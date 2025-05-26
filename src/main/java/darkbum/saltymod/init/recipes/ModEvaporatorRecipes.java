package darkbum.saltymod.init.recipes;

import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.tileentity.TileEntityEvaporator;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import static cpw.mods.fml.common.Loader.isModLoaded;
import static cpw.mods.fml.common.registry.GameRegistry.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.init.ModExternalLoader.biomesOPlentyItems;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.EvaporatingRecipe.*;
import static net.minecraftforge.fluids.FluidContainerRegistry.*;
import static net.minecraftforge.fluids.FluidRegistry.*;

/**
 * Recipe class for {@link TileEntityEvaporator}
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModEvaporatorRecipes {

    public static Fluid milk;

    /**
     * Initializes all custom evaporator recipes.
     */
    public static void init() {
        instance().addEvaporating(WATER, salt_pinch, 1000, 0.0F);

        Item dart = biomesOPlentyItems.get("dart");

        if (enableEvaporator) {
            if (isFluidRegistered("milk")) {
                Fluid milk = getFluid("milk");
                instance().addEvaporating(milk, powdered_milk, 1000, 0.0F);
            } else {
                milk = new Fluid("milk");
                registerFluid(milk);
                registerFluidContainer(new FluidStack(milk, 1000), new ItemStack(Items.milk_bucket), EMPTY_BUCKET);
                instance().addEvaporating(milk, powdered_milk, 1000, 0.0F);
            }
            if (isModLoaded("BiomesOPlenty") && enableBOPFoods) {
                if (isFluidRegistered("blood")) {
                    Fluid blood = getFluid("blood");
                    instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
                }
                if (isFluidRegistered("hell_blood")) {
                    Fluid blood = getFluid("hell_blood");
                    instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
                }
                if (dart != null && isFluidRegistered("poison")) {
                    Fluid poisonFl = getFluid("poison");
                    instance().addEvaporating(poisonFl, ModItems.bop_poison, 1000, 1.0F);
                }
            }
        }
    }
}
