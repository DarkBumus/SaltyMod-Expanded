package darkbum.saltymod.api.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.inventory.gui.GuiClayOven;
import darkbum.saltymod.util.OvenbakingRecipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        public OvenPair(OvenbakingRecipe.OvenRecipe recipe) {
            this.ingreds = new ArrayList<>();
            for (int i = 0; i < recipe.ingreds().size(); i++) {
                OvenbakingRecipe.IIngredientMatcher ingred = recipe.ingreds().get(i);
                int rX = 18 * i;
                int posX = ((rX % 36) + 30) + 5;
                int rY = Math.floorDiv(rX, 36) + 1;
                int posY = (rY * 18) - 12;
                if(ingred instanceof OvenbakingRecipe.OreIngredient oreIngredient) {
                    ingreds.add(new PositionedStack(oreIngredient.getOres(), posX, posY));
                } else if(ingred instanceof OvenbakingRecipe.StackIngredient stackIngredient) {
                    ingreds.add(new PositionedStack(stackIngredient.getStack(), posX, posY));
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
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Map.Entry<ItemStack, OvenbakingRecipe.OvenRecipe> recipe : OvenbakingRecipe.baking().getRecipes()) {
            if(NEIServerUtils.areStacksSameType(recipe.getKey(), result)) {
                arecipes.add(new OvenPair(recipe.getValue()));
            }
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(72, 10, 24, 24), SaltyMod.MODID + ".clay_oven"));
    }
    
	@Override
	public int recipiesPerPage() {
		return 1;
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
}
