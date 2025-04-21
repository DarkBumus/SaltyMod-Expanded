package darkbum.saltymod.api.nei;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {
        API.addItemListEntry(new ItemStack(Blocks.tallgrass, 1, 0));
        API.addItemListEntry(new ItemStack(Blocks.tallgrass, 1, 1));
        API.addItemListEntry(new ItemStack(Blocks.tallgrass, 1, 2));

        API.registerRecipeHandler(new NEIPotcookingRecipeHandler());
    }

    @Override
    public String getName() {
        return "SaltyMod NEI Plugin";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
