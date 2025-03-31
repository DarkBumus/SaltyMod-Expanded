package darkbum.saltymod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.SaltyMod;
//import darkbum.saltymod.blockitem.ItemBlossomSign;
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.potion.ProbablePotionEffect;
import darkbum.saltymod.item.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.potion.Potion;
import darkbum.saltymod.common.CommonProxy;

public class ModItems {
    static CreativeTabs tab = CommonProxy.tabSalt;

    public static Item void_apple;

    public static Item stuffing_apple;

    public static Item testing_apple;

    public static Item fish_bait;

    public static Item bee_larva;

    public static Item carpenter_bee;

    public static Item waxcomb;

    public static Item honeycomb;

    public static Item royal_jelly;

    public static Item mineral_mud_ball;

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

    public static Item cooked_strider;

    public static Item salt_cooked_strider;

    public static Item haunch;

    public static Item cooked_haunch;

    public static Item salt_cooked_haunch;

    public static Item cured_meat;

    public static Item salt_cooked_cod;

    public static Item salt_cooked_salmon;

    public static Item cooked_tropical_fish;

    public static Item salt_cooked_tropical_fish;

    public static Item tailor;

    public static Item cooked_tailor;

    public static Item salt_cooked_tailor;

    public static Item calamari;

    public static Item cooked_calamari;

    public static Item salt_cooked_calamari;

    public static Item salt_bread;

    public static Item salt_baked_potato;

    public static Item salt_beetroot;

    public static Item salt_egg;

    public static Item salt_mushroom_stew;

    public static Item salt_rabbit_stew;

    public static Item salt_beetroot_soup;

    public static Item pumpkin_porridge;

    public static Item salt_pumpkin_porridge;

    public static Item cactus_soup;

    public static Item salt_cactus_soup;

    public static Item stewed_vegetables;

    public static Item salt_stewed_vegetables;

    public static Item potato_mushroom;

    public static Item salt_potato_mushroom;

    public static Item golden_vegetables;

    public static Item salt_golden_vegetables;

    public static Item fish_soup;

    public static Item salt_fish_soup;

    public static Item dandelion_salad;

    public static Item salt_dandelion_salad;

    public static Item wheat_sprouts;

    public static Item salt_wheat_sprouts;

    public static Item beetroot_salad;

    public static Item salt_beetroot_salad;

    public static Item dressed_herring;

    public static Item salt_dressed_herring;

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

    public static Item sugar_fruit_salad;

    public static Item golden_fruit_salad;

    public static Item sugar_golden_fruit_salad;

    public static Item grated_carrot;

    public static Item sugar_grated_carrot;

    public static Item melon_soup;

    public static Item sugar_melon_soup;

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

//    field_76434_w = Health Boost
//    field_76443_y = Saturation
//    field_76444_x = Absorption

