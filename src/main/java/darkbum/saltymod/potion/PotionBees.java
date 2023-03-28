package darkbum.saltymod.potion;

import net.minecraft.entity.EntityLivingBase;

public class PotionBees extends ModPotion {

    protected PotionBees(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.bees");
        setIconIndex(0, 0);
        setEffectiveness(0.25D);
    }

    public void performEffect(EntityLivingBase entity, int level) {
        entity.attackEntityFrom(ModPotion.beesDamage, 1.0F);
    }
}
