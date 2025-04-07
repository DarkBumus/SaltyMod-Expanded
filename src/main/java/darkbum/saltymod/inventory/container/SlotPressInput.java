package darkbum.saltymod.inventory.container;

import darkbum.saltymod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotPressInput extends Slot {

    private final EntityPlayer player;

    public SlotPressInput(EntityPlayer player, IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.player = player;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return isValidItem(itemStack);
    }

    private boolean isValidItem(ItemStack itemStack) {
        return itemStack.getItem() == ModItems.honeycomb
            || itemStack.getItem() == ModItems.frozen_honey
            || itemStack.getItem() == ModItems.mineral_mud_ball;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
        super.onPickupFromSlot(player, itemStack);
    }
    public EntityPlayer getPlayer() {
        return this.player;
    }
}
