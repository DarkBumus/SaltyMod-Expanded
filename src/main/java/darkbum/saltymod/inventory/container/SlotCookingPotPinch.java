package darkbum.saltymod.inventory.container;

import darkbum.saltymod.api.PotcookingRecipePinchRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotCookingPotPinch extends Slot {

    private EntityPlayer entityPlayer;

    public SlotCookingPotPinch(EntityPlayer entityPlayer, IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
        setEntityPlayer(entityPlayer);
    }

    public boolean isItemValid(ItemStack itemStack) {
        return PotcookingRecipePinchRegistry.isValidPinch(itemStack);
    }

    public int getSlotStackLimit() {
        return 64;
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        super.onPickupFromSlot(entityPlayer, itemStack);
    }

    public void setEntityPlayer(EntityPlayer entityPlayer) {
        this.entityPlayer = entityPlayer;
    }
}
