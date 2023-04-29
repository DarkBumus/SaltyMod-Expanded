package darkbum.saltymod.common;

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
        removeFirstRecipeFor(Items.mushroom_stew);
        removeFirstRecipeFor(Items.bread);
        removeFirstRecipeFor(Items.cake);
        removeFirstRecipeFor(Items.cookie);
        removeFirstRecipeFor(Items.pumpkin_pie);
        if(Loader.isModLoaded("etfuturum")) {
            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            if ((rabbit_stew != null) &&
                (beetroot_soup != null)) {
                removeFirstRecipeFor(rabbit_stew);
                removeFirstRecipeFor(beetroot_soup);
            }
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
        for (Object recipe : CraftingManager.getInstance().getRecipeList())
            if (recipe != null) {
                ItemStack stack = ((IRecipe) recipe).getRecipeOutput();
                if (stack != null && stack.getItem() == item && (meta == -1 || meta == stack.getItemDamage())) {
                    CraftingManager.getInstance().getRecipeList().remove(recipe);
                    return;
                }
            }
    }
}
