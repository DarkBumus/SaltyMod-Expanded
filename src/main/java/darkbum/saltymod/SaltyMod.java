package darkbum.saltymod;

import java.io.File;

import cpw.mods.fml.common.versioning.ComparableVersion;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.init.ModExternalItemLoader;
import darkbum.saltymod.zzzdeprecated.DeprecatedRecipes;
import net.minecraft.util.EnumChatFormatting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.api.nei.NEIConfig;
import darkbum.saltymod.common.config.ModConfigurationBase;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.*;
import darkbum.saltymod.init.recipes.*;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.world.structure.ChestContent;

/**
 * Main mod class for SaltyMod Expanded.
 *
 * Handles the Forge Mod Loader events and sets up initialization, configuration and registration of all subclasses,
 * aswell as compatibility with other mods and NEI integration.
 *
 * @author DarkBum
 * @since 1.9.f
 */
@Mod(
    modid = SaltyMod.MODID,
    name = SaltyMod.NAME,
    version = SaltyMod.VERSION,
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = SaltyMod.DEPENDENCIES)
public class SaltyMod {

    /** Internal mod ID used for registration and logging. */
    public static final String MODID = "saltymod";

    /** Name of the mod. */
    public static final String NAME = "SaltyMod Expanded";

    /** Version string, replaced automatically during build. */
    public static final String VERSION = "GRADLETOKEN_VERSION";

    /** Dependency declaration. Requires to load after Et Futurum Requiem. */
    public static final String DEPENDENCIES = "after:etfuturum";

    /** Logger instance for rebug and runtime messages. **/
    public static final Logger logger = LogManager.getLogger(MODID);

    /** Root configuration object for mod configs. */
    public static ModConfigurationBase config;

    /** Singleton instance of the mod, used internally by Forge Mod Loader. */
    @Instance("saltymod")
    public static SaltyMod instance;

    /** Proxy for client/server-specific operations (GUI, Rendering, different registries, etc. */
    @SidedProxy(clientSide = "darkbum.saltymod.common.proxy.ClientProxy", serverSide = "darkbum.saltymod.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    /**
     * Called during the Forge Mod Loader Pre-Initialization phase.
     *
     * Handles initial setup, config loading, initialization for blocks, items, potions and biomes.
     * Handles proxy pre-init methods.
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Started SaltyMod Expanded PreInitialization");

        // Set custom mod metadata for display in the mod list.
        event.getModMetadata().name = EnumChatFormatting.GOLD + SaltyMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW + SaltyMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA
            + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe, Jack";

        // Load and initialize configuration files
        File configDir = new File(event.getModConfigurationDirectory(), "saltymod");
        config = new ModConfigurationBase(configDir);
        config.preInit();

        // Register core systems (potions, blocks, items, tile entities, entities and biomes)
        ModPotion.init();
        ModBlocks.init();
        ModItems.init();
        ModTileEntities.init();
        ModEntities.init();
        ModBiomes.SaltyMod();

        // Register miscellaneous registries and handlers
        ModFishRegistry.registerItems();
        GameRegistry.registerFuelHandler(new ModFuelHandler());
        ModFlammabilityHandler.init();
        ModDispenserBehaviorRegistry.init();

        proxy.preInit(event);

        logger.info("Finished SaltyMod Expanded PreInitialization");
    }

    /**
     * Called during the Forge Mod Loader Initialization phase.
     *
     * Handles runtime systems.
     * Handles proxy init methods.
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Started SaltyMod Expanded Initialization");

        config.init();

        // Initialize Achievements
        ModAchievementList.init();

        // Register chest loot for Brickmaker Camps
        if (ModConfigurationWorldGeneration.enableBrickmakerCamp) {
            ChestContent.addDungeonLoot();
        }

        proxy.init(event);
        proxy.setRenderers();

        logger.info("Finished SaltyMod Expanded Initialization");
    }

    /**
     * Called during Forge Mod Loader Post-Initialization phase.
     *
     * Handles compatibility-sensitive systems, recipe loading, ore dictionary, NEI integration and deprecated features.
     * Handles proxy post-init methods.
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("Started SaltyMod Expanded PostInitialization");

        config.postInit();

        // Load mod items, external value changes and OreDictionary
        ModExternalItemLoader.loadAll();
        ModExternalValueRegistry.init();
        ModOreDictionary.init();

        // Load internal recipes
        ModRemovedRecipes.init();
        ModShapedRecipes.init();
        ModShapelessRecipes.init();
        ModSmeltingRecipes.init();
        ModEvaporatorRecipes.init();
        if (ModConfigurationBlocks.enableMachines) {
            ModPressRecipes.init();
            ModCookingPotRecipes.init();
            ModClayOvenRecipes.init();
        }

        // Register custom ore for Et Futurum Requiem's deepslate compatibility
        if (ModConfigurationBlocks.enableSaltOre && Loader.isModLoaded("etfuturum")) {
            ganymedes01.etfuturum.api.DeepslateOreRegistry.addOre(ModBlocks.salt_ore, ModBlocks.deepslate_salt_ore);
            logger.info("Deepslate Ore registered");
        }

        // Register NEI recipes if NEI is loaded
        if (Loader.isModLoaded("NotEnoughItems")) {
            new NEIConfig().loadConfig();
            logger.info("NEI Config loaded");
        }

        // Load deprecated (legacy) recipes
        DeprecatedRecipes.init();

        proxy.postInit(event);

        logger.info("Finished SaltyMod Expanded PostInitialization");
    }
}

/*
 * //TO-DO-LIST//
 * Things I (might) need help with:
 * - Tackle Powdered Milk Recipe [Duplicating Bucket] | Impossible?
 * - Change particles of the Swarmed effect
 * - Change Heart texture of the Swarmed effect
 * - Underground Salt Lakes? [MAYBE]
 * - Underground Salt Caves/Tunnels/Mines? [MAYBE]
 * - Recipe Book [LATER, ALSO MAYBE]
 * - Fix up the latest Config changes
 * - Add Press/Cooking Pot/Clay Oven to NEI
 * - Slimes! [LATER]
 * - Rice, Tea, Brewing [LATER]
 * - Cooking Pot / Clay Oven Particles
 * - Salt Flowers Potting [LATER] [WTF]
 * - Achievements/Configs
 */
