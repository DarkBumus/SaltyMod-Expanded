package darkbum.saltmod.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.api.ExtractRegistry;
import darkbum.saltmod.init.AchievSalt;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.SaltConfig;
import darkbum.saltmod.world.SaltCrystalGenerator;
import darkbum.saltmod.world.SaltDeepslateOreGenerator;
import darkbum.saltmod.world.SaltLakeGenerator;
import darkbum.saltmod.world.SaltOreGenerator;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import darkbum.saltmod.SaltMod;
import darkbum.saltmod.dispenser.DispenserBehaviorRainmaiker;
import darkbum.saltmod.dispenser.DispenserBehaviorSaltPinch;
import darkbum.saltmod.entity.DropHandler;
import darkbum.saltmod.entity.EntityRainmaker;
import darkbum.saltmod.entity.EntityRainmakerDust;
import darkbum.saltmod.inventory.gui.GuiExtractorHandler;
import darkbum.saltmod.network.ExtractorButtonMessage;
import darkbum.saltmod.network.SaltModEvent;
import darkbum.saltmod.network.SaltWortMessage;
import darkbum.saltmod.tileentity.TileEntityExtractor;

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
        NetworkRegistry.INSTANCE.registerGuiHandler(SaltMod.instance, new GuiExtractorHandler());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("SaltMod");
        network.registerMessage(ExtractorButtonMessage.Handler.class, ExtractorButtonMessage.class, 0, Side.SERVER);
        network.registerMessage(SaltWortMessage.Handler.class, SaltWortMessage.class, 1, Side.CLIENT);
    }

    public void init(FMLInitializationEvent event) {

        AchievSalt.init();
        ClientProxy.setBlockRenderers();
        MinecraftForge.EVENT_BUS.register(new DropHandler());
        if (event.getSide().isClient())
            ClientProxy.setEntityRenderers();



        GameRegistry.registerTileEntity(TileEntityExtractor.class, "tileEntityExtractor");


        EntityRegistry.registerModEntity(EntityRainmaker.class, "entityRainmaker", 0, SaltMod.instance, 64, 20, true);
        EntityRegistry.registerModEntity(EntityRainmakerDust.class, "entityRainmakerDust", 1, SaltMod.instance, 64, 20, false);


        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaiker());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.saltPinch, new DispenserBehaviorSaltPinch());


        GameRegistry.registerWorldGenerator(saltOreGenerator, 0);
        GameRegistry.registerWorldGenerator(saltDeepslateOreGenerator, 0);
        GameRegistry.registerWorldGenerator(saltCrystalGenerator, 10);
        GameRegistry.registerWorldGenerator(saltLakeGenerator, 15);


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
        OreDictionary.registerOre("Redmeats", ModItems.haunchCooked);
        OreDictionary.registerOre("Sweeteners", Items.sugar);
        OreDictionary.registerOre("Honeys", ModItems.honeyComb);
        OreDictionary.registerOre("RoyalJellies", ModItems.royalJelly);
        OreDictionary.registerOre("logWood", ModBlocks.blossomLog);
        OreDictionary.registerOre("logWood", ModBlocks.blossomStrippedLog);
        OreDictionary.registerOre("logWood", ModBlocks.blossomBark);
        OreDictionary.registerOre("plankWood", ModBlocks.blossomPlanks);
        OreDictionary.registerOre("treeLeaves", ModBlocks.blossomLeaves);

// D E B U G // T E S T I N G //
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.mudBrickWet, 1, 1), new ItemStack(ModBlocks.mudBrickWet), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.mudBrickWet, 1, 2), new ItemStack(ModBlocks.mudBrickWet, 1, 1), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 1), new ItemStack(ModBlocks.apiary), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 2), new ItemStack(ModBlocks.apiary, 1, 1), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 3), new ItemStack(ModBlocks.apiary, 1, 2), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 4), new ItemStack(ModBlocks.apiary, 1, 3), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 5), new ItemStack(ModBlocks.apiary, 1, 4), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 6), new ItemStack(ModBlocks.apiary, 1, 5), new ItemStack(Items.stick));
// D E B U G // T E S T I N G //

