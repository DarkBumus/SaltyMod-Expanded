package darkbum.saltymod.util;

import net.minecraft.item.ItemStack;

import java.util.*;

import static net.minecraftforge.oredict.OreDictionary.*;

/**
 * Utility class for handlung recipes for the press.
 * Recipes can include up to two output items, a vessel requirement, and optional heater/mill requirements.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class PressingRecipe {
    private static final PressingRecipe pressBase = new PressingRecipe();
    private final Map<ItemStack, PressRecipe> recipes = new HashMap<>();

    /**
     * Retrieves the singleton instance of the PressingRecipe manager.
     *
     * @return the PressingRecipe instance.
     */
    public static PressingRecipe pressing() {
        return pressBase;
    }

    /**
     * Represents a recipe for the pressing machine.
     * A recipe can produce up to two output items and may require a vessel, heater, or mill.
     */
    public static class PressRecipe {
        public final ItemStack input;
        public final ItemStack output1;
        public final ItemStack output2;
        public final boolean requiresHeater;
        public final boolean requiresMill;
        public final ItemStack vesselItem;

        /**
         * Creates a new press recipe with a vessel requirement.
         *
         * @param input         The input ItemStack.
         * @param output1       The primary output ItemStack.
         * @param output2       The secondary output ItemStack.
         * @param requiresHeater Whether a heater is required.
         * @param requiresMill  Whether a mill is required.
         * @param vesselItem    The vessel ItemStack, or null if no vessel is required.
         */
        public PressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {
            this.input = input;
            this.output1 = output1;
            this.output2 = output2;
            this.requiresHeater = requiresHeater;
            this.requiresMill = requiresMill;
            this.vesselItem = vesselItem;
        }

        /**
         * Creates a new press recipe without a vessel requirement.
         *
         * @param input         The input ItemStack.
         * @param output1       The primary output ItemStack.
         * @param output2       The secondary output ItemStack.
         * @param requiresHeater Whether a heater is required.
         * @param requiresMill  Whether a mill is required.
         */
        public PressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
            this(input, output1, output2, requiresHeater, requiresMill, null);
        }

        /**
         * Checks if the recipe requires a vessel item.
         *
         * @return true, if a vessel item is required, false otherwise.
         */
        public boolean requiresVessel() {
            return vesselItem != null;
        }
    }

    /**
     * Registers a new pressing recipe with a vessel requirement.
     *
     * @param input         The input ItemStack.
     * @param output1       The primary output ItemStack.
     * @param output2       The secondary output ItemStack.
     * @param requiresHeater Whether a heater is required.
     * @param requiresMill  Whether a mill is required.
     * @param vesselItem    The vessel ItemStack, or null if no vessel is required.
     */
    public void registerRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {
        recipes.put(input, new PressRecipe(input, output1, output2, requiresHeater, requiresMill, vesselItem));
    }

    public void registerRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
        recipes.put(input, new PressRecipe(input, output1, output2, requiresHeater, requiresMill));
    }

    /**
     * Retrieves the recipe for the given input and vessel items.
     *
     * @param input  The input ItemStack.
     * @param vessel The vessel ItemStack, or null if no vessel is provided.
     * @return the corresponding PressRecipe, or null if no valid recipe is found.
     */
    public PressRecipe getRecipeFor(ItemStack input, ItemStack vessel) {
        for (Map.Entry<ItemStack, PressRecipe> entry : recipes.entrySet()) {
            PressRecipe recipe = entry.getValue();
            if (areStacksEqual(input, entry.getKey())) {
                if (recipe.requiresVessel() && (!MachineUtilRegistry.isValidVessel(vessel))) {
                    return null;
                }
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
    private boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() &&
            (stack2.getItemDamage() == WILDCARD_VALUE || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
