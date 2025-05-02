package darkbum.saltymod.potion;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
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
        if (entity instanceof EntityPlayer player) {

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

            int x = MathHelper.floor_double(player.posX);
            int y = MathHelper.floor_double(player.posY + player.getEyeHeight());
            int z = MathHelper.floor_double(player.posZ);

            if (!player.worldObj.getBlock(x, y, z).getMaterial().isLiquid() && !player.isBurning()) {
                player.addStat(ModAchievementList.effect_swarmed, 1);
                entity.attackEntityFrom(ModPotion.swarmedDamage, Math.max(0.0F, 1.0F - beeResistance));
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int interval;
        interval = 10 >> amplifier;
        return interval == 0 || duration % interval == 0;
    }
}
