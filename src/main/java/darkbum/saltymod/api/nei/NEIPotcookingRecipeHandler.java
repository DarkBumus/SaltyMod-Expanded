package darkbum.saltymod.api.nei;

import codechicken.nei.recipe.TemplateRecipeHandler;

public class NEIPotcookingRecipeHandler extends TemplateRecipeHandler {
    @Override
    public String getGuiTexture() {
        return "saltymod:gui/container/cooking_pot.png";
    }

    @Override
    public String getRecipeName() {
        return "Cooking Pot";
    }
}