//  Salty Food Rules:				1. Salt/Sugar Pinch, 2. Ingredient
//  Bowl Rules:					1. Salt/Sugar Pinch, 2. Bowl, 3. Ingredients (Apple-Carrot-Melon-Potato-Mushroom-Fish-Seeds/Saltwort-Dandelion-Allium
//  Honeyed Food Rules:			1. Honey, 2. Food
//  Chocolate Food Rules:			1. Cocoa Beans, 2. Food
//  Pie Rules:					1. Salt/Sugar Pinch, 2. Ingredients, 3. Wheat, 4. Egg,
//  Fermented Ingredient Rules:	1. Ghast Tear, 2. Glass Bottle, 3. Ingredient
//  Pickled Ingredient Rules:		1. Salt Pinch, 2. Water Bottle, 3. Ingredient
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 9),  new ItemStack(ModItems.salt) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarPinch, 9), new ItemStack(Items.sugar) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 5) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 6) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 7) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 8) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBlock, 1, 9) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltLamp) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.salt, 9), new ItemStack(ModBlocks.saltBrickStair) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new ItemStack(ModBlocks.saltSlab, 1, 0) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new ItemStack(ModBlocks.saltSlab, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch, 40), new ItemStack(ModBlocks.saltSlab, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPinch), new ItemStack(ModBlocks.saltCrystal) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltDirt), new ItemStack(ModItems.salt), new ItemStack(Blocks.dirt) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.saltDirt), new ItemStack(ModBlocks.saltDirtLite), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.saltPinch) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud), new ItemStack(ModItems.soda), new ItemStack(ModItems.salt), new ItemStack(Items.coal), new ItemStack(Items.clay_ball) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud), new ItemStack(ModItems.soda), new ItemStack(ModItems.salt), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.clay_ball) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mineralMud, 4), new ItemStack(ModBlocks.mudBlock) );

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomLog) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomStrippedLog) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomBark) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blossomPlanks, 4), new ItemStack(ModBlocks.blossomStrippedBark) );

        GameRegistry.addShapelessRecipe(new ItemStack(Items.carrot, 9), new ItemStack(ModBlocks.storageCrate) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.potato, 9), new ItemStack(ModBlocks.storageCrate, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.poisonous_potato, 9), new ItemStack(ModBlocks.storageCrate, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.red_flower, 9, 2), new ItemStack(ModBlocks.storageCrate, 1, 3) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9), new ItemStack(ModBlocks.storageBarrel) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 1), new ItemStack(ModBlocks.storageBarrel, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 2), new ItemStack(ModBlocks.storageBarrel, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.fish, 9, 3), new ItemStack(ModBlocks.storageBarrel, 1, 3) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 9), new ItemStack(ModBlocks.storageSack) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.melon_seeds, 9), new ItemStack(ModBlocks.storageSack, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds, 9), new ItemStack(ModBlocks.storageSack, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortSeed, 9), new ItemStack(ModBlocks.storageSack, 1, 3) );

        GameRegistry.addShapelessRecipe(new ItemStack(Items.milk_bucket), new ItemStack(ModItems.powderedMilk), new ItemStack(Items.water_bucket), new ItemStack(Items.bucket) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 2), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 9), new ItemStack(ModItems.blossom) );

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeefCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_beef) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPorkchopCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_porkchop) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHaunchCooked), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.haunchCooked) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPotatoBaked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.baked_potato) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltChickenCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_chicken) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishCod), new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishCodCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_fished) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmon), new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonCooked), new ItemStack(ModItems.saltPinch), new ItemStack(Items.cooked_fished, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfish), new ItemStack(ModItems.saltPinch), new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishCooked), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishClownfishCooked) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCalamariCooked), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.calamariCooked) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBread), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bread) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltEgg), new ItemStack(ModItems.saltPinch), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltMushroomStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.mushroom_stew) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pumpkinPorridge), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPumpkinPorridge), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Blocks.pumpkin) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPumpkinPorridge), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.pumpkinPorridge) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cactusStew), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCactusStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltCactusStew), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.cactusStew) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltVegetableStew), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.vegetableStew) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltPotatoMushroom), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.potatoMushroom) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenVegetables), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(ModItems.goldenPotato), new ItemStack(ModItems.goldenSaltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltGoldenVegetables), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.goldenVegetables) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltGoldenVegetables), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_carrot), new ItemStack(ModItems.goldenPotato), new ItemStack(ModItems.goldenSaltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSoup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSalmonSoup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishSalmonSoup), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishSalmonSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishClownfishSoup), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltFishClownfishSoup), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.fishClownfishSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dandelionSalad), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Blocks.yellow_flower), new ItemStack(Blocks.red_flower, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltDandelionSalad), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Blocks.yellow_flower), new ItemStack(Blocks.red_flower, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltDandelionSalad), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.dandelionSalad) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wheatSprouts), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWheatSprouts), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds), new ItemStack(Items.wheat_seeds) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWheatSprouts), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.wheatSprouts) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortSalad), new ItemStack(Items.bowl), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenSaltWortSalad), new ItemStack(Items.bowl), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed), new ItemStack(ModItems.goldenSaltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortBeef), new ItemStack(Items.bowl), new ItemStack(Items.cooked_beef), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortPorkchop), new ItemStack(Items.bowl), new ItemStack(Items.cooked_porkchop), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortHoneyedPorkchop), new ItemStack(Items.bowl), new ItemStack(ModItems.honeyedPorkchop), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortHaunch), new ItemStack(Items.bowl), new ItemStack(ModItems.haunchCooked), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarApple), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.apple) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelon), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.fruitSalad) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGoldenFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.goldenFruitSalad) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gratedCarrot), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGratedCarrot), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.carrot) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGratedCarrot), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.gratedCarrot) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.melonSoup), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelonSoup), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.melon), new ItemStack(Items.melon), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarMelonSoup), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.melonSoup) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolatePie), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.carrotPie), new ItemStack(Items.sugar), new ItemStack(Items.carrot), new ItemStack(Items.carrot), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.applePie), new ItemStack(Items.sugar), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.potatoPie), new ItemStack(ModItems.salt), new ItemStack(Items.potato), new ItemStack(Items.potato), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onionPie), new ItemStack(ModItems.salt), new ItemStack(Blocks.red_flower, 1, 2), new ItemStack(Blocks.red_flower, 1, 2), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishPie), new ItemStack(ModItems.salt), new ItemStack(Items.fish), new ItemStack(Items.wheat), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishSalmonPie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 1), new ItemStack(Items.wheat), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fishClownfishPie), new ItemStack(ModItems.salt), new ItemStack(Items.fish, 1, 2), new ItemStack(Items.wheat), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.calamariPie), new ItemStack(ModItems.salt), new ItemStack(ModItems.calamariRaw), new ItemStack(Items.wheat), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortPie), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(Items.wheat), new ItemStack(Items.egg) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fermentedSaltWort), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledFern), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(Blocks.tallgrass, 1, 2), new ItemStack(Blocks.tallgrass, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledCalamari), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(ModItems.calamariRaw), new ItemStack(ModItems.calamariRaw) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pickledOnion), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(Blocks.red_flower, 1, 2), new ItemStack(Blocks.red_flower, 1, 2) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedMelon), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(Items.melon), new ItemStack(Items.melon) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedApple), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(Items.apple), new ItemStack(Items.apple) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cobblerConcoction), new ItemStack(Items.ghast_tear), new ItemStack(Items.glass_bottle), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.sugarPinch), new ItemStack(ModItems.soda), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.mineralMud), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fizzyDrink), new ItemStack(ModItems.soda), new ItemStack(Items.potionitem) );

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltStar), new ItemStack(Items.gunpowder), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.salt), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda), new ItemStack(ModItems.soda) );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rainmaker), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(ModItems.saltStar), new ItemStack(Items.paper), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder) );


        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.mushroom_stew), new ItemStack(Items.bowl), "Mushrooms", "Mushrooms"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.shepherdsPie), new ItemStack(ModItems.salt), "RedMeats", new ItemStack(Items.wheat), new ItemStack(Items.egg) ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedApple), "Honeys", new ItemStack(Items.apple) ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedPorkchop), "Honeys", new ItemStack(Items.cooked_porkchop) ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.muffin), new ItemStack(ModItems.soda), "RoyalJellies", new ItemStack(Items.dye, 1, 3), new ItemStack(Items.wheat), new ItemStack(Items.egg) ));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.apiary), "xxx", "yyy", "xxx", 'x', "plankWood", 'y', Items.item_frame) );

        GameRegistry.addRecipe(new ItemStack(ModItems.salt), "xxx", "xxx", "xxx", 'x', ModItems.saltPinch );
        GameRegistry.addRecipe(new ItemStack(ModItems.goldenSaltWortSeed), "xxx", "xyx", "xxx", 'x', Items.gold_nugget, 'y', ModItems.saltWortSeed );
        GameRegistry.addRecipe(new ItemStack(ModItems.goldenPotato), "xxx", "xyx", "xxx", 'x', Items.gold_nugget, 'y', Items.potato );
        GameRegistry.addRecipe(new ItemStack(Items.sugar), "xxx", "xxx", "xxx", 'x', ModItems.sugarPinch );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock), "xxx", "xxx", "xxx", 'x', ModItems.salt );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltLamp), "x", "y", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0), 'y', new ItemStack(Blocks.torch) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 4, 5), "xx", "xx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 2, 2), "x", "x", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 1), "x", "x", 'x', new ItemStack(ModBlocks.saltSlab, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 8), "x", "x", 'x', new ItemStack(ModBlocks.saltSlab, 1, 1) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock, 1, 9), "x", "x", 'x', new ItemStack(ModBlocks.saltSlab, 1, 2) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBrickStair, 6), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 5) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltSlab, 6, 0), "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 0) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltSlab, 6, 1), "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 5) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.saltSlab, 6, 2), "xxx", 'x', new ItemStack(ModBlocks.saltBlock, 1, 2) );

        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBlock), "xx", "xx", 'x', ModItems.mineralMud );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickWet, 2), "xy", "yx", 'x', ModBlocks.mudBlock, 'y', new ItemStack(Items.wheat) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickDryStairs), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.mudBrickDry) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mudBrickDrySlab), "xxx", 'x', new ItemStack(ModBlocks.mudBrickDry) );

        GameRegistry.addRecipe(new ItemStack(ModBlocks.blossomStairs), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.blossomPlanks) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blossomSlab), "xxx", 'x', new ItemStack(ModBlocks.blossomPlanks) );

        GameRegistry.addRecipe(new ItemStack(ModBlocks.extractor), "xyx", "x x", "xxx", 'x', Blocks.cobblestone, 'y', Items.cauldron );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate), "xxx", "xxx", "xxx", 'x', Items.carrot );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 1), "xxx", "xxx", "xxx", 'x', Items.potato );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 2), "xxx", "xxx", "xxx", 'x', Items.poisonous_potato );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 3), "xxx", "xxx", "xxx", 'x', new ItemStack(Blocks.red_flower, 1, 2) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel, 1, 1), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish, 1, 1) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel, 1, 2), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish, 1, 2) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageBarrel, 1, 3), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.fish, 1, 3) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack), "xxx", "xxx", "xxx", 'x', Items.wheat_seeds );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 1), "xxx", "xxx", "xxx", 'x', Items.melon_seeds );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 2), "xxx", "xxx", "xxx", 'x', Items.pumpkin_seeds );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 3), "xxx", "xxx", "xxx", 'x', ModItems.saltWortSeed );

        GameRegistry.addRecipe(new ItemStack(ModItems.cornedBeef), "xxx", "xyx", "xxx", 'x', ModItems.saltPinch, 'y', Items.rotten_flesh );
        GameRegistry.addRecipe(new ItemStack(ModItems.chocolateBar), "xyx", 'x', new ItemStack(Items.dye, 1, 3), 'y', ModItems.powderedMilk );

        GameRegistry.addRecipe(new ItemStack(ModItems.mudHelmet), "xxx", "x x", 'x', ModItems.mineralMud );
        GameRegistry.addRecipe(new ItemStack(ModItems.mudChestplate), "x x", "xxx", "xxx", 'x', ModItems.mineralMud );
        GameRegistry.addRecipe(new ItemStack(ModItems.mudLeggings), "xxx", "x x", "x x", 'x', ModItems.mineralMud );
        GameRegistry.addRecipe(new ItemStack(ModItems.mudBoots), "x x", "x x", 'x', ModItems.mineralMud );

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltMushroomStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), "Mushrooms", "Mushrooms" ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.vegetableStew), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "Mushrooms" ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltVegetableStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), "Mushrooms" ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.potatoMushroom), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "Mushrooms"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltPotatoMushroom), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.potato), new ItemStack(Items.potato), "Mushrooms" ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.mushroomPie), new ItemStack(ModItems.salt), "Mushrooms", "Mushrooms", new ItemStack(Items.egg) ));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pickledMushroom), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), "Mushrooms", "Mushrooms" ));


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
            GameRegistry.addShapelessRecipe(bop_poisondart, new ItemStack(bop_dart), ModItems.bop_poison );
        }


        if(Loader.isModLoaded("harvestcraft")) {
            Item honeycombItem = GameRegistry.findItem("harvestcraft", "honeycombItem");
            Item royaljellyItem = GameRegistry.findItem("harvestcraft", "royaljellyItem");
            if(honeycombItem != null) {
                OreDictionary.registerOre("Sweeteners", honeycombItem);
                OreDictionary.registerOre("Honeys", honeycombItem);
            }
            if(royaljellyItem != null) {
                OreDictionary.registerOre("RoyalJellies", royaljellyItem);
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

        if(Loader.isModLoaded("netherlicious")) {
            Item StriderFlankCooked = GameRegistry.findItem("netherlicious", "StriderFlankCooked");
            if(StriderFlankCooked != null) {
                OreDictionary.registerOre("itemRedmeats", StriderFlankCooked);
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltStriderCooked), new ItemStack(ModItems.saltPinch), new ItemStack(StriderFlankCooked) );
            }
        }

        if(Loader.isModLoaded("etfuturum")) {
            Item mutton_cooked = GameRegistry.findItem("etfuturum", "mutton_cooked");
            Item rabbit_cooked = GameRegistry.findItem("etfuturum", "rabbit_cooked");
            Item rabbit_stew = GameRegistry.findItem("etfuturum", "rabbit_stew");
            Item beetroot = GameRegistry.findItem("etfuturum", "beetroot");
            Item beetroot_seeds = GameRegistry.findItem("etfuturum", "beetroot_seeds");
            Item beetroot_soup = GameRegistry.findItem("etfuturum", "beetroot_soup");
            Item sweet_berries = GameRegistry.findItem("etfuturum", "sweet_berries");
            if(mutton_cooked != null) {
                OreDictionary.registerOre("itemRedmeats", mutton_cooked);
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltMuttonCooked), new ItemStack(ModItems.saltPinch), new ItemStack(mutton_cooked) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltWortMutton), new ItemStack(Items.bowl), new ItemStack(mutton_cooked), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
            }
            if(rabbit_cooked != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltRabbitCooked), new ItemStack(ModItems.saltPinch), new ItemStack(rabbit_cooked) );
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.saltRabbitStew), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(rabbit_cooked), new ItemStack(Items.carrot), new ItemStack(Items.baked_potato), "Mushrooms" ));
            }
            if(rabbit_stew != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltRabbitStew), new ItemStack(ModItems.saltPinch), new ItemStack(rabbit_stew) );
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rabbit_stew), new ItemStack(Items.bowl), new ItemStack(rabbit_cooked), new ItemStack(Items.carrot), new ItemStack(Items.baked_potato), "Mushrooms" ));
            }
            if(beetroot != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(beetroot, 9), new ItemStack(ModBlocks.storageCrate, 1, 4) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetroot), new ItemStack(ModItems.saltPinch), new ItemStack(beetroot) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSoup), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.beetrootSalad), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSalad), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSalad), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.beetrootSalad) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.herringUFC), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot), new ItemStack(Items.egg), new ItemStack(Items.fish), new ItemStack(Blocks.red_flower, 1, 2) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHerringUFC), new ItemStack(ModItems.saltPinch), new ItemStack(Items.bowl), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(beetroot), new ItemStack(Items.egg), new ItemStack(Items.fish), new ItemStack(Blocks.red_flower, 1, 2) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltHerringUFC), new ItemStack(ModItems.saltPinch), new ItemStack(ModItems.herringUFC) );
                GameRegistry.addRecipe(new ItemStack(ModBlocks.storageCrate, 1, 4), "xxx", "xxx", "xxx", 'x', new ItemStack(beetroot) );
            }
            if(beetroot_seeds != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(beetroot_seeds, 9), new ItemStack(ModBlocks.storageSack, 1, 4) );
                GameRegistry.addRecipe(new ItemStack(ModBlocks.storageSack, 1, 4), "xxx", "xxx", "xxx", 'x', new ItemStack(beetroot_seeds) );
            }
            if(beetroot_soup != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(beetroot_soup), new ItemStack(Items.bowl), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot), new ItemStack(beetroot) );
