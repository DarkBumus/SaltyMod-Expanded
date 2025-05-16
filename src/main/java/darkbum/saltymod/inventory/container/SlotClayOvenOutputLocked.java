package darkbum.saltymod.inventory.container;

import darkbum.saltymod.util.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class SlotClayOvenOutputLocked extends SlotOutputLockedBase {

    public SlotClayOvenOutputLocked(EntityPlayer entityPlayer, IInventory inventory, int slotIndex, int x, int y, IInventory keyInventory, int keySlotIndex) {
        super(entityPlayer, inventory, slotIndex, x, y, keyInventory, keySlotIndex);
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        ItemStack key = keyInventory.getStackInSlot(keySlotIndex);
        ItemStack outputStack = getStack();

        if (!MachineUtilRegistry.isValidSpade(key) || outputStack == null) {
            return false;
        }

        int durabilityLeft = key.getMaxDamage() - key.getItemDamage();
        return durabilityLeft >= outputStack.stackSize;
    }

    @Override
    protected void onConsumeKeys(int amountTaken) {
        ItemStack keyStack = keyInventory.getStackInSlot(keySlotIndex);
        if (keyStack != null && Objects.requireNonNull(keyStack.getItem()).isDamageable()) {
            keyStack.setItemDamage(keyStack.getItemDamage() + amountTaken);

            if (keyStack.getItemDamage() >= keyStack.getMaxDamage()) {
                keyInventory.setInventorySlotContents(keySlotIndex, null);
            } else {
                keyInventory.setInventorySlotContents(keySlotIndex, keyStack);
            }

            keyInventory.markDirty();
        }
    }
}
