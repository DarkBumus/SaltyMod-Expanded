package ru.liahim.saltmod;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.structure.MapGenStructureIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.liahim.saltmod.common.CommonProxy;
import ru.liahim.saltmod.common.RecipeRemover;
import ru.liahim.saltmod.init.ModBiomes;
import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.ModItems;
import ru.liahim.saltmod.init.ModSounds;
import ru.liahim.saltmod.init.SaltConfig;
/*import ru.liahim.saltmod.structure.BrickmakerCampGen;
import ru.liahim.saltmod.structure.ChestContent;
import ru.liahim.saltmod.structure.BrickmakerCampGenerator;
import ru.liahim.saltmod.structure.ChestLootHandler;
import ru.liahim.saltmod.structure.ComponentCampPieces;
import ru.liahim.saltmod.structure.MapGenCamp;
import ru.liahim.saltmod.structure.SurfaceFinder;*/

@Mod(modid = "SaltMod", name = "Salty Mod Expanded", version = "2.0.0")
public class SaltMod {
  public static final String MODID = "SaltMod";
  
  public static final String NAME = "Salty Mod Expanded";
  
  public static final String VERSION = "2.0.0";
  
  public static final Logger logger = LogManager.getLogger("Salty Mod Expanded");
  
/*  public static SurfaceFinder surfaceFinder = new SurfaceFinder();
  
  public static BrickmakerCampGen brickermakerCampGen = new BrickmakerCampGen();
  
  public static ChestContent chestConent;*/
  
  public static SaltConfig config;
  
  @Instance("SaltMod")
  public static SaltMod instance;
  
  @SidedProxy(clientSide = "ru.liahim.saltmod.common.ClientProxy", serverSide = "ru.liahim.saltmod.common.CommonProxy")
  public static CommonProxy proxy;
  
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger.info("Starting SaltMod PreInitialization");
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