package darkbum.saltymod.util;

import com.github.bsideup.jabel.Desugar;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

import static net.minecraftforge.oredict.OreDictionary.*;

/**
 * Utility class for the management and processing of pot cooking recipes.
 * Recipes can be registered using item stacks or OreDictionary entries.
 * Each recipe can specify whether it requires a heater and a chance to drop experience.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class PotcookingRecipe {
    private static final PotcookingRecipe potBase = new PotcookingRecipe();
    private final Map<ItemStack, PotRecipe> recipes = new HashMap<>();

    /**
     * Interface for ingredient matching in pot cooking recipes.
     */
    public interface IIngredientMatcher {

        /**
         * Checks if the given ItemStack matches the ingredient criteria.
         *
         * @param stack The ItemStack to check.
         * @return true, if the stack matches, false otherwise.
         */
        boolean matches(ItemStack stack);
    }

    /**
     * Ingredient matcher for specific ItemStacks.
     */
    public static class StackIngredient implements IIngredientMatcher {
        private final ItemStack stack;

        /**
         * Creates a new StackIngredient matcher.
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
     * Ingredient matcher for OreDictionary entries.
     */
    public static class OreIngredient implements IIngredientMatcher {
        private final String oreName;

        /**
         * Creates a new OreIngredient matcher.
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
     * Gets the singleton instance of the PotcookingRecipe manager.
     *
     * @return the PotcookingRecipe instance.
     */
    public static PotcookingRecipe cooking() {
        return potBase;
    }

    /**
     * A record representing a baking recipe in the pot.
     */
    @Desugar
    public record PotRecipe(ItemStack output, boolean requiresHeater, List<IIngredientMatcher> ingreds, float xpChance) {

        /**
         * Determines if experience should drop based on the xpChance value.
         *
         * @return true, if experience should drop, false otherwise.
         */
        public boolean shouldSpawnXp() {
                return Math.random() < xpChance;
            }
        }

    /**
     * Registers a new cooking recipe.
     *
     * @param output         The resulting ItemStack.
     * @param requiresHeater True if the recipe requires a heat source.
     * @param xpChance       The chance for experience to drop upon successful cooking.
     * @param ingredMatchers The ingredient matchers for the recipe inputs.
     */
    public void registerRecipe(ItemStack output, boolean requiresHeater, float xpChance, IIngredientMatcher... ingredMatchers) {
        List<IIngredientMatcher> ingredList = Arrays.asList(ingredMatchers);
        recipes.put(output, new PotRecipe(output, requiresHeater, ingredList, xpChance));
    }

    /**
     * Retrieves a matching recipe based on the given input ingredients.
     *
     * @param ingreds The list of input ItemStacks.
     * @return the matching PotRecipe, or null if no recipe is found.
     */
    public PotRecipe getRecipeFor(List<ItemStack> ingreds) {
        for (Map.Entry<ItemStack, PotRecipe> entry : recipes.entrySet()) {
            PotRecipe recipe = entry.getValue();

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
     * Compares two ItemStacks for equality based on item type and damage value.
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
