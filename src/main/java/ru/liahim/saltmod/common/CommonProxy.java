package ru.liahim.saltmod.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IIcon;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ru.liahim.saltmod.SaltMod;
import ru.liahim.saltmod.api.ExtractRegistry;
import ru.liahim.saltmod.dispenser.DispenserBehaviorRainmaiker;
import ru.liahim.saltmod.dispenser.DispenserBehaviorSaltPinch;
import ru.liahim.saltmod.entity.EntityRainmaker;
import ru.liahim.saltmod.entity.EntityRainmakerDust;
import ru.liahim.saltmod.init.AchievSalt;
import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.ModItems;
import ru.liahim.saltmod.init.SaltConfig;
import ru.liahim.saltmod.inventory.gui.GuiExtractorHandler;
import ru.liahim.saltmod.network.ExtractorButtonMessage;
import ru.liahim.saltmod.network.SaltModEvent;
import ru.liahim.saltmod.network.SaltWortMessage;
import ru.liahim.saltmod.tileentity.TileEntityExtractor;
import ru.liahim.saltmod.world.SaltCrystalGenerator;
import ru.liahim.saltmod.world.SaltDeepslateOreGenerator;
import ru.liahim.saltmod.world.SaltLakeGenerator;
import ru.liahim.saltmod.world.SaltOreGenerator;

public class CommonProxy {

  public static CreativeTabs saltTab = new SaltTab("saltTab");
  
  public static SaltOreGenerator saltOreGenerator = new SaltOreGenerator();
  
  public static SaltDeepslateOreGenerator saltDeepslateOreGenerator = new SaltDeepslateOreGenerator();
  
  public static SaltCrystalGenerator saltCrystalGenerator = new SaltCrystalGenerator();
  
  public static SaltLakeGenerator saltLakeGenerator = new SaltLakeGenerator();
  
  public static ItemArmor.ArmorMaterial mudMaterial = EnumHelper.addArmorMaterial("mudMaterial", 4, new int[] { 1, 1, 1, 1 }, 15);
  
  @SideOnly(Side.CLIENT)
  public static IIcon milkIcon;
  
  public static Fluid milk;
  
  public static SimpleNetworkWrapper network;


  public void preInit(FMLPreInitializationEvent event) {
    SaltModEvent sEvent = new SaltModEvent();
    FMLCommonHandler.instance().bus().register(sEvent);
    MinecraftForge.EVENT_BUS.register(sEvent);
    NetworkRegistry.INSTANCE.registerGuiHandler(SaltMod.instance, (IGuiHandler)new GuiExtractorHandler());
    network = NetworkRegistry.INSTANCE.newSimpleChannel("SaltMod");
    network.registerMessage(ExtractorButtonMessage.Handler.class, ExtractorButtonMessage.class, 0, Side.SERVER);
    network.registerMessage(SaltWortMessage.Handler.class, SaltWortMessage.class, 1, Side.CLIENT);
  }
  
