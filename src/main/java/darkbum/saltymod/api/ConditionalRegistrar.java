package darkbum.saltymod.api;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ConditionalRegistrar {

    public static <T extends Item> void registerItem(T item, String name, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.registerItem(item, name);
    }

    public static <T extends Block> void registerBlock(T block, String name, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.registerBlock(block, name);
    }

    public static <T extends Block> void registerBlock(T block, Class<? extends ItemBlock> itemBlockClass, String name, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.registerBlock(block, itemBlockClass, name);
    }

    public static void addShapelessRecipe(ItemStack output, boolean[] conditions, Object... inputs) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.addShapelessRecipe(output, inputs);
    }

    public static void addShapelessRecipe(ItemStack output, Object... inputs) {
        addShapelessRecipe(output, new boolean[0], inputs);
    }

    public static void addShapelessOreRecipe(ItemStack output, boolean[] conditions, Object... inputs) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, inputs));
    }

    public static void addShapelessOreRecipe(ItemStack output, Object... inputs) {
        addShapelessOreRecipe(output, new boolean[0], inputs);
    }

    public static void addShapedRecipe(ItemStack output, Object[] ingredients, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.addRecipe(output, ingredients);
    }

    public static void addShapedOreRecipe(ItemStack output, Object[] ingredients, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(output, ingredients));
    }

    public static void addSmelting(ItemStack input, ItemStack output, float xp, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) return;
        }
        GameRegistry.addSmelting(input, output, xp);
    }
}
