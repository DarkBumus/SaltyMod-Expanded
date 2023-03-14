package darkbum.saltmod.common;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.SaltConfig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SmeltingRecipes {

    public static void init() {

        GameRegistry.addSmelting(new ItemStack(Items.fish, 1, 2), new ItemStack(ModItems.fishClownfishCooked), 0.35F);
        GameRegistry.addSmelting(new ItemStack(Items.leather), new ItemStack(Items.slime_ball), 0.5F);
        GameRegistry.addSmelting(new ItemStack(Items.rotten_flesh), new ItemStack(Items.leather), 0.5F);

        GameRegistry.addSmelting(new ItemStack(ModBlocks.saltOre), new ItemStack(ModItems.salt, 1), 0.7F);
        if(ModBlocks.saltDeepslateOre != null) {
            GameRegistry.addSmelting(new ItemStack(ModBlocks.saltDeepslateOre), new ItemStack(ModItems.saltPinch, 1), 0.7F);
        }
        GameRegistry.addSmelting(new ItemStack(ModBlocks.saltLake), new ItemStack(ModItems.salt, 1), 0.7F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.saltBlock, 1, 0), new ItemStack(ModBlocks.saltBlock, 1, 6), 0.1F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.saltBlock, 1, 5), new ItemStack(ModBlocks.saltBlock, 1, 7), 0.1F);

        GameRegistry.addSmelting(new ItemStack(ModItems.dough), new ItemStack(Items.bread), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.soda, 1), 0.5F);
        GameRegistry.addSmelting(new ItemStack(ModItems.haunchRaw), new ItemStack(ModItems.haunchCooked), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ModItems.fishTailorRaw), new ItemStack(ModItems.fishTailorCooked), 0.35F);
        GameRegistry.addSmelting(new ItemStack(ModItems.calamariRaw), new ItemStack(ModItems.calamariCooked), 0.35F);

        if(!SaltConfig.mudBrickComplex) {
            GameRegistry.addSmelting(new ItemStack(ModBlocks.mudBrickWet), new ItemStack(ModBlocks.mudBrickDry), 0.1F);
        }
    }
}
