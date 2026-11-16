
package darkbum.saltymod.api.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.FurnaceRecipeHandler;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.inventory.gui.GuiEvaporator;
import darkbum.saltymod.util.EvaporatingRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NEIEvaporatingRecipeHandler extends TemplateRecipeHandler {

    public class EvaporatorPair extends CachedRecipe {

        private final Fluid fluid;
        private final PositionedStack result;

        public EvaporatorPair(Fluid fluid) {
            this.fluid = fluid;

            var output = EvaporatingRecipe.instance().getEvaporateItemStack(fluid);
            this.result = new PositionedStack(output, 111, 24);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return new ArrayList<>();
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }

        public Fluid getFluid() {
            return this.fluid;
        }

        @Override
        public PositionedStack getOtherStack() {
            if (FurnaceRecipeHandler.afuels == null || FurnaceRecipeHandler.afuels.isEmpty()) return null;

            return FurnaceRecipeHandler.afuels.get((cycleticks / 48) % FurnaceRecipeHandler.afuels.size()).stack;
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(getOverlayIdentifier())
            && getClass() == NEIEvaporatingRecipeHandler.class) {

            for (Fluid fluid : EvaporatingRecipe.instance().getRegisteredFluids()) {
                arecipes.add(new EvaporatorPair(fluid));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Fluid fluid : EvaporatingRecipe.instance().getRegisteredFluids()) {
            ItemStack output = EvaporatingRecipe.instance().getEvaporateItemStack(fluid);

            if (output != null && NEIServerUtils.areStacksSameType(output, result)) {
                arecipes.add(new EvaporatorPair(fluid));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        if (ingredient == null || ingredient.getItem() == null) return;

        FluidStack fluidStack = FluidContainerRegistry.getFluidForFilledItem(ingredient);
        if (fluidStack != null) {
            loadUsageRecipes(fluidStack);
        }
    }

    public void loadUsageRecipes(FluidStack ingredient) {
        if (ingredient == null || ingredient.getFluid() == null) return;

        for (Fluid fluid : EvaporatingRecipe.instance().getRegisteredFluids()) {
            if (fluid == ingredient.getFluid()) {
                arecipes.add(new EvaporatorPair(fluid));
            }
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if ("liquid".equals(inputId) && ingredients.length > 0 && ingredients[0] instanceof FluidStack fluidStack) {

            loadUsageRecipes(fluidStack);
        } else if (ingredients.length > 0 && ingredients[0] instanceof ItemStack stack) {
            loadUsageRecipes(stack);
        } else {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), SaltyMod.MODID + ".evaporator"));
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 16), SaltyMod.MODID + ".evaporator"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiEvaporator.class;
    }

    @Override
    public String getGuiTexture() {
        return SaltyMod.MODID + ":textures/gui/container/evaporator.png";
    }

    @Override
    public String getRecipeName() {
        return "Evaporator";
    }

    @Override
    public String getOverlayIdentifier() {
        return SaltyMod.MODID + ".evaporator";
    }

    @Override
    public void drawExtras(int recipe) {
        EvaporatorPair pair = (EvaporatorPair) arecipes.get(recipe);

        Fluid fluid = pair.getFluid();
        IIcon icon = fluid.getStillIcon();

        if (icon != null) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);

            int color = fluid.getColor();
            GL11.glColor4f(
                (color >> 16 & 0xFF) / 255.0F,
                (color >> 8 & 0xFF) / 255.0F,
                (color & 0xFF) / 255.0F,
                1.0F
            );

            codechicken.lib.gui.GuiDraw.gui.drawTexturedModelRectFromIcon(
                51, 6, icon, 16, 16
            );

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        codechicken.lib.gui.GuiDraw.changeTexture(getGuiTexture());

        // Progress Bar
        drawProgressBar(74, 23, 176, 14, 24, 16, 48, 0);
        // Fire
        drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        // Liquid Bar
        drawProgressBar(43, 15, 176, 31, 5, 33, 48, 7);
        // Bubbles Bar
        drawProgressBar(29, 17, 181, 31, 12, 29, 14, 3);
    }

    @Override
    public List<String> handleTooltip(GuiRecipe<?> gui, List<String> currenttip, int recipe) {
        currenttip = super.handleTooltip(gui, currenttip, recipe);

        if (!currenttip.isEmpty()) {
            return currenttip;
        }

        Point mouse = codechicken.lib.gui.GuiDraw.getMousePosition();
        Point offset = gui.getRecipePosition(recipe);

        int mouseX = mouse.x - gui.guiLeft - offset.x;
        int mouseY = mouse.y - gui.guiTop - offset.y;

        if (new Rectangle(51, 6, 16, 16).contains(mouseX, mouseY)) {
            EvaporatorPair pair = (EvaporatorPair) arecipes.get(recipe);
            Fluid fluid = pair.getFluid();

            currenttip.add(fluid.getLocalizedName(new FluidStack(fluid, 1)));
        }

        return currenttip;
    }
}
