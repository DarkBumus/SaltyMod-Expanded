package darkbum.saltymod.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class SlotOutputLockedBase extends Slot {

    protected final EntityPlayer entityPlayer;
    protected final IInventory keyInventory;
    protected final int keySlotIndex;

    public SlotOutputLockedBase(EntityPlayer entityPlayer, IInventory inventory, int slotIndex, int x, int y, IInventory keyInventory, int keySlotIndex) {
        super(inventory, slotIndex, x, y);
        this.entityPlayer = entityPlayer;
        this.keyInventory = keyInventory;
        this.keySlotIndex = keySlotIndex;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        if (stack != null) {
            int amountTaken = stack.stackSize;
            if (amountTaken > 0) {
                onConsumeKeys(amountTaken);
            }
        }
        super.onPickupFromSlot(player, stack);
    }

    protected abstract void onConsumeKeys(int amountTaken);
}
