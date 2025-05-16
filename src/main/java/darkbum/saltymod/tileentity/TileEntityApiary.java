package darkbum.saltymod.tileentity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import darkbum.saltymod.common.config.ModConfigurationBlocks;
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
import darkbum.saltymod.util.MachineUtilRegistry;

/**
 * Tile Entity class for the apiary block.
 * The apiary is a tile entity container block that stores and produces items in a beekeeping context.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class TileEntityApiary extends TileEntity implements IInventory {

    @SuppressWarnings("unused")
    private String inventoryName;

    private ItemStack[] inventory = new ItemStack[19];

    public int runTime = 0;

    public int currentFuelRunTime = 0;

    public int produceTime = 0;

    private boolean larvaProducedForBee = false;

    /**
     * Checks if the inventory has a custom name.
     *
     * @return true if a custom name is set, false otherwise.
     */
    @Override
    public boolean hasCustomInventoryName() {
        return (this.inventoryName != null && !this.inventoryName.isEmpty());
    }

    /**
     * Returns the inventory name.
     *
     * @return the custom name if set, otherwise the default name.
     */
    @Override
    public String getInventoryName() {
        return hasCustomInventoryName() ? this.inventoryName : "container.apiary";
    }

    /**
     * Gets the size of the inventory.
     *
     * @return the number of inventory slots.
     */
    @Override
    public int getSizeInventory() {
        return this.inventory.length;
    }

    /**
     * Gets the item stack in the specified slot.
     *
     * @param slot The slot index.
     * @return the ItemStack in the slot, or null if empty.
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.inventory[slot];
    }

    /**
     * Decreases the stack size in the specified slot by the specified amount.
     *
     * @param slot   The slot index.
     * @param amount The amount to decrease.
     * @return the removed ItemStack or null if none was removed.
     */
    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (this.inventory[slot] == null) {
            setInventorySlotContents(slot, null);
            return null;
        }
        if ((this.inventory[slot]).stackSize <= amount) {
            ItemStack stack = this.inventory[slot];
            setInventorySlotContents(slot, null);
            return stack;
        }
        ItemStack stack = this.inventory[slot].splitStack(amount);
        if ((this.inventory[slot]).stackSize <= 0) setInventorySlotContents(slot, null);
        markDirty();
        return stack;
    }

    /**
     * Sets the ItemStack in the specified slot.
     *
     * @param slot  The slot index.
     * @param stack The ItemStack to set.
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) stack.stackSize = getInventoryStackLimit();
    }

    /**
     * Reads the inventory and other data from NBT.
     *
     * @param nbt The NBTTagCompound to read from.
     */
    @Override
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

    /**
     * Writes the inventory and other data to NBT.
     *
     * @param nbt The NBTTagCompound to write to.
     */
    @Override
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

    /**
     * Gets the maximum stack size allowed in a slot.
     *
     * @return the maximum stack size (64).
     */
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Updates the entity each tick. Checks for production conditions and runs production if possible.
     */
    @Override
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

    /**
     * Calculates the effective tick chance based on nearby blocks.
     *
     * @param baseChance The base tick chance.
     * @return the adjusted tick chance.
     */
    private int getEffectiveTickChance(int baseChance) {
        float modifier = 1.0f;

        int radius = 3;
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    Block block = this.worldObj.getBlock(this.xCoord + dx, this.yCoord + dy, this.zCoord + dz);
                    if (block != null && block.getUnlocalizedName().toLowerCase().contains("flower")) {
                        modifier *= 0.95f;
                    }
                }
            }
        }
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

    /**
     * Checks whether the Apiary can run its production cycle.
     *
     * @return true, if production can proceed, false otherwise.
     */
    private boolean canRun() {
        if (this.inventory[18] == null) {
            return false;
        }
        if (!(this.inventory[18].getItem() instanceof ItemBee) ||
            this.inventory[18].getItemDamage() == this.inventory[18].getMaxDamage()) {
            return false;
        }
        return !this.worldObj.isRaining() ||
            !this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord);
    }

    /**
     * Attempts to produce an item based on the current bee type and its state.
     *
     * @return the produced ItemStack or null if nothing is produced.
     */
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

    /**
     * Checks if the inventory contains a specific item.
     *
     * @param item The item to search for.
     * @return true, if the item is found, false otherwise.
     */
    private boolean containsItem(Item item) {
        for (int i = 0; i < 18; i++) {
            if (this.inventory[i] != null && this.inventory[i].getItem() == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Executes a production cycle. A random empty slot is selected to receive the produced item.
     */
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

    /**
     * Determines the runtime duration for a given ItemStack.
     *
     * @param stack The item stack.
     * @return the runtime in ticks.
     */
    int getRunTime(ItemStack stack) {
        if (stack == null) return 0;
        if (stack.getItem() instanceof ItemBee) return 3200;
        return 0;
    }

    /**
     * Checks if the specified player can access this inventory.
     *
     * @param player The player entity.
     * @return true, if the player is within access range, false otherwise.
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) return false;
        return (player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D);
    }

    /**
     * Gets the comparator signal strength based on the number of filled slots.
     *
     * @return a value between 0 and 15 based on inventory fill level.
     */
    public int getComparatorInputOverride() {
        int filled = 0;
        for (int i = 0; i < 18; i++) {
            if (this.inventory[i] != null) {
                filled++;
            }
        }
        return Math.round((filled / 18.0f) * 15);
    }

    /**
     * Called when a slot is closed. This method does nothing in this implementation.
     *
     * @param slot The slot index.
     * @return null.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return null;
    }

    /**
     * Checks if the specified item is valid for insertion into the specified slot.
     *
     * @param slot  The slot index.
     * @param stack The item stack.
     * @return false in this implementation, as no specific slot validation logic is implemented.
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    /**
     * Called when the inventory is opened by a player.
     * This implementation does nothing.
     */
    @Override
    public void openInventory() {}

    /**
     * Creates a packet to synchronize data with the client.
     *
     * @return the description packet containing the tile entity data.
     */
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    /**
     * Handles incoming data packets to synchronize data with the server.
     *
     * @param net    The network manager.
     * @param packet The packet containing the updated data.
     */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    /**
     * Called when the inventory is closed by a player.
     * This implementation does nothing.
     */
    @Override
    public void closeInventory() {}
}
