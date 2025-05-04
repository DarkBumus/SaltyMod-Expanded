package darkbum.saltymod.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class OvenbakingRecipe {
    private static final OvenbakingRecipe potBase = new OvenbakingRecipe();
    private final Map<ItemStack, OvenRecipe> recipes = new HashMap<>();

    public interface IIngredientMatcher {
        boolean matches(ItemStack stack);
    }

    public static class StackIngredient implements IIngredientMatcher {
        private final ItemStack stack;

        public StackIngredient(ItemStack stack) {
            this.stack = stack;
        }

        @Override
        public boolean matches(ItemStack input) {
            return areStacksEqual(stack, input);
        }
    }

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
    }

    public static StackIngredient stack(ItemStack stack) {
        return new StackIngredient(stack);
    }

    public static OreIngredient ore(String name) {
        return new OreIngredient(name);
    }

    public static OvenbakingRecipe baking() {
        return potBase;
    }

    public static class OvenRecipe {
        public final ItemStack output;
        public final boolean requiresHeater;
        public final List<IIngredientMatcher> ingreds;
        public final float xpChance; // Renamed to xpChance to represent the probability

        public OvenRecipe(ItemStack output, boolean requiresHeater, List<IIngredientMatcher> ingreds, float xpChance) {
            this.output = output;
            this.requiresHeater = requiresHeater;
            this.ingreds = ingreds;
            this.xpChance = xpChance;
        }

        // Check whether XP should be spawned based on the chance
        public boolean shouldSpawnXp() {
            return Math.random() < xpChance;
        }
    }

    // Modify the registerRecipe method to take xpChance instead of xp
    public void registerRecipe(ItemStack output, boolean requiresHeater, float xpChance, IIngredientMatcher... ingredMatchers) {
        List<IIngredientMatcher> ingredList = Arrays.asList(ingredMatchers);
        recipes.put(output, new OvenRecipe(output, requiresHeater, ingredList, xpChance));  // Use xpChance instead of xp
    }

    public OvenRecipe getRecipeFor(List<ItemStack> ingreds) {
        for (Map.Entry<ItemStack, OvenRecipe> entry : recipes.entrySet()) {
            OvenRecipe recipe = entry.getValue();

            if (recipe.ingreds.size() != ingreds.size()) {
                continue;
            }

            boolean[] matchedIngreds = new boolean[recipe.ingreds.size()];
            boolean matchFound = true;

            for (ItemStack ingred : ingreds) {
                boolean ingredMatched = false;
                for (int j = 0; j < recipe.ingreds.size(); j++) {
                    if (!matchedIngreds[j] && recipe.ingreds.get(j).matches(ingred)) {
                        matchedIngreds[j] = true;
                        ingredMatched = true;
                        break;
                    }
                }
                if (!ingredMatched) {
                    matchFound = false;
                    break;
                }
            }

            if (matchFound) {
                return recipe;
            }
        }
        return null;
    }

    private static boolean areStacksEqual(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) return false;
        return stack2.getItem() == stack1.getItem() &&
            (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
