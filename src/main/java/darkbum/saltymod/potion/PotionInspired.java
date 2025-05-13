package darkbum.saltymod.potion;

/**
 * Custom potion effect class for the "Inspired" effect.
 * This effect does not have any periodic functionality and serves as a passive or status effect.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class PotionInspired extends ModPotion {

    /**
     * Constructs a new instance of the Inspired potion effect.
     *
     * @param id     The unique identifier for the potion effect.
     * @param isBad  Indicates whether the effect is considered harmful.
     * @param color  The color of the effect when displayed in the HUD.
     */
    public PotionInspired(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.inspired");
        setIconIndex(2, 0);
    }

    /**
     * Determines whether the effect should perform an action at the specified tick interval.
     * For the Inspired effect, this method always returns false, indicating that no periodic action is performed.
     *
     * @param duration  The remaining duration of the effect in ticks.
     * @param amplifier The potency level of the effect.
     * @return false, as the Inspired effect does not trigger any periodic action.
     */
    @Override
    public boolean isReady(int duration, int amplifier) {
        return false;
    }
}
