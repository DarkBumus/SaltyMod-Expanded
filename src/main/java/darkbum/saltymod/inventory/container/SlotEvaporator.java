package darkbum.saltymod.inventory.container;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import darkbum.saltymod.api.EvaporateRegistry;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;

public class SlotEvaporator extends Slot {

    private EntityPlayer thePlayer;

    private int count;

    public SlotEvaporator(EntityPlayer player, IInventory inv, int x, int y, int z) {
        super(inv, x, y, z);
        this.thePlayer = player;
    }

    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    public ItemStack decrStackSize(int par_1) {
        if (getHasStack()) this.count += Math.min(par_1, (getStack()).stackSize);
        return super.decrStackSize(par_1);
    }

    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        onCrafting(stack);
        super.onPickupFromSlot(player, stack);
    }

    protected void onCrafting(ItemStack stack, int par_2) {
        this.count += par_2;
        onCrafting(stack);
    }

    protected void onCrafting(ItemStack stack) {
        stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.count);
        if (!this.thePlayer.worldObj.isRemote) {
            int i = this.count;
            float f = EvaporateRegistry.instance()
                .getEvaporateExperience(stack);
            if (f == 0.0F) {
                i = 0;
            } else if (f < 1.0F) {
                int j = MathHelper.floor_float(i * f);
                if (j < MathHelper.ceiling_float_int(i * f) && (float) Math.random() < i * f - j) j++;
                i = j;
            }
            while (i > 0) {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.thePlayer.worldObj.spawnEntityInWorld(
                    new EntityXPOrb(
                        this.thePlayer.worldObj,
                        this.thePlayer.posX,
                        this.thePlayer.posY + 0.5D,
                        this.thePlayer.posZ + 0.5D,
                        j));
            }
        }
        this.count = 0;
        if (stack.getItem() == ModItems.salt_pinch) this.thePlayer.addStat(ModAchievementList.farm_evaporator, 1);
    }
}
