package darkbum.saltymod.init.recipes;

import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.common.config.ModConfigurationModCompatibility;
import darkbum.saltymod.init.ModExternalItemLoader;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.util.PotcookingRecipe.*;


public class ModCookingPotRecipes {

    /**
     * Recipe definition is even more complex than the Press, so here it goes:
     * recipes.registerRecipe(OUTPUT[ItemStack], REQUIRES HEATER?[Boolean], stack/orePINCH[ItemStack], stack/oreINPUT1[ItemStack], stack/oreINPUT2[ItemStack], stack/oreINPUT3[ItemStack], stack/oreINPUT4[ItemStack], stack/oreINPUT5[ItemStack], stack/oreINPUT6[ItemStack]);
     * NOTE: requiresHeater intentionally functions in a way where it will block functionality of a recipe, if the recipe specifies that it's not required, and yet it is present.
     * In short: If you recipe says requiresHeater = false and you place a valid stove block under to the cooking pot, the recipe will not function. Likewise, if you recipe says requiresHeater = true, and the stove is not present,
     * it will also not function.
     * NOTE: Further, it is not necessary to place items in any of the input slots save for one. PotcookingRecipe.java defines an Array for the inputs.
     * In short: If you want a recipe that only requires, e.g. two inputs, it is sufficient to define only two in the List.
     * NOTE: If you want to make use of this in your own mod, you will have to
     * "import static darkbum.saltymod.util.PotcookingRecipe.ore;"
     * "import static darkbum.saltymod.util.PotcookingRecipe.stack;"
     * so that you can specify ItemStacks or OreDicts in your recipes.
     */

