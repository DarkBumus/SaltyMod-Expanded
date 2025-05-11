package darkbum.saltymod.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ConditionalRegistrar {

    private static boolean checkConditions(boolean... conditions) {
        if (conditions == null) return false;
        for (boolean condition : conditions) {
            if (!condition) return true;
        }
        return false;
    }

    public static void registerOre(String oreName, Item item, boolean... conditions) {
        if (checkConditions(conditions)) return;
        OreDictionary.registerOre(oreName, item);
    }

    public static void registerOre(String oreName, ItemStack itemStack, boolean... conditions) {
        if (checkConditions(conditions)) return;
        OreDictionary.registerOre(oreName, itemStack);
    }

    public static <T extends Item> void registerItem(T item, String name, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerItem(item, name);
    }

    public static <T extends Block> void registerBlock(T block, String name, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerBlock(block, name);
    }

    public static <T extends Block> void registerBlock(T block, Class<? extends ItemBlock> itemBlockClass, String name, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerBlock(block, itemBlockClass, name);
    }

    public static void addShapelessRecipe(ItemStack output, boolean[] conditions, Object... inputs) {
        if (checkConditions(conditions)) return;
        GameRegistry.addShapelessRecipe(output, inputs);
    }

    public static void addShapelessRecipe(ItemStack output, Object... inputs) {
        addShapelessRecipe(output, new boolean[0], inputs);
    }

    public static void addShapelessOreRecipe(ItemStack output, boolean[] conditions, Object... inputs) {
        if (checkConditions(conditions)) return;
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, inputs));
    }

    public static void addShapelessOreRecipe(ItemStack output, Object... inputs) {
        addShapelessOreRecipe(output, new boolean[0], inputs);
    }

    public static void addShapedRecipe(ItemStack output, Object[] ingredients, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.addRecipe(output, ingredients);
    }

    public static void addShapedOreRecipe(ItemStack output, Object[] ingredients, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.addRecipe(new ShapedOreRecipe(output, ingredients));
    }

    public static void addSmelting(ItemStack input, ItemStack output, float xp, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.addSmelting(input, output, xp);
    }

    public static void addPotRecipe(ItemStack output, boolean[] conditions, boolean requiresHeater, float xpChance, PotcookingRecipe.IIngredientMatcher... ingredients) {
        if (checkConditions(conditions)) return;
        PotcookingRecipe.cooking().registerRecipe(output, requiresHeater, xpChance, ingredients);
    }

    @SuppressWarnings("unused")
    public static void addPotRecipe(ItemStack output, boolean requiresHeater, float xpChance, PotcookingRecipe.IIngredientMatcher... ingredients) {
        addPotRecipe(output, new boolean[0], requiresHeater, xpChance, ingredients);
    }

    public static void addOvenRecipe(ItemStack output, boolean[] conditions, boolean requiresHeater, float xpChance, OvenbakingRecipe.IIngredientMatcher... ingredients) {
        if (checkConditions(conditions)) return;
        OvenbakingRecipe.baking().registerRecipe(output, requiresHeater, xpChance, ingredients);
    }

    @SuppressWarnings("unused")
    public static void addOvenRecipe(ItemStack output, boolean requiresHeater, float xpChance, OvenbakingRecipe.IIngredientMatcher... ingredients) {
        addOvenRecipe(output, new boolean[0], requiresHeater, xpChance, ingredients);
    }

    public static void removeFirstRecipeFor(Item item, int meta, boolean... conditions) {
        if (checkConditions(conditions)) return;
        RecipeRemover.removeFirstRecipeFor(item, meta);
    }

    public static void removeFirstRecipeFor(Item item, boolean... conditions) {
        removeFirstRecipeFor(item, -1, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeFirstRecipeFor(Block block, int meta, boolean... conditions) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), meta, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeFirstRecipeFor(Block block, boolean... conditions) {
        removeFirstRecipeFor(Item.getItemFromBlock(block), -1, conditions);
    }

    public static void removeAllRecipesFor(Item item, int meta, boolean... conditions) {
        if (checkConditions(conditions)) return;
        RecipeRemover.removeAllRecipesFor(item, meta);
    }

    public static void removeAllRecipesFor(Item item, boolean... conditions) {
        removeAllRecipesFor(item, -1, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Block block, int meta, boolean... conditions) {
        removeAllRecipesFor(Item.getItemFromBlock(block), meta, conditions);
    }

    public static void removeAllRecipesFor(Block block, boolean... conditions) {
        removeAllRecipesFor(Item.getItemFromBlock(block), -1, conditions);
    }

    public static void removeNumberedRecipesFor(Item item, int meta, int loopCount, boolean... conditions) {
        if (checkConditions(conditions)) return;
        RecipeRemover.removeNumberedRecipesFor(item, meta, loopCount);
    }

    @SuppressWarnings("unused")
    public static void removeNumberedRecipesFor(Item item, int loopCount, boolean... conditions) {
        removeNumberedRecipesFor(item, -1, loopCount, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeNumberedRecipesFor(Block block, int meta, int loopCount, boolean... conditions) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), meta, loopCount, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeNumberedRecipesFor(Block block, int loopCount, boolean... conditions) {
        removeNumberedRecipesFor(Item.getItemFromBlock(block), -1, loopCount, conditions);
    }
}
