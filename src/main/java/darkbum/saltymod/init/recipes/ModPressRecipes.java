package darkbum.saltymod.init.recipes;

import darkbum.saltymod.tileentity.TileEntityPress;
import darkbum.saltymod.util.PotcookingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.PressingRecipe.ore;
import static darkbum.saltymod.util.PressingRecipe.stack;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.wheat;

/**
 * Recipe class for {@link TileEntityPress}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModPressRecipes {

    /**
     * Initializes all custom press recipes.
     * <p>
     * Recipe definition:
     * OvenbakingRecipe.baking().registerRecipe(OUTPUT(ItemStack), HEATER?(boolean), XPCHANCE(float), INPUTS(ItemStack));
     * If you want to use this in your own mod, you need to import the static methods for stack and ore ingredients from {@link PotcookingRecipe}.
     * NOTE:    The requiresHeater boolean intentionally functions in a way where setting the value to "false" will require the heater to NOT
     * be present for the recipe to function.
     */
    public static void init() {

        Item raw_ore = etFuturumItems.get("raw_ore");
        Item dye = etFuturumItems.get("dye");
        Item honey_bottle = etFuturumItems.get("honey_bottle");

        addPressRecipe(stack(new ItemStack(stone)),
            new ItemStack(cobblestone),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(cobblestone)),
            new ItemStack(gravel),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(gravel)),
            new ItemStack(sand, 1, 0),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(gravel)),
            new ItemStack(sand, 1, 1),
            null,
            false,
            true,
            new ItemStack(Items.dye, 1, 1));

        addPressRecipe(stack(new ItemStack(gold_ore)),
            new boolean[]{raw_ore != null},
            new ItemStack(cobblestone),
            new ItemStack(raw_ore, 1, 2),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(iron_ore)),
            new boolean[]{raw_ore != null},
            new ItemStack(cobblestone),
            new ItemStack(raw_ore, 1, 1),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(iron_ore)),
            new ItemStack(cobblestone),
            new ItemStack(coal, 1, 0),
            false,
            true,
            null);

        addPressRecipe(ore("blockGlass"),
            new ItemStack(sand, 1, 0),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(lapis_ore)),
            new ItemStack(cobblestone),
            new ItemStack(Items.dye, 3, 4),
            false,
            true,
            null);

        addPressRecipe(ore("blockSandstone"),
            new ItemStack(sand, 1, 0),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(brick_block)),
            new ItemStack(bucket),
            new ItemStack(clay, 1, 0),
            false,
            true,
            new ItemStack(water_bucket));
        addPressRecipe(stack(new ItemStack(mossy_cobblestone)),
            new ItemStack(gravel),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(diamond_ore)),
            new ItemStack(cobblestone),
            new ItemStack(diamond),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(redstone_ore)),
            new ItemStack(cobblestone),
            new ItemStack(redstone, 3, 0),
            false,
            true,
            null);

        addPressRecipe(ore("blockIce"),
            new ItemStack(snow),
            null,
            false,
            true,
            null);
        addPressRecipe(ore("blockIce"),
            new ItemStack(water_bucket),
            null,
            true,
            false,
            new ItemStack(bucket));
        addPressRecipe(stack(new ItemStack(glowstone)),
            new ItemStack(glowstone_dust, 2, 0),
            null,
            false,
            true,
            null);

        addPressRecipe(ore("blockStoneBrick"),
            new ItemStack(cobblestone),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(emerald_ore)),
            new ItemStack(cobblestone),
            new ItemStack(emerald),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(quartz_ore)),
            new ItemStack(netherrack),
            new ItemStack(quartz),
            false,
            true,
            null);

        addPressRecipe(ore("blockQuartz"),
            new ItemStack(netherrack),
            new ItemStack(quartz, 4, 0),
            false,
            true,
            null);
        addPressRecipe(ore("blockTerracotta"),
            new ItemStack(bucket),
            new ItemStack(clay, 1, 0),
            false,
            true,
            new ItemStack(water_bucket));

        addPressRecipe(stack(new ItemStack(honeycomb)),
            new boolean[]{enableHoney, honey_bottle != null},
            new ItemStack(honey_bottle),
            new ItemStack(waxcomb),
            false,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(stack(new ItemStack(frozen_honey)),
            new boolean[]{enableHoney, honey_bottle != null},
            new ItemStack(honey_bottle),
            null,
            true,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(stack(new ItemStack(honeycomb)),
            new boolean[]{enableHoney, honey_bottle == null},
            new ItemStack(royal_jelly),
            new ItemStack(waxcomb),
            false,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(stack(new ItemStack(frozen_honey)),
            new boolean[]{enableHoney, honey_bottle == null},
            new ItemStack(royal_jelly),
            null,
            true,
            false,
            new ItemStack(glass_bottle));

        addPressRecipe(stack(new ItemStack(sheep_horn)),
            new boolean[]{enableHornedSheep},
            new ItemStack(tunneler_concoction),
            null,
            true,
            true,
            new ItemStack(fizzy_drink));
    }
}
