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

public class TileEntityCookingPot extends TileEntity implements ISidedInventory {

    private String inventoryName;

    private ItemStack[] inventory = new ItemStack[9];

    public int cookingTime = 0;

    public boolean isHeaterBelow = false;

    private static final int[] slotsIngred = new int[]{0, 1, 2, 3, 4, 5};
    public static final int[] slotOutput = new int[]{6};
    private static final int[] slotPinch = new int[]{7};
    private static final int[] slotBowl = new int[]{8};

    public String getInventoryName() {
        return hasCustomInventoryName() ? this.inventoryName : "container.cooking_pot";
    }

    public boolean hasCustomInventoryName() {
        return (this.inventoryName != null && !this.inventoryName.isEmpty());
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (inventory[index] != null) {
            ItemStack itemstack;
            if (inventory[index].stackSize <= count) {
                itemstack = inventory[index];
                inventory[index] = null;
            } else {
                itemstack = inventory[index].splitStack(count);
                if (inventory[index].stackSize == 0)
                    inventory[index] = null;
            }
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory[index] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (inventory[index] != null) {
            ItemStack stack = inventory[index];
            inventory[index] = null;
            return stack;
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScale(int scale) {
        return cookingTime * scale / 200;
    }

    public boolean isRunning() {
        return cookingTime > 0;
    }

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
                cookingTime = 0;
            }

            if (updated || cookingTime > 0) {
                markDirty();
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

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

    private boolean isHeaterRequirementMet(PotcookingRecipe.PotRecipe recipe) {
        return recipe.requiresHeater() == isHeaterBelow;
    }

    private boolean canAcceptOutput(ItemStack currentStack, ItemStack output) {
        if (output == null) return true;
        if (currentStack == null) return true;

        if (!currentStack.isItemEqual(output)) return false;
        return currentStack.stackSize + output.stackSize <= currentStack.getMaxStackSize();
    }

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

        // Update inventory after cooking
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

        // Use the XP chance to determine if XP should be spawned
        if (recipe.shouldSpawnXp() && worldObj != null && !worldObj.isRemote) {
            spawnXp(worldObj, xCoord, yCoord, zCoord, recipe.xpChance()); // Use the chance to spawn XP
        }
    }

    private void checkForHeater() {
        Block blockBelow = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
        isHeaterBelow = MachineUtilRegistry.isValidHeater(blockBelow);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        NBTTagList itemList = tag.getTagList("Items", 10);
        inventory = new ItemStack[getSizeInventory()];

        for (int i = 0; i < itemList.tagCount(); i++) {
            NBTTagCompound itemTag = itemList.getCompoundTagAt(i);
            int slot = itemTag.getByte("Slot") & 255;
            if (slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }

        cookingTime = tag.getShort("CookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setShort("CookTime", (short) cookingTime);
        NBTTagList itemList = new NBTTagList();

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) i);
                inventory[i].writeToNBT(itemTag);
                itemList.appendTag(itemTag);
            }
        }
        tag.setTag("Items", itemList);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[0];
    }


    public boolean canInsertItem(int index, ItemStack itemstack, int side) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack itemstack, int side) {
        return false;
    }
}
