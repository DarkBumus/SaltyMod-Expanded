package darkbum.saltymod.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;

public class RecipeRemover {

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

    public static void removeFirstRecipeFor(Item item) {
        removeFirstRecipeFor(item, -1);
    }

    public static void removeFirstRecipeFor(Block block, int meta) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), meta);
    }

    public static void removeFirstRecipeFor(Block block) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), -1);
    }



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

    public static void removeAllRecipesFor(Item item) {
        removeAllRecipesFor(item, -1);
    }

    public static void removeAllRecipesFor(Block block, int meta) {
        removeAllRecipesFor(Item.getItemFromBlock(block), meta);
    }

    public static void removeAllRecipesFor(Block block) {
        removeAllRecipesFor(Item.getItemFromBlock(block), -1);
    }



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

    public static void removeNumberedRecipesFor(Item item, int loopCount) {
        removeNumberedRecipesFor(item, -1, loopCount);
    }

    public static void removeNumberedRecipesFor(Block block, int meta, int loopCount) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), meta, loopCount);
    }

    public static void removeNumberedRecipesFor(Block block, int loopCount) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), -1, loopCount);
    }
}
