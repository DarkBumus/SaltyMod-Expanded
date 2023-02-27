package darkbum.saltmod.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class ExtractRegistry {
    private static final ExtractRegistry instance = new ExtractRegistry();

    public static ExtractRegistry instance() {
        return instance;
    }

    public void addExtracting(Fluid fluid, ItemStack stack, int vol, float exp) {
        this.extractingList.put(fluid, new ExtractResults(stack, vol));
        this.experienceList.put(Arrays.asList(new Object[] { stack.getItem(), Integer.valueOf(stack.getItemDamage()) } ), new Experience(exp));
    }

    public void addExtracting(Fluid fluid, Item item, int vol, float exp) {
        addExtracting(fluid, new ItemStack(item, 1), vol, exp);
    }

    public void addExtracting(Fluid fluid, Block block, int vol, float exp) {
        addExtracting(fluid, Item.getItemFromBlock(block), vol, exp);
    }

    private Map extractingList = new HashMap<Object, Object>();

    public Map getExtractingList() {
        return this.extractingList;
    }

    private HashMap<List, Experience> experienceList = new HashMap<List, Experience>();

    public Map<List, Experience> getExperienceList() {
        return this.experienceList;
    }

    class ExtractResults {
        public final ItemStack s;

        public final int v;

        public ExtractResults(ItemStack s, int v) {
            this.s = s;
            this.v = v;
        }
    }

    public ExtractResults getExtractResults(Fluid fluid) {
        if (fluid == null)
            return null;
        ExtractResults ret = (ExtractResults)this.extractingList.get(Arrays.asList(new Fluid[] { fluid }));
        if (ret != null)
            return ret;
        return (ExtractResults)this.extractingList.get(fluid);
    }

    public ItemStack getExtractItemStack(Fluid fluid) {
        ExtractResults extractresults = getExtractResults(fluid);
        if (fluid == null || extractresults == null)
            return null;
        return extractresults.s;
    }

    public int getExtractFluidVolum(Fluid fluid) {
        ExtractResults extractresults = getExtractResults(fluid);
        if (fluid == null || extractresults == null)
            return 0;
        return extractresults.v;
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
        Experience ret = this.experienceList.get(Arrays.asList(new Object[] { stack.getItem(), Integer.valueOf(stack.getItemDamage()) }));
        if (ret != null)
            return ret;
        return this.experienceList.get(stack);
    }

    public float getExtractExperience(ItemStack stack) {
        Experience experiencecount = getExperience(stack);
        if (stack == null || experiencecount == null)
            return 0.0F;
        return experiencecount.e;
    }
}
