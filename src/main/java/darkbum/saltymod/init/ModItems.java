package darkbum.saltymod.init;

import darkbum.saltymod.api.ConditionalRegistrar;
import darkbum.saltymod.configuration.configs.*;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.item.*;
import darkbum.saltymod.potion.ProbablePotionEffect;

import static net.minecraft.item.EnumAction.drink;
import static net.minecraft.item.EnumAction.eat;

public class ModItems {

    public static final Potion speed = Potion.moveSpeed;
    public static final Potion slowness = Potion.moveSlowdown;
    public static final Potion haste = Potion.digSpeed;
    public static final Potion mining_fatigue = Potion.digSlowdown;
    public static final Potion strength = Potion.damageBoost;
    public static final Potion instant_health = Potion.heal;
    public static final Potion instant_damage = Potion.harm;
    public static final Potion jump_boost = Potion.jump;
    public static final Potion nausea = Potion.confusion;
    public static final Potion regeneration = Potion.regeneration;
    public static final Potion resistance = Potion.resistance;
    public static final Potion fire_resistance = Potion.fireResistance;
    public static final Potion water_breathing = Potion.waterBreathing;
    public static final Potion invisibility = Potion.invisibility;
    public static final Potion blindness = Potion.blindness;
    public static final Potion night_vision = Potion.nightVision;
    public static final Potion hunger = Potion.hunger;
    public static final Potion weakness = Potion.weakness;
    public static final Potion poison = Potion.poison;
    public static final Potion wither = Potion.wither;
    public static final Potion health_boost = Potion.field_76434_w;
    public static final Potion absorption = Potion.field_76444_x;
    public static final Potion saturation = Potion.field_76443_y;
    public static final Potion well_fed = ModPotion.wellFed;

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
    public static Item marsh_reeds_grass;
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
        SaltyMod.logger.info("Start to initialize SaltyMod Items");

        developer_foods = new ItemSaltFood("developer_foods").setCreativeTab(tab)
            .addVariant(0, "void_apple", "dev/void_apple", 0, 0.0f, 64, null, false, true, false, eat,
                "item.void_apple.tooltip",
                new ProbablePotionEffect(hunger.id, 70, 100))
            .addVariant(1, "stuffing_apple", "dev/stuffing_apple", 20, 1.0f, 64, null, false, true, false, eat,
                "item.void_apple.tooltip")
        /*            .addVariant(2, "testing_apple", "dev/test_food", 2, 0.3f, 64, null, false, true, false, null, new ProbablePotionEffect(ModPotion.wellFed.id, 6000))*/;
        ConditionalRegistrar.registerItem(developer_foods, "developer_foods", ModConfigurationItems.enableDeveloperFoods);

        fish_bait = new Item().setCreativeTab(tab).setUnlocalizedName("fish_bait").setTextureName("saltymod:fish_bait");
        ConditionalRegistrar.registerItem(fish_bait, "fish_bait", ModConfigurationBlocks.enableFishFarm);

        bee_larva = new Item().setCreativeTab(tab).setUnlocalizedName("bee_larva").setTextureName("saltymod:bee_larva");
        ConditionalRegistrar.registerItem(bee_larva, "bee_larva", ModConfigurationItems.enableHoney);

        honey_bee = new ItemBee("honey_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:honey_bee");
        ConditionalRegistrar.registerItem(honey_bee, "honey_bee", ModConfigurationItems.enableHoney);

        carpenter_bee = new ItemBee("carpenter_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:carpenter_bee");
        ConditionalRegistrar.registerItem(carpenter_bee, "carpenter_bee", ModConfigurationItems.enableHoney);

        regal_bee = new ItemBee("regal_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:regal_bee");
        ConditionalRegistrar.registerItem(regal_bee, "regal_bee", ModConfigurationItems.enableHoney);

        boreal_bee = new ItemBee("boreal_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:boreal_bee");
        ConditionalRegistrar.registerItem(boreal_bee, "boreal_bee", ModConfigurationItems.enableHoney);

        waxcomb = new Item().setCreativeTab(tab).setUnlocalizedName("waxcomb").setTextureName("saltymod:waxcomb");
        ConditionalRegistrar.registerItem(waxcomb, "waxcomb", ModConfigurationItems.enableHoney);

        honeycomb = new Item().setCreativeTab(tab).setUnlocalizedName("honeycomb").setTextureName("saltymod:honeycomb");
        ConditionalRegistrar.registerItem(honeycomb, "honeycomb", ModConfigurationItems.enableHoney);

        frozen_honey = new Item().setCreativeTab(tab).setUnlocalizedName("frozen_honey").setTextureName("saltymod:frozen_honey");
        ConditionalRegistrar.registerItem(frozen_honey, "frozen_honey", ModConfigurationItems.enableHoney);

        royal_jelly = new Item().setCreativeTab(tab).setUnlocalizedName("royal_jelly").setTextureName("saltymod:royal_jelly");
        ConditionalRegistrar.registerItem(royal_jelly, "royal_jelly", ModConfigurationItems.enableHoney);

        marsh_reeds_grass = new ItemMarshReedsGrass("marsh_reeds_grass", tab).setTextureName("saltymod:marsh_reeds_grass");
        ConditionalRegistrar.registerItem(marsh_reeds_grass, "marsh_reeds_grass", ModConfigurationWorldGeneration.enableSaltMarsh);

        mineral_mud_ball = new Item().setCreativeTab(tab).setUnlocalizedName("mineral_mud_ball").setTextureName("saltymod:mineral_mud_ball");
        ConditionalRegistrar.registerItem(mineral_mud_ball, "mineral_mud_ball", ModConfigurationItems.enableMineralMud);

        horn = new Item().setCreativeTab(tab).setUnlocalizedName("horn").setTextureName("saltymod:horn");
        ConditionalRegistrar.registerItem(horn, "horn", ModConfigurationEntities.enableHornedSheep);

        baking_soda = new Item().setCreativeTab(tab).setUnlocalizedName("baking_soda").setTextureName("saltymod:baking_soda");
        GameRegistry.registerItem(baking_soda, "baking_soda");

        powdered_milk = new ItemPowderedMilk("powdered_milk", tab);
        GameRegistry.registerItem(powdered_milk, "powdered_milk");

        salt = new ItemSalt("salt", tab).setTextureName("saltymod:salt");
        GameRegistry.registerItem(salt, "salt");

        salt_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("salt_pinch").setTextureName("saltymod:salt_pinch");
        GameRegistry.registerItem(salt_pinch, "salt_pinch");

