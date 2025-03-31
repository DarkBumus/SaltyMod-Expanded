package darkbum.saltymod;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.versioning.ComparableVersion;
import cpw.mods.fml.common.registry.GameRegistry;

import darkbum.saltymod.common.*;
import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.init.*;
import darkbum.saltymod.init.recipes.*;
import darkbum.saltymod.potion.ModPotion;
import darkbum.saltymod.structure.ChestLootHandler;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import darkbum.saltymod.structure.ChestContent;

@Mod(modid = SaltyMod.MODID, name = SaltyMod.NAME, version = SaltyMod.VERSION, acceptedMinecraftVersions = "[1.7.10]", dependencies = SaltyMod.DEPENDENCIES)
public class SaltyMod {
    public static final String MODID = "saltymod";

    public static final String NAME = "SaltyMod Expanded";

    public static final String VERSION = "GRADLETOKEN_VERSION";

    public static final String DEPENDENCIES = "after:etfuturum";

    public static final Logger logger = LogManager.getLogger(MODID);

    public static ChestContent chestContent;

    public static ModConfiguration config;

    @Instance("saltymod")
    public static SaltyMod instance;

    @SidedProxy(clientSide = "darkbum.saltymod.common.ClientProxy", serverSide = "darkbum.saltymod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting SaltyMod Expanded PreInitialization");
        event.getModMetadata().name = EnumChatFormatting.GOLD + SaltyMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW + SaltyMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe";
        config = new ModConfiguration(event.getSuggestedConfigurationFile());
        config.preInit();
        ModPotion.init();
        ModItems.init();
        ModBlocks.init();
        ModBiomes.SaltyMod();
        ModFishRegistry.registerItems();
        GameRegistry.registerFuelHandler(new ModFuelHandler());
        if (ModConfiguration.enableBrickmakerCamp) {
            ChestLootHandler.campChest();
        }
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.init();
        proxy.init(event);
        ModOreDictionary.init();
        ModRecipeRemover.init();
        ModShapedRecipes.init();
        ModShapelessRecipes.init();
        ModSmeltingRecipes.init();
        if (ModConfiguration.enableBrickmakerCamp) {
            ChestContent.addDungeonLoot();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        config.postInit();
        proxy.postInit(event);
        ModExternalRecipes.init();
        ModExternalFoodValueRegistry.init();
        if(Loader.isModLoaded("etfuturum")/* && new ComparableVersion(Loader.instance().getIndexedModList().get("etfuturum").getProcessedVersion().getVersionString()).compareTo(new ComparableVersion("2.4.5")) <= 0*/) {
            System.out.println("deepslate ore registered");
            ganymedes01.etfuturum.api.DeepslateOreRegistry.addOre(ModBlocks.salt_ore, ModBlocks.deepslate_salt_ore);
        }
    }
}

/*        //TO-DO-LIST//
            Things I can do on my own (probably):
            - Restructure/Merge Items?
            - At least think of a way to automate fishing


            Things I (might) need help with:
            - PROPERLY SET REFERENCES WITHOUT HARD DEPENDENCY
            - Rainmaker behavior!!!
            - Create/Finish Blossom Sign [Later Boat&Chest Boat&Hanging Sign]
            - Tackle Powdered Milk Recipe [Duplicating Bucket]
            - Change particles of the Swarmed effect
            - Change Heart texture of the Swarmed effect
            - Mix Salt Flower Patches
            - Fix Fish Hunger Values [Probably set up Mixins in general?]
            - Fix up Evaporator behavior
            - Create/Finish Brickmaker Camps [Schematica?]
            - Underground Salt Lakes? [MAYBE]
            - Underground Salt Caves/Tunnels/Mines? [MAYBE]
            - Make the "automate fishing" idea work, lol
            - Recipe Book [LATER, ALSO MAYBE]
            - Change EFR's suspicious stew from giving Saturation to giving Well Fed
            - Fix up the latest Config changes
                - Specify singular blocks from Array Lists (Preventing Onion Alliums crashing the AlliumPatch.java when Salt Flowers are deactivated)
                - Same as above, singleing out Onion Crates to deactivate without removing all storage blocks)


            Things I probably have to outsource (sorted by order of importance): ##################### HI JONATHAN :) ###########################
            - Finish Blossom Burrow/Tree (!!)
                - Just add the Burrow to the tree (just under the leaves, still visible, and only when naturally generating) and have it choose a random Meta value out of 0, 1, 2, 3.
            - Finish Salt Marsh (!)
                - Flatter (at most (!) 3 blocks above water level)
                - More water being produced in general
                - Water being completely lined with Mineral Mud Blocks (Without them being everywhere under the surface)
                - If you get the better color blending to work, that'd be nice too ¯\_(ツ)_/¯)
                - Lying logs
                    - (If you manage) have the BlockSaltCrustedOakLog be a BlocKRotatedPillar, that, which ever side is set to lie on the ground,
                      will display a salt-crusted effect (Textures are in textures/blocks/oak_log_*)
                    - They should generate alongside the usual Salt Marsh trees (This in combination with a higher water-to-land ratio, should result in a nice blend,
                      especially when we make Brickmaker Camps work)
                - Reeds/Water Grass
                    - Two blocks high
                    - Grow on Mineral Mud Blocks
                    - Grow underwater (one part underwater, one part above the surface, refer to BoP)
                    - [Undecided on Drops still]
            - Fix the "Bee Resistant" functionality in the "Swarmed" effect
            - (Maybe) Fix rendering of Blossom Trapdoor in inventory (low priority)*/