  public void init(FMLInitializationEvent event) {

    AchievSalt.init();
    ClientProxy.setBlockRenderers();
    if (event.getSide().isClient())
      ClientProxy.setEntityRenderers(); 
    
    

    GameRegistry.registerTileEntity(TileEntityExtractor.class, "tileEntityExtractor");
    
    
    EntityRegistry.registerModEntity(EntityRainmaker.class, "entityRainmaker", 0, SaltMod.instance, 64, 20, true);
    EntityRegistry.registerModEntity(EntityRainmakerDust.class, "entityRainmakerDust", 1, SaltMod.instance, 64, 20, false);
    
    
    BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaiker());
    BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.saltPinch, new DispenserBehaviorSaltPinch());
    
    
    GameRegistry.registerWorldGenerator((IWorldGenerator)saltOreGenerator, 0);
    GameRegistry.registerWorldGenerator((IWorldGenerator)saltDeepslateOreGenerator, 0);
    GameRegistry.registerWorldGenerator((IWorldGenerator)saltCrystalGenerator, 10);
    GameRegistry.registerWorldGenerator((IWorldGenerator)saltLakeGenerator, 15);
    
    
    ExtractRegistry.instance().addExtracting(FluidRegistry.WATER, ModItems.saltPinch, 1000, 0.0F);
    
    
    ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
    ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
    ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltWortSeed), 2, 3, 3));
    ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
    ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.saltWortSeed), 2, 5, 5));
    ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
    ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
    ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltWortSeed), 2, 3, 3));
    ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltWortSeed), 2, 5, 5));

    
    OreDictionary.registerOre("oreSalt", ModBlocks.saltOre);
    OreDictionary.registerOre("oreSalt", ModBlocks.saltDeepslateOre);  
    OreDictionary.registerOre("SaltBlocks", new ItemStack(ModBlocks.saltBlock, 1, OreDictionary.WILDCARD_VALUE));
    OreDictionary.registerOre("MudBlocks", ModBlocks.mudBlock);
    OreDictionary.registerOre("MudBlocks", ModBlocks.mudBrickWet);
    OreDictionary.registerOre("MudBlocks", ModBlocks.mudBrickDry);
    OreDictionary.registerOre("Mushrooms", Blocks.red_mushroom);
    OreDictionary.registerOre("Mushrooms", Blocks.brown_mushroom);
    OreDictionary.registerOre("RedMeats", Items.cooked_beef);
    OreDictionary.registerOre("Sweeteners", Items.sugar);


