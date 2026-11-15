package darkbum.saltymod.api.nei;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.inventory.gui.GuiPress;
import darkbum.saltymod.util.PressingRecipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static codechicken.lib.gui.GuiDraw.drawTexturedModalRect;

/**
 * NEI recipe handler for displaying Pressing recipes in the NEI interface.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class NEIPressingRecipeHandler extends TemplateRecipeHandler {

    public class PressPair extends CachedRecipe {
        private final List<PositionedStack> ingreds;
        private final PositionedStack result;
        private final boolean heat;
        private final boolean mill;

        public PressPair(PressingRecipe.PressRecipe recipe) {
            this.heat = recipe.requiresHeater();
            this.mill = recipe.requiresMill();
            this.ingreds = new ArrayList<>();

            if (recipe.input() instanceof PressingRecipe.StackIngredient stackIngredient) {
                ingreds.add(new PositionedStack(stackIngredient.stack(), 75, 6));
            }

            if (recipe.input() instanceof PressingRecipe.OreIngredient oreIngredient) {
                ingreds.add(new PositionedStack(
                    oreIngredient.getOres(),
                    75,
                    6
                ));
            }

            if (recipe.output2() != null && recipe.output1() != null) {
                ingreds.add(new PositionedStack(recipe.output2(), 93, 42));
            }

            if (recipe.vesselItem() != null) {
                ingreds.add(new PositionedStack(recipe.vesselItem(), 21, 42));
            }

            ItemStack mainOutput = recipe.output1() != null
                ? recipe.output1()
                : recipe.output2();

            if (mainOutput == null) {
                throw new IllegalArgumentException("Press recipe must have at least one output!");
            }

            this.result = new PositionedStack(mainOutput, 57, 42);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return this.ingreds;
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }

        public boolean isHeater() {
            return this.heat;
        }

        public boolean isMill() {
            return this.mill;
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(getOverlayIdentifier()) && getClass() == NEIPressingRecipeHandler.class) {
            for (PressingRecipe.PressRecipe recipe : PressingRecipe.pressing().getRecipes()) {
                arecipes.add(new PressPair(recipe));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (PressingRecipe.PressRecipe pressRecipe : PressingRecipe.pressing().getRecipes()) {

            boolean matchesOutput1 = pressRecipe.output1() != null
                && NEIServerUtils.areStacksSameType(pressRecipe.output1(), result);

            boolean matchesOutput2 = pressRecipe.output2() != null
                && NEIServerUtils.areStacksSameType(pressRecipe.output2(), result);

            if (matchesOutput1 || matchesOutput2) {
                arecipes.add(new PressPair(pressRecipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        if (ingredient == null || ingredient.getItem() == null) return;

        for (PressingRecipe.PressRecipe pressRecipe : PressingRecipe.pressing().getRecipes()) {

            boolean isInput = pressRecipe.input() != null
                && pressRecipe.input().matches(ingredient);

            boolean isVessel = pressRecipe.vesselItem() != null
                && NEIServerUtils.areStacksSameType(pressRecipe.vesselItem(), ingredient);

            if (isInput || isVessel) {
                arecipes.add(new PressPair(pressRecipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if (ingredients != null
            && ingredients.length > 0
            && ingredients[0] instanceof ItemStack) {
            loadUsageRecipes((ItemStack) ingredients[0]);
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(68, 28, 31, 8), SaltyMod.MODID + ".press"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiPress.class;
    }

    /**
     * @return a resource location of the GUI texture.
     */
    @Override
    public String getGuiTexture() {
        return SaltyMod.MODID + ":textures/gui/container/press.png";
    }

    /**
     * @return the name of the recipe category.
     */
    @Override
    public String getRecipeName() {
        return "Press";
    }

    @Override
    public String getOverlayIdentifier() {
        return SaltyMod.MODID + ".press";
    }

    @Override
    public void drawExtras(int recipe) {
        PressPair pressPair = (PressPair) arecipes.get(recipe);

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if (pressPair.isHeater()) {
            drawTexturedModalRect(58, 7, 176, 0, 14, 14);
        }
        if (pressPair.isMill()) {
            drawTexturedModalRect(94, 7, 190, 0, 14, 14);
        }

        int progress = (int) ((System.currentTimeMillis() / 50L) % 17L);
        drawTexturedModalRect(
            68, 25,
            176, 14,
            progress, 14
        );
        drawTexturedModalRect(
            83 + (15 - progress), 25,
            191 + (15 - progress), 14,
            progress, 14
        );

    }

    @Override
    public List<String> handleTooltip(GuiRecipe<?> gui, List<String> currenttip, int recipe) {
        super.handleTooltip(gui, currenttip, recipe);

        if (!currenttip.isEmpty()) {
            return currenttip;
        }

        PressPair pressPair = (PressPair) arecipes.get(recipe);

        Point mouse = GuiDraw.getMousePosition();
        Point offset = gui.getRecipePosition(recipe);

        int mouseX = mouse.x - gui.guiLeft - offset.x;
        int mouseY = mouse.y - gui.guiTop - offset.y;

        if (mouseX >= 58 && mouseX < 72
            && mouseY >= 7 && mouseY < 21) {
            currenttip.add(I18n.format(
                pressPair.isHeater()
                    ? "container.press.heat"
                    : "container.press.no_heat"
            ));
        }
        if (mouseX >= 94 && mouseX < 108
            && mouseY >= 7 && mouseY < 21) {
            currenttip.add(I18n.format(
                pressPair.isMill()
                    ? "container.press.mill"
                    : "container.press.no_mill"
            ));
        }
        return currenttip;
    }
}
