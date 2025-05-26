package darkbum.saltymod.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class SlotEvaporatorFuel extends Slot {

    public SlotEvaporatorFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return TileEntityFurnace.isItemFuel(stack);
    }
}