//Salty Food Rules:				1. Salt/Sugar Pinch, 2. Ingredient
//Bowl Rules:					1. Salt/Sugar Pinch, 2. Bowl, 3. Ingredients (Apple-Carrot-Melon-Potato-Mushroom-Fish-Seeds/Saltwort-Dandelion-Allium
//Honeyed Food Rules:			1. Honey, 2. Food
//Chocolate Food Rules:			1. Cocoa Beans, 2. Food
//Pie Rules:					1. Salt/Sugar Pinch, 2. Ingredients, 3. Wheat, 4. Egg,
//Fermented Ingredient Rules:	1. Ghast Tear, 2. Glass Bottle, 3. Ingredient
//Pickled Ingredient Rules:		1. Salt Pinch, 2. Water Bottle, 3. Ingredient
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 9), new Object[] { new ItemStack(ModItems.salt) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarPinch, 9), new Object[] { new ItemStack(Items.sugar) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 1) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 5) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 6) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 7) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 8) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltBlock, 1, 9) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack(ModBlocks.saltLamp) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new Object[] { new ItemStack((Block)ModBlocks.saltBrickStair) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new Object[] { new ItemStack((Block)ModBlocks.saltSlab, 1, 0) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new Object[] { new ItemStack((Block)ModBlocks.saltSlab, 1, 1) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new Object[] { new ItemStack((Block)ModBlocks.saltSlab, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch), new Object[] { new ItemStack(ModBlocks.saltCrystal) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltDirt), new Object[] { new ItemStack(ModItems.salt), new ItemStack(Blocks.dirt) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltDirt), new Object[] { new ItemStack(ModBlocks.saltDirtLite), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.saltPinch) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud), new Object[] { new ItemStack(ModItems.soda), new ItemStack(ModItems.salt), new ItemStack(Items.coal), new ItemStack(Items.clay_ball) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud), new Object[] { new ItemStack(ModItems.soda), new ItemStack(ModItems.salt), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.clay_ball) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud, 4), new Object[] { new ItemStack(ModBlocks.mudBlock) });
    
    GameRegistry.addShapelessRecipe(new ItemStack(Items.milk_bucket), new Object[] { new ItemStack(ModItems.powderedMilk), new ItemStack(Items.water_bucket), new ItemStack(Items.bucket) });
    GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 2), new Object[] { new ItemStack(ModItems.saltWortSeed) });

    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeefCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_beef) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPorkchopCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_porkchop) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPotatoBaked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.baked_potato) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltChickenCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_chicken) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishCod), new Object[] {  new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishCodCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_fished) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmon), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish, 1, 1) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_fished, 1, 1) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfish), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBread), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bread) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltEgg), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltMushroomStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.mushroom_stew) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pumpkinPorridge), new Object[] { new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPumpkinPorridge), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPumpkinPorridge), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.pumpkinPorridge) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cactusStew), new Object[] { new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCactusStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus) });  
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCactusStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.cactusStew) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltVegetableStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.vegetableStew) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPotatoMushroom), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.potatoMushroom) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSoup), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishSoup) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSalmonSoup), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 1) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 1) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishSalmonSoup) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishClownfishSoup), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishClownfishSoup) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dandelionSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack((Block)Blocks.yellow_flower), new ItemStack((Block)Blocks.red_flower, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltDandelionSalad), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack((Block)Blocks.yellow_flower), new ItemStack((Block)Blocks.red_flower, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltDandelionSalad), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.dandelionSalad) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wheatSprouts), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWheatSprouts), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWheatSprouts), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.wheatSprouts) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenSaltWortSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortBeef), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.cooked_beef), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortPorkchop), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.cooked_porkchop), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortHoneyedPorkchop), new Object[] { new ItemStack(Items.bowl), new ItemStack(ModItems.honeyedPorkchop), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarApple), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.apple) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelon), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.melon) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.fruitSalad) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGoldenFruitSalad), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.goldenFruitSalad) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gratedCarrot), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGratedCarrot), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGratedCarrot), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.gratedCarrot) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melonSoup), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelonSoup), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelonSoup), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.melonSoup) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolatePie), new Object[] { new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.carrotPie), new Object[] { new ItemStack(Items.sugar), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.applePie), new Object[] { new ItemStack(Items.sugar), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.potatoPie), new Object[] { new ItemStack(ModItems.salt), new ItemStack(Items.potato), new ItemStack(Items.potato), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onionPie), new Object[] { new ItemStack(ModItems.salt), new ItemStack((Block)Blocks.red_flower, 1, 2), new ItemStack((Block)Blocks.red_flower, 1, 2), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishPie), new Object[] { new ItemStack(ModItems.salt), new ItemStack(Items.fish), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSalmonPie), new Object[] { new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 1), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishClownfishPie), new Object[] { new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 2), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortPie), new Object[] { new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fermentedSaltWort), new Object[] { new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledFern), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack((Block)Blocks.tallgrass, 1, 2), new ItemStack((Block)Blocks.tallgrass, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledOnion), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack((Block)Blocks.red_flower, 1, 2), new ItemStack((Block)Blocks.red_flower, 1, 2) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedMelon), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(Items.melon), new ItemStack(Items.melon) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedApple), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(Items.apple), new ItemStack(Items.apple) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cobblerConcoction), new Object[] { new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.soda), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.mineralMud), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fizzyDrink), new Object[] { new ItemStack(ModItems.soda), new ItemStack(Items.potionitem) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.muffin), new Object[] { new ItemStack(ModItems.soda), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
    
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltStar), new Object[] { new ItemStack(Items.gunpowder), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda) });
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rainmaker), new Object[] { new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(Items.paper), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder) });
    
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.mushroom_stew), new Object[] {new ItemStack(Items.bowl), "Mushrooms", "Mushrooms"}));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.shepherdsPie), new Object[] { new ItemStack(ModItems.salt), "RedMeats", new ItemStack(Items.wheat), new ItemStack(Items.egg) }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedApple), new Object[] { "Honeys", new ItemStack(Items.apple) }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedPorkchop), new Object[] { "Honeys", new ItemStack(Items.cooked_porkchop) }));
    
    GameRegistry.addRecipe(new ItemStack(ModItems.salt), new Object[] { "xxx", "xxx", "xxx", Character.valueOf('x'), ModItems.saltPinch });
    GameRegistry.addRecipe(new ItemStack(ModItems.goldenSaltWortSeed), new Object[] { "xxx", "xyx", "xxx", Character.valueOf('x'), Items.gold_nugget, Character.valueOf('y'), ModItems.saltWortSeed });
    GameRegistry.addRecipe(new ItemStack(Items.sugar), new Object[] { "xxx", "xxx", "xxx", Character.valueOf('x'), ModItems.sugarPinch });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock), new Object[] { "xxx", "xxx", "xxx", Character.valueOf('x'), ModItems.salt });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltLamp), new Object[] { "x", "y", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 0), Character.valueOf('y'), new ItemStack(Blocks.torch) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 4, 5), new Object[] { "xx", "xx", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 0) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 2, 2), new Object[] { "x", "x", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 0) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 1), new Object[] { "x", "x", Character.valueOf('x'), new ItemStack((Block)ModBlocks.saltSlab, 1, 0) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 8), new Object[] { "x", "x", Character.valueOf('x'), new ItemStack((Block)ModBlocks.saltSlab, 1, 1) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 9), new Object[] { "x", "x", Character.valueOf('x'), new ItemStack((Block)ModBlocks.saltSlab, 1, 2) });
    GameRegistry.addRecipe(new ItemStack((Block)ModBlocks.saltBrickStair, 6), new Object[] { "x  ", "xx ", "xxx", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 5) });
    GameRegistry.addRecipe(new ItemStack((Block)ModBlocks.saltSlab, 6, 0), new Object[] { "xxx", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 0) });
    GameRegistry.addRecipe(new ItemStack((Block)ModBlocks.saltSlab, 6, 1), new Object[] { "xxx", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 5) });
    GameRegistry.addRecipe(new ItemStack((Block)ModBlocks.saltSlab, 6, 2), new Object[] { "xxx", Character.valueOf('x'), new ItemStack(ModBlocks.saltBlock, 1, 2) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBlock), new Object[] { "xx", "xx", Character.valueOf('x'), ModItems.mineralMud });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickWet, 2), new Object[] { "xy", "yx", Character.valueOf('x'), ModBlocks.mudBlock, Character.valueOf('y'), new ItemStack(Items.wheat) });
    GameRegistry.addRecipe(new ItemStack(ModBlocks.extractor), new Object[] { "xyx", "x x", "xxx", Character.valueOf('x'), Blocks.cobblestone, Character.valueOf('y'), Items.cauldron });
    
    GameRegistry.addRecipe(new ItemStack(ModItems.cornedBeef), new Object[] { "xxx", "xyx", "xxx", Character.valueOf('x'), ModItems.saltPinch, Character.valueOf('y'), Items.rotten_flesh });
    GameRegistry.addRecipe(new ItemStack(ModItems.chocolateBar), new Object[] { "xyx", Character.valueOf('x'), new ItemStack(Items.dye, 1, 3), Character.valueOf('y'), ModItems.powderedMilk });
    
    GameRegistry.addRecipe(new ItemStack(ModItems.mudHelmet), new Object[] { "xxx", "x x", Character.valueOf('x'), ModItems.mineralMud });
    GameRegistry.addRecipe(new ItemStack(ModItems.mudChestplate), new Object[] { "x x", "xxx", "xxx", Character.valueOf('x'), ModItems.mineralMud });
    GameRegistry.addRecipe(new ItemStack(ModItems.mudLeggings), new Object[] { "xxx", "x x", "x x", Character.valueOf('x'), ModItems.mineralMud });
    GameRegistry.addRecipe(new ItemStack(ModItems.mudBoots), new Object[] { "x x", "x x", Character.valueOf('x'), ModItems.mineralMud });
    
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltMushroomStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), "Mushrooms", "Mushrooms" }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.vegetableStew), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "Mushrooms" }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltVegetableStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "Mushrooms" }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.potatoMushroom), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "Mushrooms"}));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltPotatoMushroom), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "Mushrooms" }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mushroomPie), new Object[] { new ItemStack(ModItems.salt), "Mushrooms", "Mushrooms", new ItemStack(Items.egg) }));
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pickledMushroom), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), "Mushrooms", "Mushrooms" }));
    
    
    GameRegistry.addSmelting(ModBlocks.saltOre, new ItemStack(ModItems.salt, 1), 0.7F);
    GameRegistry.addSmelting(ModBlocks.saltLake, new ItemStack(ModItems.salt, 1), 0.7F);
    GameRegistry.addSmelting(new ItemStack(ModBlocks.saltBlock, 1, 0), new ItemStack(ModBlocks.saltBlock, 1, 6), 0.1F);
    GameRegistry.addSmelting(new ItemStack(ModBlocks.saltBlock, 1, 5), new ItemStack(ModBlocks.saltBlock, 1, 7), 0.1F);
    GameRegistry.addSmelting(ModItems.saltWortSeed, new ItemStack(ModItems.soda, 1), 0.0F);

    if(!SaltConfig.mudBrickComplex) {
    GameRegistry.addSmelting(new ItemStack(ModBlocks.mudBrickWet), new ItemStack(ModBlocks.mudBrickDry), 0.1F);
    }
  }
  
  public void postInit(FMLPostInitializationEvent event) { 
    if (FluidRegistry.isFluidRegistered("milk")) {
      Fluid milk = FluidRegistry.getFluid("milk");
      ExtractRegistry.instance().addExtracting(milk, ModItems.powderedMilk, 1000, 0.0F);
    } else {
      CommonProxy.milk = new Fluid("milk");
      FluidRegistry.registerFluid(CommonProxy.milk);
      FluidContainerRegistry.registerFluidContainer(new FluidStack(CommonProxy.milk, 1000), new ItemStack(Items.milk_bucket), FluidContainerRegistry.EMPTY_BUCKET);
      ExtractRegistry.instance().addExtracting(CommonProxy.milk, ModItems.powderedMilk, 1000, 0.0F);
    } 
    if (FluidRegistry.isFluidRegistered("blood")) {
      Fluid blood = FluidRegistry.getFluid("blood");
      GameRegistry.registerItem(ModItems.hemoglobin, "hemoglobin");
      ExtractRegistry.instance().addExtracting(blood, ModItems.hemoglobin, 1000, 1.0F);
    } 
    if (FluidRegistry.isFluidRegistered("hell_blood")) {
      Fluid blood = FluidRegistry.getFluid("hell_blood");
      GameRegistry.registerItem(ModItems.hemoglobin, "hemoglobin");
      ExtractRegistry.instance().addExtracting(blood, ModItems.hemoglobin, 1000, 1.0F);
    }
    Item bop_dart = GameRegistry.findItem("BiomesOPlenty", "dart");
    ItemStack bop_poisondart = new ItemStack(bop_dart, 1, 1);
    if (bop_dart != null && FluidRegistry.isFluidRegistered("poison")) {
      Fluid poisonFl = FluidRegistry.getFluid("poison");
      GameRegistry.registerItem(ModItems.bop_poison, "bop_poison");
      ExtractRegistry.instance().addExtracting(poisonFl, ModItems.bop_poison, 1000, 1.0F);
      GameRegistry.addShapelessRecipe(bop_poisondart, new Object[] { new ItemStack(bop_dart), ModItems.bop_poison });
    }


    if(Loader.isModLoaded("harvestcraft")) {
        Item honeycombItem = GameRegistry.findItem("harvestcraft", "honeycombItem");
        if(honeycombItem != null) {
    OreDictionary.registerOre("Sweeteners", honeycombItem);
    OreDictionary.registerOre("Honeys", honeycombItem);
        }
    }

    if(Loader.isModLoaded("Forestry")) {
        Item beeCombs = GameRegistry.findItem("Forestry", "beeCombs");
        if(beeCombs != null) {
    OreDictionary.registerOre("Sweeteners", beeCombs);
    OreDictionary.registerOre("Honeys", beeCombs);
        }
    }

    if(Loader.isModLoaded("Growthcraft")) {
        Item honeyCombFilled = GameRegistry.findItem("Growthcraft|Bees", "grc.honeyCombFilled");
        if(honeyCombFilled != null) {
    OreDictionary.registerOre("Sweeteners", honeyCombFilled);
    OreDictionary.registerOre("Honeys", honeyCombFilled);
        }
    }

    if(Loader.isModLoaded("sbv")) {
    	Item golden_potato = GameRegistry.findItem("sbv", "golden_potato");
    	Item golden_berries = GameRegistry.findItem("sbv", "golden_berries");
    	Item cooked_haunch = GameRegistry.findItem("sbv", "cooked_haunch");
    	Item calamari = GameRegistry.findItem("sbv", "calamari");
    	Item cooked_calamari = GameRegistry.findItem("sbv", "cooked_calamari");
    	Item cooked_tropical_fish = GameRegistry.findItem("sbv", "cooked_tropical_fish");
    	if(golden_potato != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenVegetables), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(golden_potato), new ItemStack(ModItems.goldenSaltWortSeed) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltGoldenVegetables), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(golden_potato), new ItemStack(ModItems.goldenSaltWortSeed) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltGoldenVegetables), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.goldenVegetables) });
    	}
    	if(golden_berries != null) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenFruitSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(golden_berries), new ItemStack(Items.speckled_melon) });
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGoldenFruitSalad), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(golden_berries), new ItemStack(Items.speckled_melon) });
        }
    	if(cooked_haunch != null) {
    		OreDictionary.registerOre("itemRedmeats", cooked_haunch);
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHaunchCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(cooked_haunch)});
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortHaunch), new Object[] { new ItemStack(Items.bowl), new ItemStack(cooked_haunch), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    	}
    	if(calamari != null) {
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.calamariPie), new Object[] { new ItemStack(ModItems.salt), new ItemStack(calamari), new ItemStack(Items.wheat), new ItemStack(Items.egg) });
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledCalamari), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(calamari), new ItemStack(calamari) });
    	}
    	if(cooked_calamari != null) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCalamariCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(cooked_calamari) });
    	}
    	if(cooked_tropical_fish != null) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(cooked_tropical_fish) });
    	}
    } else {
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenFruitSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_carrot), new ItemStack(Items.speckled_melon) });
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGoldenFruitSalad), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_carrot), new ItemStack(Items.speckled_melon) });
    }
    
    if(Loader.isModLoaded("netherlicious")) {
    	Item StriderFlankCooked = GameRegistry.findItem("netherlicious", "StriderFlankCooked");
    	if(StriderFlankCooked != null) {
    		OreDictionary.registerOre("itemRedmeats", StriderFlankCooked);
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltStriderCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(StriderFlankCooked) });
    	}
    }
    
    if(Loader.isModLoaded("etfuturum")) {
    	Item mutton_cooked = GameRegistry.findItem("etfuturum", "mutton_cooked");
    	Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
    	Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
    	Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
    	Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
    	Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
    	if(mutton_cooked != null) {
    		OreDictionary.registerOre("itemRedmeats", mutton_cooked);
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltMuttonCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(mutton_cooked) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortMutton), new Object[] { new ItemStack(Items.bowl), new ItemStack(mutton_cooked), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    	}
    	if(rabbit_cooked != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltRabbitCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(rabbit_cooked) });
    		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltRabbitStew), new Object [] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(rabbit_cooked), new ItemStack(Items.carrot), new ItemStack(Items.baked_potato), "Mushrooms" }));
    	}
    	if(rabbit_stew != null) {
        	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rabbit_stew), new Object[] { new ItemStack(Items.bowl), new ItemStack(rabbit_cooked), new ItemStack(Items.carrot), new ItemStack(Items.baked_potato), "Mushrooms" }));
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltRabbitStew), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(rabbit_stew) });
    	}
    	if(beetroot != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetroot), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(beetroot) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.beetrootSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSalad), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSalad), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.beetrootSalad) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.herringUFC), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot), new ItemStack(Items.egg), new ItemStack(Items.fish), new ItemStack(Blocks.red_flower, 1, 2)});
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHerringUFC), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot), new ItemStack(Items.egg), new ItemStack(Items.fish), new ItemStack(Blocks.red_flower, 1, 2)});
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHerringUFC), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.herringUFC) });
    	}
    	if(beetroot_soup != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(beetroot_soup), new Object[] { new ItemStack(Items.bowl), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot) });
