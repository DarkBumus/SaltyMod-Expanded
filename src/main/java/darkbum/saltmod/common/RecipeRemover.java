package darkbum.saltmod.common;

import java.util.ArrayList;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class RecipeRemover {
    public static void init() {
        RemoveRecipeItem(Items.mushroom_stew, 1, 0);
        if(Loader.isModLoaded("etfuturum")) {
            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            if(rabbit_stew != null) {
                RemoveRecipeItem(rabbit_stew, 1, 0);
            }
            if(beetroot_soup != null) {
                RemoveRecipeItem(beetroot_soup, 1, 0);
            }
        }
    }

    public static void RemoveRecipeBlock(Block resultItem, int stacksize, int meta) {
        ItemStack resultStack = new ItemStack(resultItem, stacksize, meta);
        ItemStack recipeResult = null;
        ArrayList<IRecipe> recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();
        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = recipes.get(scan);
            if (tmpRecipe instanceof ShapedRecipes) {
                ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (tmpRecipe instanceof ShapelessRecipes) {
                ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(resultStack, recipeResult)) {
                System.out.println(" Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
                recipes.remove(scan);
            }
        }
    }

    public static void RemoveRecipeItem(Item resultItem, int stacksize, int meta) {
        ItemStack resultStack = new ItemStack(resultItem, stacksize, meta);
        ItemStack recipeResult = null;
        ArrayList<IRecipe> recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();
        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = recipes.get(scan);
            if (tmpRecipe instanceof ShapedRecipes) {
                ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (tmpRecipe instanceof ShapelessRecipes) {
                ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(resultStack, recipeResult)) {
                System.out.println(" Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
                recipes.remove(scan);
            }
        }
    }
}
