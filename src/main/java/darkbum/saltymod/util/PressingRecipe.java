package darkbum.saltymod.util;

import com.github.bsideup.jabel.Desugar;
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
    * A record representing a press recipe in the press.
    */
    @Desugar
    public record PressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {

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
        recipes.put(input, new PressRecipe(input, output1, output2, requiresHeater, requiresMill, null));
    }

    public Set<Map.Entry<ItemStack, PressRecipe>> getRecipes() {
        return recipes.entrySet();
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
