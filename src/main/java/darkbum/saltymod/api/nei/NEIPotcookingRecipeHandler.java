package darkbum.saltymod.api.nei;

import codechicken.nei.recipe.TemplateRecipeHandler;

/**
 * NEI recipe handler for displaying Cooking Pot recipes in the NEI interface.
 * For now, this handler provides a GUI texture and a display name for this recipe category.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class NEIPotcookingRecipeHandler extends TemplateRecipeHandler {

    /**
     * @return a resource location of the GUI texture.
     */
    @Override
    public String getGuiTexture() {
        return "saltymod:gui/container/cooking_pot.png";
    }

    /**
     * @return the name of the recipe category.
     */
    @Override
    public String getRecipeName() {
        return "Cooking Pot";
    }
}
