package darkbum.saltmod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltmod.blockitems.*;
import darkbum.saltmod.blocks.*;
import darkbum.saltmod.blocks.BlockSalt;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;
import darkbum.saltmod.SaltMod;
import darkbum.saltmod.common.CommonProxy;

public class ModBlocks {
    static CreativeTabs tab = CommonProxy.tabSalt;

    public static Block salt_ore = new BlockSaltOre("salt_ore", tab);

    public static Block salt_deepslate_ore;

    public static Block salt_lake = new BlockSaltLake("salt_lake", tab);

    public static Block salt_block = new BlockSalt(tab);

    public static BlockStairs salt_brick_stairs = new BlockSaltBrickStairs("salt_brick_stairs", tab);

    public static BlockSlab salt_slab = new BlockSaltSlab(false, "salt_slab", tab);

    public static BlockSlab double_salt_slab = new BlockSaltSlab(true, "double_salt_slab", null);

    public static Block salt_lamp = new BlockSaltLamp("salt_lamp", tab);

    public static Block salt_dirt = new BlockSaltDirt(tab);

    public static Block lite_salt_dirt = new BlockLiteSaltDirt("lite_salt_dirt", tab);

    public static Block salt_grass = new BlockSaltGrass("salt_grass", tab);

    public static Block grass_top = new BlockGrassTop("grass_top", null);

    public static Block mineral_mud = new BlockMineralMud("mineral_mud", tab);

    public static Block wet_mud_brick = new BlockWetMudBrick("wet_mud_brick", tab);

    public static Block dry_mud_brick = new BlockDryMudBrick("dry_mud_brick", tab);

    public static Block dry_mud_brick_stairs = new BlockDryMudBrickStairs("dry_mud_brick_stairs", tab);

    public static BlockSlab dry_mud_brick_slab = new BlockDryMudBrickSlab(false, "dry_mud_brick_slab", tab);

    public static BlockSlab double_dry_mud_brick_slab = new BlockDryMudBrickSlab(true, "double_dry_mud_brick_slab", null);

    public static BlockWall dry_mud_brick_wall = new BlockDryMudBrickWall(ModBlocks.dry_mud_brick, tab);

    public static Block salt_crusted_oak_log = new BlockSaltCrustedOakLog("salt_crusted_oak_log", tab);

    public static Block blossom_planks = new BlockBlossomPlanks("blossom_planks", tab);

    //    public static Block blossomSapling = new BlossomSapling("blossomSapling", tab);

    public static Block blossom_log = new BlockBlossomLog("blossom_log", tab);

    public static Block blossom_burrow = new BlockBlossomBurrow("blossom_burrow", tab);

    public static Block blossom_stripped_log = new BlockBlossomStrippedLog("blossom_stripped_log", tab);

    public static Block blossom_wood = new BlockBlossomWood("blossom_wood", tab);

    public static Block blossom_stripped_wood = new BlockBlossomStrippedWood("blossom_stripped_wood", tab);

    public static Block blossom_leaves = new BlockBlossomLeaves("blossom_leaves", tab);

    public static BlockSlab blossom_slab = new BlockBlossomSlab(false, "blossom_slab", tab);

    public static BlockSlab double_blossom_slab = new BlockBlossomSlab(true, "double_blossom_slab", null);

    //    public static BlockFence blossomFence

    public static Block blossom_stairs = new BlockBlossomStairs("blossom_stairs", tab);

//    public static BlockFenceGate blossomFenceGate

    public static Block blossom_pressure_plate = new BlockBlossomPressurePlate(0, tab);

    public static Block blossom_button = new BlockBlossomButton();

//    public static Block blossomDoor = new BlossomDoor("blossomDoor", tab);

//    public static Block blossomTrapdoor = new BlossomTrapdoor("blossomTrapdoor", tab);

//    public static Block blossomSign = new BlossomSign();


    public static Block apiary = new BlockApiary("apiary", tab);

    public static Block extractor = new BlockExtractor(false, false, "extractor", tab);

    public static Block lit_extractor = new BlockExtractor(true, false, "extractor", null);

    public static Block steam_extractor = new BlockExtractor(true, true, "extractor", null);

    public static Block storage_crate = new BlockStorageCrate("storage_crate", tab);

    public static Block storage_barrel = new BlockStorageBarrel("storage_barrel", tab);

    public static Block storage_sack = new BlockStorageSack("storage_sack", tab);

    public static Block salt_crystal = new BlockSaltCrystal("salt_crystal", tab);

    public static Block saltworts = new BlockSaltwort("saltworts", null);

    public static Block onions = new BlockOnions("onions", null);

    public static Block marsh_reeds = new BlockMarshReeds("marsh_reeds", tab);

