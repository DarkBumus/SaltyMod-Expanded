package darkbum.saltymod.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.util.PotcookingRecipe;
import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

import static darkbum.saltymod.util.MachineUtilRegistry.spawnXp;

/**
 * Tile Entity class for the cooking pot block.
 * The cooking pot is a tile entity container block that produces items in a cooking context.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class TileEntityCookingPot extends TileEntity implements ISidedInventory {

    @SuppressWarnings("unused")
    private String inventoryName;

    private ItemStack[] inventory = new ItemStack[9];

    public int cookingTime = 0;

    public boolean isHeaterBelow = false;

    public static final int[] slotOutput = new int[]{6};

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
        return hasCustomInventoryName() ? this.inventoryName : "container.cooking_pot";
    }

    /**
     * Gets the size of the inventory.
     *
     * @return the number of inventory slots.
     */
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    /**
     * Gets the item stack in the specified slot.
     *
     * @param slot The slot index.
     * @return the ItemStack in the slot, or null if empty.
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
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
        if (inventory[slot] != null) {
            ItemStack itemstack;
            if (inventory[slot].stackSize <= amount) {
                itemstack = inventory[slot];
                inventory[slot] = null;
            } else {
                itemstack = inventory[slot].splitStack(amount);
                if (inventory[slot].stackSize == 0)
                    inventory[slot] = null;
            }
            return itemstack;
        }
        return null;
    }

    /**
     * Sets the ItemStack in the specified slot.
     *
     * @param slot  The slot index.
     * @param stack The ItemStack to set.
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    /**
     * Reads the inventory and other data from NBT.
     *
     * @param nbt The NBTTagCompound to read from.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList itemList = nbt.getTagList("Items", 10);
        inventory = new ItemStack[getSizeInventory()];

        for (int i = 0; i < itemList.tagCount(); i++) {
            NBTTagCompound itemTag = itemList.getCompoundTagAt(i);
            int slot = itemTag.getByte("Slot") & 255;
            if (slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }

        cookingTime = nbt.getShort("CookTime");
    }

    /**
     * Writes the inventory and other data to NBT.
     *
     * @param nbt The NBTTagCompound to write to.
     */
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("CookTime", (short) cookingTime);
        NBTTagList itemList = new NBTTagList();

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) i);
                inventory[i].writeToNBT(itemTag);
                itemList.appendTag(itemTag);
            }
        }
        nbt.setTag("Items", itemList);
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
        boolean updated = false;
        checkForHeater();

        if (!worldObj.isRemote) {
            if (canRun()) {
                cookingTime++;
                if (cookingTime >= 200) {
                    cookingTime = 0;
                    cookItems();
                    updated = true;
                }
            } else {
                if (cookingTime != 0) {
                    cookingTime = 0;
                    updated = true;
                }
            }

            if (updated || cookingTime > 0) {
                markDirty();
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    /**
     * Checks if the specified player can access this inventory.
     *
     * @param player The player entity.
     * @return true, if the player is within access range, false otherwise.
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }

    /**
     * Called when a slot is closed. This method does nothing in this implementation.
     *
     * @param slot The slot index.
     * @return null.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (inventory[slot] != null) {
            ItemStack stack = inventory[slot];
            inventory[slot] = null;
            return stack;
        }
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
    public void openInventory() {
    }

    /**
     * Creates a packet to synchronize data with the client.
     *
     * @return the description packet containing the tile entity data.
     */
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
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
    public void closeInventory() {
    }

    /**
     * Gets the cook progress as a scaled value.
     *
     * @param scale The desired scale.
     * @return the scaled cook progress.
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScale(int scale) {
        return cookingTime * scale / 200;
    }

    /**
     * Checks whether the oven is currently running.
     *
     * @return true, if cooking is in progress, false otherwise.
     */
    public boolean isRunning() {
        return cookingTime > 0;
    }

    /**
     * Checks whether the oven can run based on input items and heater status.
     *
     * @return true, if cooking can proceed, false otherwise.
     */
    private boolean canRun() {
        List<ItemStack> ingreds = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (inventory[i] != null) {
                ingreds.add(inventory[i]);
            }
        }

        if (inventory[7] != null) {
            ingreds.add(inventory[7]);
        }

        if (ingreds.isEmpty()) return false;

        PotcookingRecipe.PotRecipe recipe = PotcookingRecipe.cooking().getRecipeFor(ingreds);
        if (recipe == null) return false;

        return isHeaterRequirementMet(recipe) && canAcceptOutput(inventory[6], recipe.output());
    }

    /**
     * Checks if the heater requirement for the recipe is met.
     *
     * @param recipe The oven recipe.
     * @return true, if the heater requirement is satisfied, false otherwise.
     */
    private boolean isHeaterRequirementMet(PotcookingRecipe.PotRecipe recipe) {
        return recipe.requiresHeater() == isHeaterBelow;
    }

    /**
     * Checks if the output slot can accept the produced item.
     *
     * @param currentStack The current stack in the output slot.
     * @param output       The output stack to be added.
     * @return true, if the output can be added, false otherwise.
     */
    private boolean canAcceptOutput(ItemStack currentStack, ItemStack output) {
        if (output == null) return true;
        if (currentStack == null) return true;

        if (!currentStack.isItemEqual(output)) return false;
        return currentStack.stackSize + output.stackSize <= currentStack.getMaxStackSize();
    }

    /**
     * Processes the current ingredients in the input slots and produces the corresponding output based on the cooking recipe.
     * <p>
     * This method checks the first four inventory slots for valid ingredients and attempts to create a recipe output
     * in the output slot (index 4). If the output slot is empty, the result is placed directly. Otherwise, the result
     * is added to the existing stack.
     * <p>
     * After producing the output, the ingredient stacks are decreased by one. Additionally, if the recipe is configured
     * to spawn experience, 1 XP orb is spawned at the TileEntity's coordinates.
     */
    public void cookItems() {
        List<ItemStack> ingreds = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (inventory[i] != null) {
                ingreds.add(inventory[i]);
            }
        }

        if (inventory[7] != null) {
            ingreds.add(inventory[7]);
        }

        PotcookingRecipe.PotRecipe recipe = PotcookingRecipe.cooking().getRecipeFor(ingreds);
        if (recipe == null) return;

        if (recipe.output() != null) {
            if (inventory[6] == null) {
                inventory[6] = recipe.output().copy();
            } else {
                inventory[6].stackSize += recipe.output().stackSize;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (inventory[i] != null) {
                inventory[i].stackSize--;
                if (inventory[i].stackSize <= 0) {
                    inventory[i] = null;
                }
            }
        }

        if (inventory[7] != null) {
            inventory[7].stackSize--;
            if (inventory[7].stackSize <= 0) {
                inventory[7] = null;
            }
        }

        if (recipe.shouldSpawnXp() && worldObj != null && !worldObj.isRemote) {
            spawnXp(worldObj, xCoord, yCoord, zCoord, recipe.xpChance());
        }
    }

    /**
     * Checks if the block below the TileEntity is a valid heat source for the oven.
     * <p>
     * The heater status is determined by querying the {@link MachineUtilRegistry}.
     */
    private void checkForHeater() {
        Block blockBelow = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
        isHeaterBelow = MachineUtilRegistry.isValidHeater(blockBelow);
    }

    /**
     * Returns the slots that can be accessed from a specific side.
     * <p>
     * Currently, this method returns an empty array, indicating that no slots are accessible
     * through automation or external access.
     *
     * @param side The side from which the slots are being accessed.
     * @return an empty array, indicating no accessible slots.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[0];
    }

    /**
     * Determines whether an item can be inserted into a specific slot from a given side.
     *
     * @param index     The slot index.
     * @param itemstack The item stack being inserted.
     * @param side      The side from which the insertion is attempted.
     * @return false, as insertion is not permitted.
     */
    @Override
    public boolean canInsertItem(int index, ItemStack itemstack, int side) {
        return false;
    }

    /**
     * Determines whether an item can be extracted from a specific slot from a given side.
     *
     * @param index     The slot index.
     * @param itemstack The item stack being extracted.
     * @param side      The side from which the extraction is attempted.
     * @return false, as extraction is not permitted.
     */
    @Override
    public boolean canExtractItem(int index, ItemStack itemstack, int side) {
        return false;
    }
}
