package darkbum.saltymod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.blockitem.*;
import darkbum.saltymod.block.*;
import darkbum.saltymod.block.BlockSaltBlock;
import darkbum.saltymod.block.BlockSaltFlower;
import darkbum.saltymod.tileentity.TileEntityBlossomSign;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.CommonProxy;

public class ModBlocks {
    static CreativeTabs tab = CommonProxy.tabSalt;

    public static Block dev_block;

    public static Block salt_ore;

    public static Block deepslate_salt_ore;

    public static Block salt_lake_ore;

    public static Block salt_lake_dirt;

    public static Block salt_block;

    public static BlockStairs salt_brick_stairs;

    public static BlockSlab salt_slab;

    public static BlockSlab double_salt_slab;

    public static Block salt_lamp;

    public static Block salt_grass;

    public static Block salt_dirt;

    public static Block grass_top;

    public static Block mineral_mud;

    public static Block wet_mud_brick;

    public static Block dry_mud_brick;

    public static Block dry_mud_brick_stairs;

    public static BlockSlab dry_mud_brick_slab;

    public static BlockSlab double_dry_mud_brick_slab;

    public static BlockWall dry_mud_brick_wall;

    public static Block salt_crusted_oak_log;

    public static Block blossom_planks;

    public static Block blossom_sapling;

    public static Block blossom_log;

    public static Block blossom_burrow;

    public static Block blossom_wood;

    public static Block blossom_stripped_log;

    public static Block blossom_stripped_burrow;

    public static Block blossom_stripped_wood;

    public static Block blossom_leaves;

    public static BlockSlab blossom_slab;

    public static BlockSlab double_blossom_slab;

    public static Block blossom_stairs;

    public static BlockFence blossom_fence;

    public static BlockFenceGate blossom_fence_gate;

    public static Block blossom_pressure_plate;

    public static Block blossom_button;

    public static Block blossom_door;

    public static Block blossom_trapdoor;

    public static Block blossom_sign_standing;

    public static Block blossom_sign_wall;

    public static Block apiary;

    public static Block evaporator;

    public static Block lit_evaporator;

    public static Block steam_evaporator;

    public static Block storage_crate;

    public static Block storage_barrel;

    public static Block storage_sack;

    public static Block salt_crystal;

    public static Block saltworts;

    public static Block onions;

    public static Block marsh_reeds;

    public static Block salt_flower;

