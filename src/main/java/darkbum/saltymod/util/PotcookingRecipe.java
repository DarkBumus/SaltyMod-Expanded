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
    private final List<PotRecipe> recipes = new ArrayList<>();

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
    @Desugar
    public record StackIngredient(ItemStack stack) implements IIngredientMatcher {

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

        public List<ItemStack> getOres() {
            return OreDictionary.getOres(oreName);
        }
    }

    /**
     * Creates a new StackIngredient matcher.
     */
    public static StackIngredient stack(ItemStack stack) {
        return new StackIngredient(stack);
    }

    @Desugar
    public record MultiStackIngredient(List<ItemStack> stacks) implements IIngredientMatcher {

            public MultiStackIngredient(List<ItemStack> stacks) {
                this.stacks = new ArrayList<>();

                for (ItemStack stack : stacks) {
                    if (stack != null) {
                        this.stacks.add(stack.copy());
                    }
                }
            }

            @Override
            public boolean matches(ItemStack input) {
                for (ItemStack stack : stacks) {
                    if (areStacksEqual(stack, input)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public List<ItemStack> stacks() {
                List<ItemStack> result = new ArrayList<>();

                for (ItemStack stack : stacks) {
                    result.add(stack.copy());
                }

                return result;
            }
        }

    /**
     * Creates a new OreIngredient matcher.
     */
    public static OreIngredient ore(String name) {
        return new OreIngredient(name);
    }

    /**
     * Gets the singleton instance of the PotcookingRecipe manager.
     */
    public static PotcookingRecipe cooking() {
        return potBase;
    }

    /**
     * A record representing a cooking recipe in the pot.
     */
    @Desugar
    public record PotRecipe(
        ItemStack output,
        boolean requiresHeater,
        List<IIngredientMatcher> ingreds,
        float xpChance,
        boolean isBucketRecipe
    ) {

        public boolean shouldSpawnXp() {
            return Math.random() < xpChance;
        }
    }

    @Desugar
    public record RemovedRecipe(int index, PotRecipe recipe) {
    }

    /**
     * Registers a new cooking recipe with an optional bucket recipe flag.
     */

    public void registerRecipe(
        ItemStack output,
        boolean requiresHeater,
        float xpChance,
        boolean isBucketRecipe,
        IIngredientMatcher... ingredMatchers
    ) {
        List<IIngredientMatcher> ingredList = new ArrayList<>(Arrays.asList(ingredMatchers));

        registerRecipe(new PotRecipe(
            output,
            requiresHeater,
            ingredList,
            xpChance,
            isBucketRecipe
        ));
    }

    public void registerRecipe(PotRecipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(PotRecipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i) == recipe) {
                recipes.remove(i);
                return;
            }
        }
    }

    public List<RemovedRecipe> removeRecipesByOutput(ItemStack output) {
        List<RemovedRecipe> removed = new ArrayList<>();

        for (int i = recipes.size() - 1; i >= 0; i--) {
            PotRecipe recipe = recipes.get(i);

            if (areOutputsEqual(recipe.output(), output)) {
                removed.add(new RemovedRecipe(i, recipe));
                recipes.remove(i);
            }
        }

        Collections.reverse(removed);

        return removed;
    }

    public void restoreRecipes(List<RemovedRecipe> removedRecipes) {
        for (RemovedRecipe removed : removedRecipes) {
            int index = Math.min(removed.index(), recipes.size());

            recipes.add(index, removed.recipe());
        }
    }

    private static boolean areOutputsEqual(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) {
            return false;
        }

        return stack1.getItem() == stack2.getItem()
            && (stack1.getItemDamage() == WILDCARD_VALUE
            || stack2.getItemDamage() == WILDCARD_VALUE
            || stack1.getItemDamage() == stack2.getItemDamage())
            && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }


    /**
     * Returns all registered recipes.
     */
    public List<PotRecipe> getRecipes() {
        return Collections.unmodifiableList(recipes);
    }

    /**
     * Retrieves a matching recipe based on the given input ingredients.
     */
    public PotRecipe getRecipeFor(List<ItemStack> ingreds) {
        for (PotRecipe recipe : recipes) {

            if (recipe.ingreds().size() != ingreds.size()) {
                continue;
            }

            boolean[] matchedIngreds = new boolean[recipe.ingreds().size()];
            boolean matchFound = true;

            for (ItemStack ingred : ingreds) {
                boolean ingredMatched = false;

                for (int j = 0; j < recipe.ingreds().size(); j++) {
                    if (recipe.ingreds().get(j) == null) continue;

                    if (!matchedIngreds[j] && recipe.ingreds().get(j).matches(ingred)) {
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
     */
    private static boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) return false;

        return stack2.getItem() == stack1.getItem()
            && (stack1.getItemDamage() == WILDCARD_VALUE
            || stack2.getItemDamage() == stack1.getItemDamage())
            && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }
}
