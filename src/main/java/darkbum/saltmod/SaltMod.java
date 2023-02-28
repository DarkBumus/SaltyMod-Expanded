package darkbum.saltmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.common.RecipeRemover;
import darkbum.saltmod.init.ModBiomes;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import darkbum.saltmod.init.SaltConfig;
/*import ru.liahim.saltmod.structure.BrickmakerCampGen;
import ru.liahim.saltmod.structure.ChestContent;
import ru.liahim.saltmod.structure.BrickmakerCampGenerator;
import ru.liahim.saltmod.structure.ChestLootHandler;
import ru.liahim.saltmod.structure.ComponentCampPieces;
import ru.liahim.saltmod.structure.MapGenCamp;
import ru.liahim.saltmod.structure.SurfaceFinder;*/

@Mod(modid = SaltMod.MODID, name = SaltMod.NAME, version = SaltMod.VERSION)
public class SaltMod {
    public static final String MODID = "SaltMod";

    public static final String NAME = "Salty Mod Expanded";

    public static final String VERSION = "GRADLETOKEN_VERSION";

    public static final Logger logger = LogManager.getLogger("Salty Mod Expanded");

/*  public static SurfaceFinder surfaceFinder = new SurfaceFinder();

  public static BrickmakerCampGen brickermakerCampGen = new BrickmakerCampGen();

  public static ChestContent chestConent;*/

    public static SaltConfig config;

    @Instance("SaltMod")
    public static SaltMod instance;

    @SidedProxy(clientSide = "darkbum.saltmod.common.ClientProxy", serverSide = "darkbum.saltmod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Starting SaltMod PreInitialization");
        event.getModMetadata().name = EnumChatFormatting.GOLD+SaltMod.NAME;
        event.getModMetadata().version = EnumChatFormatting.YELLOW+SaltMod.VERSION;
        event.getModMetadata().credits = EnumChatFormatting.AQUA + "Thanks to original author Liahim85 and contributors jss2a98aj, Roadhog360, DelirusCrux, AstroTibs, Just Moe";
        config = new SaltConfig(event.getSuggestedConfigurationFile());
        config.preInit();
        RecipeRemover.init();
        ModItems.init();
        ModBlocks.init();
        ModBiomes.SaltMod();
/*    if(SaltConfig.enableBrickmakerCamp) {
    	GameRegistry.registerWorldGenerator((IWorldGenerator)new BrickmakerCampGenerator(), 0);
    	MapGenStructureIO.registerStructure(MapGenCamp.Start.class, "BrickmakerCamp");
    	ComponentCampPieces.registerScatteredFeaturePieces();
    	ChestLootHandler.campChest();
    }*/
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.init();
        proxy.init(event);
/*    if(SaltConfig.enableBrickmakerCamp) {
    	GameRegistry.registerWorldGenerator((IWorldGenerator)SaltMod.surfaceFinder, 0);
    	ChestContent.addDungeonLoot();
    }*/
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        config.postInit();
        proxy.postInit(event);
    }
}