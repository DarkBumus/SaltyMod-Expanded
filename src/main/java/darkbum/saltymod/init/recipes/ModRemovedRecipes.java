package darkbum.saltymod.init.recipes;

import darkbum.saltymod.api.RecipeRemover;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.configuration.configs.ModConfigurationVanillaChanges;
import darkbum.saltymod.init.ModItems;

public class ModRemovedRecipes {

    public static void init() {

        if (ModConfigurationVanillaChanges.enableRecipeChanges) {
            RecipeRemover.removeFirstRecipeFor(Items.mushroom_stew);
            if (ModConfigurationItems.enableDough) {
                RecipeRemover.removeFirstRecipeFor(Items.bread);
                RecipeRemover.removeFirstRecipeFor(Items.cake);
                RecipeRemover.removeFirstRecipeFor(Items.cookie);
                RecipeRemover.removeFirstRecipeFor(Items.pumpkin_pie);
            }
        }
        if (ModConfigurationItems.replaceCake) {
            RecipeRemover.removeFirstRecipeFor(Items.cake);
        }
        if (Loader.isModLoaded("etfuturum")) {
            Item rabbit_stew = GameRegistry.findItem("etfturum", "rabbit_stew");
            Block honeycomb_block = GameRegistry.findBlock("etfuturum", "honeycomb_block");
            Block beehive = GameRegistry.findBlock("etfuturum", "beehive");
            if (rabbit_stew != null) {
                RecipeRemover.removeAllRecipesFor(rabbit_stew);
            }
            if (honeycomb_block != null) {
                if (ModConfigurationModCompatibility.enableEFRHoneyCompatibility) {
                    RecipeRemover.removeAllRecipesFor(honeycomb_block);
                }
            }
            if (beehive != null) {
                if (ModConfigurationModCompatibility.enableEFRHoneyCompatibility) {
                    RecipeRemover.removeAllRecipesFor(beehive);
                }
            }
        }
    }
}
