
package darkbum.saltymod.compat.minetweaker;

import java.util.ArrayList;
import java.util.List;

import minetweaker.IUndoableAction;

import net.minecraft.item.ItemStack;

import darkbum.saltymod.util.PressingRecipe;

public class PressActions {

    /**
     * Adds a Press recipe and removes it again when undone.
     */
    public static class AddRecipeAction implements IUndoableAction {

        private final PressingRecipe.PressRecipe recipe;

        public AddRecipeAction(PressingRecipe.PressRecipe recipe) {
            this.recipe = recipe;
        }

        @Override
        public void apply() {
            PressingRecipe.pressing().registerRecipe(recipe);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            PressingRecipe.pressing().removeRecipe(recipe);
        }

        @Override
        public String describe() {
            return "Adding Press recipe for "
                + getOutputDescription(recipe);
        }

        @Override
        public String describeUndo() {
            return "Removing Press recipe for "
                + getOutputDescription(recipe);
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }
    }

    /**
     * Removes all Press recipes containing a matching output
     * and restores them when undone.
     */
    public static class RemoveRecipeAction implements IUndoableAction {

        private final ItemStack input;

        private List<PressingRecipe.RemovedRecipe> removedRecipes =
            new ArrayList<>();

        public RemoveRecipeAction(ItemStack input) {
            this.input = input.copy();
        }

        @Override
        public void apply() {
            removedRecipes =
                PressingRecipe.pressing().removeRecipesByInput(input);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            PressingRecipe.pressing().restoreRecipes(removedRecipes);
        }

        @Override
        public String describe() {
            return "Removing Press recipes for "
                + input.getDisplayName();
        }

        @Override
        public String describeUndo() {
            return "Restoring Press recipes for "
                + input.getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }
    }

    private static String getOutputDescription(
        PressingRecipe.PressRecipe recipe
    ) {
        String output1 = recipe.output1() != null
            ? recipe.output1().getDisplayName()
            : null;

        String output2 = recipe.output2() != null
            ? recipe.output2().getDisplayName()
            : null;

        if (output1 != null && output2 != null) {
            return output1 + " and " + output2;
        }

        return output1 != null ? output1 : output2;
    }
}
