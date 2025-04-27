package darkbum.saltymod.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class PotcookingRecipe {
    private static final PotcookingRecipe potBase = new PotcookingRecipe();
    private final Map<ItemStack, PotRecipe> recipes = new HashMap<>();

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

    public static PotcookingRecipe cooking() {
        return potBase;
    }

    public static class PotRecipe {
        public final ItemStack output;
        public final boolean requiresHeater;
        public final List<IIngredientMatcher> ingreds;
        public final float xp;  // Neues Feld für XP

        // Reihenfolge geändert: Output, Heater?, Inputs, XP
        public PotRecipe(ItemStack output, boolean requiresHeater, List<IIngredientMatcher> ingreds, float xp) {
            this.output = output;
            this.requiresHeater = requiresHeater;
            this.ingreds = ingreds;
            this.xp = xp;  // XP setzen
        }

        // Getter für XP
        public float getXp() {
            return xp;
        }
    }

    // Rezeptregistrierung mit XP
    public void registerRecipe(ItemStack output, boolean requiresHeater, float xp, IIngredientMatcher... ingredMatchers) {
        // Zutaten von Varargs in eine Liste umwandeln
        List<IIngredientMatcher> ingredList = Arrays.asList(ingredMatchers);
        recipes.put(output, new PotRecipe(output, requiresHeater, ingredList, xp));  // XP übergeben
    }

    // Rezeptsuche ohne Pinch
    public PotRecipe getRecipeFor(List<ItemStack> ingreds) {
        for (Map.Entry<ItemStack, PotRecipe> entry : recipes.entrySet()) {
            PotRecipe recipe = entry.getValue();

            // Rezept muss die gleiche Anzahl an Zutaten wie die Eingabewerte haben
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
