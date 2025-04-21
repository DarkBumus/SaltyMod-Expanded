package darkbum.saltymod.potion;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ProbablePotionEffect {

    private final PotionEffect effect;
    private final float probability;
    private final int minHungerRequired;

    public ProbablePotionEffect(int potionID, int duration, int amplifier, float probability, int minHungerRequired) {
        this.effect = new PotionEffect(potionID, duration, amplifier);
        this.probability = probability;
        this.minHungerRequired = minHungerRequired;
    }

    public ProbablePotionEffect(int potionID, int duration, int amplifier, float probability) {
        this(potionID, duration, amplifier, probability, 0);
    }

    public ProbablePotionEffect(int potionID, int duration, int amplifier) {
        this(potionID, duration, amplifier, 1F);
    }

    public ProbablePotionEffect(int potionID, int duration) {
        this(potionID, duration, 0, 1F);
    }

    public boolean procEffect(EntityPlayer player, Random random) {
        if (player.getFoodStats().getFoodLevel() >= minHungerRequired) {
            boolean apply = random.nextFloat() < probability;
            player.addPotionEffect(new PotionEffect(effect));
            return apply;
        }
        return false;
    }

    public String generateTooltip() {
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
            line += " (<0:01) ";
        }
        line += (int) (probability * 100F) + "%";
        line += EnumChatFormatting.RESET;
        return line;
    }
}
