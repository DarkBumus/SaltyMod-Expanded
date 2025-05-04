package darkbum.saltymod.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class EvaporatingRecipe {

    public static final EvaporatingRecipe instance = new EvaporatingRecipe();

    public static EvaporatingRecipe instance() {
        return instance;
    }

    public void addEvaporating(Fluid fluid, ItemStack stack, int vol, float exp) {
        this.evaporatingList.put(fluid, new EvaporateResults(stack, vol));
        this.experienceList.put(Arrays.asList(stack.getItem(), stack.getItemDamage()), new Experience(exp));
    }

    public void addEvaporating(Fluid fluid, Item item, int vol, float exp) {
        addEvaporating(fluid, new ItemStack(item, 1), vol, exp);
    }

    public void addEvaporating(Fluid fluid, Block block, int vol, float exp) {
        addEvaporating(fluid, Item.getItemFromBlock(block), vol, exp);
    }

    private Map<Fluid, EvaporateResults> evaporatingList = new HashMap<>();
    private Map<List<Object>, Experience> experienceList = new HashMap<>();

    public Map<Fluid, EvaporateResults> getEvaporatingList() {
        return this.evaporatingList;
    }

    public Map<List<Object>, Experience> getExperienceList() {
        return this.experienceList;
    }

    class EvaporateResults {

        public final ItemStack s;
        public final int v;

        public EvaporateResults(ItemStack s, int v) {
            this.s = s;
            this.v = v;
        }
    }

    public EvaporateResults getEvaporateResults(Fluid fluid) {
        if (fluid == null) return null;
        return this.evaporatingList.get(fluid);
    }

    public ItemStack getEvaporateItemStack(Fluid fluid) {
        EvaporateResults evaporateresults = getEvaporateResults(fluid);
        if (fluid == null || evaporateresults == null) return null;
        return evaporateresults.s;
    }

    public int getEvaporateFluidVolume(Fluid fluid) {
        EvaporateResults evaporateresults = getEvaporateResults(fluid);
        if (fluid == null || evaporateresults == null) return 0;
        return evaporateresults.v;
    }

    class Experience {

        public final float e;

        public Experience(float e) {
            this.e = e;
        }
    }

    public Experience getExperience(ItemStack stack) {
        if (stack == null) return null;
        return this.experienceList.get(Arrays.asList(stack.getItem(), stack.getItemDamage()));
    }

    public float getEvaporateExperience(ItemStack stack) {
        Experience experiencecount = getExperience(stack);
        if (stack == null || experiencecount == null) return 0.0F;
        return experiencecount.e;
    }
}
