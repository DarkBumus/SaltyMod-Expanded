package darkbum.saltymod.potion;

import net.minecraft.util.DamageSource;

public class ModDamageSource extends DamageSource {

    public static DamageSource beesDamage = (new DamageSource("beesDamage")).setDamageBypassesArmor().setFireDamage();

    public ModDamageSource(String damageType) {
        super(damageType);
    }
}
