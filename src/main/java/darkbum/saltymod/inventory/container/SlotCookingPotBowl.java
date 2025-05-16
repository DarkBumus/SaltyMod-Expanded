package darkbum.saltymod.inventory.container;

import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCookingPotBowl extends Slot {

    public boolean isItemValid(ItemStack stack) {
        return MachineUtilRegistry.isValidBowl(stack);
    }

    public SlotCookingPotBowl(IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
        super.onPickupFromSlot(player, itemStack);
    }
}
