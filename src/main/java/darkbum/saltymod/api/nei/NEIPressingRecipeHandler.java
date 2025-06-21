package darkbum.saltymod.api.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.inventory.gui.GuiPress;
import darkbum.saltymod.util.PressingRecipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            ingreds.add(new PositionedStack(recipe.input(), 75, 6));
            if(recipe.output2() != null) {
                ingreds.add(new PositionedStack(recipe.output2(), 93, 42));
            }
            if(recipe.vesselItem() != null) {
                ingreds.add(new PositionedStack(recipe.vesselItem(), 21, 42));
            }
            this.result = new PositionedStack(recipe.output1(), 57, 42);
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
            return this.heat;
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Map.Entry<ItemStack, PressingRecipe.PressRecipe> recipe : PressingRecipe.pressing().getRecipes()) {
            if(NEIServerUtils.areStacksSameType(recipe.getValue().output1(), result) || NEIServerUtils.areStacksSameType(recipe.getValue().output2(), result)) {
                arecipes.add(new PressPair(recipe.getValue()));
            }
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(65, 24, 30, 10), SaltyMod.MODID + ".press"));
    }
    
	@Override
	public int recipiesPerPage() {
		return 1;
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
}