    public static void init() {
        SaltMod.logger.info("Start to initialize Blocks");

        GameRegistry.registerBlock(salt_ore, "salt_ore");
        if(Loader.isModLoaded("etfuturum") && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslateOres) {
            salt_deepslate_ore = new BlockSaltDeepslateOre(salt_ore);
            GameRegistry.registerBlock(salt_deepslate_ore, "salt_deepslate_ore");
        }
        GameRegistry.registerBlock(salt_lake, "salt_lake");
        GameRegistry.registerBlock(salt_block, darkbum.saltmod.blockitems.ItemSaltBlock.class, "salt_block");
        GameRegistry.registerBlock(salt_brick_stairs, "salt_brick_stairs");
        GameRegistry.registerBlock(salt_slab, ItemSaltSlab.class, "salt_slab");
        GameRegistry.registerBlock(double_salt_slab, ItemSaltSlab.class, "double_salt_slab");
        GameRegistry.registerBlock(salt_lamp, "salt_lamp");
        GameRegistry.registerBlock(salt_dirt, ItemSaltDirt.class, "salt_dirt");
        GameRegistry.registerBlock(lite_salt_dirt, "lite_salt_dirt");
        GameRegistry.registerBlock(salt_grass, "salt_grass");
        GameRegistry.registerBlock(grass_top, "grass_top");
        GameRegistry.registerBlock(mineral_mud, "mineral_mud");
        GameRegistry.registerBlock(wet_mud_brick, "wet_mud_brick");
        GameRegistry.registerBlock(dry_mud_brick, "dry_mud_brick");
        GameRegistry.registerBlock(dry_mud_brick_stairs, "dry_mud_brick_stairs");
        GameRegistry.registerBlock(dry_mud_brick_slab, ItemMudBrickDrySlab.class, "dry_mud_brick_slab");
        GameRegistry.registerBlock(double_dry_mud_brick_slab, ItemMudBrickDrySlab.class, "double_dry_mud_brick_slab");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerBlock(dry_mud_brick_wall, "dry_mud_brick_wall");
        }
        GameRegistry.registerBlock(salt_crusted_oak_log, "salt_crusted_oak_log");
        GameRegistry.registerBlock(blossom_planks, "blossom_planks");
//        GameRegistry.registerBlock(blossomSapling, "blossomSapling");
        GameRegistry.registerBlock(blossom_log, "blossom_log");
        GameRegistry.registerBlock(blossom_burrow, "blossom_burrow");
        if(Loader.isModLoaded("etfuturum")) {
            GameRegistry.registerBlock(blossom_stripped_log, "blossom_stripped_log");
            GameRegistry.registerBlock(blossom_wood, "blossom_wood");
            GameRegistry.registerBlock(blossom_stripped_wood, "blossom_stripped_wood");
        }
        GameRegistry.registerBlock(blossom_leaves, "blossom_leaves");
        GameRegistry.registerBlock(blossom_slab, ItemBlossomSlab.class,"blossom_slab");
        GameRegistry.registerBlock(double_blossom_slab, ItemBlossomSlab.class,"double_blossom_slab");
        if(Loader.isModLoaded("etfuturum")) {
//            GameRegistry.registerBlock(blossomFence, "blossomFence");
        }
        GameRegistry.registerBlock(blossom_stairs, "blossom_stairs");
        if(Loader.isModLoaded("etfuturum") && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableWoodRedstone) {
            GameRegistry.registerBlock(blossom_pressure_plate, "blossom_pressure_plate");
            GameRegistry.registerBlock(blossom_button, "blossom_button");
        }
        if(Loader.isModLoaded("etfuturum")) {
//            GameRegistry.registerBlock(blossomDoor, "blossomDoor");
//            GameRegistry.registerBlock(blossomTrapdoor, "blossomTrapdoor");
//            GameRegistry.registerBlock(blossomFenceGate, "blossomFenceGate");
//            GameRegistry.registerBlock(blossomSign, "blossomSign");
        }
        GameRegistry.registerBlock(apiary, "apiary");
        GameRegistry.registerBlock(extractor, "extractor");
        GameRegistry.registerBlock(lit_extractor, "lit_extractor").setLightLevel(0.9F);
        GameRegistry.registerBlock(steam_extractor, "steam_extractor").setLightLevel(0.9F);
        GameRegistry.registerBlock(storage_crate, ItemStorageCrate.class, "storage_crate");
        GameRegistry.registerBlock(storage_barrel, ItemStorageBarrel.class, "storage_barrel");
        GameRegistry.registerBlock(storage_sack, ItemStorageSack.class, "storage_sack");
        GameRegistry.registerBlock(salt_crystal, "salt_crystal");
        GameRegistry.registerBlock(saltworts, "saltworts");
        GameRegistry.registerBlock(onions, "onions");
//        GameRegistry.registerBlock(marsh_reeds, "marsh_reeds");

        SaltMod.logger.info("Finished initializing Blocks");
    }
}
