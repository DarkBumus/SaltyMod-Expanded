package darkbum.saltymod.potion;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import darkbum.saltymod.init.ModAchievementList;

public class PotionSwarmed extends ModPotion {

    protected PotionSwarmed(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.swarmed");
        setIconIndex(0, 0);
        setEffectiveness(0.25D);
    }

    @Override
    public void performEffect(EntityLivingBase entity, int level) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            float beeResistance = 0F;
            ArrayList<ItemStack> validStacks = OreDictionary.getOres("beeResistant");

            float[] resistanceValues = { 0.4F, 0.3F, 0.2F, 0.1F };

            for (int i = 0; i < 4; i++) {
                ItemStack itemStack = player.getCurrentArmor(i);
                if (itemStack != null) {
                    for (ItemStack validStack : validStacks) {
                        if (OreDictionary.itemMatches(validStack, itemStack, false)) {
                            beeResistance += resistanceValues[i];
                            break;
                        }
                    }
                }
            }

            // Bedingung für den Schaden
            if (!player.worldObj.getBlock((int) player.posX, (int) player.posY + 1, (int) player.posZ)
                .getMaterial()
                .isLiquid() && (!player.isBurning())) {
                player.addStat(ModAchievementList.effectSwarmed, 1);
                entity.attackEntityFrom(ModPotion.swarmedDamage, Math.max(0.0F, 1.0F - beeResistance));
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
