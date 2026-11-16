package darkbum.saltymod.api.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.inventory.gui.GuiClayOven;
import darkbum.saltymod.util.OvenbakingRecipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static codechicken.lib.gui.GuiDraw.drawTexturedModalRect;

/**
 * NEI recipe handler for displaying Oven baking recipes in the NEI interface.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class NEIOvenbakingRecipeHandler extends TemplateRecipeHandler {

    public class OvenPair extends CachedRecipe {
        private final List<PositionedStack> ingreds;
        private final PositionedStack result;
        private final PositionedStack woodenShovel;

        public OvenPair(OvenbakingRecipe.OvenRecipe recipe) {
            this.ingreds = new ArrayList<>();
            this.woodenShovel = new PositionedStack(new ItemStack(Items.wooden_shovel), 111, 44);

            for (int i = 0; i < recipe.ingreds().size(); i++) {
                OvenbakingRecipe.IIngredientMatcher ingred = recipe.ingreds().get(i);

                int rX = 18 * i;
                int posX = ((rX % 36) + 30) + 5;
                int rY = Math.floorDiv(rX, 36) + 1;
                int posY = (rY * 18) - 12;

                if (ingred instanceof OvenbakingRecipe.MultiStackIngredient multiStackIngredient) {
                    ingreds.add(new PositionedStack(multiStackIngredient.stacks(), posX, posY));

                } else if (ingred instanceof OvenbakingRecipe.OreIngredient oreIngredient) {
                    ingreds.add(new PositionedStack(oreIngredient.getOres(), posX, posY));

                } else if (ingred instanceof OvenbakingRecipe.StackIngredient stackIngredient) {
                    ingreds.add(new PositionedStack(stackIngredient.stack(), posX, posY));
                }
            }

            this.result = new PositionedStack(recipe.output(), 111, 15);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return this.getCycledIngredients(cycleticks / 20, this.ingreds);
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }

        @Override
        public List<PositionedStack> getOtherStacks() {
            return Collections.singletonList(this.woodenShovel);
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(getOverlayIdentifier()) && getClass() == NEIOvenbakingRecipeHandler.class) {
            for (OvenbakingRecipe.OvenRecipe recipe : OvenbakingRecipe.baking().getRecipes()) {
                arecipes.add(new OvenPair(recipe));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (OvenbakingRecipe.OvenRecipe recipe : OvenbakingRecipe.baking().getRecipes()) {
            if (NEIServerUtils.areStacksSameType(recipe.output(), result)) {
                arecipes.add(new OvenPair(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        if (ingredient == null || ingredient.getItem() == null) return;

        for (OvenbakingRecipe.OvenRecipe recipe : OvenbakingRecipe.baking().getRecipes()) {
            for (OvenbakingRecipe.IIngredientMatcher matcher : recipe.ingreds()) {
                if (matcher.matches(ingredient)) {
                    arecipes.add(new OvenPair(recipe));
                    break;
                }
            }
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
        if (ingredients.length > 0 && ingredients[0] instanceof ItemStack) {
            loadUsageRecipes((ItemStack) ingredients[0]);
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(43, 41, 18, 18), SaltyMod.MODID + ".clay_oven"));
        transferRects.add(new RecipeTransferRect(new Rectangle(76, 14, 24, 18), SaltyMod.MODID + ".clay_oven"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiClayOven.class;
    }

    /**
     * @return a resource location of the GUI texture.
     */
    @Override
    public String getGuiTexture() {
        return SaltyMod.MODID + ":textures/gui/container/clay_oven.png";
    }

    /**
     * @return the name of the recipe category.
     */
    @Override
    public String getRecipeName() {
        return "Clay Oven";
    }

    @Override
    public String getOverlayIdentifier() {
        return SaltyMod.MODID + ".clay_oven";
    }

    @Override
    public void drawExtras(int recipe) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        drawTexturedModalRect(45, 43, 176, 0, 14, 14);

        drawProgressBar(76, 14, 176, 14, 24, 16, 48, 0);
    }
}
