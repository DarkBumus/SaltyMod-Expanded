package darkbum.saltymod.api.nei;

import darkbum.saltymod.common.config.ModConfigurationOther;
import net.minecraft.item.ItemStack;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Blocks.*;

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
        if (ModConfigurationOther.enableNEIShrub) {
            API.addItemListEntry(new ItemStack(tallgrass, 1, 0));
            API.addItemListEntry(new ItemStack(tallgrass, 1, 1));
            API.addItemListEntry(new ItemStack(tallgrass, 1, 2));
        }

        API.hideItem(new ItemStack(dev_item, 1, 0));
        API.hideItem(new ItemStack(dev_item, 1, 1));
        API.hideItem(new ItemStack(dev_item, 1, 2));
        API.hideItem(new ItemStack(double_salt_slab, 1, 0));
        API.hideItem(new ItemStack(double_salt_slab, 1, 1));
        API.hideItem(new ItemStack(double_salt_slab, 1, 2));
        API.hideItem(new ItemStack(double_salt_slab, 1, 9));
        API.hideItem(new ItemStack(double_salt_slab, 1, 10));
        API.hideItem(new ItemStack(grass_top));
        API.hideItem(new ItemStack(double_dry_mud_brick_slab, 1, 0));
        API.hideItem(new ItemStack(onions));
        API.hideItem(new ItemStack(saltworts));
        API.hideItem(new ItemStack(marsh_reeds_t));

        API.registerRecipeHandler(new NEIPotcookingRecipeHandler());
        API.registerRecipeHandler(new NEIOvenbakingRecipeHandler());
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
