package darkbum.saltymod.init.recipes;

import darkbum.saltymod.api.RecipeRemover;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(Items.mushroom_stew),
                    new ItemStack(Items.bowl),
                    "blockMushroom",
                    "blockMushroom"));
            if (ModConfigurationItems.enableDough) {
                RecipeRemover.removeFirstRecipeFor(Items.bread);
                GameRegistry.addSmelting(new ItemStack(ModItems.dough), new ItemStack(Items.bread), 0.35F);
                RecipeRemover.removeFirstRecipeFor(Items.cake);
                GameRegistry.addRecipe(
                    new ItemStack(Items.cake),
                    " x ",
                    "yzy",
                    " a ",
                    'x',
                    Items.milk_bucket,
                    'y',
                    Items.sugar,
                    'z',
                    Items.egg,
                    'a',
                    ModItems.dough);
                RecipeRemover.removeFirstRecipeFor(Items.cookie);
                GameRegistry.addShapelessRecipe(
                    new ItemStack(Items.cookie, 8),
                    new ItemStack(ModItems.dough),
                    new ItemStack(Items.dye, 1, 3));
                RecipeRemover.removeFirstRecipeFor(Items.pumpkin_pie);
                GameRegistry.addShapelessRecipe(
                    new ItemStack(Items.pumpkin_pie, 1),
                    new ItemStack(Items.sugar),
                    new ItemStack(Blocks.pumpkin),
                    new ItemStack(ModItems.dough),
                    new ItemStack(Items.egg));
            }
        }
        if (ModConfigurationItems.replaceCake) {
            RecipeRemover.removeFirstRecipeFor(Items.cake);
        }
        if (Loader.isModLoaded("etfuturum")) {
            Block honeycomb_block = GameRegistry.findBlock("etfuturum", "honeycomb_block");
            Block beehive = GameRegistry.findBlock("etfuturum", "beehive");
            if (honeycomb_block != null) {
                if (ModConfigurationModCompatibility.enableEFRHoneyCompatibility) {
                    RecipeRemover.removeAllRecipesFor(honeycomb_block, 0);
                    GameRegistry
                        .addRecipe(new ItemStack(honeycomb_block), "xx", "xx", 'x', new ItemStack(ModItems.waxcomb));
                }
            }
            if (beehive != null) {
                if (ModConfigurationModCompatibility.enableEFRHoneyCompatibility) {
                    RecipeRemover.removeAllRecipesFor(beehive, 0);
                    GameRegistry.addRecipe(
                        new ShapedOreRecipe(
                            new ItemStack(beehive),
                            "xxx",
                            "yyy",
                            "xxx",
                            'x',
                            "plankWood",
                            'y',
                            new ItemStack(ModItems.waxcomb)));
                }
            }
        }
    }
}
