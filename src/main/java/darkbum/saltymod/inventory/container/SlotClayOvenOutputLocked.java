package darkbum.saltymod.inventory.container;

import darkbum.saltymod.api.MachineUtilRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotClayOvenOutputLocked extends Slot {

    private EntityPlayer entityPlayer;
    private final IInventory keyInventory;
    private final int keySlotIndex;

    public SlotClayOvenOutputLocked(EntityPlayer entityPlayer, IInventory inventory, int slotIndex, int x, int y, IInventory keyInventory, int keySlotIndex) {
        super(inventory, slotIndex, x, y);
        this.entityPlayer = entityPlayer;
        this.keyInventory = keyInventory;
        this.keySlotIndex = keySlotIndex;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        ItemStack key = keyInventory.getStackInSlot(keySlotIndex);
        ItemStack outputStack = getStack();

        // Kein gültiger Schlüssel oder kein Output vorhanden
        if (!MachineUtilRegistry.isValidSpade(key) || outputStack == null) {
            return false;
        }

        // Reicht die Haltbarkeit?
        int durabilityLeft = key.getMaxDamage() - key.getItemDamage();
        if (durabilityLeft < outputStack.stackSize) {
            return false;
        }

        return true;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        int amountTaken = stack != null ? stack.stackSize : 0;

        // Reduziere den Slot-Stack wie bisher
        if (getHasStack()) {
            ItemStack slotStack = getStack();

            if (slotStack.stackSize > amountTaken) {
                slotStack.stackSize -= amountTaken;
                putStack(slotStack);
            } else {
                putStack(null);
            }
        }

        // Füge Schaden zu
        if (amountTaken > 0) {
            ItemStack keyStack = keyInventory.getStackInSlot(keySlotIndex);
            if (keyStack != null && keyStack.getItem().isDamageable()) {
                keyStack.setItemDamage(keyStack.getItemDamage() + amountTaken);

                if (keyStack.getItemDamage() >= keyStack.getMaxDamage()) {
                    keyInventory.setInventorySlotContents(keySlotIndex, null);  // Schaufel zerstört
                } else {
                    keyInventory.setInventorySlotContents(keySlotIndex, keyStack);
                }

                keyInventory.markDirty();
            }
        }

        super.onPickupFromSlot(player, stack);
    }
}