//                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.saltBeetrootSoup), new ItemStack(ModItems.saltPinch), new ItemStack(beetroot_soup) );
            }
            if(sweet_berries != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolateBerries), new ItemStack(Items.dye, 1, 3), new ItemStack(sweet_berries) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sweetberryPie), new ItemStack(Items.sugar), new ItemStack(sweet_berries), new ItemStack(sweet_berries), new ItemStack(Items.egg) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarBerries), new ItemStack(ModItems.sugarPinch), new ItemStack(sweet_berries) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fruitSalad), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(sweet_berries), new ItemStack(Items.melon) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(sweet_berries), new ItemStack(Items.melon) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldenFruitSalad), new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(ModItems.goldenBerries), new ItemStack(Items.speckled_melon) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarGoldenFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.golden_apple), new ItemStack(ModItems.goldenBerries), new ItemStack(Items.speckled_melon) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preservedSweetberries), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.potionitem), new ItemStack(sweet_berries), new ItemStack(sweet_berries) );
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.honeyedBerries), "Honeys", new ItemStack(sweet_berries) ));
                GameRegistry.addRecipe(new ItemStack(ModItems.goldenBerries), "xxx", "xyx", "xxx", 'x', Items.gold_nugget, 'y', new ItemStack(sweet_berries) );
            }
        } else {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fruitSalad), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(Items.carrot), new ItemStack(Items.melon) );
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sugarFruitSalad), new ItemStack(ModItems.sugarPinch), new ItemStack(Items.bowl), new ItemStack(Items.apple), new ItemStack(Items.carrot), new ItemStack(Items.melon) );
        }

        if(Loader.isModLoaded("TwilightForest")) {
            Item venisonCooked = GameRegistry.findItem("TwilightForest", "item.venisonCooked");
            Item meefSteak = GameRegistry.findItem("TwilightForest", "item.meefSteak");
            Item meefStroganoff = GameRegistry.findItem("TwilightForest", "item.meefStroganoff");
            Item hydraChop = GameRegistry.findItem("TwilightForest", "item.hydraChop");
            Item mushgloom = GameRegistry.findItem("TwilightForest", "tile.TFPlant");
            if(venisonCooked != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltVenisonCooked), new ItemStack(ModItems.saltPinch), new ItemStack(venisonCooked) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltWortVenison), new ItemStack(Items.bowl), new ItemStack(venisonCooked), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
            }
            if(meefSteak != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltMeefSteak), new ItemStack(ModItems.saltPinch), new ItemStack(meefSteak) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltWortMeefSteak), new ItemStack(Items.bowl), new ItemStack(meefSteak), new ItemStack(ModItems.saltWortSeed), new ItemStack(ModItems.saltWortSeed) );
            }
            if(meefStroganoff != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltMeefStroganoff), new ItemStack(ModItems.saltPinch), new ItemStack(meefStroganoff) );
            }
            if(hydraChop != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_saltHydraChop), new ItemStack(ModItems.saltPinch), new ItemStack(hydraChop) );
            }
            if(mushgloom != null) {
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tf_pickledMushgloom), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(mushgloom, 1, 9), new ItemStack(mushgloom, 1, 9) );
            }
        }

        if(Loader.isModLoaded("BiomesOPlenty")) {
            Item food = GameRegistry.findItem("BiomesOPlenty", "food");
            if(food != null) {
                OreDictionary.registerOre("Sweeteners", new ItemStack(food, 1, 9));
                OreDictionary.registerOre("Honeys", new ItemStack(food, 1, 9));
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltShroomPowder), new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 1) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_sugarSaladFruit), new ItemStack(ModItems.sugarPinch), new ItemStack(food, 1, 4) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltSaladVeggie), new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 5) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltSaladShroom), new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 6) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_saltRiceBowl), new ItemStack(ModItems.saltPinch), new ItemStack(food, 1, 13) );
                GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bop_pickledTurnip), new ItemStack(ModItems.saltPinch), new ItemStack(Items.potionitem), new ItemStack(food, 1, 11), new ItemStack(food, 1, 11) );
            }
        }
    }
}
