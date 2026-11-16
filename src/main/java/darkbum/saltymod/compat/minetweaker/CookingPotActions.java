
package darkbum.saltymod.compat.minetweaker;

import java.util.ArrayList;
import java.util.List;

import minetweaker.IUndoableAction;
import net.minecraft.item.ItemStack;

import darkbum.saltymod.util.PotcookingRecipe;

public class CookingPotActions {

    /**
     * Adds a Cooking Pot recipe and removes it again when undone.
     */
    public static class AddRecipeAction implements IUndoableAction {

        private final PotcookingRecipe.PotRecipe recipe;

        public AddRecipeAction(PotcookingRecipe.PotRecipe recipe) {
            this.recipe = recipe;
        }

        @Override
        public void apply() {
            PotcookingRecipe.cooking().registerRecipe(recipe);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            PotcookingRecipe.cooking().removeRecipe(recipe);
        }

        @Override
        public String describe() {
            return "Adding Cooking Pot recipe for "
                + recipe.output().getDisplayName();
        }

        @Override
        public String describeUndo() {
            return "Removing Cooking Pot recipe for "
                + recipe.output().getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }
    }

    /**
     * Removes all Cooking Pot recipes with a matching output
     * and restores them when undone.
     */
    public static class RemoveRecipeAction implements IUndoableAction {

        private final ItemStack output;

        private List<PotcookingRecipe.RemovedRecipe> removedRecipes =
            new ArrayList<>();

        public RemoveRecipeAction(ItemStack output) {
            this.output = output.copy();
        }

        @Override
        public void apply() {
            removedRecipes =
                PotcookingRecipe.cooking().removeRecipesByOutput(output);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            PotcookingRecipe.cooking().restoreRecipes(removedRecipes);
        }

        @Override
        public String describe() {
            return "Removing Cooking Pot recipes for "
                + output.getDisplayName();
        }

        @Override
        public String describeUndo() {
            return "Restoring Cooking Pot recipes for "
                + output.getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }
    }
}
