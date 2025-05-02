package darkbum.saltymod.init.recipes;

import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.init.ModExternalItemLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.common.config.ModConfigurationModCompatibility;
import darkbum.saltymod.common.config.ModConfigurationVanillaChanges;

public class ModRemovedRecipes {

    public static void init() {

        Item rabbit_stew = ModExternalItemLoader.etFuturumItems.get("rabbit_stew");
        Item beetroot_soup = ModExternalItemLoader.etFuturumItems.get("beetroot_soup");
        Block honeycomb_block = ModExternalItemLoader.etFuturumBlocks.get("honeycomb_block");
        Block beehive = ModExternalItemLoader.etFuturumBlocks.get("beehive");

        ConditionalRegistrar.removeFirstRecipeFor(Items.mushroom_stew,
            ModConfigurationVanillaChanges.enableRecipeChanges);
        ConditionalRegistrar.removeFirstRecipeFor(Items.bread,
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough);
        ConditionalRegistrar.removeFirstRecipeFor(Items.cake,
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough);
        ConditionalRegistrar.removeFirstRecipeFor(Items.cake,
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.replaceCake);
        ConditionalRegistrar.removeFirstRecipeFor(Items.cookie,
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough);
        ConditionalRegistrar.removeFirstRecipeFor(Items.pumpkin_pie,
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough);

        ConditionalRegistrar.removeAllRecipesFor(rabbit_stew,
            rabbit_stew != null);
        ConditionalRegistrar.removeAllRecipesFor(beetroot_soup,
            beetroot_soup != null);
        ConditionalRegistrar.removeAllRecipesFor(honeycomb_block,
            honeycomb_block != null, ModConfigurationModCompatibility.enableEFRHoneyCompatibility);
        ConditionalRegistrar.removeAllRecipesFor(beehive,
            beehive != null, ModConfigurationModCompatibility.enableEFRHoneyCompatibility);
    }
}
