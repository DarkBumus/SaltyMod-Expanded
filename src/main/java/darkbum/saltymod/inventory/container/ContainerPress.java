package darkbum.saltymod.inventory.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.api.MachineUtilRegistry;
import darkbum.saltymod.tileentity.TileEntityPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPress extends Container {

    private final TileEntityPress tileEntityPress;

    private int lastPressingTime = 0;

    private static final int SLOT_INPUT = 0;
    private static final int SLOT_OUTPUT_1 = 1;
    private static final int SLOT_OUTPUT_2 = 2;
    private static final int SLOT_VESSEL = 3;
    private static final int SLOT_COUNT_MACHINE = 4;

    private static final int SLOT_PLAYER_INV_START = SLOT_COUNT_MACHINE;
    private static final int SLOT_HOTBAR_START = SLOT_PLAYER_INV_START + 27;
    private static final int SLOT_TOTAL = SLOT_HOTBAR_START + 9;

    public ContainerPress(InventoryPlayer playerInventory, TileEntityPress tileEntityPress) {
        this.tileEntityPress = tileEntityPress;

        addSlotToContainer(new SlotPressInput(playerInventory.player, tileEntityPress, SLOT_INPUT, 80, 17));
        addSlotToContainer(new SlotMachineOutput(playerInventory.player, tileEntityPress, SLOT_OUTPUT_1, 62, 53));
        addSlotToContainer(new SlotMachineOutput(playerInventory.player, tileEntityPress, SLOT_OUTPUT_2, 98, 53));
        addSlotToContainer(new SlotPressVessel(playerInventory.player, tileEntityPress, SLOT_VESSEL, 26, 53));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int index = col + row * 9 + 9;
                int x = 8 + col * 18;
                int y = 84 + row * 18;
                addSlotToContainer(new Slot(playerInventory, index, x, y));
            }
        }

        for (int col = 0; col < 9; col++) {
            int x = 8 + col * 18;
            addSlotToContainer(new Slot(playerInventory, col, x, 142));
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        if (this.lastPressingTime != this.tileEntityPress.pressingTime) {
            for (ICrafting crafter : this.crafters) {
                crafter.sendProgressBarUpdate(this, 0, this.tileEntityPress.pressingTime);
            }
            this.lastPressingTime = this.tileEntityPress.pressingTime;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.tileEntityPress.pressingTime = value;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntityPress.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            itemStack = stackInSlot.copy();

            // Output-Slots dürfen keine Items annehmen oder verschieben
            if (slotIndex == SLOT_OUTPUT_1 || slotIndex == SLOT_OUTPUT_2) {
                return null;
            }

            // Vessel-Slot: nur gültige Vessels annehmen
            if (slotIndex == SLOT_VESSEL) {
                boolean isValidVessel = MachineUtilRegistry.isValidVessel(stackInSlot);
                if (!isValidVessel) {
                    return null; // Wenn es kein gültiges Vessel ist, nichts tun
                }
                if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, false)) {
                    return null;
                }
            }
            // Input-Slot: Alle Items annehmen, auch mit Shift-Klick
            else if (slotIndex == SLOT_INPUT) {
                if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, true)) {
                    return null;
                }
            } else {
                // Slots im Inventar und Hotbar: Items hin- und herschieben
                if (slotIndex < SLOT_PLAYER_INV_START) {
                    // Maschine → Spieler-Inv
                    if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, true)) {
                        return null;
                    }
                } else if (slotIndex < SLOT_HOTBAR_START) {
                    // Spieler → Hotbar
                    if (!mergeItemStack(stackInSlot, SLOT_HOTBAR_START, SLOT_TOTAL, false)) {
                        return null;
                    }
                } else {
                    // Hotbar → Hauptinventar
                    if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_HOTBAR_START, false)) {
                        return null;
                    }
                }
            }

            // Falls die Stackgröße 0 ist, den Slot leeren
            if (stackInSlot.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            // Wenn sich nichts geändert hat, return null
            if (stackInSlot.stackSize == itemStack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, stackInSlot);
        }

        return itemStack;
    }
}
