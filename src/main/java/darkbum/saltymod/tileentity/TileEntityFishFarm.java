package darkbum.saltymod.tileentity;

import java.util.Random;

import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityFishFarm extends TileEntity implements IInventory {
    private ItemStack[] inventory = new ItemStack[19];

    public int runTime = 0;

    public int currentFuelRunTime = 0;

    public int produceTime = 0;

    public int getSizeInventory() {
        return this.inventory.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.inventory[slot];
    }

    public ItemStack decrStackSize(int slot, int amount) {
        if (this.inventory[slot] == null) {
            setInventorySlotContents(slot, null);
            return null;
        }
        if ((this.inventory[slot]).stackSize <= amount) {
            ItemStack itemStack = this.inventory[slot];
            setInventorySlotContents(slot, null);
            return itemStack;
        }
        ItemStack stack = this.inventory[slot].splitStack(amount);
        if ((this.inventory[slot]).stackSize <= 0)
            setInventorySlotContents(slot, null);
        markDirty();
        return stack;
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit())
            stack.stackSize = getInventoryStackLimit();
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList invTag = nbt.getTagList("Items", 10);
        this.inventory = new ItemStack[getSizeInventory()];
        for (int i = 0; i < invTag.tagCount(); i++) {
            NBTTagCompound stackTag = invTag.getCompoundTagAt(i);
            byte slot = stackTag.getByte("Slot");
            if (slot >= 0 && slot < this.inventory.length)
                this.inventory[slot] = ItemStack.loadItemStackFromNBT(stackTag);
        }
        this.runTime = nbt.getShort("RunTime");
        this.produceTime = nbt.getShort("ProduceTime");
        this.currentFuelRunTime = getRunTime(this.inventory[1]);
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("RunTime", (short)this.runTime);
        nbt.setShort("ProduceTime", (short)this.produceTime);
        NBTTagList intTag = new NBTTagList();
        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] != null) {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(stackTag);
                intTag.appendTag(stackTag);
            }
        }
        nbt.setTag("Items", intTag);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public int getRunTime() {
        byte radius = 2;
        int speed = ModConfiguration.fishFarmSpeed;
        World world = this.worldObj;
        int varX = this.xCoord;
        int varY = this.yCoord;
        int varZ = this.zCoord;
        for (int offsetX = -radius; offsetX <= radius; offsetX++) {
            for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
                if (offsetX * offsetX + offsetZ * offsetZ <= radius * radius && (offsetX != -(radius - 1) || offsetZ != -(radius - 1)) && (offsetX != radius - 1 || offsetZ != radius - 1) && (offsetX != radius - 1 || offsetZ != -(radius - 1)) && (offsetX != -(radius - 1) || offsetZ != radius - 1)) {
                    Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
                    if (blockAtCoords instanceof net.minecraft.block.BlockLiquid)
                        speed = (int)(speed * 0.95D);
                    if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == ModBlocks.fish_farm)
                        speed = (int)(speed / 0.85D);
                }
            }
        }
        return speed;
    }

    public int currentSurroundings() {
        byte radius = 2;
        int count = 0;
        World world = this.worldObj;
        int varX = this.xCoord;
        int varY = this.yCoord;
        int varZ = this.zCoord;
        for (int offsetX = -radius; offsetX <= radius; offsetX++) {
            for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
                if (offsetX * offsetX + offsetZ * offsetZ <= radius * radius && (offsetX != -(radius - 1) || offsetZ != -(radius - 1)) && (offsetX != radius - 1 || offsetZ != radius - 1) && (offsetX != radius - 1 || offsetZ != -(radius - 1)) && (offsetX != -(radius - 1) || offsetZ != radius - 1)) {
                    Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
                    if (blockAtCoords instanceof net.minecraft.block.BlockLiquid)
                        count++;
                }
            }
        }
        return count;
    }

    public void updateEntity() {
        boolean isRunning = (this.runTime > 0);
        boolean needsUpdate = false;
        if (isRunning)
            this.runTime--;
        ItemStack farmFuel = this.inventory[18];
        if (!this.worldObj.isRemote) {
            if (this.runTime == 0 && canRun()) {
                this
                    .currentFuelRunTime = this.runTime = getRunTime(farmFuel);
                if (this.runTime > 0) {
                    needsUpdate = true;
                    if (farmFuel != null) {
                        if (farmFuel.getItem().getContainerItem() != null) {
                            farmFuel = new ItemStack(farmFuel.getItem().setFull3D());
                        } else {
                            farmFuel.stackSize -= 0;
                        }
                        if (farmFuel.stackSize == 0)
                            farmFuel = null;
                    }
                }
            }
            if (canRun()) {
                this.produceTime++;
                if (this.produceTime >= Math.floor(getRunTime())) {
                    this.produceTime = 0;
                    run();
                    needsUpdate = true;
                }
            } else {
                this.produceTime = 0;
            }
            if (isRunning != ((this.runTime > 0)))
                needsUpdate = true;
        }
        if (needsUpdate) {
            markDirty();
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
    }

    private boolean canRun() {
        if (this.inventory[18] != null) {
            if (this.inventory[18].getItem() == ModItems.fish_bait)
                if (currentSurroundings() >= 5)
                    return true;
        } else {
            return false;
        }
        return false;
    }

    public ItemStack getProduce() {
        Random rnd = new Random();
        if (this.inventory[18] != null) {
            int i = rnd.nextInt(16);
                switch (i) {
                    case 0, 1, 2, 3, 4:
                        return new ItemStack(Items.fish, 1, 0);
                    case 5, 6, 7:
                        return new ItemStack(Items.fish, 1, 1);
                    case 8, 9:
                        return new ItemStack(Items.fish, 1, 2);
                    case 10:
                        return new ItemStack(Items.fish, 1, 3);
                    case 11, 12, 13:
                        return new ItemStack(ModItems.tailor, 1, 0);
                    case 14, 15:
                        return new ItemStack(ModItems.calamari, 1, 0);
                }
            }
        return null;
    }

    public void run() {
        ItemStack itemProduced = getProduce();
        for (int i = 0; i < 18; i++) {
            if (this.inventory[i] == null) {
                decrStackSize(18, 1);
                this.inventory[i] = itemProduced.copy();
                break;
            }
        }
    }

    int getRunTime(ItemStack stack) {
        if (stack == null)
            return 0;
        if (stack.getItem() == ModItems.fish_bait)
            return 3200;
        return 0;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this)
            return false;
        return
            (player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D);
    }

    public void openChest() {}

    public void closeChest() {}

    public ItemStack getStackInSlotOnClosing(int slot) {
        return null;
    }

    public boolean isInvNameLocalized() {
        return false;
    }

    public boolean isStackValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    public String getInventoryName() {
        return null;
    }

    public boolean hasCustomInventoryName() {
        return false;
    }

    public void openInventory() {}

    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    public void closeInventory() {}
}
