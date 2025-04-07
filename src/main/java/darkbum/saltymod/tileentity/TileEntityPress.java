package darkbum.saltymod.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import darkbum.saltymod.api.PressingRecipe;;

public class TileEntityPress extends TileEntity implements ISidedInventory {

    private String inventoryName;

    private ItemStack[] inventory = new ItemStack[4];

    public int pressingTime = 0;

    private boolean isHeaterNearby = false;

    private static final int[] slotsTop = new int[] { 0 };
    private static final int[] slotsBottom = new int[] { 1, 2 };
    private static final int[] slotsFuel = new int[] { 3 };

    public String getInventoryName() {
        return hasCustomInventoryName() ? this.inventoryName : "container.press";
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
            if (inventory[index].stackSize <= count) {
                ItemStack itemstack = inventory[index];
                inventory[index] = null;
                return itemstack;
            } else {
                ItemStack itemstack = inventory[index].splitStack(count);
                if (inventory[index].stackSize == 0)
                    inventory[index] = null;
                return itemstack;
            }
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
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 0) {
            return stack.getItem() == ModItems.honeycomb
                || stack.getItem() == ModItems.frozen_honey
                || stack.getItem() == ModItems.mineral_mud_ball;
        } else if (index == 3) {
            return stack.getItem() == Items.glass_bottle;
        }
        return false;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        if (side == 0) {
            return slotsBottom;
        }
        else if (side == 1) {
            return slotsTop;
        }
        else return slotsFuel;
    }


    public boolean canInsertItem(int index, ItemStack itemstack, int side)
    {
        return this.isItemValidForSlot(index, itemstack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack itemstack, int side) {
        return index != 0;
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
    public int getCookProgressScaled(int scale) {
        return pressingTime * scale / 125;
    }

    public boolean isRunning() {
        return pressingTime > 0;
    }

    @Override
    public void updateEntity() {
        boolean updated = false;
        checkForHeater();

        if (!worldObj.isRemote) {
            if (canRun()) {
                pressingTime++;
                if (pressingTime >= 125) {
                    pressingTime = 0;
                    pressItems();
                    updated = true;
                }
            } else {
                pressingTime = 0;
            }

            if (updated || pressingTime > 0) {
                markDirty();
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    private boolean canRun() {
        ItemStack input = inventory[0];
        if (input == null) return false;

        PressingRecipe.PressRecipe recipe = PressingRecipe.pressing().getRecipeFor(input);
        if (recipe == null) return false;

        // Prüfen, ob Heizbedingung erfüllt ist
        if (recipe.requiresHeater) {
            if (!isHeaterNearby) return false; // Wenn der Heizer erforderlich ist, aber nicht vorhanden, abbrechen
        } else {
            if (isHeaterNearby) return false; // Wenn der Heizer nicht erforderlich ist, aber vorhanden, abbrechen
        }

        // Prüfen, ob Fuel-Bedingung erfüllt ist
        if (recipe.requiresFuel) {
            if (inventory[3] == null || inventory[3].getItem() != Items.glass_bottle) return false;
        }

        // Prüfen, ob Output1 passt
        if (recipe.output1 != null) {
            ItemStack output1 = inventory[1];
            if (output1 != null) {
                if (!output1.isItemEqual(recipe.output1)) return false;
                if (output1.stackSize + recipe.output1.stackSize > output1.getMaxStackSize()) return false;
            }
        }

        // Prüfen, ob Output2 passt
        if (recipe.output2 != null) {
            ItemStack output2 = inventory[2];
            if (output2 != null) {
                if (!output2.isItemEqual(recipe.output2)) return false;
                if (output2.stackSize + recipe.output2.stackSize > output2.getMaxStackSize()) return false;
            }
        }

        return true;
    }

    public void pressItems() {
        if (!canRun()) return;

        ItemStack input = inventory[0];
        PressingRecipe.PressRecipe recipe = PressingRecipe.pressing().getRecipeFor(input);
        if (recipe == null) return; // Sollte nicht passieren, aber zur Sicherheit

        // Output 1 verarbeiten
        if (recipe.output1 != null) {
            if (inventory[1] == null) {
                inventory[1] = recipe.output1.copy();
            } else {
                inventory[1].stackSize += recipe.output1.stackSize;
            }
        }

        // Output 2 verarbeiten
        if (recipe.output2 != null) {
            if (inventory[2] == null) {
                inventory[2] = recipe.output2.copy();
            } else {
                inventory[2].stackSize += recipe.output2.stackSize;
            }
        }

        // Input verbrauchen
        inventory[0].stackSize--;
        if (inventory[0].stackSize <= 0) inventory[0] = null;

        // Fuel verbrauchen, falls notwendig
        if (recipe.requiresFuel && inventory[3] != null && inventory[3].getItem() == Items.glass_bottle) {
            inventory[3].stackSize--;
            if (inventory[3].stackSize <= 0) {
                inventory[3] = null;
            }
        }
    }

    private void checkForHeater() {
        isHeaterNearby = false;

        int[][] directions = {
            {0, 1, 0},
            {0, -1, 0},
            {1, 0, 0},
            {-1, 0, 0},
            {0, 0, 1},
            {0, 0, -1}
        };

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            int dz = dir[2];

            Block neighborBlock = worldObj.getBlock(xCoord + dx, yCoord + dy, zCoord + dz);
            if (neighborBlock != null && neighborBlock == ModBlocks.heater) {
                isHeaterNearby = true;
                return;
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        NBTTagList itemList = tag.getTagList("Items", 10);
        inventory = new ItemStack[getSizeInventory()];

        for (int i = 0; i < itemList.tagCount(); i++) {
            NBTTagCompound itemTag = itemList.getCompoundTagAt(i);
            int slot = itemTag.getByte("Slot") & 255;
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }

        pressingTime = tag.getShort("CookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setShort("CookTime", (short) pressingTime);
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
}