//      	  GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSoup), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(beetroot_soup) });
    	}
    	if(sweet_berries != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolateBerries), new Object[] { new ItemStack(Items.dye, 1, 3), new ItemStack(sweet_berries) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sweetberryPie), new Object [] { new ItemStack(Items.sugar), new ItemStack(sweet_berries), new ItemStack(sweet_berries), new ItemStack(Items.egg) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarBerries), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(sweet_berries) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fruitSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(sweet_berries), new ItemStack(Items.melon) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(sweet_berries), new ItemStack(Items.melon) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedSweetberries), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(sweet_berries), new ItemStack(sweet_berries) });
    		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedBerries), new Object[] { "Honeys", new ItemStack(sweet_berries) }));
    	}
    } else {
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fruitSalad), new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(Items.carrot), new ItemStack(Items.melon) });
        	GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(Items.carrot), new ItemStack(Items.melon) });
    }   
    
    if(Loader.isModLoaded("TwilightForest")) {
    	Item venisonCooked = GameRegistry.findItem("TwilightForest", "item.venisonCooked");
    	Item meefSteak = GameRegistry.findItem("TwilightForest", "item.meefSteak");
    	Item meefStroganoff = GameRegistry.findItem("TwilightForest", "item.meefStroganoff");
    	Item hydraChop = GameRegistry.findItem("TwilightForest", "item.hydraChop");
    	Item mushgloom = GameRegistry.findItem("TwilightForest", "tile.TFPlant");
    	if(venisonCooked != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltVenisonCooked), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(venisonCooked) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltWortVenison), new Object[] { new ItemStack(Items.bowl), new ItemStack(venisonCooked), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
    	}
    	if(meefSteak != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltMeefSteak), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(meefSteak) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltWortMeefSteak), new Object[] { new ItemStack(Items.bowl), new ItemStack(meefSteak), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) });
        }
    	if(meefStroganoff != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltMeefStroganoff), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(meefStroganoff) });
        }
    	if(hydraChop != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltHydraChop), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(hydraChop) });
        }
    	if(mushgloom != null) {
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_pickledMushgloom), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(mushgloom, 1, 9), new ItemStack(mushgloom, 1, 9) });
        }
    }
    
    if(Loader.isModLoaded("BiomesOPlenty")) {
    	Item food = GameRegistry.findItem("BiomesOPlenty", "food");
    	if(food != null) {
    		OreDictionary.registerOre("Sweeteners", new ItemStack(food, 1, 9));
    	    OreDictionary.registerOre("Honeys", new ItemStack(food, 1, 9));
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltShroomPowder), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 1) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_sugarSaladFruit), new Object[] { new ItemStack(ModItems.sugarPinch), new ItemStack(food, 1, 4) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltSaladVeggie), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 5) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltSaladShroom), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 6) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltRiceBowl), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 13) });
    		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_pickledTurnip), new Object[] { new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(food, 1, 11), new ItemStack(food, 1, 11) });
    	}
    }
  }
}