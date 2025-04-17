package darkbum.saltymod.common;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.configuration.configs.ModConfigurationEntities;
import darkbum.saltymod.dispenser.DispenserBehaviorBottle;
import darkbum.saltymod.dispenser.DispenserBehaviorPotion;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.tileentity.*;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
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
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.dispenser.DispenserBehaviorRainmaker;
import darkbum.saltymod.dispenser.DispenserBehaviorSaltPinch;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.inventory.gui.GuiHandler;
import darkbum.saltymod.network.EvaporatorButtonMessage;
import darkbum.saltymod.network.SaltwortMessage;
import darkbum.saltymod.network.events.*;
import darkbum.saltymod.world.generator.*;

public class CommonProxy {

    public static CreativeTabs tabSaltItems = new TabSaltItems("salt_items");
    public static CreativeTabs tabSaltBlocks = new TabSaltBlocks("salt_blocks");

    public static SaltOreGenerator saltOreGenerator;

    public static SaltCrystalGenerator saltCrystalGenerator;

    public static SaltLakeGenerator saltLakeGenerator;

    public static SaltFlowerGenerator saltFlowerGenerator;

    public static ItemArmor.ArmorMaterial mudMaterial = EnumHelper
        .addArmorMaterial("mudMaterial", 5, new int[] { 1, 3, 2, 1 }, 15);

    static int startEntityId = 600;

    @SideOnly(Side.CLIENT)
    public static IIcon milkIcon;

    public static Fluid milk;

    public static SimpleNetworkWrapper network;

