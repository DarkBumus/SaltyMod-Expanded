package darkbum.saltymod.common.proxy;

import darkbum.saltymod.creativetab.TabSaltBlocks;
import darkbum.saltymod.creativetab.TabSaltItems;
import darkbum.saltymod.event.*;
import darkbum.saltymod.network.SaltFlowerDirtMessage;
import darkbum.saltymod.network.SaltFlowerSandMessage;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.util.GuiHandler;
import darkbum.saltymod.network.EvaporatorButtonMessage;
import darkbum.saltymod.network.SaltwortMessage;
import darkbum.saltymod.world.generator.*;

/**
 * Server-side proxy class responsible for server-side initializations like world generation.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class CommonProxy {

    /** Creative tabs for items and blocks. */
    public static CreativeTabs tabSaltItems = new TabSaltItems("salt_items");
    public static CreativeTabs tabSaltBlocks = new TabSaltBlocks("salt_blocks");

    /** World generators for worldgen features that generate everywhere. */
    public static SaltOreGenerator saltOreGenerator;
    public static SaltCrystalGenerator saltCrystalGenerator;
    public static SaltLakeGenerator saltLakeGenerator;
    public static SaltFlowerGenerator saltFlowerGenerator;

    /** Armor material definition for Mud Armor. */
    public static ItemArmor.ArmorMaterial mudMaterial = EnumHelper.addArmorMaterial("mudMaterial", 5, new int[] { 1, 3, 2, 1 }, 15);

    /** Variables for the milk fluid and the network channel. */
    public static SimpleNetworkWrapper network;

    /**
     * Called during Forge Mod Loader Pre-Initialization phase.
     * <p>
     * Handles event handler registering, network registry, GUI handler and dispenser behavior.
     */
    @SuppressWarnings("unused")
    public void preInit(FMLPreInitializationEvent event) {
        // Register event handlers
        registerEventHandlers();

        // Register network
        NetworkRegistry.INSTANCE.registerGuiHandler(SaltyMod.instance, new GuiHandler());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("SaltyMod");
        network.registerMessage(EvaporatorButtonMessage.Handler.class, EvaporatorButtonMessage.class, 0, Side.SERVER);
        network.registerMessage(SaltwortMessage.Handler.class, SaltwortMessage.class, 1, Side.CLIENT);
        network.registerMessage(SaltFlowerDirtMessage.Handler.class, SaltFlowerDirtMessage.class, 2, Side.CLIENT);
        network.registerMessage(SaltFlowerSandMessage.Handler.class, SaltFlowerSandMessage.class, 3, Side.CLIENT);
    }

    /**
     * Called during Forge Mod Loader Initialization phase.
     * <p>
     * Handles world generators and chest gen hooks.
     */
    @SuppressWarnings("unused")
    public void init(FMLInitializationEvent event) {
        // Register world generators
        registerWorldGenerators();

        // Register chest gen hooks
        registerChestGenHooks();
    }

    /**
     * Called during Forge Mod Loader Post-Initialization phase.
     */
    @SuppressWarnings("unused")
    public void postInit(FMLPostInitializationEvent event) {
    }

    /**
     * Registers the event handlers for pre-initialization.
     */
    private void registerEventHandlers() {
        register(new AchievementEventHandler());
        register(new BlockHarvestDropsEventHandler());
        register(new DecorateBiomeEventHandler());
        register(new EntityItemPickupEventHandler());
        register(new EntityJoinWorldEventHandler());
        register(new LivingDropsEventHandler());
        register(new LivingUpdateEventHandler());
        register(new PlayerItemCraftedEventHandler());
        register(new PlayerPickupXpEventHandler());
        register(new PlayerUseItemEventHandler());
        register(new PopulateChunkEventHandler());
        register(new RainMakerEventHandler());
        register(new TextureStitchEventHandler());
        register(new TickEventHandler());
    }

    /**
     * Helper method for quick-registering event handlers.
     */
    private void register(Object handler) {
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }

    /**
     * Registers the world generators for initialization.
     */
    private void registerWorldGenerators() {
        if (ModConfigurationBlocks.enableSaltOre) {
            saltOreGenerator = new SaltOreGenerator();
            GameRegistry.registerWorldGenerator(saltOreGenerator, 0);
        }
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
    }

    /**
     * Registers the chest gen hooks for initialization.
     */
    private void registerChestGenHooks() {
        ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 5));
        ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));
        ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.salt), 2, 5, 10));
        ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 3, 3));
        ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.saltwort), 2, 5, 5));
    }

    /**
     * Placeholder method for client-side renderer registration.
     * Overriden in {@link ClientProxy}.
     */
    public void setRenderers() {
    }
}
