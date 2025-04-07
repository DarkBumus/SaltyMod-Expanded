package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.api.PressingRecipe;
import darkbum.saltymod.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModPressRecipes {

    public static void init() {
        PressingRecipe recipes = PressingRecipe.pressing();

        if (Loader.isModLoaded("etfuturum")) {
            Item honey_bottle = GameRegistry.findItem("etfuturum", "honey_bottle");
            if ((honey_bottle != null)) {
                recipes.registerItemRecipe(ModItems.honeycomb, new ItemStack(honey_bottle), new ItemStack(ModItems.waxcomb), false, true);
                recipes.registerItemRecipe(ModItems.frozen_honey, new ItemStack(honey_bottle), null, true, true);
            } else {
                recipes.registerItemRecipe(ModItems.honeycomb, new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.waxcomb), false, true);
                recipes.registerItemRecipe(ModItems.frozen_honey, new ItemStack(ModItems.royal_jelly), null, true, true);
            }
        }


        recipes.registerItemRecipe(ModItems.mineral_mud_ball, new ItemStack(Items.potionitem, 1, 0), new ItemStack(ModItems.salt), false, true);
    }
}