    public static void init() {
        SaltyMod.logger.info("Start to initialize Blocks");

        dev_block = new BlockDevBlock("dev_block", tab);
//        GameRegistry.registerBlock(dev_block, "dev_block");
        salt_ore = new BlockSaltOre("salt_ore", tab);
        GameRegistry.registerBlock(salt_ore, "salt_ore");
        if (Loader.isModLoaded("etfuturum") && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslateOres) {
            deepslate_salt_ore = new BlockSaltDeepslateOre(salt_ore);
            GameRegistry.registerBlock(deepslate_salt_ore, "deepslate_salt_ore");
        }
        salt_lake_ore = new BlockSaltLakeOre("salt_lake_ore", tab);
        GameRegistry.registerBlock(salt_lake_ore, "salt_lake_ore");
        salt_lake_dirt = new BlockSaltLakeDirt("salt_lake_dirt", tab);
        GameRegistry.registerBlock(salt_lake_dirt, "salt_lake_dirt");
        salt_block = new BlockSaltBlock(tab);
        GameRegistry.registerBlock(salt_block, ItemSaltBlock.class, "salt_block");
        salt_brick_stairs = new BlockSaltBrickStairs("salt_brick_stairs", tab);
        GameRegistry.registerBlock(salt_brick_stairs, "salt_brick_stairs");
        salt_slab = new BlockSaltSlab(false, "salt_slab", tab);
        GameRegistry.registerBlock(salt_slab, ItemSaltSlab.class, "salt_slab");
        double_salt_slab = new BlockSaltSlab(true, "double_salt_slab", null);
        GameRegistry.registerBlock(double_salt_slab, ItemSaltSlab.class, "double_salt_slab");
        salt_lamp = new BlockSaltLamp("salt_lamp", tab);
        GameRegistry.registerBlock(salt_lamp, "salt_lamp");
        salt_grass = new BlockSaltGrass("salt_grass", tab);
        GameRegistry.registerBlock(salt_grass, "salt_grass");
        salt_dirt = new BlockSaltDirt("salt_dirt", tab);
        GameRegistry.registerBlock(salt_dirt, "salt_dirt");
        grass_top = new BlockGrassTop("grass_top", null);
        GameRegistry.registerBlock(grass_top, "grass_top");
        mineral_mud = new BlockMineralMud("mineral_mud", tab);
        GameRegistry.registerBlock(mineral_mud, "mineral_mud");
        wet_mud_brick = new BlockWetMudBrick("wet_mud_brick", tab);
        GameRegistry.registerBlock(wet_mud_brick, "wet_mud_brick");
        dry_mud_brick = new BlockDryMudBrick("dry_mud_brick", tab);
        GameRegistry.registerBlock(dry_mud_brick, "dry_mud_brick");
        dry_mud_brick_stairs = new BlockDryMudBrickStairs("dry_mud_brick_stairs", tab);
        GameRegistry.registerBlock(dry_mud_brick_stairs, "dry_mud_brick_stairs");
        dry_mud_brick_slab = new BlockDryMudBrickSlab(false, "dry_mud_brick_slab", tab);
        GameRegistry.registerBlock(dry_mud_brick_slab, ItemMudBrickDrySlab.class, "dry_mud_brick_slab");
        double_dry_mud_brick_slab = new BlockDryMudBrickSlab(true, "double_dry_mud_brick_slab", null);
        GameRegistry.registerBlock(double_dry_mud_brick_slab, ItemMudBrickDrySlab.class, "double_dry_mud_brick_slab");
        if(Loader.isModLoaded("etfuturum")) {
            dry_mud_brick_wall = new BlockDryMudBrickWall(ModBlocks.dry_mud_brick, tab);
            GameRegistry.registerBlock(dry_mud_brick_wall, "dry_mud_brick_wall");
        }
        salt_crusted_oak_log = new BlockSaltCrustedOakLog("salt_crusted_oak_log", tab);
        GameRegistry.registerBlock(salt_crusted_oak_log, "salt_crusted_oak_log");
        blossom_planks = new BlockBlossomPlanks("blossom_planks", tab);
        GameRegistry.registerBlock(blossom_planks, "blossom_planks");
        blossom_sapling = new BlockBlossomSapling("blossom_sapling", tab);
        GameRegistry.registerBlock(blossom_sapling, "blossom_sapling");
        blossom_log = new BlockBlossomLog("blossom_log", tab);
        GameRegistry.registerBlock(blossom_log, "blossom_log");
        blossom_burrow = new BlockBlossomBurrow("blossom_burrow", tab);
        GameRegistry.registerBlock(blossom_burrow, "blossom_burrow");
        if(Loader.isModLoaded("etfuturum")) {
            blossom_wood = new BlockBlossomWood("blossom_wood", tab);
            GameRegistry.registerBlock(blossom_wood, "blossom_wood");
            blossom_stripped_log = new BlockBlossomStrippedLog("blossom_stripped_log", tab);
            GameRegistry.registerBlock(blossom_stripped_log, "blossom_stripped_log");
            blossom_stripped_burrow = new BlockBlossomStrippedBurrow("blossom_stripped_burrow", tab);
            GameRegistry.registerBlock(blossom_stripped_burrow, "blossom_stripped_burrow");
            blossom_stripped_wood = new BlockBlossomStrippedWood("blossom_stripped_wood", tab);
            GameRegistry.registerBlock(blossom_stripped_wood, "blossom_stripped_wood");
        }
        blossom_leaves = new BlockBlossomLeaves("blossom_leaves", tab);
        GameRegistry.registerBlock(blossom_leaves, "blossom_leaves");
        blossom_slab = new BlockBlossomSlab(false, "blossom_slab", tab);
        GameRegistry.registerBlock(blossom_slab, ItemBlossomSlab.class,"blossom_slab");
        double_blossom_slab = new BlockBlossomSlab(true, "double_blossom_slab", null);
        GameRegistry.registerBlock(double_blossom_slab, ItemBlossomSlab.class,"double_blossom_slab");
        blossom_stairs = new BlockBlossomStairs("blossom_stairs", tab);
        GameRegistry.registerBlock(blossom_stairs, "blossom_stairs");
        if(Loader.isModLoaded("etfuturum")) {
            blossom_fence = new BlockBlossomFence("blossom_fence", tab);
            GameRegistry.registerBlock(blossom_fence, "blossom_fence");
            blossom_fence_gate = new BlockBlossomFenceGate("blossom_fence_gate", tab);
            GameRegistry.registerBlock(blossom_fence_gate, "blossom_fence_gate");
        }
        if(Loader.isModLoaded("etfuturum") && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableWoodRedstone) {
            blossom_pressure_plate = new BlockBlossomPressurePlate(0, tab);
            GameRegistry.registerBlock(blossom_pressure_plate, "blossom_pressure_plate");
            blossom_button = new BlockBlossomButton();
            GameRegistry.registerBlock(blossom_button, "blossom_button");
        }
        if(Loader.isModLoaded("etfuturum")) {
            blossom_door = new BlockBlossomDoor("blossom_door", tab);
            GameRegistry.registerBlock(blossom_door, ItemBlossomDoor.class, "blossom_door");
            blossom_trapdoor = new BlockBlossomTrapdoor("blossom_trapdoor", tab);
            GameRegistry.registerBlock(blossom_trapdoor, "blossom_trapdoor");
            blossom_sign_standing = new BlockBlossomSign(TileEntityBlossomSign.class, true);
            GameRegistry.registerBlock(blossom_sign_standing, "blossom_sign_standing");
            blossom_sign_wall = new BlockBlossomSign(TileEntityBlossomSign.class, false);
            GameRegistry.registerBlock(blossom_sign_wall, "blossom_sign_wall");
        }
        apiary = new BlockApiary("apiary", tab);
        GameRegistry.registerBlock(apiary, "apiary");
        evaporator = new BlockEvaporator(false, false, "evaporator", tab);
        GameRegistry.registerBlock(evaporator, "evaporator");
        lit_evaporator = new BlockEvaporator(true, false, "evaporator", null);
        GameRegistry.registerBlock(lit_evaporator, "lit_evaporator").setLightLevel(0.9F);
        steam_evaporator = new BlockEvaporator(true, true, "evaporator", null);
        GameRegistry.registerBlock(steam_evaporator, "steam_evaporator").setLightLevel(0.9F);
        storage_crate = new BlockStorageCrate("storage_crate", tab);
        GameRegistry.registerBlock(storage_crate, ItemStorageCrate.class, "storage_crate");
        storage_barrel = new BlockStorageBarrel("storage_barrel", tab);
        GameRegistry.registerBlock(storage_barrel, ItemStorageBarrel.class, "storage_barrel");
        storage_sack = new BlockStorageSack("storage_sack", tab);
        GameRegistry.registerBlock(storage_sack, ItemStorageSack.class, "storage_sack");
        salt_crystal = new BlockSaltCrystal("salt_crystal", tab);
        GameRegistry.registerBlock(salt_crystal, "salt_crystal");
        saltworts = new BlockSaltworts("saltworts", null);
        GameRegistry.registerBlock(saltworts, "saltworts");
        onions = new BlockOnions("onions", null);
        GameRegistry.registerBlock(onions, "onions");
        marsh_reeds = new BlockMarshReeds("marsh_reeds", tab);
//        GameRegistry.registerBlock(marsh_reeds, "marsh_reeds");
        salt_flower = new BlockSaltFlower();
        GameRegistry.registerBlock(salt_flower, ItemSaltFlower.class, "salt_flower");

        SaltyMod.logger.info("Finished initializing Blocks");
    }
}