    public void preInit(FMLPreInitializationEvent event) {
        AchievementEventHandler achievementEventHandler = new AchievementEventHandler();
        MinecraftForge.EVENT_BUS.register(achievementEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(achievementEventHandler);
        BreakHarvestDropsEventHandler breakHarvestDropsEventHandler = new BreakHarvestDropsEventHandler();
        MinecraftForge.EVENT_BUS.register(breakHarvestDropsEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(breakHarvestDropsEventHandler);
        EntityItemPickupEventHandler entityItemPickupEventHandler = new EntityItemPickupEventHandler();
        MinecraftForge.EVENT_BUS.register(entityItemPickupEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(entityItemPickupEventHandler);
        EntityJoinWorldEventHandler entityJoinWorldEventHandler = new EntityJoinWorldEventHandler();
        MinecraftForge.EVENT_BUS.register(entityJoinWorldEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(entityJoinWorldEventHandler);
        LivingDropsEventHandler livingDropsEventHandler = new LivingDropsEventHandler();
        MinecraftForge.EVENT_BUS.register(livingDropsEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(livingDropsEventHandler);
        PlayerItemCraftedEventHandler playerItemCraftedEventHandler = new PlayerItemCraftedEventHandler();
        MinecraftForge.EVENT_BUS.register(playerItemCraftedEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(playerItemCraftedEventHandler);
        PlayerPickupXpEventHandler playerPickupXpEventHandler = new PlayerPickupXpEventHandler();
        MinecraftForge.EVENT_BUS.register(playerPickupXpEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(playerPickupXpEventHandler);
        PopulateChunkEventHandler populateChunkEventHandler = new PopulateChunkEventHandler();
        MinecraftForge.EVENT_BUS.register(populateChunkEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(populateChunkEventHandler);
        RainMakerEventHandler rainMakerEventHandler = new RainMakerEventHandler();
        MinecraftForge.EVENT_BUS.register(rainMakerEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(rainMakerEventHandler);
        TextureStitchEventHandler textureStitchEventHandler = new TextureStitchEventHandler();
        MinecraftForge.EVENT_BUS.register(textureStitchEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(textureStitchEventHandler);
        TickPlayerTickEventHandler tickPlayerTickEventHandler = new TickPlayerTickEventHandler();
        MinecraftForge.EVENT_BUS.register(tickPlayerTickEventHandler);
        FMLCommonHandler.instance()
            .bus()
            .register(tickPlayerTickEventHandler);

        NetworkRegistry.INSTANCE.registerGuiHandler(SaltyMod.instance, new GuiHandler());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("SaltyMod");
        network.registerMessage(EvaporatorButtonMessage.Handler.class, EvaporatorButtonMessage.class, 0, Side.SERVER);
        network.registerMessage(SaltwortMessage.Handler.class, SaltwortMessage.class, 1, Side.CLIENT);

        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.potionitem, new DispenserBehaviorPotion());
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.glass_bottle, new DispenserBehaviorBottle());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaker());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.salt_pinch, new DispenserBehaviorSaltPinch());
    }

    public void init(FMLInitializationEvent event) {

        ModAchievementList.init();
        ClientProxy.setBlockRenderers();
        if (event.getSide()
            .isClient()) {
            ClientProxy.setEntityRenderers();
        }

        if(ModConfigurationBlocks.enableEvaporator) {
            GameRegistry.registerTileEntity(TileEntityEvaporator.class, "tileEntityEvaporator");
        }
        if(ModConfigurationBlocks.enableFishFarm) {
            GameRegistry.registerTileEntity(TileEntityFishFarm.class, "tileEntityFishFarm");
        }
        if(ModConfigurationBlocks.enableApiary) {
            GameRegistry.registerTileEntity(TileEntityApiary.class, "tileEntityApiary");
        }
        GameRegistry.registerTileEntity(TileEntityPress.class, "tileEntityPress");
        GameRegistry.registerTileEntity(TileEntityCookingPot.class, "tileEntityCookingPot");
        GameRegistry.registerTileEntity(TileEntityClayOven.class, "tileEntityClayOven");

        EntityRegistry.registerModEntity(EntityRainmaker.class, "rainmaker", 0, SaltyMod.instance, 64, 20, true);
        EntityRegistry
            .registerModEntity(EntityRainmakerDust.class, "rainmaker_dust", 1, SaltyMod.instance, 64, 20, false);
        if (ModConfigurationEntities.enableHornedSheep) {
            EntityRegistry.registerModEntity(EntityHornedSheep.class, "horned_sheep", 2, SaltyMod.instance, 64, 3, true);
            registerEntityEgg(EntityHornedSheep.class, 15198183, 9663326);
        }

        saltOreGenerator = new SaltOreGenerator();
        GameRegistry.registerWorldGenerator(saltOreGenerator, 0);
        if (ModConfigurationBlocks.enableSaltCrystal) {
            saltCrystalGenerator = new SaltCrystalGenerator();
            GameRegistry.registerWorldGenerator(saltCrystalGenerator, 10);
        }
        if (ModConfigurationWorldGeneration.enableSaltLakes) {
            saltLakeGenerator = new SaltLakeGenerator();
            GameRegistry.registerWorldGenerator(saltLakeGenerator, 15);
        }
        if (ModConfigurationBlocks.enableSaltFlowers) {
            saltFlowerGenerator = new SaltFlowerGenerator();
            GameRegistry.registerWorldGenerator(saltFlowerGenerator, 0);
        }

        ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks
            .addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks
            .addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks
            .addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));
        ChestGenHooks
            .addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks
            .addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks
            .addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks
            .addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));

        EvaporateRegistry.instance()
            .addEvaporating(FluidRegistry.WATER, ModItems.salt_pinch, 1000, 0.0F);
    }

    public void postInit(FMLPostInitializationEvent event) {

        if (ModConfigurationBlocks.enableEvaporator) {
            if (FluidRegistry.isFluidRegistered("milk")) {
                Fluid milk = FluidRegistry.getFluid("milk");
                EvaporateRegistry.instance()
                    .addEvaporating(milk, ModItems.powdered_milk, 1000, 0.0F);
            } else {
                CommonProxy.milk = new Fluid("milk");
                FluidRegistry.registerFluid(CommonProxy.milk);
                FluidContainerRegistry.registerFluidContainer(
                    new FluidStack(CommonProxy.milk, 1000),
                    new ItemStack(Items.milk_bucket),
                    FluidContainerRegistry.EMPTY_BUCKET);
                EvaporateRegistry.instance()
                    .addEvaporating(CommonProxy.milk, ModItems.powdered_milk, 1000, 0.0F);
            }
            if (Loader.isModLoaded("BiomesOPlenty") && ModConfigurationModCompatibility.enableBOPFoods) {
                if (FluidRegistry.isFluidRegistered("blood")) {
                    Fluid blood = FluidRegistry.getFluid("blood");
                    GameRegistry.registerItem(ModItems.bop_hemoglobin, "hemoglobin");
                    EvaporateRegistry.instance()
                        .addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
                }
                if (FluidRegistry.isFluidRegistered("hell_blood")) {
                    Fluid blood = FluidRegistry.getFluid("hell_blood");
                    GameRegistry.registerItem(ModItems.bop_hemoglobin, "hemoglobin");
                    EvaporateRegistry.instance()
                        .addEvaporating(blood, ModItems.bop_hemoglobin, 1000, 1.0F);
                }
                Item bop_dart = GameRegistry.findItem("BiomesOPlenty", "dart");
                ItemStack bop_poisondart = new ItemStack(bop_dart, 1, 1);
                if (bop_dart != null && FluidRegistry.isFluidRegistered("poison")) {
                    Fluid poisonFl = FluidRegistry.getFluid("poison");
                    GameRegistry.registerItem(ModItems.bop_poison, "bop_poison");
                    EvaporateRegistry.instance()
                        .addEvaporating(poisonFl, ModItems.bop_poison, 1000, 1.0F);
                    GameRegistry.addShapelessRecipe(bop_poisondart, new ItemStack(bop_dart), ModItems.bop_poison);
                }
            }
        }
    }

    public static int getUniqueEntityId() {
        while (true) {
            startEntityId++;
            if (EntityList.getStringFromID(startEntityId) == null) return startEntityId;
        }
    }

    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
        EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
