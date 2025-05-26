package darkbum.saltymod.inventory.container;

import darkbum.saltymod.inventory.slot.SlotEvaporator;
import darkbum.saltymod.inventory.slot.SlotEvaporatorFuel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.tileentity.TileEntityEvaporator;

public class ContainerEvaporator extends Container {

    private final TileEntityEvaporator tileEntityEvaporator;

    private int lastEvaporateTime;

    private int lastBurnTime;

    private int lastItemBurnTime;

    public ContainerEvaporator(InventoryPlayer inv, TileEntityEvaporator tileEntityEvaporator) {
        this.tileEntityEvaporator = tileEntityEvaporator;
        addSlotToContainer(new SlotEvaporator(inv.player, tileEntityEvaporator, 0, 116, 35));
        addSlotToContainer(new SlotEvaporatorFuel(tileEntityEvaporator, 1, 56, 53));
        int i;
        for (i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
        }
        for (i = 0; i < 9; i++) addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
    }

    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, tileEntityEvaporator.evaporateTime);
        iCrafting.sendProgressBarUpdate(this, 1, tileEntityEvaporator.burningTime);
        iCrafting.sendProgressBarUpdate(this, 2, tileEntityEvaporator.currentItemBurnTime);
        iCrafting.sendProgressBarUpdate(this, 3, tileEntityEvaporator.liquidID);
        iCrafting.sendProgressBarUpdate(this, 4, tileEntityEvaporator.liquidLevel);
        iCrafting.sendProgressBarUpdate(this, 5, tileEntityEvaporator.pressure);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (ICrafting crafter : crafters) {
            if (lastEvaporateTime != tileEntityEvaporator.evaporateTime)
                crafter.sendProgressBarUpdate(this, 0, tileEntityEvaporator.evaporateTime);
            if (lastBurnTime != tileEntityEvaporator.burningTime) crafter.sendProgressBarUpdate(this, 1, tileEntityEvaporator.burningTime);
            if (lastItemBurnTime != tileEntityEvaporator.currentItemBurnTime)
                crafter.sendProgressBarUpdate(this, 2, tileEntityEvaporator.currentItemBurnTime);
            crafter.sendProgressBarUpdate(this, 3, tileEntityEvaporator.liquidID);
            crafter.sendProgressBarUpdate(this, 4, tileEntityEvaporator.liquidLevel);
            crafter.sendProgressBarUpdate(this, 5, tileEntityEvaporator.pressure);
        }
        lastEvaporateTime = tileEntityEvaporator.evaporateTime;
        lastBurnTime = tileEntityEvaporator.burningTime;
        lastItemBurnTime = tileEntityEvaporator.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int v) {
        if (id == 0) tileEntityEvaporator.evaporateTime = v;
        if (id == 1) tileEntityEvaporator.burningTime = v;
        if (id == 2) tileEntityEvaporator.currentItemBurnTime = v;
        if (id == 3) tileEntityEvaporator.liquidID = v;
        if (id == 4) tileEntityEvaporator.liquidLevel = v;
        if (id == 5) tileEntityEvaporator.pressure = v;
    }

    public boolean canInteractWith(EntityPlayer player) {
        return tileEntityEvaporator.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = null;
        Slot slot = inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 0) {
                if (!mergeItemStack(itemstack1, 2, 38, true)) return null;
                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 1) {
                if (TileEntityFurnace.isItemFuel(itemstack1)) {
                    if (!mergeItemStack(itemstack1, 1, 2, false)) return null;
                } else if (index < 29) {
                    if (!mergeItemStack(itemstack1, 29, 38, false)) return null;
                } else if (index < 38 && !mergeItemStack(itemstack1, 2, 29, false)) {
                    return null;
                }
            } else if (!mergeItemStack(itemstack1, 2, 38, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize) return null;
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
}
