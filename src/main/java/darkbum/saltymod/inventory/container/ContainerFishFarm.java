package darkbum.saltymod.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.tileentity.TileEntityFishFarm;

public class ContainerFishFarm extends Container {

    private final TileEntityFishFarm fishfarm;

    private int lastProduceTime = 0;

    private int lastRunTime = 0;

    private int lastFuelRunTime = 0;

    private static final int SLOT_OUTPUT_0 = 0;
    private static final int SLOT_OUTPUT_1 = 1;
    private static final int SLOT_OUTPUT_2 = 2;
    private static final int SLOT_OUTPUT_3 = 3;
    private static final int SLOT_OUTPUT_4 = 4;
    private static final int SLOT_OUTPUT_5 = 5;
    private static final int SLOT_OUTPUT_6 = 6;
    private static final int SLOT_OUTPUT_7 = 7;
    private static final int SLOT_OUTPUT_8 = 8;
    private static final int SLOT_OUTPUT_9 = 9;
    private static final int SLOT_OUTPUT_10 = 10;
    private static final int SLOT_OUTPUT_11 = 11;
    private static final int SLOT_OUTPUT_12 = 12;
    private static final int SLOT_OUTPUT_13 = 13;
    private static final int SLOT_OUTPUT_14 = 14;
    private static final int SLOT_OUTPUT_15 = 15;
    private static final int SLOT_OUTPUT_16 = 16;
    private static final int SLOT_OUTPUT_17 = 17;
    private static final int SLOT_INPUT = 18;

    public ContainerFishFarm(InventoryPlayer playerInventory, TileEntityFishFarm tileEntityFishFarm) {
        this.fishfarm = tileEntityFishFarm;

        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_0, 8, 17));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_1, 8, 35));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_2, 8, 53));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_3, 26, 17));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_4, 26, 35));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_5, 26, 53));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_6, 44, 17));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_7, 44, 35));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_8, 44, 53));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_9, 116, 17));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_10, 116, 35));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_11, 116, 53));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_12, 134, 17));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_13, 134, 35));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_14, 134, 53));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_15, 152, 17));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_16, 152, 35));
        addSlotToContainer(new SlotMachineOutput(tileEntityFishFarm, SLOT_OUTPUT_17, 152, 53));
        addSlotToContainer(new SlotFishFarmFuel(tileEntityFishFarm, SLOT_INPUT, 80, 35));

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

    public boolean canInteractWith(EntityPlayer player) {
        return this.fishfarm.isUseableByPlayer(player);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (ICrafting crafter : this.crafters) {
            if (this.lastProduceTime != this.fishfarm.produceTime)
                crafter.sendProgressBarUpdate(this, 1, this.fishfarm.produceTime);
            if (this.lastRunTime != this.fishfarm.runTime)
                crafter.sendProgressBarUpdate(this, 2, this.fishfarm.runTime);
            if (this.lastFuelRunTime != this.fishfarm.currentFuelRunTime)
                crafter.sendProgressBarUpdate(this, 3, this.fishfarm.currentFuelRunTime);
        }
        this.lastProduceTime = this.fishfarm.produceTime;
        this.lastRunTime = this.fishfarm.runTime;
        this.lastFuelRunTime = this.fishfarm.currentFuelRunTime;
    }

    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(slotIndex);
        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            itemStack = slotStack.copy();
            if (slotIndex >= 19) {
                if (slotStack.getItem() == ModItems.fish_bait) {
                    if (!mergeItemStack(slotStack, 18, 19, false)) return null;
                } else if (slotIndex < 46) {
                    if (!mergeItemStack(slotStack, 46, 55, false)) return null;
                } else if (slotIndex < 55 && !mergeItemStack(slotStack, 19, 46, false)) {
                    return null;
                }
            } else if (!mergeItemStack(slotStack, 19, 55, false)) {
                return null;
            }
            if (slotStack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (slotStack.stackSize == itemStack.stackSize) return null;
            slot.onPickupFromSlot(entityPlayer, slotStack);
        }
        return itemStack;
    }

    public void updateProgressBar(int event, int val) {
        if (event == 1) {
            this.fishfarm.produceTime = val;
        } else if (event == 2) {
            this.fishfarm.runTime = val;
        } else if (event == 3) {
            this.fishfarm.currentFuelRunTime = val;
        }
    }
}
