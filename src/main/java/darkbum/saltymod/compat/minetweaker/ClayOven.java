
package darkbum.saltymod.compat.minetweaker;

import java.util.ArrayList;
import java.util.List;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import net.minecraft.item.ItemStack;

import darkbum.saltymod.util.OvenbakingRecipe;

@ZenClass("mods.saltymod.clayOven")
public class ClayOven {

    // =========================================================
    // Rezeptregistrierung
    // =========================================================

    @SuppressWarnings("unused")
    @ZenMethod
    public static void addRecipe(
        IItemStack output,
        boolean requiresHeater,
        double xpChance,
        IIngredient[] ingredients
    ) {
        addIngredientRecipe(
            output, requiresHeater, xpChance, ingredients
        );
    }

    // =========================================================
    // Gemeinsame Verarbeitung aller Zutaten
    // =========================================================

    private static void addIngredientRecipe(
        IItemStack output,
        boolean requiresHeater,
        double xpChance,
        IIngredient[] ingredients
    ) {
        if (ingredients == null || ingredients.length == 0) {
            throw new IllegalArgumentException(
                "Clay Oven recipe must contain at least one ingredient."
            );
        }

        if (ingredients.length > 4) {
            throw new IllegalArgumentException(
                "Clay Oven recipes cannot contain more than 4 ingredients."
            );
        }

        ItemStack outputStack = getItemStack(output);

        if (outputStack == null) {
            throw new IllegalArgumentException(
                "Clay Oven recipe output must be a valid item."
            );
        }

        List<OvenbakingRecipe.IIngredientMatcher> matchers =
            new ArrayList<>();

        for (int i = 0; i < ingredients.length; i++) {
            IIngredient ingredient = ingredients[i];

            if (ingredient == null) {
                throw new IllegalArgumentException(
                    "Clay Oven recipe ingredient at position "
                        + i + " must not be null."
                );
            }

            List<ItemStack> stacks = new ArrayList<>();

            for (IItemStack item : ingredient.getItems()) {
                ItemStack stack = getItemStack(item);

                if (stack != null) {
                    stacks.add(stack);
                }
            }

            if (stacks.isEmpty()) {
                throw new IllegalArgumentException(
                    "Clay Oven recipe ingredient at position "
                        + i + " contains no valid items."
                );
            }

            matchers.add(
                new OvenbakingRecipe.MultiStackIngredient(stacks)
            );
        }

        OvenbakingRecipe.OvenRecipe recipe =
            new OvenbakingRecipe.OvenRecipe(
                outputStack,
                requiresHeater,
                new ArrayList<>(matchers),
                (float) xpChance
            );

        MineTweakerAPI.apply(
            new ClayOvenActions.AddRecipeAction(recipe)
        );
    }

    // =========================================================
    // Rezept entfernen
    // =========================================================

    @SuppressWarnings("unused")
    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        ItemStack outputStack = getItemStack(output);

        if (outputStack == null) {
            throw new IllegalArgumentException(
                "Clay Oven recipe output must be a valid item."
            );
        }

        MineTweakerAPI.apply(
            new ClayOvenActions.RemoveRecipeAction(outputStack)
        );
    }

    // =========================================================
    // ItemStack-Konvertierung
    // =========================================================

    private static ItemStack getItemStack(IItemStack ingredient) {
        if (ingredient == null) {
            return null;
        }

        Object internal = ingredient.getInternal();

        if (internal instanceof ItemStack) {
            return ((ItemStack) internal).copy();
        }

        return null;
    }
}
