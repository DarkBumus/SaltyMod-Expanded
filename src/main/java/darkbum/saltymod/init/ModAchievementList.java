package darkbum.saltymod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.ArrayList;
import java.util.List;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;
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

    public static Achievement find_salt;
    public static Achievement make_rain;
    public static Achievement find_salt_crystal;
    public static Achievement nav_salt_crystal;
    public static Achievement navelse_salt_crystal;
    public static Achievement slime_salt_crystal;
    public static Achievement witch_salt_crystal;
    public static Achievement farm_salt;
    public static Achievement farm_evaporator;
    public static Achievement explodespec_evaporator;
    public static Achievement nav_salt_marsh;
    public static Achievement find_onion;
    public static Achievement nav_salt_lake;
    public static Achievement find_mineral_mud;
    public static Achievement find_mud_brick;
    public static Achievement full_mud_armor;
    public static Achievement destroy_mud_armor;
    public static Achievement find_saltwort;
    public static Achievement farm_saltwort;
    public static Achievement consume_fizzy_drink;
    public static Achievement find_dough;
    public static Achievement consumespec_muffin;
    public static Achievement effect_swarmed;
    public static Achievement craft_apiary;

    /**
     * Initializes all achievements.
     */
    public static void init() {

        find_salt = new Achievement(
            "achievement.find_salt",
            "find_salt",
            0,
            -1,
            salt,
            null).registerStat();

        make_rain = new Achievement(
            "achievement.make_rain",
            "make_rain",
            0,
            -4,
            rainmaker,
            find_salt).registerStat();

        find_salt_crystal = new Achievement(
            "achievement.find_salt_crystal",
            "find_salt_crystal",
            -4,
            -2,
            iron_pickaxe,
            find_salt).registerStat();

        nav_salt_crystal = new Achievement(
            "achievement.nav_salt_crystal",
            "nav_salt_crystal",
            -4,
            -4,
            Items.bone,
            find_salt_crystal).registerStat();

        navelse_salt_crystal = new Achievement(
            "achievement.navelse_salt_crystal",
            "navelse_salt_crystal",
            -4,
            -6,
            salt_crystal,
            nav_salt_crystal).setSpecial().registerStat();

        slime_salt_crystal = new Achievement(
            "achievement.slime_salt_crystal",
            "slime_salt_crystal",
            -5,
            -3,
            tough_jelly,
            find_salt_crystal).setSpecial().registerStat();

        witch_salt_crystal = new Achievement(
            "achievement.witch_salt_crystal",
            "witch_salt_crystal",
            -3,
            -3,
            new ItemStack(dev_item, 1, 2),
            find_salt_crystal).setSpecial().registerStat();

        farm_salt = new Achievement(
            "achievement.farm_salt",
            "farm_salt",
            2,
            -2,
            salt_pinch,
            find_salt).registerStat();

        if (enableEvaporator) {
            farm_evaporator = new Achievement(
                "achievement.farm_evaporator",
                "farm_evaporator",
                4,
                -2,
                Items.bucket,
                farm_salt).registerStat();

            if (evaporator != null) {
                explodespec_evaporator = new Achievement(
                    "achievement.explodespec_evaporator",
                    "explodespec_evaporator",
                    4,
                    -4,
                    evaporator,
                    farm_evaporator).setSpecial().registerStat();
            }
        }

        if (salt_grass != null && enableSaltDirt && enableMineralMud && enableSaltMarsh) {
            nav_salt_marsh = new Achievement(
                "achievement.nav_salt_marsh",
                "nav_salt_marsh",
                2,
                0,
                salt_grass,
                null).registerStat();

            if (onion != null && enableOnion) {
                find_onion = new Achievement(
                    "achievement.find_onion",
                    "find_onion",
                    4,
                    0,
                    onion,
                    nav_salt_marsh).registerStat();
            }
        }

        nav_salt_lake = new Achievement(
            "achievement.nav_salt_lake",
            "nav_salt_lake",
            0,
            1,
            salt_lake,
            null).registerStat();

        if (mineral_mud_ball != null && enableMineralMud) {
            find_mineral_mud = new Achievement(
                "achievement.find_mineral_mud",
                "find_mineral_mud",
                2,
                2,
                mineral_mud_ball,
                nav_salt_lake).registerStat();

            if (dry_mud_brick != null && enableMudBricks) {
                find_mud_brick = new Achievement(
                    "achievement.find_mud_brick",
                    "find_mud_brick",
                    2,
                    4,
                    dry_mud_brick,
                    find_mineral_mud).registerStat();
            }
            if (dev_item != null && enableMudArmor) {
                full_mud_armor = new Achievement(
                    "achievement.full_mud_armor",
                    "full_mud_armor",
                    4,
                    2,
                    new ItemStack(dev_item, 1, 0),
                    find_mineral_mud).registerStat();

                destroy_mud_armor = new Achievement(
                    "achievement.destroy_mud_armor",
                    "destroy_mud_armor",
                    6,
                    2,
                    new ItemStack(dev_item, 1, 1),
                    full_mud_armor).registerStat();
            }
        }

        find_saltwort = new Achievement(
            "achievement.find_saltwort",
            "find_saltwort",
            -2,
            0,
            saltwort,
            null).registerStat();

        farm_saltwort = new Achievement(
            "achievement.farm_saltwort",
            "farm_saltwort",
            -4,
            0,
            salt_dirt_lite,
            find_saltwort).registerStat();

        if (fizzy_drink != null && enableFizzyDrink) {
            consume_fizzy_drink = new Achievement(
                "achievement.consume_fizzy_drink",
                "consume_fizzy_drink",
                -4,
                2,
                fizzy_drink,
                find_saltwort).registerStat();
        }

        if (dough != null && enableDough) {
            find_dough = new Achievement(
                "achievement.find_dough",
                "find_dough",
                -2,
                4,
                dough,
                find_saltwort).registerStat();

            if (muffin != null && enableMuffin) {
                consumespec_muffin = new Achievement(
                    "achievement.consumespec_muffin",
                    "consumespec_muffin",
                    -2,
                    6,
                    muffin,
                    find_dough).setSpecial().registerStat();
            }
        }

        if (honey_bee != null && apiary != null && enableHoney && enableApiary) {
            effect_swarmed = new Achievement(
                "achievement.effect_swarmed",
                "effect_swarmed",
                0,
                6,
                honey_bee,
                null).registerStat();

            craft_apiary = new Achievement(
                "achievement.craft_apiary",
                "craft_apiary",
                2,
                6,
                apiary,
                effect_swarmed).registerStat();
        }


        List<Achievement> list = new ArrayList<>();

        list.add(find_salt);
        list.add(make_rain);
        list.add(find_salt_crystal);
        list.add(nav_salt_crystal);
        list.add(navelse_salt_crystal);
        list.add(slime_salt_crystal);
        list.add(witch_salt_crystal);
        list.add(farm_salt);
        if (enableEvaporator) {
            list.add(farm_evaporator);
            if (evaporator != null) {
                list.add(explodespec_evaporator);
            }
        }
        if (salt_grass != null && enableSaltDirt && enableMineralMud && enableSaltMarsh) {
            list.add(nav_salt_marsh);
            if (onion != null && enableOnion) {
                list.add(find_onion);
            }
        }
        list.add(nav_salt_lake);
        if (mineral_mud_ball != null && enableMineralMud) {
            list.add(find_mineral_mud);
            if (dry_mud_brick != null && enableMudBricks) {
                list.add(find_mud_brick);
            }
            if (dev_item != null && enableMudArmor) {
                list.add(full_mud_armor);
                list.add(destroy_mud_armor);
            }
        }
        list.add(find_saltwort);
        list.add(farm_saltwort);
        if (fizzy_drink != null && enableFizzyDrink) {
            list.add(consume_fizzy_drink);
        }
        if (dough != null && enableDough) {
            list.add(find_dough);
            if (muffin != null && enableMuffin) {
                list.add(consumespec_muffin);
            }
        }
        if (honey_bee != null && apiary != null && enableHoney && enableApiary) {
            list.add(effect_swarmed);
            list.add(craft_apiary);
        }

        AchievementPage page = new AchievementPage("SaltyMod Expanded", list.toArray(new Achievement[0]));
        registerAchievementPage(page);
    }
}
