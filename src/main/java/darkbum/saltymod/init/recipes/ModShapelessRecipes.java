package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.enableRecipeChanges;
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

        Block nether_fungus = etFuturumBlocks.get("nether_fungus");

        Item mutton_cooked = etFuturumItems.get("mutton_cooked");
        Item rabbit_raw = etFuturumItems.get("rabbit_raw");
        Item rabbit_cooked = etFuturumItems.get("rabbit_cooked");
        Item rabbit_stew = etFuturumItems.get("rabbit_stew");
        Item beetroot = etFuturumItems.get("beetroot");
        Item beetroot_seeds = etFuturumItems.get("beetroot_seeds");
        Item beetroot_soup = etFuturumItems.get("beetroot_soup");
        Item chorus_fruit = etFuturumItems.get("chorus_fruit");
        Item sweet_berries = etFuturumItems.get("sweet_berries");
        Item efrdye = etFuturumItems.get("efrdye");

        Block mushgloom = twilightForestBlocks.get("mushgloom");
        Item venisonCooked = twilightForestItems.get("venisonCooked");
        Item meefSteak = twilightForestItems.get("meefSteak");
        Item meefStroganoff = twilightForestItems.get("meefStroganoff");
        Item hydraChop = twilightForestItems.get("hydraChop");

        Item food = biomesOPlentyItems.get("food");
        Item dart = biomesOPlentyItems.get("dart");

        Item cooked_bison_meat = wildMobsItems.get("cooked_bison_meat");
        Item cooked_calamari = wildMobsItems.get("cooked_calamari");
        Item cooked_chevon = wildMobsItems.get("cooked_chevon");
        Item cooked_goose = wildMobsItems.get("cooked_goose");
        Item cooked_mouse = wildMobsItems.get("cooked_mouse");
        Item cooked_venison = wildMobsItems.get("cooked_venison");


        addShapelessRecipe(new ItemStack(wheat_seeds, 9),
            new ItemStack(storage_sack));

        addShapelessRecipe(new ItemStack(slime_ball),
            new boolean[]{enableDough},
            new ItemStack(Items.dye, 1, 10),
            new ItemStack(dough));

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

        addShapelessRecipe(new ItemStack(efrdye, 1, 0),
            new boolean[]{efrdye != null, enableSaltFlowers},
            new ItemStack(salt_flower_d, 1, 0));
        addShapelessRecipe(new ItemStack(Items.dye, 1, 15),
            new boolean[]{efrdye == null, enableSaltFlowers},
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

        if(!enableMachines) {
            addShapelessOreRecipe(new ItemStack(mushroom_stew),
                new boolean[]{enableRecipeChanges},
                new ItemStack(bowl),
                "blockMushroom",
                "blockMushroom");

            addShapelessRecipe(new ItemStack(cookie, 4),
                new boolean[]{enableRecipeChanges, enableDough},
                new ItemStack(dough),
                new ItemStack(dye, 1, 3));
            addShapelessRecipe(new ItemStack(cookie, 4),
                new boolean[]{enableRecipeChanges, !enableDough},
                new ItemStack(wheat),
                new ItemStack(dye, 1, 3));

            addShapelessRecipe(new ItemStack(pumpkin_pie),
                new boolean[]{enableRecipeChanges, enableDough},
                new ItemStack(sugar),
                new ItemStack(pumpkin),
                new ItemStack(dough),
                new ItemStack(egg));

            addShapelessOreRecipe(new ItemStack(rabbit_stew),
                new boolean[]{rabbit_stew != null, rabbit_raw != null},
                new ItemStack(bowl),
                new ItemStack(rabbit_raw),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");

            addShapelessRecipe(new ItemStack(beetroot_soup),
                new boolean[]{enableRecipeChanges, beetroot != null, beetroot_soup != null},
                new ItemStack(bowl),
                new ItemStack(beetroot),
                new ItemStack(beetroot),
                new ItemStack(beetroot));

            addShapelessRecipe(new ItemStack(dough),
                new boolean[]{enableDough},
                new ItemStack(wheat),
                new ItemStack(potionitem));

            addShapelessRecipe(new ItemStack(egg_bowl),
                new boolean[]{enableEgg},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(egg),
                new ItemStack(egg),
                new ItemStack(egg),
                new ItemStack(egg));

            addShapelessOreRecipe(new ItemStack(salt_mushroom_stew),
                new boolean[]{enableSaltedMushroomStew},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                "blockMushroom",
                "blockMushroom");

            addShapelessOreRecipe(new ItemStack(salt_rabbit_stew),
                new boolean[]{rabbit_raw != null, enableSaltedRabbitRagout},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(rabbit_raw),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");

            addShapelessRecipe(new ItemStack(salt_beetroot_soup),
                new boolean[]{beetroot != null, enableSaltedBorscht},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(beetroot),
                new ItemStack(beetroot),
                new ItemStack(beetroot));

            addShapelessOreRecipe(new ItemStack(fungus_stew),
                new boolean[]{nether_fungus != null, enableFungusStew},
                new ItemStack(bowl),
                "blockFungus",
                "blockFungus");
            addShapelessOreRecipe(new ItemStack(fungus_stew, 1, 1),
                new boolean[]{nether_fungus != null, enableFungusStew},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                "blockFungus",
                "blockFungus");

            addShapelessOreRecipe(new ItemStack(chicken_soup),
                new boolean[]{enableChickenSoup},
                new ItemStack(bowl),
                new ItemStack(chicken),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");
            addShapelessOreRecipe(new ItemStack(chicken_soup, 1, 1),
                new boolean[]{enableChickenSoup},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(chicken),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");

            addShapelessOreRecipe(new ItemStack(beef_stew),
                new boolean[]{enableBeefStew},
                new ItemStack(bowl),
                new ItemStack(beef),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");
            addShapelessOreRecipe(new ItemStack(beef_stew, 1, 1),
                new boolean[]{enableBeefStew},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(beef),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");

            addShapelessRecipe(new ItemStack(pumpkin_porridge),
                new boolean[]{enablePumpkinPorridge},
                new ItemStack(bowl),
                new ItemStack(pumpkin));
            addShapelessRecipe(new ItemStack(pumpkin_porridge, 1, 1),
                new boolean[]{enablePumpkinPorridge},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(pumpkin));

            addShapelessRecipe(new ItemStack(cactus_soup),
                new boolean[]{enableCactusSoup},
                new ItemStack(bowl),
                new ItemStack(cactus),
                new ItemStack(cactus),
                new ItemStack(cactus));
            addShapelessRecipe(new ItemStack(cactus_soup, 1, 1),
                new boolean[]{enableCactusSoup},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(cactus),
                new ItemStack(cactus),
                new ItemStack(cactus));

            addShapelessOreRecipe(new ItemStack(bone_marrow_soup),
                new boolean[]{enableBoneMarrowSoup},
                new ItemStack(bowl),
                new ItemStack(bone),
                "blockMushroom");
            addShapelessOreRecipe(new ItemStack(bone_marrow_soup, 1, 1),
                new boolean[]{enableBoneMarrowSoup},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(bone),
                "blockMushroom");

            addShapelessOreRecipe(new ItemStack(stewed_vegetables),
                new boolean[]{enableStewedVegetables},
                new ItemStack(bowl),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");
            addShapelessOreRecipe(new ItemStack(stewed_vegetables, 1, 1),
                new boolean[]{enableStewedVegetables},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(carrot),
                new ItemStack(potato),
                "blockMushroom");

            addShapelessOreRecipe(new ItemStack(potato_mushroom),
                new boolean[]{enablePotatoMushroom},
                new ItemStack(bowl),
                new ItemStack(potato),
                new ItemStack(potato),
                "blockMushroom");
            addShapelessOreRecipe(new ItemStack(potato_mushroom, 1, 1),
                new boolean[]{enablePotatoMushroom},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(potato),
                new ItemStack(potato),
                "blockMushroom");

            addShapelessRecipe(new ItemStack(golden_vegetables),
                new boolean[]{enableGoldenFoods},
                new ItemStack(bowl),
                new ItemStack(golden_carrot),
                new ItemStack(golden_potato),
                new ItemStack(golden_saltwort));
            addShapelessRecipe(new ItemStack(golden_vegetables, 1, 1),
                new boolean[]{enableGoldenFoods},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(golden_carrot),
                new ItemStack(golden_potato),
                new ItemStack(golden_saltwort));

            addShapelessOreRecipe(new ItemStack(fish_soup),
                new boolean[]{enableFishSoup},
                new ItemStack(bowl),
                "itemFish",
                new ItemStack(carrot),
                new ItemStack(potato));
            addShapelessOreRecipe(new ItemStack(fish_soup, 1, 1),
                new boolean[]{enableFishSoup},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                "itemFish",
                new ItemStack(carrot),
                new ItemStack(potato));

            addShapelessRecipe(new ItemStack(dandelion_salad),
                new boolean[]{enableOnion, enableDandelionSalad},
                new ItemStack(bowl),
                new ItemStack(tallgrass, 1,2),
                new ItemStack(yellow_flower),
                new ItemStack(onion));
            addShapelessRecipe(new ItemStack(dandelion_salad, 1, 1),
                new boolean[]{enableOnion, enableDandelionSalad},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(tallgrass, 1,2),
                new ItemStack(yellow_flower),
                new ItemStack(onion));

            addShapelessRecipe(new ItemStack(wheat_sprouts),
                new boolean[]{enableWheatSprouts},
                new ItemStack(bowl),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds));
            addShapelessRecipe(new ItemStack(wheat_sprouts, 1, 1),
                new boolean[]{enableWheatSprouts},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds),
                new ItemStack(wheat_seeds));

            addShapelessRecipe(new ItemStack(beetroot_salad),
                new boolean[]{beetroot != null, enableBeetrootSalad},
                new ItemStack(bowl),
                new ItemStack(beetroot),
                new ItemStack(carrot),
                new ItemStack(potato));
            addShapelessRecipe(new ItemStack(beetroot_salad, 1, 1),
                new boolean[]{beetroot != null, enableBeetrootSalad},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(beetroot),
                new ItemStack(carrot),
                new ItemStack(potato));

            addShapelessRecipe(new ItemStack(dressed_herring),
                new boolean[]{beetroot != null, enableOnion, enableDressedHerring},
                new ItemStack(bowl),
                new ItemStack(fish),
                new ItemStack(onion),
                new ItemStack(carrot),
                new ItemStack(potato),
                new ItemStack(beetroot),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(dressed_herring, 1, 1),
                new boolean[]{beetroot != null, enableOnion, enableDressedHerring},
                new ItemStack(salt_pinch),
                new ItemStack(bowl),
                new ItemStack(fish),
                new ItemStack(onion),
                new ItemStack(carrot),
                new ItemStack(potato),
                new ItemStack(beetroot),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(saltwort_salad),
                new boolean[]{enableSaltwortSalad},
                new ItemStack(bowl),
                new ItemStack(saltwort),
                new ItemStack(saltwort),
                new ItemStack(saltwort),
                new ItemStack(saltwort),
                new ItemStack(saltwort),
                new ItemStack(saltwort));
            addShapelessRecipe(new ItemStack(golden_saltwort_salad),
                new boolean[]{enableSaltwortSalad},
                new ItemStack(bowl),
                new ItemStack(golden_saltwort),
                new ItemStack(golden_saltwort),
                new ItemStack(golden_saltwort),
                new ItemStack(golden_saltwort),
                new ItemStack(golden_saltwort),
                new ItemStack(golden_saltwort));

            addShapelessRecipe(new ItemStack(saltwort_cooked_porkchop),
                new boolean[]{enableSaltwortPorkchop},
                new ItemStack(bowl),
                new ItemStack(salt_cooked_porkchop),
                new ItemStack(saltwort),
                new ItemStack(saltwort));
            addShapelessRecipe(new ItemStack(saltwort_honey_porkchop),
                new boolean[]{enableHoney, enableHoneyPorkchop, enableSaltwortHoneyPorkchop},
                new ItemStack(bowl),
                new ItemStack(honey_porkchop),
                new ItemStack(saltwort),
                new ItemStack(saltwort));
            addShapelessRecipe(new ItemStack(saltwort_cooked_beef),
                new boolean[]{enableSaltwortBeef},
                new ItemStack(bowl),
                new ItemStack(salt_cooked_beef),
                new ItemStack(saltwort),
                new ItemStack(saltwort));
            addShapelessRecipe(new ItemStack(saltwort_cooked_mutton),
                new boolean[]{enableSaltwortMutton},
                new ItemStack(bowl),
                new ItemStack(salt_cooked_mutton),
                new ItemStack(saltwort),
                new ItemStack(saltwort));
            addShapelessRecipe(new ItemStack(saltwort_cooked_strider),
                new boolean[]{enableStrider, enableSaltwortStrider},
                new ItemStack(bowl),
                new ItemStack(strider, 1, 2),
                new ItemStack(saltwort),
                new ItemStack(saltwort));
            addShapelessRecipe(new ItemStack(saltwort_cooked_haunch),
                new boolean[]{enableSaltwortHaunch},
                new ItemStack(bowl),
                new ItemStack(haunch, 1, 2),
                new ItemStack(saltwort),
                new ItemStack(saltwort));

            addShapelessRecipe(new ItemStack(fruit_salad),
                new boolean[]{sweet_berries != null, enableFruitSalad},
                new ItemStack(bowl),
                new ItemStack(apple),
                new ItemStack(melon),
                new ItemStack(sweet_berries));
            addShapelessRecipe(new ItemStack(fruit_salad),
                new boolean[]{sweet_berries == null, enableFruitSalad},
                new ItemStack(bowl),
                new ItemStack(apple),
                new ItemStack(melon),
                new ItemStack(carrot));
            addShapelessRecipe(new ItemStack(fruit_salad, 1, 1),
                new boolean[]{sweet_berries != null, enableFruitSalad},
                new ItemStack(sugar_pinch),
                new ItemStack(bowl),
                new ItemStack(apple),
                new ItemStack(melon),
                new ItemStack(sweet_berries));
            addShapelessRecipe(new ItemStack(fruit_salad, 1, 1),
                new boolean[]{sweet_berries == null, enableFruitSalad},
                new ItemStack(sugar_pinch),
                new ItemStack(bowl),
                new ItemStack(apple),
                new ItemStack(melon),
                new ItemStack(carrot));

            addShapelessRecipe(new ItemStack(golden_fruit_salad),
                new boolean[]{sweet_berries != null, enableGoldenFoods},
                new ItemStack(bowl),
                new ItemStack(golden_apple, 1, 0),
                new ItemStack(golden_berries, 1, 0),
                new ItemStack(speckled_melon));
            addShapelessRecipe(new ItemStack(golden_fruit_salad),
                new boolean[]{sweet_berries == null, enableGoldenFoods},
                new ItemStack(bowl),
                new ItemStack(golden_apple, 1, 0),
                new ItemStack(golden_carrot),
                new ItemStack(speckled_melon));
            addShapelessRecipe(new ItemStack(golden_fruit_salad, 1, 1),
                new boolean[]{sweet_berries != null, enableGoldenFoods},
                new ItemStack(sugar_pinch),
                new ItemStack(bowl),
                new ItemStack(golden_apple, 1, 0),
                new ItemStack(golden_berries, 1, 0),
                new ItemStack(speckled_melon));
            addShapelessRecipe(new ItemStack(golden_fruit_salad, 1, 1),
                new boolean[]{sweet_berries == null, enableGoldenFoods},
                new ItemStack(sugar_pinch),
                new ItemStack(bowl),
                new ItemStack(golden_apple, 1, 0),
                new ItemStack(golden_carrot),
                new ItemStack(speckled_melon));

            addShapelessRecipe(new ItemStack(grated_carrot),
                new boolean[]{enableGratedCarrot},
                new ItemStack(bowl),
                new ItemStack(carrot),
                new ItemStack(carrot),
                new ItemStack(carrot));
            addShapelessRecipe(new ItemStack(grated_carrot, 1, 1),
                new boolean[]{enableGratedCarrot},
                new ItemStack(sugar_pinch),
                new ItemStack(bowl),
                new ItemStack(carrot),
                new ItemStack(carrot),
                new ItemStack(carrot));

            addShapelessRecipe(new ItemStack(melon_soup),
                new boolean[]{enableMelonSoup},
                new ItemStack(bowl),
                new ItemStack(melon),
                new ItemStack(melon),
                new ItemStack(melon));
            addShapelessRecipe(new ItemStack(melon_soup, 1, 1),
                new boolean[]{enableMelonSoup},
                new ItemStack(sugar_pinch),
                new ItemStack(bowl),
                new ItemStack(melon),
                new ItemStack(melon),
                new ItemStack(melon));

            addShapelessRecipe(new ItemStack(sweetberry_cookie, 4),
                new boolean[]{sweet_berries != null, enableDough, enableBerryCookie},
                new ItemStack(dough),
                new ItemStack(sweet_berries));
            addShapelessRecipe(new ItemStack(sweetberry_cookie, 4),
                new boolean[]{sweet_berries != null, !enableDough, enableBerryCookie},
                new ItemStack(wheat),
                new ItemStack(sweet_berries));
            addShapelessRecipe(new ItemStack(chorus_cookie, 4),
                new boolean[]{chorus_fruit != null, enableDough, enableChorusCookie},
                new ItemStack(dough),
                new ItemStack(chorus_fruit));
            addShapelessRecipe(new ItemStack(chorus_cookie, 4),
                new boolean[]{chorus_fruit != null, !enableDough, enableChorusCookie},
                new ItemStack(wheat),
                new ItemStack(chorus_fruit));

            addShapelessRecipe(new ItemStack(chocolate_pie),
                new boolean[]{enableDough, enableChocolatePie},
                new ItemStack(dye, 1, 3),
                new ItemStack(dye, 1, 3),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(chocolate_pie),
                new boolean[]{!enableDough, enableChocolatePie},
                new ItemStack(dye, 1, 3),
                new ItemStack(dye, 1, 3),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessOreRecipe(new ItemStack(birthday_pie),
                new boolean[]{enableEvaporator, enableDough, enableBirthdayPie},
                new ItemStack(sugar),
                "itemMilk",
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessOreRecipe(new ItemStack(birthday_pie),
                new boolean[]{enableEvaporator, !enableDough, enableBirthdayPie},
                new ItemStack(sugar),
                "itemMilk",
                new ItemStack(wheat),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(birthday_pie),
                new boolean[]{!enableEvaporator, enableDough, enableBirthdayPie},
                new ItemStack(sugar),
                new ItemStack(milk_bucket),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(birthday_pie),
                new boolean[]{!enableEvaporator, !enableDough, enableBirthdayPie},
                new ItemStack(sugar),
                new ItemStack(milk_bucket),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(apple_pie),
                new boolean[]{enableDough, enableApplePie},
                new ItemStack(sugar),
                new ItemStack(apple),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(apple_pie),
                new boolean[]{!enableDough, enableApplePie},
                new ItemStack(sugar),
                new ItemStack(apple),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(carrot_pie),
                new boolean[]{enableDough, enableCarrotPie},
                new ItemStack(sugar),
                new ItemStack(carrot),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(carrot_pie),
                new boolean[]{!enableDough, enableCarrotPie},
                new ItemStack(sugar),
                new ItemStack(carrot),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessOreRecipe(new ItemStack(mushroom_pie),
                new boolean[]{enableDough, enableMushroomPie},
                new ItemStack(salt),
                "blockMushroom",
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessOreRecipe(new ItemStack(mushroom_pie),
                new boolean[]{!enableDough, enableMushroomPie},
                new ItemStack(salt),
                "blockMushroom",
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(potato_pie),
                new boolean[]{enableDough, enablePotatoPie},
                new ItemStack(salt),
                new ItemStack(potato),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(potato_pie),
                new boolean[]{!enableDough, enablePotatoPie},
                new ItemStack(salt),
                new ItemStack(potato),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(onion_pie),
                new boolean[]{enableDough, enableOnion, enableOnionPie},
                new ItemStack(salt),
                new ItemStack(onion),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(onion_pie),
                new boolean[]{!enableDough, enableOnion, enableOnionPie},
                new ItemStack(salt),
                new ItemStack(onion),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessOreRecipe(new ItemStack(shepherds_pie),
                new boolean[]{enableDough, enableShepherdsPie},
                new ItemStack(salt),
                "itemRedmeat",
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessOreRecipe(new ItemStack(shepherds_pie),
                new boolean[]{!enableDough, enableShepherdsPie},
                new ItemStack(salt),
                "itemRedmeat",
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(cod_pie),
                new boolean[]{enableDough, enableCodPie},
                new ItemStack(salt),
                new ItemStack(fish),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(cod_pie),
                new boolean[]{!enableDough, enableCodPie},
                new ItemStack(salt),
                new ItemStack(fish),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(salmon_pie),
                new boolean[]{enableDough, enableSalmonPie},
                new ItemStack(salt),
                new ItemStack(fish, 1, 1),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(salmon_pie),
                new boolean[]{!enableDough, enableSalmonPie},
                new ItemStack(salt),
                new ItemStack(fish, 1, 1),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(tropical_fish_pie),
                new boolean[]{enableDough, enableTropicalFishPie},
                new ItemStack(salt),
                new ItemStack(fish, 1, 2),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(tropical_fish_pie),
                new boolean[]{!enableDough, enableTropicalFishPie},
                new ItemStack(salt),
                new ItemStack(fish, 1, 2),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(tailor_pie),
                new boolean[]{enableDough, enableTailor, enableTailorPie},
                new ItemStack(salt),
                new ItemStack(tailor),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(tailor_pie),
                new boolean[]{!enableDough, enableTailor, enableTailorPie},
                new ItemStack(salt),
                new ItemStack(tailor),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(calamari_pie),
                new boolean[]{enableDough, enableCalamari, enableCalamariPie},
                new ItemStack(salt),
                new ItemStack(calamari),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(calamari_pie),
                new boolean[]{!enableDough, enableCalamari, enableCalamariPie},
                new ItemStack(salt),
                new ItemStack(calamari),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(saltwort_pie),
                new boolean[]{enableDough, enableSaltwortPie},
                new ItemStack(saltwort),
                new ItemStack(saltwort),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(saltwort_pie),
                new boolean[]{!enableDough, enableSaltwortPie},
                new ItemStack(saltwort),
                new ItemStack(saltwort),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessOreRecipe(new ItemStack(muffin),
                new boolean[]{enableHoney, enableDough, enableMuffin},
                "itemRoyaljelly",
                new ItemStack(dye, 1, 3),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessOreRecipe(new ItemStack(muffin),
                new boolean[]{enableHoney, !enableDough, enableMuffin},
                "itemRoyaljelly",
                new ItemStack(dye, 1, 3),
                new ItemStack(wheat),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(muffin),
                new boolean[]{!enableHoney, enableDough, enableMuffin},
                new ItemStack(sugar),
                new ItemStack(dye, 1, 3),
                new ItemStack(dough),
                new ItemStack(egg));
            addShapelessRecipe(new ItemStack(muffin),
                new boolean[]{!enableHoney, !enableDough, enableMuffin},
                new ItemStack(sugar),
                new ItemStack(dye, 1, 3),
                new ItemStack(wheat),
                new ItemStack(egg));

            addShapelessRecipe(new ItemStack(tunneler_concoction),
                new boolean[]{enableTunnelersConcoction},
                new ItemStack(sheep_horn),
                new ItemStack(fizzy_drink));
        }


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
        addShapelessRecipe(new ItemStack(tf_pickled_mushgloom),
            new boolean[]{enableTFFoods, mushgloom != null},
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(mushgloom, 1, 9),
            new ItemStack(mushgloom, 1, 9));

        addShapelessRecipe(new ItemStack(bop_salt_shroom_powder),
            new boolean[]{enableBOPFoods, food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 1));
        addShapelessRecipe(new ItemStack(bop_sugar_fruit_salad),
            new boolean[]{enableBOPFoods, food != null},
            new ItemStack(sugar_pinch),
            new ItemStack(food, 1, 4));
        addShapelessRecipe(new ItemStack(bop_salt_veggie_salad),
            new boolean[]{enableBOPFoods, food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 5));
        addShapelessRecipe(new ItemStack(bop_salt_shroom_salad),
            new boolean[]{enableBOPFoods, food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 6));
        addShapelessRecipe(new ItemStack(bop_salt_rice_bowl),
            new boolean[]{enableBOPFoods, food != null},
            new ItemStack(salt_pinch),
            new ItemStack(food, 1, 13));
        addShapelessRecipe(new ItemStack(bop_pickled_turnip),
            new boolean[]{enableBOPFoods, food != null},
            new ItemStack(salt_pinch),
            new ItemStack(potionitem),
            new ItemStack(food, 1, 11),
            new ItemStack(food, 1, 11));
        addShapelessRecipe(new ItemStack(dart, 1, 1),
            new boolean[]{enableBOPFoods, dart != null},
            new ItemStack(dart, 1, 0),
            new ItemStack(ModItems.bop_poison));

        addShapelessRecipe(new ItemStack(wm_salt_cooked_bison),
            new boolean[]{enableWMFoods, cooked_bison_meat != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_bison_meat));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_calamari),
            new boolean[]{enableWMFoods, cooked_calamari != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_calamari));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_chevon),
            new boolean[]{enableWMFoods, cooked_chevon != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_chevon));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_goose),
            new boolean[]{enableWMFoods, cooked_goose != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_goose));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_mouse),
            new boolean[]{enableWMFoods, cooked_mouse != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_mouse));
        addShapelessRecipe(new ItemStack(wm_salt_cooked_venison),
            new boolean[]{enableWMFoods, cooked_venison != null},
            new ItemStack(salt_pinch),
            new ItemStack(cooked_venison));


    }
}
