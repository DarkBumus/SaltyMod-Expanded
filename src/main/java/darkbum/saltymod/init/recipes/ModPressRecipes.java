package darkbum.saltymod.init.recipes;

import darkbum.saltymod.tileentity.TileEntityPress;
import darkbum.saltymod.util.PotcookingRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModExternalItemLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.init.ModItems.*;
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

        Item honey_bottle = etFuturumItems.get("honey_bottle");

        addPressRecipe(new ItemStack(cobblestone),
            null,
            new ItemStack(gravel),
            false,
            true,
            null);

        addPressRecipe(new ItemStack(mineral_mud_ball),
            new boolean[]{enableMineralMud},
            new ItemStack(potionitem, 1, 0),
            new ItemStack(clay_ball),
            false,
            false,
            new ItemStack(glass_bottle));

        addPressRecipe(new ItemStack(wheat),
            new boolean[]{enableDough},
            new ItemStack(glass_bottle),
            new ItemStack(dough),
            false,
            true,
            new ItemStack(potionitem, 1, 0));

        addPressRecipe(new ItemStack(honeycomb),
            new boolean[]{enableHoney, honey_bottle != null},
            new ItemStack(honey_bottle),
            new ItemStack(waxcomb),
            false,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(new ItemStack(frozen_honey),
            new boolean[]{enableHoney, honey_bottle != null},
            new ItemStack(honey_bottle),
            null,
            true,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(new ItemStack(honeycomb),
            new boolean[]{enableHoney, honey_bottle == null},
            new ItemStack(royal_jelly),
            new ItemStack(waxcomb),
            false,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(new ItemStack(frozen_honey),
            new boolean[]{enableHoney, honey_bottle == null},
            new ItemStack(royal_jelly),
            null,
            true,
            false,
            new ItemStack(glass_bottle));

        addPressRecipe(new ItemStack(horn),
            new boolean[]{enableHornedSheep},
            new ItemStack(tunneler_concoction),
            null,
            true,
            true,
            new ItemStack(fizzy_drink));
    }
}
