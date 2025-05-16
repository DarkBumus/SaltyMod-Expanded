package darkbum.saltymod.inventory.container;

import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotCookingPotPinch extends Slot {

    public SlotCookingPotPinch(IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return MachineUtilRegistry.isValidPinch(stack);
    }

    public int getSlotStackLimit() {
        return 64;
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        super.onPickupFromSlot(entityPlayer, itemStack);
    }

}
