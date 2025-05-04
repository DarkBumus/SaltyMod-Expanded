package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationModCompatibility;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.util.EvaporatingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ModEvaporatorRecipes {

    public static Fluid milk;

    public static void init() {
        EvaporatingRecipe.instance().addEvaporating(FluidRegistry.WATER, ModItems.salt_pinch, 1000, 0.0F);

        if (ModConfigurationBlocks.enableEvaporator) {
            if (FluidRegistry.isFluidRegistered("milk")) {
                Fluid milk = FluidRegistry.getFluid("milk");
                EvaporatingRecipe.instance().addEvaporating(milk, ModItems.powdered_milk, 1000, 0.0F);
            } else {
                milk = new Fluid("milk");
                FluidRegistry.registerFluid(milk);
                FluidContainerRegistry.registerFluidContainer(
                    new FluidStack(milk, 1000),
                    new ItemStack(Items.milk_bucket),
                    FluidContainerRegistry.EMPTY_BUCKET);
                EvaporatingRecipe.instance().addEvaporating(milk, ModItems.powdered_milk, 1000, 0.0F);
            }
            if (Loader.isModLoaded("BiomesOPlenty") && ModConfigurationModCompatibility.enableBOPFoods) {
                if (FluidRegistry.isFluidRegistered("blood")) {
                    Fluid blood = FluidRegistry.getFluid("blood");
                    GameRegistry.registerItem(ModItems.bop_hemoglobin, "bop_hemoglobin");
                    EvaporatingRecipe.instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
                }
                if (FluidRegistry.isFluidRegistered("hell_blood")) {
                    Fluid blood = FluidRegistry.getFluid("hell_blood");
                    GameRegistry.registerItem(ModItems.bop_hemoglobin, "bop_hemoglobin");
                    EvaporatingRecipe.instance()
                        .addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
                }
                Item bop_dart = GameRegistry.findItem("BiomesOPlenty", "dart");
                ItemStack bop_poisondart = new ItemStack(bop_dart, 1, 1);
                if (bop_dart != null && FluidRegistry.isFluidRegistered("poison")) {
                    Fluid poisonFl = FluidRegistry.getFluid("poison");
                    GameRegistry.registerItem(ModItems.bop_poison, "bop_poison");
                    EvaporatingRecipe.instance().addEvaporating(poisonFl, ModItems.bop_poison, 1000, 1.0F);
                    GameRegistry.addShapelessRecipe(bop_poisondart, new ItemStack(bop_dart), ModItems.bop_poison);
                }
            }
        }

    }
}
