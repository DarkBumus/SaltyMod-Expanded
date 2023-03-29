package darkbum.saltymod.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class PotionBees extends ModPotion {

    protected PotionBees(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.bees");
        setIconIndex(0, 0);
        setEffectiveness(0.25D);
    }

    public void performEffect(EntityLivingBase entity, int level) {
        if (!entity.isEntityUndead() && (entity instanceof net.minecraft.entity.player.EntityPlayer)) {
            entity.attackEntityFrom(ModDamageSource.beesDamage, 1.0F);
        }
    }

    public boolean isInstant() {
        return false;
    }
}
