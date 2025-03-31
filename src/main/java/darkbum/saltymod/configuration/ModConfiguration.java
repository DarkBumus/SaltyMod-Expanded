package darkbum.saltymod.configuration;

import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.init.ModBlocks;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ModConfiguration extends Configuration {

    // Categories
    private static final String categoryNotes = "--- notes ---";
    private static final String categoryBlocks = "blocks";
    private static final String categoryEffects = "effects";
    private static final String categoryItems = "items";
    private static final String categoryItemsArmor = "items | armor";
    private static final String categoryItemsFood = "items | food items";
    private static final String categoryModCompatibility = "mod compatibility";
    private static final String categoryModCompatibilityBlocks = "mod compatibility | blocks";
    private static final String categoryModCompatibilityItems = "mod compatibility | items";
    private static final String categoryVanillaChanges = "vanilla changes";
    private static final String categoryWorldGeneration = "world generation";
    private static final String categoryWorldGenerationBiomes = "world generation | biomes";
    private static final String categoryWorldGenerationStructures = "world generation | structures";
    private static final String categoryTOBEPHASEDOUT = "zzz to be phased out zzz";


    // Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityString1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityString2 = " to be present";


    // Config Options Blocks
    public static boolean enableSaltBlocks;

    public static boolean enableSaltDirt;

    public static boolean enableMudBricks;
    public static boolean complexMudBricks;

//    public static boolean enableBlossom;
//    public static boolean blossomDoorCraftingRecipe;

    public static boolean enableEvaporator;
    public static int evaporatorVolume;

    public static boolean enableFishFarm;

    public static boolean enableStorageBlocks;

    public static boolean enableSaltCrystal;
    public static int saltCrystalGrowthSpeed;

    public static int saltwortGrowthSpeed;

    public static boolean enableSaltFlowers;


    // Config Options Effects
    public static int swarmedEffectID;

    public static int wellFedEffectID;


    // Config Options Items
    public static boolean enableDeveloperFoods;

    public static boolean enableHoney;

    public static boolean enableMineralMud;

    public static boolean enableFizzyDrink;
    public static boolean fizzyDrinkEffect;
    public static boolean enableTunnelersConcoction;

    public static boolean enableMudArmor;
    public static boolean mudArmorWaterDamage;
    public static boolean mudArmorHealthBoost;
    public static int mudArmorHealthBoostValue;
    public static boolean mudArmorBeeResistant;

    public static boolean enableRainmaker;


    // Config Options ItemsFood
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

    public static boolean enablePumpkinPorridge;
    public static boolean enableCactusSoup;
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
    public static boolean enableFermentedMushroom;
    public static boolean enablePickledCalamari;
    public static boolean enablePickledOnion;
    public static boolean enableApplePreserves;
    public static boolean enableMelonPreserves;

    public static boolean enableMuffin;

    public static boolean enableToughJelly;


    // Config Options ModCompatibility
    public static boolean enableEFRFoodValueChanges;

    public static int TFDimensionID;
    public static boolean enableTFSaltOre;


    // Config Options ModCompatibilityBlocks
    public static boolean enableMudBrickWall;
    public static boolean enableBlossomWood;
    public static boolean enableStrippedBlossomLogs;
    public static boolean enableStrippedBlossomWood;
    public static boolean enableBlossomFence;
    public static boolean enableBlossomFenceGate;
    public static boolean enableBlossomPressurePlate;
    public static boolean enableBlossomButton;
    public static boolean enableBlossomDoor;
    public static boolean enableBlossomTrapdoor;
    public static boolean enableBlossomSign;


    // Config Options ModCompatbilityItems
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

    public static boolean enableBOPFoods;

    public static boolean enableTFFoods;


    // Config Options VanillaChanges
    public static boolean enableVanillaFoodValueChanges;

    public static boolean enableRecipeChanges;


    // Config Options WorldGeneration
    public static int saltOreFrequency;
    public static int saltoreVeinSize;


    // Config Options WorldGenerationBiomes
    public static boolean enableSaltMarsh;
    public static int saltMarshBiomeID;
    public static int saltMarshBiomeWeight;
    public static boolean saltMarshAdditionalSaltOre;
    public static int saltMarshSaltOreFrequency;


    // Config Options WorldGenerationStructures
    public static boolean enableSaltLakes;
    public static int saltLakeFrequency;
    public static int saltLakeQuantity;
    public static int saltLakeDistance;
    public static int saltLakeRadius;

    public static boolean enableBrickmakerCamp;
    public static int brickmakerCampFrequency;


    // Config Options TOBEPHASEDOUT
    public static Map<Integer, Integer> cloudLevel;
    private String[] loadedCloudLevel;


    // File
    private File file;

    public ModConfiguration(File file) {
        super(file);
        this.file = file;
        setCategoryComment(categoryNotes, "This isn't a separate Configuration category, this is just a little \"Note Pad\" of sorts, where I put information that doesn't fit into the other categories and should be displayed right at the top of the file." +
            "\nDue to the way Forge set up Configuration files, all the settings will be sorted in alphabetical order. That's the only reason for the numbers that appear before the Configuration options." +
            "\nAlso, keep in mind that there are multiple Configuration options that enable the same exact feature. You will have to enable all of them to have the feature be present." +
            "\nThere are only a few features that cannot be deactivated. Salt Ore, Salt Deepslate Ore, Baking Soda, Salt, Salt Pinch, Sugar Pinch, Saltwort");
        setCategoryComment(categoryBlocks, "All the Blocks configuration that doesn't touch Mod Compatibility");
        setCategoryComment(categoryEffects, "All the Effects configuration");
        setCategoryComment(categoryItems, "All the Items configuration that doesn't touch Armor, Food or Mod Compatibility");
        setCategoryComment(categoryItemsArmor, "All the Armor Items configuration");
        setCategoryComment(categoryItemsFood, "All the Food Items configuration");
        setCategoryComment(categoryModCompatibility, "All the Mod Compatibility configuration that doesn't touch Blocks or Items");
        setCategoryComment(categoryModCompatibilityBlocks, "All the Mod Compatibility Blocks configuration");
        setCategoryComment(categoryModCompatibilityItems, "All the Mod Compatibility Items configuration");
        setCategoryComment(categoryVanillaChanges, "All the Vanilla Changes configuration");
        setCategoryComment(categoryWorldGeneration, "All the World Generation configuration that doesn't touch Biomes or Structures");
        setCategoryComment(categoryWorldGenerationBiomes, "All the World Generation Biomes configuration");
        setCategoryComment(categoryWorldGenerationStructures, "All the World Generation Structures configuration");
        setCategoryComment(categoryTOBEPHASEDOUT, "TO BE PHASED OUT | IGNORE");
    }

    public void preInit() {
        String[] defaultCloudLevel = { "0=128", "7=160" }; //TOBEPHASEDOUT
        load();

        enableSaltBlocks = getBoolean("01-enableSaltBlocks", categoryBlocks, true, enableFeatures +
            "\nSalt Block" +
            "\nChiseled Salt Block" +
            "\nSalt Pillar" +
            "\nSalt Bricks" +
            "\nCracked Salt Block" +
            "\nCracked Salt Bricks" +
            "\nChiseled Salt Bricks" +
            "\nSalt Chapiter" +
            "\nSalt Brick Stairs" +
            "\nSalt Slab" +
            "\nSalt Brick Slab" +
            "\nSalt Pillar Slab" +
            "\nSalt Lamp" +
            "\n");

        enableSaltDirt = getBoolean("02-enableSaltDirt", categoryBlocks, true, enableFeatures +
            "\nSalt Grass" +
            "\nSalt Dirt" +
            "\n");

        enableMudBricks = getBoolean("03-enableMudBricks", categoryBlocks, true, enableFeatures +
            "\nWet Mud Bricks" +
            "\nMud Bricks" +
            "\nMud Brick Stairs" +
            "\nMud Brick Slab" +
            "\nMud Brick Wall (Requires Et Futurum Requiem)" +
            "\n");
        complexMudBricks = getBoolean("04-complexMudBricks", categoryBlocks, true, "Enables the a complex drying mechanic on Wet Mud Bricks (by enabling their random tick functionality) and disables the furnace recipe");

/*        enableBlossom = getBoolean("05-enableBlossom", categoryBlocks, true, enableFeatures +
            "\nBlossom Planks" +
            "\nBlossom Sapling" +
            "\nBlossom Log" +
            "\nBlossom Wood" +
            "\nStripped Blossom Log" +
            "\nStripped Blossom Wood (Requires Et Futurum Requiem)" +
            "\nBlossom Leaves" +
            "\nBlossom Slab" +
            "\nBlossom Stairs" +
            "\nBlossom Fence (Requires Et Futurum Requiem)" +
            "\nBlossom Fence Gate (Requires Et Futurum Requiem)" +
            "\nBlossom Pressure Plate (Requires Et Futurum Requiem)" +
            "\nBlossom Button (Requires Et Futurum Requiem)" +
            "\nBlossom Door (Requires Et Futurum Requiem)" +
            "\nBlossom Trapdoor (Requires Et Futurum Requiem)" +
            "\nBlossom Boat (Requires Et Futurum Requiem)" +
            "\nBlossom Chest Boat (Requires Et Futurum Requiem)" +
            "\nBlossom Sign (Requires Et Futurum Requiem)" +
            "\nBlossom" +
            "\n");

        blossomDoorCraftingRecipe = getBoolean("06-blossomDoorCraftingRecipe", categoryBlocks, true, "Changes the Blossom Door Crafting Recipe to output 3 instead of 1 item");*/

        enableEvaporator = getBoolean("05-enableEvaporator", categoryBlocks, true, enableFeatures +
            "\nEvaporator" +
            "\nPowdered Milk" +
            "\n");
        evaporatorVolume = getInt("06-evaporatorVolume", categoryBlocks, 1, 1, 3, "Regulates the number of buckets that can be poured into an evaporator at once");

        enableFishFarm = getBoolean("07-enableFishFarm", categoryBlocks, true, enableFeatures +
            "\nFish Farm" +
            "\nBait");

        enableStorageBlocks = getBoolean("08-enableStorageBlocks", categoryBlocks, true, enableFeatures +
            "\nCarrot Crate" +
            "\nPotato Crate" +
            "\nPoisonous Potato Crate" +
            "\nOnion Crate" +
            "\nBeetroot Crate (Requires Et Futurum Requiem)" +
            "\nCod Barrel" +
            "\nSalmon Barrel" +
            "\nTropical Fish Barrel" +
            "\nTailor Barrel" +
            "\nPufferfish Barrel" +
            "\nWheat Seed Sack" +
            "\nMelon Seed Sack" +
            "\nPumpkin Seed Sack" +
            "\nSaltwort Sack" +
            "\nBeetroot Seed Sack (Requires Et Futurum Requiem)" +
            "\n");

        enableSaltCrystal = getBoolean("09-enableSaltCrystal", categoryBlocks, true, enableFeatures +
            "\nSalt Crystal" +
            "\nSalt Shard" +
            "\n");
        saltCrystalGrowthSpeed = getInt("10-saltCrystalGrowthSpeed", categoryBlocks, 14, 1, 20, "Regulates the Salt Crystal growth speed (1 - faster, 20 - slower)");

        saltwortGrowthSpeed = getInt("11-saltwortGrowthSpeed", categoryBlocks, 7, 1, 20, "Regulates the Saltwort growth speed (1 - faster, 20 - slower)");

        enableSaltFlowers = getBoolean("12-enableSaltFlowers", categoryBlocks, true, enableFeatures +
            "\nDaucus" +
            "\nSuspicious Daucus" +
            "\nSolanum" +
            "\nSuspicious Solanum" +
            "\nSuspicious Allium" +
            "\nMaritima" +
            "\nSuspicious Maritima (Requires Et Futurum Requiem)" +
            "\n");


        swarmedEffectID = getInt("01-swarmedEffectID", categoryEffects, 28, 0, Byte.MAX_VALUE, "Sets the Potion ID for the \"Swarmed!\" Potion Effect");

        wellFedEffectID = getInt("02-wellFedEffectID", categoryEffects, 29, 0, Byte.MAX_VALUE, "Sets the Potion ID for the \"Well Fed\" Potion Effect");


        enableDeveloperFoods = getBoolean("01-enableDeveloperFoods", categoryItems, false, enableFeatures +
            "\nVoid Apple (Developer Testing Item, instantly empties the hunger bar)" +
            "\nStuffing Apple (Developer Testing Item, instantly replenishes the hunger bar)" +
            "\n");

        enableHoney = getBoolean("02-enableHoney", categoryItems, true, enableFeatures +
            "\nApiary" +
            "\nBee Larva" +
            "\nCarpenter Bee" +
            "\nWaxcomb" +
            "\nHoneycomb" +
            "\nRoyal Jelly" +
            "\nHoney Glazed Porkchop with Saltwort" +
            "\nHoney Glazed Porkchop" +
            "\nHoney Glazed Apple" +
            "\nHoney Glazed Sweetberries (Requires Et Futurum Requiem)" +
            "\nAn alternative Crafting Recipe for the Muffin" +
            "\n");

        enableMineralMud = getBoolean("03-enableMineralMud", categoryItems, true, enableFeatures +
            "\nMineral Mud" +
            "\nWet Mud Bricks" +
            "\nMud Bricks" +
            "\nMud Brick Stairs" +
            "\nMud Brick Slab" +
            "\nMud Brick Wall (Requires Et Futurum Requiem)" +
            "\nMineral Mud Ball" +
            "\nHead Mud Mask" +
            "\nBody Mud Mask" +
            "\nLegs Mud Mask" +
            "\nFeet Mud Mask" +
            "\n");

        enableFizzyDrink = getBoolean("04-enableFizzyDrink", categoryItems, true, enableFeatures +
            "\nFizzy Drink" +
            "\n");
        fizzyDrinkEffect = getBoolean("05-fizzyDrinkEffect", categoryItems, false, "Regulates the capabilities of the Fizzy Drink (true - removes all effects, false - removes the same effects that milk removes)");
        enableTunnelersConcoction = getBoolean("06-enableTunnelersConcoction", categoryItems, true, enableFeatures +
            "\nTunneler's Concoction" +
            "\n");

        enableRainmaker = getBoolean("07-enableRainmaker", categoryItems, true, enableFeatures +
            "\nRainmaker Star" +
            "\nRainmaker" +
            "\n");


        enableMudArmor = getBoolean("01-enableMudArmor", categoryItemsArmor, true, enableFeatures +
            "\nHead Mud Mask" +
            "\nBody Mud Mask" +
            "\nLegs Mud Mask" +
            "\nFeet Mud Mask" +
            "\n");
        mudArmorWaterDamage = getBoolean("02-mudArmorWaterDamage", categoryItemsArmor, true, "Enables the Water Damage mechanic for the Mud Armor, slowly degrading it in water or in the rain");
        mudArmorHealthBoost = getBoolean("03-mudArmorHealthBoost", categoryItemsArmor, true, "Enables the Health Boost, that the Mud Armor gives when worn");
        mudArmorHealthBoostValue = getInt("04-mudArmorHealthBoostValue", categoryItemsArmor, 1, 0, 4, "Regulates the potency of the Health Boost effect of the Mud Armor (0 - Health Boost I, 1 - Health Boost II, etc., every level will give you 2 more hearts");
        mudArmorBeeResistant = getBoolean("05-mudArmorBeeResistant", categoryItemsArmor, false, "Gives the Mud Armor a resistance against the \"Swarmed!\" Effect" +
            "\nAdditionally, by using CraftTweaker, you can also add this resistance to other armor sets at your leisure" +
            "\nTo achieve this, you open a new CraftTweaker document and input the following information:" +
            "\n" +
            "\nval beeResistant = <ore:beeResistant>;" +
            "\nbeeResistant.add(<[MODID]:[HELMETID]>);" +
            "\nbeeResistant.add(<[MODID]:[CHESTPLATEID]>);" +
            "\nbeeResistant.add(<[MODID]:[LEGGINGSID]>);" +
            "\nbeeResistant.add(<[MODID]:[BOOTSID]>);" +
            "\n" +
            "\n");


        enableDough = getBoolean("01-enableDough", categoryItemsFood, true, enableFeatures +
            "\nDough" +
            "\nAn alternative Crafting Recipe for the Chocolate Pie" +
            "\nAn alternative Crafting Recipe for the Birthday Pie" +
            "\nAn alternative Crafting Recipe for the Shepherd's Pie" +
            "\nAn alternative Crafting Recipe for the Cod Pie" +
            "\nAn alternative Crafting Recipe for the Salmon Pie" +
            "\nAn alternative Crafting Recipe for the Tropical Fish Pie" +
            "\nAn alternative Crafting Recipe for the Tailor Pie" +
            "\nAn alternative Crafting Recipe for the Calamari Pie" +
            "\nAn alternative Crafting Recipe for the Saltwort Pie" +
            "\nAn alternative Crafting Recipe for the Muffin" +
            "\nAn alternative Crafting Recipe for the Bread" +
            "\nAn alternative Crafting Recipe for the Cake" +
            "\nAn alternative Crafting Recipe for the Cookie" +
            "\nAn alternative Crafting Recipe for the Pumpkin Pie" +
            "\n");

        enableOnion = getBoolean("02-enableOnion", categoryItemsFood, true, enableFeatures +
            "\nOnion" +
            "\nOnion Crate" +
            "\nDandelion Salad" +
            "\nSalted Dandelion Salad" +
            "\nDressed Herring (Requires Et Futurum Requiem)" +
            "\nSalted Dressed Herring (Requires Et Futurum Requiem)" +
            "\nOnion Pie" +
            "\nPickled Onion" +
            "\n");

        enableGoldenFoods = getBoolean("03-enableGoldenFoods", categoryItemsFood, true, enableFeatures +
            "\nGolden Saltwort" +
            "\nGolden Potato" +
            "\nGolden Sweetberries (Requires Et Futurum Requiem)" +
            "\nGolden Vegetables" +
            "\nSalted Golden Vegetables" +
            "\nGolden Saltwort Salad" +
            "\nGolden Fruit Salad" +
            "\nSugared Golden Fruit Salad" +
            "\n");

        enableSaltedPorkchop = getBoolean("04-enableSaltedPorkchop", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Porkchop" +
            "\nSalted Cooked Porkchop with Saltwort" +
            "\n");
        enableSaltedBeef = getBoolean("05-enableSaltedBeef", categoryItemsFood, true, enableFeatures +
            "\nSalted Steak" +
            "\nSalted Steak with Saltwort" +
            "\n");
        enableSaltedChicken = getBoolean("06-enableSaltedChicken", categoryItemsFood, true, enableFeatures +
            "\nSalted Chicken" +
            "\n");
        enableStrider = getBoolean("07-enableStrider", categoryItemsFood, true, enableFeatures +
            "\nRaw Strider Flank" +
            "\nStrider Steak" +
            "\nSalted Strider Steak" +
            "\nSalted Strider Steak with Saltwort" +
            "\nNotes: This idea has been shamelessly stolen from Netherlicious. Though, since Et Futurum Requiem currently doesn't add Striders, and Netherlicious already has Strider meat, this meat drops from Bats instead for now" +
            "\n");
        enableHaunch = getBoolean("08-enableHaunch", categoryItemsFood, true, enableFeatures +
            "\nRaw Haunch" +
            "\nCooked Haunch" +
            "\nSalted Cooked Haunch" +
            "\nSalted Cooked Haunch with Saltwort" +
            "\n");
        enableCuredMeat = getBoolean("09-enableCuredMeat", categoryItemsFood, true, enableFeatures +
            "\nCured Meat" +
            "\n");
        enableSaltedCod = getBoolean("10-enableSaltedCod", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Cod" +
            "\nNotes: This is in line with the texture and localization changes this mod makes to the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions" +
            "\n");
        enableSaltedSalmon = getBoolean("11-enableSaltedSalmon", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Salmon" +
            "\n");
        enableTropicalFish = getBoolean("12-enableTropicalFish", categoryItemsFood, true, enableFeatures +
            "\nCooked Tropical Fish" +
            "\nSalted Cooked Tropical Fish" +
            "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 2), to better reflect the modern Minecraft versions" +
            "\n");
        enableTailor = getBoolean("13-enableTailor", categoryItemsFood, true, enableFeatures +
            "\nTailor" +
            "\nCooked Tailor" +
            "\nSalted Cooked Tailor" +
            "\nTailor Pie" +
            "\nNotes: This replaces the vanilla Fish (with the meta value of 0) in texture, to better reflect the modern Minecraft versions" +
            "\n");
        enableCalamari = getBoolean("14-enableCalamari", categoryItemsFood, true, enableFeatures +
            "\nRaw Calamari" +
            "\nCooked Calamari" +
            "\nSalted Cooked Calamari" +
            "\nCalamari Pie" +
            "\nPickled Calamari" +
            "\n");
        enableSaltedBread = getBoolean("15-enableSaltedBread", categoryItemsFood, true, enableFeatures +
            "\nSalted Bread" +
            "\n");
        enableSaltedPotato = getBoolean("16-enableSaltedPotato", categoryItemsFood, true, enableFeatures +
            "\nSalted Baked Potato" +
            "\n");
        enableEgg = getBoolean("17-enableEgg", categoryItemsFood, true, enableFeatures +
            "\nSoft-Boiled Egg" +
            "\n");

        enableSaltedMushroomStew = getBoolean("18-enableSaltedMushroomStew", categoryItemsFood, true, enableFeatures +
            "\nSalted Mushroom Stew" +
            "\n");

        enablePumpkinPorridge = getBoolean("19-enablePumpkinPorridge", categoryItemsFood, true, enableFeatures +
            "\nPumpkin Porridge" +
            "\nSalted Pumpkin Porridge" +
            "\n");
        enableCactusSoup = getBoolean("20-enableCactusSoup", categoryItemsFood, true, enableFeatures +
            "\nCactus Soup" +
            "\nSalted Cactus Soup" +
            "\n");
        enableStewedVegetables = getBoolean("21-enableStewedVegetables", categoryItemsFood, true, enableFeatures +
            "\nStewed Vegetables" +
            "\nSalted Stewed Vegetables" +
            "\n");
        enablePotatoMushroom = getBoolean("22-enablePotatoMushroom", categoryItemsFood, true, enableFeatures +
            "\nPotato with Mushroom" +
            "\nSalted Potato with Mushroom" +
            "\n");
        enableFishSoup = getBoolean("23-enableFishSoup", categoryItemsFood, true, enableFeatures +
            "\nFish Soup" +
            "\nSalted Fish Soup" +
            "\n");
        enableDandelionSalad = getBoolean("24-enableDandelionSalad", categoryItemsFood, true, enableFeatures +
            "\nDandelion Salad" +
            "\nSalted Dandelion Salad" +
            "\n");
        enableWheatSprouts = getBoolean("25-enableWheatSprouts", categoryItemsFood, true, enableFeatures +
            "\nWheat Sprouts" +
            "\nSalted Wheat Sprouts" +
            "\n");
        enableSaltwortSalad = getBoolean("26-enableSaltwortSalad", categoryItemsFood, true, enableFeatures +
            "\nSaltwort Salad" +
            "\n");

        enableSaltwortPorkchop = getBoolean("27-enableSaltwortPorkchop", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Porkchop with Saltwort" +
            "\n");
        enableSaltwortHoneyPorkchop = getBoolean("28-enableSaltwortHoneyPorkchop", categoryItemsFood, true, enableFeatures +
            "\nHoney Glazed Porkchop with Saltwort" +
            "\n");
        enableSaltwortBeef = getBoolean("29-enableSaltwortBeef", categoryItemsFood, true, enableFeatures +
            "\nSalted Steak with Saltwort" +
            "\n");
        enableSaltwortStrider = getBoolean("30-enableSaltwortStrider", categoryItemsFood, true, enableFeatures +
            "\nSalted Strider Steak with Saltwort" +
            "\n");
        enableSaltwortHaunch = getBoolean("31-enableSaltwortHaunch", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Haunch with Saltwort" +
            "\n");

        enableSugaredApple = getBoolean("32-enableSugaredApple", categoryItemsFood, true, enableFeatures +
            "\nSugared Apple" +
            "\n");
        enableSugaredMelon = getBoolean("33-enableSugaredMelon", categoryItemsFood, true, enableFeatures +
            "\nSugared Melon Slice" +
            "\n");

        enableFruitSalad = getBoolean("34-enableFruitSalad", categoryItemsFood, true, enableFeatures +
            "\nFruit Salad" +
            "\nSugared Fruit Salad" +
            "\n");
        enableGratedCarrot = getBoolean("35-enableGratedCarrot", categoryItemsFood, true, enableFeatures +
            "\nGrated Carrot" +
            "\nSugared Grated Carrot" +
            "\n");
        enableMelonSoup = getBoolean("36-enableMelonSoup", categoryItemsFood, true, enableFeatures +
            "\nMelon Soup" +
            "\nSugared Melon Soup" +
            "\n");

        enableHoneyPorkchop = getBoolean("37-enableHoneyPorkchop", categoryItemsFood, true, enableFeatures +
            "\nHoney Glazed Porkchop" +
            "\n");
        enableHoneyApple = getBoolean("38-enableHoneyApple", categoryItemsFood, true, enableFeatures +
            "\nHoney Glazed Apple" +
            "\n");
        enableChocolateBar = getBoolean("39-enableChocolateBar", categoryItemsFood, true, enableFeatures +
            "\nChocolate Bar" +
            "\n");

        enableChocolatePie = getBoolean("40-enableChocolatePie", categoryItemsFood, true, enableFeatures +
            "\nChocolate Pie" +
            "\n");
        enableBirthdayPie = getBoolean("41-enableBirthdayPie", categoryItemsFood, true, enableFeatures +
            "\nBirthday Pie" +
            "\n");
        replaceCake = getBoolean("42-replaceCake", categoryItemsFood, false, "Disables the Crafting Recipe for Cake, effectively replacing the Cake with the Birthday Pie");
        enableApplePie = getBoolean("43-enableApplePie", categoryItemsFood, true, enableFeatures +
            "\nApple Pie" +
            "\n");
        enableCarrotPie = getBoolean("44-enableCarrotPie", categoryItemsFood, true, enableFeatures +
            "\nCarrot Pie" +
            "\n");
        enableMushroomPie = getBoolean("45-enableMushroomPie", categoryItemsFood, true, enableFeatures +
            "\nMushroom Pie" +
            "\n");
        enablePotatoPie = getBoolean("46-enablePotatoPie", categoryItemsFood, true, enableFeatures +
            "\nPotato Pie" +
            "\n");
        enableOnionPie = getBoolean("47-enableOnionPie", categoryItemsFood, true, enableFeatures +
            "\nOnion Pie" +
            "\n");
        enableShepherdsPie = getBoolean("48-enableShepherdsPie", categoryItemsFood, true, enableFeatures +
            "\nShepherd's Pie" +
            "\n");
        enableCodPie = getBoolean("49-enableCodPie", categoryItemsFood, true, enableFeatures +
            "\nCod Pie" +
            "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions" +
            "\n");
        enableSalmonPie = getBoolean("50-enableSalmonPie", categoryItemsFood, true, enableFeatures +
            "\nSalmon Pie" +
            "\n");
        enableTropicalFishPie = getBoolean("51-enableTropicalFishPie", categoryItemsFood, true, enableFeatures +
            "\nTropical Fish Pie" +
            "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 2), to better reflect the modern Minecraft versions" +
            "\n");
        enableTailorPie = getBoolean("52-enableTailorPie", categoryItemsFood, true, enableFeatures +
            "\nTailor Pie" +
            "\nNotes: This replaces an obligatory \"Fish Pie\" that would be named after the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions" +
            "\n");
        enableCalamariPie = getBoolean("53-enableCalamariPie", categoryItemsFood, true, enableFeatures +
            "\nCalamari Pie" +
            "\n");
        enableSaltwortPie = getBoolean("54-enableSaltwortPie", categoryItemsFood, true, enableFeatures +
            "\nSaltwort Pie" +
            "\n");

        enableFermentedSaltwort = getBoolean("55-enableFermentedSaltwort", categoryItemsFood, true, enableFeatures +
            "\nFermented Saltwort" +
            "\n");
        enableFermentedFern = getBoolean("56-enableFermentedFern", categoryItemsFood, true, enableFeatures +
            "\nFermented Fern" +
            "\n");
        enableFermentedMushroom = getBoolean("57-enableFermentedMushroom", categoryItemsFood, true, enableFeatures +
            "\nFermented Mushroom" +
            "\n");
        enablePickledCalamari = getBoolean("58-enablePickledCalamari", categoryItemsFood, true, enableFeatures +
            "\nPickled Calamari" +
            "\n");
        enablePickledOnion = getBoolean("59-enablePickledOnion", categoryItemsFood, true, enableFeatures +
            "\nPickled Onion" +
            "\n");
        enableApplePreserves = getBoolean("60-enableApplePreserves", categoryItemsFood, true, enableFeatures +
            "\nApple Preserves" +
            "\n");
        enableMelonPreserves = getBoolean("61-enableMelonPreserves", categoryItemsFood, true, enableFeatures +
            "\nMelon Preserves" +
            "\n");

        enableMuffin = getBoolean("62-enableMuffin", categoryItemsFood, true, enableFeatures +
            "\nMuffin" +
            "\n");

        enableToughJelly = getBoolean("63-enableToughJelly", categoryItemsFood, true, enableFeatures +
            "\nTough Jelly" +
            "\n");


        enableEFRFoodValueChanges = getBoolean("01-enableEFRFoodValueChanges", categoryModCompatibility, true, "Changes the food values of the Et Futurum Requiem Foods, to better fit the new balancing:" +
            "\nRaw Mutton - 2 | 0.6F" +
            "\nCooked Mutton - 4 | 0.6F" +
            "\nRaw Rabbit - 1 | 0.6F" +
            "\nCooked Rabbit - 3 | 0.6F" +
            "\nRabbit Ragout - 7 | 0.7F" +
            "\nBeetroot - 1 | 0.3F" +
            "\nBorscht - 5 | 0.7F" +
            "\nChorus Fruit - 1 | 0.3F" +
            "\nSuspicious Stew - 5 | 0.7F" +
            "\nSweetberries - 1 | 0.3F" +
            "\nNotes: The first value refers to the number of half hunger shanks the respective item returns. The second value refers to the saturation. For a more detailed understanding, refer to this table and halve the \"Saturation Ratio\" values depicted there: https://minecraft.wiki/w/Food#Foods" +
            "\n");

        enableTFSaltOre = getBoolean("02-enableTFSaltOre", categoryModCompatibility, true, "Enables Salt Ore Generation in the Twilight Forest Dimension");


        enableMudBrickWall = getBoolean("01-enableMudBrickWall", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nMud Brick Wall" +
            "\n" + compatibilityString1 + "Mud Brick Wall" + compatibilityString2 +
            "\n");
        enableBlossomWood = getBoolean("02-enableBlossomWood", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Wood" +
            "\n" + compatibilityString1 + "Blossom Wood" + compatibilityString2 +
            "\n");
        enableStrippedBlossomLogs = getBoolean("03-enableStrippedBlossomLogs", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nStripped Blossom Logs" +
            "\n" + compatibilityString1 + "Stripped Blossom Logs" + compatibilityString2 +
            "\n");
        enableStrippedBlossomWood = getBoolean("04-enableStrippedBlossomWood", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nStripped Blossom Wood" +
            "\n" + compatibilityString1 + "Stripped Blossom Wood" + compatibilityString2 +
            "\n");
        enableBlossomFence = getBoolean("05-enableBlossomFence", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Fence" +
            "\n" + compatibilityString1 + "Blossom Fence" + compatibilityString2 +
            "\n");
        enableBlossomFenceGate = getBoolean("06-enableBlossomFenceGate", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Fence Gate" +
            "\n" + compatibilityString1 + "Blossom Fence Gate" + compatibilityString2 +
            "\n");
        enableBlossomPressurePlate = getBoolean("07-enableBlossomPressurePlate", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Pressure Plate" +
            "\n" + compatibilityString1 + "Blossom Pressure Plate" + compatibilityString2 +
            "\n");
        enableBlossomButton = getBoolean("08-enableBlossomButton", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Button" +
            "\n" + compatibilityString1 + "Blossom Button" + compatibilityString2 +
            "\n");
        enableBlossomDoor = getBoolean("09-enableBlossomDoor", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Door" +
            "\n" + compatibilityString1 + "Blossom Door" + compatibilityString2 +
            "\n");
        enableBlossomTrapdoor = getBoolean("10-enableBlossomTrapdoor", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Trapdoor" +
            "\n" + compatibilityString1 + "Blossom Trapdoor" + compatibilityString2 +
            "\n");
        enableBlossomSign = getBoolean("11-enableBlossomSign", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Sign" +
            "\n" + compatibilityString1 + "Blossom Sign" + compatibilityString2 +
            "\n");


        enableSaltedRabbit = getBoolean("01-enableSaltedRabbit", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Cooked Rabbit" +
            "\n" + compatibilityString1 + "Salted Cooked Rabbit" + compatibilityString2 +
            "\n");
        enableSaltedMutton = getBoolean("02-enableSaltedMutton", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Cooked Mutton" +
            "\n" + compatibilityString1 + "Salted Cooked Mutton" + compatibilityString2 +
            "\n");
        enableSaltedBeetroot = getBoolean("03-enableSaltedBeetroot", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Beetroot" +
            "\n" + compatibilityString1 + "Salted Beetroot" + compatibilityString2 +
            "\n");
        enableSaltedRabbitRagout = getBoolean("04-enableSaltedRabbitRagout", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Rabbit Ragout" +
            "\n" + compatibilityString1 + "Salted Rabbit Ragout" + compatibilityString2 +
            "\n");
        enableSaltedBorscht = getBoolean("05-enableSaltedBorscht", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Borscht" +
            "\n" + compatibilityString1 + "Salted Borscht" + compatibilityString2 +
            "\n");

        enableBeetrootSalad = getBoolean("06-enableBeetrootSalad", categoryModCompatibilityItems, true, enableFeatures +
            "\nBeetroot Salad" +
            "\nSalted Beetroot Salad" +
            "\n" + compatibilityString1 + "Beetroot Salad and Salted Beetroot Salad" + compatibilityString2 +
            "\n");
        enableDressedHerring = getBoolean("07-enableDressedHerring", categoryModCompatibilityItems, true, enableFeatures +
            "\nDressed Herring" +
            "\nSalted Dressed Herring" +
            "\n" + compatibilityString1 + "Dressed Herring and Salted Dressed Herring" + compatibilityString2 +
            "\n");
        enableSaltwortMutton = getBoolean("08-enableSaltwortMutton", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Cooked Mutton with Saltwort" +
            "\n" + compatibilityString1 + "Salted Cooked Mutton with Saltwort" + compatibilityString2 +
            "\n");
        enableSugaredBerries = getBoolean("09-enableSugaredBerries", categoryModCompatibilityItems, true, enableFeatures+
            "\nSugared Sweetberries" +
            "\n" + compatibilityString1 + "Sugared Sweetberries" + compatibilityString2 +
            "\n");
        enableHoneyBerries = getBoolean("10-enableHoneyBerries", categoryModCompatibilityItems, true, enableFeatures+
            "\nHoney Glazed Sweetberries" +
            "\n" + compatibilityString1 + "Honey Glazed Sweetberries" + compatibilityString2 +
            "\n");
        enableChocolateBerries = getBoolean("11-enableChocolateBerries", categoryModCompatibilityItems, true, enableFeatures+
            "\nChocolate Laced Sweetberries" +
            "\n" + compatibilityString1 + "Chocolate Laced Sweetberries" + compatibilityString2 +
            "\n");
        enableBerryPie = getBoolean("12-enableBerryPie", categoryModCompatibilityItems, true, enableFeatures+
            "\nSweetberry Pie" +
            "\n" + compatibilityString1 + "Sweetberry Pie" + compatibilityString2 +
            "\n");
        enablePickledBeetroot = getBoolean("13-enablePickledBeetroot", categoryModCompatibilityItems, true, enableFeatures+
            "\nPickled Beetroot" +
            "\n" + compatibilityString1 + "Pickled Beetroot" + compatibilityString2 +
            "\n");
        enableBerryPreserves = getBoolean("14-enableBerryPreserves", categoryModCompatibilityItems, true, enableFeatures+
            "\nSweetberry Preserves" +
            "\n" + compatibilityString1 + "Sweetberry Preserves" + compatibilityString2 +
            "\n");

        enableTFFoods = getBoolean("15-enableTFFoods", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Venison Steak" +
            "\nSalted Meef Steak" +
            "\nSalted Meef Stroganoff" +
            "\nSalted Hyrda Chop" +
            "\nPickled Mushgloom" +
            "\nVenison Steak with Saltwort" +
            "\nMeef Steak with Saltwort" +
            "\nNotes: This is for when you have Twilight Forest installed, but for some reason, don't want the respective Foods to be present" +
            "\n");

        enableBOPFoods = getBoolean("16-enableBOPFoods", categoryModCompatibilityItems, true, enableFeatures +
            "\nHemoglobin" +
            "\nPoison" +
            "\nSalted Shroom Powder" +
            "\nSugared Fruit Salad" +
            "\nSalted Veggie Salad" +
            "\nSalted Shroom Salad" +
            "\nSalted Bowl of Rice" +
            "\nPickled Turnip" +
            "\nNotes: This is for when you have Biomes O'Plenty installed, but for some reason, don't want the respective Foods to be present" +
            "\n");


        enableVanillaFoodValueChanges = getBoolean("01-enableVanillaFoodValueChanges", categoryVanillaChanges, true, "Changes the food values of the vanilla Foods, to better fit the new balancing:" +
            "\nApple - 2 | 0.3F" +
            "\nMushroom Stew - 5 | 0.7F" +
            "\nBread - 3 | 0.5F" +
            "\nPorkchop - 2 | 0.6F" +
            "\nCooked Porkchop - 4 | 0.6F" +
            "\nGolden Apple - 4 | 0.6F" +
            "\nFish (All Fish) - 1 | 0.5F (Added Water Breathing for 3 seconds)" +
            "\nCooked Fish (All Fish) - 3 | 0.5F" +
            "\nCookie - 2 | 0.1F" +
            "\nMelon Slice - 1 | 0.3F (Added Jump Boost for 3 seconds)" +
            "\nBeef - 2 | 0.6F" +
            "\nSteak - 4 | 0.6F" +
            "\nChicken - 1 | 0.6F" +
            "\nCooked Chicken - 3 | 0.6F" +
            "\nRotten Flesh - 1 | 0.3F" +
            "\nSpider Eye - 1 | 0.3F" +
            "\nCarrot - 2 | 0.3F" +
            "\nPotato - 1 | 0.3F" +
            "\nBaked Potato - 3 | 0.5F" +
            "\nPoisonous Potato - 1 | 0.3F" +
            "\nGolden Carrot - 6 | 1.2F" +
            "\nPumpkin Pie - 7 | 0.9F" +
            "\nNotes: The first value refers to the number of half hunger shanks the respective item returns. The second value refers to the saturation. For a more detailed understanding, refer to this table and halve the \"Saturation Ratio\" values depicted there: https://minecraft.wiki/w/Food#Foods" +
            "\n");

        enableRecipeChanges = getBoolean("02-enableRecipeChanges", categoryVanillaChanges, true, "Changes the following vanilla Crafting Recipes:" +
            "\nMushroom Stew - Now gets crafted with an Ore Dictionary, allowing you to use either two Mushrooms to craft it" +
            "\nBread - Now gets crafted by burning Dough in a Furnace (or a Smoker, if Et Futurum Requiem is installed)" +
            "\nCake - Now gets crafted with only one Milk Bucket in the upper row and one Dough in the lower row, instead of three pieces of Wheat" +
            "\nCookie - Now gets crafted with Dough and Cocoa Beans, instead of two pieces of Wheat" +
            "\nPumpkin Pie - Now also needs Dough in addition to Pumpkin, Sugar and an Egg" +
            "\n");


        saltOreFrequency = getInt("01-saltOreFrequency", categoryWorldGeneration, 4, 1, 10, "Regulates the frequency of the Salt Ore Generation");
        saltoreVeinSize = getInt("02-saltoreVeinSize", categoryWorldGeneration, 5, 1, 10, "Regulates the size of Salt Ore veins");


        enableSaltMarsh = getBoolean("01-enableSaltMarsh", categoryWorldGenerationBiomes, true, enableFeatures +
            "\nSalt Marsh" +
            "\nSalt Crusted Oak Logs" +
            "\nMarsh Reeds" +
            "\n");
        saltMarshBiomeID = getInt("02-saltMarshBiomeID", categoryWorldGenerationBiomes, 40, 40, 40, "Sets the Biome ID of the Salt Marsh Biome, setting this to \"-1\" completely disables the Biome");
        saltMarshBiomeWeight = getInt("03-saltMarshBiomeWeight", categoryWorldGenerationBiomes, 10, 10, 10, "Regulates the Generation chance of Salt Marsh Biomes");
        saltMarshAdditionalSaltOre = getBoolean("04-saltMarshAdditionalSaltOre", categoryWorldGenerationBiomes, true, "Enables additional Salt Ore Generation in Salt Marsh Biomes");
        saltMarshSaltOreFrequency = getInt("05-saltMarshSaltOreFrequency", categoryWorldGenerationBiomes, 4, 1, 10, "Regulates the frequency of the additional Salt Ore Generation in Salt Marsh Biomes");


        enableSaltLakes = getBoolean("01-enableSaltLakes", categoryWorldGenerationStructures, true, enableFeatures +
            "\nSalt Lake" +
            "\nSalt Lake Bottom" +
            "\n");
        saltLakeFrequency = getInt("02-saltLakeFrequency", categoryWorldGenerationStructures, 500, 1, 1000, "Regulates the frequency of the Salt Lake Group Generation");
        saltLakeQuantity = getInt("03-saltLakeQuantity", categoryWorldGenerationStructures, 5, 1, 10, "Regulates the quantity of single Salt Lakes in Salt Lake Groups");
        saltLakeDistance = getInt("04-saltLakeDistance", categoryWorldGenerationStructures, 30, 10, 50, "Regulates the distance between single Salt Lakes in Salt Lake Groups");
        saltLakeRadius = getInt("05-saltLakeRadius", categoryWorldGenerationStructures, 20, 5, 50, "Regulates the radius of single Salt Lakes");

        enableBrickmakerCamp = getBoolean("06-enableBrickmakerCamps", categoryWorldGenerationStructures, true, enableFeatures +
            "\nBrickmaker Camp" +
            "\n");
        brickmakerCampFrequency = getInt("07-brickmakerCampFrequency", categoryWorldGenerationStructures, 300, 10, 1000, "Regulates the frequency of the Brickmaker Camp Generation in Salt Marsh Biomes");

        //TOBEPHASEDOUT
        loadedCloudLevel = getStringList("loadedCloudLevel", categoryTOBEPHASEDOUT, defaultCloudLevel, "The height of the clouds in a specific dimension (DimensionID=CloudLevel)");

        save();
    }

    public void init() {
        Configuration configTF = new Configuration(new File("./config", "TwilightForest.cfg"));
        configTF.load();
        TFDimensionID = configTF.get("dimension", "TFDimensionID", 7).getInt();
    }

    //TOBEPHASEDOUT
    public void postInit() {
        cloudLevel = new HashMap<Integer, Integer>();
        Pattern splitpattern = Pattern.compile("=");
        for (int i = 0; i < this.loadedCloudLevel.length; i++) {
            String s = this.loadedCloudLevel[i];
            String[] pair = splitpattern.split(s);
            if (pair.length != 2) {
                SaltyMod.logger.warn("Invalid key-value pair at DimCloudLevel[" + i + "]");
            } else {
                int dim, level;
                try {
                    dim = Integer.parseInt(pair[0]);
                } catch (NumberFormatException e) {
                    SaltyMod.logger.warn("Cannot parse DimensionID \"" + pair[0] + "\" to integer point at DimCloudLevel line " + (i + 1));
                    break;
                }
                try {
                    level = Integer.parseInt(pair[1]);
                } catch (NumberFormatException e) {
                    SaltyMod.logger.warn("Cannot parse CloudLevel \"" + pair[1] + "\" to integer point at DimCloudLevel line " + (i + 1));
                    break;
                }
                cloudLevel.put(dim, level);
            }
        }
    }
}
