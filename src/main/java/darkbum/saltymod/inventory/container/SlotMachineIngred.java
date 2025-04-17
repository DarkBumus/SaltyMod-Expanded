package darkbum.saltymod.inventory.container;

import darkbum.saltymod.api.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachineIngred extends Slot {

    private final EntityPlayer player;

    public SlotMachineIngred(EntityPlayer player, IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.player = player;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return !MachineUtilRegistry.isValidPinch(stack) && !MachineUtilRegistry.isValidSpade(stack);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
        super.onPickupFromSlot(player, itemStack);
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }
}
