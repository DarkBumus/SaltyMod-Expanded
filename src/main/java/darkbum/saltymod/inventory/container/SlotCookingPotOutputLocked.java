package darkbum.saltymod.inventory.container;

import darkbum.saltymod.api.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCookingPotOutputLocked extends Slot {

    private EntityPlayer entityPlayer;
    private final IInventory keyInventory;
    private final int keySlotIndex;

    public SlotCookingPotOutputLocked(EntityPlayer entityPlayer, IInventory inventory, int slotIndex, int x, int y, IInventory keyInventory, int keySlotIndex) {
        super(inventory, slotIndex, x, y);
        this.entityPlayer = entityPlayer;
        this.keyInventory = keyInventory;
        this.keySlotIndex = keySlotIndex;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    @Override
    public int getSlotStackLimit() {
        return 16;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        ItemStack key = keyInventory.getStackInSlot(keySlotIndex);
        ItemStack outputStack = getStack();

        // Kein gültiger Schlüssel -> blockiert
        if (!MachineUtilRegistry.isValidBowl(key)) {
            return false;
        }

        // Wenn zu wenig Bowls im Slot sind -> blockiert
        if (key == null || outputStack == null || key.stackSize < outputStack.stackSize) {
            return false;
        }

        return true;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        int amountTaken = stack != null ? stack.stackSize : 0;

        // Reduziere den Slot-Stack wie bisher
        if (getHasStack()) {
            ItemStack slotStack = getStack();

            if (slotStack.stackSize > amountTaken) {
                slotStack.stackSize -= amountTaken;
                putStack(slotStack);
            } else {
                putStack(null);
            }
        }

        // Reduziere Key-Items (z.B. Bowls)
        if (amountTaken > 0) {
            ItemStack keyStack = keyInventory.getStackInSlot(keySlotIndex);
            if (keyStack != null && keyStack.stackSize > 0) {
                int consume = Math.min(amountTaken, keyStack.stackSize);
                keyStack.stackSize -= consume;

                if (keyStack.stackSize <= 0) {
                    keyInventory.setInventorySlotContents(keySlotIndex, null);
                } else {
                    keyInventory.setInventorySlotContents(keySlotIndex, keyStack);
                }
                keyInventory.markDirty();
            }
        }

        super.onPickupFromSlot(player, stack);
    }

    public void consumeKeys(int amount) {
        if (amount <= 0) return;

        ItemStack keyStack = keyInventory.getStackInSlot(keySlotIndex);
        if (keyStack != null && keyStack.stackSize > 0) {
            int consume = Math.min(amount, keyStack.stackSize);
            keyStack.stackSize -= consume;

            if (keyStack.stackSize <= 0) {
                keyInventory.setInventorySlotContents(keySlotIndex, null);
            } else {
                keyInventory.setInventorySlotContents(keySlotIndex, keyStack);
            }
            keyInventory.markDirty();
        }
    }
}
