package darkbum.saltymod.api;

import net.minecraft.item.ItemStack;

import java.util.*;

public class PressingRecipe {

    private static final PressingRecipe pressBase = new PressingRecipe();

    private final Map<ItemStack, PressRecipe> recipes = new HashMap<>();

    public static PressingRecipe pressing() {
        return pressBase;
    }

    public static class PressRecipe {
        public final ItemStack input;
        public final ItemStack output1;
        public final ItemStack output2;
        public final boolean requiresHeater;
        public final boolean requiresMill; // Neues Flag für "Mühle erforderlich"
        public final ItemStack vesselItem;

        public PressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {
            this.input = input;
            this.output1 = output1;
            this.output2 = output2;
            this.requiresHeater = requiresHeater;
            this.requiresMill = requiresMill; // Mill setzen
            this.vesselItem = vesselItem;
        }

        public PressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
            this(input, output1, output2, requiresHeater, requiresMill, null);
        }

        public boolean requiresVessel() {
            return vesselItem != null;
        }
    }

    public void registerRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack vesselItem) {
        recipes.put(input, new PressRecipe(input, output1, output2, requiresHeater, requiresMill, vesselItem));
    }

    public void registerRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
        recipes.put(input, new PressRecipe(input, output1, output2, requiresHeater, requiresMill));
    }

    public PressRecipe getRecipeFor(ItemStack input, ItemStack vessel) {
        for (Map.Entry<ItemStack, PressRecipe> entry : recipes.entrySet()) {
            PressRecipe recipe = entry.getValue();
            if (areStacksEqual(input, entry.getKey())) {
                if (recipe.requiresVessel() && (vessel == null || !MachineUtilRegistry.isValidVessel(vessel))) {
                    return null;
                }
                return recipe;
            }
        }
        return null;
    }

    private boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() &&
            (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
