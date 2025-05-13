package darkbum.saltymod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import static net.minecraftforge.common.AchievementPage.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Items.*;

/**
 * Achievement class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModAchievementList {

    public static Achievement find_salt = new Achievement(
        "achievement.find_salt",
        "find_salt",
        0,
        -1,
        salt,
        null).registerStat();

    public static Achievement find_salt_crystal = new Achievement(
        "achievement.find_salt_crystal",
        "find_salt_crystal",
        -4,
        -2,
        iron_pickaxe,
        find_salt).registerStat();

    public static Achievement nav_salt_crystal = new Achievement(
        "achievement.nav_salt_crystal",
        "nav_salt_crystal",
        -4,
        -4,
        Items.bone,
        find_salt_crystal).registerStat();

    public static Achievement navelse_salt_crystal = new Achievement(
        "achievement.navelse_salt_crystal",
        "navelse_salt_crystal",
        -4,
        -6,
        salt_crystal,
        nav_salt_crystal).setSpecial().registerStat();

    public static Achievement slime_salt_crystal = new Achievement(
        "achievement.slime_salt_crystal",
        "slime_salt_crystal",
        -5,
        -3,
        tough_jelly,
        find_salt_crystal).setSpecial().registerStat();

    public static Achievement witch_salt_crystal = new Achievement(
        "achievement.witch_salt_crystal",
        "witch_salt_crystal",
        -3,
        -3,
        new ItemStack(dev_item, 1, 2),
        find_salt_crystal).setSpecial().registerStat();

    public static Achievement farm_salt = new Achievement(
        "achievement.farm_salt",
        "farm_salt",
        2,
        -2,
        salt_pinch,
        find_salt).registerStat();

    public static Achievement make_rain = new Achievement(
        "achievement.make_rain",
        "make_rain",
        2,
        -4,
        rainmaker,
        farm_salt).registerStat();

    public static Achievement farm_evaporator = new Achievement(
        "achievement.farm_evaporator",
        "farm_evaporator",
        4,
        -2,
        Items.bucket,
        farm_salt).registerStat();

    public static Achievement explode_evaporator = new Achievement(
        "achievement.explode_evaporator",
        "explode_evaporator",
        4,
        -4,
        evaporator,
        farm_evaporator).setSpecial().registerStat();

    public static Achievement nav_salt_marsh = new Achievement(
        "achievement.nav_salt_marsh",
        "nav_salt_marsh",
        2,
        0,
        salt_grass,
        null).registerStat();

    public static Achievement find_onion = new Achievement(
        "achievement.find_onion",
        "find_onion",
        4,
        0,
        onion,
        nav_salt_marsh).registerStat();

    public static Achievement find_mud_brick = new Achievement(
        "achievement.find_mud_brick",
        "find_mud_brick",
        6,
        0,
        dry_mud_brick,
        find_onion).registerStat();

    public static Achievement nav_salt_lake = new Achievement(
        "achievement.nav_salt_lake",
        "nav_salt_lake",
        0,
        1,
        salt_lake,
        null).registerStat();

    public static Achievement find_mineral_mud = new Achievement(
        "achievement.find_mineral_mud",
        "find_mineral_mud",
        2,
        2,
        mineral_mud_ball,
        nav_salt_lake).registerStat();

    public static Achievement full_mud_armor = new Achievement(
        "achievement.full_mud_armor",
        "full_mud_armor",
        4,
        2,
        new ItemStack(dev_item, 1, 0),
        find_mineral_mud).registerStat();

    public static Achievement destroy_mud_armor = new Achievement(
        "achievement.destroy_mud_armor",
        "destroy_mud_armor",
        6,
        2,
        new ItemStack(dev_item, 1, 1),
        full_mud_armor).registerStat();

    public static Achievement find_saltwort = new Achievement(
        "achievement.find_saltwort",
        "find_saltwort",
        -2,
        0,
        saltwort,
        null).registerStat();

    public static Achievement farm_saltwort = new Achievement(
        "achievement.farm_saltwort",
        "farm_saltwort",
        -4,
        0,
        salt_dirt_lite,
        find_saltwort).registerStat();

    public static Achievement consume_fizzy_drink = new Achievement(
        "achievement.consume_fizzy_drink",
        "consume_fizzy_drink",
        -4,
        2,
        fizzy_drink,
        find_saltwort).registerStat();

    public static Achievement find_dough = new Achievement(
        "achievement.find_dough",
        "find_dough",
        -2,
        4,
        dough,
        find_saltwort).registerStat();

    public static Achievement consumespec_muffin = new Achievement(
        "achievement.consumespec_muffin",
        "consumespec_muffin",
        -2,
        6,
        muffin,
        find_dough).setSpecial().registerStat();

    public static Achievement effect_swarmed = new Achievement(
        "achievement.effect_swarmed",
        "effect_swarmed",
        0,
        6,
        carpenter_bee,
        null).registerStat();

    public static Achievement craft_apiary = new Achievement(
        "achievement.craft_apiary",
        "craft_apiary",
        2,
        6,
        apiary,
        effect_swarmed).registerStat();

    public static AchievementPage achievSaltPage = new AchievementPage(
        "SaltyMod Expanded",
        find_salt,
        find_salt_crystal,
        nav_salt_crystal,
        navelse_salt_crystal,
        slime_salt_crystal,
        witch_salt_crystal,
        farm_salt,
        make_rain,
        farm_evaporator,
        explode_evaporator,
        nav_salt_lake,
        find_mineral_mud,
        full_mud_armor,
        destroy_mud_armor,
        find_saltwort,
        farm_saltwort,
        consume_fizzy_drink,
        find_dough,
        consumespec_muffin,
        nav_salt_marsh,
        find_onion,
        find_mud_brick,
        effect_swarmed,
        craft_apiary);

    /**
     * Initializes all achievements.
     */
    public static void init() {
        registerAchievementPage(achievSaltPage);
    }
}
