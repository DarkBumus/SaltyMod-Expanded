package darkbum.saltymod.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotApiary extends Slot {
    private EntityPlayer entityPlayer;

    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    public SlotApiary(EntityPlayer entityPlayer, IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
        this.entityPlayer = entityPlayer;
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        super.onPickupFromSlot(entityPlayer, itemStack);
    }
}
