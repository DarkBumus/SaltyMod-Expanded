package darkbum.saltymod.configuration.configs;

import net.minecraftforge.common.config.Configuration;

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

    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameEff, categoryDescriptionEff);

        swarmedEffectID = config.getInt(
            "01-swarmedEffectID",
            categoryNameEff,
            28,
            0,
            Byte.MAX_VALUE,
            "Sets the Potion ID for the \"Swarmed!\" Potion Effect");

        wellFedEffectID = config.getInt(
            "02-wellFedEffectID",
            categoryNameEff,
            29,
            0,
            Byte.MAX_VALUE,
            "Sets the Potion ID for the \"Well Fed\" Potion Effect");
    }
}
