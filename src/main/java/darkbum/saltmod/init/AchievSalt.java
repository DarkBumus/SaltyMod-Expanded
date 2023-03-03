package darkbum.saltmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievSalt {
    public static Achievement salt = (new Achievement("salt", "salt", 0, -1, ModItems.salt, null)).registerStat();

    public static Achievement saltFarm = (new Achievement("saltFarm", "saltFarm", 0, -3, ModItems.saltPinch, salt)).registerStat();

    public static Achievement rain = (new Achievement("rain", "rain", -2, -1, new ItemStack(ModItems.rainmaker), salt)).registerStat();

    public static Achievement mineralMud = (new Achievement("mineralMud", "mineralMud", 2, -1, ModItems.mineralMud, null)).registerStat();

    public static Achievement fullMud = (new Achievement("fullMud", "fullMud", 2, -3, new ItemStack(ModItems.achievItem, 1, 1), mineralMud)).registerStat();

    public static Achievement discomfiture = (new Achievement("discomfiture", "discomfiture", 4, -1, new ItemStack(ModItems.achievItem, 1, 2), mineralMud)).registerStat();

    public static Achievement saltWort = (new Achievement("saltWort", "saltWort", 2, 1, ModItems.saltWortSeed, null)).registerStat();

    public static Achievement saltWortFarm = (new Achievement("saltWortFarm", "saltWortFarm", 2, 3, ModBlocks.saltDirtLite, saltWort)).registerStat();

    public static Achievement fizzyDrink = (new Achievement("fizzyDrink", "fizzyDrink", 4, 1, ModItems.fizzyDrink, saltWort)).registerStat();

    public static Achievement moreBuckets = (new Achievement("moreBuckets", "moreBuckets", 1, 1, Items.water_bucket, null)).registerStat();

    public static Achievement muffin = (new Achievement("muffin", "muffin", 1, -1, ModItems.muffin, null)).registerStat();

    public static Achievement saltCrystal = (new Achievement("saltCrystal", "saltCrystal", 0, 0, ModBlocks.saltCrystal, null)).setSpecial().registerStat();

    public static Achievement saltLake = (new Achievement("saltLake", "saltLake", 2, 0, ModBlocks.saltLake, null)).setSpecial().registerStat();

    public static Achievement saltCrystalGet = (new Achievement("saltCrystalGet", "saltCrystalGet", 0, 1, Items.iron_pickaxe, null)).registerStat();

    public static Achievement saltWitch = (new Achievement("saltWitch", "saltWitch", 0, 3, new ItemStack(ModItems.achievItem, 1, 0), saltCrystalGet)).setSpecial().registerStat();

    public static Achievement saltSlime = (new Achievement("saltSlime", "saltSlime", -2, 1, ModItems.toughJelly, saltCrystalGet)).setSpecial().registerStat();

    public static AchievementPage achievSaltPage = new AchievementPage("Salty Mod", salt, saltFarm, rain, mineralMud, fullMud, discomfiture, saltWort, saltWortFarm, fizzyDrink, moreBuckets,
        muffin, saltCrystalGet, saltSlime, saltWitch, saltLake, saltCrystal);

    public static void init() {
        AchievementPage.registerAchievementPage(achievSaltPage);
    }
}