    public static void init() {
        SaltyMod.logger.info("Start to initialize SaltyMod Items");

        if (ModConfiguration.enableDeveloperFoods) {
            void_apple = new ItemVoidApple("void_apple", null).setAlwaysEdible().setTextureName("saltymod:dev/void_apple");
            GameRegistry.registerItem(void_apple, "void_apple");
            stuffing_apple = new ItemStuffingApple("stuffing_apple", null).setAlwaysEdible().setTextureName("saltymod:dev/stuffing_apple");
            GameRegistry.registerItem(stuffing_apple, "stuffing_apple");
//            testing_apple = new ItemSaltFood("testing_apple", 2, 0.3F, new ProbablePotionEffect(ModPotion.wellFed.id, 6000)).setAlwaysEdible().setCreativeTab(null).setTextureName("saltymod:dev/test_food");
//            GameRegistry.registerItem(testing_apple, "testing_apple");
        }
        if (ModConfiguration.enableFishFarm) {
            fish_bait = new Item().setCreativeTab(tab).setUnlocalizedName("fish_bait").setTextureName("saltymod:fish_bait");
            GameRegistry.registerItem(fish_bait, "fish_bait");
        }
        if (ModConfiguration.enableHoney) {
            bee_larva = new Item().setCreativeTab(tab).setUnlocalizedName("bee_larva").setTextureName("saltymod:bee_larva");
            GameRegistry.registerItem(bee_larva, "bee_larva");
            carpenter_bee = new ItemCarpenterBee("carpenter_bee", tab).setMaxStackSize(1).setMaxDamage(18).setTextureName("saltymod:carpenter_bee");
            GameRegistry.registerItem(carpenter_bee, "carpenter_bee");
            waxcomb = new Item().setCreativeTab(tab).setUnlocalizedName("waxcomb").setTextureName("saltymod:waxcomb");
            GameRegistry.registerItem(waxcomb, "waxcomb");
            honeycomb = new Item().setCreativeTab(tab).setUnlocalizedName("honeycomb").setTextureName("saltymod:honeycomb");
            GameRegistry.registerItem(honeycomb, "honeycomb");
            royal_jelly = new Item().setCreativeTab(tab).setUnlocalizedName("royal_jelly").setTextureName("saltymod:royal_jelly");
            GameRegistry.registerItem(royal_jelly, "royal_jelly");
        }
        if(ModConfiguration.enableMineralMud) {
            mineral_mud_ball = new Item().setCreativeTab(tab).setUnlocalizedName("mineral_mud_ball").setTextureName("saltymod:mineral_mud_ball");
            GameRegistry.registerItem(mineral_mud_ball, "mineral_mud_ball");
        }
        baking_soda = new Item().setCreativeTab(tab).setUnlocalizedName("baking_soda").setTextureName("saltymod:baking_soda");
        GameRegistry.registerItem(baking_soda, "baking_soda");
        if (ModConfiguration.enableEvaporator) {
            powdered_milk = new ItemPowderedMilk("powdered_milk", tab);
            GameRegistry.registerItem(powdered_milk, "powdered_milk");
        }
        salt = new ItemSalt("salt", tab).setTextureName("saltymod:salt");
        GameRegistry.registerItem(salt, "salt");
        salt_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("salt_pinch").setTextureName("saltymod:salt_pinch");
        GameRegistry.registerItem(salt_pinch, "salt_pinch");
        sugar_pinch = new Item().setCreativeTab(tab).setUnlocalizedName("sugar_pinch").setTextureName("saltymod:sugar_pinch");
        GameRegistry.registerItem(sugar_pinch, "sugar_pinch");
        if (ModConfiguration.enableDough) {
            dough = new ItemDough("dough", tab).setTextureName("saltymod:dough");
            GameRegistry.registerItem(dough, "dough");
        }
        if (ModConfiguration.enableOnion) {
            onion = new ItemSeedFood(2, 0.3F, ModBlocks.onions, Blocks.farmland).setUnlocalizedName("onion").setCreativeTab(tab).setTextureName("saltymod:onion");
            GameRegistry.registerItem(onion, "onion");
        }
        saltwort = new ItemSaltwort("saltwort", tab).setTextureName("saltymod:saltwort");
        GameRegistry.registerItem(saltwort, "saltwort");
        if (ModConfiguration.enableGoldenFoods) {
            golden_saltwort = new ItemSaltFood("golden_saltwort", 6, 1.2F, new ProbablePotionEffect(Potion.regeneration.id, 60, 2)).setCreativeTab(tab).setTextureName("saltymod:golden_saltwort");
            GameRegistry.registerItem(golden_saltwort, "golden_saltwort");
            golden_potato = new ItemSaltFood("golden_potato", 6, 1.2F).setCreativeTab(tab).setTextureName("saltymod:golden_potato");
            GameRegistry.registerItem(golden_potato, "golden_potato");
            if (Loader.isModLoaded("etfuturum")) {
                golden_berries = new ItemBerriesGold(3, 0.6F, false).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setUnlocalizedName("golden_berries").setCreativeTab(tab).setTextureName("saltymod:golden_berries");
                GameRegistry.registerItem(golden_berries, "golden_berries");
            }
        }
        if (ModConfiguration.enableSaltedPorkchop) {
            salt_cooked_porkchop = new ItemSaltFood("salt_cooked_porkchop", 6, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_porkchop");
            GameRegistry.registerItem(salt_cooked_porkchop, "salt_cooked_porkchop");
        }
        if (ModConfiguration.enableSaltedBeef) {
            salt_cooked_beef = new ItemSaltFood("salt_cooked_beef", 6, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_beef");
            GameRegistry.registerItem(salt_cooked_beef, "salt_cooked_beef");
        }
        if (ModConfiguration.enableSaltedChicken) {
            salt_cooked_chicken = new ItemSaltFood("salt_cooked_chicken", 5, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_chicken");
            GameRegistry.registerItem(salt_cooked_chicken, "salt_cooked_chicken");
        }
        if (Loader.isModLoaded("etfuturum")) {
            if(ModConfiguration.enableSaltedRabbit) {
                salt_cooked_rabbit = new ItemSaltFood("salt_cooked_rabbit", 5, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_rabbit");
                GameRegistry.registerItem(salt_cooked_rabbit, "salt_cooked_rabbit");
            }
            if(ModConfiguration.enableSaltedMutton) {
                salt_cooked_mutton = new ItemSaltFood("salt_cooked_mutton", 6, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_mutton");
                GameRegistry.registerItem(salt_cooked_mutton, "salt_cooked_mutton");
            }
        }
        if (ModConfiguration.enableStrider) {
            strider = new ItemSaltFood("strider", 2, 0.6F).setCreativeTab(tab).setTextureName("saltymod:strider");
            GameRegistry.registerItem(strider, "strider");
            cooked_strider = new ItemSaltFood("cooked_strider", 4, 0.6F).setCreativeTab(tab).setTextureName("saltymod:cooked_strider");
            GameRegistry.registerItem(cooked_strider, "cooked_strider");
            salt_cooked_strider = new ItemSaltFood("salt_cooked_strider", 6, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_strider");
            GameRegistry.registerItem(salt_cooked_strider, "salt_cooked_strider");
        }
        if (ModConfiguration.enableHaunch) {
            haunch = new ItemSaltFood("haunch", 2, 0.6F).setCreativeTab(tab).setTextureName("saltymod:haunch");
            GameRegistry.registerItem(haunch, "haunch");
            cooked_haunch = new ItemSaltFood("cooked_haunch", 4, 0.6F).setCreativeTab(tab).setTextureName("saltymod:cooked_haunch");
            GameRegistry.registerItem(cooked_haunch, "cooked_haunch");
            salt_cooked_haunch = new ItemSaltFood("salt_cooked_haunch", 6, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 3)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_haunch");
            GameRegistry.registerItem(salt_cooked_haunch, "salt_cooked_haunch");
        }
        if (ModConfiguration.enableCuredMeat) {
            cured_meat = new ItemSaltFood("cured_meat", 4, 0.7F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 4)).setCreativeTab(tab).setTextureName("saltymod:cured_meat");
            GameRegistry.registerItem(cured_meat, "cured_meat");
        }
        if (ModConfiguration.enableSaltedCod) {
            salt_cooked_cod = new ItemSaltFood("salt_cooked_cod", 4, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_cod");
            GameRegistry.registerItem(salt_cooked_cod, "salt_cooked_cod");
        }
        if (ModConfiguration.enableSaltedSalmon) {
            salt_cooked_salmon = new ItemSaltFood("salt_cooked_salmon", 4, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_salmon");
            GameRegistry.registerItem(salt_cooked_salmon, "salt_cooked_salmon");
        }
        if (ModConfiguration.enableTropicalFish) {
            cooked_tropical_fish = new ItemSaltFood("cooked_tropical_fish", 3, 0.5F).setCreativeTab(tab).setTextureName("saltymod:cooked_tropical_fish");
            GameRegistry.registerItem(cooked_tropical_fish, "cooked_tropical_fish");
            salt_cooked_tropical_fish = new ItemSaltFood("salt_cooked_tropical_fish", 4, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_tropical_fish");
            GameRegistry.registerItem(salt_cooked_tropical_fish, "salt_cooked_tropical_fish");
        }
        if (ModConfiguration.enableTailor) {
            tailor = new ItemSaltFood("tailor", 1, 0.5F, new ProbablePotionEffect(Potion.waterBreathing.id, 3, 0)).setCreativeTab(tab).setTextureName("saltymod:tailor");
            GameRegistry.registerItem(tailor, "tailor");
            cooked_tailor = new ItemSaltFood("cooked_tailor", 3, 0.5F).setCreativeTab(tab).setTextureName("saltymod:cooked_tailor");
            GameRegistry.registerItem(cooked_tailor, "cooked_tailor");
            salt_cooked_tailor = new ItemSaltFood("salt_cooked_tailor", 4, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_tailor");
            GameRegistry.registerItem(salt_cooked_tailor, "salt_cooked_tailor");
        }
        if (ModConfiguration.enableCalamari) {
            calamari = new ItemSaltFood("calamari", 2, 0.5F).setCreativeTab(tab).setTextureName("saltymod:calamari");
            GameRegistry.registerItem(calamari, "calamari");
            cooked_calamari = new ItemSaltFood("cooked_calamari", 3, 0.5F).setCreativeTab(tab).setTextureName("saltymod:cooked_calamari");
            GameRegistry.registerItem(cooked_calamari, "cooked_calamari");
            salt_cooked_calamari = new ItemSaltFood("salt_cooked_calamari", 5, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 2)).setCreativeTab(tab).setTextureName("saltymod:salt_cooked_calamari");
            GameRegistry.registerItem(salt_cooked_calamari, "salt_cooked_calamari");
        }
        if (ModConfiguration.enableSaltedBread) {
            salt_bread = new ItemSaltFood("salt_bread", 4, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 1)).setCreativeTab(tab).setTextureName("saltymod:salt_bread");
            GameRegistry.registerItem(salt_bread, "salt_bread");
        }
        if (ModConfiguration.enableSaltedPotato) {
            salt_baked_potato = new ItemSaltFood("salt_baked_potato", 4, 0.6F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 1)).setCreativeTab(tab).setTextureName("saltymod:salt_baked_potato");
            GameRegistry.registerItem(salt_baked_potato, "salt_baked_potato");
        }
        if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableSaltedBeetroot) {
            salt_beetroot = new ItemSaltFood("salt_beetroot", 2, 0.3F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:salt_beetroot");
            GameRegistry.registerItem(salt_beetroot, "salt_beetroot");
        }
        if (ModConfiguration.enableEgg) {
            salt_egg = new ItemSaltFood("salt_egg", 2, 0.3F, new ProbablePotionEffect(Potion.field_76434_w.id, 300, 0)).setMaxStackSize(16).setCreativeTab(tab).setTextureName("saltymod:salt_egg");
            GameRegistry.registerItem(salt_egg, "salt_egg");
        }
        if (ModConfiguration.enableSaltedMushroomStew) {
            salt_mushroom_stew = new ItemSaltFood("salt_mushroom_stew", 6, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_mushroom_stew");
            GameRegistry.registerItem(salt_mushroom_stew, "salt_mushroom_stew");
        }
        if (Loader.isModLoaded("etfuturum")) {
            if(ModConfiguration.enableSaltedRabbitRagout) {
                salt_rabbit_stew = new ItemSaltFood("salt_rabbit_stew", 8, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_rabbit_stew");
                GameRegistry.registerItem(salt_rabbit_stew, "salt_rabbit_stew");
            }
            if(ModConfiguration.enableSaltedBorscht) {
                salt_beetroot_soup = new ItemSaltFood("salt_beetroot_soup", 6, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_beetroot_soup");
                GameRegistry.registerItem(salt_beetroot_soup, "salt_beetroot_soup");
            }
        }
        if (ModConfiguration.enablePumpkinPorridge) {
            pumpkin_porridge = new ItemSaltFood("pumpkin_porridge", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:pumpkin_porridge");
            GameRegistry.registerItem(pumpkin_porridge, "pumpkin_porridge");
            salt_pumpkin_porridge = new ItemSaltFood("salt_pumpkin_porridge", 6, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_pumpkin_porridge");
            GameRegistry.registerItem(salt_pumpkin_porridge, "salt_pumpkin_porridge");
        }
        if (ModConfiguration.enableCactusSoup) {
            cactus_soup = new ItemSaltFood("cactus_soup", 5, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.heal.id, 20, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:cactus_soup");
            GameRegistry.registerItem(cactus_soup, "cactus_soup");
            salt_cactus_soup = new ItemSaltFood("salt_cactus_soup", 6, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.heal.id, 20, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_cactus_soup");
            GameRegistry.registerItem(salt_cactus_soup, "salt_cactus_soup");
        }
        if (ModConfiguration.enableStewedVegetables) {
            stewed_vegetables = new ItemSaltFood("stewed_vegetables", 6, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.nightVision.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:stewed_vegetables");
            GameRegistry.registerItem(stewed_vegetables, "stewed_vegetables");
            salt_stewed_vegetables = new ItemSaltFood("salt_stewed_vegetables", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.nightVision.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_stewed_vegetables");
            GameRegistry.registerItem(salt_stewed_vegetables, "salt_stewed_vegetables");
        }
        if (ModConfiguration.enablePotatoMushroom) {
            potato_mushroom = new ItemSaltFood("potato_mushroom", 5, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:potato_mushroom");
            GameRegistry.registerItem(potato_mushroom, "potato_mushroom");
            salt_potato_mushroom = new ItemSaltFood("salt_potato_mushroom", 6, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_potato_mushroom");
            GameRegistry.registerItem(salt_potato_mushroom, "salt_potato_mushroom");
        }
        if (ModConfiguration.enableGoldenFoods) {
            golden_vegetables = new ItemSaltFood("golden_vegetables", 10, 1.2F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 120, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:golden_vegetables");
            GameRegistry.registerItem(golden_vegetables, "golden_vegetables");
            salt_golden_vegetables = new ItemSaltFood("salt_golden_vegetables", 11, 1.2F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 180, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_golden_vegetables");
            GameRegistry.registerItem(salt_golden_vegetables, "salt_golden_vegetables");
        }
        if (ModConfiguration.enableFishSoup) {
            fish_soup = new ItemSaltFood("fish_soup", 6, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:fish_soup");
            GameRegistry.registerItem(fish_soup, "fish_soup");
            salt_fish_soup = new ItemSaltFood("salt_fish_soup", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_fish_soup");
            GameRegistry.registerItem(salt_fish_soup, "salt_fish_soup");
        }
        if (ModConfiguration.enableOnion && ModConfiguration.enableDandelionSalad) {
            dandelion_salad = new ItemSaltFood("dandelion_salad", 6, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.resistance.id, 300, 0), new ProbablePotionEffect(Potion.heal.id, 20, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:dandelion_salad");
            GameRegistry.registerItem(dandelion_salad, "dandelion_salad");
            salt_dandelion_salad = new ItemSaltFood("salt_dandelion_salad", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.resistance.id, 600, 0), new ProbablePotionEffect(Potion.heal.id, 20, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_dandelion_salad");
            GameRegistry.registerItem(salt_dandelion_salad, "salt_dandelion_salad");
        }
        if (ModConfiguration.enableWheatSprouts) {
            wheat_sprouts = new ItemSaltFood("wheat_sprouts", 4, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.heal.id, 20, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:wheat_sprouts");
            GameRegistry.registerItem(wheat_sprouts, "wheat_sprouts");
            salt_wheat_sprouts = new ItemSaltFood("salt_wheat_sprouts", 5, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.heal.id, 20, 3)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_wheat_sprouts");
            GameRegistry.registerItem(salt_wheat_sprouts, "salt_wheat_sprouts");
        }
        if (Loader.isModLoaded("etfuturum")) {
            if(ModConfiguration.enableBeetrootSalad) {
                beetroot_salad = new ItemSaltFood("beetroot_salad", 6, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:beetroot_salad");
                GameRegistry.registerItem(beetroot_salad, "beetroot_salad");
                salt_beetroot_salad = new ItemSaltFood("salt_beetroot_salad", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_beetroot_salad");
                GameRegistry.registerItem(salt_beetroot_salad, "salt_beetroot_salad");
            }
            if (ModConfiguration.enableOnion && ModConfiguration.enableDressedHerring) {
                dressed_herring = new ItemSaltFood("dressed_herring", 6, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.nightVision.id, 300, 0), new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:dressed_herring");
                GameRegistry.registerItem(dressed_herring, "dressed_herring");
                salt_dressed_herring = new ItemSaltFood("salt_dressed_herring", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.nightVision.id, 600, 0), new ProbablePotionEffect(Potion.waterBreathing.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:salt_dressed_herring");
                GameRegistry.registerItem(salt_dressed_herring, "salt_dressed_herring");
            }
        }
        if (ModConfiguration.enableSaltwortSalad) {
            saltwort_salad = new ItemSaltFood("saltwort_salad", 5, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 180, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_salad");
            GameRegistry.registerItem(saltwort_salad, "saltwort_salad");
        }
        if (ModConfiguration.enableGoldenFoods) {
            golden_saltwort_salad = new ItemSaltFood("golden_saltwort_salad", 6, 1.2F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 180, 3)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:golden_saltwort_salad");
            GameRegistry.registerItem(golden_saltwort_salad, "golden_saltwort_salad");
        }
        if (ModConfiguration.enableSaltedPorkchop && ModConfiguration.enableSaltwortPorkchop) {
            saltwort_cooked_porkchop = new ItemSaltFood("saltwort_cooked_porkchop", 12, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_cooked_porkchop");
            GameRegistry.registerItem(saltwort_cooked_porkchop, "saltwort_cooked_porkchop");
        }
        if (ModConfiguration.enableHoney && ModConfiguration.enableSaltwortHoneyPorkchop) {
            saltwort_honey_porkchop = new ItemSaltFood("saltwort_honey_porkchop", 12, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 300, 1), new ProbablePotionEffect(Potion.field_76444_x.id, 900, 2)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_honey_porkchop");
            GameRegistry.registerItem(saltwort_honey_porkchop, "saltwort_honey_porkchop");
        }
        if (ModConfiguration.enableSaltedBeef && ModConfiguration.enableSaltwortBeef) {
            saltwort_cooked_beef = new ItemSaltFood("saltwort_cooked_beef", 12, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_cooked_beef");
            GameRegistry.registerItem(saltwort_cooked_beef, "saltwort_cooked_beef");
        }
        if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableSaltwortMutton) {
            saltwort_cooked_mutton = new ItemSaltFood("saltwort_cooked_mutton", 12, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_cooked_mutton");
            GameRegistry.registerItem(saltwort_cooked_mutton, "saltwort_cooked_mutton");
        }
        if (ModConfiguration.enableStrider && ModConfiguration.enableSaltwortStrider) {
            saltwort_cooked_strider = new ItemSaltFood("saltwort_cooked_strider", 12, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_cooked_strider");
            GameRegistry.registerItem(saltwort_cooked_strider, "saltwort_cooked_strider");
        }
        if (ModConfiguration.enableHaunch && ModConfiguration.enableSaltwortHaunch) {
            saltwort_cooked_haunch = new ItemSaltFood("saltwort_cooked_haunch", 12, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.field_76434_w.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 300, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:saltwort_cooked_haunch");
            GameRegistry.registerItem(saltwort_cooked_haunch, "saltwort_cooked_haunch");
        }
        if (ModConfiguration.enableSugaredApple) {
            sugar_apple = new ItemSaltFood("sugar_apple", 4, 0.5F, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltymod:sugar_apple");
            GameRegistry.registerItem(sugar_apple, "sugar_apple");
        }
        if (ModConfiguration.enableSugaredMelon) {
            sugar_melon = new ItemSaltFood("sugar_melon", 3, 0.5F, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltymod:sugar_melon_slice");
            GameRegistry.registerItem(sugar_melon, "sugar_melon");
        }
        if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableSugaredBerries) {
            sugar_berries = new ItemSaltFood("sugar_berries", 3, 0.5F, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0)).setCreativeTab(tab).setTextureName("saltymod:sugar_sweet_berries");
            GameRegistry.registerItem(sugar_berries, "sugar_berries");
        }
        if (ModConfiguration.enableFruitSalad) {
            fruit_salad = new ItemSaltFood("fruit_salad", 6, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.jump.id, 60, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:fruit_salad");
            GameRegistry.registerItem(fruit_salad, "fruit_salad");
            sugar_fruit_salad = new ItemSaltFood("sugar_fruit_salad", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0), new ProbablePotionEffect(Potion.jump.id, 60, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:sugar_fruit_salad");
            GameRegistry.registerItem(sugar_fruit_salad, "sugar_fruit_salad");
        }
        if (ModConfiguration.enableGoldenFoods) {
            if (Loader.isModLoaded("etfuturum")) {
                golden_fruit_salad = new ItemSaltFood("golden_fruit_salad", 8, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 120, 1), new ProbablePotionEffect(Potion.field_76444_x.id, 3000)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:golden_fruit_salad");
                GameRegistry.registerItem(golden_fruit_salad, "golden_fruit_salad");
                sugar_golden_fruit_salad = new ItemSaltFood("sugar_golden_fruit_salad", 9, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0), new ProbablePotionEffect(Potion.regeneration.id, 240, 1), new ProbablePotionEffect(Potion.field_76444_x.id, 3000, 1), new ProbablePotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:sugar_golden_fruit_salad");
                GameRegistry.registerItem(sugar_golden_fruit_salad, "sugar_golden_fruit_salad");
            }
        }
        if (ModConfiguration.enableGratedCarrot) {
            grated_carrot = new ItemSaltFood("grated_carrot", 6, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.nightVision.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:grated_carrot");
            GameRegistry.registerItem(grated_carrot, "grated_carrot");
            sugar_grated_carrot = new ItemSaltFood("sugar_grated_carrot", 7, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0), new ProbablePotionEffect(Potion.nightVision.id, 1200, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:sugar_grated_carrot");
            GameRegistry.registerItem(sugar_grated_carrot, "sugar_grated_carrot");
        }
        if (ModConfiguration.enableMelonSoup) {
            melon_soup = new ItemSaltFood("melon_soup", 5, 0.7F, Items.bowl, new ProbablePotionEffect(Potion.jump.id, 600, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:melon_soup");
            GameRegistry.registerItem(melon_soup, "melon_soup");
            sugar_melon_soup = new ItemSaltFood("sugar_melon_soup", 6, 0.8F, Items.bowl, new ProbablePotionEffect(Potion.moveSpeed.id, 120, 0), new ProbablePotionEffect(Potion.jump.id, 1200, 1)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:sugar_melon_soup");
            GameRegistry.registerItem(sugar_melon_soup, "sugar_melon_soup");
        }
        if (ModConfiguration.enableHoney) {
            if (ModConfiguration.enableHoneyPorkchop) {
                honey_porkchop = new ItemSaltFood("honey_porkchop", 6, 0.7F, new ProbablePotionEffect(Potion.field_76444_x.id, 900, 2)).setCreativeTab(tab).setTextureName("saltymod:honey_porkchop");
                GameRegistry.registerItem(honey_porkchop, "honey_porkchop");
            }
            if (ModConfiguration.enableHoneyApple) {
                honey_apple = new ItemSaltFood("honey_apple", 4, 0.5F, new ProbablePotionEffect(Potion.field_76444_x.id, 600, 1)).setCreativeTab(tab).setTextureName("saltymod:honey_apple");
                GameRegistry.registerItem(honey_apple, "honey_apple");
            }
            if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableHoneyBerries) {
                honey_berries = new ItemSaltFood("honey_berries", 3, 0.5F, new ProbablePotionEffect(Potion.field_76444_x.id, 300)).setCreativeTab(tab).setTextureName("saltymod:honey_berries");
                GameRegistry.registerItem(honey_berries, "honey_berries");
            }
        }
        if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableChocolateBerries) {
            chocolate_berries = new ItemSaltFood("chocolate_berries", 3, 0.5F, new ProbablePotionEffect(Potion.digSpeed.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:chocolate_berries");
            GameRegistry.registerItem(chocolate_berries, "chocolate_berries");
        }
        if (ModConfiguration.enableChocolateBar) {
            chocolate_bar = new ItemChocolateBar("chocolate_bar", tab).setTextureName("saltymod:chocolate_bar");
            GameRegistry.registerItem(chocolate_bar, "chocolate_bar");
        }
        if (ModConfiguration.enableChocolatePie) {
            chocolate_pie = new ItemSaltFood("chocolate_pie", 7, 0.9F, new ProbablePotionEffect(Potion.digSpeed.id, 900, 2)).setCreativeTab(tab).setTextureName("saltymod:chocolate_pie");
            GameRegistry.registerItem(chocolate_pie, "chocolate_pie");
        }
        if (ModConfiguration.enableBirthdayPie) {
            birthday_pie = new ItemSaltFood("birthday_pie", 9, 0.9F).setCreativeTab(tab).setTextureName("saltymod:birthday_pie");
            GameRegistry.registerItem(birthday_pie, "birthday_pie");
        }
        if (ModConfiguration.enableApplePie) {
            apple_pie = new ItemSaltFood("apple_pie", 8, 0.9F).setCreativeTab(tab).setTextureName("saltymod:apple_pie");
            GameRegistry.registerItem(apple_pie, "apple_pie");
        }
        if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableBerryPie) {
            sweetberry_pie = new ItemSaltFood("sweetberry_pie", 7, 0.9F).setCreativeTab(tab).setTextureName("saltymod:sweetberry_pie");
            GameRegistry.registerItem(sweetberry_pie, "sweetberry_pie");
        }
        if (ModConfiguration.enableCarrotPie) {
            carrot_pie = new ItemSaltFood("carrot_pie", 8, 0.9F, new ProbablePotionEffect(Potion.nightVision.id, 1200, 0)).setCreativeTab(tab).setTextureName("saltymod:carrot_pie");
            GameRegistry.registerItem(carrot_pie, "carrot_pie");
        }
        if (ModConfiguration.enableMushroomPie) {
            mushroom_pie = new ItemSaltFood("mushroom_pie", 7, 0.9F, new ProbablePotionEffect(Potion.damageBoost.id, 300, 1), new ProbablePotionEffect(Potion.blindness.id, 60, 0)).setCreativeTab(tab).setTextureName("saltymod:mushroom_pie");
            GameRegistry.registerItem(mushroom_pie, "mushroom_pie");
        }
        if (ModConfiguration.enablePotatoPie) {
            potato_pie = new ItemSaltFood("potato_pie", 7, 0.9F).setCreativeTab(tab).setTextureName("saltymod:potato_pie");
            GameRegistry.registerItem(potato_pie, "potato_pie");
        }
        if (ModConfiguration.enableOnion && ModConfiguration.enableOnionPie) {
            onion_pie = new ItemSaltFood("onion_pie", 8, 0.9F).setCreativeTab(tab).setTextureName("saltymod:onion_pie");
            GameRegistry.registerItem(onion_pie, "onion_pie");
        }
        if (ModConfiguration.enableShepherdsPie) {
            shepherds_pie = new ItemSaltFood("shepherds_pie", 10, 0.9F).setCreativeTab(tab).setTextureName("saltymod:shepherds_pie");
            GameRegistry.registerItem(shepherds_pie, "shepherds_pie");
        }
        if (ModConfiguration.enableCodPie) {
            cod_pie = new ItemSaltFood("cod_pie", 7, 0.9F, new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:cod_pie");
            GameRegistry.registerItem(cod_pie, "cod_pie");
        }
        if (ModConfiguration.enableSalmonPie) {
            salmon_pie = new ItemSaltFood("salmon_pie", 7, 0.9F, new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:salmon_pie");
            GameRegistry.registerItem(salmon_pie, "salmon_pie");
        }
        if (ModConfiguration.enableTropicalFishPie) {
            tropical_fish_pie = new ItemSaltFood("tropical_fish_pie", 7, 0.9F, new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:tropical_fish_pie");
            GameRegistry.registerItem(tropical_fish_pie, "tropical_fish_pie");
        }
        if (ModConfiguration.enableTailor && ModConfiguration.enableTailorPie) {
            tailor_pie = new ItemSaltFood("tailor_pie", 7, 0.9F, new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:tailor_pie");
            GameRegistry.registerItem(tailor_pie, "tailor_pie");
        }
        if (ModConfiguration.enableCalamari && ModConfiguration.enableCalamariPie) {
            calamari_pie = new ItemSaltFood("calamari_pie", 7, 0.9F, new ProbablePotionEffect(Potion.waterBreathing.id, 300, 0)).setCreativeTab(tab).setTextureName("saltymod:calamari_pie");
            GameRegistry.registerItem(calamari_pie, "calamari_pie");
        }
        if (ModConfiguration.enableSaltwortPie) {
            saltwort_pie = new ItemSaltFood("saltwort_pie", 7, 0.9F, new ProbablePotionEffect(Potion.regeneration.id, 600, 1)).setCreativeTab(tab).setTextureName("saltymod:saltwort_pie");
            GameRegistry.registerItem(saltwort_pie, "saltwort_pie");
        }
        if (ModConfiguration.enableFermentedFern) {
            fermented_saltwort = new ItemSaltFood("fermented_saltwort", 5, 0.7F, Items.glass_bottle, new ProbablePotionEffect(Potion.regeneration.id, 900, 2)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:fermented_saltwort");
            GameRegistry.registerItem(fermented_saltwort, "fermented_saltwort");
        }
        if (ModConfiguration.enableFermentedFern) {
            fermented_fern = new ItemSaltFood("fermented_fern", 4, 0.7F, Items.glass_bottle, new ProbablePotionEffect(Potion.field_76434_w.id, 1200, 1), new ProbablePotionEffect(Potion.resistance.id, 900, 1)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:fermented_fern");
            GameRegistry.registerItem(fermented_fern, "fermented_fern");
        }
        if (ModConfiguration.enableFermentedMushroom) {
            fermented_mushroom = new ItemSaltFood("fermented_mushroom", 4, 0.7F, Items.glass_bottle, new ProbablePotionEffect(Potion.field_76434_w.id, 1200, 1), new ProbablePotionEffect(Potion.damageBoost.id, 600, 1), new ProbablePotionEffect(Potion.blindness.id, 120, 0)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:fermented_mushroom");
            GameRegistry.registerItem(fermented_mushroom, "fermented_mushroom");
        }
        if(ModConfiguration.enableCalamari && ModConfiguration.enablePickledCalamari) {
            pickled_calamari = new ItemSaltFood("pickled_calamari", 6, 0.7F, Items.glass_bottle, new ProbablePotionEffect(Potion.field_76434_w.id, 1200, 1), new ProbablePotionEffect(Potion.waterBreathing.id, 600, 0)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:pickled_calamari");
            GameRegistry.registerItem(pickled_calamari, "pickled_calamari");
        }
        if(Loader.isModLoaded("etfuturum") && ModConfiguration.enablePickledBeetroot) {
            pickled_beetroot = new ItemSaltFood("pickled_beetroot", 5, 0.8F, Items.glass_bottle, new ProbablePotionEffect(Potion.field_76434_w.id, 1200, 1)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:pickled_beetroot");
            GameRegistry.registerItem(pickled_beetroot, "pickled_beetroot");
        }
        if(ModConfiguration.enableOnion && ModConfiguration.enablePickledOnion) {
            pickled_onion = new ItemSaltFood("pickled_onion", 6, 0.8F, Items.glass_bottle, new ProbablePotionEffect(Potion.field_76434_w.id, 1200, 1)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:pickled_onion");
            GameRegistry.registerItem(pickled_onion, "pickled_onion");
        }
        if(ModConfiguration.enableApplePreserves) {
            apple_preserves = new ItemSaltFood("apple_preserves", 8, 0.8F, Items.glass_bottle, new ProbablePotionEffect(Potion.moveSpeed.id, 300, 1)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:apple_preserves");
            GameRegistry.registerItem(apple_preserves, "apple_preserves");
        }
        if(ModConfiguration.enableMelonPreserves) {
            melon_preserves = new ItemSaltFood("melon_preserves", 6, 0.8F, Items.glass_bottle, new ProbablePotionEffect(Potion.moveSpeed.id, 300, 1), new ProbablePotionEffect(Potion.jump.id, 600, 1)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:melon_preserves");
            GameRegistry.registerItem(melon_preserves, "melon_preserves");
        }
        if(Loader.isModLoaded("etfuturum") && ModConfiguration.enableBerryPreserves) {
            berry_preserves = new ItemSaltFood("berry_preserves", 6, 0.8F, Items.glass_bottle, new ProbablePotionEffect(Potion.moveSpeed.id, 300, 1)).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:berry_preserves");
            GameRegistry.registerItem(berry_preserves, "berry_preserves");
        }
        if(ModConfiguration.enableFizzyDrink) {
            fizzy_drink = new ItemFizzyDrink("fizzy_drink", tab).setTextureName("saltymod:fizzy_drink");
            GameRegistry.registerItem(fizzy_drink, "fizzy_drink");
        }
        if(ModConfiguration.enableTunnelersConcoction) {
            tunneler_concoction = new ItemTunnelerConcoction("tunneler_concoction", tab).setTextureName("saltymod:tunneler_concoction");
            GameRegistry.registerItem(tunneler_concoction, "tunneler_concoction");
        }
        if(ModConfiguration.enableMuffin) {
            muffin = new ItemMuffin("muffin", tab).setTextureName("saltymod:muffin");
            GameRegistry.registerItem(muffin, "muffin");
        }
        if(ModConfiguration.enableToughJelly) {
            tough_jelly = new ItemSaltFood("tough_jelly", 1, 0.3F).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltymod:tough_jelly");
            GameRegistry.registerItem(tough_jelly, "tough_jelly");
        }
        if(ModConfiguration.enableMineralMud && ModConfiguration.enableMudArmor) {
            mud_helmet = new ItemMudArmor("mud_helmet", CommonProxy.mudMaterial, 0);
            GameRegistry.registerItem(mud_helmet, "mud_helmet");
            mud_chestplate = new ItemMudArmor("mud_chestplate", CommonProxy.mudMaterial, 1);
            GameRegistry.registerItem(mud_chestplate, "mud_chestplate");
            mud_leggings = new ItemMudArmor("mud_leggings", CommonProxy.mudMaterial, 2);
            GameRegistry.registerItem(mud_leggings, "mud_leggings");
            mud_boots = new ItemMudArmor("mud_boots", CommonProxy.mudMaterial, 3);
            GameRegistry.registerItem(mud_boots, "mud_boots");
        }
        if(ModConfiguration.enableSaltCrystal) {
            salt_shard = new ItemSaltShard("salt_shard", tab).setTextureName("saltymod:salt_shard");
            GameRegistry.registerItem(salt_shard, "salt_shard");
        }
        if(ModConfiguration.enableRainmaker) {
            rainmaker_star = new Item().setCreativeTab(tab).setUnlocalizedName("rainmaker_star").setTextureName("saltymod:rainmaker_star");
            GameRegistry.registerItem(rainmaker_star, "rainmaker_star");
            rainmaker = new ItemRainmaker("rainmaker", tab).setTextureName("saltymod:rainmaker");
            GameRegistry.registerItem(rainmaker, "rainmaker");
        }

        if(Loader.isModLoaded("TwilightForest") && ModConfiguration.enableTFFoods) {
            tf_salt_cooked_venison = new ItemSaltFood("tf_salt_cooked_venison", 9, 0.9F).setCreativeTab(tab).setTextureName("saltymod:tf/tf_saltwort_cooked_venison");
            GameRegistry.registerItem(tf_salt_cooked_venison, "tf_salt_cooked_venison");
            tf_salt_meef_steak = new ItemSaltFood("tf_salt_meef_steak", 7, 0.7F).setCreativeTab(tab).setTextureName("saltymod:tf/tf_salt_meef_steak");
            GameRegistry.registerItem(tf_salt_meef_steak, "tf_salt_meef_steak");
            tf_salt_meef_stroganoff = new ItemSaltFood("tf_salt_meef_stroganoff", 9, 0.7F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:tf/tf_salt_meef_stroganoff");
            GameRegistry.registerItem(tf_salt_meef_stroganoff, "tf_salt_meef_stroganoff");
            tf_salt_hydra_chop = new ItemSaltFood("tf_salt_hydra_chop", 19, 2.1F).setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setCreativeTab(tab).setTextureName("saltymod:tf/tf_salt_hydra_chop");
            GameRegistry.registerItem(tf_salt_hydra_chop, "tf_salt_hydra_chop");
            tf_pickled_mushgloom = new ItemSaltFood("tf_pickled_mushgloom", 6, 0.8F, Items.glass_bottle, new ProbablePotionEffect(Potion.nightVision.id, 1200, 0), new ProbablePotionEffect(Potion.moveSlowdown.id, 100, 0)).setItemUseAction(EnumAction.drink).setAlwaysEdible().setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:tf/tf_pickled_mushgloom");
            GameRegistry.registerItem(tf_pickled_mushgloom, "tf_pickled_mushgloom");
            tf_saltwort_cooked_venison = new ItemSaltFood("tf_saltwort_cooked_venison", 10, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:tf/tf_saltwort_cooked_venison");
            GameRegistry.registerItem(tf_saltwort_cooked_venison, "tf_saltwort_cooked_venison");
            tf_saltwort_meef_steak = new ItemSaltFood("tf_saltwort_meef_steak", 8, 0.9F, Items.bowl, new ProbablePotionEffect(Potion.regeneration.id, 100, 0)).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:tf/tf_saltwort_meef_steak");
            GameRegistry.registerItem(tf_saltwort_meef_steak, "tf_saltwort_meef_steak");
        }
        if(Loader.isModLoaded("BiomesOPlenty") && ModConfiguration.enableBOPFoods) {
            bop_hemoglobin = new ItemSaltFood("bop_hemoglobin", 2, 4.0F, new ProbablePotionEffect(Potion.heal.id, 1, 1)).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltymod:bop/bop_hemoglobin");
            GameRegistry.registerItem(bop_hemoglobin, "bop_hemoglobin");
            bop_poison = new Item().setCreativeTab(tab).setUnlocalizedName("bop_poison").setTextureName("saltymod:bop/bop_poison");
            GameRegistry.registerItem(bop_poison, "bop_poison");
            bop_salt_shroom_powder = new ItemSaltFood("bop_salt_shroom_powder", 2, 0.2F).setPotionEffect(Potion.confusion.id, 15, 0, 0.3F).setAlwaysEdible().setCreativeTab(tab).setTextureName("saltmod:bop/bop_salt_shroom_powder");
            GameRegistry.registerItem(bop_salt_shroom_powder, "bop_salt_shroom_powder");
            bop_sugar_fruit_salad = new ItemSaltFood("bop_sugar_fruit_salad", 7, 0.7F, Items.bowl).setPotionEffect(Potion.digSpeed.id, 1200, 2, 0.1F).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:bop/bop_sugar_fruit_salad");
            GameRegistry.registerItem(bop_sugar_fruit_salad, "bop_sugar_fruit_salad");
            bop_salt_veggie_salad = new ItemSaltFood("bop_salt_veggie_salad", 7, 0.7F, Items.bowl).setPotionEffect(Potion.field_76434_w.id, 1550, 2, 0.1F).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:bop/bop_salt_veggie_salad");
            GameRegistry.registerItem(bop_salt_veggie_salad, "bop_salt_veggie_salad");
            bop_salt_shroom_salad = new ItemSaltFood("bop_salt_shroom_salad", 7, 0.7F, Items.bowl).setPotionEffect(Potion.jump.id, 900, 2, 0.1F).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:bop/bop_salt_shroom_salad");
            GameRegistry.registerItem(bop_salt_shroom_salad, "bop_salt_shroom_salad");
            bop_salt_rice_bowl = new ItemSaltFood("bop_salt_rice_bowl", 3, 0.2F, Items.bowl).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:bop/bop_salt_rice_bowl");
            GameRegistry.registerItem(bop_salt_rice_bowl, "bop_salt_rice_bowl");
            bop_pickled_turnip = new ItemSaltFood("bop_pickled_turnip", 6, 0.8F, Items.glass_bottle).setItemUseAction(EnumAction.drink).setMaxStackSize(1).setCreativeTab(tab).setTextureName("saltymod:bop/bop_pickled_turnip");
            GameRegistry.registerItem(bop_pickled_turnip, "bop_pickled_turnip");
        }

        SaltyMod.logger.info("Finished initializing SaltyMod Items");
    }
}
