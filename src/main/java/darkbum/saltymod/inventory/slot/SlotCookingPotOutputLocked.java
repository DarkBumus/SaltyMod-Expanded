package darkbum.saltymod.inventory.slot;

import darkbum.saltymod.tileentity.TileEntityCookingPot;
import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotCookingPotOutputLocked extends SlotOutputLockedBase {

    private final TileEntityCookingPot tileEntityCookingPot;

    public SlotCookingPotOutputLocked(
        EntityPlayer entityPlayer,
        IInventory inventory,
        int slotIndex,
        int x,
        int y,
        IInventory keyInventory,
        int keySlotIndex
    ) {
        super(entityPlayer, inventory, slotIndex, x, y, keyInventory, keySlotIndex);

        this.tileEntityCookingPot = (TileEntityCookingPot) keyInventory;
    }

    @Override
    public int getSlotStackLimit() {
        return 16;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        ItemStack outputStack = getStack();

        if (outputStack == null) {
            return false;
        }

        // Bucket recipes do not require a bowl.
        if (tileEntityCookingPot.isOutputBucketRecipe()) {
            return true;
        }

        // Regular recipes still require a valid bowl.
        ItemStack key = keyInventory.getStackInSlot(keySlotIndex);

        if (!MachineUtilRegistry.isValidBowl(key)) {
            return false;
        }

        return key.stackSize >= outputStack.stackSize;
    }

    @Override
    public void onConsumeKeys(int amountTaken) {

        // Bucket recipes never consume bowls.
        if (tileEntityCookingPot.isOutputBucketRecipe()) {
            return;
        }

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
