package darkbum.saltymod.configuration.configs;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ModConfigurationModCompatibility {

    // Category Strings
    private static final String categoryNameMod = "mod compatibility";
    private static final String categoryDescriptionMod = "All the Mod Compatibility configuration that doesn't touch Blocks or Items";
    private static final String categoryNameModBlo = "mod compatibility | blocks";
    private static final String categoryDescriptionModBlo = "All the Mod Compatibility Blocks configuration";
    private static final String categoryNameModIte = "mod compatibility | items";
    private static final String categoryDescriptionModIte = "All the Mod Compatibility Items configuration";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityStringEFR1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityStringEFR2 = " to be present";

    // Mod Compatibility Config Options
    public static boolean enableEFRFoodValueChanges;
    public static boolean enableEFRStewsStacksize16;

    public static int TFDimensionID;
    public static boolean enableTFSaltOre;

    // Mod Compatibility Blocks Config Options
    public static boolean enableMudBrickWall;

    // Mod Compatibility Items Config Options
    public static boolean enableSaltedRabbit;
    public static boolean enableSaltedMutton;
    public static boolean enableSaltedBeetroot;
    public static boolean enableSaltedRabbitRagout;
    public static boolean enableSaltedBorscht;
    public static boolean enableBeetrootSalad;
    public static boolean enableDressedHerring;
    public static boolean enableSaltwortMutton;
    public static boolean enableSugaredBerries;
    public static boolean enableHoneyBerries;
    public static boolean enableChocolateBerries;
    public static boolean enableBerryPie;
    public static boolean enablePickledBeetroot;
    public static boolean enableBerryPreserves;

    public static boolean enableEFRHoneyCompatibility;

    public static boolean enableTFFoods;

    public static boolean enableBOPFoods;

    public static boolean enableWMFoods;

    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameMod, categoryDescriptionMod);

        enableEFRFoodValueChanges = config.getBoolean(
            "01-enableEFRFoodValueChanges",
            categoryNameMod,
            true,
            "Changes the food values of the Et Futurum Requiem Foods, to better fit the new balancing:"
                + "\nRaw Mutton - 2 | 0.6F"
                + "\nCooked Mutton - 4 | 0.6F"
                + "\nRaw Rabbit - 1 | 0.6F"
                + "\nCooked Rabbit - 3 | 0.6F"
                + "\nRabbit Ragout - 7 | 0.7F"
                + "\nBeetroot - 1 | 0.3F"
                + "\nBorscht - 5 | 0.7F"
                + "\nChorus Fruit - 1 | 0.3F"
                + "\nSuspicious Stew - 5 | 0.7F"
                + "\nSweetberries - 1 | 0.3F"
                + "\nNotes: The first value refers to the number of half hunger shanks the respective item returns. The second value refers to the saturation. For a more detailed understanding, refer to this table and halve the \"Saturation Ratio\" values depicted there: https://minecraft.wiki/w/Food#Foods"
                + "\n");

        enableEFRStewsStacksize16 = config.getBoolean(
            "02-enableEFRStewsStacksize16",
            categoryNameMod,
            true,
            "Changes the maximum stacksize of Et Futurum Requiem's Stews to 16."
                + "\nThis only changes the stacksize of Et Futurum Requiem's stews. For Mushroom Stew, see vanilla_changes.cfg."
                + "\n");

        enableTFSaltOre = config.getBoolean(
            "03-enableTFSaltOre",
            categoryNameMod,
            true,
            "Enables Salt Ore Generation in the Twilight Forest Dimension");

        config.setCategoryComment(categoryNameModBlo, categoryDescriptionModBlo);

        enableMudBrickWall = config.getBoolean(
            "01-enableMudBrickWall",
            categoryNameModBlo,
            true,
            enableFeatures + "\nMud Brick Wall"
                + "\n"
                + compatibilityStringEFR1
                + "Mud Brick Wall"
                + compatibilityStringEFR2
                + "\n");

        config.setCategoryComment(categoryNameModIte, categoryDescriptionModIte);

        enableSaltedRabbit = config.getBoolean(
            "01-enableSaltedRabbit",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Cooked Rabbit"
                + "\n"
                + compatibilityStringEFR1
                + "Salted Cooked Rabbit"
                + compatibilityStringEFR2
                + "\n");
        enableSaltedMutton = config.getBoolean(
            "02-enableSaltedMutton",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Cooked Mutton"
                + "\n"
                + compatibilityStringEFR1
                + "Salted Cooked Mutton"
                + compatibilityStringEFR2
                + "\n");
        enableSaltedBeetroot = config.getBoolean(
            "03-enableSaltedBeetroot",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Beetroot"
                + "\n"
                + compatibilityStringEFR1
                + "Salted Beetroot"
                + compatibilityStringEFR2
                + "\n");
        enableSaltedRabbitRagout = config.getBoolean(
            "04-enableSaltedRabbitRagout",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Rabbit Ragout"
                + "\n"
                + compatibilityStringEFR1
                + "Salted Rabbit Ragout"
                + compatibilityStringEFR2
                + "\n");
        enableSaltedBorscht = config.getBoolean(
            "05-enableSaltedBorscht",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Borscht"
                + "\n"
                + compatibilityStringEFR1
                + "Salted Borscht"
                + compatibilityStringEFR2
                + "\n");

        enableBeetrootSalad = config.getBoolean(
            "06-enableBeetrootSalad",
            categoryNameModIte,
            true,
            enableFeatures + "\nBeetroot Salad"
                + "\nSalted Beetroot Salad"
                + "\n"
                + compatibilityStringEFR1
                + "Beetroot Salad and Salted Beetroot Salad"
                + compatibilityStringEFR2
                + "\n");
        enableDressedHerring = config.getBoolean(
            "07-enableDressedHerring",
            categoryNameModIte,
            true,
            enableFeatures + "\nDressed Herring"
                + "\nSalted Dressed Herring"
                + "\n"
                + compatibilityStringEFR1
                + "Dressed Herring and Salted Dressed Herring"
                + compatibilityStringEFR2
                + "\n");
        enableSaltwortMutton = config.getBoolean(
            "08-enableSaltwortMutton",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Cooked Mutton with Saltwort"
                + "\n"
                + compatibilityStringEFR1
                + "Salted Cooked Mutton with Saltwort"
                + compatibilityStringEFR2
                + "\n");
        enableSugaredBerries = config.getBoolean(
            "09-enableSugaredBerries",
            categoryNameModIte,
            true,
            enableFeatures + "\nSugared Sweetberries"
                + "\n"
                + compatibilityStringEFR1
                + "Sugared Sweetberries"
                + compatibilityStringEFR2
                + "\n");
        enableHoneyBerries = config.getBoolean(
            "10-enableHoneyBerries",
            categoryNameModIte,
            true,
            enableFeatures + "\nHoney Glazed Sweetberries"
                + "\n"
                + compatibilityStringEFR1
                + "Honey Glazed Sweetberries"
                + compatibilityStringEFR2
                + "\n");
        enableChocolateBerries = config.getBoolean(
            "11-enableChocolateBerries",
            categoryNameModIte,
            true,
            enableFeatures + "\nChocolate Laced Sweetberries"
                + "\n"
                + compatibilityStringEFR1
                + "Chocolate Laced Sweetberries"
                + compatibilityStringEFR2
                + "\n");
        enableBerryPie = config.getBoolean(
            "12-enableBerryPie",
            categoryNameModIte,
            true,
            enableFeatures + "\nSweetberry Pie"
                + "\n"
                + compatibilityStringEFR1
                + "Sweetberry Pie"
                + compatibilityStringEFR2
                + "\n");
        enablePickledBeetroot = config.getBoolean(
            "13-enablePickledBeetroot",
            categoryNameModIte,
            true,
            enableFeatures + "\nPickled Beetroot"
                + "\n"
                + compatibilityStringEFR1
                + "Pickled Beetroot"
                + compatibilityStringEFR2
                + "\n");
        enableBerryPreserves = config.getBoolean(
            "14-enableBerryPreserves",
            categoryNameModIte,
            true,
            enableFeatures + "\nSweetberry Preserves"
                + "\n"
                + compatibilityStringEFR1
                + "Sweetberry Preserves"
                + compatibilityStringEFR2
                + "\n");

        enableEFRHoneyCompatibility = config.getBoolean(
            "03-enableEFRHoneyCompatibility",
            categoryNameModIte,
            true,
            "Integrates SaltyMod's Honey into Et Futurum Requiem's Honey as best as possible."
                + "\nWith this option active, Et Futurum Requiem's Honeycombs will be taken out of all possible recipes, so it can't be collected."
                + "\nHoney Bottles will become craftable with SaltyMod's Honeycombs and Honeycomb Blocks will become craftable with SaltyMod's Waxcombs."
                + "\nIt is recommended to deactivate Et Futurum Requiem's Bees in the entities.cfg and deactivate Et Futurum Requiem's Honeycomb with CraftTweaker.");

        enableTFFoods = config.getBoolean(
            "15-enableTFFoods",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Venison Steak"
                + "\nSalted Meef Steak"
                + "\nSalted Meef Stroganoff"
                + "\nSalted Hyrda Chop"
                + "\nPickled Mushgloom"
                + "\nVenison Steak with Saltwort"
                + "\nMeef Steak with Saltwort"
                + "\nNotes: This is for when you have Twilight Forest installed, but for some reason, don't want the respective Foods to be present"
                + "\n");

        enableBOPFoods = config.getBoolean(
            "16-enableBOPFoods",
            categoryNameModIte,
            true,
            enableFeatures + "\nHemoglobin"
                + "\nPoison"
                + "\nSalted Shroom Powder"
                + "\nSugared Fruit Salad"
                + "\nSalted Veggie Salad"
                + "\nSalted Shroom Salad"
                + "\nSalted Bowl of Rice"
                + "\nPickled Turnip"
                + "\nNotes: This is for when you have Biomes O'Plenty installed, but for some reason, don't want the respective Foods to be present"
                + "\n");

        enableWMFoods = config.getBoolean(
            "17-enableWMFoods",
            categoryNameModIte,
            true,
            enableFeatures + "\nSalted Cooked Bison"
            + "\nSalted Cooked Calamario (Wild Mobs)"
            + "\nSalted Cooked Chevon"
            + "\nSalted Cooked Goose"
            + "\nSalted Cooked Mouse"
            + "\nSalted Cooked Venison"
            + "\nNotes: This is for when you have Wild Mobs installed, but for some reason, don't want the respective Foods to be present"
            + "\n");

        Configuration configTF = new Configuration(new File("./config", "TwilightForest.cfg"));
        configTF.load();
        TFDimensionID = configTF.get("mod compatibility", "TFDimensionID", 7)
            .getInt();
    }
}
