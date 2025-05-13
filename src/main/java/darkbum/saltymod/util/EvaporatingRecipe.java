package darkbum.saltymod.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.bsideup.jabel.Desugar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

/**
 * Handles the registration and retrieval of evaporating recipes,
 * associating fluids with evaporation results and experience values.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EvaporatingRecipe {

    private static final EvaporatingRecipe INSTANCE = new EvaporatingRecipe();
    private final Map<Fluid, EvaporateResults> evaporatingList = new HashMap<>();
    private final Map<List<Object>, Experience> experienceList = new HashMap<>();

    /**
     * Retrieves the singleton instance of this class.
     *
     * @return the singleton instance.
     */
    public static EvaporatingRecipe instance() {
        return INSTANCE;
    }

    /**
     * Registers a new evaporation recipe.
     *
     * @param fluid The fluid to evaporate.
     * @param stack The resulting ItemStack.
     * @param vol   The amount of fluid consumed in millibuckets.
     * @param exp   The experience gained from the evaporation.
     */
    public void addEvaporating(Fluid fluid, ItemStack stack, int vol, float exp) {
        if (fluid != null && stack != null) {
            evaporatingList.put(fluid, new EvaporateResults(stack, vol));
            experienceList.put(Arrays.asList(stack.getItem(), stack.getItemDamage()), new Experience(exp));
        }
    }

    /**
     * Registers a new evaporation recipe using an Item instead of an ItemStack.
     *
     * @param fluid The fluid to evaporate.
     * @param item  The resulting Item.
     * @param vol   The amount of fluid consumed in millibuckets.
     * @param exp   The experience gained from the evaporation.
     */
    @SuppressWarnings("unused")
    public void addEvaporating(Fluid fluid, Item item, int vol, float exp) {
        addEvaporating(fluid, new ItemStack(item), vol, exp);
    }

    /**
     * Registers a new evaporation recipe using a Block.
     *
     * @param fluid The fluid to evaporate.
     * @param block The resulting Block.
     * @param vol   The amount of fluid consumed in millibuckets.
     * @param exp   The experience gained from the evaporation.
     */
    @SuppressWarnings("unused")
    public void addEvaporating(Fluid fluid, Block block, int vol, float exp) {
        addEvaporating(fluid, Item.getItemFromBlock(block), vol, exp);
    }

    /**
     * Retrieves the evaporation result for the specified fluid.
     *
     * @param fluid The fluid to check.
     * @return The evaporation result, or null if none exists.
     */
    private EvaporateResults getEvaporateResults(Fluid fluid) {
        return evaporatingList.get(fluid);
    }

    /**
     * Retrieves the resulting ItemStack from evaporating the specified fluid.
     *
     * @param fluid The fluid to check.
     * @return The resulting ItemStack, or null if none exists.
     */
    public ItemStack getEvaporateItemStack(Fluid fluid) {
        EvaporateResults result = getEvaporateResults(fluid);
        return result != null ? result.stack : null;
    }

    /**
     * Retrieves the amount of fluid consumed in millibuckets for the specified fluid.
     *
     * @param fluid The fluid to check.
     * @return The fluid volume in millibuckets, or 0 if none exists.
     */
    public int getEvaporateFluidVolume(Fluid fluid) {
        EvaporateResults result = getEvaporateResults(fluid);
        return result != null ? result.volume : 0;
    }

    /**
     * Retrieves the experience value for the specified ItemStack.
     *
     * @param stack The ItemStack to check.
     * @return The experience value, or 0.0F if none exists.
     */
    public float getEvaporateExperience(ItemStack stack) {
        Experience exp = getExperience(stack);
        return exp != null ? exp.value : 0.0F;
    }

    /**
     * Retrieves the experience wrapper for the specified ItemStack.
     *
     * @param stack The ItemStack to check.
     * @return The Experience object, or null if none exists.
     */
    private Experience getExperience(ItemStack stack) {
        if (stack == null) return null;
        return experienceList.get(Arrays.asList(stack.getItem(), stack.getItemDamage()));
    }

    /**
     * Retrieves the complete list of evaporation results.
     *
     * @return A map of fluids to evaporation results.
     */
    @SuppressWarnings("unused")
    private Map<Fluid, EvaporateResults> getEvaporatingList() {
        return evaporatingList;
    }

    /**
     * Retrieves the complete list of experience values.
     *
     * @return A map of item and metadata pairs to experience values.
     */
    @SuppressWarnings("unused")
    private Map<List<Object>, Experience> getExperienceList() {
        return experienceList;
    }

    /**
     * Wrapper class for evaporation results, consisting of an ItemStack and a fluid volume.
     *
     * @param stack  The resulting ItemStack from evaporation
     * @param volume The fluid volume consumed in millibuckets
     */
    @Desugar
    private record EvaporateResults(ItemStack stack, int volume) {

        /**
         * Constructs a new EvaporateResults instance.
         *
         * @param stack  The resulting ItemStack.
         * @param volume The fluid volume in millibuckets.
         */
        private EvaporateResults {
        }
    }

    /**
     * Wrapper class for experience values.
     *
     * @param value The experience value
     */
    @Desugar
    private record Experience(float value) {

        /**
         * Constructs a new Experience instance.
         *
         * @param value The experience value.
         */
        private Experience {
        }
    }
}
