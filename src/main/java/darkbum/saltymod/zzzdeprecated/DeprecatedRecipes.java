package darkbum.saltymod.zzzdeprecated;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.wheat;

/**
 * Recipe class for Deprecated Recipes.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class DeprecatedRecipes {

    /**
     * Initializes all deprecated recipes.
     */
    public static void init() {

        Block nether_fungus = etFuturumBlocks.get("nether_fungus");
        Item rabbit_raw = etFuturumItems.get("rabbit_raw");
        Item rabbit_stew = etFuturumItems.get("rabbit_stew");
        Item beetroot = etFuturumItems.get("beetroot");
        Item beetroot_soup = etFuturumItems.get("beetroot_soup");
        Item chorus_fruit = etFuturumItems.get("chorus_fruit");
        Item sweet_berries = etFuturumItems.get("sweet_berries");


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
            new boolean[]{beetroot != null, beetroot_soup != null, enableRecipeChanges},
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
            new ItemStack(wheat),
            new ItemStack(sweet_berries));
        addShapelessRecipe(new ItemStack(chorus_cookie, 4),
            new boolean[]{chorus_fruit != null, enableDough, enableChorusCookie},
            new ItemStack(dough),
            new ItemStack(chorus_fruit));
        addShapelessRecipe(new ItemStack(chorus_cookie, 4),
            new boolean[]{chorus_fruit != null, !enableDough, enableChorusCookie},
            new ItemStack(wheat),
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
            new boolean[]{enableHoney, enableDough},
            "itemRoyaljelly",
            new ItemStack(dye, 1, 3),
            new ItemStack(dough),
            new ItemStack(egg));
        addShapelessOreRecipe(new ItemStack(muffin),
            new boolean[]{enableHoney, !enableDough},
            "itemRoyaljelly",
            new ItemStack(dye, 1, 3),
            new ItemStack(wheat),
            new ItemStack(egg));
        addShapelessRecipe(new ItemStack(muffin),
            new boolean[]{!enableHoney, enableDough},
            new ItemStack(sugar),
            new ItemStack(dye, 1, 3),
            new ItemStack(dough),
            new ItemStack(egg));
        addShapelessRecipe(new ItemStack(muffin),
            new boolean[]{!enableHoney, !enableDough},
            new ItemStack(sugar),
            new ItemStack(dye, 1, 3),
            new ItemStack(wheat),
            new ItemStack(egg));

        addShapelessRecipe(new ItemStack(tunneler_concoction),
            new boolean[]{enableTunnelersConcoction},
            new ItemStack(sheep_horn),
            new ItemStack(fizzy_drink));
    }
}
