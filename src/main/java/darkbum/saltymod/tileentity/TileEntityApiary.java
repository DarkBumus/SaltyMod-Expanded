package darkbum.saltymod.tileentity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.item.ItemBee;
import darkbum.saltymod.api.MachineUtilRegistry;

public class TileEntityApiary extends TileEntity implements IInventory {

    private String inventoryName;

    private ItemStack[] inventory = new ItemStack[19];

    private static final int[] slotsOutput = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final int[] slotBee = new int[] {18};

    public int runTime = 0;

    public int currentFuelRunTime = 0;

    public int produceTime = 0;

    private boolean larvaProducedForBee = false;

    public String getInventoryName() {
        return hasCustomInventoryName() ? this.inventoryName : "container.apiary";
    }

    public boolean hasCustomInventoryName() {
        return (this.inventoryName != null && !this.inventoryName.isEmpty());
    }

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
        if ((this.inventory[slot]).stackSize <= 0) setInventorySlotContents(slot, null);
        markDirty();
        return stack;
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) stack.stackSize = getInventoryStackLimit();
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
        this.currentFuelRunTime = getRunTime(this.inventory[1]);
        this.larvaProducedForBee = nbt.getBoolean("LarvaProducedForBee");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("LarvaProducedForBee", this.larvaProducedForBee);
        NBTTagList intTag = new NBTTagList();
        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] != null) {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.inventory[i].writeToNBT(stackTag);
                intTag.appendTag(stackTag);
            }
        }
        nbt.setTag("Items", intTag);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    private int getEffectiveTickChance(int baseChance) {
        float modifier = 1.0f;

        int radius = 3;
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    Block block = this.worldObj.getBlock(this.xCoord + dx, this.yCoord + dy, this.zCoord + dz);
                    if (block != null && block.getUnlocalizedName().toLowerCase().contains("flower")) {
                        modifier *= 0.95f; // jede Blume reduziert Chance etwas
                    }
                }
            }
        }
/*        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    TileEntity tile = this.worldObj.getTileEntity(this.xCoord + dx, this.yCoord + dy, this.zCoord + dz);
                    if (tile != null && tile != this && tile.getClass() == this.getClass()) {
                        modifier *= 0.9f;
                    }
                }
            }
        }*/
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    Block block = this.worldObj.getBlock(this.xCoord + dx, this.yCoord + dy, this.zCoord + dz);
                    if (block != null && block.getUnlocalizedName().toLowerCase().contains("hopper")) {
                        modifier *= 1.15f;
                    }
                }
            }
        }

        return Math.round(baseChance * modifier);
    }

    public void updateEntity() {
        boolean needsUpdate = false;

        if (!this.worldObj.isRemote) {
            if (canRun()) {
                final int BASE_CHANCE = ModConfigurationBlocks.apiarySpeed;
                int effectiveChance = getEffectiveTickChance(BASE_CHANCE);
                if (this.worldObj.rand.nextInt(effectiveChance) == 0) {
                    run();
                    needsUpdate = true;
                }
            }
        }

        if (needsUpdate) {
            markDirty();
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
    }

    private boolean canRun() {
        if (this.inventory[18] == null) {
            return false;
        }
        if (!(this.inventory[18].getItem() instanceof ItemBee) ||
            this.inventory[18].getItemDamage() == this.inventory[18].getMaxDamage()) {
            return false;
        }
        if (this.worldObj.isRaining() &&
            this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord)) {
            return false;
        }

        return true;
    }

    public ItemStack getProduce() {
        Random rnd = new Random();
        if (this.inventory[18] != null) {
            ItemStack beeItem = this.inventory[18];
            if (beeItem.getItemDamage() == 17 && !containsItem(ModItems.bee_larva)) {
                return new ItemStack(ModItems.bee_larva);
            }

            MachineUtilRegistry.BeeType beeType = MachineUtilRegistry.BeeType.getByBeeItem(beeItem);
            if (beeType != null) {
                return beeType.getProduce(rnd);
            }
        }
        return null;
    }

    private boolean containsItem(Item item) {
        for (int i = 0; i < 18; i++) {
            if (this.inventory[i] != null && this.inventory[i].getItem() == item) {
                return true;
            }
        }
        return false;
    }

    public void run() {
        List<Integer> slotOrder = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            if (this.inventory[i] == null) {
                slotOrder.add(i);
            }
        }

        if (slotOrder.isEmpty()) {
            return;
        }

        Collections.shuffle(slotOrder);

        this.inventory[18].attemptDamageItem(1, null);
        ItemStack itemProduced = getProduce();

        if (itemProduced != null) {
            this.inventory[slotOrder.get(0)] = itemProduced.copy();
        }
    }

    int getRunTime(ItemStack stack) {
        if (stack == null) return 0;
        if (stack.getItem() instanceof ItemBee) return 3200;
        return 0;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) return false;
        return (player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D);
    }

    public int getComparatorInputOverride() {
        int filled = 0;
        for (int i = 0; i < 18; i++) {
            if (this.inventory[i] != null) {
                filled++;
            }
        }
        return Math.round((filled / 18.0f) * 15);
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        return null;
    }

    public boolean isItemValidForSlot(int slot, ItemStack stack) {
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