        sugar_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("sugar_pinch").setTextureName("saltymod:sugar_pinch");
        GameRegistry.registerItem(sugar_pinch, "sugar_pinch");

        dough = new ItemSaltFood("dough").setCreativeTab(tab)
            .addVariant(0, "dough", "dough", 1, 0.3f, eat,
                new ProbablePotionEffect(nausea.id, 100, 0, 1.0f),
                new ProbablePotionEffect(slowness.id, 300, 0, 1.0f, 20));
        ConditionalRegistrar.registerItem(dough, "dough", ModConfigurationItems.enableDough);

        onion = new ItemSeedFood(2, 0.3F, ModBlocks.onions, Blocks.farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltymod:onion");
        ConditionalRegistrar.registerItem(onion, "onion", ModConfigurationItems.enableOnion);

        saltwort = new ItemSaltwort("saltwort", tab).setTextureName("saltymod:saltwort");
        GameRegistry.registerItem(saltwort, "saltwort");

        golden_saltwort = new ItemSaltFood("golden_saltwort").setCreativeTab(tab)
            .addVariant(0, "golden_saltwort", "golden_saltwort", 6, 1.2f, eat,
                new ProbablePotionEffect(regeneration.id, 60, 2));
        ConditionalRegistrar.registerItem(golden_saltwort, "golden_saltwort", ModConfigurationItems.enableGoldenFoods);
        golden_potato = new ItemSaltFood("golden_potato").setCreativeTab(tab)
            .addVariant(0, "golden_potato", "golden_potato", 6, 1.2f, eat);
        ConditionalRegistrar.registerItem(golden_potato, "golden_potato", ModConfigurationItems.enableGoldenFoods);
        golden_berries = new ItemSaltFood("golden_berries").setCreativeTab(tab)
            .addVariant(0, "golden_berries", "golden_berries", 3, 0.6f, 64, null, false, true, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 100, 1, 1.0f),
                new ProbablePotionEffect(absorption.id, 1200, 0, 1.0f))
            .addVariant(1, "golden_berries", "golden_berries", 3, 0.6f, 64, null, false, true, true, eat, null,
                new ProbablePotionEffect(regeneration.id, 300, 3),
                new ProbablePotionEffect(absorption.id, 1200, 3),
                new ProbablePotionEffect(resistance.id, 3000, 0),
                new ProbablePotionEffect(fire_resistance.id, 3000, 0));
        ConditionalRegistrar.registerItem(golden_berries, "golden_berries", ModConfigurationItems.enableGoldenFoods, Loader.isModLoaded("etfuturum"));

        salt_cooked_porkchop = new ItemSaltFood("salt_cooked_porkchop").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_porkchop", "salt_cooked_porkchop", 6, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(salt_cooked_porkchop, "salt_cooked_porkchop", ModConfigurationItems.enableSaltedPorkchop);

        salt_cooked_beef = new ItemSaltFood("salt_cooked_beef").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_beef", "salt_cooked_beef", 6, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(salt_cooked_beef, "salt_cooked_beef", ModConfigurationItems.enableSaltedBeef);

        salt_cooked_chicken = new ItemSaltFood("salt_cooked_chicken").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_chicken", "salt_cooked_chicken", 5, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(salt_cooked_chicken, "salt_cooked_chicken", ModConfigurationItems.enableSaltedChicken);

        salt_cooked_rabbit = new ItemSaltFood("salt_cooked_rabbit").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_rabbit", "salt_cooked_rabbit", 5, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(salt_cooked_rabbit, "salt_cooked_rabbit", ModConfigurationModCompatibility.enableSaltedRabbit, Loader.isModLoaded("etfuturum"));

        salt_cooked_mutton = new ItemSaltFood("salt_cooked_mutton").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_mutton", "salt_cooked_mutton", 6, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(salt_cooked_mutton, "salt_cooked_mutton", ModConfigurationModCompatibility.enableSaltedMutton, Loader.isModLoaded("etfuturum"));

        strider = new ItemSaltFood("strider").setCreativeTab(tab)
            .addVariant(0, "strider", "strider", 2, 0.6f, eat)
            .addVariant(1, "cooked_strider", "cooked_strider", 4, 0.6f, eat)
            .addVariant(2, "salt_cooked_strider", "salt_cooked_strider", 6, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(strider, "strider", ModConfigurationItems.enableStrider);

        haunch = new ItemSaltFood("haunch").setCreativeTab(tab)
            .addVariant(0, "haunch", "haunch", 2, 0.6f, eat)
            .addVariant(1, "cooked_haunch", "cooked_haunch", 4, 0.6f, eat)
            .addVariant(2, "salt_cooked_haunch", "salt_cooked_haunch", 6, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 3));
        ConditionalRegistrar.registerItem(haunch, "haunch", ModConfigurationItems.enableHaunch);

