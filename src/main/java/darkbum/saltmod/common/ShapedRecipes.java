package darkbum.saltmod.common;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ShapedRecipes {

    public static void init() {

        GameRegistry.addRecipe(new ItemStack(Items.sugar), "xxx", "xxx", "xxx", 'x', ModItems.sugarPinch);
        GameRegistry.addRecipe(new ItemStack(Items.cake), " x ", "yzy", " a ", 'x', Items.milk_bucket, 'y', Items.sugar, 'z', Items.egg, 'a', ModItems.dough);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock), "xxx", "xxx", "xxx", 'x', ModItems.salt);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 4, 5), "xx", "xx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 2, 2), "x", "x", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 1), "x", "x", 'x', new ItemStack(ModBlocks.saltSlab, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 8), "x", "x", 'x', new ItemStack(ModBlocks.saltSlab, 1, 1) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 9), "x", "x", 'x', new ItemStack(ModBlocks.saltSlab, 1, 2) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBrickStair, 6), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 5) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltSlab, 6, 0), "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltSlab, 6, 1), "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 5) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltSlab, 6, 2), "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 2) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltLamp), "x", "y", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0), 'y', new ItemStack(Blocks.torch) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBlock), "xx", "xx", 'x', ModItems.mineralMud);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickWet, 2), "xy", "yx", 'x', ModBlocks.mudBlock, 'y', new ItemStack(Items.wheat));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickDryStairs), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.mudBrickDry));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickDrySlab), "xxx", 'x', new ItemStack(ModBlocks.mudBrickDry));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blossomStairs), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.blossomPlanks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blossomSlab), "xxx", 'x', new ItemStack(ModBlocks.blossomPlanks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.extractor), "xyx", "x x", "xxx", 'x', Blocks.cobblestone, 'y', Items.cauldron);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate), "xxx", "xxx", "xxx", 'x', Items.carrot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 1), "xxx", "xxx", "xxx", 'x', Items.potato);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 2), "xxx", "xxx", "xxx", 'x', Items.poisonous_potato);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 3), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.onion));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel, 1, 1), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish, 1, 1));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel, 1, 2), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish, 1, 2));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel, 1, 3), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish, 1, 3));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack), "xxx", "xxx", "xxx", 'x', Items.wheat_seeds);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 1), "xxx", "xxx", "xxx", 'x', Items.melon_seeds);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 2), "xxx", "xxx", "xxx", 'x', Items.pumpkin_seeds);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 3), "xxx", "xxx", "xxx", 'x', ModItems.saltWortSeed);

        GameRegistry.addRecipe(new ItemStack(ModItems.salt), "xxx", "xxx", "xxx", 'x', ModItems.saltPinch);
        GameRegistry.addRecipe(new ItemStack(ModItems.goldenSaltWortSeed), "xxx", "xyx", "xxx", 'x', Items.gold_nugget, 'y', ModItems.saltWortSeed);
        GameRegistry.addRecipe(new ItemStack(ModItems.goldenPotato), "xxx", "xyx", "xxx", 'x', Items.gold_nugget, 'y', Items.potato);
        GameRegistry.addRecipe(new ItemStack(ModItems.cornedBeef), "xxx", "xyx", "xxx", 'x', ModItems.saltPinch, 'y', Items.rotten_flesh);
        GameRegistry.addRecipe(new ItemStack(ModItems.chocolateBar), "xyx", 'x', new ItemStack(Items.dye, 1, 3), 'y', ModItems.powderedMilk);
        GameRegistry.addRecipe(new ItemStack(ModItems.mudHelmet), "xxx", "x x", 'x', ModItems.mineralMud);
        GameRegistry.addRecipe(new ItemStack(ModItems.mudChestplate), "x x", "xxx", "xxx", 'x', ModItems.mineralMud);
        GameRegistry.addRecipe(new ItemStack(ModItems.mudLeggings), "xxx", "x x", "x x", 'x', ModItems.mineralMud);
        GameRegistry.addRecipe(new ItemStack(ModItems.mudBoots), "x x", "x x", 'x', ModItems.mineralMud);
    }
}
