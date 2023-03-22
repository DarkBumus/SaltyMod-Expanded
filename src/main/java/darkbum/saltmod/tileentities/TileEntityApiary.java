package darkbum.saltmod.tileentities;

import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class TileEntityApiary extends TileEntity implements IInventory {

    public int runTime = 0;

    public int currentBeeRunTime = 0;

    public int produceTime = 0;

    private ItemStack[] inventory = new ItemStack[19];

    @Override
    public int getSizeInventory() {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIn) {
        return this.inventory[slotIn];
    }

    @Override
    public ItemStack decrStackSize(int slotIn, int count) {
        if (this.inventory[slotIn] == null) {
            setInventorySlotContents(slotIn, null);
            return null;
        }
        if ((this.inventory[slotIn]).stackSize <= count) {
            ItemStack itemStack = this.inventory[slotIn];
            setInventorySlotContents(slotIn, null);
            return itemStack;
        }
        ItemStack stack = this.inventory[slotIn].splitStack(count);
        if ((this.inventory[slotIn]).stackSize <= 0)
            setInventorySlotContents(slotIn, null);
        markDirty();
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slotIn, ItemStack stack) {
        this.inventory[slotIn] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit())
            stack.stackSize = getInventoryStackLimit();
    }

    @Override
    public String getInventoryName() {
        return "Apiary";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this)
            return false;
        return (player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D);
    }

    @Override
    public void openInventory() {
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return (Packet)new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
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
        this.currentBeeRunTime = getRunTime(this.inventory[1]);
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

    public int getRunTime() {
        int radius = 2;
        int speed = 3500;
        World world = this.worldObj;
        int varX = this.xCoord;
        int varY = this.yCoord;
        int varZ = this.zCoord;
        for (int offsetX = -radius; offsetX <= radius; offsetX++) {
            for (int offsetZ = -radius; offsetZ <= radius; offsetZ++) {
                if (offsetX * offsetX + offsetZ * offsetZ <= radius * radius && (offsetX != -(radius - 1) || offsetZ != -(radius - 1)) && (offsetX != radius - 1 || offsetZ != radius - 1) && (offsetX != radius - 1 || offsetZ != -(radius - 1)) && (offsetX != -(radius - 1) || offsetZ != radius - 1)) {
                    Block blockAtCoords = world.getBlock(varX + offsetX, varY, varZ + offsetZ);
                    if (blockAtCoords instanceof net.minecraft.block.BlockFlower)
                        speed = (int)(speed * 0.95D);
                    if (world.getBlock(varX + offsetX, varY, varZ + offsetZ) == ModBlocks.apiary)
                        speed = (int)(speed / 0.85D);
                }
            }
        }
        return speed;
    }

    public void updateEntity() {
        boolean isRunning = (this.runTime > 0);
        boolean needsUpdate = false;
        if (isRunning)
            this.runTime--;
        ItemStack queenBee = this.inventory[18];
        if (!this.worldObj.isRemote) {
            if (this.runTime == 0 && canRun()) {
                this.currentBeeRunTime = this.runTime = getRunTime();
                if (this.runTime > 0) {
                    needsUpdate = true;
                    if (queenBee != null) {
                        if (queenBee.getItem().getContainerItem() != null) {
                            queenBee = new ItemStack(queenBee.getItem().setFull3D());
                        } else {
                            queenBee.stackSize -= 0;
                        }
                        if (queenBee.stackSize == 0)
                            queenBee = null;
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
        if (this.inventory[18] != null)
            return (this.inventory[18].getItem() == ModItems.carpenter_bee && this.inventory[18]
                .getItemDamage() != this.inventory[18].getMaxDamage());
        return false;
    }

    public ItemStack getComb() {
        Random rnd = new Random();
        int rndnum = rnd.nextInt(100);
        if (this.inventory[18] != null) {
            if (this.inventory[18].getItem() == ModItems.carpenter_bee && this.inventory[18].getItemDamage() == 17)
                return new ItemStack(ModItems.bee_grub);
            if (rndnum < 50)
                return new ItemStack(ModItems.waxcomb);
            if (rndnum >= 50 && rndnum < 95)
                return new ItemStack(ModItems.honeycomb);
            return new ItemStack(ModItems.bee_grub);
        }
        return null;
    }

    public void run() {
        this.inventory[18].attemptDamageItem(1, null);
        ItemStack itemProduced = getComb();
        for (int i = 0; i < 18; ) {
            if (this.inventory[i] != null) {
                i++;
                continue;
            }
            this.inventory[i] = itemProduced.copy();
        }
    }

    int getRunTime(ItemStack stack) {
        if (stack == null)
            return 0;
        if (stack.getItem() == ModItems.carpenter_bee)
            return 3200;
        return 0;
    }
}
