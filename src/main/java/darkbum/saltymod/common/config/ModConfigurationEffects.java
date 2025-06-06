package darkbum.saltymod.common.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Handles the configuration settings for potion effects in SaltyMod Expanded.
 * <p>
 * This class is responsible for defining the IDs and other properties of custom potion effects
 * introduced by the mod, such as "Swarmed", "Well Fed", and "Inspired".
 * The configuration values are read from the "effects.cfg" file.
 * <p>
 * This class is initialized during the pre-initialization stage of the mod lifecycle.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModConfigurationEffects {

    // Category Strings
    private static final String categoryNameEff = "effects";
    private static final String categoryDescriptionEff = "All the Effects configuration";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityStringEFR1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityStringEFR2 = " to be present";

    // Effects Config Options
    public static int swarmedEffectID;

    public static int wellFedEffectID;

    public static int inspiredEffectID;
    public static float inspiredEffectStrength;

    /**
     * Initializes the effect configuration settings by reading values from the provided configuration file.
     *
     * @param config The configuration file object to read from.
     */
    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameEff, categoryDescriptionEff);

        swarmedEffectID = config.getInt(
            "01-swarmedEffectID",
            categoryNameEff,
            28,
            0,
            65536,
            "Sets the Potion ID for the \"Swarmed!\" Potion Effect. Only use a value above 127 if you have an ID extender mod."
                + "\nIf you don't know what that is, don't use a value above 127.");

        wellFedEffectID = config.getInt(
            "02-wellFedEffectID",
            categoryNameEff,
            29,
            0,
            65536,
            "Sets the Potion ID for the \"Well Fed\" Potion Effect. Only use a value above 127 if you have an ID extender mod."
                + "\nIf you don't know what that is, don't use a value above 127.");

        inspiredEffectID = config.getInt(
            "03-inspiredEffectID",
            categoryNameEff,
            30,
            0,
            65536,
            "Sets the Potion ID for the \"Inspired\" Potion Effect. Only use a value above 127 if you have an ID extender mod."
                + "\nIf you don't know what that is, don't use a value above 127.");
        inspiredEffectStrength = config.getFloat(
            "04-inspiredEffectStrength",
            categoryNameEff,
            0.3f,
            0.0f,
            1000.0f,
            "Changes the strength of the \"Inspired\" Potion Effect. This float value will be multiplied with the effect level."
            + "\nSetting the value to 0.0f will negate the effect of \"Inspired\" fully."
            + "\nCareful, this setting is quite sensitive!");
    }
}
