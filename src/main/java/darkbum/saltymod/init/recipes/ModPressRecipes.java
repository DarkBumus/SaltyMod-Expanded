package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.util.PressingRecipe;
import darkbum.saltymod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModPressRecipes {

    /**
     *  Recipe definition is a bit complex, so here it goes:
     *  recipes.registerRecipe(INPUT[ItemStack], OUTPUT1/LEFT[ItemStack], OUTPUT2/RIGHT[ItemStack], REQUIRES HEATER?[Boolean], REQUIRES MILL?[Boolean], VESSEL[ItemStack]);
     *  NOTE: Both requiresHeater and requiresMill intentionally function in a way where they will block functionality of a recipe, if the recipe specifies that they're not required, and yet they are present.
     *  In short: If you recipe says requiresHeater = false and you place a valid stove block next to the press, the recipe will not function. Likewise, if you recipe says requiresHeater = true, and the stove is not present,
     *  it will also not function. Same goes for the mill.
     */

    public static void init() {
        PressingRecipe press = PressingRecipe.pressing();

        press.registerRecipe(new ItemStack(Blocks.cobblestone), null, new ItemStack(Blocks.gravel), false, true, null);
        press.registerRecipe(new ItemStack(Blocks.gravel), null, new ItemStack(Blocks.sand), false, true, null);

        press.registerRecipe(new ItemStack(ModItems.mineral_mud_ball), new ItemStack(Items.potionitem, 1, 0), new ItemStack(Items.clay_ball, 1, 0), false, false, new ItemStack(Items.glass_bottle));
        press.registerRecipe(new ItemStack(Items.wheat), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.dough), false, true, new ItemStack(Items.potionitem, 1, 0));

        if (Loader.isModLoaded("etfuturum")) {
            Item honey_bottle = GameRegistry.findItem("etfuturum", "honey_bottle");
            if ((honey_bottle != null)) {
                press.registerRecipe(new ItemStack(ModItems.honeycomb),
                    new ItemStack(honey_bottle), new ItemStack(ModItems.waxcomb),
                    false,
                    false,
                    new ItemStack(Items.glass_bottle));
                press.registerRecipe(new ItemStack(ModItems.frozen_honey),
                    new ItemStack(honey_bottle),
                    null,
                    true,
                    false,
                    new ItemStack(Items.glass_bottle));
            } else {
                press.registerRecipe(new ItemStack(ModItems.honeycomb), new ItemStack(ModItems.royal_jelly), new ItemStack(ModItems.waxcomb), false, false, new ItemStack(Items.glass_bottle));
                press.registerRecipe(new ItemStack(ModItems.frozen_honey), new ItemStack(ModItems.royal_jelly), null, true, false, new ItemStack(Items.glass_bottle));
            }
        }

        press.registerRecipe(new ItemStack(ModItems.horn), new ItemStack(ModItems.tunneler_concoction), null, true, true, new ItemStack(ModItems.fizzy_drink));
    }
}
