package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.init.ModItems.calamari;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.wheat;

/**
 * Recipe class for Shapeless Recipes.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModShapelessRecipes {

    /**
     * Initializes all shapeless recipes.
     */
    public static void init() {

        Item StriderFlankCooked = netherliciousItems.get("StriderFlankCooked");

        Item mutton_cooked = etFuturumItems.get("mutton_cooked");
        Item rabbit_cooked = etFuturumItems.get("rabbit_cooked");
        Item beetroot = etFuturumItems.get("beetroot");
        Item beetroot_seeds = etFuturumItems.get("beetroot_seeds");
        Item sweet_berries = etFuturumItems.get("sweet_berries");
        Item dye = etFuturumItems.get("dye");

        Item venisonCooked = twilightForestItems.get("venisonCooked");
        Item meefSteak = twilightForestItems.get("meefSteak");
        Item meefStroganoff = twilightForestItems.get("meefStroganoff");
        Item hydraChop = twilightForestItems.get("hydraChop");
        Block mushgloom = twilightForestBlocks.get("mushgloom");

        Item food = biomesOPlentyItems.get("food");

        Item cooked_bison_meat = wildMobsItems.get("cooked_bison_meat");
        Item cooked_calamari = wildMobsItems.get("cooked_calamari");
        Item cooked_chevon = wildMobsItems.get("cooked_chevon");
        Item cooked_goose = wildMobsItems.get("cooked_goose");
        Item cooked_mouse = wildMobsItems.get("cooked_mouse");
        Item cooked_venison = wildMobsItems.get("cooked_venison");


        addShapelessRecipe(new ItemStack(wheat_seeds, 9),
            new ItemStack(storage_sack));
        addShapelessRecipe(new ItemStack(milk_bucket),
            new ItemStack(powdered_milk),
            new ItemStack(water_bucket),
            new ItemStack(bucket));

        addShapelessRecipe(new ItemStack(fish, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_barrel));
        addShapelessRecipe(new ItemStack(fish, 9, 1),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_barrel, 1, 1));
        addShapelessRecipe(new ItemStack(fish, 9, 2),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_barrel, 1, 2));
        addShapelessRecipe(new ItemStack(fish, 9, 3),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_barrel, 1, 4));

        addShapelessRecipe(new ItemStack(Items.dye, 1, 2),
            new ItemStack(saltwort));
        addShapelessRecipe(new ItemStack(Items.dye, 1, 5),
            new boolean[]{enableSaltFlowers},
            new ItemStack(salt_flower_d, 1, 2));
        addShapelessRecipe(new ItemStack(Items.dye, 1, 10),
            new boolean[]{enableSaltFlowers},
            new ItemStack(salt_flower_s, 1, 0));

        addShapelessRecipe(new ItemStack(melon_seeds, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_sack, 1, 1));
        addShapelessRecipe(new ItemStack(pumpkin_seeds, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_sack, 1, 2));
        addShapelessRecipe(new ItemStack(carrot, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_crate));
        addShapelessRecipe(new ItemStack(potato, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_crate, 1, 1));
        addShapelessRecipe(new ItemStack(poisonous_potato, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_crate, 1, 2));

        addShapelessRecipe(new ItemStack(beetroot, 9),
            new boolean[]{beetroot != null, enableStorageBlocks},
            new ItemStack(storage_crate, 1, 4));

        addShapelessRecipe(new ItemStack(beetroot_seeds, 9),
            new boolean[]{beetroot_seeds != null, enableStorageBlocks},
            new ItemStack(storage_sack, 1, 4));

        addShapelessRecipe(new ItemStack(dye, 1, 0),
            new boolean[]{dye != null, enableSaltFlowers},
            new ItemStack(salt_flower_d, 1, 0));
        addShapelessRecipe(new ItemStack(Items.dye, 1, 15),
            new boolean[]{dye == null, enableSaltFlowers},
            new ItemStack(salt_flower_d, 1, 0));

        addShapelessRecipe(new ItemStack(salt_grass),
            new boolean[]{enableSaltDirt},
            new ItemStack(grass),
            new ItemStack(salt_pinch));
        addShapelessRecipe(new ItemStack(salt_dirt_lite),
            new boolean[]{enableSaltDirt},
            new ItemStack(dirt),
            new ItemStack(salt_pinch));
        addShapelessRecipe(new ItemStack(salt_dirt),
            new boolean[]{enableSaltDirt},
            new ItemStack(dirt),
            new ItemStack(salt_pinch),
            new ItemStack(salt_pinch),
            new ItemStack(salt_pinch),
            new ItemStack(salt_pinch));
        addShapelessRecipe(new ItemStack(salt_dirt),
            new boolean[]{enableSaltDirt},
            new ItemStack(salt_dirt_lite),
            new ItemStack(salt_pinch),
            new ItemStack(salt_pinch),
            new ItemStack(salt_pinch));

        addShapelessOreRecipe(new ItemStack(fish_bait, 4),
                new boolean[]{enableFishFarm},
                "itemFish",
                new ItemStack(saltwort),
                new ItemStack(wheat),
                new ItemStack(wheat));

        addShapelessRecipe(new ItemStack(honey_bee, 1, 0),
            new boolean[]{enableHoney},
            new ItemStack(bee_larva),
            new ItemStack(honey_bee, 1, 18));
        addShapelessRecipe(new ItemStack(carpenter_bee, 1, 0),
            new boolean[]{enableHoney},
            new ItemStack(bee_larva),
            new ItemStack(carpenter_bee, 1, 18));
        addShapelessRecipe(new ItemStack(regal_bee, 1, 0),
            new boolean[]{enableHoney},
            new ItemStack(bee_larva),
            new ItemStack(regal_bee, 1, 18));
        addShapelessRecipe(new ItemStack(boreal_bee, 1, 0),
            new boolean[]{enableHoney},
            new ItemStack(bee_larva),
            new ItemStack(boreal_bee, 1, 18));
        addShapelessRecipe(new ItemStack(royal_jelly),
            new boolean[]{enableHoney},
            new ItemStack(honey_bee, 1, 18));
        addShapelessRecipe(new ItemStack(royal_jelly),
            new boolean[]{enableHoney},
            new ItemStack(carpenter_bee, 1, 18));
        addShapelessRecipe(new ItemStack(royal_jelly),
            new boolean[]{enableHoney},
            new ItemStack(regal_bee, 1, 18));

        addShapelessRecipe(new ItemStack(string),
            new boolean[]{ModConfigurationWorldGeneration.enableSaltMarsh},
            new ItemStack(marsh_reeds_b),
            new ItemStack(marsh_reeds_b));

        addShapelessOreRecipe(new ItemStack(mineral_mud_ball),
                new boolean[]{enableMineralMud},
                new ItemStack(baking_soda),
                new ItemStack(salt),
                "itemCoal",
                new ItemStack(clay_ball));
        addShapelessRecipe(new ItemStack(mineral_mud_ball, 4),
            new boolean[]{enableMineralMud},
            new ItemStack(mineral_mud));

        addShapelessRecipe(new ItemStack(salt, 9),
            new boolean[]{enableSaltBlocks},
            new ItemStack(salt_block, 1, OreDictionary.WILDCARD_VALUE));
        addShapelessRecipe(new ItemStack(salt_pinch, 9),
            new ItemStack(salt));
        addShapelessRecipe(new ItemStack(salt_pinch, 40),
            new boolean[]{enableSaltBlocks},
            new ItemStack(salt_slab, 1, OreDictionary.WILDCARD_VALUE));
        addShapelessRecipe(new ItemStack(sugar_pinch, 9),
            new ItemStack(sugar));

        addShapelessRecipe(new ItemStack(onion, 9),
            new boolean[]{enableStorageBlocks, enableOnion},
            new ItemStack(storage_crate, 1, 3));
        addShapelessRecipe(new ItemStack(saltwort, 9),
            new boolean[]{enableStorageBlocks},
            new ItemStack(storage_sack, 1, 3));

        addShapelessRecipe(new ItemStack(salt_cooked_porkchop),
            new ItemStack(salt_pinch),
            new ItemStack(cooked_porkchop));
        addShapelessRecipe(new ItemStack(salt_cooked_beef),
            new ItemStack(salt_pinch),
            new ItemStack(cooked_beef));
        addShapelessRecipe(new ItemStack(salt_cooked_chicken),
            new ItemStack(salt_pinch),
            new ItemStack(cooked_chicken));
        addShapelessRecipe(new ItemStack(salt_cooked_rabbit),
            new boolean[]{rabbit_cooked != null},
            new ItemStack(salt_pinch),
            new ItemStack(rabbit_cooked));
        addShapelessRecipe(new ItemStack(salt_cooked_mutton),
            new boolean[]{mutton_cooked != null},
            new ItemStack(salt_pinch),
            new ItemStack(mutton_cooked));
        addShapelessRecipe(new ItemStack(strider, 1, 2),
            new boolean[]{StriderFlankCooked != null},
            new ItemStack(salt_pinch),
            new ItemStack(StriderFlankCooked));
        addShapelessRecipe(new ItemStack(strider, 1, 2),
            new boolean[]{Loader.isModLoaded("etfuturum"), !Loader.isModLoaded("netherlicious")},
            new ItemStack(salt_pinch),
            new ItemStack(strider, 1, 1));
        addShapelessRecipe(new ItemStack(haunch, 1, 2),
            new ItemStack(salt_pinch),
            new ItemStack(haunch, 1, 1));
        addShapelessRecipe(new ItemStack(salt_cooked_cod),
            new ItemStack(salt_pinch),
            new ItemStack(cooked_fished));
        addShapelessRecipe(new ItemStack(salt_cooked_salmon),
            new ItemStack(salt_pinch),
            new ItemStack(cooked_fished, 1, 1));
        addShapelessRecipe(new ItemStack(cooked_tropical_fish, 1, 1),
            new ItemStack(salt_pinch),
            new ItemStack(cooked_tropical_fish));

        addShapelessRecipe(new ItemStack(tailor, 9),
            new boolean[]{enableStorageBlocks, enableTailor},
            new ItemStack(storage_barrel, 1, 3));

        addShapelessRecipe(new ItemStack(tailor, 1, 2),
            new ItemStack(salt_pinch),
            new ItemStack(tailor, 1, 1));
        addShapelessRecipe(new ItemStack(calamari, 1, 2),
            new ItemStack(salt_pinch),
            new ItemStack(calamari, 1, 1));
        addShapelessRecipe(new ItemStack(salt_bread),
            new ItemStack(salt_pinch),
            new ItemStack(bread));
        addShapelessRecipe(new ItemStack(salt_baked_potato),
            new ItemStack(salt_pinch),
            new ItemStack(baked_potato));
        addShapelessRecipe(new ItemStack(salt_beetroot),
            new boolean[]{beetroot != null},
            new ItemStack(salt_pinch),
            new ItemStack(beetroot));
        addShapelessRecipe(new ItemStack(sugar_apple),
            new ItemStack(sugar_pinch),
            new ItemStack(apple));
        addShapelessRecipe(new ItemStack(sugar_melon),
            new ItemStack(sugar_pinch),
            new ItemStack(melon));
        addShapelessRecipe(new ItemStack(sugar_berries),
            new boolean[]{sweet_berries != null},
            new ItemStack(sugar_pinch),
            new ItemStack(sweet_berries));

        addShapelessOreRecipe(new ItemStack(honey_apple),
            new boolean[]{enableHoney},
            "itemHoney",
            new ItemStack(apple));
        addShapelessOreRecipe(new ItemStack(honey_porkchop),
            new boolean[]{enableHoney},
            "itemHoney",
            new ItemStack(cooked_porkchop));
        addShapelessOreRecipe(new ItemStack(honey_berries),
            new boolean[]{sweet_berries != null, enableHoney},
            "itemHoney",
            new ItemStack(sweet_berries));
        addShapelessRecipe(new ItemStack(chocolate_berries),
            new boolean[]{sweet_berries != null},
            new ItemStack(Items.dye, 1, 3),
            new ItemStack(sweet_berries));

        addShapelessRecipe(new ItemStack(fermented_saltwort),
            new ItemStack(ghast_tear),
            new ItemStack(glass_bottle),
            new ItemStack(saltwort),
            new ItemStack(saltwort),
            new ItemStack(saltwort),
            new ItemStack(saltwort),
            new ItemStack(saltwort));
        addShapelessRecipe(new ItemStack(fermented_fern),
            new ItemStack(ghast_tear),
            new ItemStack(glass_bottle),
            new ItemStack(tallgrass, 1, 2),
            new ItemStack(tallgrass, 1, 2),
            new ItemStack(tallgrass, 1, 2),
            new ItemStack(tallgrass, 1, 2),
            new ItemStack(tallgrass, 1, 2));
        addShapelessRecipe(new ItemStack(fermented_marsh_reeds),
            new ItemStack(ghast_tear),
            new ItemStack(glass_bottle),
            new ItemStack(marsh_reeds_b),
            new ItemStack(marsh_reeds_b),
            new ItemStack(marsh_reeds_b),
            new ItemStack(marsh_reeds_b),
            new ItemStack(marsh_reeds_b));
        addShapelessOreRecipe(new ItemStack(fermented_mushroom),
            new ItemStack(ghast_tear),
            new ItemStack(glass_bottle),
            "blockMushroom",
            "blockMushroom",
            "blockMushroom",
            "blockMushroom",
            "blockMushroom");
        addShapelessRecipe(new ItemStack(pickled_calamari),
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(calamari),
            new ItemStack(calamari));
        addShapelessRecipe(new ItemStack(pickled_beetroot),
            new boolean[]{beetroot != null},
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(beetroot),
            new ItemStack(beetroot));
        addShapelessRecipe(new ItemStack(pickled_onion),
            new boolean[]{enableOnion},
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(onion),
            new ItemStack(onion));
        addShapelessRecipe(new ItemStack(apple_preserves),
            new ItemStack(sugar_pinch),
            new ItemStack(potionitem),
            new ItemStack(apple),
            new ItemStack(apple));
        addShapelessRecipe(new ItemStack(melon_preserves),
            new ItemStack(sugar_pinch),
            new ItemStack(potionitem),
            new ItemStack(melon),
            new ItemStack(melon));
        addShapelessRecipe(new ItemStack(berry_preserves),
            new boolean[]{sweet_berries != null},
            new ItemStack(sugar_pinch),
            new ItemStack(potionitem),
            new ItemStack(sweet_berries),
            new ItemStack(sweet_berries));

        addShapelessRecipe(new ItemStack(fizzy_drink),
            new boolean[]{enableFizzyDrink},
            new ItemStack(baking_soda),
            new ItemStack(potionitem));

        addShapelessRecipe(new ItemStack(rainmaker_star),
            new boolean[]{enableRainmaker},
            new ItemStack(gunpowder),
            new ItemStack(salt),
            new ItemStack(salt),
            new ItemStack(salt),
            new ItemStack(salt),
            new ItemStack(baking_soda),
            new ItemStack(baking_soda),
            new ItemStack(baking_soda),
            new ItemStack(baking_soda));
        addShapelessRecipe(new ItemStack(rainmaker),
            new boolean[]{enableRainmaker},
            new ItemStack(rainmaker_star),
            new ItemStack(rainmaker_star),
            new ItemStack(rainmaker_star),
            new ItemStack(rainmaker_star),
            new ItemStack(rainmaker_star),
            new ItemStack(paper),
            new ItemStack(gunpowder),
            new ItemStack(gunpowder),
            new ItemStack(gunpowder));


        addShapelessRecipe(new ItemStack(tf_salt_cooked_venison),
            new boolean[]{enableTFFoods, venisonCooked != null},
            new ItemStack(salt_pinch),
            new ItemStack(venisonCooked));
        addShapelessRecipe(new ItemStack(tf_salt_meef_steak),
            new boolean[]{enableTFFoods, meefSteak != null},
            new ItemStack(salt_pinch),
            new ItemStack(meefSteak));
        addShapelessRecipe(new ItemStack(tf_salt_meef_stroganoff),
            new boolean[]{meefStroganoff != null},
            new ItemStack(salt_pinch),
            new ItemStack(meefStroganoff));
        addShapelessRecipe(new ItemStack(tf_salt_hydra_chop),
            new boolean[]{enableTFFoods, hydraChop != null},
            new ItemStack(salt_pinch),
            new ItemStack(hydraChop));
        addShapelessRecipe(new ItemStack(tf_saltwort_cooked_venison),
            new boolean[]{enableTFFoods},
            new ItemStack(bowl),
            new ItemStack(tf_salt_cooked_venison),
            new ItemStack(saltwort),
            new ItemStack(saltwort));
        addShapelessRecipe(new ItemStack(tf_saltwort_meef_steak),
            new boolean[]{enableTFFoods},
            new ItemStack(bowl),
            new ItemStack(tf_salt_meef_steak),
            new ItemStack(saltwort),
            new ItemStack(saltwort));
        addShapelessRecipe(new ItemStack(tf_pickled_mushgloom),
            new boolean[]{enableTFFoods, mushgloom != null},
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(mushgloom, 1, 9),
            new ItemStack(mushgloom, 1, 9));

        addShapelessRecipe(new ItemStack(bop_salt_shroom_powder),
            new boolean[]{food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 1));
        addShapelessRecipe(new ItemStack(bop_sugar_fruit_salad),
            new boolean[]{food != null},
            new ItemStack(sugar_pinch),
            new ItemStack(food, 1, 4));
        addShapelessRecipe(new ItemStack(bop_salt_veggie_salad),
            new boolean[]{food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 5));
        addShapelessRecipe(new ItemStack(bop_salt_shroom_salad),
            new boolean[]{food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 6));
        addShapelessRecipe(new ItemStack(bop_salt_rice_bowl),
            new boolean[]{food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 13));
        addShapelessRecipe(new ItemStack(bop_pickled_turnip),
            new boolean[]{food != null},
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(food, 1, 11),
            new ItemStack(food, 1, 11));

        addShapelessRecipe(new ItemStack(wm_salt_cooked_bison),
            new boolean[]{cooked_bison_meat != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_bison_meat));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_calamari),
            new boolean[]{cooked_calamari != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_calamari));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_chevon),
            new boolean[]{cooked_chevon != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_chevon));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_goose),
            new boolean[]{cooked_goose != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_goose));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_mouse),
            new boolean[]{cooked_mouse != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_mouse));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_venison),
            new boolean[]{cooked_venison != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_venison));
    }
}
