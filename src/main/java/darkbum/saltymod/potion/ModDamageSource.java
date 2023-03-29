package darkbum.saltymod.potion;

import net.minecraft.util.DamageSource;

public class ModDamageSource extends DamageSource {

    public static final DamageSource beesDamage = (new DamageSource("beesDamage")).setDamageBypassesArmor();

    public ModDamageSource(String damageType) {
        super(damageType);
    }


}
