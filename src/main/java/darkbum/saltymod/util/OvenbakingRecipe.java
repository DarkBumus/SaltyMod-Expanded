package darkbum.saltymod.util;

import com.github.bsideup.jabel.Desugar;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

import static net.minecraftforge.oredict.OreDictionary.*;

/**
 * Utility class for the management and processing of oven baking recipes.
 * Recipes can be registered using item stacks or OreDictionary entries.
 * Each recipe can specify whether it requires a heater and a chance to drop experience.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class OvenbakingRecipe {
    private static final OvenbakingRecipe ovenBase = new OvenbakingRecipe();
    private final Map<ItemStack, OvenRecipe> recipes = new HashMap<>();

    /**
     * Interface for ingredient matching in oven recipes.
     */
    public interface IIngredientMatcher {

        /**
         * Checks whether the given ItemStack matches the ingredient criteria.
         *
         * @param stack The ItemStack to be checked.
         * @return true, if the stack matches, false otherwise.
         */
        boolean matches(ItemStack stack);
    }

    /**
     * Ingredient matcher that checks for a specific ItemStack.
     */
    public static class StackIngredient implements IIngredientMatcher {
        private final ItemStack stack;

        /**
         * Constructs a new StackIngredient matcher.
         *
         * @param stack The ItemStack to match.
         */
        public StackIngredient(ItemStack stack) {
            this.stack = stack;
        }

        @Override
        public boolean matches(ItemStack input) {
            return areStacksEqual(stack, input);
        }
    }

    /**
     * Ingredient matcher that checks for OreDictionary entries.
     */
    public static class OreIngredient implements IIngredientMatcher {
        private final String oreName;

        /**
         * Constructs a new OreIngredient matcher.
         *
         * @param oreName The OreDictionary entry to match.
         */
        public OreIngredient(String oreName) {
            this.oreName = oreName;
        }

        @Override
        public boolean matches(ItemStack input) {
            List<ItemStack> ores = OreDictionary.getOres(oreName);
            for (ItemStack oreStack : ores) {
                if (input != null && areStacksEqual(oreStack, input)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Creates a new StackIngredient matcher.
     *
     * @param stack The ItemStack to match.
     * @return a new StackIngredient instance.
     */
    public static StackIngredient stack(ItemStack stack) {
        return new StackIngredient(stack);
    }

    /**
     * Creates a new OreIngredient matcher.
     *
     * @param name The OreDictionary entry to match.
     * @return a new OreIngredient instance.
     */
    public static OreIngredient ore(String name) {
        return new OreIngredient(name);
    }

    /**
     * Returns the singleton instance of the OvenbakingRecipe manager.
     *
     * @return the OvenbakingRecipe instance.
     */
    public static OvenbakingRecipe baking() {
        return ovenBase;
    }

    /**
     * A record representing a baking recipe in the oven.
     */
    @Desugar
    public record OvenRecipe(ItemStack output, boolean requiresHeater, List<IIngredientMatcher> ingreds, float xpChance) {

        /**
         * Determines if experience should be dropped based on the xpChance value.
         *
         * @return true, if experience should be dropped, false otherwise.
         */
        public boolean shouldSpawnXp() {
                return Math.random() < xpChance;
            }
        }

    /**
     * Registers a new baking recipe.
     *
     * @param output        The resulting ItemStack.
     * @param requiresHeater True if the recipe requires a heater to function.
     * @param xpChance      The chance for experience to drop upon successful baking.
     * @param ingredMatchers The ingredient matchers defining the recipe inputs.
     */
    public void registerRecipe(ItemStack output, boolean requiresHeater, float xpChance, IIngredientMatcher... ingredMatchers) {
        List<IIngredientMatcher> ingredList = Arrays.asList(ingredMatchers);
        recipes.put(output, new OvenRecipe(output, requiresHeater, ingredList, xpChance));
    }

    /**
     * Retrieves a recipe based on the given input ingredients.
     *
     * @param ingreds The list of input ItemStacks.
     * @return the matching OvenRecipe, or null if no match is found.
     */
    public OvenRecipe getRecipeFor(List<ItemStack> ingreds) {
        for (Map.Entry<ItemStack, OvenRecipe> entry : recipes.entrySet()) {
            OvenRecipe recipe = entry.getValue();

            if (recipe.ingreds.size() != ingreds.size()) {
                continue;
            }

            boolean[] matchedIngreds = new boolean[recipe.ingreds.size()];
            boolean matchFound = true;

            for (ItemStack ingred : ingreds) {
                boolean ingredMatched = false;
                for (int j = 0; j < recipe.ingreds.size(); j++) {
                    if (!matchedIngreds[j] && recipe.ingreds.get(j).matches(ingred)) {
                        matchedIngreds[j] = true;
                        ingredMatched = true;
                        break;
                    }
                }
                if (!ingredMatched) {
                    matchFound = false;
                    break;
                }
            }

            if (matchFound) {
                return recipe;
            }
        }
        return null;
    }

    /**
     * Compares two ItemStacks for equality, considering both item type and metadata.
     *
     * @param stack1 The first ItemStack.
     * @param stack2 The second ItemStack.
     * @return true, if the stacks are considered equal, false otherwise.
     */
    private static boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) return false;
        return stack2.getItem() == stack1.getItem() &&
            (stack2.getItemDamage() == WILDCARD_VALUE || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
