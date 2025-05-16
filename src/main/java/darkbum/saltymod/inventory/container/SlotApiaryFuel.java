package darkbum.saltymod.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.item.ItemBee;

public class SlotApiaryFuel extends Slot {

    public SlotApiaryFuel(IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
    }

    public boolean isItemValid(ItemStack itemStack) {
        return (itemStack.getItem() instanceof ItemBee);
    }

    public int getSlotStackLimit() {
        return 1;
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        super.onPickupFromSlot(entityPlayer, itemStack);
    }
}
