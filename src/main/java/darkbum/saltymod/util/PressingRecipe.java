
package darkbum.saltymod.util;

import com.github.bsideup.jabel.Desugar;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

import static net.minecraftforge.oredict.OreDictionary.*;

public class PressingRecipe {
    private static final PressingRecipe pressBase = new PressingRecipe();
    private final List<PressRecipe> recipes = new ArrayList<>();

    public static PressingRecipe pressing() {
        return pressBase;
    }

    /**
     * Interface for input ingredient matching.
     */
    public interface IIngredientMatcher {
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
         * Ingredient matcher for multiple alternative ItemStacks.
         */

        @Desugar
        public record MultiStackIngredient(List<ItemStack> stacks) implements IIngredientMatcher {
            public MultiStackIngredient(List<ItemStack> stacks) {
                this.stacks = new ArrayList<>();

                for (ItemStack stack : stacks) {
                    this.stacks.add(stack.copy());
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
     * Creates a StackIngredient matcher.
     */
    public static StackIngredient stack(ItemStack stack) {
        return new StackIngredient(stack);
    }

    /**
     * Creates an OreIngredient matcher.
     */
    public static OreIngredient ore(String name) {
        return new OreIngredient(name);
    }

    /**
     * Recipe definition.
     */
    @Desugar
    public record PressRecipe(
        IIngredientMatcher input,
        ItemStack output1,
        ItemStack output2,
        boolean requiresHeater,
        boolean requiresMill,
        ItemStack vesselItem,
        boolean copyInputMeta
    ) {

        public boolean requiresVessel() {
            return vesselItem != null;
        }
    }

    /**
     * Registers a new pressing recipe with a vessel.
     */
    public void registerRecipe(
        IIngredientMatcher input,
        ItemStack output1,
        ItemStack output2,
        boolean requiresHeater,
        boolean requiresMill,
        ItemStack vesselItem,
        boolean copyInputMeta
    ) {
        recipes.add(new PressRecipe(
            input,
            output1,
            output2,
            requiresHeater,
            requiresMill,
            vesselItem,
            copyInputMeta
        ));
    }

    /**
     * Registers a new pressing recipe without a vessel.
     */
    public void registerRecipe(
        IIngredientMatcher input,
        ItemStack output1,
        ItemStack output2,
        boolean requiresHeater,
        boolean requiresMill
    ) {
        registerRecipe(input, output1, output2, requiresHeater, requiresMill, null, false);
    }

    public void registerRecipe(PressRecipe recipe) {
        recipes.add(recipe);
    }


    /**
     * Removes a recipe by its exact object identity.
     */
    public void removeRecipe(PressRecipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i) == recipe) {
                recipes.remove(i);
                return;
            }
        }
    }

    public List<RemovedRecipe> removeRecipesByInput(ItemStack input) {
        List<RemovedRecipe> removedRecipes = new ArrayList<>();

        for (int i = recipes.size() - 1; i >= 0; i--) {
            PressRecipe recipe = recipes.get(i);

            if (recipe.input() != null && recipe.input().matches(input)) {
                removedRecipes.add(new RemovedRecipe(i, recipe));
                recipes.remove(i);
            }
        }

        Collections.reverse(removedRecipes);
        return removedRecipes;
    }

    /**
     * Restores previously removed recipes at their original positions.
     */
    public void restoreRecipes(List<RemovedRecipe> removedRecipes) {
        for (RemovedRecipe removed : removedRecipes) {
            int index = Math.min(removed.index(), recipes.size());
            recipes.add(index, removed.recipe());
        }
    }

    @SuppressWarnings("unused")
    private static boolean areOutputsEqual(
        ItemStack stack1,
        ItemStack stack2
    ) {
        if (stack1 == null || stack2 == null) {
            return false;
        }

        return stack1.isItemEqual(stack2)
            && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }

    @Desugar
    public record RemovedRecipe(int index, PressRecipe recipe) {
    }

    /**
     * Returns all registered recipes.
     */
    public List<PressRecipe> getRecipes() {
        return Collections.unmodifiableList(recipes);
    }


    /**
     * Retrieves a matching recipe, including machine and vessel requirements.
     */
    public PressRecipe getRecipeFor(
        ItemStack input,
        ItemStack vessel,
        boolean isHeaterNearby,
        boolean isMillNearby
    ) {
        for (PressRecipe recipe : recipes) {

            if (recipe.input() == null || !recipe.input().matches(input)) {
                continue;
            }

            if (recipe.requiresHeater() != isHeaterNearby) {
                continue;
            }

            if (recipe.requiresMill() != isMillNearby) {
                continue;
            }

            if (recipe.requiresVessel()) {
                if (!MachineUtilRegistry.isValidVessel(vessel)
                    || vessel.getItem() != recipe.vesselItem().getItem()) {
                    continue;
                }
            }

            return recipe;
        }

        return null;
    }


    /**
     * Compares two ItemStacks.
     */
    private static boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) return false;

        return stack2.getItem() == stack1.getItem()
            && (stack1.getItemDamage() == WILDCARD_VALUE
            || stack2.getItemDamage() == stack1.getItemDamage())
            && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }
}
