package ru.liahim.saltmod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import ru.liahim.saltmod.SaltMod;
import ru.liahim.saltmod.block.*;
//import ru.liahim.saltmod.block.MudBrickDrySlab;
//import ru.liahim.saltmod.block.MudBrickDryStairs;
//import ru.liahim.saltmod.block.MudBrickDryWall;
import ru.liahim.saltmod.common.CommonProxy;
//import ru.liahim.saltmod.item.ItemMudBrickDrySlab;
import ru.liahim.saltmod.item.ItemSaltBlock;
import ru.liahim.saltmod.item.ItemSaltDirt;
import ru.liahim.saltmod.item.ItemSaltSlab;

public class ModBlocks {
  static CreativeTabs tab = CommonProxy.saltTab;

  public static Block saltOre = new SaltOre("saltOre", tab);

  public static Block saltDeepslateOre = new SaltDeepslateOre("saltDeepslateOre", tab);

  public static Block saltLake = new SaltLake("saltLake", tab);

  public static Block saltBlock = new SaltBlock(tab);

  public static BlockStairs saltBrickStair = (BlockStairs)new SaltBrickStair("saltBrickStair", tab);

  public static BlockSlab saltSlab = (BlockSlab)new SaltSlab(false, "saltSlab", tab);

  public static BlockSlab saltSlabDouble = (BlockSlab)new SaltSlab(true, "saltSlabDouble", null);

  public static Block saltLamp = new SaltLamp("saltLamp", tab);

  public static Block saltDirt = new SaltDirt(tab);

  public static Block saltDirtLite = new SaltDirtLite("saltDirtLite", tab);

  public static Block saltGrass = new SaltGrass("saltGrass", tab);

  public static Block grassTop = new GrassTop("grassTop", null);

  public static Block mudBlock = new MudBlock("mudBlock", tab);

  public static Block mudBrickWet = new MudBrickWet("mudBrickWet", tab);

  public static Block mudBrickDry = new MudBrickDry("mudBrickDry", tab);

//  public static Block mudBrickDrySlab = (BlockSlab)new MudBrickDrySlab(false, "mudBrickDrySlab", tab);

//  public static Block mudBrickDrySlabDouble = (BlockSlab)new MudBrickDrySlab(true, "mudBrickDrySlabDouble", null);

//  public static Block mudBrickDryStairs = (Block)new MudBrickDryStairs("mudBrickDryStairs", tab);

//  public static Block mudBrickDryWall = (Block)new MudBrickDryWall(ModBlocks.mudBrickDry, tab);

  public static Block oakLogSaltCrusted = new OakLogSaltCrusted("oakLogSaltCrusted", tab);

  public static Block blossomLog = new BlossomLog("blossomLog", tab);

  public static Block blossomBurrow = new BlossomBurrow("blossomBurrow", tab);

  public static Block blossomLeaves = new BlossomLeaves("blossomLeaves", tab);

  public static Block blossomPlanks = new BlossomPlanks("blossomPlanks", tab);

  public static Block blossomDoor = new BlossomDoor("blossomDoor", tab);

  public static Block blossomTrapdoor = new BlossomTrapdoor("blossomTrapdoor", tab);

  public static Block apiary = new Apiary("apiary", tab);

  public static Block extractor = (Block)new Extractor(false, false, "extractor", tab);

  public static Block extractorLit = (Block)new Extractor(true, false, "extractor", null);

  public static Block extractorSteam = (Block)new Extractor(true, true, "extractor", null);

  public static Block storageBlock = new StorageBlock("storageBlock", tab);

  public static Block saltCrystal = (Block)new SaltCrystal("saltCrystal", tab);

  public static Block saltWort = (Block)new SaltWort("saltWort", null);

  public static void init() {
    SaltMod.logger.info("Start to initialize Blocks");
    GameRegistry.registerBlock(saltOre, "saltOre");
    if(Loader.isModLoaded("etfuturum")) {
    GameRegistry.registerBlock(saltDeepslateOre, "saltDeepslateOre");
    }
    GameRegistry.registerBlock(saltLake, "saltLake");
    GameRegistry.registerBlock(saltBlock, ItemSaltBlock.class, "saltBlock");
    GameRegistry.registerBlock((Block)saltBrickStair, "saltBrickStair");
    GameRegistry.registerBlock((Block)saltSlab, ItemSaltSlab.class, "saltSlab");
    GameRegistry.registerBlock((Block)saltSlabDouble, ItemSaltSlab.class, "saltSlabDouble");
    GameRegistry.registerBlock(saltLamp, "saltLamp");
    GameRegistry.registerBlock(saltDirt, ItemSaltDirt.class, "saltDirt");
    GameRegistry.registerBlock(saltDirtLite, "saltDirtLite");
    GameRegistry.registerBlock(saltGrass, "saltGrass");
    GameRegistry.registerBlock(grassTop, "grassTop");
    GameRegistry.registerBlock(mudBlock, "mudBlock");
    GameRegistry.registerBlock(mudBrickWet, "mudBrickWet");
    GameRegistry.registerBlock(mudBrickDry, "mudBrickDry");
//    GameRegistry.registerBlock((Block)mudBrickDrySlab, ItemMudBrickDrySlab.class, "mudBrickDrySlab");
//    GameRegistry.registerBlock((Block)mudBrickDrySlabDouble, ItemMudBrickDrySlab.class, "mudBrickDrySlabDouble");
//    GameRegistry.registerBlock(mudBrickDryStairs, "mudBrickDryStairs");
//    GameRegistry.registerBlock(mudBrickDryWall, "mudBrickDryWall");
    GameRegistry.registerBlock(oakLogSaltCrusted, "oakLogSaltCrusted");
    GameRegistry.registerBlock(blossomLog, "blossomLog");
    GameRegistry.registerBlock(blossomBurrow, "blossomBurrow");
    GameRegistry.registerBlock(blossomLeaves, "blossomLeaves");
    GameRegistry.registerBlock(blossomPlanks, "blossomPlanks");
    GameRegistry.registerBlock(blossomDoor, "blossomDoor");
    GameRegistry.registerBlock(blossomTrapdoor, "blossomTrapdoor");
    GameRegistry.registerBlock(apiary, "apiary");
    GameRegistry.registerBlock(extractor, "extractor");
    GameRegistry.registerBlock(extractorLit, "extractorLit").setLightLevel(0.9F);
    GameRegistry.registerBlock(extractorSteam, "extractorSteam").setLightLevel(0.9F);
    GameRegistry.registerBlock(storageBlock, "storageBlock");
    GameRegistry.registerBlock(saltCrystal, "saltCrystal");
    GameRegistry.registerBlock(saltWort, "saltWort");
    SaltMod.logger.info("Finished initializing Blocks");
  }
}
