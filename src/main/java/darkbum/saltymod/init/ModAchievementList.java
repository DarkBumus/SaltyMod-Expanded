package darkbum.saltymod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ModAchievementList {

    public static Achievement findSalt = new Achievement("achievement.findSalt", "findSalt", 0, -1, ModItems.salt, null).registerStat();

    public static Achievement farmSalt = new Achievement("achievement.farmSalt", "farmSalt", 2, -2, ModItems.salt_pinch, findSalt).registerStat();

    public static Achievement farmEvaporator = new Achievement("achievement.farmEvaporator", "farmEvaporator", 4, -2, Items.bucket, farmSalt).registerStat();

    public static Achievement explodeEvaporator = new Achievement("achievement.explodeEvaporator", "explodeEvaporator", 4, -4, new ItemStack(ModBlocks.evaporator), farmEvaporator).registerStat();

    public static Achievement navSaltLake = new Achievement("achievement.navSaltLake", "navSaltLake", 0, 1, ModBlocks.salt_lake_ore, null).setSpecial().registerStat();

    public static Achievement findMineralMud = new Achievement("achievement.findMineralMud", "findMineralMud", 2, 2, ModItems.mineral_mud_ball, navSaltLake).registerStat();

    public static Achievement fullMudArmor = new Achievement("achievement.fullMudArmor", "fullMudArmor", 4, 2, new ItemStack(ModItems.mud_chestplate), findMineralMud).registerStat();

    public static Achievement discomfort = new Achievement("achievement.discomfort", "discomfort", 4, 4, new ItemStack(Blocks.water), fullMudArmor).registerStat();


    public static Achievement rain = new Achievement("achievement.rain", "rain", 10, 10, new ItemStack(ModItems.rainmaker), findSalt).registerStat();

    public static Achievement saltwort = new Achievement("achievement.saltwort", "saltwort", 10, 10, ModItems.saltwort, null).registerStat();

    public static Achievement saltwortFarm = new Achievement("achievement.saltwortFarm", "saltwortFarm", 10, 10, ModBlocks.salt_dirt, saltwort).registerStat();

    public static Achievement fizzyDrink = new Achievement("achievement.fizzyDrink", "fizzyDrink", 10, 10, ModItems.fizzy_drink, saltwort).registerStat();

    public static Achievement muffin = new Achievement("achievement.muffin", "muffin", 10, 10, ModItems.muffin, null).registerStat();


    public static Achievement saltCrystalGet = new Achievement("achievement.saltCrystalGet", "saltCrystalGet", 10, 10, Items.iron_pickaxe, null).registerStat();

    public static Achievement saltCrystalKill = new Achievement("achievement.saltCrystalKill", "saltCrystalKill", 10, 10, new ItemStack(ModBlocks.salt_crystal), saltCrystalGet).setSpecial().registerStat();

    public static Achievement saltWitch = new Achievement("achievement.saltWitch", "saltWitch", 10, 10, new ItemStack(ModItems.salt_shard), saltCrystalGet).setSpecial().registerStat();

    public static Achievement saltSlime = new Achievement("achievement.saltSlime", "saltSlime", 10, 10, ModItems.tough_jelly, saltCrystalGet).setSpecial().registerStat();

    public static Achievement stung = new Achievement("achievement.stung", "stung", 10, 10, ModItems.carpenter_bee, null).registerStat();

    public static AchievementPage achievSaltPage = new AchievementPage("Salty Mod", findSalt, farmSalt, rain, findMineralMud, fullMudArmor, discomfort, saltwort, saltwortFarm, fizzyDrink, farmEvaporator, explodeEvaporator, muffin, saltCrystalGet, saltCrystalKill, saltSlime, saltWitch, navSaltLake, stung);
    public static void init() {
        AchievementPage.registerAchievementPage(achievSaltPage);
    }
}
