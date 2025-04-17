package darkbum.saltymod;

import java.io.File;

import net.minecraft.potion.Potion;
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
import darkbum.saltymod.common.*;
import darkbum.saltymod.configuration.ModConfigurationBase;
import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.*;
import darkbum.saltymod.init.recipes.*;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.structure.ChestContent;
import darkbum.saltymod.structure.ChestLootHandler;

@Mod(
    modid = SaltyMod.MODID,
    name = SaltyMod.NAME,
    version = SaltyMod.VERSION,
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = SaltyMod.DEPENDENCIES)
public class SaltyMod {

    public static final String MODID = "saltymod";

    public static final String NAME = "SaltyMod Expanded";

    public static final String VERSION = "GRADLETOKEN_VERSION";

    public static final String DEPENDENCIES = "after:etfuturum";

    public static final Logger logger = LogManager.getLogger(MODID);

    public static ChestContent chestContent;

    public static ModConfigurationBase config;

    @Instance("saltymod")
    public static SaltyMod instance;

    @SidedProxy(clientSide = "darkbum.saltymod.common.ClientProxy", serverSide = "darkbum.saltymod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting SaltyMod Expanded PreInitialization");
        event.getModMetadata().name = EnumChatFormatting.GOLD + SaltyMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW + SaltyMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA
            + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe";
        File configDir = new File(event.getModConfigurationDirectory(), "saltymod");
        config = new ModConfigurationBase(configDir);
        config.preInit();
        ModPotion.init();
        ModBlocks.init();
        ModItems.init();
        ModOreDictionary.init();
        ModBiomes.SaltyMod();
        ModFishRegistry.registerItems();
        GameRegistry.registerFuelHandler(new ModFuelHandler());
        if (ModConfigurationWorldGeneration.enableBrickmakerCamp) {
            ChestLootHandler.campChest();
        }
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.init();
        proxy.init(event);
        if (ModConfigurationWorldGeneration.enableBrickmakerCamp) {
            ChestContent.addDungeonLoot();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        config.postInit();
        proxy.postInit(event);
        ModRemovedRecipes.init();
        ModShapedRecipes.init();
        ModShapelessRecipes.init();
        ModSmeltingRecipes.init();
        ModPressRecipes.init();
        ModCookingPotRecipes.init();
        ModClayOvenRecipes.init();
        ModExternalRecipes.init();
        ModExternalValueRegistry.init();
        if (Loader.isModLoaded(
            "etfuturum")/*
                         * && new ComparableVersion(Loader.instance().getIndexedModList().get("etfuturum").
                         * getProcessedVersion().getVersionString()).compareTo(new ComparableVersion("2.4.5")) <= 0
                         */) {
            System.out.println("deepslate ore registered");
            ganymedes01.etfuturum.api.DeepslateOreRegistry.addOre(ModBlocks.salt_ore, ModBlocks.deepslate_salt_ore);
        }
        if (Loader.isModLoaded("NotEnoughItems")) {
            new NEIConfig().loadConfig();
        }
    }
}


/*
 * //TO-DO-LIST//
 * Things I (might) need help with:
 * - Tackle Powdered Milk Recipe [Duplicating Bucket]
 * - Change particles of the Swarmed effect
 * - Change Heart texture of the Swarmed effect
 * - Fix Fish Hunger Values [Probably set up Mixins in general?]
 * - Create/Finish Brickmaker Camps [Schematica?]
 * - Underground Salt Lakes? [MAYBE]
 * - Underground Salt Caves/Tunnels/Mines? [MAYBE]
 * - Recipe Book [LATER, ALSO MAYBE]
 * - Fix up the latest Config changes
 *
 * NEW:
 *
 * - Try to set up Marsh Reeds as a two-tall plant?
 * - Clay Brick Furnace
 * - Apiary + Fish Farm Hopper interaction
 * - Add Press/Cooking Pot to NEI
 * - Sounds to Mill
 * - Slimes! [LATER]
 * - Apiary + Fish Farm time-based rather than set time.
 * - Refactoring Salt Food
 * - Inspired effect
 * - Item/Block tab
 * - Farmer's Delight foods?
 * - Clay Oven Stack block indictor
 */
