package darkbum.saltymod.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.api.EvaporateRegistry;
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.tileentity.TileEntityBlossomSign;
import darkbum.saltymod.world.generator.*;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
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
import darkbum.saltymod.dispenser.DispenserBehaviorRainmaker;
import darkbum.saltymod.dispenser.DispenserBehaviorSaltPinch;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import darkbum.saltymod.inventory.gui.GuiEvaporatorHandler;
import darkbum.saltymod.network.EvaporatorButtonMessage;
import darkbum.saltymod.network.SaltyModEventHandler;
import darkbum.saltymod.network.SaltwortMessage;
import darkbum.saltymod.tileentity.TileEntityEvaporator;

public class CommonProxy {

    public static CreativeTabs tabSalt = new TabSalt("salt");

    public static SaltOreGenerator saltOreGenerator;

    public static SaltCrystalGenerator saltCrystalGenerator;

    public static SaltLakeGenerator saltLakeGenerator;

    public static BlossomTreeGenerator blossomTreeGenerator;

    public static SaltFlowerGenerator saltFlowerGenerator;

    public static ItemArmor.ArmorMaterial mudMaterial = EnumHelper.addArmorMaterial("mudMaterial", 5, new int[]{1, 3, 2, 1}, 15);

    @SideOnly(Side.CLIENT)
    public static IIcon milkIcon;

    public static Fluid milk;

    public static SimpleNetworkWrapper network;

    public void preInit(FMLPreInitializationEvent event) {
        SaltyModEventHandler sEvent = new SaltyModEventHandler();
        FMLCommonHandler.instance().bus().register(sEvent);
        MinecraftForge.EVENT_BUS.register(sEvent);
        NetworkRegistry.INSTANCE.registerGuiHandler(SaltyMod.instance, new GuiEvaporatorHandler());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("SaltyMod");
        network.registerMessage(EvaporatorButtonMessage.Handler.class, EvaporatorButtonMessage.class, 0, Side.SERVER);
        network.registerMessage(SaltwortMessage.Handler.class, SaltwortMessage.class, 1, Side.CLIENT);
    }

    public void init(FMLInitializationEvent event) {

        ModAchievementList.init();
        ClientProxy.setBlockRenderers();
        if (event.getSide().isClient()) {
            ClientProxy.setEntityRenderers();
        }

        GameRegistry.registerTileEntity(TileEntityEvaporator.class, "tileEntityEvaporator");
        GameRegistry.registerTileEntity(TileEntityBlossomSign.class, "tileEntityBlossomSign");

        EntityRegistry.registerModEntity(EntityRainmaker.class, "entityRainmaker", 0, SaltyMod.instance, 64, 20, true);
        EntityRegistry.registerModEntity(EntityRainmakerDust.class, "entityRainmakerDust", 1, SaltyMod.instance, 64, 20, false);

        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaker());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.salt_pinch, new DispenserBehaviorSaltPinch());

        saltOreGenerator = new SaltOreGenerator();
        GameRegistry.registerWorldGenerator(saltOreGenerator, 0);
        if(ModConfiguration.enableSaltCrystal) {
            saltCrystalGenerator = new SaltCrystalGenerator();
            GameRegistry.registerWorldGenerator(saltCrystalGenerator, 10);
        }
        if(ModConfiguration.enableSaltLakes) {
            saltLakeGenerator = new SaltLakeGenerator();
            GameRegistry.registerWorldGenerator(saltLakeGenerator, 15);
        }
        blossomTreeGenerator = new BlossomTreeGenerator();
        GameRegistry.registerWorldGenerator(blossomTreeGenerator, 0);
        if(ModConfiguration.enableSaltFlowers) {
            saltFlowerGenerator = new SaltFlowerGenerator();
            GameRegistry.registerWorldGenerator(saltFlowerGenerator, 0);
        }

        EvaporateRegistry.instance().addEvaporating(FluidRegistry.WATER, ModItems.salt_pinch, 1000, 0.0F);

        ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));
        ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));

// D E B U G // T E S T I N G //
        ItemStack stick = new ItemStack(Items.stick);

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.wet_mud_brick, 1, 1), new ItemStack(ModBlocks.wet_mud_brick), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.wet_mud_brick, 1, 2), new ItemStack(ModBlocks.wet_mud_brick, 1, 1), stick);

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 1), new ItemStack(ModBlocks.apiary), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 2), new ItemStack(ModBlocks.apiary, 1, 1), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 3), new ItemStack(ModBlocks.apiary, 1, 2), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 4), new ItemStack(ModBlocks.apiary, 1, 3), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 5), new ItemStack(ModBlocks.apiary, 1, 4), stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.apiary, 1, 6), new ItemStack(ModBlocks.apiary, 1, 5), stick);

//        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.salt_crusted_oak_log, 1, 1), new ItemStack(ModBlocks.salt_crusted_oak_log), stick);
//        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.salt_crusted_oak_log, 1, 2), new ItemStack(ModBlocks.salt_crusted_oak_log, 1, 1), stick);
// D E B U G // T E S T I N G //
    }

    public void postInit(FMLPostInitializationEvent event) {

        if (ModConfiguration.enableEvaporator) {
            if (FluidRegistry.isFluidRegistered("milk")) {
                Fluid milk = FluidRegistry.getFluid("milk");
                EvaporateRegistry.instance().addEvaporating(milk, ModItems.powdered_milk, 1000, 0.0F);
            } else {
                CommonProxy.milk = new Fluid("milk");
                FluidRegistry.registerFluid(CommonProxy.milk);
                FluidContainerRegistry.registerFluidContainer(new FluidStack(CommonProxy.milk, 1000), new ItemStack(Items.milk_bucket), FluidContainerRegistry.EMPTY_BUCKET);
                EvaporateRegistry.instance().addEvaporating(CommonProxy.milk, ModItems.powdered_milk, 1000, 0.0F);
            }
            if (FluidRegistry.isFluidRegistered("blood")) {
                Fluid blood = FluidRegistry.getFluid("blood");
                GameRegistry.registerItem(ModItems.bop_hemoglobin, "hemoglobin");
                EvaporateRegistry.instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
            }
            if (FluidRegistry.isFluidRegistered("hell_blood")) {
                Fluid blood = FluidRegistry.getFluid("hell_blood");
                GameRegistry.registerItem(ModItems.bop_hemoglobin, "hemoglobin");
                EvaporateRegistry.instance().addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
            }
            Item bop_dart = GameRegistry.findItem("BiomesOPlenty", "dart");
            ItemStack bop_poisondart = new ItemStack(bop_dart, 1, 1);
            if (bop_dart != null && FluidRegistry.isFluidRegistered("poison")) {
                Fluid poisonFl = FluidRegistry.getFluid("poison");
                GameRegistry.registerItem(ModItems.bop_poison, "bop_poison");
                EvaporateRegistry.instance().addEvaporating(poisonFl, ModItems.bop_poison, 1000, 1.0F);
                GameRegistry.addShapelessRecipe(bop_poisondart, new ItemStack(bop_dart), ModItems.bop_poison);
            }
        }
    }
}
