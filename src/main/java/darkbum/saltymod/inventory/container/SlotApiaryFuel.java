package darkbum.saltymod.inventory.container;

import darkbum.saltymod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotApiaryFuel extends Slot {
    private EntityPlayer entityPlayer;

    public SlotApiaryFuel(EntityPlayer entityPlayer, IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
        setEntityPlayer(entityPlayer);
    }

    public boolean isItemValid(ItemStack itemStack) {
        return (itemStack.getItem() == ModItems.carpenter_bee);
    }

    public int getSlotStackLimit() {
        return 1;
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        super.onPickupFromSlot(entityPlayer, itemStack);
    }

    public void setEntityPlayer(EntityPlayer entityPlayer) {
        this.entityPlayer = entityPlayer;
    }
}
