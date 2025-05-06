package darkbum.saltymod.api.nei;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

/**
 * NEI plugin configuration for SaltyMod Expanded
 * Can register custom NEI listings and recipe handlers for the NEI (Not Enough Items) interface.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class NEIConfig implements IConfigureNEI {

    /**
     * Registers the three meta values (0, 1, 2) of the tallgrass block to be shown in the NEI item list.
     * Registers custom recipe handlers to allow NEI to display SME-specific Cooking Pot recipes.
     */
    @Override
    public void loadConfig() {
        API.addItemListEntry(new ItemStack(Blocks.tallgrass, 1, 0));
        API.addItemListEntry(new ItemStack(Blocks.tallgrass, 1, 1));
        API.addItemListEntry(new ItemStack(Blocks.tallgrass, 1, 2));
        API.hideItem(new ItemStack(ModBlocks.marsh_reeds_t));

        API.registerRecipeHandler(new NEIPotcookingRecipeHandler());
    }

    /**
     * @return the display name String of this NEI plugin.
     */
    @Override
    public String getName() {
        return "SaltyMod NEI Plugin";
    }

    /**
     * @return the version String of this NEI plugin.
     */
    @Override
    public String getVersion() {
        return "1.0";
    }
}
