package darkbum.saltmod.common;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class OreDictionary {

    public static void init() {
//Salty Mod Ore Dictionaries
        net.minecraftforge.oredict.OreDictionary.registerOre("blockMushroom", Blocks.red_mushroom);
        net.minecraftforge.oredict.OreDictionary.registerOre("blockMushroom", Blocks.brown_mushroom);
        net.minecraftforge.oredict.OreDictionary.registerOre("oreSalt", ModBlocks.saltOre);
        net.minecraftforge.oredict.OreDictionary.registerOre("blockSalt", new ItemStack(ModBlocks.saltBlock, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE));
        net.minecraftforge.oredict.OreDictionary.registerOre("stairSalt", ModBlocks.saltBrickStair);
        net.minecraftforge.oredict.OreDictionary.registerOre("slabSalt", new ItemStack(ModBlocks.saltSlab, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE));
        net.minecraftforge.oredict.OreDictionary.registerOre("blockMud", ModBlocks.mudBlock);
        net.minecraftforge.oredict.OreDictionary.registerOre("blockMud", ModBlocks.mudBrickWet);
        net.minecraftforge.oredict.OreDictionary.registerOre("blockMud", ModBlocks.mudBrickDry);
        net.minecraftforge.oredict.OreDictionary.registerOre("logWood", ModBlocks.blossomLog);
        net.minecraftforge.oredict.OreDictionary.registerOre("logWood", ModBlocks.blossomStrippedLog);
        net.minecraftforge.oredict.OreDictionary.registerOre("logWood", ModBlocks.blossomBark);
        net.minecraftforge.oredict.OreDictionary.registerOre("plankWood", ModBlocks.blossomPlanks);
        net.minecraftforge.oredict.OreDictionary.registerOre("stairWood", ModBlocks.blossomStairs);
        net.minecraftforge.oredict.OreDictionary.registerOre("slabWood", ModBlocks.blossomSlab);
        net.minecraftforge.oredict.OreDictionary.registerOre("treeLeaves", ModBlocks.blossomLeaves);

        net.minecraftforge.oredict.OreDictionary.registerOre("itemRedmeat", Items.cooked_beef);
        net.minecraftforge.oredict.OreDictionary.registerOre("itemRedmeat", ModItems.haunchCooked);
        net.minecraftforge.oredict.OreDictionary.registerOre("itemSweetener", Items.sugar);
        net.minecraftforge.oredict.OreDictionary.registerOre("itemSweetener", ModItems.honeyComb);
        net.minecraftforge.oredict.OreDictionary.registerOre("itemHoney", ModItems.honeyComb);
        net.minecraftforge.oredict.OreDictionary.registerOre("itemRoyaljelly", ModItems.royalJelly);
        net.minecraftforge.oredict.OreDictionary.registerOre("cropOnion", ModItems.onion);
        net.minecraftforge.oredict.OreDictionary.registerOre("cropSaltwort", ModItems.saltWortSeed);

//HarvestCraft Ore Dictionaries
        if(Loader.isModLoaded("harvestcraft")) {
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllfishcooked", ModItems.fishClownfishCooked);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllmeatraw", ModItems.haunchRaw);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllmeatcooked", ModItems.haunchCooked);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllfishraw", ModItems.calamariRaw);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllfishcooked", ModItems.calamariCooked);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllmilk", ModItems.powderedMilk);
            net.minecraftforge.oredict.OreDictionary.registerOre("foodSalt", ModItems.salt);
            net.minecraftforge.oredict.OreDictionary.registerOre("foodSalt", ModItems.saltPinch);
            net.minecraftforge.oredict.OreDictionary.registerOre("dustSalt", ModItems.salt);
            net.minecraftforge.oredict.OreDictionary.registerOre("dustSalt", ModItems.saltPinch);
            net.minecraftforge.oredict.OreDictionary.registerOre("itemSalt", ModItems.salt);
            net.minecraftforge.oredict.OreDictionary.registerOre("itemSalt", ModItems.saltPinch);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllsugar", ModItems.sugarPinch);
            net.minecraftforge.oredict.OreDictionary.registerOre("foodDough", ModItems.dough);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllseeds", ModItems.saltWortSeed);
            net.minecraftforge.oredict.OreDictionary.registerOre("listAllsugar", ModItems.honeyComb);
        }

//Ore Recipes
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl), "blockMushroom", "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mineralMud), new ItemStack(ModItems.soda), new ItemStack(ModItems.salt), "itemCoal", new ItemStack(Items.clay_ball)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltMushroomStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), "blockMushroom", "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.vegetableStew), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltVegetableStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.potatoMushroom), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltPotatoMushroom), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedApple), "itemHoney", new ItemStack(Items.apple)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedPorkchop), "itemHoney", new ItemStack(Items.cooked_porkchop)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.shepherdsPie), new ItemStack(ModItems.salt), "itemRedmeat", new ItemStack(ModItems.dough), new ItemStack(Items.egg)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mushroomPie), new ItemStack(ModItems.salt), "blockMushroom", "blockMushroom", new ItemStack(Items.egg)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pickledMushroom), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), "blockMushroom", "blockMushroom"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.muffin), "itemRoyaljelly", new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.dough), new ItemStack(Items.egg)));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.apiary), "xxx", "yyy", "xxx", 'x', "plankWood", 'y', Items.item_frame) );
    }
}
