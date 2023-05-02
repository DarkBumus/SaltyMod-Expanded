package darkbum.saltymod.configuration;

import darkbum.saltymod.SaltyMod;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ModConfiguration extends Configuration {

    // Categories
    private static final String categoryBlocks = "Blocks";
    private static final String categoryEffects = "Effects";
    private static final String categoryItems = "Items";
    private static final String categoryItemsArmor = "Items | Armor";
    private static final String categoryItemsFood = "Items | Food Items";
    private static final String categoryModCompatibility = "Mod Compatibility";
    private static final String categoryModCompatibilityBlocks = "Mod Compatibility | Blocks";
    private static final String categoryModCompatibilityItems = "Mod Compatibility | Items";
    private static final String categoryVanillaChanges = "Vanilla Changes";
    private static final String categoryWorldGeneration = "World Generation";
    private static final String categoryWorldGenerationBiomes = "World Generation | Biomes";
    private static final String categoryWorldGenerationStructures = "World Generation | Structures";
    private static final String categoryTOBEPHASEDOUT = "TO BE PHASED OUT";


    // Strings

    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityString1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityString2 = " to be present";


    // Config Options Blocks
    public static boolean enableBlossom;
    public static boolean enableMudBricks;
    public static boolean complexMudBricks;

    public static boolean enableEvaporator;
    public static int evaporatorVolume;

    public static boolean enableSaltBlocks;

    public static boolean enableSaltCrystal;
    public static int saltCrystalGrowthSpeed;

    public static int saltwortGrowthSpeed;

    public static boolean enableSaltOre;

    public static boolean enableSaltDirt;

    public static boolean enableSaltFlowers;

    public static boolean enableStorageBlocks;


    // Config Options Effects
    public static int swarmedEffectID;

    public static int wellFedEffectID;


    // Config Options Items
    public static boolean enableDeveloperFoods;

    public static boolean enableHoney;

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
    public static boolean enableSaltedSteak;
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
    public static boolean enableSaltwortSteak;
    public static boolean enableSaltwortStrider;
    public static boolean enableSaltwortHaunch;

    public static boolean enableSugaredApple;
    public static boolean enableSugaredMelon;

    public static boolean enableFruitSalad;
    public static boolean enableGratedCarrot;
    public static boolean enableMelonSoup;

    public static boolean enableHoneyPorkchop;
    public static boolean enableHoneyApple;
    public static boolean enableChocolatebar;

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
    public static boolean enableBlossomWood;
    public static boolean enableStrippedBlossomLogs;
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



    private File file;

    public ModConfiguration(File file) {
        super(file);
        this.file = file;
    }

    public void preInit() {
        String[] defaultCloudLevel = { "0=128", "7=160" }; //TOBEPHASEDOUT
        load();
        enableBlossom = getBoolean("enableBlossom", categoryBlocks, true, enableFeatures +
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
            "\nBlossom Sign (Requires Et Futurum Requiem)" +
            "\nBlossom" +
            "\n");
        enableMudBricks = getBoolean("enableMudBricks", categoryBlocks, true, enableFeatures +
            "\nWet Mud Bricks" +
            "\nMud Bricks" +
            "\nMud Brick Stairs" +
            "\nMud Brick Slab" +
            "\nMud Brick Wall" +
            "\n");
        complexMudBricks = getBoolean("complexMudBricks", categoryBlocks, true, "Enables the a complex drying mechanic on Wet Mud Bricks by enabling their random tick functionality and disables the furnace recipe");

        enableEvaporator = getBoolean("enableEvaporator", categoryBlocks, true, enableFeatures +
            "\nEvaporator" +
            "\nPowdered Milk" +
            "\n");
        evaporatorVolume = getInt("evaporatorVolume", categoryBlocks, 1, 1, 3, "Regulates the number of buckets that can be poured into an evaporator at once");

        enableSaltBlocks = getBoolean("enableSaltBlocks", categoryBlocks, true, enableFeatures +
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

        enableSaltCrystal = getBoolean("enableSaltCrystal", categoryBlocks, true, enableFeatures +
            "\nSalt Crystal" +
            "\nSalt Shard" +
            "\n");
        saltCrystalGrowthSpeed = getInt("saltCrystalGrowthSpeed", categoryBlocks, 14, 1, 20, "Regulates the Salt Crystal growth speed (1 - faster, 20 - slower)");

        saltwortGrowthSpeed = getInt("saltwortGrowthSpeed", categoryBlocks, 7, 1, 20, "Regulates the Saltwort growth speed (1 - faster, 20 - slower)");

        enableSaltOre = getBoolean("enableSaltOre", categoryBlocks, true, enableFeatures +
            "\nSalt Ore" +
            "\nDeepslate Salt Ore (Requires Et Futurum Requiem)" +
            "\n");

        enableSaltDirt = getBoolean("enableSaltDirt", categoryBlocks, true, enableFeatures +
            "\nSalt Grass" +
            "\nSalt Dirt" +
            "\n");

        enableSaltFlowers = getBoolean("enableSaltFlowers", categoryBlocks, true, enableFeatures +
            "\nDaucus" +
            "\nSolanum" +
            "\nAllium" +
            "\nMaritima (Requires Et Futurum Requiem)" +
            "\n");

        enableStorageBlocks = getBoolean("enableStorageBlocks", categoryBlocks, true, enableFeatures +
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


        swarmedEffectID = getInt("swarmedEffectID", categoryEffects, 28, 0, Byte.MAX_VALUE, "Sets the Potion ID for the \"Swarmed!\" Potion Effect");

        wellFedEffectID = getInt("wellFedEffectID", categoryEffects, 29, 0, Byte.MAX_VALUE, "Sets the Potion ID for the \"Well Fed\" Potion Effect");


        enableDeveloperFoods = getBoolean("enableDeveloperFoods", categoryItems, false, enableFeatures +
            "\nVoid Apple (Developer Testing Item, instantly empties the hunger bar)" +
            "\nStuffing Apple (Developer Testing Item, instantly replenishes the hunger bar)" +
            "\n");

        enableHoney = getBoolean("enableHoney", categoryItems, true, enableFeatures +
            "\nApiary" +
            "\nBee Larva" +
            "\nCarpenter Bee" +
            "\nWaxcomb" +
            "\nHoneycomb" +
            "\nRoyal Jelly" +
            "\nHoney Glazed Porkchop" +
            "\nHoney Glazed Apple" +
            "\nHoney Glazed Sweetberries (Requires Et Futurum Requiem)" +
            "\nAn alternative Crafting Recipe for the Muffin" +
            "\n");

        enableFizzyDrink = getBoolean("enableFizzyDrink", categoryItems, true, enableFeatures +
            "\nFizzy Drink" +
            "\n");
        fizzyDrinkEffect = getBoolean("fizzyDrinkEffect", categoryItems, false, "Regulates the capabilities of the Fizzy Drink (true - removes all effects, false - removes the same effects that milk removes)");
        enableTunnelersConcoction = getBoolean("enableTunnelersConcoction", categoryItems, true, enableFeatures +
            "\nTunneler's Concoction" +
            "\n");

        enableRainmaker = getBoolean("enableRainmaker", categoryItems, true, enableFeatures +
            "\nRainmaker Star" +
            "\nRainmaker" +
            "\n");


        enableMudArmor = getBoolean("enableMudArmor", categoryItemsArmor, true, enableFeatures +
            "\nHead Mud Mask" +
            "\nBody Mud Mask" +
            "\nLegs Mud Mask" +
            "\nFeet Mud Mask" +
            "\n");
        mudArmorWaterDamage = getBoolean("mudArmorWaterDamage", categoryItemsArmor, true, "Enables the Water Damage mechanic for the Mud Armor, slowly degrading it in water or in the rain");
        mudArmorHealthBoost = getBoolean("mudArmorHealthBoost", categoryItemsArmor, true, "Enables the Health Boost, that the Mud Armor gives when worn");
        mudArmorHealthBoostValue = getInt("mudArmorHealthBoostValue", categoryItemsArmor, 1, 0, 5, "Regulates the potency of the Health Boost effect of the Mud Armor (0 - Health Boost I, 1 - Health Boost II, etc., every level will give you 2 more hearts");
        mudArmorBeeResistant = getBoolean("mudArmorBeeResistant", categoryItemsArmor, false, "Gives the Mud Armor a resistance against the \"Swarmed!\" Effect" +
            "\nAdditionally, by using CraftTweaker, you can also add this resistance to other armor sets at your leisure" +
            "\nTo achieve this, you open a new CraftTweaker document and input the following information:" +
            "\nval beeResistant = <ore:beeResistant>;" +
            "\nbeeResistant.add(<[MODID]:[HELMETID]>);" +
            "\nbeeResistant.add(<[MODID]:[CHESTPLATEID]>);" +
            "\nbeeResistant.add(<[MODID]:[LEGGINGSID]>);" +
            "\nbeeResistant.add(<[MODID]:[BOOTSID]>);" +
            "\n");


        enableDough = getBoolean("enableDough", categoryItemsFood, true, enableFeatures +
            "\nDough" +
            "\nAn alternative Crafting Recipe for the Chocolate Pie" +
            "\nAn alternative Crafting Recipe for the Cod Pie" +
            "\nAn alternative Crafting Recipe for the Salmon Pie" +
            "\nAn alternative Crafting Recipe for the Tropical Fish Pie" +
            "\nAn alternative Crafting Recipe for the Tailor Pie" +
            "\nAn alternative Crafting Recipe for the Calamari Pie" +
            "\nAn alternative Crafting Recipe for the Saltwort Pie" +
            "\nAn alternative Crafting Recipe for the Shepherd's Pie" +
            "\nAn alternative Crafting Recipe for the Muffin" +
            "\nNotes: This also reverts all the changed vanilla recipes, that use Dough instead of Wheat in this mod" +
            "\n");

        enableOnion = getBoolean("enableOnion", categoryItemsFood, true, enableFeatures +
            "\nOnion" +
            "\nOnion Crate" +
            "\nDressed Herring (Requires Et Futurum Requiem)" +
            "\nSalted Dressed Herring (Requires Et Futurum Requiem)" +
            "\nDandelion Salad" +
            "\nSalted Dandelion Salad" +
            "\nOnion Pie" +
            "\nPickled Onion" +
            "\n");

        enableGoldenFoods = getBoolean("enableGoldenFoods", categoryItemsFood, true, enableFeatures +
            "\nGolden Saltwort" +
            "\nGolden Potato" +
            "\nGolden Sweetberries (Requires Et Futurum Requiem)" +
            "\nGolden Vegetables" +
            "\nSalted Golden Vegetables" +
            "\nGolden Saltwort Salad" +
            "\nGolden Fruit Salad" +
            "\nGolden Fruit Salad" +
            "\n");

        enableSaltedPorkchop = getBoolean("enableSaltedPorkchop", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Porkchop" +
            "\nSalted Cooked Porkchop with Saltwort" +
            "\n");
        enableSaltedSteak = getBoolean("enableSaltedSteak", categoryItemsFood, true, enableFeatures +
            "\nSalted Steak" +
            "\nSalted Steak with Saltwort" +
            "\n");
        enableSaltedChicken = getBoolean("enableSaltedChicken", categoryItemsFood, true, enableFeatures +
            "\nSalted Chicken" +
            "\n");
        enableStrider = getBoolean("enableStrider", categoryItemsFood, true, enableFeatures +
            "\nRaw Strider Flank" +
            "\nStrider Steak" +
            "\nSalted Strider Steak" +
            "\nSalted Strider Steak with Saltwort" +
            "\nNotes: This idea has been shamelessly stolen from Netherlicious. Though, since Et Futurum Requiem currently doesn't add Striders, and Netherlicious already has Strider meat, this meat drops from Bats instead for now" +
            "\n");
        enableHaunch = getBoolean("enableHaunch", categoryItemsFood, true, enableFeatures +
            "\nRaw Haunch" +
            "\nCooked Haunch" +
            "\nSalted Cooked Haunch" +
            "\nSalted Cooked Haunch with Saltwort" +
            "\n");
        enableCuredMeat = getBoolean("enableCuredMeat", categoryItemsFood, true, enableFeatures +
            "\nCured Meat" +
            "\n");
        enableSaltedCod = getBoolean("enableSaltedCod", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Cod" +
            "\nNotes: This is in line with the texture and localization changes this mod makes to the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions" +
            "\n");
        enableSaltedSalmon = getBoolean("enableSaltedSalmon", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Salmon" +
            "\n");
        enableTropicalFish = getBoolean("enableTropicalFish", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Tropical Fish" +
            "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 2), to better reflect the modern Minecraft versions" +
            "\n");
        enableTailor = getBoolean("enableTailor", categoryItemsFood, true, enableFeatures +
            "\nTailor" +
            "\nCooked Tailor" +
            "\nSalted Cooked Tailor" +
            "\nTailor Pie" +
            "\nNotes: This replaces the vanilla Fish (with the meta value of 0) in texture, to better reflect the modern Minecraft versions" +
            "\n");
        enableCalamari = getBoolean("enableCalamari", categoryItemsFood, true, enableFeatures +
            "\nRaw Calamari" +
            "\nCooked Calamari" +
            "\nSalted Cooked Calamari" +
            "\nCalamari Pie" +
            "\nPickled Calamari" +
            "\n");
        enableSaltedBread = getBoolean("enableSaltedBread", categoryItemsFood, true, enableFeatures +
            "\nSalted Bread" +
            "\n");
        enableSaltedPotato = getBoolean("enableSaltedPotato", categoryItemsFood, true, enableFeatures +
            "\nSalted Baked Potato" +
            "\n");
        enableEgg = getBoolean("enableEgg", categoryItemsFood, true, enableFeatures +
            "\nSoft-Boiled Egg" +
            "\n");

        enableSaltedMushroomStew = getBoolean("enableSaltedMushroomStew", categoryItemsFood, true, enableFeatures +
            "\nSalted Mushroom Stew" +
            "\n");

        enablePumpkinPorridge = getBoolean("enablePumpkinPorridge", categoryItemsFood, true, enableFeatures +
            "\nPumpkin Porridge" +
            "\nSalted Pumpkin Porridge" +
            "\n");
        enableCactusSoup = getBoolean("enableCactusSoup", categoryItemsFood, true, enableFeatures +
            "\nCactus Soup" +
            "\nSalted Cactus Soup" +
            "\n");
        enableStewedVegetables = getBoolean("enableStewedVegetables", categoryItemsFood, true, enableFeatures +
            "\nStewed Vegetables" +
            "\nSalted Stewed Vegetables" +
            "\n");
        enablePotatoMushroom = getBoolean("enablePotatoMushroom", categoryItemsFood, true, enableFeatures +
            "\nPotato with Mushroom" +
            "\nSalted Potato with Mushroom" +
            "\n");
        enableFishSoup = getBoolean("enableFishSoup", categoryItemsFood, true, enableFeatures +
            "\nFish Soup" +
            "\nSalted Fish Soup" +
            "\n");
        enableDandelionSalad = getBoolean("enableDandelionSalad", categoryItemsFood, true, enableFeatures +
            "\nDandelion Salad" +
            "\nSalted Dandelion Salad" +
            "\n");
        enableWheatSprouts = getBoolean("enableWheatSprouts", categoryItemsFood, true, enableFeatures +
            "\nWheat Sprouts" +
            "\nSalted Wheat Sprouts" +
            "\n");
        enableSaltwortSalad = getBoolean("enableSaltwortSalad", categoryItemsFood, true, enableFeatures +
            "\nSaltwort Salad" +
            "\n");

        enableSaltwortPorkchop = getBoolean("enableSaltwortPorkchop", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Porkchop with Saltwort" +
            "\n");
        enableSaltwortHoneyPorkchop = getBoolean("enableSaltwortHoneyPorkchop", categoryItemsFood, true, enableFeatures +
            "\nHoney Glazed Porkchop with Saltwort" +
            "\n");
        enableSaltwortSteak = getBoolean("enableSaltwortSteak", categoryItemsFood, true, enableFeatures +
            "\nSalted Steak with Saltwort" +
            "\n");
        enableSaltwortStrider = getBoolean("enableSaltwortStrider", categoryItemsFood, true, enableFeatures +
            "\nSalted Strider Steak with Saltwort" +
            "\n");
        enableSaltwortHaunch = getBoolean("enableSaltwortHaunch", categoryItemsFood, true, enableFeatures +
            "\nSalted Cooked Haunch with Saltwort" +
            "\n");

        enableSugaredApple = getBoolean("enableSugaredApple", categoryItemsFood, true, enableFeatures +
            "\nSugared Apple" +
            "\n");
        enableSugaredMelon = getBoolean("enableSugaredMelon", categoryItemsFood, true, enableFeatures +
            "\nSugared Melon" +
            "\n");

        enableFruitSalad = getBoolean("enableFruitSalad", categoryItemsFood, true, enableFeatures +
            "\nFruit Salad" +
            "\nSugared Fruit Salad" +
            "\n");
        enableGratedCarrot = getBoolean("enableGratedCarrot", categoryItemsFood, true, enableFeatures +
            "\nGrated Carrot" +
            "\nSugared Grated Carrot" +
            "\n");
        enableMelonSoup = getBoolean("enableMelonSoup", categoryItemsFood, true, enableFeatures +
            "\nMelon Soup" +
            "\nSugared Melon Soup" +
            "\n");

        enableHoneyPorkchop = getBoolean("enableHoneyPorkchop", categoryItemsFood, true, enableFeatures +
            "\nHoney Glazed Porkchop" +
            "\n");
        enableHoneyApple = getBoolean("enableHoneyApple", categoryItemsFood, true, enableFeatures +
            "\nHoney Glazed Apple" +
            "\n");
        enableChocolatebar = getBoolean("enableChocolatebar", categoryItemsFood, true, enableFeatures +
            "\nChocolate Bar" +
            "\n");

        enableChocolatePie = getBoolean("enableChocolatePie", categoryItemsFood, true, enableFeatures +
            "\nChocolate Pie" +
            "\n");
        enableBirthdayPie = getBoolean("enableBirthdayPie", categoryItemsFood, true, enableFeatures +
            "\nBirthday Pie" +
            "\n");
        replaceCake = getBoolean("replaceCake", categoryItemsFood, false, "Disables the Crafting Recipe for Cake, effectively replacing the Cake with the Birthday Pie");
        enableApplePie = getBoolean("enableApplePie", categoryItemsFood, true, enableFeatures +
            "\nApple Pie" +
            "\n");
        enableCarrotPie = getBoolean("enableCarrotPie", categoryItemsFood, true, enableFeatures +
            "\nCarrot Pie" +
            "\n");
        enableMushroomPie = getBoolean("enableMushroomPie", categoryItemsFood, true, enableFeatures +
            "\nMushroom Pie" +
            "\n");
        enablePotatoPie = getBoolean("enablePotatoPie", categoryItemsFood, true, enableFeatures +
            "\nPotato Pie" +
            "\n");
        enableOnionPie = getBoolean("enableOnionPie", categoryItemsFood, true, enableFeatures +
            "\nOnion Pie" +
            "\n");
        enableShepherdsPie = getBoolean("enableShepherdsPie", categoryItemsFood, true, enableFeatures +
            "\nShepherd's Pie" +
            "\n");
        enableCodPie = getBoolean("enableCodPie", categoryItemsFood, true, enableFeatures +
            "\nCod Pie" +
            "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions" +
            "\n");
        enableSalmonPie = getBoolean("enableSalmonPie", categoryItemsFood, true, enableFeatures +
            "\nSalmon Pie" +
            "\n");
        enableTropicalFishPie = getBoolean("enableTropicalFishPie", categoryItemsFood, true, enableFeatures +
            "\nTropical Fish Pie" +
            "\nNotes: This is in line with the localization changes this mod makes to the vanilla Fish (with the meta value of 2), to better reflect the modern Minecraft versions" +
            "\n");
        enableTailorPie = getBoolean("enableTailorPie", categoryItemsFood, true, enableFeatures +
            "\nTailor Pie" +
            "\nNotes: This replaces an obligatory \"Fish Pie\" that would be named after the vanilla Fish (with the meta value of 0), to better reflect the modern Minecraft versions" +
            "\n");
        enableCalamariPie = getBoolean("enableCalamariPie", categoryItemsFood, true, enableFeatures +
            "\nCalamari Pie" +
            "\n");
        enableSaltwortPie = getBoolean("enableSaltwortPie", categoryItemsFood, true, enableFeatures +
            "\nSaltwort Pie" +
            "\n");

        enableFermentedSaltwort = getBoolean("enableFermentedSaltwort", categoryItemsFood, true, enableFeatures +
            "\nFermented Saltwort" +
            "\n");
        enableFermentedFern = getBoolean("enableFermentedFern", categoryItemsFood, true, enableFeatures +
            "\nFermented Fern" +
            "\n");
        enableFermentedMushroom = getBoolean("enableFermentedMushroom", categoryItemsFood, true, enableFeatures +
            "\nFermented Mushroom" +
            "\n");
        enablePickledCalamari = getBoolean("enablePickledCalamari", categoryItemsFood, true, enableFeatures +
            "\nPickled Calamari" +
            "\n");
        enablePickledOnion = getBoolean("enablePickledOnion", categoryItemsFood, true, enableFeatures +
            "\nPickled Onion" +
            "\n");
        enableApplePreserves = getBoolean("enableApplePreserves", categoryItemsFood, true, enableFeatures +
            "\nApple Preserves" +
            "\n");
        enableMelonPreserves = getBoolean("enableMelonPreserves", categoryItemsFood, true, enableFeatures +
            "\nMelon Preserves" +
            "\n");

        enableMuffin = getBoolean("enableMuffin", categoryItemsFood, true, enableFeatures +
            "\nMuffin" +
            "\n");

        enableToughJelly = getBoolean("enableToughJelly", categoryItemsFood, true, enableFeatures +
            "\nTough Jelly" +
            "\n");


        enableEFRFoodValueChanges = getBoolean("enableEFRFoodValueChanges", categoryModCompatibility, true, "Changes the food values of the Et Futurum Requiem Foods, to better fit the new balancing:" +
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
            "\nNotes: The first value refers to the number of half hunger shanks the respective item returns. The second value refers to the saturation. For a more detailed understanding, refer to this table and halve the \"Saturation Ratio\" values depicted there: https://minecraft.fandom.com/wiki/Food#Foods" +
            "\n");

        enableTFSaltOre = getBoolean("enableTFSaltOre", categoryModCompatibility, true, "Enables Salt Ore Generation in the Twilight Forest Dimension");


        enableBlossomWood = getBoolean("enableBlossomWood", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Wood" +
            "\n" + compatibilityString1 + "Blossom Wood" + compatibilityString2 +
            "\n");
        enableStrippedBlossomLogs = getBoolean("enableStrippedBlossomLogs", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nStripped Blossom Logs" +
            "\n" + compatibilityString1 + "Stripped Blossom Logs" + compatibilityString2 +
            "\n");
        enableBlossomFence = getBoolean("enableBlossomFence", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Fence" +
            "\n" + compatibilityString1 + "Blossom Fence" + compatibilityString2 +
            "\n");
        enableBlossomFenceGate = getBoolean("enableBlossomFenceGate", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Fence Gate" +
            "\n" + compatibilityString1 + "Blossom Fence Gate" + compatibilityString2 +
            "\n");
        enableBlossomPressurePlate = getBoolean("enableBlossomPressurePlate", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Pressure Plate" +
            "\n" + compatibilityString1 + "Blossom Pressure Plate" + compatibilityString2 +
            "\n");
        enableBlossomButton = getBoolean("enableBlossomButton", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Button" +
            "\n" + compatibilityString1 + "Blossom Button" + compatibilityString2 +
            "\n");
        enableBlossomDoor = getBoolean("enableBlossomDoor", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Door" +
            "\n" + compatibilityString1 + "Blossom Door" + compatibilityString2 +
            "\n");
        enableBlossomTrapdoor = getBoolean("enableBlossomTrapdoor", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Trapdoor" +
            "\n" + compatibilityString1 + "Blossom Trapdoor" + compatibilityString2 +
            "\n");
        enableBlossomSign = getBoolean("enableBlossomSign", categoryModCompatibilityBlocks, true, enableFeatures +
            "\nBlossom Sign" +
            "\n" + compatibilityString1 + "Blossom Sign" + compatibilityString2 +
            "\n");


        enableSaltedRabbit = getBoolean("enableSaltedRabbit", categoryModCompatibilityItems, true, enableFeatures+
            "\nSalted Cooked Rabbit" +
            "\n" + compatibilityString1 + "Salted Cooked Rabbit" + compatibilityString2 +
            "\n");
        enableSaltedMutton = getBoolean("enableSaltedMutton", categoryModCompatibilityItems, true, enableFeatures+
            "\nSalted Cooked Mutton" +
            "\n" + compatibilityString1 + "Salted Cooked Mutton" + compatibilityString2 +
            "\n");
        enableSaltedBeetroot = getBoolean("enableSaltedBeetroot", categoryModCompatibilityItems, true, enableFeatures+
            "\nSalted Beetroot" +
            "\n" + compatibilityString1 + "Salted Beetroot" + compatibilityString2 +
            "\n");
        enableSaltedRabbitRagout = getBoolean("enableSaltedRabbitRagout", categoryModCompatibilityItems, true, enableFeatures+
            "\nSalted Rabbit Ragout" +
            "\n" + compatibilityString1 + "Salted Rabbit Ragout" + compatibilityString2 +
            "\n");
        enableSaltedBorscht = getBoolean("enableSaltedBorscht", categoryModCompatibilityItems, true, enableFeatures+
            "\nSalted Borscht" +
            "\n" + compatibilityString1 + "Salted Borscht" + compatibilityString2 +
            "\n");

        enableBeetrootSalad = getBoolean("enableBeetrootSalad", categoryModCompatibilityItems, true, enableFeatures+
            "\nBeetroot Salad" +
            "\nSalted Beetroot Salad" +
            "\n" + compatibilityString1 + "Beetroot Salad and Salted Beetroot Salad" + compatibilityString2 +
            "\n");
        enableDressedHerring = getBoolean("enableDressedHerring", categoryModCompatibilityItems, true, enableFeatures+
            "\nDressed Herring" +
            "\nSalted Dressed Herring" +
            "\n" + compatibilityString1 + "Dressed Herring and Salted Dressed Herring" + compatibilityString2 +
            "\n");

        enableSugaredBerries = getBoolean("enableSugaredBerries", categoryModCompatibilityItems, true, enableFeatures+
            "\nSugared Sweetberries" +
            "\n" + compatibilityString1 + "Sugared Sweetberries" + compatibilityString2 +
            "\n");
        enableHoneyBerries = getBoolean("enableHoneyBerries", categoryModCompatibilityItems, true, enableFeatures+
            "\nHoney Glazed Sweetberries" +
            "\n" + compatibilityString1 + "Honey Glazed Sweetberries" + compatibilityString2 +
            "\n");
        enableChocolateBerries = getBoolean("enableChocolateBerries", categoryModCompatibilityItems, true, enableFeatures+
            "\nChocolate Laced Sweetberries" +
            "\n" + compatibilityString1 + "Chocolate Laced Sweetberries" + compatibilityString2 +
            "\n");
        enableBerryPie = getBoolean("enableBerryPie", categoryModCompatibilityItems, true, enableFeatures+
            "\nSweetberry Pie" +
            "\n" + compatibilityString1 + "Sweetberry Pie" + compatibilityString2 +
            "\n");
        enablePickledBeetroot = getBoolean("enablePickledBeetroot", categoryModCompatibilityItems, true, enableFeatures+
            "\nPickled Beetroot" +
            "\n" + compatibilityString1 + "Pickled Beetroot" + compatibilityString2 +
            "\n");
        enableBerryPreserves = getBoolean("enableBerryPreserves", categoryModCompatibilityItems, true, enableFeatures+
            "\nSweetberry Preserves" +
            "\n" + compatibilityString1 + "Sweetberry Preserves" + compatibilityString2 +
            "\n");

        enableTFFoods = getBoolean("enableTFFoods", categoryModCompatibilityItems, true, enableFeatures +
            "\nSalted Venison Steak" +
            "\nSalted Meef Steak" +
            "\nSalted Meef Stroganoff" +
            "\nSalted Hyrda Chop" +
            "\nPickled Mushgloom" +
            "\nVenison Steak with Saltwort" +
            "\nMeef Steak with Saltwort" +
            "\nNotes: This is for when you have Twilight Forest installed, but for some reason, don't want the respective Foods to be present" +
            "\n");

        enableBOPFoods = getBoolean("enableBOPFoods", categoryModCompatibilityItems, true, enableFeatures +
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


        enableVanillaFoodValueChanges = getBoolean("enableVanillaFoodValueChanges", categoryVanillaChanges, true, "Changes the food values of the vanilla Foods, to better fit the new balancing:" +
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
            "\nNotes: The first value refers to the number of half hunger shanks the respective item returns. The second value refers to the saturation. For a more detailed understanding, refer to this table and halve the \"Saturation Ratio\" values depicted there: https://minecraft.fandom.com/wiki/Food#Foods" +
            "\n");

        enableRecipeChanges = getBoolean("enableRecipeChanges", categoryVanillaChanges, true, "Changes the following vanilla Crafting Recipes:" +
            "\nMushroom Stew - Now gets crafted with an Ore Dictionary, allowing you to use either two Mushrooms to craft it" +
            "\nBread - Now gets crafted by burning Dough in a Furnace (or a Smoker, if Et Futurum Requiem is installed)" +
            "\nCake - Now gets crafted with only one Milk Bucket in the upper row and one Dough in the lower row, instead of three pieces of Wheat" +
            "\nCookie - Now gets crafted with Dough and Cocoa Beans, instead of two pieces of Wheat" +
            "\nPumpkin Pie - Now also needs Dough in addition to Pumpkin, Sugar and an Egg" +
            "\n");


        saltOreFrequency = getInt("saltOreFrequency", categoryWorldGeneration, 4, 1, 10, "Regulates the frequency of the Salt Ore Generation");
        saltoreVeinSize = getInt("saltoreVeinSize", categoryWorldGeneration, 5, 1, 10, "Regulates the size of Salt Ore veins");


        enableSaltMarsh = getBoolean("enableSaltMarsh", categoryWorldGenerationBiomes, true, enableFeatures +
            "\nSalt Marsh" +
            "\nSalt Crusted Oak Logs" +
            "\n");
        saltMarshBiomeID = get(categoryWorldGenerationBiomes, "Sets the Biome ID of the Salt Marsh Biome, setting this to \"-1\" completely disables the Biome", 40).getInt(40);
        saltMarshBiomeWeight = get(categoryWorldGenerationBiomes, "Regulates the Generation chance of Salt Marsh Biomes", 10).getInt(10);
        saltMarshAdditionalSaltOre = getBoolean("saltMarshAdditionalSaltOre", categoryWorldGenerationBiomes, true, "Enables additional Salt Ore Generation in Salt Marsh Biomes");
        saltMarshSaltOreFrequency = getInt("saltMarshSaltOreFrequency", categoryWorldGenerationBiomes, 4, 1, 10, "Regulates the frequency of the additional Salt Ore Generation in Salt Marsh Biomes");


        enableSaltLakes = getBoolean("enableSaltLakes", categoryWorldGenerationStructures, true, enableFeatures +
            "\nSalt Lake" +
            "\nSalt Lake Bottom" +
            "\n");
        saltLakeFrequency = getInt("saltLakeFrequency", categoryWorldGenerationStructures, 500, 1, 1000, "Regulates the frequency of the Salt Lake Group Generation");
        saltLakeQuantity = getInt("saltLakeQuantity", categoryWorldGenerationStructures, 5, 1, 10, "Regulates the quantity of single Salt Lakes in Salt Lake Groups");
        saltLakeDistance = getInt("saltLakeDistance", categoryWorldGenerationStructures, 30, 10, 50, "Regulates the distance between single Salt Lakes in Salt Lake Groups");
        saltLakeRadius = getInt("saltLakeRadius", categoryWorldGenerationStructures, 20, 5, 50, "Regulates the radius of single Salt Lakes");

        enableBrickmakerCamp = getBoolean("enableBrickmakerCamps", categoryWorldGenerationStructures, true, enableFeatures +
            "\nBrickmaker Camp" +
            "\n");
        brickmakerCampFrequency = getInt("brickmakerCampFrequency", categoryWorldGenerationStructures, 300, 10, 1000, "Regulates the frequency of the Brickmaker Camp Generation in Salt Marsh Biomes");

        //TOBEPHASEDOUT
        loadedCloudLevel = getStringList("loadedCloudLevel", categoryTOBEPHASEDOUT, defaultCloudLevel, "The height of the clouds in a specific dimension (DimensionID=CloudLevel)");
        save();
    }

    public void init() {
        Configuration configTF = new Configuration(new File("./config", "TwilightForest.cfg"));
        configTF.load();
        TFDimensionID = configTF.get("dimension", "dimensionID", 7).getInt();
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
