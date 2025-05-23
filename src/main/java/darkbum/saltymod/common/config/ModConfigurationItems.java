package darkbum.saltymod.common.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Handles the configuration settings for item-related features in SaltyMod Expanded.
 * <p>
 * This class is responsible for defining configuration options related to items,
 * including regular items, armor/tools, and food items. The configuration values
 * are read from the "items.cfg" file and its subcategories.
 * <p>
 * This class is initialized during the pre-initialization stage of the mod lifecycle.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModConfigurationItems {

    // Category Strings
    private static final String categoryNameIte = "items";
    private static final String categoryDescriptionIte = "All the Items configuration that doesn't touch Armor, Food or Mod Compatibility";
    private static final String categoryNameIteArm = "items | armor + tools";
    private static final String categoryDescriptionIteArm = "All the Armor and Tool Items configuration";
    private static final String categoryNameIteFoo = "items | food";
    private static final String categoryDescriptionIteFoo = "All the Food Items configuration";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityStringEFR1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityStringEFR2 = " to be present";

    // Items Config Options
    public static boolean enableDeveloperFoods;

    public static boolean enableHoney;

    public static boolean enableMineralMud;

    public static boolean enableFizzyDrink;
    public static boolean fizzyDrinkEffect;
    public static boolean enableTunnelersConcoction;
    public static int tunnelersConcoctionHasteLevel;

    public static boolean enableRainmaker;

    // Armor/Tools Items Config Options
    public static boolean enableMudArmor;
    public static boolean mudArmorWaterDamage;
    public static boolean mudArmorHealthBoost;
    public static int mudArmorHealthBoostValue;
    public static boolean mudArmorBeeResistant;

    public static boolean enableSaltPickaxe;

    // Food items Config Options
    public static boolean enableDough;

    public static boolean enableOnion;

    public static boolean enableGoldenFoods;

    public static boolean enableSaltedPorkchop;
    public static boolean enableSaltedBeef;
    public static boolean enableSaltedChicken;
    public static boolean enableStrider;
    public static boolean enableHaunch;
    public static boolean enableCuredMeat;
    public static boolean enableSaltedCod;
    public static boolean enableSaltedSalmon;
    public static boolean enableTropicalFish;
    public static boolean enableTailor;
    public static boolean enableCalamari;
    public static boolean enableSaltedBread;
    public static boolean enableSaltedPotato;
    public static boolean enableEgg;

    public static boolean enableSaltedMushroomStew;
    public static boolean enableChickenSoup;
    public static boolean enableBeefStew;
    public static boolean enablePumpkinPorridge;
    public static boolean enableCactusSoup;
    public static boolean enableBoneMarrowSoup;
    public static boolean enableStewedVegetables;
    public static boolean enablePotatoMushroom;
    public static boolean enableFishSoup;
    public static boolean enableDandelionSalad;
    public static boolean enableWheatSprouts;
    public static boolean enableSaltwortSalad;

    public static boolean enableSaltwortPorkchop;
    public static boolean enableSaltwortHoneyPorkchop;
    public static boolean enableSaltwortBeef;
    public static boolean enableSaltwortStrider;
    public static boolean enableSaltwortHaunch;

    public static boolean enableSugaredApple;
    public static boolean enableSugaredMelon;

    public static boolean enableFruitSalad;
    public static boolean enableGratedCarrot;
    public static boolean enableMelonSoup;

    public static boolean enableHoneyPorkchop;
    public static boolean enableHoneyApple;
    public static boolean enableChocolateBar;

    public static boolean enableChocolatePie;
    public static boolean enableBirthdayPie;
    public static boolean replaceCake;
    public static boolean enableApplePie;
    public static boolean enableCarrotPie;
    public static boolean enableMushroomPie;
    public static boolean enablePotatoPie;
    public static boolean enableOnionPie;
    public static boolean enableShepherdsPie;
    public static boolean enableCodPie;
    public static boolean enableSalmonPie;
    public static boolean enableTropicalFishPie;
    public static boolean enableTailorPie;
    public static boolean enableCalamariPie;
    public static boolean enableSaltwortPie;

    public static boolean enableFermentedSaltwort;
    public static boolean enableFermentedFern;
    public static boolean enableFermentedMarshReeds;
    public static boolean enableFermentedMushroom;
    public static boolean enablePickledCalamari;
    public static boolean enablePickledOnion;
    public static boolean enableApplePreserves;
    public static boolean enableMelonPreserves;

    public static boolean enableMuffin;

    public static boolean enableToughJelly;

    /**
     * Initializes the item configuration settings by reading values from the provided configuration file.
     *
     * @param config The configuration file object to read from.
     */
    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameIte, categoryDescriptionIte);

        enableDeveloperFoods = config.getBoolean(
            "01-enableDeveloperFoods",
            categoryNameIte,
            false,
            enableFeatures + "\nVoid Apple (Developer Testing Item, instantly empties the hunger bar)"
                + "\nStuffing Apple (Developer Testing Item, instantly replenishes the hunger bar)"
                + "\n");

        enableHoney = config.getBoolean(
            "02-enableHoney",
            categoryNameIte,
            true,
            enableFeatures + "\nBee Larva"
                + "\nHoney Bee"
                + "\nCarpenter Bee"
                + "\nRegal Bee"
                + "\nWaxcomb"
                + "\nHoneycomb"
                + "\nRoyal Jelly"
                + "\nHoney Glazed Porkchop with Saltwort"
                + "\nHoney Glazed Porkchop"
                + "\nHoney Glazed Apple"
                + "\nHoney Glazed Sweetberries (Requires Et Futurum Requiem)"
                + "\nAn alternative Crafting Recipe for the Muffin"
                + "\n");

        enableMineralMud = config.getBoolean(
            "04-enableMineralMud",
            categoryNameIte,
            true,
            enableFeatures + "\nMineral Mud"
                + "\nWet Mud Bricks"
                + "\nMud Bricks"
                + "\nMud Brick Stairs"
                + "\nMud Brick Slab"
                + "\nMud Brick Wall (Requires Et Futurum Requiem)"
                + "\nMineral Mud Ball"
                + "\nHead Mud Mask"
                + "\nBody Mud Mask"
                + "\nLegs Mud Mask"
                + "\nFeet Mud Mask"
                + "\n");

        enableFizzyDrink = config.getBoolean(
            "05-enableFizzyDrink",
            categoryNameIte,
            true,
            enableFeatures + "\nFizzy Drink"
                + "\n");
        fizzyDrinkEffect = config.getBoolean(
            "06-fizzyDrinkEffect",
            categoryNameIte,
            false,
            "Regulates the capabilities of the Fizzy Drink (true - removes all effects, false - removes the same effects that milk removes)");

        enableTunnelersConcoction = config.getBoolean(
            "07-enableTunnelersConcoction",
            categoryNameIte,
            true,
            enableFeatures + "\nTunneler's Concoction" + "\n");
        tunnelersConcoctionHasteLevel = config.getInt(
            "08-tunnelersConcoctionHasteLevel",
            categoryNameIte,
            5,
            1,
            5,
            "Regulates the Haste level that the Tunneler's Concoction gives."
            + "\n(This config exists as a reaction to a bug that prevents arm swing when the Haste level is too high."
            + "\nIf this does not bother you, you can leave the config alone.)");

        enableRainmaker = config.getBoolean(
            "09-enableRainmaker",
            categoryNameIte,
            true,
            enableFeatures + "\nRainmaker Star" + "\nRainmaker" + "\n");

        config.setCategoryComment(categoryNameIteArm, categoryDescriptionIteArm);

        enableMudArmor = config.getBoolean(
            "01-enableMudArmor",
            categoryNameIteArm,
            true,
            enableFeatures + "\nHead Mud Mask" + "\nBody Mud Mask" + "\nLegs Mud Mask" + "\nFeet Mud Mask" + "\n");
        mudArmorWaterDamage = config.getBoolean(
            "02-mudArmorWaterDamage",
            categoryNameIteArm,
            true,
            "Enables the Water Damage mechanic for the Mud Armor, slowly degrading it in water or in the rain");
        mudArmorHealthBoost = config.getBoolean(
            "03-mudArmorHealthBoost",
            categoryNameIteArm,
            true,
            "Enables the Health Boost, that the Mud Armor gives when worn");
        mudArmorHealthBoostValue = config.getInt(
            "04-mudArmorHealthBoostValue",
            categoryNameIteArm,
            1,
            0,
            4,
            "Regulates the potency of the Health Boost effect of the Mud Armor (0 - Health Boost I, 1 - Health Boost II, etc., every level will give you 2 more hearts");
        mudArmorBeeResistant = config.getBoolean(
            "05-mudArmorBeeResistant",
            categoryNameIteArm,
            true,
            "Gives the Mud Armor a resistance against the \"Swarmed!\" Effect"
                + "\nAdditionally, by using CraftTweaker, you can also add this resistance to other armor sets at your leisure"
                + "\nTo achieve this, you open a new CraftTweaker document and input the following information:"
                + "\n"
                + "\nval beeResistant = <ore:beeResistant>;"
                + "\nbeeResistant.add(<[MODID]:[HELMETID]>);"
                + "\nbeeResistant.add(<[MODID]:[CHESTPLATEID]>);"
                + "\nbeeResistant.add(<[MODID]:[LEGGINGSID]>);"
                + "\nbeeResistant.add(<[MODID]:[BOOTSID]>);"
                + "\n");

        enableSaltPickaxe = config.getBoolean(
            "06-enableSaltPickaxe",
            categoryNameIteArm,
            true,
            enableFeatures + "\nSalt Pickaxe" + "\n");

        config.setCategoryComment(categoryNameIteFoo, categoryDescriptionIteFoo);

        enableDough = config.getBoolean(
            "01-enableDough",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nDough"
                + "\nAn alternative Crafting Recipe for the Chocolate Pie"
                + "\nAn alternative Crafting Recipe for the Birthday Pie"
                + "\nAn alternative Crafting Recipe for the Shepherd's Pie"
                + "\nAn alternative Crafting Recipe for the Cod Pie"
                + "\nAn alternative Crafting Recipe for the Salmon Pie"
                + "\nAn alternative Crafting Recipe for the Tropical Fish Pie"
                + "\nAn alternative Crafting Recipe for the Tailor Pie"
                + "\nAn alternative Crafting Recipe for the Calamari Pie"
                + "\nAn alternative Crafting Recipe for the Saltwort Pie"
                + "\nAn alternative Crafting Recipe for the Muffin"
                + "\nAn alternative Crafting Recipe for the Bread"
                + "\nAn alternative Crafting Recipe for the Cake"
                + "\nAn alternative Crafting Recipe for the Cookie"
                + "\nAn alternative Crafting Recipe for the Pumpkin Pie"
                + "\n");

        enableOnion = config.getBoolean(
            "02-enableOnion",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nOnion"
                + "\nOnion Crate"
                + "\nDandelion Salad"
                + "\nSalted Dandelion Salad"
                + "\nDressed Herring (Requires Et Futurum Requiem)"
                + "\nSalted Dressed Herring (Requires Et Futurum Requiem)"
                + "\nOnion Pie"
                + "\nPickled Onion"
                + "\n");

        enableGoldenFoods = config.getBoolean(
            "03-enableGoldenFoods",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nGolden Saltwort"
                + "\nGolden Potato"
                + "\nGolden Sweetberries (Requires Et Futurum Requiem)"
                + "\nGolden Vegetables"
                + "\nSalted Golden Vegetables"
                + "\nGolden Saltwort Salad"
                + "\nGolden Fruit Salad"
                + "\nSugared Golden Fruit Salad"
                + "\n");

        enableSaltedPorkchop = config.getBoolean(
            "04-enableSaltedPorkchop",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Cooked Porkchop" + "\nSalted Cooked Porkchop with Saltwort" + "\n");
        enableSaltedBeef = config.getBoolean(
            "05-enableSaltedBeef",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Steak" + "\nSalted Steak with Saltwort" + "\n");
        enableSaltedChicken = config
            .getBoolean("06-enableSaltedChicken", categoryNameIteFoo, true, enableFeatures + "\nSalted Chicken" + "\n");
        enableStrider = config.getBoolean(
            "07-enableStrider",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nRaw Strider Flank"
                + "\nStrider Steak"
                + "\nSalted Strider Steak"
                + "\nSalted Strider Steak with Saltwort"
                + "\nNotes: This idea has been shamelessly stolen from Netherlicious. Though, since Et Futurum Requiem currently doesn't add Striders, and Netherlicious already has Strider meat, this meat drops from Bats instead for now"
                + "\n");
        enableHaunch = config.getBoolean(
            "08-enableHaunch",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nRaw Haunch"
                + "\nCooked Haunch"
                + "\nSalted Cooked Haunch"
                + "\nSalted Cooked Haunch with Saltwort"
                + "\n");
        enableCuredMeat = config
            .getBoolean("09-enableCuredMeat", categoryNameIteFoo, true, enableFeatures + "\nCured Meat" + "\n");
        enableSaltedCod = config.getBoolean(
            "10-enableSaltedCod",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Cooked Cod"
                + "\nNotes: This is in line with the texture and localization changes this mod makes to the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions"
                + "\n");
        enableSaltedSalmon = config.getBoolean(
            "11-enableSaltedSalmon",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Cooked Salmon" + "\n");
        enableTropicalFish = config.getBoolean(
            "12-enableTropicalFish",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nCooked Tropical Fish"
                + "\nSalted Cooked Tropical Fish"
                + "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 2), to better reflect the modern Minecraft versions"
                + "\n");
        enableTailor = config.getBoolean(
            "13-enableTailor",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nTailor"
                + "\nCooked Tailor"
                + "\nSalted Cooked Tailor"
                + "\nTailor Pie"
                + "\nNotes: This replaces the vanilla Fish (with the meta value of 0) in texture, to better reflect the modern Minecraft versions"
                + "\n");
        enableCalamari = config.getBoolean(
            "14-enableCalamari",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nRaw Calamari"
                + "\nCooked Calamari"
                + "\nSalted Cooked Calamari"
                + "\nCalamari Pie"
                + "\nPickled Calamari"
                + "\n");
        enableSaltedBread = config
            .getBoolean("15-enableSaltedBread", categoryNameIteFoo, true, enableFeatures + "\nSalted Bread" + "\n");
        enableSaltedPotato = config
            .getBoolean("16-enableSaltedPotato", categoryNameIteFoo, true, enableFeatures + "\nSalted Baked Potato" + "\n");
        enableEgg = config
            .getBoolean("17-enableEgg", categoryNameIteFoo, true, enableFeatures + "\nSoft-Boiled Egg" + "\n");

        enableSaltedMushroomStew = config.getBoolean(
            "18-enableSaltedMushroomStew",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Mushroom Stew" + "\n");

        enableChickenSoup = config.getBoolean(
            "20-enableChickenSoup",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nChicken Soup" + "\nSalted Chicken Soup" + "\n");
        enableBeefStew = config.getBoolean(
            "21-enableBeefStew",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nBeef Stew" + "\nSalted Beef Stew" + "\n");
        enablePumpkinPorridge = config.getBoolean(
            "22-enablePumpkinPorridge",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nPumpkin Porridge" + "\nSalted Pumpkin Porridge" + "\n");
        enableCactusSoup = config.getBoolean(
            "21-enableCactusSoup",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nCactus Soup" + "\nSalted Cactus Soup" + "\n");
        enableBoneMarrowSoup = config.getBoolean(
            "22-enableBoneMarrowSoup",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nBone Marrow Soup" + "\nSalted Bone Marrow Soup" + "\n");
        enableStewedVegetables = config.getBoolean(
            "23-enableStewedVegetables",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nStewed Vegetables" + "\nSalted Stewed Vegetables" + "\n");
        enablePotatoMushroom = config.getBoolean(
            "24-enablePotatoMushroom",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nPotato with Mushroom" + "\nSalted Potato with Mushroom" + "\n");
        enableFishSoup = config.getBoolean(
            "25-enableFishSoup",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nFish Soup" + "\nSalted Fish Soup" + "\n");
        enableDandelionSalad = config.getBoolean(
            "26-enableDandelionSalad",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nDandelion Salad" + "\nSalted Dandelion Salad" + "\n");
        enableWheatSprouts = config.getBoolean(
            "27-enableWheatSprouts",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nWheat Sprouts" + "\nSalted Wheat Sprouts" + "\n");
        enableSaltwortSalad = config
            .getBoolean("28-enableSaltwortSalad", categoryNameIteFoo, true, enableFeatures + "\nSaltwort Salad" + "\n");

        enableSaltwortPorkchop = config.getBoolean(
            "29-enableSaltwortPorkchop",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Cooked Porkchop with Saltwort" + "\n");
        enableSaltwortHoneyPorkchop = config.getBoolean(
            "30-enableSaltwortHoneyPorkchop",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nHoney Glazed Porkchop with Saltwort" + "\n");
        enableSaltwortBeef = config.getBoolean(
            "31-enableSaltwortBeef",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Steak with Saltwort" + "\n");
        enableSaltwortStrider = config.getBoolean(
            "32-enableSaltwortStrider",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Strider Steak with Saltwort" + "\n");
        enableSaltwortHaunch = config.getBoolean(
            "33-enableSaltwortHaunch",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nSalted Cooked Haunch with Saltwort" + "\n");

        enableSugaredApple = config
            .getBoolean("34-enableSugaredApple", categoryNameIteFoo, true, enableFeatures + "\nSugared Apple" + "\n");
        enableSugaredMelon = config
            .getBoolean("35-enableSugaredMelon", categoryNameIteFoo, true, enableFeatures + "\nSugared Melon Slice" + "\n");

        enableFruitSalad = config.getBoolean(
            "36-enableFruitSalad",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nFruit Salad" + "\nSugared Fruit Salad" + "\n");
        enableGratedCarrot = config.getBoolean(
            "37-enableGratedCarrot",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nGrated Carrot" + "\nSugared Grated Carrot" + "\n");
        enableMelonSoup = config.getBoolean(
            "38-enableMelonSoup",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nMelon Soup" + "\nSugared Melon Soup" + "\n");

        enableHoneyPorkchop = config.getBoolean(
            "39-enableHoneyPorkchop",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nHoney Glazed Porkchop" + "\n");
        enableHoneyApple = config
            .getBoolean("40-enableHoneyApple", categoryNameIteFoo, true, enableFeatures + "\nHoney Glazed Apple" + "\n");
        enableChocolateBar = config
            .getBoolean("41-enableChocolateBar", categoryNameIteFoo, true, enableFeatures + "\nChocolate Bar" + "\n");

        enableChocolatePie = config
            .getBoolean("42-enableChocolatePie", categoryNameIteFoo, true, enableFeatures + "\nChocolate Pie" + "\n");
        enableBirthdayPie = config
            .getBoolean("43-enableBirthdayPie", categoryNameIteFoo, true, enableFeatures + "\nBirthday Pie" + "\n");
        replaceCake = config.getBoolean(
            "44-replaceCake",
            categoryNameIteFoo,
            false,
            "Disables the Crafting Recipe for Cake, effectively replacing the Cake with the Birthday Pie");

        enableApplePie = config
            .getBoolean("45-enableApplePie", categoryNameIteFoo, true, enableFeatures + "\nApple Pie" + "\n");
        enableCarrotPie = config
            .getBoolean("46-enableCarrotPie", categoryNameIteFoo, true, enableFeatures + "\nCarrot Pie" + "\n");
        enableMushroomPie = config
            .getBoolean("47-enableMushroomPie", categoryNameIteFoo, true, enableFeatures + "\nMushroom Pie" + "\n");
        enablePotatoPie = config
            .getBoolean("48-enablePotatoPie", categoryNameIteFoo, true, enableFeatures + "\nPotato Pie" + "\n");
        enableOnionPie = config
            .getBoolean("49-enableOnionPie", categoryNameIteFoo, true, enableFeatures + "\nOnion Pie" + "\n");
        enableShepherdsPie = config
            .getBoolean("50-enableShepherdsPie", categoryNameIteFoo, true, enableFeatures + "\nShepherd's Pie" + "\n");
        enableCodPie = config.getBoolean(
            "51-enableCodPie",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nCod Pie"
                + "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions"
                + "\n");
        enableSalmonPie = config
            .getBoolean("52-enableSalmonPie", categoryNameIteFoo, true, enableFeatures + "\nSalmon Pie" + "\n");
        enableTropicalFishPie = config.getBoolean(
            "53-enableTropicalFishPie",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nTropical Fish Pie"
                + "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 2), to better reflect the modern Minecraft versions"
                + "\n");
        enableTailorPie = config.getBoolean(
            "54-enableTailorPie",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nTailor Pie"
                + "\nNotes: This replaces an obligatory \"Fish Pie\" that would be named after the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions"
                + "\n");
        enableCalamariPie = config
            .getBoolean("55-enableCalamariPie", categoryNameIteFoo, true, enableFeatures + "\nCalamari Pie" + "\n");
        enableSaltwortPie = config
            .getBoolean("56-enableSaltwortPie", categoryNameIteFoo, true, enableFeatures + "\nSaltwort Pie" + "\n");

        enableFermentedSaltwort = config.getBoolean(
            "57-enableFermentedSaltwort",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nFermented Saltwort" + "\n");
        enableFermentedFern = config
            .getBoolean("58-enableFermentedFern", categoryNameIteFoo, true, enableFeatures + "\nFermented Fern" + "\n");
        enableFermentedMarshReeds = config
            .getBoolean("59-enableFermentedMarshReeds", categoryNameIteFoo, true, enableFeatures + "\nFermented Marhs Reeds" + "\n");
        enableFermentedMushroom = config.getBoolean(
            "60-enableFermentedMushroom",
            categoryNameIteFoo,
            true,
            enableFeatures + "\nFermented Mushroom" + "\n");
        enablePickledCalamari = config
            .getBoolean("61-enablePickledCalamari", categoryNameIteFoo, true, enableFeatures + "\nPickled Calamari" + "\n");
        enablePickledOnion = config
            .getBoolean("62-enablePickledOnion", categoryNameIteFoo, true, enableFeatures + "\nPickled Onion" + "\n");
        enableApplePreserves = config
            .getBoolean("63-enableApplePreserves", categoryNameIteFoo, true, enableFeatures + "\nApple Preserves" + "\n");
        enableMelonPreserves = config
            .getBoolean("64-enableMelonPreserves", categoryNameIteFoo, true, enableFeatures + "\nMelon Preserves" + "\n");

        enableMuffin = config.getBoolean("65-enableMuffin", categoryNameIteFoo, true, enableFeatures + "\nMuffin" + "\n");

        enableToughJelly = config
            .getBoolean("66-enableToughJelly", categoryNameIteFoo, true, enableFeatures + "\nTough Jelly" + "\n");
    }
}
