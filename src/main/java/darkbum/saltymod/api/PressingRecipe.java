package darkbum.saltymod.api;

import net.minecraft.item.Item;
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
        public final boolean requiresFuel;

        public PressRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresFuel) {
            this.input = input;
            this.output1 = output1;
            this.output2 = output2;
            this.requiresHeater = requiresHeater;
            this.requiresFuel = requiresFuel;
        }
    }

    public void registerBlockRecipe(Item blockItem, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresFuel) {
        registerItemRecipe(blockItem, output1, output2, requiresHeater, requiresFuel);
    }

    public void registerItemRecipe(Item item, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresFuel) {
        ItemStack input = new ItemStack(item, 1, 32767);
        recipes.put(input, new PressRecipe(input, output1, output2, requiresHeater, requiresFuel));
    }

    public PressRecipe getRecipeFor(ItemStack input) {
        for (Map.Entry<ItemStack, PressRecipe> entry : recipes.entrySet()) {
            if (areStacksEqual(input, entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() &&
            (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
