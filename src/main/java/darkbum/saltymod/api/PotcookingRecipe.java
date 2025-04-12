package darkbum.saltymod.api;

import net.minecraft.item.ItemStack;

import java.util.*;

public class PotcookingRecipe {

    private static final PotcookingRecipe potBase = new PotcookingRecipe();

    private final Map<ItemStack, PotRecipe> recipes = new HashMap<>();

    public static PotcookingRecipe cooking() {
        return potBase;
    }

    public static class PotRecipe {
        public final ItemStack input;
        public final ItemStack output1;
        public final ItemStack output2;
        public final boolean requiresHeater;
        public final boolean requiresMill;
        public final ItemStack pinchItem;

        public PotRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack pinchItem) {
            this.input = input;
            this.output1 = output1;
            this.output2 = output2;
            this.requiresHeater = requiresHeater;
            this.requiresMill = requiresMill;
            this.pinchItem = pinchItem;
        }

        public PotRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
            this(input, output1, output2, requiresHeater, requiresMill, null);
        }

        public boolean requiresPinch() {
            return pinchItem != null;
        }
    }

    public void registerRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill, ItemStack pinchItem) {
        recipes.put(input, new PotRecipe(input, output1, output2, requiresHeater, requiresMill, pinchItem));
    }

    public void registerRecipe(ItemStack input, ItemStack output1, ItemStack output2, boolean requiresHeater, boolean requiresMill) {
        recipes.put(input, new PotRecipe(input, output1, output2, requiresHeater, requiresMill));
    }

    public PotRecipe getRecipeFor(ItemStack input, ItemStack pinch) {
        for (Map.Entry<ItemStack, PotRecipe> entry : recipes.entrySet()) {
            PotRecipe recipe = entry.getValue();
            if (areStacksEqual(input, entry.getKey())) {
                if (recipe.requiresPinch() && (pinch == null || !PotcookingRecipePinchRegistry.isValidPinch(pinch))) {
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
