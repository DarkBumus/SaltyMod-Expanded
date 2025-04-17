package darkbum.saltymod.inventory.container;

import darkbum.saltymod.api.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotPressVessel extends Slot {

    private EntityPlayer entityPlayer;

    public SlotPressVessel(EntityPlayer entityPlayer, IInventory iInventory, int slotIndex, int x, int y) {
        super(iInventory, slotIndex, x, y);
        setEntityPlayer(entityPlayer);
    }

    public boolean isItemValid(ItemStack itemStack) {
        return MachineUtilRegistry.isValidVessel(itemStack);
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
