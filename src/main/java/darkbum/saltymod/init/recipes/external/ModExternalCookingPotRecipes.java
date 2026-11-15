package darkbum.saltymod.init.recipes.external;

import darkbum.saltymod.tileentity.TileEntityCookingPot;
import darkbum.saltymod.util.PotcookingRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.enableMachines;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.init.ModExternalLoader.twilightForestItems;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.ConditionalRegistrar.addPotRecipe;
import static darkbum.saltymod.util.PotcookingRecipe.ore;
import static darkbum.saltymod.util.PotcookingRecipe.stack;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;

/**
 * Recipe class for {@link TileEntityCookingPot}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModExternalCookingPotRecipes {

    /**
     * Initializes all custom pot recipes.
     * <p>
     * Recipe definition:
     * OvenbakingRecipe.baking().registerRecipe(OUTPUT(ItemStack), HEATER?(boolean), XPCHANCE(float), INPUTS(ItemStack));
     * If you want to use this in your own mod, you need to import the static methods for stack and ore ingredients from {@link PotcookingRecipe}.
     * NOTE:    The requiresHeater boolean intentionally functions in a way where setting the value to "false" will require the heater to NOT
     *          be present for the recipe to function.
     */
    public static void init() {

        Item venisonRaw = twilightForestItems.get("venisonRaw");
        Item venisonCooked = twilightForestItems.get("venisonCooked");
        Item meefRaw = twilightForestItems.get("meefRaw");
        Item meefSteak = twilightForestItems.get("meefSteak");

        addPotRecipe(new ItemStack(tf_saltwort_cooked_venison),
            new boolean[]{enableTFFoods, venisonRaw != null, venisonCooked != null},
            false,
            0.3f,
            stack(new ItemStack(tf_salt_cooked_venison)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
        addPotRecipe(new ItemStack(tf_saltwort_meef_steak),
            new boolean[]{enableTFFoods, meefRaw != null, meefSteak != null},
            false,
            0.3f,
            stack(new ItemStack(tf_salt_meef_steak)),
            stack(new ItemStack(saltwort)),
            stack(new ItemStack(saltwort)));
    }
}
