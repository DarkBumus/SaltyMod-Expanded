package darkbum.saltmod.common;

import cpw.mods.fml.common.Loader;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class OreDictionary {

    public static void init() {
//Salty Mod Ore Dictionaries
        net.minecraftforge.oredict.OreDictionary.registerOre("oreSalt", ModBlocks.saltOre);
        net.minecraftforge.oredict.OreDictionary.registerOre("SaltBlocks", new ItemStack(ModBlocks.saltBlock, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE));
        net.minecraftforge.oredict.OreDictionary.registerOre("MudBlocks", ModBlocks.mudBlock);
        net.minecraftforge.oredict.OreDictionary.registerOre("MudBlocks", ModBlocks.mudBrickWet);
        net.minecraftforge.oredict.OreDictionary.registerOre("MudBlocks", ModBlocks.mudBrickDry);
        net.minecraftforge.oredict.OreDictionary.registerOre("logWood", ModBlocks.blossomLog);
        net.minecraftforge.oredict.OreDictionary.registerOre("logWood", ModBlocks.blossomStrippedLog);
        net.minecraftforge.oredict.OreDictionary.registerOre("logWood", ModBlocks.blossomBark);
        net.minecraftforge.oredict.OreDictionary.registerOre("plankWood", ModBlocks.blossomPlanks);
        net.minecraftforge.oredict.OreDictionary.registerOre("treeLeaves", ModBlocks.blossomLeaves);
        net.minecraftforge.oredict.OreDictionary.registerOre("Mushrooms", Blocks.red_mushroom);
        net.minecraftforge.oredict.OreDictionary.registerOre("Mushrooms", Blocks.brown_mushroom);
        net.minecraftforge.oredict.OreDictionary.registerOre("RedMeats", Items.cooked_beef);
        net.minecraftforge.oredict.OreDictionary.registerOre("RedMeats", ModItems.haunchCooked);
        net.minecraftforge.oredict.OreDictionary.registerOre("Sweeteners", Items.sugar);
        net.minecraftforge.oredict.OreDictionary.registerOre("Honeys", ModItems.honeyComb);
        net.minecraftforge.oredict.OreDictionary.registerOre("RoyalJellies", ModItems.royalJelly);

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
    }
}
