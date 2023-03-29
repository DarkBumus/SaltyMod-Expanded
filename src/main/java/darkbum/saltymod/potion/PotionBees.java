package darkbum.saltymod.potion;

import darkbum.saltymod.SaltyMod;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;


public class PotionBees extends ModPotion {

    protected PotionBees(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.bees");
        setIconIndex(0, 0);
        setEffectiveness(0.25D);
    }

    @Override
    public void performEffect(EntityLivingBase entity, int level) {
        if (entity instanceof net.minecraft.entity.player.EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            float beeResistance = 0F;
            ArrayList<ItemStack> validStacks = OreDictionary.getOres("beeResistant");
            ItemStack itemStack = player.getCurrentArmor(0);

            if (itemStack != null && validStacks.contains(itemStack)) {
                beeResistance += 0.4F;
            }
            itemStack = player.getCurrentArmor(1);
            if (itemStack != null && validStacks.contains(itemStack)) {
                beeResistance += 0.3F;
            }
            itemStack = player.getCurrentArmor(2);
            if (itemStack != null && validStacks.contains(itemStack)) {
                beeResistance += 0.2F;
            }
            itemStack = player.getCurrentArmor(3);
            if (itemStack != null && validStacks.contains(itemStack)) {
                beeResistance += 0.1F;
            }
            if  (!player.getEntityWorld().getBlock((int)player.posX, (int)player.posY + 1, (int)player.posZ).getMaterial().isLiquid() &&
                (!player.isBurning())) {
                entity.attackEntityFrom(ModDamageSource.beesDamage, 1.0F - beeResistance);
            }
        }
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public boolean isReady(int p_76397_1_, int p_76397_2_) {
        int k;
        k = 10 >> p_76397_2_;
        return k > 0 ? p_76397_1_ % k == 0 : true;
    }
}
