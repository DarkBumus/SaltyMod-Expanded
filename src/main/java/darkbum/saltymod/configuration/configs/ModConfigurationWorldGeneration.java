package darkbum.saltymod.configuration.configs;

import net.minecraftforge.common.config.Configuration;

public class ModConfigurationWorldGeneration {

    // Category Strings
    private static final String categoryNameWor = "world generation";
    private static final String categoryDescriptionWor = "All the World Generation configuration that doesn't touch Biomes or Structures";
    private static final String categoryNameWorBio = "world generation | biomes";
    private static final String categoryDescriptionWorBio = "All the World Generation Biomes configuration";
    private static final String categoryNameWorStr = "world generation | structures";
    private static final String categoryDescriptionWorStr = "All the World Generation Structures configuration";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityString1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityString2 = " to be present";

    // Config Options WorldGeneration
    public static int saltOreFrequency;
    public static int saltoreVeinSize;

    // Config Options WorldGenerationBiomes
    public static boolean enableSaltMarsh;
    public static int saltMarshBiomeID;
    public static int saltMarshBiomeWeight;
    public static boolean saltMarshAdditionalSaltOre;
    public static int saltMarshSaltOreFrequency;
    public static int marshReedUpdateFrequency;

    // Config Options WorldGenerationStructures
    public static boolean enableSaltLakes;
    public static int saltLakeFrequency;
    public static int saltLakeQuantity;
    public static int saltLakeDistance;
    public static int saltLakeRadius;

    public static boolean enableBrickmakerCamp;
    public static int brickmakerCampFrequency;

    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameWor, categoryDescriptionWor);

        saltOreFrequency = config.getInt(
            "01-saltOreFrequency",
            categoryNameWor,
            4,
            1,
            10,
            "Regulates the frequency of the Salt Ore Generation");
        saltoreVeinSize = config
            .getInt("02-saltoreVeinSize", categoryNameWor, 5, 1, 10, "Regulates the size of Salt Ore veins");

        config.setCategoryComment(categoryNameWorBio, categoryDescriptionWorBio);

        enableSaltMarsh = config.getBoolean(
            "01-enableSaltMarsh",
            categoryNameWorBio,
            true,
            enableFeatures
                + "\nSalt Marsh"
                + "\nSalt Crusted Oak Logs"
                + "\nMarsh Reeds"
                + "\n");
        saltMarshBiomeID = config.getInt(
            "02-saltMarshBiomeID",
            categoryNameWorBio,
            40,
            40,
            40,
            "Sets the Biome ID of the Salt Marsh Biome, setting this to \"-1\" completely disables the Biome");
        saltMarshBiomeWeight = config.getInt(
            "03-saltMarshBiomeWeight",
            categoryNameWorBio,
            10,
            10,
            10,
            "Regulates the Generation chance of Salt Marsh Biomes");
        saltMarshAdditionalSaltOre = config.getBoolean(
            "04-saltMarshAdditionalSaltOre",
            categoryNameWorBio,
            true,
            "Enables additional Salt Ore Generation in Salt Marsh Biomes");
        saltMarshSaltOreFrequency = config.getInt(
            "05-saltMarshSaltOreFrequency",
            categoryNameWorBio,
            4,
            1,
            10,
            "Regulates the frequency of the additional Salt Ore Generation in Salt Marsh Biomes");
        marshReedUpdateFrequency = config.getInt(
            "06-marshReedUpdateFrequency",
            categoryNameWorBio,
            25,
            1,
            100,
            "Regulates the chance in % at which Marsh Reeds will check for an update in case their placement is invalid."
            + "\nIf you don't know what this means, leave the value as it is. However, if you fear for performance,"
            + "\ndon't raise this value over ~35. Too many update checks will certainly impact your performance,"
            + "especially when you're in a Salt Marsh with many Marsh Reeds."
            + "\n");

        config.setCategoryComment(categoryNameWorStr, categoryDescriptionWorStr);

        enableSaltLakes = config.getBoolean(
            "01-enableSaltLakes",
            categoryNameWorStr,
            true,
            enableFeatures + "\nSalt Lake" + "\nSalt Lake Bottom" + "\n");
        saltLakeFrequency = config.getInt(
            "02-saltLakeFrequency",
            categoryNameWorStr,
            500,
            1,
            1000,
            "Regulates the frequency of the Salt Lake Group Generation");
        saltLakeQuantity = config.getInt(
            "03-saltLakeQuantity",
            categoryNameWorStr,
            5,
            1,
            10,
            "Regulates the quantity of single Salt Lakes in Salt Lake Groups");
        saltLakeDistance = config.getInt(
            "04-saltLakeDistance",
            categoryNameWorStr,
            30,
            10,
            50,
            "Regulates the distance between single Salt Lakes in Salt Lake Groups");
        saltLakeRadius = config.getInt(
            "05-saltLakeRadius",
            categoryNameWorStr,
            20,
            5,
            50,
            "Regulates the radius of single Salt Lakes");

        enableBrickmakerCamp = config.getBoolean(
            "06-enableBrickmakerCamps",
            categoryNameWorStr,
            true,
            enableFeatures + "\nBrickmaker Camp" + "\n");
        brickmakerCampFrequency = config.getInt(
            "07-brickmakerCampFrequency",
            categoryNameWorStr,
            300,
            10,
            1000,
            "Regulates the frequency of the Brickmaker Camp Generation in Salt Marsh Biomes");
    }
}
