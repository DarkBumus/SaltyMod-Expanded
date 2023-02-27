package darkbum.saltmod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.block.*;
import darkbum.saltmod.item.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;
import darkbum.saltmod.SaltMod;
import darkbum.saltmod.block.*;
//import darkbum.saltmod.block.MudBrickDryWall;
import darkbum.saltmod.common.CommonProxy;
import darkbum.saltmod.item.*;

public class ModBlocks {
    static CreativeTabs tab = CommonProxy.saltTab;

    public static Block saltOre = new SaltOre("saltOre", tab);

    public static Block saltDeepslateOre = new SaltDeepslateOre("saltDeepslateOre", tab);

    public static Block saltLake = new SaltLake("saltLake", tab);

    public static Block saltBlock = new SaltBlock(tab);

    public static BlockStairs saltBrickStair = new SaltBrickStair("saltBrickStair", tab);

    public static BlockSlab saltSlab = new SaltSlab(false, "saltSlab", tab);

    public static BlockSlab saltSlabDouble = new SaltSlab(true, "saltSlabDouble", null);

    public static Block saltLamp = new SaltLamp("saltLamp", tab);

    public static Block saltDirt = new SaltDirt(tab);

    public static Block saltDirtLite = new SaltDirtLite("saltDirtLite", tab);

    public static Block saltGrass = new SaltGrass("saltGrass", tab);

    public static Block grassTop = new GrassTop("grassTop", null);

    public static Block mudBlock = new MudBlock("mudBlock", tab);

    public static Block mudBrickWet = new MudBrickWet("mudBrickWet", tab);

    public static Block mudBrickDry = new MudBrickDry("mudBrickDry", tab);

    public static Block mudBrickDryStairs = new MudBrickDryStairs("mudBrickDryStairs", tab);

    public static BlockSlab mudBrickDrySlab = new MudBrickDrySlab(false, "mudBrickDrySlab", tab);

    public static BlockSlab mudBrickDrySlabDouble = new MudBrickDrySlab(true, "mudBrickDrySlabDouble", null);

//    public static BlockWall mudBrickDryWall = new MudBrickDryWall(ModBlocks.mudBrickDry, tab);

    public static Block oakLogSaltCrusted = new OakLogSaltCrusted("oakLogSaltCrusted", tab);

//    public static Block blossomSapling = new BlossomSapling("blossomSapling", tab);

    public static Block blossomLog = new BlossomLog("blossomLog", tab);

    public static Block blossomBark = new BlossomBark("blossomBark", tab);

    public static Block blossomStrippedLog = new BlossomStrippedLog("blossomStrippedLog", tab);

    public static Block blossomStrippedBark = new BlossomStrippedBark("blossomStrippedBark", tab);

    public static Block blossomBurrow = new BlossomBurrow("blossomBurrow", tab);

    public static Block blossomLeaves = new BlossomLeaves("blossomLeaves", tab, BlossomLeaves.LeafCategory.CAT1);

    public static Block blossomPlanks = new BlossomPlanks("blossomPlanks", tab);

    public static Block blossomStairs = new BlossomStairs("blossomStairs", tab);

    public static BlockSlab blossomSlab = new BlossomSlab(false, "blossomSlab", tab);

    public static BlockSlab blossomSlabDouble = new BlossomSlab(true, "saltSlabDouble", null);

//    public static BlockFence blossomFence

//    public static BlockFenceGate blossomFenceGate

//    public static Block blossomDoor = new BlossomDoor("blossomDoor", tab);

//    public static Block blossomTrapdoor = new BlossomTrapdoor("blossomTrapdoor", tab);

    public static Block apiary = new Apiary("apiary", tab);

    public static Block extractor = new Extractor(false, false, "extractor", tab);

    public static Block extractorLit = new Extractor(true, false, "extractor", null);

    public static Block extractorSteam = new Extractor(true, true, "extractor", null);

    public static Block storageCrate = new StorageCrate("storageCrate", tab);

    public static Block storageBarrel = new StorageBarrel("storageBarrel", tab);

    public static Block storageSack = new StorageSack("storageSack", tab);

