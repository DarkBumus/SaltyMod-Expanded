package darkbum.saltymod.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Utility class for conditionally registering various Minecraft items, blocks, recipes, and tile entities.
 * This class provides methods to register items, blocks, recipes, and other game components only if certain conditions are met.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public final class ConditionalRegistrar {

    /**
     * Checks whether any of the provided conditions are false.
     * If any condition is false, it returns true, meaning the conditions fail.
     * If all conditions are true, it returns false.
     *
     * @param conditions the conditions to check
     * @return true, if any condition is false, false otherwise
     */
    private static boolean checkConditions(boolean... conditions) {
        if (conditions == null) return false;
        for (boolean condition : conditions) {
            if (!condition) return true;
        }
        return false;
    }

    /**
     * Registers an ore in the OreDictionary if the provided conditions are met.
     *
     * @param oreName the name of the ore
     * @param item the item to register
     * @param conditions the conditions that must be true for registration
     */
    public static void registerOre(String oreName, Item item, boolean... conditions) {
        if (checkConditions(conditions)) return;
        OreDictionary.registerOre(oreName, item);
    }

    public static void registerOre(String oreName, ItemStack itemStack, boolean... conditions) {
        if (checkConditions(conditions)) return;
        OreDictionary.registerOre(oreName, itemStack);
    }

    /**
     * Registers an item with the specified name if the provided conditions are met.
     *
     * @param item the item to register
     * @param name the name of the item
     * @param conditions the conditions that must be true for registration
     */
    public static <T extends Item> void registerItem(T item, String name, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerItem(item, name);
    }

    /**
     * Registers a block with the specified name if the provided conditions are met.
     *
     * @param block the block to register
     * @param name the name of the block
     * @param conditions the conditions that must be true for registration
     */
    public static <T extends Block> void registerBlock(T block, String name, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerBlock(block, name);
    }

    public static <T extends Block> void registerBlock(T block, Class<? extends ItemBlock> itemBlockClass, String name, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerBlock(block, itemBlockClass, name);
    }

    /**
     * Registers a tile entity with the specified ID if the provided conditions are met.
     *
     * @param tileEntityClass the class of the tile entity
     * @param id the ID for the tile entity
     * @param conditions the conditions that must be true for registration
     */
    public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.registerTileEntity(tileEntityClass, id);
    }

    @SuppressWarnings("unused")
    public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, boolean... conditions) {
        String id = "tileEntity" + tileEntityClass.getSimpleName().replace("TileEntity", "");
        registerTileEntity(tileEntityClass, id, conditions);
    }

    /**
     * Adds a shapeless recipe to the game if the provided conditions are met.
     *
     * @param output the resulting item stack from the recipe
     * @param conditions the conditions that must be true for recipe registration
     * @param inputs the input items for the recipe
     */
    public static void addShapelessRecipe(ItemStack output, boolean[] conditions, Object... inputs) {
        if (checkConditions(conditions)) return;
        GameRegistry.addShapelessRecipe(output, inputs);
    }

    @SuppressWarnings("unused")
    public static void addShapelessRecipe(ItemStack output, Object... inputs) {
        addShapelessRecipe(output, new boolean[0], inputs);
    }

    /**
     * Adds a shapeless ore recipe to the game if the provided conditions are met.
     *
     * @param output the resulting item stack from the recipe
     * @param conditions the conditions that must be true for recipe registration
     * @param inputs the input items for the recipe
     */
    public static void addShapelessOreRecipe(ItemStack output, boolean[] conditions, Object... inputs) {
        if (checkConditions(conditions)) return;
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, inputs));
    }

    @SuppressWarnings("unused")
    public static void addShapelessOreRecipe(ItemStack output, Object... inputs) {
        addShapelessOreRecipe(output, new boolean[0], inputs);
    }

    /**
     * Adds a shaped recipe to the game if the provided conditions are met.
     *
     * @param output the resulting item stack from the recipe
     * @param ingredients the array of ingredients for the recipe
     * @param conditions the conditions that must be true for recipe registration
     */
    public static void addShapedRecipe(ItemStack output, Object[] ingredients, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.addRecipe(output, ingredients);
    }

    public static void addShapedOreRecipe(ItemStack output, Object[] ingredients, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.addRecipe(new ShapedOreRecipe(output, ingredients));
    }

    /**
     * Adds a smelting recipe to the game if the provided conditions are met.
     *
     * @param input the input item stack for the smelting recipe
     * @param output the resulting item stack from the smelting recipe
     * @param xp the experience gained from the smelting process
     * @param conditions the conditions that must be true for recipe registration
     */
    public static void addSmelting(ItemStack input, ItemStack output, float xp, boolean... conditions) {
        if (checkConditions(conditions)) return;
        GameRegistry.addSmelting(input, output, xp);
    }

    /**
     * Adds a cooking pot recipe to the game if the provided conditions are met.
     *
     * @param output the resulting item stack from the cooking pot recipe
     * @param conditions the conditions that must be true for recipe registration
     * @param requiresHeater whether the recipe requires a heater
     * @param xpChance the chance to gain experience from the recipe
     * @param ingredients the ingredient matchers for the recipe
     */
    public static void addPotRecipe(ItemStack output, boolean[] conditions, boolean requiresHeater, float xpChance, PotcookingRecipe.IIngredientMatcher... ingredients) {
        if (checkConditions(conditions)) return;
        PotcookingRecipe.cooking().registerRecipe(output, requiresHeater, xpChance, ingredients);
    }

    @SuppressWarnings("unused")
    public static void addPotRecipe(ItemStack output, boolean requiresHeater, float xpChance, PotcookingRecipe.IIngredientMatcher... ingredients) {
        addPotRecipe(output, new boolean[0], requiresHeater, xpChance, ingredients);
    }


    /**
     * Adds a clay oven recipe to the game if the provided conditions are met.
     *
     * @param output the resulting item stack from the clay oven recipe
     * @param conditions the conditions that must be true for recipe registration
     * @param requiresHeater whether the recipe requires a heater
     * @param xpChance the chance to gain experience from the recipe
     * @param ingredients the ingredient matchers for the recipe
     */
    public static void addOvenRecipe(ItemStack output, boolean[] conditions, boolean requiresHeater, float xpChance, OvenbakingRecipe.IIngredientMatcher... ingredients) {
        if (checkConditions(conditions)) return;
        OvenbakingRecipe.baking().registerRecipe(output, requiresHeater, xpChance, ingredients);
    }

    @SuppressWarnings("unused")
    public static void addOvenRecipe(ItemStack output, boolean requiresHeater, float xpChance, OvenbakingRecipe.IIngredientMatcher... ingredients) {
        addOvenRecipe(output, new boolean[0], requiresHeater, xpChance, ingredients);
    }

    /**
     * Adds a press recipe to the game if the provided conditions are met.
     *
     * @param input the input item stack for the press recipe
     * @param conditions the conditions that must be true for recipe registration
     * @param output1 the first output item stack from the press recipe
     * @param output2 the second output item stack from the press recipe
     * @param requiresHeater whether the recipe requires a heater
     * @param requiresMill whether the recipe requires a mill
     * @param vesselItem the item required for the vessel in the press
     */
    public static void addPressRecipe(ItemStack input, boolean[] conditions, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {
        if (checkConditions(conditions)) return;
        PressingRecipe.pressing().registerRecipe(input, output1, output2, requiresHeater, requiresMill, vesselItem);
    }

    @SuppressWarnings("unused")
    public static void addPressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {
        addPressRecipe(input, new boolean[0], output1, output2, requiresHeater, requiresMill, vesselItem);
    }

    public static void addPressRecipe(ItemStack input, boolean[] conditions, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
        if (checkConditions(conditions)) return;
        PressingRecipe.pressing().registerRecipe(input, output1, output2, requiresHeater, requiresMill);
    }

    @SuppressWarnings("unused")
    public static void addPressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
        addPressRecipe(input, new boolean[0], output1, output2, requiresHeater, requiresMill);
    }

    /**
     * Removes the first recipe for a specific item and metadata, based on conditions.
     *
     * @param item the item to remove the recipe for
     * @param meta the metadata of the item to remove the recipe for
     * @param conditions the conditions to check before removing the recipe
     */
    public static void removeFirstRecipeFor(Item item, int meta, boolean... conditions) {
        if (checkConditions(conditions)) return;
        RecipeRemover.removeFirstRecipeFor(item, meta);
    }

    @SuppressWarnings("unused")
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

    /**
     * Removes all recipes for a specific item and metadata, based on conditions.
     *
     * @param item the item to remove all recipes for
     * @param meta the metadata of the item to remove all recipes for
     * @param conditions the conditions to check before removing the recipes
     */
    public static void removeAllRecipesFor(Item item, int meta, boolean... conditions) {
        if (checkConditions(conditions)) return;
        RecipeRemover.removeAllRecipesFor(item, meta);
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Item item, boolean... conditions) {
        removeAllRecipesFor(item, -1, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Block block, int meta, boolean... conditions) {
        removeAllRecipesFor(Item.getItemFromBlock(block), meta, conditions);
    }

    @SuppressWarnings("unused")
    public static void removeAllRecipesFor(Block block, boolean... conditions) {
        removeAllRecipesFor(Item.getItemFromBlock(block), -1, conditions);
    }

    /**
     * Removes a specific number of recipes for an item and metadata, based on conditions.
     *
     * @param item the item to remove recipes for
     * @param meta the metadata of the item to remove recipes for
     * @param loopCount the number of recipes to remove
     * @param conditions the conditions to check before removing the recipes
     */
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
