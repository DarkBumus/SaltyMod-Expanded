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
        if (event.getSide().isClient()) {
            ClientProxy.setEntityRenderers();
        }

        GameRegistry.registerTileEntity(TileEntityExtractor.class, "tileEntityExtractor");

        EntityRegistry.registerModEntity(EntityRainmaker.class, "entityRainmaker", 0, SaltMod.instance, 64, 20, true);
        EntityRegistry.registerModEntity(EntityRainmakerDust.class, "entityRainmakerDust", 1, SaltMod.instance, 64, 20, false);

        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaiker());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.saltPinch, new DispenserBehaviorSaltPinch());

        GameRegistry.registerWorldGenerator(saltOreGenerator, 0);
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

// D E B U G // T E S T I N G //
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.mudBrickWet, 1, 1), new ItemStack(ModBlocks.mudBrickWet), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.mudBrickWet, 1, 2), new ItemStack(ModBlocks.mudBrickWet, 1, 1), new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 1), new ItemStack(ModBlocks.apiary), new ItemStack(Items.stick));
        ItemStack stick = new ItemStack(Items.stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 2), new ItemStack(ModBlocks.apiary, 1, 1), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 3), new ItemStack(ModBlocks.apiary, 1, 2), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 4), new ItemStack(ModBlocks.apiary, 1, 3), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 5), new ItemStack(ModBlocks.apiary, 1, 4), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 6), new ItemStack(ModBlocks.apiary, 1, 5), stick);
// D E B U G // T E S T I N G //
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
