package darkbum.saltymod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ModAchievementList {

    public static Achievement findSalt = new Achievement("achievement.findSalt", "findSalt", 0, -1, ModItems.salt, null).registerStat();

    public static Achievement findSaltCrystal = new Achievement("achievement.findSaltCrystal", "findSaltCrystal", -4, -2, Items.iron_pickaxe, findSalt).registerStat();

    public static Achievement navelseSaltCrystal = new Achievement("achievement.navelseSaltCrystal", "navelseSaltCrystal", -4, -4, ModBlocks.salt_crystal, findSaltCrystal).setSpecial().registerStat();

    public static Achievement slimeSaltCrystal = new Achievement("achievement.slimeSaltCrystal", "slimeSaltCrystal", -5, -3, ModItems.tough_jelly, findSaltCrystal).setSpecial().registerStat();

    public static Achievement witchSaltCrystal = new Achievement("achievement.witchSaltCrystal", "witchSaltCrystal", -3, -3, new ItemStack(ModItems.salt_shard), findSaltCrystal).setSpecial().registerStat();


    public static Achievement farmSalt = new Achievement("achievement.farmSalt", "farmSalt", 2, -2, ModItems.salt_pinch, findSalt).registerStat();

    public static Achievement makeRain = new Achievement("achievement.makeRain", "makeRain", 2, -4, ModItems.rainmaker, farmSalt).registerStat();

    public static Achievement farmEvaporator = new Achievement("achievement.farmEvaporator", "farmEvaporator", 4, -2, Items.bucket, farmSalt).registerStat();

    public static Achievement explodeEvaporator = new Achievement("achievement.explodeEvaporator", "explodeEvaporator", 4, -4, ModBlocks.evaporator, farmEvaporator).setSpecial().registerStat();


    public static Achievement navSaltLake = new Achievement("achievement.navSaltLake", "navSaltLake", 0, 1, ModBlocks.salt_lake_ore, null).registerStat();

    public static Achievement findMineralMud = new Achievement("achievement.findMineralMud", "findMineralMud", 2, 2, ModItems.mineral_mud_ball, navSaltLake).registerStat();

    public static Achievement fullMudArmor = new Achievement("achievement.fullMudArmor", "fullMudArmor", 4, 2, ModItems.mud_chestplate, findMineralMud).registerStat();

    public static Achievement destroyMudArmor = new Achievement("achievement.destroyMudArmor", "destroyMudArmor", 4, 4, Items.water_bucket, fullMudArmor).registerStat();

    public static Achievement findSaltwort = new Achievement("achievement.findSaltwort", "findSaltwort", 6, 2, ModItems.saltwort, fullMudArmor).registerStat();

    public static Achievement farmSaltwort = new Achievement("achievement.farmSaltwort", "farmSaltwort", 6, 4, ModBlocks.salt_dirt, findSaltwort).registerStat();

    public static Achievement consumeFizzyDrink = new Achievement("achievement.consumeFizzyDrink", "consumeFizzyDrink", 8, 2, ModItems.fizzy_drink, findSaltwort).registerStat();


    public static Achievement navSaltMarsh = new Achievement("achievement.navSaltMarsh", "navSaltMarsh", 2, 0, ModBlocks.salt_grass, null).registerStat();

    public static Achievement findMudBrick = new Achievement("achievement.findMudBrick", "findMudBrick", 4, 0, ModBlocks.dry_mud_brick, navSaltMarsh).registerStat();


    public static Achievement findBlossomLog = new Achievement("achievement.findBlossomLog", "findBlossomLog", -2, 0, ModBlocks.blossom_log, null).registerStat();

    public static Achievement effectSwarmed = new Achievement("achievement.effectSwarmed", "effectSwarmed", -2, 2, ModItems.carpenter_bee, findBlossomLog).registerStat();


    public static Achievement craftApiary = new Achievement("achievement.craftApiary", "craftApiary", -4, 0, ModBlocks.apiary, findBlossomLog).registerStat();

    public static Achievement consumeSpecMuffin = new Achievement("achievement.consumeSpecMuffin", "consumeSpecMuffin", -4, 2, ModItems.muffin, craftApiary).setSpecial().registerStat();


    public static AchievementPage achievSaltPage = new AchievementPage("SaltyMod Expanded",
        findSalt,
        findSaltCrystal,
        navelseSaltCrystal,
        slimeSaltCrystal,
        witchSaltCrystal,
        farmSalt,
        makeRain,
        farmEvaporator,
        explodeEvaporator,
        navSaltLake,
        findMineralMud,
        fullMudArmor,
        destroyMudArmor,
        findSaltwort,
        farmSaltwort,
        consumeFizzyDrink,
        navSaltMarsh,
        findMudBrick,
        findBlossomLog,
        craftApiary,
        consumeSpecMuffin,
        effectSwarmed);

    public static void init() {
        AchievementPage.registerAchievementPage(achievSaltPage);
    }
}
