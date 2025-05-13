package darkbum.saltymod.potion;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

/**
 * Represents a potion effect that has a probability of being applied.
 * This class allows for effects to be applied conditionally based on a random chance and a minimum hunger level.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ProbablePotionEffect {

    private final PotionEffect effect;
    private final float probability;
    private final int minHungerRequired;

    /**
     * Constructs a new ProbablePotionEffect with the specified parameters.
     *
     * @param potionID         The ID of the potion effect.
     * @param duration         The duration of the effect in ticks.
     * @param amplifier        The level of the effect.
     * @param probability      The probability of the effect being applied (0.0 - 1.0).
     * @param minHungerRequired The minimum hunger level required to apply the effect.
     */
    public ProbablePotionEffect(int potionID, int duration, int amplifier, float probability, int minHungerRequired) {
        this.effect = new PotionEffect(potionID, duration, amplifier);
        this.probability = probability;
        this.minHungerRequired = minHungerRequired;
    }

    @SuppressWarnings("unused")
    public ProbablePotionEffect(int potionID, int duration, int amplifier, float probability) {
        this(potionID, duration, amplifier, probability, 0);
    }

    @SuppressWarnings("unused")
    public ProbablePotionEffect(int potionID, int duration, int amplifier) {
        this(potionID, duration, amplifier, 1F);
    }

    @SuppressWarnings("unused")
    public ProbablePotionEffect(int potionID, int duration) {
        this(potionID, duration, 0, 1F);
    }

    /**
     * Attempts to apply the effect to the specified player based on the probability.
     * The effect is only applied if the player's hunger level meets the minimum requirement.
     * If the effect is applied, the player receives the specified potion effect.
     *
     * @param player The player to whom the effect might be applied.
     * @param random The random number generator used to determine whether the effect is applied.
     */
    public void procEffect(EntityPlayer player, Random random) {
        if (player.getFoodStats().getFoodLevel() >= minHungerRequired) {
            boolean apply = random.nextFloat() < probability;

            if (apply) {
                player.addPotionEffect(new PotionEffect(effect));
            }
        }
    }

    /**
     * Generates a tooltip string that describes the effect, its duration, amplifier, and probability.
     * If the effect has a hunger requirement, no tooltip is generated.
     *
     * @return a formatted tooltip string, or null if the effect has a hunger requirement.
     */
    public String addTooltip() {
        if (minHungerRequired > 0) {
            return null;
        }

        String line = "";
        if (Potion.potionTypes[effect.getPotionID()].isBadEffect()) {
            line += EnumChatFormatting.RED;
        }
        line += StatCollector.translateToLocal(effect.getEffectName())
            .trim();
        switch (effect.getAmplifier()) {
            case 1:
                line += " II";
                break;
            case 2:
                line += " III";
                break;
            case 3:
                line += " IV";
                break;
            case 4:
                line += " V";
                break;
            case 5:
                line += " VI";
                break;
        }
        line += EnumChatFormatting.GRAY;
        if (effect.getDuration() > 20) {
            line += " (" + Potion.getDurationString(effect) + ") ";
        } else {
            line += " ";
        }
        line += (int) (probability * 100F) + "%";
        line += EnumChatFormatting.RESET;
        return line;
    }
}
