package darkbum.saltymod.common.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Handles the configuration settings for entity-related features in SaltyMod Expanded.
 * <p>
 * This class is responsible for defining configuration options related to entities,
 * such as enabling or modifying specific entity types.
 * The configuration values are read from the "entities.cfg" file.
 * <p>
 * This class is initialized during the pre-initialization stage of the mod lifecycle.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModConfigurationEntities {

    // Category Strings
    private static final String categoryNameEnt = "entities";
    private static final String categoryDescriptionEnt = "All the Entities configuration";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityStringEFR1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityStringEFR2 = " to be present";

    // Effects Config Options
    public static boolean enableHornedSheep;

    public static boolean hornedSheepThinHorns;

    /**
     * Initializes the entity configuration settings by reading values from the provided configuration file.
     *
     * @param config The configuration file object to read from.
     */
    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameEnt, categoryDescriptionEnt);

        enableHornedSheep = config.getBoolean(
            "01-enableHornedSheep",
            categoryNameEnt,
            true,
            enableFeatures + "\nHorned Sheep"
            + "\nHorn"
            + "\n");

        hornedSheepThinHorns = config.getBoolean(
            "02-hornedSheepThinHorns",
            categoryNameEnt,
            false,
            "Changes the model and texture to give the Horned Sheep thinner horns");
    }
}
