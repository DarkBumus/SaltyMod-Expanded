package darkbum.saltymod.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotResult extends Slot {

    private EntityPlayer player;
    public SlotResult(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPos, int yPos) {
        super(inventoryIn, slotIndex, xPos, yPos);
        this.player = player;
    }

    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
        super.onPickupFromSlot(playerIn, stack);
    }
}
