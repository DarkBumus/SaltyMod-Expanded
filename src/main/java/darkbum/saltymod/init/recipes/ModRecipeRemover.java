package darkbum.saltymod.init.recipes;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.configuration.configs.ModConfigurationVanillaChanges;
import darkbum.saltymod.init.ModItems;

public class ModRecipeRemover {

    public static void init() {

        if (ModConfigurationVanillaChanges.enableRecipeChanges) {
            removeFirstRecipeFor(Items.mushroom_stew);
            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(Items.mushroom_stew),
                    new ItemStack(Items.bowl),
                    "blockMushroom",
                    "blockMushroom"));
            if (ModConfigurationItems.enableDough) {
                removeFirstRecipeFor(Items.bread);
                GameRegistry.addSmelting(new ItemStack(ModItems.dough), new ItemStack(Items.bread), 0.35F);
                removeFirstRecipeFor(Items.cake);
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
                removeFirstRecipeFor(Items.cookie);
                GameRegistry.addShapelessRecipe(
                    new ItemStack(Items.cookie, 8),
                    new ItemStack(ModItems.dough),
                    new ItemStack(Items.dye, 1, 3));
                removeFirstRecipeFor(Items.pumpkin_pie);
                GameRegistry.addShapelessRecipe(
                    new ItemStack(Items.pumpkin_pie, 1),
                    new ItemStack(Items.sugar),
                    new ItemStack(Blocks.pumpkin),
                    new ItemStack(ModItems.dough),
                    new ItemStack(Items.egg));
            }
        }
        if (ModConfigurationItems.replaceCake) {
            removeFirstRecipeFor(Items.cake);
        }
        if (Loader.isModLoaded("etfuturum")) {
            Block honeycomb_block = GameRegistry.findBlock("etfuturum", "honeycomb_block");
            Block beehive = GameRegistry.findBlock("etfuturum", "beehive");
            if (honeycomb_block != null) {
                if (ModConfigurationModCompatibility.enableEFRHoneyCompatibility) {
                    removeAllRecipesFor(honeycomb_block, 0);
                    GameRegistry
                        .addRecipe(new ItemStack(honeycomb_block), "xx", "xx", 'x', new ItemStack(ModItems.waxcomb));
                }
            }
            if (beehive != null) {
                if (ModConfigurationModCompatibility.enableEFRHoneyCompatibility) {
                    removeAllRecipesFor(beehive, 0);
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

    private static void removeFirstRecipeFor(Item item, int meta) {
        Iterator<IRecipe> it = CraftingManager.getInstance()
            .getRecipeList()
            .iterator();
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

    private static void removeFirstRecipeFor(Item item) {
        removeFirstRecipeFor(item, -1);
    }

    private static void removeFirstRecipeFor(Block block, int meta) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), meta);
    }

    private static void removeFirstRecipeFor(Block block) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), -1);
    }

    private static void removeAllRecipesFor(Item item, int meta) {
        Iterator<IRecipe> it = CraftingManager.getInstance()
            .getRecipeList()
            .iterator();
        while (it.hasNext()) {
            IRecipe recipe = it.next();
            ItemStack output = recipe.getRecipeOutput();
            if (output == null || output.getItem() == null) continue; // Sicherstellen, dass Item nicht null ist

            boolean sameItem = output.getItem() == item;
            boolean sameMeta = meta == -1 || meta == output.getItemDamage();

            if (sameItem && sameMeta) {
                it.remove();
            }
        }
    }

    private static void removeAllRecipesFor(Item item) {
        removeAllRecipesFor(item, -1);
    }

    private static void removeAllRecipesFor(Block block, int meta) {
        removeAllRecipesFor(Item.getItemFromBlock(block), meta);
    }

    private static void removeAllRecipesFor(Block block) {
        removeAllRecipesFor(Item.getItemFromBlock(block), -1);
    }

    private static void removeNumberedRecipesFor(Item item, int meta, int loopCount) {
        Iterator<IRecipe> it = CraftingManager.getInstance()
            .getRecipeList()
            .iterator();
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

    private static void removeNumberedRecipesFor(Item item, int loopCount) {
        removeNumberedRecipesFor(item, -1, loopCount);
    }

    private static void removeNumberedRecipesFor(Block block, int meta, int loopCount) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), meta, loopCount);
    }

    private static void removeNumberedRecipesFor(Block block, int loopCount) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), -1, loopCount);
    }
}
