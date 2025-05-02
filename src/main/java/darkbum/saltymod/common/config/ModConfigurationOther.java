package darkbum.saltymod.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import net.minecraftforge.common.config.Configuration;

import darkbum.saltymod.SaltyMod;

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

    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameOth, categoryDescriptionOth);

        String[] defaultCloudLevel = { "0=128", "7=160" };

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
                SaltyMod.logger.warn("Invalid key-value pair at DimCloudLevel[" + i + "]");
            } else {
                int dim, level;
                try {
                    dim = Integer.parseInt(pair[0]);
                } catch (NumberFormatException e) {
                    SaltyMod.logger.warn(
                        "Cannot parse DimensionID \"" + pair[0]
                            + "\" to integer point at DimCloudLevel line "
                            + (i + 1));
                    break;
                }
                try {
                    level = Integer.parseInt(pair[1]);
                } catch (NumberFormatException e) {
                    SaltyMod.logger.warn(
                        "Cannot parse CloudLevel \"" + pair[1]
                            + "\" to integer point at DimCloudLevel line "
                            + (i + 1));
                    break;
                }
                cloudLevel.put(dim, level);
            }
        }
    }
}
