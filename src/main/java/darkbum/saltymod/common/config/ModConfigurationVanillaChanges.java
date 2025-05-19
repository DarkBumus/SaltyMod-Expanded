package darkbum.saltymod.common.config;

import net.minecraftforge.common.config.Configuration;

/**
 * Handles configuration settings for vanilla Minecraft content changes in SaltyMod Expanded.
 * <p>
 * This class manages configuration options that adjust the properties, recipes, and stack sizes
 * of vanilla Minecraft items, particularly foods. These changes are intended to align with
 * the new balancing introduced by SaltyMod.
 * <p>
 * This class is initialized during the pre-initialization stage of the mod lifecycle.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModConfigurationVanillaChanges {

    // Category Strings
    private static final String categoryNameVan = "vanilla changes";
    private static final String categoryDescriptionVan = "All the Vanilla Changes configuration";

    // Replacement Strings
    private static final String enableFeatures = "Enables the following features:";
    private static final String compatibilityString1 = "Notes: This is for when you have Et Futurum Requiem installed, but for some reason, don't want ";
    private static final String compatibilityString2 = " to be present";

    // Config Options VanillaChanges
    public static boolean enableVanillaFoodValueChanges;

    public static boolean enableRecipeChanges;

    public static boolean enableMushroomStewStacksize16;

    /**
     * Initializes the configuration settings for vanilla Minecraft changes by reading values from the provided configuration file.
     * <p>
     *
     * @param config The configuration file object to read from.
     */
    public static void init(Configuration config) {
        config.setCategoryComment(categoryNameVan, categoryDescriptionVan);

        enableVanillaFoodValueChanges = config.getBoolean(
            "01-enableVanillaFoodValueChanges",
            categoryNameVan,
            true,
            "Changes the food values of the vanilla Foods, to better fit the new balancing:"
                + "\nApple - 2 | 0.3f (Has a chance to give Speed for 5 seconds)"
                + "\nMushroom Stew - 5 | 0.7f (Has a chance to give Strength for 15 seconds)"
                + "\nBread - 3 | 0.5f"
                + "\nPorkchop - 2 | 0.6f"
                + "\nCooked Porkchop - 4 | 0.6f (Has a chance to give Health Boost for 5 seconds)"
                + "\nGolden Apple - 4 | 0.6f (Gives Speed for 45 seconds)"
                + "\nFish (All Fish) - 1 | 0.5f (Has a chance to give Water Breathing for 5 seconds)"
                + "\nCooked Fish (All Fish) - 3 | 0.5f (Has a chance to give Water Breathing for 5 seconds)"
                + "\nCookie - 2 | 0.1f (Has a chance to give Haste for 5 seconds)"
                + "\nMelon Slice - 1 | 0.3f (Added Fire Resistance for 5 seconds)"
                + "\nBeef - 2 | 0.6f"
                + "\nSteak - 4 | 0.6f (Has a chance to give Health Boost for 5 seconds)"
                + "\nChicken - 1 | 0.6f"
                + "\nCooked Chicken - 3 | 0.6f (Has a chance to give Health Boost for 5 seconds)"
                + "\nRotten Flesh - 1 | 0.3f"
                + "\nSpider Eye - 1 | 0.3f"
                + "\nCarrot - 1 | 0.3f (Has a achance to give Night Vision for 5 seconds)"
                + "\nPotato - 2 | 0.3f"
                + "\nBaked Potato - 3 | 0.5f"
                + "\nPoisonous Potato - 1 | 0.3f"
                + "\nGolden Carrot - 4 | 1.2f (Has a chance to give Night Vision for 45 seconds)"
                + "\nPumpkin Pie - 7 | 0.9f (Has a chance to give resistance for 90 seconds)"
                + "\nNotes: The first value refers to the number of half hunger shanks the respective item returns. The second value refers to the saturation. For a more detailed understanding, refer to this table and halve the \"Saturation Ratio\" values depicted there: https://minecraft.wiki/w/Food#Foods"
                + "\n");

        enableRecipeChanges = config.getBoolean(
            "02-enableRecipeChanges",
            categoryNameVan,
            true,
            "Changes the following vanilla Crafting Recipes:"
                + "\nMushroom Stew - Now gets crafted with an Ore Dictionary, allowing you to use either two Mushrooms to craft it"
                + "\nBread - Now gets crafted by burning Dough in a Furnace (or a Smoker, if Et Futurum Requiem is installed)"
                + "\nCake - Now gets crafted with only one Milk Bucket in the upper row and one Dough in the lower row, instead of three pieces of Wheat"
                + "\nCookie - Now gets crafted with Dough and Cocoa Beans, instead of two pieces of Wheat"
                + "\nPumpkin Pie - Now also needs Dough in addition to Pumpkin, Sugar and an Egg"
                + "\n");

        enableMushroomStewStacksize16 = config.getBoolean(
            "03-enableItemSoupStacksize16",
            categoryNameVan,
            true,
            "Changes the maximum stacksize of Mushroom Stew to 16."
                + "\nThis only changes the stacksize of Mushroom Stew. For modded food items that extends from ItemSoup, see mod_compatibility.cfg."
                + "\n");
    }
}
