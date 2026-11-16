
package darkbum.saltymod.compat.minetweaker;

import java.util.ArrayList;
import java.util.List;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import net.minecraft.item.ItemStack;

import darkbum.saltymod.util.MachineUtilRegistry;
import darkbum.saltymod.util.PressingRecipe;

@ZenClass("mods.saltymod.press")
public class Press {

    // =========================================================
    // Rezeptregistrierung ohne Gefäß
    // =========================================================

    @SuppressWarnings("unused")
    @ZenMethod
    public static void addRecipe(
        IIngredient input,
        IItemStack output1,
        IItemStack output2,
        boolean requiresHeater,
        boolean requiresMill,
        boolean copyInputMeta
    ) {
        addPressingRecipe(
            input,
            output1,
            output2,
            requiresHeater,
            requiresMill,
            null,
            copyInputMeta
        );
    }

    // =========================================================
    // Rezeptregistrierung mit Gefäß
    // =========================================================

    @SuppressWarnings("unused")
    @ZenMethod
    public static void addRecipe(
        IIngredient input,
        IItemStack output1,
        IItemStack output2,
        boolean requiresHeater,
        boolean requiresMill,
        IItemStack vesselItem,
        boolean copyInputMeta
    ) {
        addPressingRecipe(
            input,
            output1,
            output2,
            requiresHeater,
            requiresMill,
            vesselItem,
            copyInputMeta
        );
    }

    // =========================================================
    // Gemeinsame Verarbeitung des Rezepts
    // =========================================================

    private static void addPressingRecipe(
        IIngredient input,
        IItemStack output1,
        IItemStack output2,
        boolean requiresHeater,
        boolean requiresMill,
        IItemStack vesselItem,
        boolean copyInputMeta
    ) {
        if (input == null) {
            throw new IllegalArgumentException(
                "Press recipe input must not be null."
            );
        }

        ItemStack outputStack1 = getItemStack(output1);
        ItemStack outputStack2 = getItemStack(output2);

        if (outputStack1 == null && outputStack2 == null) {
            throw new IllegalArgumentException(
                "Press recipe must have at least one valid output."
            );
        }

        ItemStack vesselStack = getItemStack(vesselItem);

        if (vesselItem != null && vesselStack == null) {
            throw new IllegalArgumentException(
                "Press recipe vessel must be a valid item."
            );
        }

        if (vesselStack != null
            && !MachineUtilRegistry.isValidVessel(vesselStack)) {
            throw new IllegalArgumentException(
                "Press recipe vessel must be a valid vessel."
            );
        }

        List<ItemStack> inputStacks = new ArrayList<>();

        for (IItemStack item : input.getItems()) {
            ItemStack stack = getItemStack(item);

            if (stack != null) {
                inputStacks.add(stack);
            }
        }

        if (inputStacks.isEmpty()) {
            throw new IllegalArgumentException(
                "Press recipe input contains no valid items."
            );
        }

        PressingRecipe.IIngredientMatcher matcher =
            new PressingRecipe.MultiStackIngredient(inputStacks);

        PressingRecipe.PressRecipe recipe =
            new PressingRecipe.PressRecipe(
                matcher,
                outputStack1,
                outputStack2,
                requiresHeater,
                requiresMill,
                vesselStack,
                copyInputMeta
            );

        MineTweakerAPI.apply(
            new PressActions.AddRecipeAction(recipe)
        );
    }

    // =========================================================
    // Rezept entfernen
    // =========================================================

    @SuppressWarnings("unused")
    @ZenMethod
    public static void removeRecipe(IItemStack input) {
        ItemStack inputStack = getItemStack(input);

        if (inputStack == null) {
            MineTweakerAPI.logError("Press: Invalid recipe input.");
            return;
        }

        MineTweakerAPI.apply(new PressActions.RemoveRecipeAction(inputStack));
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
