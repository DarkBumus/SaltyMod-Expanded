package darkbum.saltmod.common;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.SaltConfig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SmeltingRecipes {

    public static void init() {

        GameRegistry.addSmelting(ModItems.dough, new ItemStack(Items.bread), 0.35F);
        GameRegistry.addSmelting(ModBlocks.saltOre, new ItemStack(ModItems.salt, 1), 0.7F);
        GameRegistry.addSmelting(ModBlocks.saltLake, new ItemStack(ModItems.salt, 1), 0.7F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.saltBlock, 1, 0), new ItemStack(ModBlocks.saltBlock, 1, 6), 0.1F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.saltBlock, 1, 5), new ItemStack(ModBlocks.saltBlock, 1, 7), 0.1F);
        GameRegistry.addSmelting(ModItems.saltWortSeed, new ItemStack(ModItems.soda, 1), 1.0F);
        GameRegistry.addSmelting(new ItemStack(Items.fish, 1, 2), new ItemStack(ModItems.fishClownfishCooked), 0.35F);
        GameRegistry.addSmelting(ModItems.haunchRaw, new ItemStack(ModItems.haunchCooked), 0.35F);
        GameRegistry.addSmelting(ModItems.calamariRaw, new ItemStack(ModItems.calamariCooked), 0.35F);

        if(!SaltConfig.mudBrickComplex) {
            GameRegistry.addSmelting(new ItemStack(ModBlocks.mudBrickWet), new ItemStack(ModBlocks.mudBrickDry), 0.1F);
        }
    }
}
