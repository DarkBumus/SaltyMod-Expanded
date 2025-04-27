package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.api.PotcookingRecipe;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.api.PotcookingRecipe.ore;
import static darkbum.saltymod.api.PotcookingRecipe.stack;


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
     * "import static darkbum.saltymod.api.PotcookingRecipe.ore;"
     * "import static darkbum.saltymod.api.PotcookingRecipe.stack;"
     * so that you can specify ItemStacks or OreDicts in your recipes.
     */

    public static void init() {
        PotcookingRecipe pot = PotcookingRecipe.cooking();

        pot.registerRecipe(new ItemStack(Items.mushroom_stew),
            true,
            1.0f,
            ore("blockMushroom"),
            ore("blockMushroom"));

/*        if (Loader.isModLoaded("etfuturum")) {
            Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            if ((rabbit_cooked != null) && (rabbit_stew != null)) {
                pot.registerRecipe(new ItemStack(rabbit_stew),
                    true,
                    stack(new ItemStack(rabbit_cooked)),
                    stack(new ItemStack(Items.carrot)),
                    stack(new ItemStack(Items.baked_potato)),
                    ore("blockMushroom"));
            }
            if ((beetroot != null) && (beetroot_soup != null)) {
                pot.registerRecipe(new ItemStack(beetroot_soup),
                    true,
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)));
            }
        }

        pot.registerRecipe(new ItemStack(ModItems.egg_bowl),
        true,
        0.1f,
        stack(new ItemStack(Moditems.salt_pinch)),
        stack(new ItemStack(Items.egg),
        stack(new ItemStack(Items.egg),
        stack(new ItemStack(Items.egg),
        stack(new ItemStack(Items.egg));

        pot.registerRecipe(new ItemStack(ModItems.salt_mushroom_stew),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            ore("blockMushroom"),
            ore("blockMushroom"));

        if (Loader.isModLoaded("etfuturum")) {
            Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            if ((rabbit_cooked != null)) {
                pot.registerRecipe(new ItemStack(ModItems.salt_rabbit_stew),
                    true,
                    stack(new ItemStack(ModItems.salt_pinch)),
                    stack(new ItemStack(rabbit_cooked)),
                    stack(new ItemStack(Items.carrot)),
                    stack(new ItemStack(Items.baked_potato)),
                    ore("blockMushroom"));
            }
            if ((beetroot != null)) {
                pot.registerRecipe(new ItemStack(ModItems.salt_beetroot_soup),
                    true,
                    stack(new ItemStack(ModItems.salt_pinch)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)),
                    stack(new ItemStack(beetroot)));
            }
        }

        pot.registerRecipe(new ItemStack(ModItems.pumpkin_porridge),
            true,
            stack(new ItemStack(Blocks.pumpkin)));
        pot.registerRecipe(new ItemStack(ModItems.pumpkin_porridge, 1, 1),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Blocks.pumpkin)));

        pot.registerRecipe(new ItemStack(ModItems.cactus_soup),
            true,
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)));
        pot.registerRecipe(new ItemStack(ModItems.cactus_soup, 1, 1),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)),
            stack(new ItemStack(Blocks.cactus)));

        pot.registerRecipe(new ItemStack(ModItems.stewed_vegetables),
            true,
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        pot.registerRecipe(new ItemStack(ModItems.stewed_vegetables, 1, 1),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));

        pot.registerRecipe(new ItemStack(ModItems.potato_mushroom),
            true,
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));
        pot.registerRecipe(new ItemStack(ModItems.potato_mushroom, 1, 1),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.potato)),
            stack(new ItemStack(Items.potato)),
            ore("blockMushroom"));

        pot.registerRecipe(new ItemStack(ModItems.golden_vegetables),
            true,
            stack(new ItemStack(Items.golden_carrot)),
            stack(new ItemStack(ModItems.golden_potato)),
            stack(new ItemStack(ModItems.golden_saltwort)));
        pot.registerRecipe(new ItemStack(ModItems.golden_vegetables, 1, 1),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.golden_carrot)),
            stack(new ItemStack(ModItems.golden_potato)),
            stack(new ItemStack(ModItems.golden_saltwort)));

        pot.registerRecipe(new ItemStack(ModItems.fish_soup),
            true,
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("itemFish"));
        pot.registerRecipe(new ItemStack(ModItems.fish_soup, 1, 1),
            true,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.potato)),
            ore("itemFish"));

        if (ModConfigurationItems.enableOnion) {
            pot.registerRecipe(new ItemStack(ModItems.dandelion_salad),
                false,
                stack(new ItemStack(Blocks.tallgrass, 1, 2)),
                stack(new ItemStack(Blocks.yellow_flower)),
                stack(new ItemStack(ModItems.onion)));
            pot.registerRecipe(new ItemStack(ModItems.dandelion_salad, 1, 1),
                false,
                stack(new ItemStack(ModItems.salt_pinch)),
                stack(new ItemStack(Blocks.tallgrass, 1, 2)),
                stack(new ItemStack(Blocks.yellow_flower)),
                stack(new ItemStack(ModItems.onion)));
        }

        pot.registerRecipe(new ItemStack(ModItems.wheat_sprouts),
            false,
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)));
        pot.registerRecipe(new ItemStack(ModItems.wheat_sprouts, 1, 1),
            false,
            stack(new ItemStack(ModItems.salt_pinch)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)),
            stack(new ItemStack(Items.wheat_seeds)));

        if (Loader.isModLoaded("etfuturum")) {
            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            if ((beetroot != null)) {
                pot.registerRecipe(new ItemStack(ModItems.beetroot_salad),
                    false,
                    stack(new ItemStack(Items.carrot)),
                    stack(new ItemStack(Items.potato)),
                    stack(new ItemStack(beetroot)));
                pot.registerRecipe(new ItemStack(ModItems.beetroot_salad, 1, 1),
                    false,
                    stack(new ItemStack(ModItems.salt_pinch)),
                    stack(new ItemStack(Items.carrot)),
                    stack(new ItemStack(Items.potato)),
                    stack(new ItemStack(beetroot)));

                if (ModConfigurationItems.enableOnion) {
                    pot.registerRecipe(new ItemStack(ModItems.dressed_herring),
                        false,
                        stack(new ItemStack(Items.carrot)),
                        stack(new ItemStack(ModItems.onion)),
                        stack(new ItemStack(Items.potato)),
                        stack(new ItemStack(beetroot)),
                        stack(new ItemStack(Items.egg)),
                        ore("itemFish"));
                    pot.registerRecipe(new ItemStack(ModItems.dressed_herring, 1, 1),
                        false,
                        stack(new ItemStack(ModItems.salt_pinch)),
                        stack(new ItemStack(Items.carrot)),
                        stack(new ItemStack(ModItems.onion)),
                        stack(new ItemStack(Items.potato)),
                        stack(new ItemStack(beetroot)),
                        stack(new ItemStack(Items.egg)),
                        ore("itemFish"));
                }
            }
        }

        pot.registerRecipe(new ItemStack(ModItems.saltwort_salad),
            false,
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        pot.registerRecipe(new ItemStack(ModItems.golden_saltwort_salad),
            false,
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)),
            stack(new ItemStack(ModItems.golden_saltwort)));

        pot.registerRecipe(new ItemStack(ModItems.saltwort_cooked_porkchop),
            false,
            stack(new ItemStack(ModItems.salt_cooked_porkchop)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        if (ModConfigurationItems.enableHoney) {
            pot.registerRecipe(new ItemStack(ModItems.saltwort_honey_porkchop),
                false,
                stack(new ItemStack(ModItems.honey_porkchop)),
                stack(new ItemStack(ModItems.saltwort)),
                stack(new ItemStack(ModItems.saltwort)));
        }
        pot.registerRecipe(new ItemStack(ModItems.saltwort_cooked_beef),
            false,
            stack(new ItemStack(ModItems.salt_cooked_beef)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        pot.registerRecipe(new ItemStack(ModItems.saltwort_cooked_mutton),
            false,
            stack(new ItemStack(ModItems.salt_cooked_mutton)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        pot.registerRecipe(new ItemStack(ModItems.saltwort_cooked_strider),
            false,
            stack(new ItemStack(ModItems.strider, 1, 2)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));
        pot.registerRecipe(new ItemStack(ModItems.saltwort_cooked_haunch),
            false,
            stack(new ItemStack(ModItems.haunch, 1, 2)),
            stack(new ItemStack(ModItems.saltwort)),
            stack(new ItemStack(ModItems.saltwort)));

        if (Loader.isModLoaded("etfuturum")) {
            Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
            if ((sweet_berries != null)) {
                pot.registerRecipe(new ItemStack(ModItems.fruit_salad),
                    false,
                    stack(new ItemStack(Items.apple)),
                    stack(new ItemStack(sweet_berries)),
                    stack(new ItemStack(Items.melon)));
                pot.registerRecipe(new ItemStack(ModItems.fruit_salad, 1, 1),
                    false,
                    stack(new ItemStack(ModItems.sugar_pinch)),
                    stack(new ItemStack(Items.apple)),
                    stack(new ItemStack(sweet_berries)),
                    stack(new ItemStack(Items.melon)));
            }
        }

        pot.registerRecipe(new ItemStack(ModItems.golden_fruit_salad),
            false,
            stack(new ItemStack(Items.golden_apple, 1, 0)),
            stack(new ItemStack(ModItems.golden_berries, 1, 0)),
            stack(new ItemStack(Items.speckled_melon)));
        pot.registerRecipe(new ItemStack(ModItems.golden_fruit_salad, 1, 1),
            false,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.golden_apple, 1, 0)),
            stack(new ItemStack(ModItems.golden_berries, 1, 0)),
            stack(new ItemStack(Items.speckled_melon)));

        pot.registerRecipe(new ItemStack(ModItems.grated_carrot),
            false,
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)));
        pot.registerRecipe(new ItemStack(ModItems.grated_carrot, 1, 1),
            false,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)),
            stack(new ItemStack(Items.carrot)));

        pot.registerRecipe(new ItemStack(ModItems.melon_soup),
            true,
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)));
        pot.registerRecipe(new ItemStack(ModItems.melon_soup),
            true,
            stack(new ItemStack(ModItems.sugar_pinch)),
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)),
            stack(new ItemStack(Items.melon)));*/
    }
}