        cured_meat = new ItemSaltFood("cured_meat").setCreativeTab(tab)
            .addVariant(0, "cured_meat", "cured_meat", 4, 0.7f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 4));
        ConditionalRegistrar.registerItem(cured_meat, "cured_meat", ModConfigurationItems.enableCuredMeat);

        salt_cooked_cod = new ItemSaltFood("salt_cooked_cod").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_cod", "salt_cooked_cod", 4, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 2));
        ConditionalRegistrar.registerItem(salt_cooked_cod, "salt_cooked_cod", ModConfigurationItems.enableSaltedCod);

        salt_cooked_salmon = new ItemSaltFood("salt_cooked_salmon").setCreativeTab(tab)
            .addVariant(0, "salt_cooked_salmon", "salt_cooked_salmon", 4, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 2));
        ConditionalRegistrar.registerItem(salt_cooked_salmon, "salt_cooked_salmon", ModConfigurationItems.enableSaltedSalmon);

        cooked_tropical_fish = new ItemSaltFood("cooked_tropical_fish").setCreativeTab(tab)
            .addVariant(0, "cooked_tropical_fish", "cooked_tropical_fish", 3, 0.5f, eat)
            .addVariant(1, "salt_cooked_tropical_fish", "salt_cooked_tropical_fish", 4, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 2));
        ConditionalRegistrar.registerItem(cooked_tropical_fish, "cooked_tropical_fish", ModConfigurationItems.enableTropicalFish);

        tailor = new ItemSaltFood("tailor").setCreativeTab(tab)
            .addVariant(0, "tailor", "tailor", 1, 0.5f, eat,
                new ProbablePotionEffect(water_breathing.id, 60, 0))
            .addVariant(1, "cooked_tailor", "cooked_tailor", 3, 0.5f, eat)
            .addVariant(2, "salt_cooked_tailor", "salt_cooked_tailor", 4, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 2));
        ConditionalRegistrar.registerItem(tailor, "tailor", ModConfigurationItems.enableTailor);

        calamari = new ItemSaltFood("calamari").setCreativeTab(tab)
            .addVariant(0, "calamari", "calamari", 2, 0.5f, eat)
            .addVariant(1, "cooked_calamari", "cooked_calamari", 3, 0.5f, eat)
            .addVariant(2, "salt_cooked_calamari", "salt_cooked_calamari", 5, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 2));
        ConditionalRegistrar.registerItem(calamari, "calamari", ModConfigurationItems.enableCalamari);

        salt_bread = new ItemSaltFood("salt_bread").setCreativeTab(tab)
            .addVariant(0, "salt_bread", "salt_bread", 4, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 1));
        ConditionalRegistrar.registerItem(salt_bread, "salt_bread", ModConfigurationItems.enableSaltedBread);

        salt_baked_potato = new ItemSaltFood("salt_baked_potato").setCreativeTab(tab)
            .addVariant(0, "salt_baked_potato", "salt_baked_potato", 4, 0.6f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 1));
        ConditionalRegistrar.registerItem(salt_baked_potato, "salt_baked_potato", ModConfigurationItems.enableSaltedPotato);

        salt_beetroot = new ItemSaltFood("salt_beetroot").setCreativeTab(tab)
            .addVariant(0, "salt_beetroot", "salt_beetroot", 2, 0.3f, eat,
                new ProbablePotionEffect(health_boost.id, 300, 0));
        ConditionalRegistrar.registerItem(salt_beetroot, "salt_beetroot", ModConfigurationModCompatibility.enableSaltedBeetroot);

        salt_egg = new ItemSaltFood("salt_egg").setCreativeTab(tab)
            .addVariant(0, "salt_egg", "salt_egg", 2, 0.3f, 16, new ItemStack(Items.dye, 1, 15), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 300, 0));
        ConditionalRegistrar.registerItem(salt_egg, "salt_egg", ModConfigurationItems.enableEgg);

        egg_bowl = new ItemEggBowl("egg_bowl", tab).setMaxStackSize(16).setTextureName("saltymod:egg_bowl");
        ConditionalRegistrar.registerItem(egg_bowl, "egg_bowl", ModConfigurationItems.enableEgg);

        salt_mushroom_stew = new ItemSaltFood("salt_mushroom_stew").setCreativeTab(tab)
            .addVariant(0, "salt_mushroom_stew", "salt_mushroom_stew", 6, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(salt_mushroom_stew, "salt_mushroom_stew", ModConfigurationItems.enableSaltedMushroomStew);

        salt_rabbit_stew = new ItemSaltFood("salt_rabbit_stew").setCreativeTab(tab)
            .addVariant(0, "salt_rabbit_stew", "salt_rabbit_stew", 8, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(salt_rabbit_stew, "salt_rabbit_stew", ModConfigurationModCompatibility.enableSaltedRabbitRagout, Loader.isModLoaded("etfuturum"));

        salt_beetroot_soup = new ItemSaltFood("salt_beetroot_soup").setCreativeTab(tab)
            .addVariant(0, "salt_beetroot_soup", "salt_beetroot_soup", 6, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(salt_beetroot_soup, "salt_beetroot_soup", ModConfigurationModCompatibility.enableSaltedBorscht, Loader.isModLoaded("etfuturum"));

        pumpkin_porridge = new ItemSaltFood("pumpkin_porridge").setCreativeTab(tab)
            .addVariant(0, "pumpkin_porridge", "pumpkin_porridge", 5, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null)
            .addVariant(1, "salt_pumpkin_porridge", "salt_pumpkin_porridge", 6, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(pumpkin_porridge, "pumpkin_porridge", ModConfigurationItems.enablePumpkinPorridge);

        cactus_soup = new ItemSaltFood("cactus_soup").setCreativeTab(tab)
            .addVariant(0, "cactus_soup", "cactus_soup", 5, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(instant_health.id, 1, 0))
            .addVariant(1, "salt_cactus_soup", "salt_cactus_soup", 6, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(instant_health.id, 1, 1));
        ConditionalRegistrar.registerItem(cactus_soup, "cactus_soup", ModConfigurationItems.enableCactusSoup);

        bone_marrow_soup = new ItemSaltFood("bone_marrow_soup").setCreativeTab(tab)
            .addVariant(0, "bone_marrow_soup", "bone_marrow_soup", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null)
            .addVariant(1, "salt_bone_marrow_soup", "salt_bone_marrow_soup", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(bone_marrow_soup, "bone_marrow_soup", ModConfigurationItems.enableBoneMarrowSoup);

        stewed_vegetables = new ItemSaltFood("stewed_vegetables").setCreativeTab(tab)
            .addVariant(0, "stewed_vegetables", "stewed_vegetables", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(night_vision.id, 300, 0))
            .addVariant(1, "salt_stewed_vegetables", "salt_stewed_vegetables", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(night_vision.id, 600, 0));
        ConditionalRegistrar.registerItem(stewed_vegetables, "stewed_vegetables", ModConfigurationItems.enableStewedVegetables);

        potato_mushroom = new ItemSaltFood("potato_mushroom").setCreativeTab(tab)
            .addVariant(0, "potato_mushroom", "potato_mushroom", 5, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null)
            .addVariant(1, "salt_potato_mushroom", "salt_potato_mushroom", 6, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(potato_mushroom, "potato_mushroom", ModConfigurationItems.enablePotatoMushroom);

        golden_vegetables = new ItemSaltFood("golden_vegetables").setCreativeTab(tab)
            .addVariant(0, "golden_vegetables", "golden_vegetables", 10, 1.2f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 120, 2))
            .addVariant(1, "salt_golden_vegetables", "salt_golden_vegetables", 11, 1.2f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 180, 2));
        ConditionalRegistrar.registerItem(golden_vegetables, "golden_vegetables", ModConfigurationItems.enableGoldenFoods);

        fish_soup = new ItemSaltFood("fish_soup").setCreativeTab(tab)
            .addVariant(0, "fish_soup", "fish_soup", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(water_breathing.id, 300, 0))
            .addVariant(1, "salt_fish_soup", "salt_fish_soup", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(water_breathing.id, 600, 0));
        ConditionalRegistrar.registerItem(fish_soup, "fish_soup", ModConfigurationItems.enableFishSoup);

        dandelion_salad = new ItemSaltFood("dandelion_salad").setCreativeTab(tab)
            .addVariant(0, "dandelion_salad", "dandelion_salad", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(resistance.id, 300, 0),
                new ProbablePotionEffect(instant_health.id, 1, 0))
            .addVariant(1, "salt_dandelion_salad", "salt_dandelion_salad", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(resistance.id, 600, 0),
                new ProbablePotionEffect(instant_health.id, 1, 1));
        ConditionalRegistrar.registerItem(dandelion_salad, "dandelion_salad", ModConfigurationItems.enableDandelionSalad, ModConfigurationItems.enableOnion);

        wheat_sprouts = new ItemSaltFood("wheat_sprouts").setCreativeTab(tab)
            .addVariant(0, "wheat_sprouts", "wheat_sprouts", 4, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(instant_health.id, 1, 2))
            .addVariant(1, "salt_wheat_sprouts", "salt_wheat_sprouts", 5, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(instant_health.id, 1, 3));
        ConditionalRegistrar.registerItem(wheat_sprouts, "wheat_sprouts", ModConfigurationItems.enableWheatSprouts);

        beetroot_salad = new ItemSaltFood("beetroot_salad").setCreativeTab(tab)
            .addVariant(0, "beetroot_salad", "beetroot_salad", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null)
            .addVariant(1, "salt_beetroot_salad", "salt_beetroot_salad", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0));
        ConditionalRegistrar.registerItem(beetroot_salad, "beetroot_salad", ModConfigurationModCompatibility.enableBeetrootSalad, Loader.isModLoaded("etfuturum"));

        dressed_herring = new ItemSaltFood("dressed_herring").setCreativeTab(tab)
            .addVariant(0, "dressed_herring", "dressed_herring", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(night_vision.id, 300, 0),
                new ProbablePotionEffect(water_breathing.id, 300, 0))
            .addVariant(1, "salt_dressed_herring", "salt_dressed_herring", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(night_vision.id, 600, 0),
                new ProbablePotionEffect(water_breathing.id, 600, 0));
        ConditionalRegistrar.registerItem(dressed_herring, "dressed_herring", ModConfigurationModCompatibility.enableDressedHerring, ModConfigurationItems.enableOnion, Loader.isModLoaded("etfuturum"));

        saltwort_salad = new ItemSaltFood("saltwort_salad").setCreativeTab(tab)
            .addVariant(0, "saltwort_salad", "saltwort_salad", 5, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 180, 2));
        ConditionalRegistrar.registerItem(saltwort_salad, "saltwort_salad", ModConfigurationItems.enableSaltwortSalad);

        golden_saltwort_salad = new ItemSaltFood("golden_saltwort_salad").setCreativeTab(tab)
            .addVariant(0, "golden_saltwort_salad", "golden_saltwort_salad", 6, 1.2f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 180, 3));
        ConditionalRegistrar.registerItem(golden_saltwort_salad, "golden_saltwort_salad", ModConfigurationItems.enableGoldenFoods);

        saltwort_cooked_porkchop = new ItemSaltFood("saltwort_cooked_porkchop").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_porkchop", "saltwort_cooked_porkchop", 12, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 300, 1));
        ConditionalRegistrar.registerItem(saltwort_cooked_porkchop, "saltwort_cooked_porkchop", ModConfigurationItems.enableSaltwortPorkchop, ModConfigurationItems.enableSaltedPorkchop);

        saltwort_honey_porkchop = new ItemSaltFood("saltwort_honey_porkchop").setCreativeTab(tab)
            .addVariant(0, "saltwort_honey_porkchop", "saltwort_honey_porkchop", 12, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 300, 1),
                new ProbablePotionEffect(absorption.id, 900, 2));
        ConditionalRegistrar.registerItem(saltwort_honey_porkchop, "saltwort_honey_porkchop", ModConfigurationItems.enableSaltwortHoneyPorkchop, ModConfigurationItems.enableHoney);

        saltwort_cooked_beef = new ItemSaltFood("saltwort_cooked_beef").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_beef", "saltwort_cooked_beef", 12, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 300, 1));
        ConditionalRegistrar.registerItem(saltwort_cooked_beef, "saltwort_cooked_beef", ModConfigurationItems.enableSaltwortBeef, ModConfigurationItems.enableSaltedBeef);

        saltwort_cooked_mutton = new ItemSaltFood("saltwort_cooked_mutton").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_mutton", "saltwort_cooked_mutton", 12, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 300, 1));
        ConditionalRegistrar.registerItem(saltwort_cooked_mutton, "saltwort_cooked_mutton", ModConfigurationModCompatibility.enableSaltwortMutton, ModConfigurationModCompatibility.enableSaltedMutton, Loader.isModLoaded("etfuturum"));

        saltwort_cooked_strider = new ItemSaltFood("saltwort_cooked_strider").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_strider", "saltwort_cooked_strider", 12, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 300, 1));
        ConditionalRegistrar.registerItem(saltwort_cooked_strider, "saltwort_cooked_strider", ModConfigurationItems.enableSaltwortStrider, ModConfigurationItems.enableStrider);

        saltwort_cooked_haunch = new ItemSaltFood("saltwort_cooked_haunch").setCreativeTab(tab)
            .addVariant(0, "saltwort_cooked_haunch", "saltwort_cooked_haunch", 12, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 300, 1));
        ConditionalRegistrar.registerItem(saltwort_cooked_haunch, "saltwort_cooked_haunch", ModConfigurationItems.enableSaltwortHaunch, ModConfigurationItems.enableHaunch);

        sugar_apple = new ItemSaltFood("sugar_apple").setCreativeTab(tab)
            .addVariant(0, "sugar_apple", "sugar_apple", 4, 0.5f, eat,
                new ProbablePotionEffect(speed.id, 120, 0));
        ConditionalRegistrar.registerItem(sugar_apple, "sugar_apple", ModConfigurationItems.enableSugaredApple);

        sugar_melon = new ItemSaltFood("sugar_melon").setCreativeTab(tab)
            .addVariant(0, "sugar_melon", "sugar_melon_slice", 3, 0.5f, eat,
                new ProbablePotionEffect(speed.id, 120, 0));
        ConditionalRegistrar.registerItem(sugar_melon, "sugar_melon", ModConfigurationItems.enableSugaredMelon);

        sugar_berries = new ItemSaltFood("sugar_berries").setCreativeTab(tab)
            .addVariant(0, "sugar_berries", "sugar_sweet_berries", 3, 0.5f, eat,
                new ProbablePotionEffect(speed.id, 120, 0));
        ConditionalRegistrar.registerItem(sugar_berries, "sugar_berries", ModConfigurationModCompatibility.enableSugaredBerries, Loader.isModLoaded("etfuturum"));

        fruit_salad = new ItemSaltFood("fruit_salad").setCreativeTab(tab)
            .addVariant(0, "fruit_salad", "fruit_salad", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(jump_boost.id, 60, 0))
            .addVariant(1, "sugar_fruit_salad", "sugar_fruit_salad", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(speed.id, 120, 0),
                new ProbablePotionEffect(jump_boost.id, 60, 0));
        ConditionalRegistrar.registerItem(fruit_salad, "fruit_salad", ModConfigurationItems.enableFruitSalad);

        golden_fruit_salad = new ItemSaltFood("golden_fruit_salad").setCreativeTab(tab)
            .addVariant(0, "golden_fruit_salad", "golden_fruit_salad", 8, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 120, 1),
                new ProbablePotionEffect(absorption.id, 3000, 0))
            .addVariant(1, "sugar_golden_fruit_salad", "sugar_golden_fruit_salad", 9, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(speed.id, 120, 0),
                new ProbablePotionEffect(regeneration.id, 240, 1),
                new ProbablePotionEffect(absorption.id, 3000, 1),
                new ProbablePotionEffect(instant_health.id, 1, 1));
        ConditionalRegistrar.registerItem(golden_fruit_salad, "golden_fruit_salad", ModConfigurationItems.enableGoldenFoods, Loader.isModLoaded("etfuturum"));

        grated_carrot = new ItemSaltFood("grated_carrot").setCreativeTab(tab)
            .addVariant(0, "grated_carrot", "grated_carrot", 6, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(night_vision.id, 600, 0))
            .addVariant(1, "sugar_grated_carrot", "sugar_grated_carrot", 7, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(speed.id, 120, 0),
                new ProbablePotionEffect(night_vision.id, 1200, 0));
        ConditionalRegistrar.registerItem(grated_carrot, "grated_carrot", ModConfigurationItems.enableGratedCarrot);

        melon_soup = new ItemSaltFood("melon_soup").setCreativeTab(tab)
            .addVariant(0, "melon_soup", "melon_soup", 5, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(jump_boost.id, 600, 0))
            .addVariant(1, "sugar_melon_soup", "sugar_melon_soup", 6, 0.8f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(speed.id, 120, 0),
                new ProbablePotionEffect(jump_boost.id, 1200, 1));
        ConditionalRegistrar.registerItem(melon_soup, "melon_soup", ModConfigurationItems.enableMelonSoup);

        honey_porkchop = new ItemSaltFood("honey_porkchop").setCreativeTab(tab)
            .addVariant(0, "honey_porkchop", "honey_porkchop", 6, 0.7f, eat,
                new ProbablePotionEffect(absorption.id, 900, 2));
        ConditionalRegistrar.registerItem(honey_porkchop, "honey_porkchop", ModConfigurationItems.enableHoneyPorkchop, ModConfigurationItems.enableHoney);

        honey_apple = new ItemSaltFood("honey_apple").setCreativeTab(tab)
            .addVariant(0, "honey_apple", "honey_apple", 4, 0.5f, eat,
                new ProbablePotionEffect(absorption.id, 600, 1));
        ConditionalRegistrar.registerItem(honey_apple, "honey_apple", ModConfigurationItems.enableHoneyApple, ModConfigurationItems.enableHoney);

        honey_berries = new ItemSaltFood("honey_berries").setCreativeTab(tab)
            .addVariant(0, "honey_berries", "honey_berries", 3, 0.5f, eat,
                new ProbablePotionEffect(absorption.id, 300, 0));
        ConditionalRegistrar.registerItem(honey_berries, "honey_berries", ModConfigurationModCompatibility.enableHoneyBerries, ModConfigurationItems.enableHoney, Loader.isModLoaded("etfuturum"));

        chocolate_berries = new ItemSaltFood("chocolate_berries").setCreativeTab(tab)
            .addVariant(0, "chocolate_berries", "chocolate_berries", 3, 0.5f, eat,
                new ProbablePotionEffect(haste.id, 300, 0));
        ConditionalRegistrar.registerItem(chocolate_berries, "chocolate_berries", ModConfigurationModCompatibility.enableChocolateBerries, Loader.isModLoaded("etfuturum"));

        chocolate_bar = new ItemSaltFood("chocolate_bar").setCreativeTab(tab)
            .addVariant(0, "chocolate_bar", "chocolate_bar", 3, 0.2f, 64, null, false, false, false, eat, "item.chocolate_bar.tooltip",
                new ProbablePotionEffect(haste.id, 300, 0),
                new ProbablePotionEffect(nausea.id, 300, 0, 1.0f, 20));
        ConditionalRegistrar.registerItem(chocolate_bar, "chocolate_bar", ModConfigurationItems.enableChocolateBar);

        chocolate_pie = new ItemSaltFood("chocolate_pie").setCreativeTab(tab)
            .addVariant(0, "chocolate_pie", "chocolate_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(haste.id, 900, 2));
        ConditionalRegistrar.registerItem(chocolate_pie, "chocolate_pie", ModConfigurationItems.enableChocolatePie);

        birthday_pie = new ItemSaltFood("birthday_pie").setCreativeTab(tab)
            .addVariant(0, "birthday_pie", "birthday_pie", 9, 0.9f, eat);
        ConditionalRegistrar.registerItem(birthday_pie, "birthday_pie", ModConfigurationItems.enableBirthdayPie);

        apple_pie = new ItemSaltFood("apple_pie").setCreativeTab(tab)
            .addVariant(0, "apple_pie", "apple_pie", 8, 0.9f, eat);
        ConditionalRegistrar.registerItem(apple_pie, "apple_pie", ModConfigurationItems.enableApplePie);

        sweetberry_pie = new ItemSaltFood("sweetberry_pie").setCreativeTab(tab)
            .addVariant(0, "sweetberry_pie", "sweetberry_pie", 7, 0.9f, eat);
        ConditionalRegistrar.registerItem(sweetberry_pie, "sweetberry_pie", ModConfigurationModCompatibility.enableBerryPie, Loader.isModLoaded("etfuturum"));

        carrot_pie = new ItemSaltFood("carrot_pie").setCreativeTab(tab)
            .addVariant(0, "carrot_pie", "carrot_pie", 8, 0.9f, eat,
                new ProbablePotionEffect(night_vision.id, 1200, 0));
        ConditionalRegistrar.registerItem(carrot_pie, "carrot_pie", ModConfigurationItems.enableCarrotPie);

        mushroom_pie = new ItemSaltFood("mushroom_pie").setCreativeTab(tab)
            .addVariant(0, "mushroom_pie", "mushroom_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(strength.id, 300, 1),
                new ProbablePotionEffect(blindness.id, 60, 0));
        ConditionalRegistrar.registerItem(mushroom_pie, "mushroom_pie", ModConfigurationItems.enableMushroomPie);

        potato_pie = new ItemSaltFood("potato_pie").setCreativeTab(tab)
            .addVariant(0, "potato_pie", "potato_pie", 7, 0.9f, eat);
        ConditionalRegistrar.registerItem(potato_pie, "potato_pie", ModConfigurationItems.enablePotatoPie);

        onion_pie = new ItemSaltFood("onion_pie").setCreativeTab(tab)
            .addVariant(0, "onion_pie", "onion_pie", 8, 0.9f, eat);
        ConditionalRegistrar.registerItem(onion_pie, "onion_pie", ModConfigurationItems.enableOnionPie, ModConfigurationItems.enableOnion);

        shepherds_pie = new ItemSaltFood("shepherds_pie").setCreativeTab(tab)
            .addVariant(0, "shepherds_pie", "shepherds_pie", 10, 0.9f, eat);
        ConditionalRegistrar.registerItem(shepherds_pie, "shepherds_pie", ModConfigurationItems.enableShepherdsPie);

        cod_pie = new ItemSaltFood("cod_pie").setCreativeTab(tab)
            .addVariant(0, "cod_pie", "cod_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(water_breathing.id, 300, 0));
        ConditionalRegistrar.registerItem(cod_pie, "cod_pie", ModConfigurationItems.enableCodPie);

        salmon_pie = new ItemSaltFood("salmon_pie").setCreativeTab(tab)
            .addVariant(0, "salmon_pie", "salmon_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(water_breathing.id, 300, 0));
        ConditionalRegistrar.registerItem(salmon_pie, "salmon_pie", ModConfigurationItems.enableSalmonPie);

        tropical_fish_pie = new ItemSaltFood("tropical_fish_pie").setCreativeTab(tab)
            .addVariant(0, "tropical_fish_pie", "tropical_fish_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(water_breathing.id, 300, 0));
        ConditionalRegistrar.registerItem(tropical_fish_pie, "tropical_fish_pie", ModConfigurationItems.enableTropicalFishPie);

        tailor_pie = new ItemSaltFood("tailor_pie").setCreativeTab(tab)
            .addVariant(0, "tailor_pie", "tailor_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(water_breathing.id, 300, 0));
        ConditionalRegistrar.registerItem(tailor_pie, "tailor_pie", ModConfigurationItems.enableTailorPie, ModConfigurationItems.enableTailor);

        calamari_pie = new ItemSaltFood("calamari_pie").setCreativeTab(tab)
            .addVariant(0, "calamari_pie", "calamari_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(water_breathing.id, 300, 0));
        ConditionalRegistrar.registerItem(calamari_pie, "calamari_pie", ModConfigurationItems.enableCalamariPie, ModConfigurationItems.enableCalamari);

        saltwort_pie = new ItemSaltFood("saltwort_pie").setCreativeTab(tab)
            .addVariant(0, "saltwort_pie", "saltwort_pie", 7, 0.9f, eat,
                new ProbablePotionEffect(regeneration.id, 600, 1));
        ConditionalRegistrar.registerItem(saltwort_pie, "saltwort_pie", ModConfigurationItems.enableSaltwortPie);

        fermented_saltwort = new ItemSaltFood("fermented_saltwort").setCreativeTab(tab)
            .addVariant(0, "fermented_saltwort", "fermented_saltwort", 5, 0.7f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(regeneration.id, 900, 2));
        ConditionalRegistrar.registerItem(fermented_saltwort, "fermented_saltwort", ModConfigurationItems.enableFermentedSaltwort);

        fermented_fern = new ItemSaltFood("fermented_fern").setCreativeTab(tab)
            .addVariant(0, "fermented_fern", "fermented_fern", 4, 0.7f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(health_boost.id, 1200, 1),
                new ProbablePotionEffect(resistance.id, 900, 1));
        ConditionalRegistrar.registerItem(fermented_fern, "fermented_fern", ModConfigurationItems.enableFermentedFern);

        fermented_mushroom = new ItemSaltFood("fermented_mushroom").setCreativeTab(tab)
            .addVariant(0, "fermented_mushroom", "fermented_mushroom", 4, 0.7f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(health_boost.id, 1200, 1),
                new ProbablePotionEffect(strength.id, 600, 1),
                new ProbablePotionEffect(blindness.id, 120, 0));
        ConditionalRegistrar.registerItem(fermented_mushroom, "fermented_mushroom", ModConfigurationItems.enableFermentedMushroom);

        pickled_calamari = new ItemSaltFood("pickled_calamari").setCreativeTab(tab)
            .addVariant(0, "pickled_calamari", "pickled_calamari", 6, 0.7f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(health_boost.id, 1200, 1),
                new ProbablePotionEffect(water_breathing.id, 600, 0));
        ConditionalRegistrar.registerItem(pickled_calamari, "pickled_calamari", ModConfigurationItems.enablePickledCalamari, ModConfigurationItems.enableCalamari);

        pickled_beetroot = new ItemSaltFood("pickled_beetroot").setCreativeTab(tab)
            .addVariant(0, "pickled_beetroot", "pickled_beetroot", 5, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(health_boost.id, 1200, 1));
        ConditionalRegistrar.registerItem(pickled_beetroot, "pickled_beetroot", ModConfigurationModCompatibility.enablePickledBeetroot, Loader.isModLoaded("etfuturum"));

        pickled_onion = new ItemSaltFood("pickled_onion").setCreativeTab(tab)
            .addVariant(0, "pickled_onion", "pickled_onion", 6, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(health_boost.id, 1200, 1));
        ConditionalRegistrar.registerItem(pickled_onion, "pickled_onion", ModConfigurationItems.enablePickledOnion, ModConfigurationItems.enableOnion);

        apple_preserves = new ItemSaltFood("apple_preserves").setCreativeTab(tab)
            .addVariant(0, "apple_preserves", "apple_preserves", 8, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(speed.id, 300, 1));
        ConditionalRegistrar.registerItem(apple_preserves, "apple_preserves", ModConfigurationItems.enableApplePreserves);

        melon_preserves = new ItemSaltFood("melon_preserves").setCreativeTab(tab)
            .addVariant(0, "melon_preserves", "melon_preserves", 6, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(speed.id, 300, 1),
                new ProbablePotionEffect(jump_boost.id, 600, 1));
        ConditionalRegistrar.registerItem(melon_preserves, "melon_preserves", ModConfigurationItems.enableMelonPreserves);

        berry_preserves = new ItemSaltFood("berry_preserves").setCreativeTab(tab)
            .addVariant(0, "berry_preserves", "berry_preserves", 6, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(speed.id, 300, 1));
        ConditionalRegistrar.registerItem(berry_preserves, "berry_preserves", ModConfigurationModCompatibility.enableBerryPreserves, Loader.isModLoaded("etfuturum"));

        fizzy_drink = new ItemFizzyDrink("fizzy_drink", tab).setTextureName("saltymod:fizzy_drink");
        ConditionalRegistrar.registerItem(fizzy_drink, "fizzy_drink", ModConfigurationItems.enableFizzyDrink);

        tunneler_concoction = new ItemSaltFood("tunneler_concoction").setCreativeTab(tab)
            .addVariant(0, "tunneler_concoction", "tunneler_concoction", 0, 0.0f, 1, new ItemStack(Items.glass_bottle), false, true, false, drink,
                "item.tunneler_concoction.tooltip",
                new ProbablePotionEffect(haste.id, 3600, 4),
                new ProbablePotionEffect(instant_damage.id, 1, 1, 1.0f, 20),
                new ProbablePotionEffect(nausea.id, 120, 0, 1.0f, 20));
        ConditionalRegistrar.registerItem(tunneler_concoction, "tunneler_concoction", ModConfigurationItems.enableTunnelersConcoction);

        muffin = new ItemSaltFood("muffin").setCreativeTab(tab)
            .addVariant(0, "muffin", "muffin", 3, 3.4f, 64, null, false, false, false, eat,
                "item.muffin.tooltip",
                new ProbablePotionEffect(well_fed.id, 3400, 0, 1.0f, 20));
        ConditionalRegistrar.registerItem(muffin, "muffin", ModConfigurationItems.enableMuffin);

        tough_jelly = new ItemSaltFood("tough_jelly").setCreativeTab(tab)
            .addVariant(0, "tough_jelly", "tough_jelly", 1, 0.3f, 64, null, false, true, false, eat, null,
                new ProbablePotionEffect(nausea.id, 300, 0, 0.3f));
        ConditionalRegistrar.registerItem(tough_jelly, "tough_jelly", ModConfigurationItems.enableToughJelly);

        mud_helmet = new ItemMudArmor("mud_helmet", CommonProxy.mudMaterial, 0);
        ConditionalRegistrar.registerItem(mud_helmet, "mud_helmet", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        mud_chestplate = new ItemMudArmor("mud_chestplate", CommonProxy.mudMaterial, 1);
        ConditionalRegistrar.registerItem(mud_chestplate, "mud_chestplate", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        mud_leggings = new ItemMudArmor("mud_leggings", CommonProxy.mudMaterial, 2);
        ConditionalRegistrar.registerItem(mud_leggings, "mud_leggings", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);
        mud_boots = new ItemMudArmor("mud_boots", CommonProxy.mudMaterial, 3);
        ConditionalRegistrar.registerItem(mud_boots, "mud_boots", ModConfigurationItems.enableMudArmor, ModConfigurationItems.enableMineralMud);

        salt_pickaxe = new ItemSaltPickaxe("salt_pickaxe", tab).setTextureName("saltymod:salt_pickaxe");
        ConditionalRegistrar.registerItem(salt_pickaxe, "salt_pickaxe", ModConfigurationBlocks.enableSaltCrystal);

        salt_shard = new ItemSaltShard("salt_shard", tab).setTextureName("saltymod:salt_shard");
        ConditionalRegistrar.registerItem(salt_shard, "salt_shard", ModConfigurationBlocks.enableSaltCrystal);

        rainmaker_star = new Item().setCreativeTab(tab).setUnlocalizedName("rainmaker_star").setTextureName("saltymod:rainmaker_star");
        ConditionalRegistrar.registerItem(rainmaker_star, "rainmaker_star", ModConfigurationItems.enableRainmaker);
        rainmaker = new ItemRainmaker("rainmaker", tab).setTextureName("saltymod:rainmaker");
        ConditionalRegistrar.registerItem(rainmaker, "rainmaker", ModConfigurationItems.enableRainmaker);


        tf_salt_cooked_venison = new ItemSaltFood("tf_salt_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "tf_salt_cooked_venison", "tf/tf_salt_cooked_venison", 9, 0.9f, eat);
        ConditionalRegistrar.registerItem(tf_salt_cooked_venison, "tf_salt_cooked_venison", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));

        tf_salt_meef_steak = new ItemSaltFood("tf_salt_meef_steak").setCreativeTab(tab)
            .addVariant(0, "tf_salt_meef_steak", "tf/tf_salt_meef_steak", 7, 0.7f, eat);
        ConditionalRegistrar.registerItem(tf_salt_meef_steak, "tf_salt_meef_steak", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));

        tf_salt_meef_stroganoff = new ItemSaltFood("tf_salt_meef_stroganoff").setCreativeTab(tab)
            .addVariant(0, "tf_salt_meef_stroganoff", "tf/tf_salt_meef_stroganoff", 9, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null);
        ConditionalRegistrar.registerItem(tf_salt_meef_stroganoff, "tf_salt_meef_stroganoff", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));

        tf_salt_hydra_chop = new ItemSaltFood("tf_salt_hydra_chop").setCreativeTab(tab)
            .addVariant(0, "tf_salt_hydra_chop", "tf/tf_salt_hydra_chop", 19, 2.1f, 64, null, false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 100, 0));
        ConditionalRegistrar.registerItem(tf_salt_hydra_chop, "tf_salt_hydra_chop", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));

        tf_pickled_mushgloom = new ItemSaltFood("tf_pickled_mushgloom").setCreativeTab(tab)
            .addVariant(0, "tf_pickled_mushgloom", "tf/tf_pickled_mushgloom", 6, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null,
                new ProbablePotionEffect(night_vision.id, 1200, 0),
                new ProbablePotionEffect(slowness.id, 100, 0));
        ConditionalRegistrar.registerItem(tf_pickled_mushgloom, "tf_pickled_mushgloom", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));

        tf_saltwort_cooked_venison = new ItemSaltFood("tf_saltwort_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "tf_saltwort_cooked_venison", "tf/tf_saltwort_cooked_venison", 10, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 100, 0));
        ConditionalRegistrar.registerItem(tf_saltwort_cooked_venison, "tf_saltwort_cooked_venison", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));

        tf_saltwort_meef_steak = new ItemSaltFood("tf_saltwort_meef_steak").setCreativeTab(tab)
            .addVariant(0, "tf_saltwort_meef_steak", "tf/tf_saltwort_meef_steak", 8, 0.9f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(regeneration.id, 100, 0));
        ConditionalRegistrar.registerItem(tf_saltwort_meef_steak, "tf_saltwort_meef_steak", ModConfigurationModCompatibility.enableTFFoods, Loader.isModLoaded("TwilightForest"));


        bop_hemoglobin = new ItemSaltFood("bop_hemoglobin").setCreativeTab(tab)
            .addVariant(0, "bop_hemoglobin", "bop/bop_hemoglobin", 2, 4.0f, eat,
                new ProbablePotionEffect(instant_health.id, 1, 1));
        ConditionalRegistrar.registerItem(bop_hemoglobin, "bop_hemoglobin", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_poison = new Item().setCreativeTab(tab).setUnlocalizedName("bop_poison").setTextureName("saltymod:bop/bop_poison");
        ConditionalRegistrar.registerItem(bop_poison, "bop_poison", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_salt_shroom_powder = new ItemSaltFood("bop_salt_shroom_powder").setCreativeTab(tab)
            .addVariant(0, "bop_salt_shroom_powder", "bop/bop_salt_shroom_powder", 2, 0.2f, eat,
                new ProbablePotionEffect(nausea.id, 300, 0, 0.3f));
        ConditionalRegistrar.registerItem(bop_salt_shroom_powder, "bop_salt_shroom_powder", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_sugar_fruit_salad = new ItemSaltFood("bop_sugar_fruit_salad").setCreativeTab(tab)
            .addVariant(0, "bop_sugar_fruit_salad", "bop/bop_sugar_fruit_salad", 7, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(haste.id, 1200, 2, 0.1f));
        ConditionalRegistrar.registerItem(bop_sugar_fruit_salad, "bop_sugar_fruit_salad", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_salt_veggie_salad = new ItemSaltFood("bop_salt_veggie_salad").setCreativeTab(tab)
            .addVariant(0, "bop_salt_veggie_salad", "bop/bop_salt_veggie_salad", 7, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(health_boost.id, 1550, 2, 0.1f));
        ConditionalRegistrar.registerItem(bop_salt_veggie_salad, "bop_salt_veggie_salad", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_salt_shroom_salad = new ItemSaltFood("bop_salt_shroom_salad").setCreativeTab(tab)
            .addVariant(0, "bop_salt_shroom_salad", "bop/bop_salt_shroom_salad", 7, 0.7f, 16, new ItemStack(Items.bowl), false, false, false, eat, null,
                new ProbablePotionEffect(jump_boost.id, 900, 2, 0.1f));
        ConditionalRegistrar.registerItem(bop_salt_shroom_salad, "bop_salt_shroom_salad", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_salt_rice_bowl = new ItemSaltFood("bop_salt_rice_bowl").setCreativeTab(tab)
            .addVariant(0, "bop_salt_rice_bowl", "bop/bop_salt_rice_bowl", 3, 0.2f, 16, new ItemStack(Items.bowl), false, false, false, eat, null);
        ConditionalRegistrar.registerItem(bop_salt_rice_bowl, "bop_salt_rice_bowl", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));

        bop_pickled_turnip = new ItemSaltFood("bop_pickled_turnip").setCreativeTab(tab)
            .addVariant(0, "bop_pickled_turnip", "bop/bop_pickled_turnip", 6, 0.8f, 1, new ItemStack(Items.glass_bottle), false, false, false, drink, null);
        ConditionalRegistrar.registerItem(bop_pickled_turnip, "bop_pickled_turnip", ModConfigurationModCompatibility.enableBOPFoods, Loader.isModLoaded("BiomesOPlenty"));


        wm_salt_cooked_bison = new ItemSaltFood("wm_salt_cooked_bison").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_bison", "wm/wm_salt_cooked_bison", 9, 0.7f, eat);
        ConditionalRegistrar.registerItem(wm_salt_cooked_bison, "wm_salt_cooked_bison", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));

        wm_salt_cooked_calamari = new ItemSaltFood("wm_salt_cooked_calamari").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_calamari", "wm/wm_salt_cooked_calamari", 6, 0.7f, eat);
        ConditionalRegistrar.registerItem(wm_salt_cooked_calamari, "wm_salt_cooked_calamari", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));

        wm_salt_cooked_chevon = new ItemSaltFood("wm_salt_cooked_chevon").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_chevon", "wm/wm_salt_cooked_chevon", 7, 0.7f, eat);
        ConditionalRegistrar.registerItem(wm_salt_cooked_chevon, "wm_salt_cooked_chevon", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));

        wm_salt_cooked_goose = new ItemSaltFood("wm_salt_cooked_goose").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_goose", "wm/wm_salt_cooked_goose", 7, 0.7f, eat);
        ConditionalRegistrar.registerItem(wm_salt_cooked_goose, "wm_salt_cooked_goose", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));

        wm_salt_cooked_mouse = new ItemSaltFood("wm_salt_cooked_mouse").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_mouse", "wm/wm_salt_cooked_mouse", 5, 0.7f, eat);
        ConditionalRegistrar.registerItem(wm_salt_cooked_mouse, "wm_salt_cooked_mouse", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));

        wm_salt_cooked_venison = new ItemSaltFood("wm_salt_cooked_venison").setCreativeTab(tab)
            .addVariant(0, "wm_salt_cooked_venison", "wm/wm_salt_cooked_venison", 9, 0.7f, eat);
        ConditionalRegistrar.registerItem(wm_salt_cooked_venison, "wm_salt_cooked_venison", ModConfigurationModCompatibility.enableWMFoods, Loader.isModLoaded("wildmobsmod"));


        SaltyMod.logger.info("Finished initializing SaltyMod Items");
    }
}
