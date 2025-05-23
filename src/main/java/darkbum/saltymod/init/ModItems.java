package darkbum.saltymod.init;

import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.util.ItemSaltFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;

import darkbum.saltymod.item.*;
import darkbum.saltymod.potion.ProbablePotionEffect;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;
import static darkbum.saltymod.common.proxy.CommonProxy.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static java.util.Collections.*;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.dye;
import static net.minecraft.item.EnumAction.*;

/**
 * Items class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
@SuppressWarnings("unused")
public class ModItems {

    public static final int speed = Potion.moveSpeed.id;
    public static final int slowness = Potion.moveSlowdown.id;
    public static final int haste = Potion.digSpeed.id;
    public static final int mining_fatigue = Potion.digSlowdown.id;
    public static final int strength = Potion.damageBoost.id;
    public static final int instant_health = Potion.heal.id;
    public static final int instant_damage = Potion.harm.id;
    public static final int jump_boost = Potion.jump.id;
    public static final int nausea = Potion.confusion.id;
    public static final int regeneration = Potion.regeneration.id;
    public static final int resistance = Potion.resistance.id;
    public static final int fire_resistance = Potion.fireResistance.id;
    public static final int water_breathing = Potion.waterBreathing.id;
    public static final int invisibility = Potion.invisibility.id;
    public static final int blindness = Potion.blindness.id;
    public static final int night_vision = Potion.nightVision.id;
    public static final int hunger = Potion.hunger.id;
    public static final int weakness = Potion.weakness.id;
    public static final int poison = Potion.poison.id;
    public static final int wither = Potion.wither.id;
    public static final int health_boost = Potion.field_76434_w.id;
    public static final int absorption = Potion.field_76444_x.id;
    public static final int saturation = Potion.field_76443_y.id;
    public static final int well_fed = ModPotion.wellFed.id;
    public static final int swarmed = ModPotion.swarmed.id;
    public static final int inspired = ModPotion.inspired.id;

    public static final float one_third = 1.0f / 3.0f;
    public static final float two_thirds = 2.0f / 3.0f;

    public static CreativeTabs tab = tabSaltItems;

    public static Item dev_item;
    public static Item developer_foods;
    public static Item fish_bait;
    public static Item bee_larva;
    public static Item honey_bee;
    public static Item carpenter_bee;
    public static Item regal_bee;
    public static Item boreal_bee;
    public static Item waxcomb;
    public static Item honeycomb;
    public static Item frozen_honey;
    public static Item royal_jelly;
    public static Item mineral_mud_ball;
    public static Item sheep_horn;
    public static Item baking_soda;
    public static Item powdered_milk;
    public static Item salt;
    public static Item salt_pinch;
    public static Item sugar_pinch;
    public static Item dough;
    public static Item onion;
    public static Item saltwort;
    public static Item golden_saltwort;
    public static Item golden_potato;
    public static Item golden_berries;
    public static Item salt_cooked_porkchop;
    public static Item salt_cooked_beef;
    public static Item salt_cooked_chicken;
    public static Item salt_cooked_rabbit;
    public static Item salt_cooked_mutton;
    public static Item strider;
    public static Item haunch;
    public static Item cured_meat;
    public static Item salt_cooked_cod;
    public static Item salt_cooked_salmon;
    public static Item cooked_tropical_fish;
    public static Item tailor;
    public static Item calamari;
    public static Item salt_bread;
    public static Item salt_baked_potato;
    public static Item salt_beetroot;
    public static Item salt_egg;
    public static Item egg_bowl;
    public static Item salt_mushroom_stew;
    public static Item salt_rabbit_stew;
    public static Item salt_beetroot_soup;
    public static Item fungus_stew;
    public static Item chicken_soup;
    public static Item beef_stew;
    public static Item bone_marrow_soup;
    public static Item pumpkin_porridge;
    public static Item cactus_soup;
    public static Item stewed_vegetables;
    public static Item potato_mushroom;
    public static Item golden_vegetables;
    public static Item fish_soup;
    public static Item dandelion_salad;
    public static Item wheat_sprouts;
    public static Item beetroot_salad;
    public static Item dressed_herring;
    public static Item saltwort_salad;
    public static Item golden_saltwort_salad;
    public static Item saltwort_cooked_porkchop;
    public static Item saltwort_honey_porkchop;
    public static Item saltwort_cooked_beef;
    public static Item saltwort_cooked_mutton;
    public static Item saltwort_cooked_strider;
    public static Item saltwort_cooked_haunch;
    public static Item sugar_apple;
    public static Item sugar_melon;
    public static Item sugar_berries;
    public static Item fruit_salad;
    public static Item golden_fruit_salad;
    public static Item grated_carrot;
    public static Item melon_soup;
    public static Item honey_porkchop;
    public static Item honey_apple;
    public static Item honey_berries;
    public static Item chocolate_berries;
    public static Item chocolate_bar;
    public static Item sweetberry_cookie;
    public static Item chorus_cookie;
    public static Item chocolate_pie;
    public static Item birthday_pie;
    public static Item apple_pie;
    public static Item sweetberry_pie;
    public static Item carrot_pie;
    public static Item mushroom_pie;
    public static Item potato_pie;
    public static Item onion_pie;
    public static Item shepherds_pie;
    public static Item cod_pie;
    public static Item salmon_pie;
    public static Item tropical_fish_pie;
    public static Item tailor_pie;
    public static Item calamari_pie;
    public static Item saltwort_pie;
    public static Item fermented_saltwort;
    public static Item fermented_fern;
    public static Item fermented_marsh_reeds;
    public static Item fermented_mushroom;
    public static Item pickled_calamari;
    public static Item pickled_beetroot;
    public static Item pickled_onion;
    public static Item apple_preserves;
    public static Item melon_preserves;
    public static Item berry_preserves;
    public static Item muffin;
    public static Item fizzy_drink;
    public static Item tunneler_concoction;
    public static Item tough_jelly;
    public static Item mud_helmet;
    public static Item mud_chestplate;
    public static Item mud_leggings;
    public static Item mud_boots;
    public static Item salt_pickaxe;
    public static Item salt_shard;
    public static Item rainmaker_star;
    public static Item rainmaker;

    public static Item tf_salt_cooked_venison;
    public static Item tf_salt_meef_steak;
    public static Item tf_salt_meef_stroganoff;
    public static Item tf_salt_hydra_chop;
    public static Item tf_pickled_mushgloom;
    public static Item tf_saltwort_cooked_venison;
    public static Item tf_saltwort_meef_steak;

    public static Item bop_hemoglobin;
    public static Item bop_poison;
    public static Item bop_salt_shroom_powder;
    public static Item bop_sugar_fruit_salad;
    public static Item bop_salt_veggie_salad;
    public static Item bop_salt_shroom_salad;
    public static Item bop_salt_rice_bowl;
    public static Item bop_pickled_turnip;

    public static Item wm_salt_cooked_bison;
    public static Item wm_salt_cooked_calamari;
    public static Item wm_salt_cooked_chevon;
    public static Item wm_salt_cooked_goose;
    public static Item wm_salt_cooked_mouse;
    public static Item wm_salt_cooked_venison;

    /**
     * Initializes and registers all blocks.
     */
    public static void init() {

        dev_item = new ItemDevItem("dev_item", null);
        developer_foods = new ItemDeveloperFoods("developer_foods", tab);

        fish_bait = new Item().setCreativeTab(tab).setUnlocalizedName("fish_bait").setTextureName("saltymod:fish_bait");

        bee_larva = new Item().setCreativeTab(tab).setUnlocalizedName("bee_larva").setTextureName("saltymod:bee_larva");
        honey_bee = new ItemBee("honey_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:honey_bee");
        carpenter_bee = new ItemBee("carpenter_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:carpenter_bee");
        regal_bee = new ItemBee("regal_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:regal_bee");
        boreal_bee = new ItemBee("boreal_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:boreal_bee");
        waxcomb = new Item().setCreativeTab(tab).setUnlocalizedName("waxcomb").setTextureName("saltymod:waxcomb");
        honeycomb = new Item().setCreativeTab(tab).setUnlocalizedName("honeycomb").setTextureName("saltymod:honeycomb");
        frozen_honey = new Item().setCreativeTab(tab).setUnlocalizedName("frozen_honey").setTextureName("saltymod:frozen_honey");
        royal_jelly = new Item().setCreativeTab(tab).setUnlocalizedName("royal_jelly").setTextureName("saltymod:royal_jelly");

        mineral_mud_ball = new Item().setCreativeTab(tab).setUnlocalizedName("mineral_mud_ball").setTextureName("saltymod:mineral_mud_ball");
        sheep_horn = new Item().setCreativeTab(tab).setUnlocalizedName("sheep_horn").setTextureName("saltymod:sheep_horn");

        baking_soda = new Item().setCreativeTab(tab).setUnlocalizedName("baking_soda").setTextureName("saltymod:baking_soda");
        powdered_milk = new ItemPowderedMilk("powdered_milk", tab).setTextureName("saltymod:powdered_milk");
        salt = new ItemSalt("salt", tab).setTextureName("saltymod:salt");
        salt_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("salt_pinch").setTextureName("saltymod:salt_pinch");
        sugar_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("sugar_pinch").setTextureName("saltymod:sugar_pinch");

        dough = new ItemSaltFood("dough").setCreativeTab(tab)
            .addVariant(0, "dough", "dough", 1, 0.3f, false,
                new ProbablePotionEffect(nausea, 100),
                new ProbablePotionEffect(slowness, 300, 0, 1.0f, 20));
        onion = new ItemSeedFood(2, 0.3F, onions, farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltymod:onion");
        saltwort = new ItemSaltwort("saltwort", tab).setTextureName("saltymod:saltwort");

        golden_saltwort = new ItemSaltFood("golden_saltwort").setCreativeTab(tab)
            .addVariant(0, "golden_saltwort", "golden_saltwort", 6, 1.2f, false,
                new ProbablePotionEffect(regeneration, 900, 2, two_thirds));
        golden_potato = new ItemSaltFood("golden_potato").setCreativeTab(tab)
            .addVariant(0, "golden_potato", "golden_potato", 6, 1.2f, false);
        golden_berries = new ItemBerriesGold("golden_berries", tab);

        salt_cooked_porkchop = new ItemSaltFood("salt_cooked_porkchop").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_porkchop", "salt_cooked_porkchop", 6, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        salt_cooked_beef = new ItemSaltFood("salt_cooked_beef").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_beef", "salt_cooked_beef", 6, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        salt_cooked_chicken = new ItemSaltFood("salt_cooked_chicken").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_chicken", "salt_cooked_chicken", 5, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        salt_cooked_rabbit = new ItemSaltFood("salt_cooked_rabbit").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_rabbit", "salt_cooked_rabbit", 5, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        salt_cooked_mutton = new ItemSaltFood("salt_cooked_mutton").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_mutton", "salt_cooked_mutton", 6, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        strider = new ItemSaltFood("strider").setCreativeTab(tab)
            .addVariant(0, "strider", "strider", 2, 0.6f, true)
            .addVariant(1, "cooked_strider", "cooked_strider", 4, 0.6f, true,
                new ProbablePotionEffect(health_boost, 100, 0, one_third))
            .addVariant(2, "salt_cooked_strider", "salt_cooked_strider", 6, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        haunch = new ItemSaltFood("haunch").setCreativeTab(tab)
            .addVariant(0, "haunch", "haunch", 2, 0.6f, true)
            .addVariant(1, "cooked_haunch", "cooked_haunch", 4, 0.6f, true,
                new ProbablePotionEffect(health_boost, 100, 0, one_third))
            .addVariant(2, "salt_cooked_haunch", "salt_cooked_haunch", 6, 0.7f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(health_boost, 100, 0, one_third));
        cured_meat = new ItemSaltFood("cured_meat").setCreativeTab(tab)
            .addVariant(0, "cured_meat", "cured_meat", 4, 0.7f, false,
                new ProbablePotionEffect(well_fed, 900));
        salt_cooked_cod = new ItemSaltFood("salt_cooked_cod").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_cod", "salt_cooked_cod", 4, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(water_breathing, 100, 0, one_third));
        salt_cooked_salmon = new ItemSaltFood("salt_cooked_salmon").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_salmon", "salt_cooked_salmon", 4, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(water_breathing, 100, 0, one_third));
        cooked_tropical_fish = new ItemSaltFood("cooked_tropical_fish").setCreativeTab(tab)
            .addVariant(0, "cooked_tropical_fish", "cooked_tropical_fish", 3, 0.5f, false,
                new ProbablePotionEffect(water_breathing, 100, 0, one_third))
            .addVariant(1, "salt_cooked_tropical_fish", "salt_cooked_tropical_fish", 4, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(water_breathing, 100, 0, one_third));
        tailor = new ItemSaltFood("tailor").setCreativeTab(tab)
            .addVariant(0, "tailor", "tailor", 1, 0.5f, false,
                new ProbablePotionEffect(water_breathing, 100, 0, one_third))
            .addVariant(1, "cooked_tailor", "cooked_tailor", 3, 0.5f, false,
                new ProbablePotionEffect(water_breathing, 100, 0, one_third))
            .addVariant(2, "salt_cooked_tailor", "salt_cooked_tailor", 4, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(water_breathing, 100, 0, one_third));
        calamari = new ItemSaltFood("calamari").setCreativeTab(tab)
            .addVariant(0, "calamari", "calamari", 2, 0.5f, false,
                new ProbablePotionEffect(water_breathing, 100, 0, one_third))
            .addVariant(1, "cooked_calamari", "cooked_calamari", 3, 0.5f, false,
                new ProbablePotionEffect(water_breathing, 100, 0, one_third))
            .addVariant(2, "salt_cooked_calamari", "salt_cooked_calamari", 5, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(water_breathing, 100, 0, one_third));

        salt_bread = new ItemSaltFood("salt_bread").setCreativeTab(tab)
            .addVariant(0, "salt_bread", "salt_bread", 4, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200));
        salt_baked_potato = new ItemSaltFood("salt_baked_potato").setCreativeTab(tab)
            .addVariant(0, "salt_baked_potato", "salt_baked_potato", 4, 0.6f, false,
                new ProbablePotionEffect(well_fed, 200));
        salt_beetroot = new ItemSaltFood("salt_beetroot").setCreativeTab(tab)
            .addVariant(0, "salt_beetroot", "salt_beetroot", 2, 0.3f, false,
                new ProbablePotionEffect(well_fed, 200),
                new ProbablePotionEffect(jump_boost, 100, 0, one_third));
        salt_egg = new ItemSaltFood("salt_egg").setCreativeTab(tab)
            .addVariant(0, "salt_egg", "salt_egg", 2, 0.3f, false, 16, singletonList(new ItemStack(dye, 1, 15)),
                new ProbablePotionEffect(well_fed, 300));
        egg_bowl = new ItemEggBowl("egg_bowl", tab);

        salt_mushroom_stew = new ItemSaltFood("salt_mushroom_stew").setCreativeTab(tab)
            .addVariant(0, "salt_mushroom_stew", "salt_mushroom_stew", 6, 0.8f, false, 16, singletonList((new ItemStack(bowl))),
                new ProbablePotionEffect(well_fed, 900),
                new ProbablePotionEffect(strength, 900, 0, two_thirds));
        salt_rabbit_stew = new ItemSaltFood("salt_rabbit_stew").setCreativeTab(tab)
            .addVariant(0, "salt_rabbit_stew", "salt_rabbit_stew", 8, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1500),
                new ProbablePotionEffect(health_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 1, two_thirds));
        salt_beetroot_soup = new ItemSaltFood("salt_beetroot_soup").setCreativeTab(tab)
            .addVariant(0, "salt_beetroot_soup", "salt_beetroot_soup", 6, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(jump_boost, 1200, 1, two_thirds));
        fungus_stew = new ItemSaltFood("fungus_stew").setCreativeTab(tab)
            .addVariant(0, "fungus_stew", "fungus_stew", 4, 0.6f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(wither, 200),
                new ProbablePotionEffect(strength, 300, 0 ,one_third))
            .addVariant(1, "salt_fungus_stew", "salt_fungus_stew", 5, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 900),
                new ProbablePotionEffect(strength, 900, 0, two_thirds));
        chicken_soup = new ItemSaltFood("chicken_soup").setCreativeTab(tab)
            .addVariant(0, "chicken_soup", "chicken_soup", 7, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(health_boost, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third),
                new ProbablePotionEffect(strength, 100, 0, one_third))
            .addVariant(1, "salt_chicken_soup", "salt_chicken_soup", 8, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1500),
                new ProbablePotionEffect(health_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 1, two_thirds));
        beef_stew = new ItemSaltFood("beef_stew").setCreativeTab(tab)
            .addVariant(0, "beef_stew", "beef_stew", 7, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(health_boost, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third),
                new ProbablePotionEffect(strength, 100, 0, one_third))
            .addVariant(1, "salt_beef_stew", "salt_beef_stew", 8, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1500),
                new ProbablePotionEffect(health_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 1, two_thirds));
        pumpkin_porridge = new ItemSaltFood("pumpkin_porridge").setCreativeTab(tab)
            .addVariant(0, "pumpkin_porridge", "pumpkin_porridge", 5, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(resistance, 200, 0, one_third))
            .addVariant(1, "salt_pumpkin_porridge", "salt_pumpkin_porridge", 6, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 600),
                new ProbablePotionEffect(resistance, 600, 0, two_thirds));
        cactus_soup = new ItemSaltFood("cactus_soup").setCreativeTab(tab)
            .addVariant(0, "cactus_soup", "cactus_soup", 5, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(fire_resistance, 400, 0, one_third))
            .addVariant(1, "salt_cactus_soup", "salt_cactus_soup", 6, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(fire_resistance, 1200, 0, two_thirds));
        bone_marrow_soup = new ItemSaltFood("bone_marrow_soup").setCreativeTab(tab)
            .addVariant(0, "bone_marrow_soup", "bone_marrow_soup", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(health_boost, 100, 0, one_third),
                new ProbablePotionEffect(strength, 100, 0, one_third))
            .addVariant(1, "salt_bone_marrow_soup", "salt_bone_marrow_soup", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 900),
                new ProbablePotionEffect(health_boost, 300, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 0, two_thirds));
        stewed_vegetables = new ItemSaltFood("stewed_vegetables").setCreativeTab(tab)
            .addVariant(0, "stewed_vegetables", "stewed_vegetables", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(night_vision, 600, 0, one_third),
                new ProbablePotionEffect(strength, 200, 0, one_third))
            .addVariant(1, "salt_stewed_vegetables", "salt_stewed_vegetables", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(night_vision, 900, 0, two_thirds),
                new ProbablePotionEffect(strength, 600, 0, two_thirds));
        potato_mushroom = new ItemSaltFood("potato_mushroom").setCreativeTab(tab)
            .addVariant(0, "potato_mushroom", "potato_mushroom", 5, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(strength, 200, 0, one_third))
            .addVariant(1, "salt_potato_mushroom", "salt_potato_mushroom", 6, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(strength, 600, 0, two_thirds));
        golden_vegetables = new ItemSaltFood("golden_vegetables").setCreativeTab(tab)
            .addVariant(0, "golden_vegetables", "golden_vegetables", 10, 1.2f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(night_vision, 900),
                new ProbablePotionEffect(regeneration, 900, 2))
            .addVariant(1, "salt_golden_vegetables", "salt_golden_vegetables", 11, 1.2f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(night_vision, 900),
                new ProbablePotionEffect(regeneration, 900, 2));
        fish_soup = new ItemSaltFood("fish_soup").setCreativeTab(tab)
            .addVariant(0, "fish_soup", "fish_soup", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(water_breathing, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third))
            .addVariant(1, "salt_fish_soup", "salt_fish_soup", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(water_breathing, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds));
        dandelion_salad = new ItemSaltFood("dandelion_salad").setCreativeTab(tab)
            .addVariant(0, "dandelion_salad", "dandelion_salad", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(resistance, 300, 0, one_third),
                new ProbablePotionEffect(inspired, 200, 0, one_third))
            .addVariant(1, "salt_dandelion_salad", "salt_dandelion_salad", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(resistance, 800, 0, two_thirds),
                new ProbablePotionEffect(inspired, 600, 0, two_thirds));
        wheat_sprouts = new ItemSaltFood("wheat_sprouts").setCreativeTab(tab)
            .addVariant(0, "wheat_sprouts", "wheat_sprouts", 3, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(resistance, 700, 0, one_third))
            .addVariant(1, "salt_wheat_sprouts", "salt_wheat_sprouts", 4, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 2100),
                new ProbablePotionEffect(resistance, 1200, 1, two_thirds));
        beetroot_salad = new ItemSaltFood("beetroot_salad").setCreativeTab(tab)
            .addVariant(0, "beetroot_salad", "beetroot_salad", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(jump_boost, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third))
            .addVariant(1, "salt_beetroot_salad", "salt_beetroot_salad", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(jump_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds));
        dressed_herring = new ItemSaltFood("dressed_herring").setCreativeTab(tab)
            .addVariant(0, "dressed_herring", "dressed_herring", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(water_breathing, 600, 0, one_third),
                new ProbablePotionEffect(inspired, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third),
                new ProbablePotionEffect(jump_boost, 200, 0, one_third))
            .addVariant(1, "salt_dressed_herring", "salt_dressed_herring", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 2100),
                new ProbablePotionEffect(water_breathing, 900, 0, two_thirds),
                new ProbablePotionEffect(inspired, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(jump_boost, 600, 0, two_thirds));
        saltwort_salad = new ItemSaltFood("saltwort_salad").setCreativeTab(tab)
            .addVariant(0, "saltwort_salad", "saltwort_salad", 5, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(regeneration, 1200, 1, one_third));
        golden_saltwort_salad = new ItemSaltFood("golden_saltwort_salad").setCreativeTab(tab)
            .addVariant(0, "golden_saltwort_salad", "golden_saltwort_salad", 6, 1.2f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_porkchop = new ItemSaltFood("saltwort_cooked_porkchop").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_porkchop", "saltwort_cooked_porkchop", 12, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_honey_porkchop = new ItemSaltFood("saltwort_honey_porkchop").setCreativeTab(tab)
            .addVariant(0, "saltwort_honey_porkchop", "saltwort_honey_porkchop", 12, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(absorption, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_beef = new ItemSaltFood("saltwort_cooked_beef").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_beef", "saltwort_cooked_beef", 12, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_mutton = new ItemSaltFood("saltwort_cooked_mutton").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_mutton", "saltwort_cooked_mutton", 12, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_strider = new ItemSaltFood("saltwort_cooked_strider").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_strider", "saltwort_cooked_strider", 12, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_haunch = new ItemSaltFood("saltwort_cooked_haunch").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_haunch", "saltwort_cooked_haunch", 12, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));

        sugar_apple = new ItemSaltFood("sugar_apple").setCreativeTab(tab)
            .addVariant(0, "sugar_apple", "sugar_apple", 4, 0.5f, false,
                new ProbablePotionEffect(speed, 300));
        sugar_melon = new ItemSaltFood("sugar_melon").setCreativeTab(tab)
            .addVariant(0, "sugar_melon", "sugar_melon_slice", 3, 0.5f, false,
                new ProbablePotionEffect(speed, 200),
                new ProbablePotionEffect(fire_resistance, 100, 0, one_third));
        sugar_berries = new ItemSaltFood("sugar_berries").setCreativeTab(tab)
            .addVariant(0, "sugar_berries", "sugar_sweet_berries", 3, 0.5f, false,
                new ProbablePotionEffect(speed, 300));

        fruit_salad = new ItemSaltFood("fruit_salad").setCreativeTab(tab)
            .addVariant(0, "fruit_salad", "fruit_salad", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(speed, 900, 0, one_third),
                new ProbablePotionEffect(fire_resistance, 600, 0, one_third))
            .addVariant(1, "sugar_fruit_salad", "sugar_fruit_salad", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(speed, 1200, 2),
                new ProbablePotionEffect(fire_resistance, 600, 0));
        golden_fruit_salad = new ItemSaltFood("golden_fruit_salad").setCreativeTab(tab)
            .addVariant(0, "golden_fruit_salad", "golden_fruit_salad", 8, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(regeneration, 200, 1),
                new ProbablePotionEffect(absorption, 2400),
                new ProbablePotionEffect(speed, 900, 1, two_thirds))
            .addVariant(1, "sugar_golden_fruit_salad", "sugar_golden_fruit_salad", 9, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(regeneration, 200, 1),
                new ProbablePotionEffect(absorption, 2400),
                new ProbablePotionEffect(fire_resistance, 200),
                new ProbablePotionEffect(speed, 900, 1));
        grated_carrot = new ItemSaltFood("grated_carrot").setCreativeTab(tab)
            .addVariant(0, "grated_carrot", "grated_carrot", 6, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(night_vision, 1200, 0, one_third))
            .addVariant(1, "sugar_grated_carrot", "sugar_grated_carrot", 7, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(speed, 1200),
                new ProbablePotionEffect(night_vision, 1200, 0, two_thirds));
        melon_soup = new ItemSaltFood("melon_soup").setCreativeTab(tab)
            .addVariant(0, "melon_soup", "melon_soup", 5, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(fire_resistance, 1200, 0, one_third))
            .addVariant(1, "sugar_melon_soup", "sugar_melon_soup", 6, 0.8f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(speed, 1200),
                new ProbablePotionEffect(fire_resistance, 1200, 1, two_thirds));

        honey_porkchop = new ItemSaltFood("honey_porkchop").setCreativeTab(tab)
            .addVariant(0, "honey_porkchop", "honey_porkchop", 6, 0.7f, false,
                new ProbablePotionEffect(absorption, 200, 1, one_third));
        honey_apple = new ItemSaltFood("honey_apple").setCreativeTab(tab)
            .addVariant(0, "honey_apple", "honey_apple", 4, 0.5f, false,
                new ProbablePotionEffect(absorption, 200, 0, one_third));
        honey_berries = new ItemSaltFood("honey_berries").setCreativeTab(tab)
            .addVariant(0, "honey_berries", "honey_berries", 3, 0.5f, false,
                new ProbablePotionEffect(absorption, 200, 0, one_third));
        chocolate_berries = new ItemSaltFood("chocolate_berries").setCreativeTab(tab)
            .addVariant(0, "chocolate_berries", "chocolate_berries", 3, 0.5f, false,
                new ProbablePotionEffect(haste, 200, 0, one_third));
        chocolate_bar = new ItemChocolateBar("chocolate_bar", tab);

        sweetberry_cookie = new ItemSaltFood("sweetberry_cookie").setCreativeTab(tab)
            .addVariant(0, "sweetberry_cookie", "sweetberry_cookie", 2, 0.1f, false,
                new ProbablePotionEffect(speed, 200, 0, one_third));
        chorus_cookie = new ItemChorusCookie("chorus_cookie", tab);

        chocolate_pie = new ItemSaltFood("chocolate_pie").setCreativeTab(tab)
            .addVariant(0, "chocolate_pie", "chocolate_pie", 7, 0.9f, false,
                new ProbablePotionEffect(haste, 1800, 0, two_thirds));
        birthday_pie = new ItemSaltFood("birthday_pie").setCreativeTab(tab)
            .addVariant(0, "birthday_pie", "birthday_pie", 9, 0.9f, false);
        apple_pie = new ItemSaltFood("apple_pie").setCreativeTab(tab)
            .addVariant(0, "apple_pie", "apple_pie", 8, 0.9f, false,
                new ProbablePotionEffect(speed, 1800, 0, two_thirds));
        sweetberry_pie = new ItemSaltFood("sweetberry_pie").setCreativeTab(tab)
            .addVariant(0, "sweetberry_pie", "sweetberry_pie", 7, 0.9f, false,
                new ProbablePotionEffect(speed, 1800, 0, two_thirds));
        carrot_pie = new ItemSaltFood("carrot_pie").setCreativeTab(tab)
            .addVariant(0, "carrot_pie", "carrot_pie", 8, 0.9f, false,
                new ProbablePotionEffect(night_vision, 1800, 0, two_thirds));
        mushroom_pie = new ItemSaltFood("mushroom_pie").setCreativeTab(tab)
            .addVariant(0, "mushroom_pie", "mushroom_pie", 7, 0.9f, false,
                new ProbablePotionEffect(strength, 1800, 0, two_thirds));
        potato_pie = new ItemSaltFood("potato_pie").setCreativeTab(tab)
            .addVariant(0, "potato_pie", "potato_pie", 7, 0.9f, false);
        onion_pie = new ItemSaltFood("onion_pie").setCreativeTab(tab)
            .addVariant(0, "onion_pie", "onion_pie", 8, 0.9f, false,
                new ProbablePotionEffect(inspired, 1800, 0, two_thirds));
        shepherds_pie = new ItemSaltFood("shepherds_pie").setCreativeTab(tab)
            .addVariant(0, "shepherds_pie", "shepherds_pie", 10, 0.9f, false,
                new ProbablePotionEffect(health_boost, 1800, 0, two_thirds));
        cod_pie = new ItemSaltFood("cod_pie").setCreativeTab(tab)
            .addVariant(0, "cod_pie", "cod_pie", 7, 0.9f, false,
                new ProbablePotionEffect(water_breathing, 1800, 0, two_thirds));
        salmon_pie = new ItemSaltFood("salmon_pie").setCreativeTab(tab)
            .addVariant(0, "salmon_pie", "salmon_pie", 7, 0.9f, false,
                new ProbablePotionEffect(water_breathing, 1800, 0, two_thirds));
        tropical_fish_pie = new ItemSaltFood("tropical_fish_pie").setCreativeTab(tab)
            .addVariant(0, "tropical_fish_pie", "tropical_fish_pie", 7, 0.9f, false,
                new ProbablePotionEffect(water_breathing, 1800, 0, two_thirds));
        tailor_pie = new ItemSaltFood("tailor_pie").setCreativeTab(tab)
            .addVariant(0, "tailor_pie", "tailor_pie", 7, 0.9f, false,
                new ProbablePotionEffect(water_breathing, 1800, 0, two_thirds));
        calamari_pie = new ItemSaltFood("calamari_pie").setCreativeTab(tab)
            .addVariant(0, "calamari_pie", "calamari_pie", 7, 0.9f, false,
                new ProbablePotionEffect(water_breathing, 1800, 0, two_thirds));
        saltwort_pie = new ItemSaltFood("saltwort_pie").setCreativeTab(tab)
            .addVariant(0, "saltwort_pie", "saltwort_pie", 7, 0.9f, false,
                new ProbablePotionEffect(regeneration, 1800, 1, two_thirds));

        fermented_saltwort = new ItemSaltFood("fermented_saltwort").setCreativeTab(tab)
            .addVariant(0, "fermented_saltwort", "fermented_saltwort", 5, 0.7f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(regeneration, 1200, 3),
                new ProbablePotionEffect(instant_damage, 1, 1));
        fermented_fern = new ItemSaltFood("fermented_fern").setCreativeTab(tab)
            .addVariant(0, "fermented_fern", "fermented_fern", 4, 0.7f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(resistance, 1200, 2),
                new ProbablePotionEffect(slowness, 600, 1));
        fermented_marsh_reeds = new ItemSaltFood("fermented_marsh_reeds").setCreativeTab(tab)
            .addVariant(0, "fermented_marsh_reeds", "fermented_marsh_reeds", 4, 0.7f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(resistance, 1200, 2),
                new ProbablePotionEffect(slowness, 600, 1));
        fermented_mushroom = new ItemSaltFood("fermented_mushroom").setCreativeTab(tab)
            .addVariant(0, "fermented_mushroom", "fermented_mushroom", 4, 0.7f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(strength, 1200, 2),
                new ProbablePotionEffect(blindness, 100, 0));
        pickled_calamari = new ItemSaltFood("pickled_calamari").setCreativeTab(tab)
            .addVariant(0, "pickled_calamari", "pickled_calamari", 6, 0.7f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(water_breathing, 1200, 0),
                new ProbablePotionEffect(mining_fatigue, 600, 1));
        pickled_beetroot = new ItemSaltFood("pickled_beetroot").setCreativeTab(tab)
            .addVariant(0, "pickled_beetroot", "pickled_beetroot", 5, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(jump_boost, 1200, 2),
                new ProbablePotionEffect(nausea, 300));
        pickled_onion = new ItemSaltFood("pickled_onion").setCreativeTab(tab)
            .addVariant(0, "pickled_onion", "pickled_onion", 6, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(inspired, 1200, 2),
                new ProbablePotionEffect(hunger, 600, 1));
        apple_preserves = new ItemSaltFood("apple_preserves").setCreativeTab(tab)
            .addVariant(0, "apple_preserves", "apple_preserves", 8, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(speed, 1200, 2),
                new ProbablePotionEffect(weakness, 600, 1));
        melon_preserves = new ItemSaltFood("melon_preserves").setCreativeTab(tab)
            .addVariant(0, "melon_preserves", "melon_preserves", 6, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(fire_resistance, 1200),
                new ProbablePotionEffect(weakness, 600, 1));
        berry_preserves = new ItemSaltFood("berry_preserves").setCreativeTab(tab)
            .addVariant(0, "berry_preserves", "berry_preserves", 6, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(speed, 1200, 2),
                new ProbablePotionEffect(weakness, 600, 1));

        muffin = new ItemMuffin("muffin", tab).setTextureName("saltymod:muffin");

        fizzy_drink = new ItemFizzyDrink("fizzy_drink", tab).setTextureName("saltymod:fizzy_drink");
        tunneler_concoction = new ItemTunnelerConcoction("tunneler_concoction", tab);

        tough_jelly = new ItemSaltFood("tough_jelly").setCreativeTab(tab)
            .addVariant(0, "tough_jelly", "tough_jelly", 1, 0.3f, false,
                new ProbablePotionEffect(nausea, 300, 0, 0.3f));
        mud_helmet = new ItemMudArmor("mud_helmet", mudMaterial, 0);
        mud_chestplate = new ItemMudArmor("mud_chestplate", mudMaterial, 1);
        mud_leggings = new ItemMudArmor("mud_leggings", mudMaterial, 2);
        mud_boots = new ItemMudArmor("mud_boots", mudMaterial, 3);

        salt_pickaxe = new ItemSaltPickaxe("salt_pickaxe", tab).setTextureName("saltymod:salt_pickaxe");
        salt_shard = new ItemSaltShard("salt_shard", tab).setTextureName("saltymod:salt_shard");

        rainmaker_star = new Item().setCreativeTab(tab).setUnlocalizedName("rainmaker_star").setTextureName("saltymod:rainmaker_star");
        rainmaker = new ItemRainmaker("rainmaker", tab).setTextureName("saltymod:rainmaker");


        tf_salt_cooked_venison = new ItemSaltFood("tf_salt_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "tf_salt_cooked_venison", "tf/tf_salt_cooked_venison", 9, 0.9f, false);
        tf_salt_meef_steak = new ItemSaltFood("tf_salt_meef_steak").setCreativeTab(tab)
            .addVariant(0, "tf_salt_meef_steak", "tf/tf_salt_meef_steak", 7, 0.7f, false);
        tf_salt_meef_stroganoff = new ItemSaltFood("tf_salt_meef_stroganoff").setCreativeTab(tab)
            .addVariant(0, "tf_salt_meef_stroganoff", "tf/tf_salt_meef_stroganoff", 9, 0.7f, false, 16, singletonList(new ItemStack(bowl)));
        tf_salt_hydra_chop = new ItemSaltFood("tf_salt_hydra_chop").setCreativeTab(tab)
            .addVariant(0, "tf_salt_hydra_chop", "tf/tf_salt_hydra_chop", 19, 2.1f, false,
                new ProbablePotionEffect(regeneration, 100, 0));
        tf_pickled_mushgloom = new ItemSaltFood("tf_pickled_mushgloom").setCreativeTab(tab)
            .addVariant(0, "tf_pickled_mushgloom", "tf/tf_pickled_mushgloom", 6, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)), drink,
                new ProbablePotionEffect(night_vision, 1200, 0),
                new ProbablePotionEffect(slowness, 100, 0));
        tf_saltwort_cooked_venison = new ItemSaltFood("tf_saltwort_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "tf_saltwort_cooked_venison", "tf/tf_saltwort_cooked_venison", 10, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(regeneration, 100, 0));
        tf_saltwort_meef_steak = new ItemSaltFood("tf_saltwort_meef_steak").setCreativeTab(tab)
            .addVariant(0, "tf_saltwort_meef_steak", "tf/tf_saltwort_meef_steak", 8, 0.9f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(regeneration, 100, 0));


        bop_hemoglobin = new ItemSaltFood("bop_hemoglobin").setCreativeTab(tab)
            .addVariant(0, "bop_hemoglobin", "bop/bop_hemoglobin", 2, 4.0f, false,
                new ProbablePotionEffect(instant_health, 1, 1));
        bop_poison = new Item().setCreativeTab(tab).setUnlocalizedName("bop_poison").setTextureName("saltymod:bop/bop_poison");
        bop_salt_shroom_powder = new ItemSaltFood("bop_salt_shroom_powder").setCreativeTab(tab)
            .addVariant(0, "bop_salt_shroom_powder", "bop/bop_salt_shroom_powder", 2, 0.2f, false,
                new ProbablePotionEffect(nausea, 300, 0, 0.3f));
        bop_sugar_fruit_salad = new ItemSaltFood("bop_sugar_fruit_salad").setCreativeTab(tab)
            .addVariant(0, "bop_sugar_fruit_salad", "bop/bop_sugar_fruit_salad", 7, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(haste, 1200, 2, 0.1f));
        bop_salt_veggie_salad = new ItemSaltFood("bop_salt_veggie_salad").setCreativeTab(tab)
            .addVariant(0, "bop_salt_veggie_salad", "bop/bop_salt_veggie_salad", 7, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(health_boost, 1550, 2, 0.1f));
        bop_salt_shroom_salad = new ItemSaltFood("bop_salt_shroom_salad").setCreativeTab(tab)
            .addVariant(0, "bop_salt_shroom_salad", "bop/bop_salt_shroom_salad", 7, 0.7f, false, 16, singletonList(new ItemStack(bowl)),
                new ProbablePotionEffect(jump_boost, 900, 2, 0.1f));
        bop_salt_rice_bowl = new ItemSaltFood("bop_salt_rice_bowl").setCreativeTab(tab)
            .addVariant(0, "bop_salt_rice_bowl", "bop/bop_salt_rice_bowl", 3, 0.2f, false, 16, singletonList(new ItemStack(bowl)));
        bop_pickled_turnip = new ItemSaltFood("bop_pickled_turnip").setCreativeTab(tab)
            .addVariant(0, "bop_pickled_turnip", "bop/bop_pickled_turnip", 6, 0.8f, false, 1, singletonList(new ItemStack(glass_bottle)));


        wm_salt_cooked_bison = new ItemSaltFood("wm_salt_cooked_bison").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_bison", "wm/wm_salt_cooked_bison", 9, 0.7f, false);
        wm_salt_cooked_calamari = new ItemSaltFood("wm_salt_cooked_calamari").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_calamari", "wm/wm_salt_cooked_calamari", 6, 0.7f, false);
        wm_salt_cooked_chevon = new ItemSaltFood("wm_salt_cooked_chevon").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_chevon", "wm/wm_salt_cooked_chevon", 7, 0.7f, false);
        wm_salt_cooked_goose = new ItemSaltFood("wm_salt_cooked_goose").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_goose", "wm/wm_salt_cooked_goose", 7, 0.7f, false);
        wm_salt_cooked_mouse = new ItemSaltFood("wm_salt_cooked_mouse").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_mouse", "wm/wm_salt_cooked_mouse", 5, 0.7f, false);
        wm_salt_cooked_venison = new ItemSaltFood("wm_salt_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_venison", "wm/wm_salt_cooked_venison", 9, 0.7f, false);


        registerItem(dev_item, "dev_item");
        registerItem(developer_foods, "developer_foods", enableDeveloperFoods);
        registerItem(fish_bait, "fish_bait", enableFishFarm);
        registerItem(bee_larva, "bee_larva", enableHoney);
        registerItem(honey_bee, "honey_bee", enableHoney);
        registerItem(carpenter_bee, "carpenter_bee", enableHoney);
        registerItem(regal_bee, "regal_bee", enableHoney);
        registerItem(boreal_bee, "boreal_bee", enableHoney);
        registerItem(waxcomb, "waxcomb", enableHoney);
        registerItem(honeycomb, "honeycomb", enableHoney);
        registerItem(frozen_honey, "frozen_honey", enableHoney);
        registerItem(royal_jelly, "royal_jelly", enableHoney);
        registerItem(mineral_mud_ball, "mineral_mud_ball", enableMineralMud);
        registerItem(sheep_horn, "sheep_horn", enableHornedSheep);
        registerItem(baking_soda, "baking_soda");
        registerItem(powdered_milk, "powdered_milk");
        registerItem(salt, "salt");
        registerItem(salt_pinch, "salt_pinch");
        registerItem(sugar_pinch, "sugar_pinch");
        registerItem(dough, "dough", enableDough);
        registerItem(onion, "onion", enableOnion);
        registerItem(saltwort, "saltwort");
        registerItem(golden_saltwort, "golden_saltwort", enableGoldenFoods);
        registerItem(golden_potato, "golden_potato", enableGoldenFoods);
        registerItem(golden_berries, "golden_berries", enableGoldenFoods, efr);
        registerItem(salt_cooked_porkchop, "salt_cooked_porkchop", enableSaltedPorkchop);
        registerItem(salt_cooked_beef, "salt_cooked_beef", enableSaltedBeef);
        registerItem(salt_cooked_chicken, "salt_cooked_chicken", enableSaltedChicken);
        registerItem(salt_cooked_rabbit, "salt_cooked_rabbit", enableSaltedRabbit, efr);
        registerItem(salt_cooked_mutton, "salt_cooked_mutton", enableSaltedMutton, efr);
        registerItem(strider, "strider", enableStrider);
        registerItem(haunch, "haunch", enableHaunch);
        registerItem(cured_meat, "cured_meat", enableCuredMeat);
        registerItem(salt_cooked_cod, "salt_cooked_cod", enableSaltedCod);
        registerItem(salt_cooked_salmon, "salt_cooked_salmon", enableSaltedSalmon);
        registerItem(cooked_tropical_fish, "cooked_tropical_fish", enableTropicalFish);
        registerItem(tailor, "tailor", enableTailor);
        registerItem(calamari, "calamari", enableCalamari);
        registerItem(salt_bread, "salt_bread", enableSaltedBread);
        registerItem(salt_baked_potato, "salt_baked_potato", enableSaltedPotato);
        registerItem(salt_beetroot, "salt_beetroot", enableSaltedBeetroot, efr);
        registerItem(salt_egg, "salt_egg", enableEgg);
        registerItem(egg_bowl, "egg_bowl", enableEgg);
        registerItem(salt_mushroom_stew, "salt_mushroom_stew", enableSaltedMushroomStew);
        registerItem(salt_rabbit_stew, "salt_rabbit_stew", enableSaltedRabbitRagout, efr);
        registerItem(salt_beetroot_soup, "salt_beetroot_soup", enableSaltedBorscht, efr);
        registerItem(fungus_stew, "fungus_stew", enableFungusStew, efr);
        registerItem(chicken_soup, "chicken_soup", enableChickenSoup);
        registerItem(beef_stew, "beef_stew", enableBeefStew);
        registerItem(pumpkin_porridge, "pumpkin_porridge", enablePumpkinPorridge);
        registerItem(cactus_soup, "cactus_soup", enableCactusSoup);
        registerItem(bone_marrow_soup, "bone_marrow_soup", enableBoneMarrowSoup);
        registerItem(stewed_vegetables, "stewed_vegetables", enableStewedVegetables);
        registerItem(potato_mushroom, "potato_mushroom", enablePotatoMushroom);
        registerItem(golden_vegetables, "golden_vegetables", enableGoldenFoods);
        registerItem(fish_soup, "fish_soup", enableFishSoup);
        registerItem(dandelion_salad, "dandelion_salad", enableDandelionSalad, enableOnion);
        registerItem(wheat_sprouts, "wheat_sprouts", enableWheatSprouts);
        registerItem(beetroot_salad, "beetroot_salad", enableBeetrootSalad, efr);
        registerItem(dressed_herring, "dressed_herring", enableDressedHerring, enableOnion, efr);
        registerItem(saltwort_salad, "saltwort_salad", enableSaltwortSalad);
        registerItem(golden_saltwort_salad, "golden_saltwort_salad", enableGoldenFoods);
        registerItem(saltwort_cooked_porkchop, "saltwort_cooked_porkchop", enableSaltwortPorkchop, enableSaltedPorkchop);
        registerItem(saltwort_honey_porkchop, "saltwort_honey_porkchop", enableSaltwortHoneyPorkchop, enableHoneyPorkchop, enableHoney);
        registerItem(saltwort_cooked_beef, "saltwort_cooked_beef", enableSaltwortBeef, enableSaltedBeef);
        registerItem(saltwort_cooked_mutton, "saltwort_cooked_mutton", enableSaltwortMutton, enableSaltedMutton, efr);
        registerItem(saltwort_cooked_strider, "saltwort_cooked_strider", enableSaltwortStrider, enableStrider);
        registerItem(saltwort_cooked_haunch, "saltwort_cooked_haunch", enableSaltwortHaunch, enableHaunch);
        registerItem(sugar_apple, "sugar_apple", enableSugaredApple);
        registerItem(sugar_melon, "sugar_melon", enableSugaredMelon);
        registerItem(sugar_berries, "sugar_berries", enableSugaredBerries, efr);
        registerItem(fruit_salad, "fruit_salad", enableFruitSalad);
        registerItem(golden_fruit_salad, "golden_fruit_salad", enableGoldenFoods, efr);
        registerItem(grated_carrot, "grated_carrot", enableGratedCarrot);
        registerItem(melon_soup, "melon_soup", enableMelonSoup);
        registerItem(honey_porkchop, "honey_porkchop", enableHoneyPorkchop, enableHoney);
        registerItem(honey_apple, "honey_apple", enableHoneyApple, enableHoney);
        registerItem(honey_berries, "honey_berries", enableHoneyBerries, enableHoney, efr);
        registerItem(chocolate_berries, "chocolate_berries", enableChocolateBerries, efr);
        registerItem(chocolate_bar, "chocolate_bar", enableChocolateBar);
        registerItem(sweetberry_cookie, "sweetberry_cookie", enableBerryCookie, efr);
        registerItem(chorus_cookie, "chorus_cookie", enableChorusCookie, efr);
        registerItem(chocolate_pie, "chocolate_pie", enableChocolatePie);
        registerItem(birthday_pie, "birthday_pie", enableBirthdayPie);
        registerItem(apple_pie, "apple_pie", enableApplePie);
        registerItem(sweetberry_pie, "sweetberry_pie", enableBerryPie, efr);
        registerItem(carrot_pie, "carrot_pie", enableCarrotPie);
        registerItem(mushroom_pie, "mushroom_pie", enableMushroomPie);
        registerItem(potato_pie, "potato_pie", enablePotatoPie);
        registerItem(onion_pie, "onion_pie", enableOnionPie, enableOnion);
        registerItem(shepherds_pie, "shepherds_pie", enableShepherdsPie);
        registerItem(cod_pie, "cod_pie", enableCodPie);
        registerItem(salmon_pie, "salmon_pie", enableSalmonPie);
        registerItem(tropical_fish_pie, "tropical_fish_pie", enableTropicalFishPie);
        registerItem(tailor_pie, "tailor_pie", enableTailorPie, enableTailor);
        registerItem(calamari_pie, "calamari_pie", enableCalamariPie, enableCalamari);
        registerItem(saltwort_pie, "saltwort_pie", enableSaltwortPie);
        registerItem(fermented_saltwort, "fermented_saltwort", enableFermentedSaltwort);
        registerItem(fermented_fern, "fermented_fern", enableFermentedFern);
        registerItem(fermented_marsh_reeds, "fermented_marsh_reeds", enableFermentedMarshReeds, enableSaltMarsh);
        registerItem(fermented_mushroom, "fermented_mushroom", enableFermentedMushroom);
        registerItem(pickled_calamari, "pickled_calamari", enablePickledCalamari, enableCalamari);
        registerItem(pickled_beetroot, "pickled_beetroot", enablePickledBeetroot, efr);
        registerItem(pickled_onion, "pickled_onion", enablePickledOnion, enableOnion);
        registerItem(apple_preserves, "apple_preserves", enableApplePreserves);
        registerItem(melon_preserves, "melon_preserves", enableMelonPreserves);
        registerItem(berry_preserves, "berry_preserves", enableBerryPreserves, efr);
        registerItem(muffin, "muffin", enableMuffin);
        registerItem(fizzy_drink, "fizzy_drink", enableFizzyDrink);
        registerItem(tunneler_concoction, "tunneler_concoction", enableTunnelersConcoction);
        registerItem(tough_jelly, "tough_jelly", enableToughJelly);
        registerItem(mud_helmet, "mud_helmet", enableMudArmor, enableMineralMud);
        registerItem(mud_chestplate, "mud_chestplate", enableMudArmor, enableMineralMud);
        registerItem(mud_leggings, "mud_leggings", enableMudArmor, enableMineralMud);
        registerItem(mud_boots, "mud_boots", enableMudArmor, enableMineralMud);
        registerItem(salt_pickaxe, "salt_pickaxe", enableSaltCrystal);
        registerItem(salt_shard, "salt_shard", enableSaltCrystal);
        registerItem(rainmaker_star, "rainmaker_star", enableRainmaker);
        registerItem(rainmaker, "rainmaker", enableRainmaker);


        registerItem(tf_salt_cooked_venison, "tf_salt_cooked_venison", enableTFFoods, tf);
        registerItem(tf_salt_meef_steak, "tf_salt_meef_steak", enableTFFoods, tf);
        registerItem(tf_salt_meef_stroganoff, "tf_salt_meef_stroganoff", tf);
        registerItem(tf_salt_hydra_chop, "tf_salt_hydra_chop", enableTFFoods, tf);
        registerItem(tf_pickled_mushgloom, "tf_pickled_mushgloom", enableTFFoods, tf);
        registerItem(tf_saltwort_cooked_venison, "tf_saltwort_cooked_venison", enableTFFoods, tf);
        registerItem(tf_saltwort_meef_steak, "tf_saltwort_meef_steak", enableTFFoods, tf);


        registerItem(bop_hemoglobin, "bop_hemoglobin", enableBOPFoods, bop);
        registerItem(bop_poison, "bop_poison", enableBOPFoods, bop);
        registerItem(bop_salt_shroom_powder, "bop_salt_shroom_powder", enableBOPFoods, bop);
        registerItem(bop_sugar_fruit_salad, "bop_sugar_fruit_salad", enableBOPFoods, bop);
        registerItem(bop_salt_veggie_salad, "bop_salt_veggie_salad", enableBOPFoods, bop);
        registerItem(bop_salt_shroom_salad, "bop_salt_shroom_salad", enableBOPFoods, bop);
        registerItem(bop_salt_rice_bowl, "bop_salt_rice_bowl", enableBOPFoods, bop);
        registerItem(bop_pickled_turnip, "bop_pickled_turnip", enableBOPFoods, bop);


        registerItem(wm_salt_cooked_bison, "wm_salt_cooked_bison", enableWMFoods, wm);
        registerItem(wm_salt_cooked_calamari, "wm_salt_cooked_calamari", enableWMFoods, wm);
        registerItem(wm_salt_cooked_chevon, "wm_salt_cooked_chevon", enableWMFoods, wm);
        registerItem(wm_salt_cooked_goose, "wm_salt_cooked_goose", enableWMFoods, wm);
        registerItem(wm_salt_cooked_mouse, "wm_salt_cooked_mouse", enableWMFoods, wm);
        registerItem(wm_salt_cooked_venison, "wm_salt_cooked_venison", enableWMFoods, wm);
    }
}
