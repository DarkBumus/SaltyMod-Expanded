package darkbum.saltmod.inventory.container;

import darkbum.saltmod.tileentity.TileEntityApiary;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerApiary extends Container {

    private TileEntityApiary apiary;

    private int lastProduceTime = 0;

    private int lastRunTime = 0;

    private int lastBeeRunTime = 0;

    public ContainerApiary(InventoryPlayer inventoryPlayer, TileEntityApiary tileEntityApiary) {
        this.apiary = tileEntityApiary;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 3; y++)
                addSlotToContainer(new SlotResult(inventoryPlayer.player, tileEntityApiary, y + x * 3, 62 + 18 * x, 17 + 18 * y));
        }
        addSlotToContainer(new SlotApiary(inventoryPlayer.player, tileEntityApiary, 18, 26, 35));
        int i;
        for (i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++)
                addSlotToContainer(new Slot((IInventory) inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
        }
        for (i = 0; i < 9; i++)
            addSlotToContainer(new Slot((IInventory) inventoryPlayer, i, 8 + i * 18, 142));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.apiary.isUseableByPlayer(player);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting crafter = (ICrafting) this.crafters.get(i);
            if (this.lastProduceTime != this.apiary.produceTime)
                crafter.sendProgressBarUpdate(this, 1, this.apiary.produceTime);
            if (this.lastRunTime != this.apiary.runTime)
                crafter.sendProgressBarUpdate(this, 2, this.apiary.runTime);
            if (this.lastBeeRunTime != this.apiary.currentBeeRunTime)
                crafter.sendProgressBarUpdate(this, 3, this.apiary.currentBeeRunTime);
        }
        this.lastProduceTime = this.apiary.produceTime;
        this.lastRunTime = this.apiary.runTime;
        this.lastBeeRunTime = this.apiary.currentBeeRunTime;
    }

    public void updateProgressBar(int event, int val) {
        if (event == 1) {
            this.apiary.produceTime = val;
        } else if (event == 2) {
            this.apiary.runTime = val;
        } else if (event == 3) {
            this.apiary.currentBeeRunTime = val;
        }
    }
}
