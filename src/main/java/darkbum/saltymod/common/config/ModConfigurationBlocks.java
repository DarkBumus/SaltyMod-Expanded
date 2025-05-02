package darkbum.saltymod.common.config;

import net.minecraftforge.common.config.Configuration;

public class ModConfigurationBlocks {

    // Category Strings
    private static final String categoryNameBlo = "blocks";
    private static final String categoryDescriptionBlo = "All the Blocks configuration that doesn't touch Mod Compatibility";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityStringEFR1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityStringEFR2 = " to be present";

    // Blocks Config Options
    public static boolean enableSaltBlocks;

    public static boolean enableSaltDirt;

    public static boolean enableMudBricks;
    public static boolean complexMudBricks;

    public static boolean enableEvaporator;
    public static int evaporatorVolume;

    public static boolean enableFishFarm;
    public static int fishFarmSpeed;

    public static boolean enableApiary;
    public static int apiarySpeed;

    public static boolean enableMachines;

    public static boolean enableStorageBlocks;

    public static boolean enableSaltCrystal;
    public static int saltCrystalGrowthSpeed;

    public static int saltwortGrowthSpeed;

    public static boolean enableSaltFlowers;
    public static boolean saltFlowersLargeHitbox;

    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameBlo, categoryDescriptionBlo);

        enableSaltBlocks = config.getBoolean(
            "01-enableSaltBlocks",
            categoryNameBlo,
            true,
            enableFeatures + "\nSalt Block"
                + "\nChiseled Salt Block"
                + "\nSalt Pillar"
                + "\nSalt Bricks"
                + "\nCracked Salt Block"
                + "\nCracked Salt Bricks"
                + "\nChiseled Salt Bricks"
                + "\nSalt Chapiter"
                + "\nSalt Brick Stairs"
                + "\nSalt Slab"
                + "\nSalt Brick Slab"
                + "\nSalt Pillar Slab"
                + "\nSalt Lamp"
                + "\n");

        enableSaltDirt = config.getBoolean(
            "02-enableSaltDirt",
            categoryNameBlo,
            true,
            enableFeatures + "\nSalt Grass" + "\nLight Salt Dirt" + "\nSalt Lake Bottom (Dirt)" + "\nSalt Dirt" + "\n");

        enableMudBricks = config.getBoolean(
            "03-enableMudBricks",
            categoryNameBlo,
            true,
            enableFeatures + "\nWet Mud Bricks"
                + "\nMud Bricks"
                + "\nMud Brick Stairs"
                + "\nMud Brick Slab"
                + "\nMud Brick Wall (Requires Et Futurum Requiem)"
                + "\n");
        complexMudBricks = config.getBoolean(
            "04-complexMudBricks",
            categoryNameBlo,
            true,
            "Enables the a complex drying mechanic on Wet Mud Bricks (by enabling their random tick functionality) and disables the furnace recipe");

        enableEvaporator = config.getBoolean(
            "05-enableEvaporator",
            categoryNameBlo,
            true,
            enableFeatures + "\nEvaporator" + "\nPowdered Milk" + "\n");
        evaporatorVolume = config.getInt(
            "06-evaporatorVolume",
            categoryNameBlo,
            1,
            1,
            3,
            "Regulates the number of buckets that can be poured into an evaporator at once");

        enableFishFarm = config
            .getBoolean("07-enableFishFarm", categoryNameBlo, true, enableFeatures + "\nFish Farm" + "\nFish Bait" + "\n");
        fishFarmSpeed = config.getInt(
            "08-fishFarmSpeed",
            categoryNameBlo,
            3500,
            1,
            999999,
            "Regulates the speed in ticks at which an Fish Farm will fill itself up, not including the bonuses from rainfall."
                + "\nThe lower the value, the higher the chance, per tick, that a slot will be filled, i.e. the quicker the Fish Farm will fill up.");

        enableApiary = config.getBoolean(
            "09-enableApiary",
            categoryNameBlo,
            true,
            enableFeatures + "\nApiary" + "\nBee Nest" + "\nBee Burrow" + "\n");
        apiarySpeed = config.getInt(
            "10-apiarySpeed",
            categoryNameBlo,
            3500,
            1,
            999999,
            "Regulates the speed in ticks at which an Apiary will fill itself up, not including the bonuses from nearby apiaries and flowers."
                + "\nThe lower the value, the higher the chance, per tick, that a slot will be filled, i.e. the quicker the Apiary will fill up.");

        enableMachines = config.getBoolean(
            "11-enableMachines",
            categoryNameBlo,
            true,
            enableFeatures + "\nHeater"
                + "\n");

        enableStorageBlocks = config.getBoolean(
            "11-enableStorageBlocks",
            categoryNameBlo,
            true,
            enableFeatures + "\nCarrot Crate"
                + "\nPotato Crate"
                + "\nPoisonous Potato Crate"
                + "\nOnion Crate"
                + "\nBeetroot Crate (Requires Et Futurum Requiem)"
                + "\nCod Barrel"
                + "\nSalmon Barrel"
                + "\nTropical Fish Barrel"
                + "\nTailor Barrel"
                + "\nPufferfish Barrel"
                + "\nWheat Seed Sack"
                + "\nMelon Seed Sack"
                + "\nPumpkin Seed Sack"
                + "\nSaltwort Sack"
                + "\nBeetroot Seed Sack (Requires Et Futurum Requiem)"
                + "\n");

        enableSaltCrystal = config.getBoolean(
            "12-enableSaltCrystal",
            categoryNameBlo,
            true,
            enableFeatures + "\nSalt Crystal" + "\nSalt Shard" + "\n");
        saltCrystalGrowthSpeed = config.getInt(
            "13-saltCrystalGrowthSpeed",
            categoryNameBlo,
            14,
            1,
            20,
            "Regulates the Salt Crystal growth speed (1 - faster, 20 - slower)");

        saltwortGrowthSpeed = config.getInt(
            "14-saltwortGrowthSpeed",
            categoryNameBlo,
            7,
            1,
            20,
            "Regulates the Saltwort growth speed (1 - faster, 20 - slower)");

        enableSaltFlowers = config.getBoolean(
            "15-enableSaltFlowers",
            categoryNameBlo,
            true,
            enableFeatures + "\nDaucus"
                + "\nSolanum"
                + "\nMaritima"
                + "\nMaritima (Requires Et Futurum Requiem)"
                + "\n");

        saltFlowersLargeHitbox = config.getBoolean(
            "16-saltFlowersLargeHitbox",
            categoryNameBlo,
            false,
            "Changes the hitbox of the flowers with vegetables growing under them, to make them more distinct.");
    }
}
