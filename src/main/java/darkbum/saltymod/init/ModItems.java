package darkbum.saltymod.init;

import darkbum.saltymod.common.config.*;
import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.item.*;
import darkbum.saltymod.potion.ProbablePotionEffect;

import static net.minecraft.item.EnumAction.*;

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
    public static final int inspired = ModPotion.inspired.id;

    public static final float one_third = 1.0f / 3.0f;
    public static final float two_thirds = 2.0f / 3.0f;

    public static CreativeTabs tab = CommonProxy.tabSaltItems;

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
    public static Item horn;
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
    public static Item fizzy_drink;
    public static Item tunneler_concoction;
    public static Item muffin;
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

    public static void init() {
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
        horn = new Item().setCreativeTab(tab).setUnlocalizedName("horn").setTextureName("saltymod:horn");

        baking_soda = new Item().setCreativeTab(tab).setUnlocalizedName("baking_soda").setTextureName("saltymod:baking_soda");
        powdered_milk = new ItemPowderedMilk("powdered_milk", tab);
        salt = new ItemSalt("salt", tab).setTextureName("saltymod:salt");
        salt_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("salt_pinch").setTextureName("saltymod:salt_pinch");
        sugar_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("sugar_pinch").setTextureName("saltymod:sugar_pinch");

        dough = new ItemSaltFood("dough").setCreativeTab(tab)
            .addVariant(0, "dough", "dough", 1, 0.3f, false,
                new ProbablePotionEffect(nausea, 100),
                new ProbablePotionEffect(slowness, 300, 0, 1.0f, 20));
        onion = new ItemSeedFood(2, 0.3F, ModBlocks.onions, Blocks.farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltymod:onion");
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
            .addVariant(0, "salt_egg", "salt_egg", 2, 0.3f, false, 16, new ItemStack(Items.dye, 1, 15),
                new ProbablePotionEffect(well_fed, 300));
        egg_bowl = new ItemEggBowl("egg_bowl", tab).setMaxStackSize(16).setTextureName("saltymod:egg_bowl");

        salt_mushroom_stew = new ItemSaltFood("salt_mushroom_stew").setCreativeTab(tab)
            .addVariant(0, "salt_mushroom_stew", "salt_mushroom_stew", 6, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 900),
                new ProbablePotionEffect(strength, 900, 0, two_thirds));
        salt_rabbit_stew = new ItemSaltFood("salt_rabbit_stew").setCreativeTab(tab)
            .addVariant(0, "salt_rabbit_stew", "salt_rabbit_stew", 8, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1500),
                new ProbablePotionEffect(health_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 1, two_thirds));
        salt_beetroot_soup = new ItemSaltFood("salt_beetroot_soup").setCreativeTab(tab)
            .addVariant(0, "salt_beetroot_soup", "salt_beetroot_soup", 6, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(jump_boost, 1200, 1, two_thirds));
        fungus_stew = new ItemSaltFood("fungus_stew").setCreativeTab(tab)
            .addVariant(0, "fungus_stew", "fungus_stew", 4, 0.6f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(wither, 200),
                new ProbablePotionEffect(strength, 300, 0 ,one_third))
            .addVariant(1, "salt_fungus_stew", "salt_fungus_stew", 5, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 900),
                new ProbablePotionEffect(strength, 900, 0, two_thirds));
        chicken_soup = new ItemSaltFood("chicken_soup").setCreativeTab(tab)
            .addVariant(0, "chicken_soup", "chicken_soup", 7, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(health_boost, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third),
                new ProbablePotionEffect(strength, 100, 0, one_third))
            .addVariant(1, "salt_chicken_soup", "salt_chicken_soup", 8, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1500),
                new ProbablePotionEffect(health_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 1, two_thirds));
        beef_stew = new ItemSaltFood("beef_stew").setCreativeTab(tab)
            .addVariant(0, "beef_stew", "beef_stew", 7, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(health_boost, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third),
                new ProbablePotionEffect(strength, 100, 0, one_third))
            .addVariant(1, "salt_beef_stew", "salt_beef_stew", 8, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1500),
                new ProbablePotionEffect(health_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 1, two_thirds));
        pumpkin_porridge = new ItemSaltFood("pumpkin_porridge").setCreativeTab(tab)
            .addVariant(0, "pumpkin_porridge", "pumpkin_porridge", 5, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(resistance, 200, 0, one_third))
            .addVariant(1, "salt_pumpkin_porridge", "salt_pumpkin_porridge", 6, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 600),
                new ProbablePotionEffect(resistance, 600, 0, two_thirds));
        cactus_soup = new ItemSaltFood("cactus_soup").setCreativeTab(tab)
            .addVariant(0, "cactus_soup", "cactus_soup", 5, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(fire_resistance, 400, 0, one_third))
            .addVariant(1, "salt_cactus_soup", "salt_cactus_soup", 6, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(fire_resistance, 1200, 0, two_thirds));
        bone_marrow_soup = new ItemSaltFood("bone_marrow_soup").setCreativeTab(tab)
            .addVariant(0, "bone_marrow_soup", "bone_marrow_soup", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(health_boost, 100, 0, one_third),
                new ProbablePotionEffect(strength, 100, 0, one_third))
            .addVariant(1, "salt_bone_marrow_soup", "salt_bone_marrow_soup", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 900),
                new ProbablePotionEffect(health_boost, 300, 0, two_thirds),
                new ProbablePotionEffect(strength, 200, 0, two_thirds));
        stewed_vegetables = new ItemSaltFood("stewed_vegetables").setCreativeTab(tab)
            .addVariant(0, "stewed_vegetables", "stewed_vegetables", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(night_vision, 600, 0, one_third),
                new ProbablePotionEffect(strength, 200, 0, one_third))
            .addVariant(1, "salt_stewed_vegetables", "salt_stewed_vegetables", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(night_vision, 900, 0, two_thirds),
                new ProbablePotionEffect(strength, 600, 0, two_thirds));
        potato_mushroom = new ItemSaltFood("potato_mushroom").setCreativeTab(tab)
            .addVariant(0, "potato_mushroom", "potato_mushroom", 5, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(strength, 200, 0, one_third))
            .addVariant(1, "salt_potato_mushroom", "salt_potato_mushroom", 6, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(strength, 600, 0, two_thirds));
        golden_vegetables = new ItemSaltFood("golden_vegetables").setCreativeTab(tab)
            .addVariant(0, "golden_vegetables", "golden_vegetables", 10, 1.2f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(night_vision, 900),
                new ProbablePotionEffect(regeneration, 900, 2))
            .addVariant(1, "salt_golden_vegetables", "salt_golden_vegetables", 11, 1.2f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(night_vision, 900),
                new ProbablePotionEffect(regeneration, 900, 2));
        fish_soup = new ItemSaltFood("fish_soup").setCreativeTab(tab)
            .addVariant(0, "fish_soup", "fish_soup", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(water_breathing, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third))
            .addVariant(1, "salt_fish_soup", "salt_fish_soup", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(water_breathing, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds));
        dandelion_salad = new ItemSaltFood("dandelion_salad").setCreativeTab(tab)
            .addVariant(0, "dandelion_salad", "dandelion_salad", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(resistance, 300, 0, one_third),
                new ProbablePotionEffect(inspired, 200, 0, one_third))
            .addVariant(1, "salt_dandelion_salad", "salt_dandelion_salad", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(resistance, 800, 0, two_thirds),
                new ProbablePotionEffect(inspired, 600, 0, two_thirds));
        wheat_sprouts = new ItemSaltFood("wheat_sprouts").setCreativeTab(tab)
            .addVariant(0, "wheat_sprouts", "wheat_sprouts", 3, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(resistance, 700, 0, one_third))
            .addVariant(1, "salt_wheat_sprouts", "salt_wheat_sprouts", 4, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 2100),
                new ProbablePotionEffect(resistance, 1200, 1, two_thirds));
        beetroot_salad = new ItemSaltFood("beetroot_salad").setCreativeTab(tab)
            .addVariant(0, "beetroot_salad", "beetroot_salad", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(jump_boost, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third))
            .addVariant(1, "salt_beetroot_salad", "salt_beetroot_salad", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(jump_boost, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds));
        dressed_herring = new ItemSaltFood("dressed_herring").setCreativeTab(tab)
            .addVariant(0, "dressed_herring", "dressed_herring", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(water_breathing, 600, 0, one_third),
                new ProbablePotionEffect(inspired, 600, 0, one_third),
                new ProbablePotionEffect(night_vision, 200, 0, one_third),
                new ProbablePotionEffect(jump_boost, 200, 0, one_third))
            .addVariant(1, "salt_dressed_herring", "salt_dressed_herring", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 2100),
                new ProbablePotionEffect(water_breathing, 900, 0, two_thirds),
                new ProbablePotionEffect(inspired, 900, 0, two_thirds),
                new ProbablePotionEffect(night_vision, 600, 0, two_thirds),
                new ProbablePotionEffect(jump_boost, 600, 0, two_thirds));
        saltwort_salad = new ItemSaltFood("saltwort_salad").setCreativeTab(tab)
            .addVariant(0, "saltwort_salad", "saltwort_salad", 5, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(regeneration, 1200, 1, one_third));
        golden_saltwort_salad = new ItemSaltFood("golden_saltwort_salad").setCreativeTab(tab)
            .addVariant(0, "golden_saltwort_salad", "golden_saltwort_salad", 6, 1.2f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_porkchop = new ItemSaltFood("saltwort_cooked_porkchop").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_porkchop", "saltwort_cooked_porkchop", 12, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_honey_porkchop = new ItemSaltFood("saltwort_honey_porkchop").setCreativeTab(tab)
            .addVariant(0, "saltwort_honey_porkchop", "saltwort_honey_porkchop", 12, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(absorption, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_beef = new ItemSaltFood("saltwort_cooked_beef").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_beef", "saltwort_cooked_beef", 12, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_mutton = new ItemSaltFood("saltwort_cooked_mutton").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_mutton", "saltwort_cooked_mutton", 12, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_strider = new ItemSaltFood("saltwort_cooked_strider").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_strider", "saltwort_cooked_strider", 12, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(well_fed, 1200),
                new ProbablePotionEffect(health_boost, 900, 1, two_thirds),
                new ProbablePotionEffect(regeneration, 1200, 2, two_thirds));
        saltwort_cooked_haunch = new ItemSaltFood("saltwort_cooked_haunch").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_haunch", "saltwort_cooked_haunch", 12, 0.9f, false, 16, new ItemStack(Items.bowl),
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
            .addVariant(0, "fruit_salad", "fruit_salad", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(speed, 900, 0, one_third),
                new ProbablePotionEffect(fire_resistance, 600, 0, one_third))
            .addVariant(1, "sugar_fruit_salad", "sugar_fruit_salad", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(speed, 1200, 2),
                new ProbablePotionEffect(fire_resistance, 600, 0));
        golden_fruit_salad = new ItemSaltFood("golden_fruit_salad").setCreativeTab(tab)
            .addVariant(0, "golden_fruit_salad", "golden_fruit_salad", 8, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(regeneration, 200, 1),
                new ProbablePotionEffect(absorption, 2400),
                new ProbablePotionEffect(speed, 900, 1, two_thirds))
            .addVariant(1, "sugar_golden_fruit_salad", "sugar_golden_fruit_salad", 9, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(regeneration, 200, 1),
                new ProbablePotionEffect(absorption, 2400),
                new ProbablePotionEffect(fire_resistance, 200),
                new ProbablePotionEffect(speed, 900, 1));
        grated_carrot = new ItemSaltFood("grated_carrot").setCreativeTab(tab)
            .addVariant(0, "grated_carrot", "grated_carrot", 6, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(night_vision, 1200, 0, one_third))
            .addVariant(1, "sugar_grated_carrot", "sugar_grated_carrot", 7, 0.8f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(speed, 1200),
                new ProbablePotionEffect(night_vision, 1200, 0, two_thirds));
        melon_soup = new ItemSaltFood("melon_soup").setCreativeTab(tab)
            .addVariant(0, "melon_soup", "melon_soup", 5, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(fire_resistance, 1200, 0, one_third))
            .addVariant(1, "sugar_melon_soup", "sugar_melon_soup", 6, 0.8f, false, 16, new ItemStack(Items.bowl),
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
            .addVariant(0, "fermented_saltwort", "fermented_saltwort", 5, 0.7f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(regeneration, 1200, 3),
                new ProbablePotionEffect(instant_damage, 1, 1));
        fermented_fern = new ItemSaltFood("fermented_fern").setCreativeTab(tab)
            .addVariant(0, "fermented_fern", "fermented_fern", 4, 0.7f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(resistance, 1200, 2),
                new ProbablePotionEffect(slowness, 600, 1));
        fermented_marsh_reeds = new ItemSaltFood("fermented_marsh_reeds").setCreativeTab(tab)
            .addVariant(0, "fermented_marsh_reeds", "fermented_marsh_reeds", 4, 0.7f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(resistance, 1200, 2),
                new ProbablePotionEffect(slowness, 600, 1));
        fermented_mushroom = new ItemSaltFood("fermented_mushroom").setCreativeTab(tab)
            .addVariant(0, "fermented_mushroom", "fermented_mushroom", 4, 0.7f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(strength, 1200, 2),
                new ProbablePotionEffect(blindness, 100, 0));
        pickled_calamari = new ItemSaltFood("pickled_calamari").setCreativeTab(tab)
            .addVariant(0, "pickled_calamari", "pickled_calamari", 6, 0.7f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(water_breathing, 1200, 0),
                new ProbablePotionEffect(mining_fatigue, 600, 1));
        pickled_beetroot = new ItemSaltFood("pickled_beetroot").setCreativeTab(tab)
            .addVariant(0, "pickled_beetroot", "pickled_beetroot", 5, 0.8f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(jump_boost, 1200, 2),
                new ProbablePotionEffect(nausea, 300));
        pickled_onion = new ItemSaltFood("pickled_onion").setCreativeTab(tab)
            .addVariant(0, "pickled_onion", "pickled_onion", 6, 0.8f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(inspired, 1200, 2),
                new ProbablePotionEffect(hunger, 600, 1));
        apple_preserves = new ItemSaltFood("apple_preserves").setCreativeTab(tab)
            .addVariant(0, "apple_preserves", "apple_preserves", 8, 0.8f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(speed, 1200, 2),
                new ProbablePotionEffect(weakness, 600, 1));
        melon_preserves = new ItemSaltFood("melon_preserves").setCreativeTab(tab)
            .addVariant(0, "melon_preserves", "melon_preserves", 6, 0.8f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(fire_resistance, 1200),
                new ProbablePotionEffect(weakness, 600, 1));
        berry_preserves = new ItemSaltFood("berry_preserves").setCreativeTab(tab)
            .addVariant(0, "berry_preserves", "berry_preserves", 6, 0.8f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(speed, 1200, 2),
                new ProbablePotionEffect(weakness, 600, 1));

        fizzy_drink = new ItemFizzyDrink("fizzy_drink", tab).setTextureName("saltymod:fizzy_drink");
        tunneler_concoction = new ItemTunnelerConcoction("tunneler_concoction", tab);
        muffin = new ItemMuffin("muffin", tab).setTextureName("saltymod:muffin");
        tough_jelly = new ItemSaltFood("tough_jelly").setCreativeTab(tab)
            .addVariant(0, "tough_jelly", "tough_jelly", 1, 0.3f, false,
                new ProbablePotionEffect(nausea, 300, 0, 0.3f));

        mud_helmet = new ItemMudArmor("mud_helmet", CommonProxy.mudMaterial, 0);
        mud_chestplate = new ItemMudArmor("mud_chestplate", CommonProxy.mudMaterial, 1);
        mud_leggings = new ItemMudArmor("mud_leggings", CommonProxy.mudMaterial, 2);
        mud_boots = new ItemMudArmor("mud_boots", CommonProxy.mudMaterial, 3);

        salt_pickaxe = new ItemSaltPickaxe("salt_pickaxe", tab).setTextureName("saltymod:salt_pickaxe");
        salt_shard = new ItemSaltShard("salt_shard", tab).setTextureName("saltymod:salt_shard");

        rainmaker_star = new Item().setCreativeTab(tab).setUnlocalizedName("rainmaker_star").setTextureName("saltymod:rainmaker_star");
        rainmaker = new ItemRainmaker("rainmaker", tab).setTextureName("saltymod:rainmaker");


        tf_salt_cooked_venison = new ItemSaltFood("tf_salt_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "tf_salt_cooked_venison", "tf/tf_salt_cooked_venison", 9, 0.9f, false);
        tf_salt_meef_steak = new ItemSaltFood("tf_salt_meef_steak").setCreativeTab(tab)
            .addVariant(0, "tf_salt_meef_steak", "tf/tf_salt_meef_steak", 7, 0.7f, false);
        tf_salt_meef_stroganoff = new ItemSaltFood("tf_salt_meef_stroganoff").setCreativeTab(tab)
            .addVariant(0, "tf_salt_meef_stroganoff", "tf/tf_salt_meef_stroganoff", 9, 0.7f, false, 16, new ItemStack(Items.bowl));
        tf_salt_hydra_chop = new ItemSaltFood("tf_salt_hydra_chop").setCreativeTab(tab)
            .addVariant(0, "tf_salt_hydra_chop", "tf/tf_salt_hydra_chop", 19, 2.1f, false,
                new ProbablePotionEffect(regeneration, 100, 0));
        tf_pickled_mushgloom = new ItemSaltFood("tf_pickled_mushgloom").setCreativeTab(tab)
            .addVariant(0, "tf_pickled_mushgloom", "tf/tf_pickled_mushgloom", 6, 0.8f, false, 1, new ItemStack(Items.glass_bottle), drink,
                new ProbablePotionEffect(night_vision, 1200, 0),
                new ProbablePotionEffect(slowness, 100, 0));
        tf_saltwort_cooked_venison = new ItemSaltFood("tf_saltwort_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "tf_saltwort_cooked_venison", "tf/tf_saltwort_cooked_venison", 10, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(regeneration, 100, 0));
        tf_saltwort_meef_steak = new ItemSaltFood("tf_saltwort_meef_steak").setCreativeTab(tab)
            .addVariant(0, "tf_saltwort_meef_steak", "tf/tf_saltwort_meef_steak", 8, 0.9f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(regeneration, 100, 0));


        bop_hemoglobin = new ItemSaltFood("bop_hemoglobin").setCreativeTab(tab)
            .addVariant(0, "bop_hemoglobin", "bop/bop_hemoglobin", 2, 4.0f, false,
                new ProbablePotionEffect(instant_health, 1, 1));
        bop_poison = new Item().setCreativeTab(tab).setUnlocalizedName("bop_poison").setTextureName("saltymod:bop/bop_poison");
        bop_salt_shroom_powder = new ItemSaltFood("bop_salt_shroom_powder").setCreativeTab(tab)
            .addVariant(0, "bop_salt_shroom_powder", "bop/bop_salt_shroom_powder", 2, 0.2f, false,
                new ProbablePotionEffect(nausea, 300, 0, 0.3f));
        bop_sugar_fruit_salad = new ItemSaltFood("bop_sugar_fruit_salad").setCreativeTab(tab)
            .addVariant(0, "bop_sugar_fruit_salad", "bop/bop_sugar_fruit_salad", 7, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(haste, 1200, 2, 0.1f));
        bop_salt_veggie_salad = new ItemSaltFood("bop_salt_veggie_salad").setCreativeTab(tab)
            .addVariant(0, "bop_salt_veggie_salad", "bop/bop_salt_veggie_salad", 7, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(health_boost, 1550, 2, 0.1f));
        bop_salt_shroom_salad = new ItemSaltFood("bop_salt_shroom_salad").setCreativeTab(tab)
            .addVariant(0, "bop_salt_shroom_salad", "bop/bop_salt_shroom_salad", 7, 0.7f, false, 16, new ItemStack(Items.bowl),
                new ProbablePotionEffect(jump_boost, 900, 2, 0.1f));
        bop_salt_rice_bowl = new ItemSaltFood("bop_salt_rice_bowl").setCreativeTab(tab)
            .addVariant(0, "bop_salt_rice_bowl", "bop/bop_salt_rice_bowl", 3, 0.2f, false, 16, new ItemStack(Items.bowl));
        bop_pickled_turnip = new ItemSaltFood("bop_pickled_turnip").setCreativeTab(tab)
            .addVariant(0, "bop_pickled_turnip", "bop/bop_pickled_turnip", 6, 0.8f, false, 1, new ItemStack(Items.glass_bottle));


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


        ConditionalRegistrar.registerItem(developer_foods, "developer_foods", ModConfigurationItems.enableDeveloperFoods);
        ConditionalRegistrar.registerItem(fish_bait, "fish_bait", ModConfigurationBlocks.enableFishFarm);
        ConditionalRegistrar.registerItem(bee_larva, "bee_larva", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(honey_bee, "honey_bee", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(carpenter_bee, "carpenter_bee", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(regal_bee, "regal_bee", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(boreal_bee, "boreal_bee", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(waxcomb, "waxcomb", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(honeycomb, "honeycomb", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(frozen_honey, "frozen_honey", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(royal_jelly, "royal_jelly", ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(mineral_mud_ball, "mineral_mud_ball", ModConfigurationItems.enableMineralMud);
        ConditionalRegistrar.registerItem(horn, "horn", ModConfigurationEntities.enableHornedSheep);
        ConditionalRegistrar.registerItem(baking_soda, "baking_soda");
        ConditionalRegistrar.registerItem(powdered_milk, "powdered_milk");
        ConditionalRegistrar.registerItem(salt, "salt");
        ConditionalRegistrar.registerItem(salt_pinch, "salt_pinch");
        ConditionalRegistrar.registerItem(sugar_pinch, "sugar_pinch");
        ConditionalRegistrar.registerItem(dough, "dough", ModConfigurationItems.enableDough);
        ConditionalRegistrar.registerItem(onion, "onion", ModConfigurationItems.enableOnion);
        ConditionalRegistrar.registerItem(saltwort, "saltwort");
        ConditionalRegistrar.registerItem(golden_saltwort, "golden_saltwort", ModConfigurationItems.enableGoldenFoods);
        ConditionalRegistrar.registerItem(golden_potato, "golden_potato", ModConfigurationItems.enableGoldenFoods);
        ConditionalRegistrar.registerItem(golden_berries, "golden_berries", ModConfigurationItems.enableGoldenFoods, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(salt_cooked_porkchop, "salt_cooked_porkchop", ModConfigurationItems.enableSaltedPorkchop);
        ConditionalRegistrar.registerItem(salt_cooked_beef, "salt_cooked_beef", ModConfigurationItems.enableSaltedBeef);
        ConditionalRegistrar.registerItem(salt_cooked_chicken, "salt_cooked_chicken", ModConfigurationItems.enableSaltedChicken);
        ConditionalRegistrar.registerItem(salt_cooked_rabbit, "salt_cooked_rabbit", ModConfigurationModCompatibility.enableSaltedRabbit, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(salt_cooked_mutton, "salt_cooked_mutton", ModConfigurationModCompatibility.enableSaltedMutton, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(strider, "strider", ModConfigurationItems.enableStrider);
        ConditionalRegistrar.registerItem(haunch, "haunch", ModConfigurationItems.enableHaunch);
        ConditionalRegistrar.registerItem(cured_meat, "cured_meat", ModConfigurationItems.enableCuredMeat);
        ConditionalRegistrar.registerItem(salt_cooked_cod, "salt_cooked_cod", ModConfigurationItems.enableSaltedCod);
        ConditionalRegistrar.registerItem(salt_cooked_salmon, "salt_cooked_salmon", ModConfigurationItems.enableSaltedSalmon);
        ConditionalRegistrar.registerItem(cooked_tropical_fish, "cooked_tropical_fish", ModConfigurationItems.enableTropicalFish);
        ConditionalRegistrar.registerItem(tailor, "tailor", ModConfigurationItems.enableTailor);
        ConditionalRegistrar.registerItem(calamari, "calamari", ModConfigurationItems.enableCalamari);
        ConditionalRegistrar.registerItem(salt_bread, "salt_bread", ModConfigurationItems.enableSaltedBread);
        ConditionalRegistrar.registerItem(salt_baked_potato, "salt_baked_potato", ModConfigurationItems.enableSaltedPotato);
        ConditionalRegistrar.registerItem(salt_beetroot, "salt_beetroot", ModConfigurationModCompatibility.enableSaltedBeetroot);
        ConditionalRegistrar.registerItem(salt_egg, "salt_egg", ModConfigurationItems.enableEgg);
        ConditionalRegistrar.registerItem(egg_bowl, "egg_bowl", ModConfigurationItems.enableEgg);
        ConditionalRegistrar.registerItem(salt_mushroom_stew, "salt_mushroom_stew", ModConfigurationItems.enableSaltedMushroomStew);
        ConditionalRegistrar.registerItem(salt_rabbit_stew, "salt_rabbit_stew", ModConfigurationModCompatibility.enableSaltedRabbitRagout, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(salt_beetroot_soup, "salt_beetroot_soup", ModConfigurationModCompatibility.enableSaltedBorscht, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(fungus_stew, "fungus_stew", ModConfigurationModCompatibility.enableFungusStew, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(chicken_soup, "chicken_soup", ModConfigurationItems.enableChickenSoup);
        ConditionalRegistrar.registerItem(beef_stew, "beef_stew", ModConfigurationItems.enableBeefStew);
        ConditionalRegistrar.registerItem(pumpkin_porridge, "pumpkin_porridge", ModConfigurationItems.enablePumpkinPorridge);
        ConditionalRegistrar.registerItem(cactus_soup, "cactus_soup", ModConfigurationItems.enableCactusSoup);
        ConditionalRegistrar.registerItem(bone_marrow_soup, "bone_marrow_soup", ModConfigurationItems.enableBoneMarrowSoup);
        ConditionalRegistrar.registerItem(stewed_vegetables, "stewed_vegetables", ModConfigurationItems.enableStewedVegetables);
        ConditionalRegistrar.registerItem(potato_mushroom, "potato_mushroom", ModConfigurationItems.enablePotatoMushroom);
        ConditionalRegistrar.registerItem(golden_vegetables, "golden_vegetables", ModConfigurationItems.enableGoldenFoods);
        ConditionalRegistrar.registerItem(fish_soup, "fish_soup", ModConfigurationItems.enableFishSoup);
        ConditionalRegistrar.registerItem(dandelion_salad, "dandelion_salad", ModConfigurationItems.enableDandelionSalad, ModConfigurationItems.enableOnion);
        ConditionalRegistrar.registerItem(wheat_sprouts, "wheat_sprouts", ModConfigurationItems.enableWheatSprouts);
        ConditionalRegistrar.registerItem(beetroot_salad, "beetroot_salad", ModConfigurationModCompatibility.enableBeetrootSalad, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(dressed_herring, "dressed_herring", ModConfigurationModCompatibility.enableDressedHerring, ModConfigurationItems.enableOnion, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(saltwort_salad, "saltwort_salad", ModConfigurationItems.enableSaltwortSalad);
        ConditionalRegistrar.registerItem(golden_saltwort_salad, "golden_saltwort_salad", ModConfigurationItems.enableGoldenFoods);
        ConditionalRegistrar.registerItem(saltwort_cooked_porkchop, "saltwort_cooked_porkchop", ModConfigurationItems.enableSaltwortPorkchop, ModConfigurationItems.enableSaltedPorkchop);
        ConditionalRegistrar.registerItem(saltwort_honey_porkchop, "saltwort_honey_porkchop", ModConfigurationItems.enableSaltwortHoneyPorkchop, ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(saltwort_cooked_beef, "saltwort_cooked_beef", ModConfigurationItems.enableSaltwortBeef, ModConfigurationItems.enableSaltedBeef);
        ConditionalRegistrar.registerItem(saltwort_cooked_mutton, "saltwort_cooked_mutton", ModConfigurationModCompatibility.enableSaltwortMutton, ModConfigurationModCompatibility.enableSaltedMutton, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(saltwort_cooked_strider, "saltwort_cooked_strider", ModConfigurationItems.enableSaltwortStrider, ModConfigurationItems.enableStrider);
        ConditionalRegistrar.registerItem(saltwort_cooked_haunch, "saltwort_cooked_haunch", ModConfigurationItems.enableSaltwortHaunch, ModConfigurationItems.enableHaunch);
        ConditionalRegistrar.registerItem(sugar_apple, "sugar_apple", ModConfigurationItems.enableSugaredApple);
        ConditionalRegistrar.registerItem(sugar_melon, "sugar_melon", ModConfigurationItems.enableSugaredMelon);
        ConditionalRegistrar.registerItem(sugar_berries, "sugar_berries", ModConfigurationModCompatibility.enableSugaredBerries, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(fruit_salad, "fruit_salad", ModConfigurationItems.enableFruitSalad);
        ConditionalRegistrar.registerItem(golden_fruit_salad, "golden_fruit_salad", ModConfigurationItems.enableGoldenFoods, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(grated_carrot, "grated_carrot", ModConfigurationItems.enableGratedCarrot);
        ConditionalRegistrar.registerItem(melon_soup, "melon_soup", ModConfigurationItems.enableMelonSoup);
        ConditionalRegistrar.registerItem(honey_porkchop, "honey_porkchop", ModConfigurationItems.enableHoneyPorkchop, ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(honey_apple, "honey_apple", ModConfigurationItems.enableHoneyApple, ModConfigurationItems.enableHoney);
        ConditionalRegistrar.registerItem(honey_berries, "honey_berries", ModConfigurationModCompatibility.enableHoneyBerries, ModConfigurationItems.enableHoney, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(chocolate_berries, "chocolate_berries", ModConfigurationModCompatibility.enableChocolateBerries, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(chocolate_bar, "chocolate_bar", ModConfigurationItems.enableChocolateBar);
        ConditionalRegistrar.registerItem(sweetberry_cookie, "sweetberry_cookie", ModConfigurationModCompatibility.enableBerryCookie);
        ConditionalRegistrar.registerItem(chorus_cookie, "chorus_cookie", ModConfigurationModCompatibility.enableChorusCookie);
        ConditionalRegistrar.registerItem(chocolate_pie, "chocolate_pie", ModConfigurationItems.enableChocolatePie);
        ConditionalRegistrar.registerItem(birthday_pie, "birthday_pie", ModConfigurationItems.enableBirthdayPie);
        ConditionalRegistrar.registerItem(apple_pie, "apple_pie", ModConfigurationItems.enableApplePie);
        ConditionalRegistrar.registerItem(sweetberry_pie, "sweetberry_pie", ModConfigurationModCompatibility.enableBerryPie, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(carrot_pie, "carrot_pie", ModConfigurationItems.enableCarrotPie);
        ConditionalRegistrar.registerItem(mushroom_pie, "mushroom_pie", ModConfigurationItems.enableMushroomPie);
        ConditionalRegistrar.registerItem(potato_pie, "potato_pie", ModConfigurationItems.enablePotatoPie);
        ConditionalRegistrar.registerItem(onion_pie, "onion_pie", ModConfigurationItems.enableOnionPie, ModConfigurationItems.enableOnion);
        ConditionalRegistrar.registerItem(shepherds_pie, "shepherds_pie", ModConfigurationItems.enableShepherdsPie);
        ConditionalRegistrar.registerItem(cod_pie, "cod_pie", ModConfigurationItems.enableCodPie);
        ConditionalRegistrar.registerItem(salmon_pie, "salmon_pie", ModConfigurationItems.enableSalmonPie);
        ConditionalRegistrar.registerItem(tropical_fish_pie, "tropical_fish_pie", ModConfigurationItems.enableTropicalFishPie);
        ConditionalRegistrar.registerItem(tailor_pie, "tailor_pie", ModConfigurationItems.enableTailorPie, ModConfigurationItems.enableTailor);
        ConditionalRegistrar.registerItem(calamari_pie, "calamari_pie", ModConfigurationItems.enableCalamariPie, ModConfigurationItems.enableCalamari);
        ConditionalRegistrar.registerItem(saltwort_pie, "saltwort_pie", ModConfigurationItems.enableSaltwortPie);
        ConditionalRegistrar.registerItem(fermented_saltwort, "fermented_saltwort", ModConfigurationItems.enableFermentedSaltwort);
        ConditionalRegistrar.registerItem(fermented_fern, "fermented_fern", ModConfigurationItems.enableFermentedFern);
        ConditionalRegistrar.registerItem(fermented_marsh_reeds, "fermented_marsh_reeds", ModConfigurationItems.enableFermentedFern);
        ConditionalRegistrar.registerItem(fermented_mushroom, "fermented_mushroom", ModConfigurationItems.enableFermentedMushroom);
        ConditionalRegistrar.registerItem(pickled_calamari, "pickled_calamari", ModConfigurationItems.enablePickledCalamari, ModConfigurationItems.enableCalamari);
        ConditionalRegistrar.registerItem(pickled_beetroot, "pickled_beetroot", ModConfigurationModCompatibility.enablePickledBeetroot, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(pickled_onion, "pickled_onion", ModConfigurationItems.enablePickledOnion, ModConfigurationItems.enableOnion);
        ConditionalRegistrar.registerItem(apple_preserves, "apple_preserves", ModConfigurationItems.enableApplePreserves);
        ConditionalRegistrar.registerItem(melon_preserves, "melon_preserves", ModConfigurationItems.enableMelonPreserves);
        ConditionalRegistrar.registerItem(berry_preserves, "berry_preserves", ModConfigurationModCompatibility.enableBerryPreserves, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerItem(fizzy_drink, "fizzy_drink", ModConfigurationItems.enableFizzyDrink);
        ConditionalRegistrar.registerItem(tunneler_concoction, "tunneler_concoction", ModConfigurationItems.enableTunnelersConcoction);
        ConditionalRegistrar.registerItem(muffin, "muffin", ModConfigurationItems.enableMuffin);
        ConditionalRegistrar.registerItem(tough_jelly, "tough_jelly", ModConfigurationItems.enableToughJelly);
        ConditionalRegistrar.registerItem(mud_helmet, "mud_helmet", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        ConditionalRegistrar.registerItem(mud_chestplate, "mud_chestplate", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        ConditionalRegistrar.registerItem(mud_leggings, "mud_leggings", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        ConditionalRegistrar.registerItem(mud_boots, "mud_boots", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        ConditionalRegistrar.registerItem(salt_pickaxe, "salt_pickaxe", ModConfigurationBlocks.enableSaltCrystal);
        ConditionalRegistrar.registerItem(salt_shard, "salt_shard", ModConfigurationBlocks.enableSaltCrystal);
        ConditionalRegistrar.registerItem(rainmaker_star, "rainmaker_star", ModConfigurationItems.enableRainmaker);
        ConditionalRegistrar.registerItem(rainmaker, "rainmaker", ModConfigurationItems.enableRainmaker);


        ConditionalRegistrar.registerItem(tf_salt_cooked_venison, "tf_salt_cooked_venison", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));
        ConditionalRegistrar.registerItem(tf_salt_meef_steak, "tf_salt_meef_steak", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));
        ConditionalRegistrar.registerItem(tf_salt_meef_stroganoff, "tf_salt_meef_stroganoff", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));
        ConditionalRegistrar.registerItem(tf_salt_hydra_chop, "tf_salt_hydra_chop", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));
        ConditionalRegistrar.registerItem(tf_pickled_mushgloom, "tf_pickled_mushgloom", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));
        ConditionalRegistrar.registerItem(tf_saltwort_cooked_venison, "tf_saltwort_cooked_venison", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));
        ConditionalRegistrar.registerItem(tf_saltwort_meef_steak, "tf_saltwort_meef_steak", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));


        ConditionalRegistrar.registerItem(bop_hemoglobin, "bop_hemoglobin", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_poison, "bop_poison", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_salt_shroom_powder, "bop_salt_shroom_powder", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_sugar_fruit_salad, "bop_sugar_fruit_salad", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_salt_veggie_salad, "bop_salt_veggie_salad", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_salt_shroom_salad, "bop_salt_shroom_salad", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_salt_rice_bowl, "bop_salt_rice_bowl", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));
        ConditionalRegistrar.registerItem(bop_pickled_turnip, "bop_pickled_turnip", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));


        ConditionalRegistrar.registerItem(wm_salt_cooked_bison, "wm_salt_cooked_bison", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));
        ConditionalRegistrar.registerItem(wm_salt_cooked_calamari, "wm_salt_cooked_calamari", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));
        ConditionalRegistrar.registerItem(wm_salt_cooked_chevon, "wm_salt_cooked_chevon", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));
        ConditionalRegistrar.registerItem(wm_salt_cooked_goose, "wm_salt_cooked_goose", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));
        ConditionalRegistrar.registerItem(wm_salt_cooked_mouse, "wm_salt_cooked_mouse", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));
        ConditionalRegistrar.registerItem(wm_salt_cooked_venison, "wm_salt_cooked_venison", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));
    }
}
