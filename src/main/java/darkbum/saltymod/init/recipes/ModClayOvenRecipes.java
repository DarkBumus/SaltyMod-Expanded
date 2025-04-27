package darkbum.saltymod.init.recipes;

import darkbum.saltymod.api.OvenbakingRecipe;
import darkbum.saltymod.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.api.OvenbakingRecipe.stack;

public class ModClayOvenRecipes {

    public static void init() {
        OvenbakingRecipe oven = OvenbakingRecipe.baking();

        oven.registerRecipe(new ItemStack(ModItems.chocolate_pie),
            true,
            1.0f,
            stack(new ItemStack(Items.dye, 1, 3)),
            stack(new ItemStack(Items.dye, 1, 3)),
            stack(new ItemStack(ModItems.dough)),
            stack(new ItemStack(Items.egg)));
    }
}
