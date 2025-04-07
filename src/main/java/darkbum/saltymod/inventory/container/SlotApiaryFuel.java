package darkbum.saltymod.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.item.ItemBee;

public class SlotApiaryFuel extends Slot {

    private EntityPlayer entityPlayer;

    public SlotApiaryFuel(EntityPlayer entityPlayer, IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
        setEntityPlayer(entityPlayer);
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

    public void setEntityPlayer(EntityPlayer entityPlayer) {
        this.entityPlayer = entityPlayer;
    }
}
