package darkbum.saltymod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;

/**
 * Utility class for removing crafting recipes.
 * Provides methods to remove recipes by item, block, metadata, and quantity.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class RecipeRemover {

    /**
     * Removes the first recipe that produces the specified item and metadata.
     *
     * @param item The item to search for.
     * @param meta The metadata to match. Use -1 to ignore metadata.
     */
    public static void removeFirstRecipeFor(Item item, int meta) {
        Iterator<IRecipe> it = CraftingManager.getInstance().getRecipeList().iterator();
        while (it.hasNext()) {
            IRecipe recipe = it.next();
            if (recipe != null) {
                ItemStack stack = recipe.getRecipeOutput();
                if (stack != null && stack.getItem() == item && (meta == -1 || meta == stack.getItemDamage())) {
                    it.remove();
                    return;
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public static void removeFirstRecipeFor(Item item) {
        removeFirstRecipeFor(item, -1);
    }

    @SuppressWarnings("unused")

    public static void removeFirstRecipeFor(Block block, int meta) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), meta);
    }

    @SuppressWarnings("unused")
    public static void removeFirstRecipeFor(Block block) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), -1);
    }

    /**
     * Removes all recipes that produce the specified item and metadata.
     *
     * @param item The item to search for.
     * @param meta The metadata to match. Use -1 to ignore metadata.
     */
    public static void removeAllRecipesFor(Item item, int meta) {
        Iterator<IRecipe> it = CraftingManager.getInstance().getRecipeList().iterator();
        while (it.hasNext()) {
            IRecipe recipe = it.next();
            ItemStack output = recipe.getRecipeOutput();
            if (output == null || output.getItem() == null) continue;

            boolean sameItem = output.getItem() == item;
            boolean sameMeta = meta == -1 || meta == output.getItemDamage();

            if (sameItem && sameMeta) {
                it.remove();
            }
        }
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Item item) {
        removeAllRecipesFor(item, -1);
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Block block, int meta) {
        removeAllRecipesFor(Item.getItemFromBlock(block), meta);
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Block block) {
        removeAllRecipesFor(Item.getItemFromBlock(block), -1);
    }

    /**
     * Removes a specified number of recipes that produce the given item and metadata.
     * The search will terminate after the specified number of recipes have been removed.
     *
     * @param item      The item to search for.
     * @param meta      The metadata to match. Use -1 to ignore metadata.
     * @param loopCount The number of recipes to remove.
     */
    public static void removeNumberedRecipesFor(Item item, int meta, int loopCount) {
        Iterator<IRecipe> it = CraftingManager.getInstance().getRecipeList().iterator();
        int removed = 0;
        while (it.hasNext() && removed < loopCount) {
            IRecipe recipe = it.next();
            ItemStack output = recipe.getRecipeOutput();
            if (output == null || output.getItem() == null) continue;

            boolean sameItem = output.getItem() == item;
            boolean sameMeta = meta == -1 || meta == output.getItemDamage();

            if (sameItem && sameMeta) {
                it.remove();
                removed++;
            }
        }
    }

    @SuppressWarnings("unused")
    public static void removeNumberedRecipesFor(Item item, int loopCount) {
        removeNumberedRecipesFor(item, -1, loopCount);
    }

    @SuppressWarnings("unused")
    public static void removeNumberedRecipesFor(Block block, int meta, int loopCount) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), meta, loopCount);
    }

    @SuppressWarnings("unused")
    public static void removeNumberedRecipesFor(Block block, int loopCount) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), -1, loopCount);
    }
}
