package darkbum.saltymod.api.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.inventory.gui.GuiCookingPot;
import darkbum.saltymod.util.PotcookingRecipe;
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
 * NEI recipe handler for displaying Cooking Pot recipes in the NEI interface.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class NEIPotcookingRecipeHandler extends TemplateRecipeHandler {

    public class CookingPotPair extends CachedRecipe {
        private final List<PositionedStack> ingreds;
        private final PositionedStack result;
        private final PositionedStack bowl;

        public CookingPotPair(PotcookingRecipe.PotRecipe recipe) {
            this.ingreds = new ArrayList<>();
            this.bowl = recipe.isBucketRecipe() ? null : new PositionedStack(new ItemStack(Items.bowl), 119, 44);
            for (int i = 0; i < recipe.ingreds().size(); i++) {
                int i2 = i;
                PotcookingRecipe.IIngredientMatcher ingred = recipe.ingreds().get(i);
                PotcookingRecipe.IIngredientMatcher firstIngred = recipe.ingreds().get(0);
                if(firstIngred instanceof PotcookingRecipe.StackIngredient stackIngredient) {
                    if(stackIngredient.stack().getItem() == ModItems.salt_pinch || stackIngredient.stack().getItem() == ModItems.sugar_pinch) {
                        i2 = i - 1;
                    }
                }
                int rX = 18 * i2;
                int posX = ((rX % 54) + 30) - 5;
                int rY = Math.floorDiv(rX, 54) + 1;
                int posY = (rY * 18) - 12;
                if(ingred instanceof PotcookingRecipe.OreIngredient oreIngredient) {
                    ingreds.add(new PositionedStack(oreIngredient.getOres(), posX, posY));
                } else if(ingred instanceof PotcookingRecipe.StackIngredient stackIngredient) {
                    if(stackIngredient.stack().getItem() == ModItems.salt_pinch || stackIngredient.stack().getItem() == ModItems.sugar_pinch) {
                        ingreds.add(new PositionedStack(stackIngredient.stack(), 3, 6));
                    } else {
                        ingreds.add(new PositionedStack(stackIngredient.stack(), posX, posY));
                    }

                }
            }
            this.result = new PositionedStack(recipe.output(), 119, 15);
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
            return this.bowl != null ? Collections.singletonList(this.bowl) : Collections.emptyList();
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(getOverlayIdentifier()) && getClass() == NEIPotcookingRecipeHandler.class) {
            for (PotcookingRecipe.PotRecipe recipe : PotcookingRecipe.cooking().getRecipes()) {
                arecipes.add(new CookingPotPair(recipe));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (PotcookingRecipe.PotRecipe recipe : PotcookingRecipe.cooking().getRecipes()) {
            if (NEIServerUtils.areStacksSameType(recipe.output(), result)) {
                arecipes.add(new CookingPotPair(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        if (ingredient == null || ingredient.getItem() == null) return;

        for (PotcookingRecipe.PotRecipe recipe : PotcookingRecipe.cooking().getRecipes()) {
            for (PotcookingRecipe.IIngredientMatcher matcher : recipe.ingreds()) {
                if (matcher.matches(ingredient)) {
                    arecipes.add(new CookingPotPair(recipe));
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
        transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(42, 41, 18, 18), SaltyMod.MODID + ".cooking_pot"));
        transferRects.add(new RecipeTransferRect(new Rectangle(84, 14, 24, 18), SaltyMod.MODID + ".cooking_pot"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiCookingPot.class;
    }

    /**
     * @return a resource location of the GUI texture.
     */
    @Override
    public String getGuiTexture() {
        return SaltyMod.MODID + ":textures/gui/container/cooking_pot.png";
    }

    /**
     * @return the name of the recipe category.
     */
    @Override
    public String getRecipeName() {
        return "Cooking Pot";
    }

    @Override
    public String getOverlayIdentifier() {
        return SaltyMod.MODID + ".cooking_pot";
    }

    @Override
    public void drawExtras(int recipe) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        drawTexturedModalRect(44, 43, 176, 0, 14, 14);

        drawProgressBar(84, 14, 176, 14, 24, 16, 48, 0);
    }
}
