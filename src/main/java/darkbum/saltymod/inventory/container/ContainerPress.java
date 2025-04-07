package darkbum.saltymod.inventory.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.tileentity.TileEntityPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPress extends Container {

    private final TileEntityPress press;

    private int lastPressingTime = 0;

    private static final int SLOT_INPUT = 0;
    private static final int SLOT_OUTPUT_1 = 1;
    private static final int SLOT_OUTPUT_2 = 2;
    private static final int SLOT_FUEL = 3;
    private static final int SLOT_COUNT_MACHINE = 4;

    private static final int SLOT_PLAYER_INV_START = SLOT_COUNT_MACHINE;
    private static final int SLOT_HOTBAR_START = SLOT_PLAYER_INV_START + 27;
    private static final int SLOT_TOTAL = SLOT_HOTBAR_START + 9;

    public ContainerPress(InventoryPlayer playerInventory, TileEntityPress press) {
        this.press = press;

        addSlotToContainer(new SlotPressInput(playerInventory.player, press, SLOT_INPUT, 80, 21));
        addSlotToContainer(new SlotFarmOutput(playerInventory.player, press, SLOT_OUTPUT_1, 62, 53));
        addSlotToContainer(new SlotFarmOutput(playerInventory.player, press, SLOT_OUTPUT_2, 98, 53));
        addSlotToContainer(new SlotPressFuel(playerInventory.player, press, SLOT_FUEL, 26, 53));

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

        if (this.lastPressingTime != this.press.pressingTime) {
            for (ICrafting crafter : this.crafters) {
                crafter.sendProgressBarUpdate(this, 0, this.press.pressingTime);
            }
            this.lastPressingTime = this.press.pressingTime;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.press.pressingTime = value;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.press.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            itemStack = stackInSlot.copy();

            // Wenn der Slot der Block-Slots (Fuel, Input, Output) ist, verschiebe das Item ins Inventar
            if (slotIndex == SLOT_INPUT || slotIndex == SLOT_OUTPUT_1 || slotIndex == SLOT_OUTPUT_2 || slotIndex == SLOT_FUEL) {
                // Verschieben des Items in das Inventar (zwischen 3 und 39, Hotbar und Inventar)
                if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, true)) {
                    return null;
                }
            } else {
                // Wenn der Slot nicht der Block-Slot ist, verschieben wir die Items zwischen Hotbar und Inventar
                if (slotIndex < SLOT_PLAYER_INV_START) {
                    // Verschieben zwischen Inventar und Hotbar
                    if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, true)) {
                        return null;
                    }
                } else {
                    // Verschieben zwischen Hotbar und Inventar
                    if (slotIndex < SLOT_HOTBAR_START) {
                        if (!mergeItemStack(stackInSlot, SLOT_HOTBAR_START, SLOT_TOTAL, false)) {
                            return null;
                        }
                    } else {
                        if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_HOTBAR_START, false)) {
                            return null;
                        }
                    }
                }
            }

            if (stackInSlot.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (stackInSlot.stackSize == itemStack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, stackInSlot);
        }

        return itemStack;
    }


}

