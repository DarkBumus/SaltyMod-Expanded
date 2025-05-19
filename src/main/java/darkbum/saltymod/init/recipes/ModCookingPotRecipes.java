package darkbum.saltymod.init.recipes;

import darkbum.saltymod.tileentity.TileEntityCookingPot;
import darkbum.saltymod.util.PotcookingRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.util.PotcookingRecipe.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;

/**
 * Recipe class for {@link TileEntityCookingPot}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModCookingPotRecipes {

    /**
     * Initializes all custom pot recipes.
     * <p>
     * Recipe definition:
     * OvenbakingRecipe.baking().registerRecipe(OUTPUT(ItemStack), HEATER?(boolean), XPCHANCE(float), INPUTS(ItemStack));
     * If you want to use this in your own mod, you need to import the static methods for stack and ore ingredients from {@link PotcookingRecipe}.
     * NOTE:    The requiresHeater boolean intentionally functions in a way where setting the value to "false" will require the heater to NOT
     *          be present for the recipe to function.
     */
    public static void init() {

        Block nether_fungus = etFuturumBlocks.get("nether_fungus");
        Item rabbit_raw = etFuturumItems.get("rabbit_raw");
        Item rabbit_stew = etFuturumItems.get("rabbit_stew");
        Item beetroot = etFuturumItems.get("beetroot");
        Item beetroot_soup = etFuturumItems.get("beetroot_soup");
        Item sweet_berries = etFuturumItems.get("sweet_berries");

        addPotRecipe(new ItemStack(mushroom_stew),
            new boolean[]{enableMachines},
            true,
            0.3f,
            ore("blockMushroom"),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(rabbit_stew),
            new boolean[]{rabbit_raw != null, rabbit_stew != null},
            true,
            0.5f,
            stack(new ItemStack(rabbit_raw)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(beetroot_soup),
            new boolean[]{beetroot != null, beetroot_soup != null},
            true,
            0.3f,
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)));

        addPotRecipe(new ItemStack(egg_bowl),
            new boolean[]{enableEgg},
            true,
            0.5f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(egg)),
            stack(new ItemStack(egg)),
            stack(new ItemStack(egg)),
            stack(new ItemStack(egg)));
        addPotRecipe(new ItemStack(salt_mushroom_stew),
            new boolean[]{enableSaltedMushroomStew},
            true,
            0.4f,
            stack(new ItemStack(salt_pinch)),
            ore("blockMushroom"),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(salt_rabbit_stew),
            new boolean[]{rabbit_raw != null, enableSaltedRabbitRagout},
            true,
            0.6f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(rabbit_raw)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(salt_beetroot_soup),
            new boolean[]{beetroot != null, enableSaltedBorscht},
            true,
            0.4f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(beetroot)));

        addPotRecipe(new ItemStack(fungus_stew),
            new boolean[]{nether_fungus != null, enableFungusStew},
            true,
            0.3f,
            ore("blockFungus"),
            ore("blockFungus"));
        addPotRecipe(new ItemStack(fungus_stew, 1, 1),
            new boolean[]{nether_fungus != null, enableFungusStew},
            true,
            0.4f,
            stack(new ItemStack(salt_pinch)),
            ore("blockFungus"),
            ore("blockFungus"));

        addPotRecipe(new ItemStack(chicken_soup),
            new boolean[]{enableChickenSoup},
            true,
            0.45f,
            stack(new ItemStack(cooked_chicken)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(chicken_soup, 1, 1),
            new boolean[]{enableChickenSoup},
            true,
            0.55f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(cooked_chicken)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));

        addPotRecipe(new ItemStack(beef_stew),
            new boolean[]{enableBeefStew},
            true,
            0.45f,
            stack(new ItemStack(cooked_beef)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(beef_stew, 1, 1),
            new boolean[]{enableBeefStew},
            true,
            0.55f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(cooked_beef)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));

        addPotRecipe(new ItemStack(pumpkin_porridge),
            new boolean[]{enablePumpkinPorridge},
            true,
            0.15f,
            stack(new ItemStack(pumpkin)));
        addPotRecipe(new ItemStack(pumpkin_porridge, 1, 1),
            new boolean[]{enablePumpkinPorridge},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(pumpkin)));

        addPotRecipe(new ItemStack(cactus_soup),
            new boolean[]{enableCactusSoup},
            true,
            0.3f,
            stack(new ItemStack(cactus)),
            stack(new ItemStack(cactus)),
            stack(new ItemStack(cactus)));
        addPotRecipe(new ItemStack(cactus_soup, 1, 1),
            new boolean[]{enableCactusSoup},
            true,
            0.4f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(cactus)),
            stack(new ItemStack(cactus)),
            stack(new ItemStack(cactus)));

        addPotRecipe(new ItemStack(stewed_vegetables),
            new boolean[]{enableStewedVegetables},
            true,
            0.35f,
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(stewed_vegetables, 1, 1),
            new boolean[]{enableStewedVegetables},
            true,
            0.45f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));

        addPotRecipe(new ItemStack(potato_mushroom),
            new boolean[]{enableSaltedPotato},
            true,
            0.35f,
            stack(new ItemStack(potato)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));
        addPotRecipe(new ItemStack(potato_mushroom, 1, 1),
            new boolean[]{enableSaltedPotato},
            true,
            0.45f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(potato)),
            stack(new ItemStack(potato)),
            ore("blockMushroom"));

        addPotRecipe(new ItemStack(golden_vegetables),
            new boolean[]{enableGoldenFoods},
            true,
            0.45f,
            stack(new ItemStack(golden_carrot)),
            stack(new ItemStack(golden_potato)),
            stack(new ItemStack(golden_saltwort)));
        addPotRecipe(new ItemStack(golden_vegetables, 1, 1),
            new boolean[]{enableGoldenFoods},
            true,
            0.55f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(golden_carrot)),
            stack(new ItemStack(golden_potato)),
            stack(new ItemStack(golden_saltwort)));

        addPotRecipe(new ItemStack(fish_soup),
            new boolean[]{enableFishSoup},
            true,
            0.3f,
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("itemFish"));
        addPotRecipe(new ItemStack(fish_soup, 1, 1),
            new boolean[]{enableFishSoup},
            true,
            0.4f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            ore("itemFish"));

        addPotRecipe(new ItemStack(dandelion_salad),
            new boolean[]{enableOnion, enableDandelionSalad},
            false,
            0.35f,
            stack(new ItemStack(tallgrass, 1, 2)),
            stack(new ItemStack(yellow_flower)),
            stack(new ItemStack(onion)));
        addPotRecipe(new ItemStack(dandelion_salad, 1, 1),
            new boolean[]{enableOnion, enableDandelionSalad},
            false,
            0.45f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(tallgrass, 1, 2)),
            stack(new ItemStack(yellow_flower)),
            stack(new ItemStack(onion)));

        addPotRecipe(new ItemStack(wheat_sprouts),
            new boolean[]{enableWheatSprouts},
            false,
            0.6f,
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)));
        addPotRecipe(new ItemStack(wheat_sprouts, 1, 1),
            new boolean[]{enableWheatSprouts},
            false,
            0.6f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)),
            stack(new ItemStack(wheat_seeds)));

        addPotRecipe(new ItemStack(beetroot_salad),
            new boolean[]{beetroot != null, enableBeetrootSalad},
            false,
            0.3f,
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)));
        addPotRecipe(new ItemStack(beetroot_salad, 1, 1),
            new boolean[]{beetroot != null, enableBeetrootSalad},
            false,
            0.4f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)));

        addPotRecipe(new ItemStack(dressed_herring),
            new boolean[]{beetroot != null, enableDressedHerring},
            false,
            0.6f,
            ore("itemFish"),
            stack(new ItemStack(onion)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(egg)));
        addPotRecipe(new ItemStack(dressed_herring, 1, 1),
            new boolean[]{beetroot != null, enableDressedHerring},
            false,
            0.7f,
            stack(new ItemStack(salt_pinch)),
            ore("itemFish"),
            stack(new ItemStack(onion)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(potato)),
            stack(new ItemStack(beetroot)),
            stack(new ItemStack(egg)));

        addPotRecipe(new ItemStack(saltwort_salad),
            new boolean[]{enableSaltwortSalad},
            false,
            0.6f,
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(golden_saltwort_salad),
            new boolean[]{enableGoldenFoods},
            false,
            0.9f,
            stack(new ItemStack(golden_saltwort)),
            stack(new ItemStack(golden_saltwort)),
            stack(new ItemStack(golden_saltwort)),
            stack(new ItemStack(golden_saltwort)),
            stack(new ItemStack(golden_saltwort)),
            stack(new ItemStack(golden_saltwort)));

        addPotRecipe(new ItemStack(saltwort_cooked_porkchop),
            new boolean[]{enableSaltwortPorkchop},
            false,
            0.3f,
            stack(new ItemStack(salt_cooked_porkchop)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(saltwort_honey_porkchop),
            new boolean[]{enableHoney, enableHoneyPorkchop, enableSaltwortHoneyPorkchop},
            false,
            0.35f,
            stack(new ItemStack(honey_porkchop)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(saltwort_cooked_beef),
            new boolean[]{enableSaltwortBeef},
            false,
            0.3f,
            stack(new ItemStack(salt_cooked_beef)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(saltwort_cooked_mutton),
            new boolean[]{enableSaltwortMutton},
            false,
            0.3f,
            stack(new ItemStack(salt_cooked_mutton)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(saltwort_cooked_strider),
            new boolean[]{enableStrider, enableSaltwortStrider},
            false,
            0.35f,
            stack(new ItemStack(strider, 1, 2)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(saltwort_cooked_haunch),
            new boolean[]{enableHaunch, enableSaltwortHaunch},
            false,
            0.3f,
            stack(new ItemStack(haunch, 1, 2)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));

        addPotRecipe(new ItemStack(fruit_salad),
            new boolean[]{sweet_berries != null, enableFruitSalad},
            false,
            0.3f,
            stack(new ItemStack(apple)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(melon)));
        addPotRecipe(new ItemStack(fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null, enableFruitSalad},
            false,
            0.4f,
            stack(new ItemStack(sugar_pinch)),
            stack(new ItemStack(apple)),
            stack(new ItemStack(sweet_berries)),
            stack(new ItemStack(melon)));

        addPotRecipe(new ItemStack(golden_fruit_salad),
            new boolean[]{sweet_berries != null, enableGoldenFoods},
            false,
            0.45f,
            stack(new ItemStack(golden_apple, 1, 0)),
            stack(new ItemStack(golden_berries, 1, 0)),
            stack(new ItemStack(speckled_melon)));
        addPotRecipe(new ItemStack(golden_fruit_salad, 1, 1),
            new boolean[]{sweet_berries != null, enableGoldenFoods},
            false,
            0.55f,
            stack(new ItemStack(sugar_pinch)),
            stack(new ItemStack(golden_apple, 1, 0)),
            stack(new ItemStack(golden_berries, 1, 0)),
            stack(new ItemStack(speckled_melon)));

        addPotRecipe(new ItemStack(grated_carrot),
            new boolean[]{enableGratedCarrot},
            false,
            0.3f,
            stack(new ItemStack(carrot)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(carrot)));
        addPotRecipe(new ItemStack(grated_carrot, 1, 1),
            new boolean[]{enableGratedCarrot},
            false,
            0.4f,
            stack(new ItemStack(sugar_pinch)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(carrot)),
            stack(new ItemStack(carrot)));

        addPotRecipe(new ItemStack(melon_soup),
            new boolean[]{enableMelonSoup},
            true,
            0.45f,
            stack(new ItemStack(melon)),
            stack(new ItemStack(melon)),
            stack(new ItemStack(melon)));
        addPotRecipe(new ItemStack(melon_soup, 1, 1),
            new boolean[]{enableMelonSoup},
            true,
            0.55f,
            stack(new ItemStack(sugar_pinch)),
            stack(new ItemStack(melon)),
            stack(new ItemStack(melon)),
            stack(new ItemStack(melon)));
    }
}
