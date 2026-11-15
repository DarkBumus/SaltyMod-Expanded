
package darkbum.saltymod.util;

import com.github.bsideup.jabel.Desugar;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

import static net.minecraftforge.oredict.OreDictionary.*;

public class OvenbakingRecipe {
    private static final OvenbakingRecipe ovenBase = new OvenbakingRecipe();
    private final List<OvenRecipe> recipes = new ArrayList<>();

    public interface IIngredientMatcher {
        boolean matches(ItemStack stack);
    }

    @Desugar
    public record StackIngredient(ItemStack stack) implements IIngredientMatcher {
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

        public List<ItemStack> getOres() {
            return OreDictionary.getOres(oreName);
        }
    }

    public static StackIngredient stack(ItemStack stack) {
        return new StackIngredient(stack);
    }

    public static OreIngredient ore(String name) {
        return new OreIngredient(name);
    }

    public static OvenbakingRecipe baking() {
        return ovenBase;
    }

    @Desugar
    public record OvenRecipe(ItemStack output, boolean requiresHeater, List<IIngredientMatcher> ingreds, float xpChance) {
        public boolean shouldSpawnXp() {
            return Math.random() < xpChance;
        }
    }

    public void registerRecipe(ItemStack output, boolean requiresHeater, float xpChance, IIngredientMatcher... ingredMatchers) {
        List<IIngredientMatcher> ingredList = Arrays.asList(ingredMatchers);
        recipes.add(new OvenRecipe(output, requiresHeater, ingredList, xpChance));
    }

    public List<OvenRecipe> getRecipes() {
        return Collections.unmodifiableList(recipes);
    }

    public OvenRecipe getRecipeFor(List<ItemStack> ingreds) {
        for (OvenRecipe recipe : recipes) {
            if (recipe.ingreds().size() != ingreds.size()) {
                continue;
            }

            boolean[] matchedIngreds = new boolean[recipe.ingreds().size()];
            boolean matchFound = true;

            for (ItemStack ingred : ingreds) {
                boolean ingredMatched = false;
                for (int j = 0; j < recipe.ingreds().size(); j++) {
                    if (recipe.ingreds().get(j) == null) continue;
                    if (!matchedIngreds[j] && recipe.ingreds().get(j).matches(ingred)) {
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
        return stack2.getItem() == stack1.getItem()
            && (stack1.getItemDamage() == WILDCARD_VALUE
            || stack2.getItemDamage() == stack1.getItemDamage());
    }
}