    public static void init() {

        Block nether_fungus = ModExternalItemLoader.etFuturumBlocks.get("nether_fungus");
        Item rabbit_raw = ModExternalItemLoader.etFuturumItems.get("rabbit_raw");
        Item rabbit_stew = ModExternalItemLoader.etFuturumItems.get("rabbit_stew");
        Item beetroot = ModExternalItemLoader.etFuturumItems.get("beetroot");
        Item beetroot_soup = ModExternalItemLoader.etFuturumItems.get("beetroot_soup");
        Item sweet_berries = ModExternalItemLoader.etFuturumItems.get("sweet_berries");

        ConditionalRegistrar.addPotRecipe(new ItemStack(Items.mushroom_stew),
            new boolean[]{ModConfigurationBlocks.enableMachines},
            true,
            0.3f,
            ore("blockMushroom"),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(rabbit_stew),
            new boolean[]{rabbit_raw != null, rabbit_stew != null},
            true,
            0.5f,
            stack(new ItemStack(rabbit_raw)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(beetroot_soup),
            new boolean[]{beetroot != null, beetroot_soup != null},
            true,
            0.3f,
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.egg_bowl),
            new boolean[]{ModConfigurationItems.enableEgg},
            true,
            0.5f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.egg)),
            stack(new ItemStack(Items.egg)),
            stack(new ItemStack(Items.egg)),
            stack(new ItemStack(Items.egg)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.salt_mushroom_stew),
            new boolean[]{ModConfigurationItems.enableSaltedMushroomStew},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt_pinch)),
            ore("blockMushroom"),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.salt_rabbit_stew),
            new boolean[]{rabbit_raw != null, ModConfigurationModCompatibility.enableSaltedRabbitRagout},
            true,
            0.6f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(rabbit_raw)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.salt_beetroot_soup),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableSaltedBorscht},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.fungus_stew),
            new boolean[]{nether_fungus != null, ModConfigurationModCompatibility.enableFungusStew},
            true,
            0.3f,
            ore("blockFungus"),
            ore("blockFungus"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.fungus_stew, 1, 1),
            new boolean[]{nether_fungus != null, ModConfigurationModCompatibility.enableFungusStew},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt_pinch)),
            ore("blockFungus"),
            ore("blockFungus"));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.chicken_soup),
            new boolean[]{ModConfigurationItems.enableChickenSoup},
            true,
            0.45f,
            stack(new ItemStack(Items.cooked_chicken)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.chicken_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableChickenSoup},
            true,
            0.55f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.cooked_chicken)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.beef_stew),
            new boolean[]{ModConfigurationItems.enableBeefStew},
            true,
            0.45f,
            stack(new ItemStack(Items.cooked_beef)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.beef_stew, 1, 1),
            new boolean[]{ModConfigurationItems.enableBeefStew},
            true,
            0.55f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.cooked_beef)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.pumpkin_porridge),
            new boolean[]{ModConfigurationItems.enablePumpkinPorridge},
            true,
            0.15f,
            stack(new ItemStack(Blocks.pumpkin)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.pumpkin_porridge, 1, 1),
            new boolean[]{ModConfigurationItems.enablePumpkinPorridge},
            true,
            0.25f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Blocks.pumpkin)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.cactus_soup),
            new boolean[]{ModConfigurationItems.enableCactusSoup},
            true,
            0.3f,
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.cactus_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableCactusSoup},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.stewed_vegetables),
            new boolean[]{ModConfigurationItems.enableStewedVegetables},
            true,
            0.35f,
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.stewed_vegetables, 1, 1),
            new boolean[]{ModConfigurationItems.enableStewedVegetables},
            true,
            0.45f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.potato_mushroom),
            new boolean[]{ModConfigurationItems.enableSaltedPotato},
            true,
            0.35f,
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.potato_mushroom, 1, 1),
            new boolean[]{ModConfigurationItems.enableSaltedPotato},
            true,
            0.45f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.golden_vegetables),
            new boolean[]{ModConfigurationItems.enableGoldenFoods},
            true,
            0.45f,
            stack(new ItemStack(Items.golden_carrot)),
            stack(new ItemStack(ModItems.golden_potato)),
            stack(new ItemStack(ModItems.golden_saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.golden_vegetables, 1, 1),
            new boolean[]{ModConfigurationItems.enableGoldenFoods},
            true,
            0.55f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.golden_carrot)),
            stack(new ItemStack(ModItems.golden_potato)),
            stack(new ItemStack(ModItems.golden_saltwort)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.fish_soup),
            new boolean[]{ModConfigurationItems.enableFishSoup},
            true,
            0.3f,
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("itemFish"));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.fish_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableFishSoup},
            true,
            0.4f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("itemFish"));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.dandelion_salad),
            new boolean[]{ModConfigurationItems.enableOnion, ModConfigurationItems.enableDandelionSalad},
            false,
            0.35f,
            stack(new ItemStack(Blocks.tallgrass, 1, 2)),
            stack(new ItemStack(Blocks.yellow_flower)),
            stack(new ItemStack(ModItems.onion)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.dandelion_salad, 1, 1),
            new boolean[]{ModConfigurationItems.enableOnion, ModConfigurationItems.enableDandelionSalad},
            false,
            0.45f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Blocks.tallgrass, 1, 2)),
            stack(new ItemStack(Blocks.yellow_flower)),
            stack(new ItemStack(ModItems.onion)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.wheat_sprouts),
            new boolean[]{ModConfigurationItems.enableWheatSprouts},
            false,
            0.6f,
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.wheat_sprouts, 1, 1),
            new boolean[]{ModConfigurationItems.enableWheatSprouts},
            false,
            0.6f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.beetroot_salad),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableBeetrootSalad},
            false,
            0.3f,
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.beetroot_salad, 1, 1),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableBeetrootSalad},
            false,
            0.4f,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.dressed_herring),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableDressedHerring},
            false,
            0.6f,
            ore("itemFish"),
            stack(new ItemStack(ModItems.onion)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(Items.egg)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.dressed_herring, 1, 1),
            new boolean[]{beetroot != null, ModConfigurationModCompatibility.enableDressedHerring},
            false,
            0.7f,
            stack(new ItemStack(ModItems.salt_pinch)),
            ore("itemFish"),
            stack(new ItemStack(ModItems.onion)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(Items.egg)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_salad),
            new boolean[]{ModConfigurationItems.enableSaltwortSalad},
            false,
            0.6f,
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.golden_saltwort_salad),
            new boolean[]{ModConfigurationItems.enableGoldenFoods},
            false,
            0.9f,
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_cooked_porkchop),
            new boolean[]{ModConfigurationItems.enableSaltwortPorkchop},
            false,
            0.3f,
            stack(new ItemStack(ModItems.salt_cooked_porkchop)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_honey_porkchop),
            new boolean[]{ModConfigurationItems.enableHoney, ModConfigurationItems.enableHoneyPorkchop, ModConfigurationItems.enableSaltwortHoneyPorkchop},
            false,
            0.35f,
            stack(new ItemStack(ModItems.honey_porkchop)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_cooked_beef),
            new boolean[]{ModConfigurationItems.enableSaltwortBeef},
            false,
            0.3f,
            stack(new ItemStack(ModItems.salt_cooked_beef)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_cooked_mutton),
            new boolean[]{ModConfigurationModCompatibility.enableSaltwortMutton},
            false,
            0.3f,
            stack(new ItemStack(ModItems.salt_cooked_mutton)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_cooked_strider),
            new boolean[]{ModConfigurationItems.enableStrider, ModConfigurationItems.enableSaltwortStrider},
            false,
            0.35f,
            stack(new ItemStack(ModItems.strider, 1, 2)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.saltwort_cooked_haunch),
            new boolean[]{ModConfigurationItems.enableHaunch, ModConfigurationItems.enableSaltwortHaunch},
            false,
            0.3f,
            stack(new ItemStack(ModItems.haunch, 1, 2)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.fruit_salad),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableFruitSalad},
            false,
            0.3f,
            stack(new ItemStack(Items.apple)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(Items.melon)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableFruitSalad},
            false,
            0.4f,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.apple)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(Items.melon)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.golden_fruit_salad),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableGoldenFoods},
            false,
            0.45f,
            stack(new ItemStack(Items.golden_apple, 1, 0)),
            stack(new ItemStack(ModItems.golden_berries, 1, 0)),
            stack(new ItemStack(Items.speckled_melon)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.golden_fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null, ModConfigurationItems.enableGoldenFoods},
            false,
            0.55f,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.golden_apple, 1, 0)),
            stack(new ItemStack(ModItems.golden_berries, 1, 0)),
            stack(new ItemStack(Items.speckled_melon)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.grated_carrot),
            new boolean[]{ModConfigurationItems.enableGratedCarrot},
            false,
            0.3f,
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.grated_carrot, 1, 1),
            new boolean[]{ModConfigurationItems.enableGratedCarrot},
            false,
            0.4f,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)));

        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.melon_soup),
            new boolean[]{ModConfigurationItems.enableMelonSoup},
            true,
            0.45f,
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)));
        ConditionalRegistrar.addPotRecipe(new ItemStack(ModItems.melon_soup, 1, 1),
            new boolean[]{ModConfigurationItems.enableMelonSoup},
            true,
            0.55f,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)));
    }
}
