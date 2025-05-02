package darkbum.saltymod.inventory.container;

import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCookingPotBowl extends Slot {

    private final EntityPlayer player;

    public boolean isItemValid(ItemStack stack) {
        return MachineUtilRegistry.isValidBowl(stack);
    }

    public SlotCookingPotBowl(EntityPlayer player, IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.player = player;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
        super.onPickupFromSlot(player, itemStack);
    }
}
