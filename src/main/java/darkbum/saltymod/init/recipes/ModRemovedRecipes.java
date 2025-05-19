package darkbum.saltymod.init.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.cake;

/**
 * Recipe remover class.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModRemovedRecipes {

    /**
     * Initializes all removed recipes.
     */
    public static void init() {

        Item rabbit_stew = etFuturumItems.get("rabbit_stew");
        Item beetroot_soup = etFuturumItems.get("beetroot_soup");
        Block honeycomb_block = etFuturumBlocks.get("honeycomb_block");
        Block beehive = etFuturumBlocks.get("beehive");

        removeFirstRecipeFor(mushroom_stew,
            enableRecipeChanges);
        removeFirstRecipeFor(bread,
            enableRecipeChanges, enableDough);
        removeFirstRecipeFor(cake,
            enableRecipeChanges, enableDough);
        removeFirstRecipeFor(cake,
            enableRecipeChanges, replaceCake);
        removeFirstRecipeFor(cake,
            enableRecipeChanges, enableDough);
        removeFirstRecipeFor(cake,
            enableRecipeChanges, replaceCake);
        removeFirstRecipeFor(cookie,
            enableRecipeChanges, enableDough);
        removeFirstRecipeFor(pumpkin_pie,
            enableRecipeChanges, enableDough);

        removeAllRecipesFor(rabbit_stew,
            rabbit_stew != null);
        removeAllRecipesFor(beetroot_soup,
            beetroot_soup != null);
        removeAllRecipesFor(honeycomb_block,
            honeycomb_block != null, enableEFRHoneyCompatibility);
        removeAllRecipesFor(beehive,
            beehive != null, enableEFRHoneyCompatibility);
    }
}
