package darkbum.saltymod.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionWellFed extends ModPotion {

    public PotionWellFed(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.well_fed");
        setIconIndex(1, 0);
    }

    @Override
    public void performEffect(EntityLivingBase entity, int level) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            player.getFoodStats().foodExhaustionLevel = 0F;
            if (player.isPotionActive(Potion.hunger)) {
                PotionEffect hungerEffect = player.getActivePotionEffect(Potion.hunger);
                PotionEffect wellFedEffect = player.getActivePotionEffect(this);
                int hungerDuration = hungerEffect.duration;
                hungerEffect.duration -= wellFedEffect.duration;
                wellFedEffect.duration -= hungerDuration;
            }
        }
    }

    @Override
    public boolean isReady(int p_76397_1_, int p_76397_2_) {
        return true;
    }
}
