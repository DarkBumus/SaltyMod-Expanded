package darkbum.saltymod.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Custom potion effect class for the "Well Fed" effect.
 * The Well Fed effect prevents the player from experiencing hunger and mitigates the effects of the Hunger debuff.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class PotionWellFed extends ModPotion {

    /**
     * Constructs a new instance of the Well Fed potion effect.
     *
     * @param id     The unique identifier for the potion effect.
     * @param isBad  Indicates whether the effect is considered harmful.
     * @param color  The color of the effect when displayed in the HUD.
     */
    public PotionWellFed(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.well_fed");
        setIconIndex(1, 0);
    }

    /**
     * Performs the effect logic for the Well Fed effect.
     * Resets the player's exhaustion level and attempts to counteract the Hunger effect.
     * The remaining duration of the Hunger effect is subtracted from the duration of the Well Fed effect.
     *
     * @param entity The entity affected by the effect.
     * @param level  The effect amplifier level.
     */
    @Override
    public void performEffect(EntityLivingBase entity, int level) {
        if (entity instanceof EntityPlayer player) {
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

    /**
     * Determines if the Well Fed effect should perform its action at a given tick interval.
     * This effect is always active, so it will trigger every tick.
     *
     * @param duration  The remaining duration of the effect in ticks.
     * @param amplifier The effect amplifier level.
     * @return true, indicating the effect should always trigger.
     */
    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
