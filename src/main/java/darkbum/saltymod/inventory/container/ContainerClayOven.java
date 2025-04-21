package darkbum.saltymod.inventory.container;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.api.MachineUtilRegistry;
import darkbum.saltymod.tileentity.TileEntityClayOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerClayOven extends Container {

    private final TileEntityClayOven tileEntityClayOven;

    private int lastBakingTime = 0;

    private static final int SLOT_INGRED_1 = 0;
    private static final int SLOT_INGRED_2 = 1;
    private static final int SLOT_INGRED_3 = 2;
    private static final int SLOT_INGRED_4 = 3;
    public static final int SLOT_OUTPUT = 4;
    private static final int SLOT_SPADE = 5;
    private static final int SLOT_COUNT_MACHINE = 6;

    private static final int SLOT_PLAYER_INV_START = SLOT_COUNT_MACHINE;
    private static final int SLOT_HOTBAR_START = SLOT_PLAYER_INV_START + 27;
    private static final int SLOT_TOTAL = SLOT_HOTBAR_START + 9;

    public ContainerClayOven(InventoryPlayer playerInventory, TileEntityClayOven TileEntityClayOven) {
        this.tileEntityClayOven = TileEntityClayOven;

        addSlotToContainer(new SlotMachineIngred(playerInventory.player, TileEntityClayOven, SLOT_INGRED_1, 40, 17));
        addSlotToContainer(new SlotMachineIngred(playerInventory.player, TileEntityClayOven, SLOT_INGRED_2, 58, 17));
        addSlotToContainer(new SlotMachineIngred(playerInventory.player, TileEntityClayOven, SLOT_INGRED_3, 40, 35));
        addSlotToContainer(new SlotMachineIngred(playerInventory.player, TileEntityClayOven, SLOT_INGRED_4, 58, 35));
        addSlotToContainer(new SlotClayOvenOutputLocked(playerInventory.player, TileEntityClayOven, SLOT_OUTPUT, 116, 26, TileEntityClayOven, SLOT_SPADE));
        addSlotToContainer(new SlotClayOvenSpade(playerInventory.player, TileEntityClayOven, SLOT_SPADE, 116, 55));

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

        if (this.lastBakingTime != this.tileEntityClayOven.bakingTime) {
            for (ICrafting crafter : this.crafters) {
                crafter.sendProgressBarUpdate(this, 0, this.tileEntityClayOven.bakingTime);
            }
            this.lastBakingTime = this.tileEntityClayOven.bakingTime;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value) {
        if (id == 0) {
            this.tileEntityClayOven.bakingTime = value;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntityClayOven.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            itemStack = stackInSlot.copy();

            // === SPEZIALFALL: Outputslot mit SHIFT-Klick ===
            if (slotIndex == SLOT_OUTPUT && slot instanceof SlotClayOvenOutputLocked) {
                // Zugriff auf Key (Schaufel) prüfen
                ItemStack keyStack = tileEntityClayOven.getStackInSlot(SLOT_SPADE);
                if (!MachineUtilRegistry.isValidSpade(keyStack)) {
                    return null;
                }

                int amountTaken = stackInSlot.stackSize;

                // Genug Haltbarkeit?
                int durabilityLeft = keyStack.getMaxDamage() - keyStack.getItemDamage();
                if (durabilityLeft < amountTaken) {
                    return null;
                }

                // Verschiebe Output ins Inventar
                if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, true)) {
                    return null;
                }

                // Stack wurde verschoben → Schlüssel beschädigen
                if (keyStack.getItem().isDamageable()) {
                    keyStack.setItemDamage(keyStack.getItemDamage() + amountTaken);
                    if (keyStack.getItemDamage() >= keyStack.getMaxDamage()) {
                        tileEntityClayOven.setInventorySlotContents(SLOT_SPADE, null); // Schaufel kaputt
                    } else {
                        tileEntityClayOven.setInventorySlotContents(SLOT_SPADE, keyStack);
                    }
                    tileEntityClayOven.markDirty();
                }

                // Output-Slot leeren
                slot.putStack(null);
                slot.onSlotChanged();

                return itemStack;
            }

            // === Maschinenbereich → Spieler (immer erlaubt) ===
            if (slotIndex < SLOT_PLAYER_INV_START) {
                if (!mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_TOTAL, true)) {
                    return null;
                }
            } else {
                // === Spieler → Maschine ===
                boolean isSpadeItem = MachineUtilRegistry.isValidSpade(stackInSlot);
                boolean merged = false;

                if (isSpadeItem) {
                    merged = mergeItemStack(stackInSlot, SLOT_SPADE, SLOT_SPADE + 1, false);
                } else {
                    merged = mergeItemStack(stackInSlot, SLOT_INGRED_1, SLOT_INGRED_4 + 1, false);
                }

                // Falls nicht in Maschine mergebar → Hotbar/Inventory
                if (!merged) {
                    if (slotIndex >= SLOT_PLAYER_INV_START && slotIndex < SLOT_HOTBAR_START) {
                        merged = mergeItemStack(stackInSlot, SLOT_HOTBAR_START, SLOT_TOTAL, false);
                    } else if (slotIndex >= SLOT_HOTBAR_START && slotIndex < SLOT_TOTAL) {
                        merged = mergeItemStack(stackInSlot, SLOT_PLAYER_INV_START, SLOT_HOTBAR_START, false);
                    }

                    if (!merged) {
                        return null;
                    }
                }
            }

            // Stack geleert?
            if (stackInSlot.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            // Nichts bewegt?
            if (stackInSlot.stackSize == itemStack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, stackInSlot);
        }

        return itemStack;
    }
}
