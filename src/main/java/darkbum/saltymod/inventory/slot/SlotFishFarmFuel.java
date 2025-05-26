package darkbum.saltymod.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.init.ModItems;

public class SlotFishFarmFuel extends Slot {

    public SlotFishFarmFuel(IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
    }

    public boolean isItemValid(ItemStack itemStack) {
        return (itemStack.getItem() == ModItems.fish_bait);
    }

    public int getSlotStackLimit() {
        return 64;
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        super.onPickupFromSlot(entityPlayer, itemStack);
    }
}
