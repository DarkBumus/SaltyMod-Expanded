package darkbum.saltymod.inventory.container;

import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotCookingPotOutputLocked extends SlotOutputLockedBase {

    public SlotCookingPotOutputLocked(EntityPlayer entityPlayer, IInventory inventory, int slotIndex, int x, int y, IInventory keyInventory, int keySlotIndex) {
        super(entityPlayer, inventory, slotIndex, x, y, keyInventory, keySlotIndex);
    }

    @Override
    public int getSlotStackLimit() {
        return 16;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        ItemStack key = keyInventory.getStackInSlot(keySlotIndex);
        ItemStack outputStack = getStack();

        if (!MachineUtilRegistry.isValidBowl(key)) {
            return false;
        }

        return outputStack != null && key.stackSize >= outputStack.stackSize;
    }

    @Override
    protected void onConsumeKeys(int amountTaken) {
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
}
