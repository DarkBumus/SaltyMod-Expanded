
package darkbum.saltymod.compat.minetweaker;

import java.util.ArrayList;
import java.util.List;

import minetweaker.IUndoableAction;

import net.minecraft.item.ItemStack;

import darkbum.saltymod.util.OvenbakingRecipe;

public class ClayOvenActions {

    /**
     * Adds a Clay Oven recipe and removes it again when undone.
     */
    public static class AddRecipeAction implements IUndoableAction {

        private final OvenbakingRecipe.OvenRecipe recipe;

        public AddRecipeAction(OvenbakingRecipe.OvenRecipe recipe) {
            this.recipe = recipe;
        }

        @Override
        public void apply() {
            OvenbakingRecipe.baking().registerRecipe(recipe);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            OvenbakingRecipe.baking().removeRecipe(recipe);
        }

        @Override
        public String describe() {
            return "Adding Clay Oven recipe for "
                + recipe.output().getDisplayName();
        }

        @Override
        public String describeUndo() {
            return "Removing Clay Oven recipe for "
                + recipe.output().getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }
    }

    /**
     * Removes all Clay Oven recipes with a matching output
     * and restores them when undone.
     */
    public static class RemoveRecipeAction implements IUndoableAction {

        private final ItemStack output;

        private List<OvenbakingRecipe.RemovedRecipe> removedRecipes =
            new ArrayList<>();

        public RemoveRecipeAction(ItemStack output) {
            this.output = output.copy();
        }

        @Override
        public void apply() {
            removedRecipes =
                OvenbakingRecipe.baking().removeRecipesByOutput(output);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            OvenbakingRecipe.baking().restoreRecipes(removedRecipes);
        }

        @Override
        public String describe() {
            return "Removing Clay Oven recipes for "
                + output.getDisplayName();
        }

        @Override
        public String describeUndo() {
            return "Restoring Clay Oven recipes for "
                + output.getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }
    }
}
