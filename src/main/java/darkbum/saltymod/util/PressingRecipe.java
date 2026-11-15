
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
        ItemStack vesselItem
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
        ItemStack vesselItem
    ) {
        recipes.add(new PressRecipe(
            input,
            output1,
            output2,
            requiresHeater,
            requiresMill,
            vesselItem
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
        registerRecipe(input, output1, output2, requiresHeater, requiresMill, null);
    }

    /**
     * Returns all registered recipes.
     */
    public List<PressRecipe> getRecipes() {
        return Collections.unmodifiableList(recipes);
    }

    /**
     * Retrieves a matching recipe.
     */
    public PressRecipe getRecipeFor(ItemStack input, ItemStack vessel) {
        for (PressRecipe recipe : recipes) {

            if (recipe.input() == null || !recipe.input().matches(input)) {
                continue;
            }

            if (recipe.requiresVessel() && !MachineUtilRegistry.isValidVessel(vessel)) {
                continue;
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
            || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
