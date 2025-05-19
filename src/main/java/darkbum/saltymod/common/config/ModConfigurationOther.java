package darkbum.saltymod.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import net.minecraftforge.common.config.Configuration;

import darkbum.saltymod.SaltyMod;

/**
 * Handles configuration settings that are marked to be phased out in future versions of SaltyMod Expanded.
 * <p>
 * This class manages configuration options that are deprecated or planned for removal,
 * allowing for legacy support and transition handling. Currently, the only configuration
 * handled here is cloud level height per dimension.
 * <p>
 * This class is initialized during the pre-initialization stage of the mod lifecycle.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModConfigurationOther {

    // Category Strings
    private static final String categoryNameOth = "to be phased out";
    private static final String categoryDescriptionOth = "TO BE PHASED OUT | IGNORE";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityString1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityString2 = " to be present";

    // Config Options TOBEPHASEDOUT
    public static Map<Integer, Integer> cloudLevel;

    public static boolean enableNEIShrub;

    /**
     * Initializes the configuration settings for the "to be phased out" category by reading values from the provided configuration file.
     *
     * @param config The configuration file object to read from.
     */
    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameOth, categoryDescriptionOth);

        enableNEIShrub = config.getBoolean(
            "enableNEIShrub",
            categoryNameOth,
            true,
            "Regulates whether or not the Shrub (tallgrass:0) should be shown in NEI or not."
                + "\nDue to a bug with NEI this option currently shows two sets of tallgrass in NEI.");

        String[] defaultCloudLevel = {"0=128", "7=160"};

        String[] loadedCloudLevel = config.getStringList(
            "loadedCloudLevel",
            categoryNameOth,
            defaultCloudLevel,
            "The height of the clouds in a specific dimension (DimensionID=CloudLevel)");

        cloudLevel = new HashMap<>();
        Pattern splitpattern = Pattern.compile("=");
        for (int i = 0; i < loadedCloudLevel.length; i++) {
            String s = loadedCloudLevel[i];
            String[] pair = splitpattern.split(s);
            if (pair.length != 2) {
                SaltyMod.logger.warn("Invalid key-value pair at DimCloudLevel[{}]", i);
            } else {
                int dim, level;
                try {
                    dim = Integer.parseInt(pair[0]);
                } catch (NumberFormatException e) {
                    SaltyMod.logger.warn("Cannot parse DimensionID \"{}\" to integer point at DimCloudLevel line {}", pair[0], i + 1);
                    break;
                }
                try {
                    level = Integer.parseInt(pair[1]);
                } catch (NumberFormatException e) {
                    SaltyMod.logger.warn("Cannot parse CloudLevel \"{}\" to integer point at DimCloudLevel line {}", pair[1], i + 1);
                    break;
                }
                cloudLevel.put(dim, level);
            }
        }
    }
}
