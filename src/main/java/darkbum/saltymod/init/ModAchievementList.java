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

    public static Achievement witchSaltCrystal = new Achievement("achievement.witchSaltCrystal", "witchSaltCrystal", -3, -3, new ItemStack(ModItems.powdered_milk, 1, 3), findSaltCrystal).setSpecial().registerStat();


    public static Achievement farmSalt = new Achievement("achievement.farmSalt", "farmSalt", 2, -2, ModItems.salt_pinch, findSalt).registerStat();

    public static Achievement makeRain = new Achievement("achievement.makeRain", "makeRain", 2, -4, ModItems.rainmaker, farmSalt).registerStat();

    public static Achievement farmEvaporator = new Achievement("achievement.farmEvaporator", "farmEvaporator", 4, -2, Items.bucket, farmSalt).registerStat();

    public static Achievement explodeEvaporator = new Achievement("achievement.explodeEvaporator", "explodeEvaporator", 4, -4, ModBlocks.evaporator, farmEvaporator).setSpecial().registerStat();


    public static Achievement navSaltMarsh = new Achievement("achievement.navSaltMarsh", "navSaltMarsh", 2, 0, ModBlocks.salt_grass, null).registerStat();

    public static Achievement findOnion = new Achievement("achievement.findOnion", "findOnion", 4, 0, ModItems.onion, navSaltMarsh).registerStat();

    public static Achievement findMudBrick = new Achievement("achievement.findMudBrick", "findMudBrick", 6, 0, ModBlocks.dry_mud_brick, findOnion).registerStat();


    public static Achievement navSaltLake = new Achievement("achievement.navSaltLake", "navSaltLake", 0, 1, ModBlocks.salt_lake, null).registerStat();

    public static Achievement findMineralMud = new Achievement("achievement.findMineralMud", "findMineralMud", 2, 2, ModItems.mineral_mud_ball, navSaltLake).registerStat();

    public static Achievement fullMudArmor = new Achievement("achievement.fullMudArmor", "fullMudArmor", 4, 2, new ItemStack(ModItems.powdered_milk, 1, 1), findMineralMud).registerStat();

    public static Achievement destroyMudArmor = new Achievement("achievement.destroyMudArmor", "destroyMudArmor", 6, 2, new ItemStack(ModItems.powdered_milk, 1, 2), fullMudArmor).registerStat();


    public static Achievement findSaltwort = new Achievement("achievement.findSaltwort", "findSaltwort", -2, 0, ModItems.saltwort, null).registerStat();

    public static Achievement farmSaltwort = new Achievement("achievement.farmSaltwort", "farmSaltwort", -4, 0, ModBlocks.salt_dirt_lite, findSaltwort).registerStat();

    public static Achievement consumeFizzyDrink = new Achievement("achievement.consumeFizzyDrink", "consumeFizzyDrink", -4, 2, ModItems.fizzy_drink, findSaltwort).registerStat();

    public static Achievement findDough = new Achievement("achievement.findDough", "findDough", -2, 4, ModItems.dough, findSaltwort).registerStat();

    public static Achievement consumeSpecMuffin = new Achievement("achievement.consumeSpecMuffin", "consumeSpecMuffin", -2, 6, ModItems.muffin, findDough).setSpecial().registerStat();


    public static Achievement effectSwarmed = new Achievement("achievement.effectSwarmed", "effectSwarmed", 0, 6, ModItems.carpenter_bee, null).registerStat();

    public static Achievement craftApiary = new Achievement("achievement.craftApiary", "craftApiary", 2, 6, ModBlocks.apiary, effectSwarmed).registerStat();

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
        findDough,
        consumeSpecMuffin,
        navSaltMarsh,
        findOnion,
        findMudBrick,
        effectSwarmed,
        craftApiary
    );

    public static void init() {
        AchievementPage.registerAchievementPage(achievSaltPage);
    }
}