    public static Block saltCrystal = new SaltCrystal("saltCrystal", tab);

    public static Block saltWort = new SaltWort("saltWort", null);

    public static void init() {
        SaltMod.logger.info("Start to initialize Blocks");
        GameRegistry.registerBlock(saltOre, "saltOre");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerBlock(saltDeepslateOre, "saltDeepslateOre");
        }
        GameRegistry.registerBlock(saltLake, "saltLake");
        GameRegistry.registerBlock(saltBlock, ItemSaltBlock.class, "saltBlock");
        GameRegistry.registerBlock(saltBrickStair, "saltBrickStair");
        GameRegistry.registerBlock(saltSlab, ItemSaltSlab.class, "saltSlab");
        GameRegistry.registerBlock(saltSlabDouble, ItemSaltSlab.class, "saltSlabDouble");
        GameRegistry.registerBlock(saltLamp, "saltLamp");
        GameRegistry.registerBlock(saltDirt, ItemSaltDirt.class, "saltDirt");
        GameRegistry.registerBlock(saltDirtLite, "saltDirtLite");
        GameRegistry.registerBlock(saltGrass, "saltGrass");
        GameRegistry.registerBlock(grassTop, "grassTop");
        GameRegistry.registerBlock(mudBlock, "mudBlock");
        GameRegistry.registerBlock(mudBrickWet, "mudBrickWet");
        GameRegistry.registerBlock(mudBrickDry, "mudBrickDry");
        GameRegistry.registerBlock(mudBrickDryStairs, "mudBrickDryStairs");
        GameRegistry.registerBlock(mudBrickDrySlab, ItemMudBrickDrySlab.class, "mudBrickDrySlab");
        GameRegistry.registerBlock(mudBrickDrySlabDouble, ItemMudBrickDrySlab.class, "mudBrickDrySlabDouble");
//        GameRegistry.registerBlock(mudBrickDryWall, "mudBrickDryWall");
        GameRegistry.registerBlock(oakLogSaltCrusted, "oakLogSaltCrusted");
//        GameRegistry.registerBlock(blossomSapling, "blossomSapling");
        GameRegistry.registerBlock(blossomLog, "blossomLog");
        GameRegistry.registerBlock(blossomBark, "blossomBark");
        GameRegistry.registerBlock(blossomStrippedLog, "blossomStrippedLog");
        GameRegistry.registerBlock(blossomStrippedBark, "blossomStrippedBark");
        GameRegistry.registerBlock(blossomBurrow, "blossomBurrow");
        GameRegistry.registerBlock(blossomLeaves, "blossomLeaves");
        GameRegistry.registerBlock(blossomPlanks, "blossomPlanks");
        GameRegistry.registerBlock(blossomStairs, "blossomStairs");
        GameRegistry.registerBlock(blossomSlab, ItemBlossomSlab.class,"blossomSlab");
        GameRegistry.registerBlock(blossomSlabDouble, ItemBlossomSlab.class,"blossomSlabDouble");
//        GameRegistry.registerBlock(blossomFence, "blossomFence");
//        GameRegistry.registerBlock(blossomFenceGate, "blossomFenceGate");
//        GameRegistry.registerBlock(blossomDoor, "blossomDoor");
//        GameRegistry.registerBlock(blossomTrapdoor, "blossomTrapdoor");
        GameRegistry.registerBlock(apiary, "apiary");
        GameRegistry.registerBlock(extractor, "extractor");
        GameRegistry.registerBlock(extractorLit, "extractorLit").setLightLevel(0.9F);
        GameRegistry.registerBlock(extractorSteam, "extractorSteam").setLightLevel(0.9F);
        GameRegistry.registerBlock(storageCrate, ItemStorageCrate.class, "storageCrate");
        GameRegistry.registerBlock(storageBarrel, ItemStorageBarrel.class, "storageBarrel");
        GameRegistry.registerBlock(storageSack, ItemStorageSack.class, "storageSack");
        GameRegistry.registerBlock(saltCrystal, "saltCrystal");
        GameRegistry.registerBlock(saltWort, "saltWort");
        SaltMod.logger.info("Finished initializing Blocks");
    }
}
