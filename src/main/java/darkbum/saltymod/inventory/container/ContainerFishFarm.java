package darkbum.saltymod.inventory.container;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.tileentity.TileEntityFishFarm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFishFarm extends Container {

    private TileEntityFishFarm fishfarm;

    private int lastProduceTime = 0;

    private int lastRunTime = 0;

    private int lastFuelRunTime = 0;

    public ContainerFishFarm(InventoryPlayer inventoryPlayer, TileEntityFishFarm tileEntityFishFarm) {
        this.fishfarm = tileEntityFishFarm;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 3; y++)
                addSlotToContainer(new SlotFishFarm(inventoryPlayer.player, tileEntityFishFarm, y + x * 3, 62 + 18 * x, 17 + 18 * y));
        }
        addSlotToContainer(new SlotFishFarmFuel(inventoryPlayer.player, tileEntityFishFarm, 18, 26, 35));
        int i;
        for (i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++)
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
        }
        for (i = 0; i < 9; i++)
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.fishfarm.isUseableByPlayer(player);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting crafter = this.crafters.get(i);
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
                    if (!mergeItemStack(slotStack, 18, 19, false))
                        return null;
                } else if (slotIndex >= 19 && slotIndex < 46) {
                    if (!mergeItemStack(slotStack, 46, 55, false))
                        return null;
                } else if (slotIndex >= 46 && slotIndex < 55 && !mergeItemStack(slotStack, 19, 46, false)) {
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
            if (slotStack.stackSize == itemStack.stackSize)
                return null;
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
