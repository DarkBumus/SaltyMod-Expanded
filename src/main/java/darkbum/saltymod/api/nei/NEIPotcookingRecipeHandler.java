package darkbum.saltymod.api.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.inventory.gui.GuiCookingPot;
import darkbum.saltymod.item.ItemSalt;
import darkbum.saltymod.util.PotcookingRecipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * NEI recipe handler for displaying Cooking Pot recipes in the NEI interface.
 * For now, this handler provides a GUI texture and a display name for this recipe category.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class NEIPotcookingRecipeHandler extends TemplateRecipeHandler {

    public class CookingPotPair extends CachedRecipe {
        private final List<PositionedStack> ingreds;
        private final PositionedStack result;

        public CookingPotPair(PotcookingRecipe.PotRecipe recipe) {
            this.ingreds = new ArrayList<>();
            for (int i = 0; i < recipe.ingreds().size(); i++) {
                int i2 = i;
                PotcookingRecipe.IIngredientMatcher ingred = recipe.ingreds().get(i);
                PotcookingRecipe.IIngredientMatcher firstIngred = recipe.ingreds().get(0);
                if(firstIngred instanceof PotcookingRecipe.StackIngredient stackIngredient) {
                    if(stackIngredient.getStack().getItem() == ModItems.salt_pinch || stackIngredient.getStack().getItem() == ModItems.sugar_pinch) {
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
                    if(stackIngredient.getStack().getItem() == ModItems.salt_pinch || stackIngredient.getStack().getItem() == ModItems.sugar_pinch) {
                        ingreds.add(new PositionedStack(stackIngredient.getStack(), 3, 6));
                    } else {
                        ingreds.add(new PositionedStack(stackIngredient.getStack(), posX, posY));
                    }
  
                }
            }
            this.result = new PositionedStack(recipe.output(), 119, 15);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return this.ingreds;
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Map.Entry<ItemStack, PotcookingRecipe.PotRecipe> recipe : PotcookingRecipe.cooking().getRecipes()) {
            if(NEIServerUtils.areStacksSameType(recipe.getKey(), result)) {
                arecipes.add(new CookingPotPair(recipe.getValue()));
            }
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(80, 10, 24, 24), SaltyMod.MODID + ".cooking_pot"));
    }
    
	@Override
	public int recipiesPerPage() {
		return 1;
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
}
