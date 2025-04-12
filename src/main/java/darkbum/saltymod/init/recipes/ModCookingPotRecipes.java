package darkbum.saltymod.init.recipes;

import darkbum.saltymod.api.PotcookingRecipe;
import darkbum.saltymod.init.ModItems;
import net.minecraft.item.ItemStack;

public class ModCookingPotRecipes {

    public static void init() {
        PotcookingRecipe recipes = PotcookingRecipe.cooking();

        recipes.registerRecipe(new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.waxcomb), false, false);
    }
}
