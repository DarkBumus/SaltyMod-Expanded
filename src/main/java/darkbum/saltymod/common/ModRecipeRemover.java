package darkbum.saltymod.common;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipeRemover {
    public static void init() {
        if(ModConfiguration.enableRecipeChanges) {
            removeFirstRecipeFor(Items.mushroom_stew);
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl), "blockMushroom", "blockMushroom"));
            if (ModConfiguration.enableDough) {
                removeFirstRecipeFor(Items.bread);
                GameRegistry.addSmelting(new ItemStack(ModItems.dough), new ItemStack(Items.bread), 0.35F);
                removeFirstRecipeFor(Items.cake);
                GameRegistry.addRecipe(new ItemStack(Items.cake), " x ", "yzy", " a ", 'x', Items.milk_bucket, 'y', Items.sugar, 'z', Items.egg, 'a', ModItems.dough);
                removeFirstRecipeFor(Items.cookie);
                GameRegistry.addShapelessRecipe(new ItemStack(Items.cookie, 8), new ItemStack(ModItems.dough), new ItemStack(Items.dye, 1, 3));
                removeFirstRecipeFor(Items.pumpkin_pie);
                GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie, 1), new ItemStack(Items.sugar), new ItemStack(Blocks.pumpkin), new ItemStack(ModItems.dough), new ItemStack(Items.egg));
            }
        }
        if(ModConfiguration.replaceCake) {
            removeFirstRecipeFor(Items.cake);
        }
    }

    private static void removeFirstRecipeFor(Block block) {
        removeFirstRecipeFor(Item.getItemFromBlock(block));
    }

    private static void removeFirstRecipeFor(Block block, int meta) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), meta);
    }

    private static void removeFirstRecipeFor(Item item) {
        removeFirstRecipeFor(item, -1);
    }

    private static void removeFirstRecipeFor(Item item, int meta) {
        for (Object recipe : CraftingManager.getInstance().getRecipeList()) {
            if (recipe != null) {
                ItemStack stack = ((IRecipe) recipe).getRecipeOutput();
                if (stack != null && stack.getItem() == item && (meta == -1 || meta == stack.getItemDamage())) {
                    CraftingManager.getInstance().getRecipeList().remove(recipe);
                    return;
                }
            }
        }
    }

/*    public static void RemoveRecipeBlock(Block resultItem, int stacksize, int meta) {
        ItemStack resultStack = new ItemStack(resultItem, stacksize, meta);
        ItemStack recipeResult = null;
        ArrayList<IRecipe> recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = recipes.get(scan);
            if (tmpRecipe instanceof ShapedRecipes) {
                ShapedRecipes recipe = (ShapedRecipes) tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (tmpRecipe instanceof ShapelessRecipes) {
                ShapelessRecipes recipe = (ShapelessRecipes) tmpRecipe;
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
        ArrayList<IRecipe> recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = recipes.get(scan);
            if (tmpRecipe instanceof ShapedRecipes) {
                ShapedRecipes recipe = (ShapedRecipes) tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (tmpRecipe instanceof ShapelessRecipes) {
                ShapelessRecipes recipe = (ShapelessRecipes) tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(resultStack, recipeResult)) {
                System.out.println(" Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
                recipes.remove(scan);
            }
        }
    }*/
}
