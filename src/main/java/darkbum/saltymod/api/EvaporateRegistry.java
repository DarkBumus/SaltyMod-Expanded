package darkbum.saltymod.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class EvaporateRegistry {
    private static final EvaporateRegistry instance = new EvaporateRegistry();

    public static EvaporateRegistry instance() {
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

    private Map evaporatingList = new HashMap<Object, Object>();

    public Map getEvaporatingList() {
        return this.evaporatingList;
    }

    private HashMap<List, Experience> experienceList = new HashMap<List, Experience>();

    public Map<List, Experience> getExperienceList() {
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
        if (fluid == null)
            return null;
        EvaporateResults ret = (EvaporateResults)this.evaporatingList.get(Arrays.asList(fluid));
        if (ret != null)
            return ret;
        return (EvaporateResults)this.evaporatingList.get(fluid);
    }

    public ItemStack getEvaporateItemStack(Fluid fluid) {
        EvaporateResults evaporateresults = getEvaporateResults(fluid);
        if (fluid == null || evaporateresults == null)
            return null;
        return evaporateresults.s;
    }

    public int getEvaporateFluidVolume(Fluid fluid) {
        EvaporateResults evaporateresults = getEvaporateResults(fluid);
        if (fluid == null || evaporateresults == null)
            return 0;
        return evaporateresults.v;
    }

    class Experience {
        public final float e;

        public Experience(float e) {
            this.e = e;
        }
    }

    public Experience getExperience(ItemStack stack) {
        if (stack == null)
            return null;
        Experience ret = this.experienceList.get(Arrays.asList(stack.getItem(), stack.getItemDamage()));
        if (ret != null)
            return ret;
        return this.experienceList.get(stack);
    }

    public float getEvaporateExperience(ItemStack stack) {
        Experience experiencecount = getExperience(stack);
        if (stack == null || experiencecount == null)
            return 0.0F;
        return experiencecount.e;
    }
}
