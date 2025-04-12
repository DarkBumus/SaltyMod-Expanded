package darkbum.saltymod.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotCookingPotBowl extends Slot {

    private final EntityPlayer player;

    public SlotCookingPotBowl(EntityPlayer player, IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.player = player;
    }
}
