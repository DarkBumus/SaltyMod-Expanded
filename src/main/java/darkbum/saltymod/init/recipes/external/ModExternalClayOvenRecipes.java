package darkbum.saltymod.init.recipes.external;

import darkbum.saltymod.tileentity.TileEntityClayOven;
import darkbum.saltymod.util.OvenbakingRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.enableEvaporator;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.enableRecipeChanges;
import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.ConditionalRegistrar.addOvenRecipe;
import static darkbum.saltymod.util.OvenbakingRecipe.ore;
import static darkbum.saltymod.util.OvenbakingRecipe.stack;
import static net.minecraft.init.Blocks.pumpkin;
import static net.minecraft.init.Items.*;

/**
 * Recipe class for {@link TileEntityClayOven}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModExternalClayOvenRecipes {

    /**
     * Initializes all custom oven recipes.
     * <p>
     * Recipe definition:
     * OvenbakingRecipe.baking().registerRecipe(OUTPUT(ItemStack), HEATER?(boolean), XPCHANCE(float), INPUTS(ItemStack));
     * If you want to use this in your own mod, you need to import the static methods for stack and ore ingredients from {@link OvenbakingRecipe}.
     * NOTE:    The requiresHeater boolean intentionally functions in a way where setting the value to "false" will require the heater to NOT
     *          be present for the recipe to function.
     */
    public static void init() {

        Item venisonRaw = twilightForestItems.get("venisonRaw");
        Item venisonCooked = twilightForestItems.get("venisonCooked");
        Item meefRaw = twilightForestItems.get("meefRaw");
        Item meefSteak = twilightForestItems.get("meefSteak");

        Item bison_meat = wildMobsItems.get("bison_meat");
        Item cooked_bison_meat = wildMobsItems.get("cooked_bison_meat");
        Item wm_calamari = wildMobsItems.get("calamari");
        Item cooked_calamari = wildMobsItems.get("cooked_calamari");
        Item chevon = wildMobsItems.get("chevon");
        Item cooked_chevon = wildMobsItems.get("cooked_chevon");
        Item goose = wildMobsItems.get("goose");
        Item cooked_goose = wildMobsItems.get("cooked_goose");
        Item mouse = wildMobsItems.get("mouse");
        Item cooked_mouse = wildMobsItems.get("cooked_mouse");
        Item venison = wildMobsItems.get("venison");
        Item cooked_venison = wildMobsItems.get("cooked_venison");
        Item magma_plant_seed = wildMobsItems.get("magma_plant_seed");
        Item roasted_magma_plant_seed = wildMobsItems.get("roasted_magma_plant_seed");

        addOvenRecipe(new ItemStack(venisonCooked),
            new boolean[]{enableTFFoods, venisonRaw != null, venisonCooked != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(venisonRaw)));
        addOvenRecipe(new ItemStack(tf_salt_cooked_venison),
            new boolean[]{enableTFFoods, venisonRaw != null, venisonCooked != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(venisonRaw)));
        addOvenRecipe(new ItemStack(meefSteak),
            new boolean[]{enableTFFoods, meefRaw != null, meefSteak != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(meefRaw)));
        addOvenRecipe(new ItemStack(tf_salt_meef_steak),
            new boolean[]{enableTFFoods, meefRaw != null, meefSteak != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(meefRaw)));
        addOvenRecipe(new ItemStack(cooked_bison_meat),
            new boolean[]{enableWMFoods, bison_meat != null, cooked_bison_meat != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(bison_meat)));
        addOvenRecipe(new ItemStack(wm_salt_cooked_bison),
            new boolean[]{enableWMFoods, bison_meat != null, cooked_bison_meat != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(bison_meat)));
        addOvenRecipe(new ItemStack(cooked_calamari),
            new boolean[]{enableWMFoods, wm_calamari != null, cooked_calamari != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(wm_calamari)));
        addOvenRecipe(new ItemStack(wm_salt_cooked_calamari),
            new boolean[]{enableWMFoods, wm_calamari != null, cooked_calamari != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(wm_calamari)));
        addOvenRecipe(new ItemStack(cooked_chevon),
            new boolean[]{enableWMFoods, chevon != null, cooked_chevon != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(chevon)));
        addOvenRecipe(new ItemStack(wm_salt_cooked_chevon),
            new boolean[]{enableWMFoods, chevon != null, cooked_chevon != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(chevon)));
        addOvenRecipe(new ItemStack(cooked_goose),
            new boolean[]{enableWMFoods, goose != null, cooked_goose != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(goose)));
        addOvenRecipe(new ItemStack(wm_salt_cooked_goose),
            new boolean[]{enableWMFoods, goose != null, cooked_goose != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(goose)));
        addOvenRecipe(new ItemStack(cooked_mouse),
            new boolean[]{enableWMFoods, mouse != null, cooked_mouse != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(mouse)));
        addOvenRecipe(new ItemStack(wm_salt_cooked_mouse),
            new boolean[]{enableWMFoods, mouse != null, cooked_mouse != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(mouse)));
        addOvenRecipe(new ItemStack(cooked_venison),
            new boolean[]{enableWMFoods, venison != null, cooked_venison != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(venison)));
        addOvenRecipe(new ItemStack(wm_salt_cooked_venison),
            new boolean[]{enableWMFoods, venison != null, cooked_venison != null, enableRecipeChanges},
            true,
            0.25f,
            stack(new ItemStack(salt_pinch)),
            stack(new ItemStack(venison)));
        addOvenRecipe(new ItemStack(roasted_magma_plant_seed),
            new boolean[]{enableWMFoods, magma_plant_seed != null, roasted_magma_plant_seed != null, enableRecipeChanges},
            true,
            0.15f,
            stack(new ItemStack(magma_plant_seed)));
    }
}
