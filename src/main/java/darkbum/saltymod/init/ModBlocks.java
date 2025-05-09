package darkbum.saltymod.init;

import darkbum.saltymod.block.itemblock.*;
import darkbum.saltymod.util.ConditionalRegistrar;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.block.*;
import darkbum.saltymod.block.BlockSaltBlock;
import darkbum.saltymod.block.BlockSaltFlowerDirt;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.common.config.ModConfigurationModCompatibility;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;

import static darkbum.saltymod.block.BlockMarshReeds.*;

public class ModBlocks {

    static CreativeTabs tab = CommonProxy.tabSaltBlocks;

    public static Block dev_block;
    public static Block salt_ore;
    public static Block deepslate_salt_ore;
    public static Block salt_lake;
    public static Block salt_block;
    public static BlockStairs salt_brick_stairs;
    public static BlockSlab salt_slab;
    public static BlockSlab double_salt_slab;
    public static Block salt_lamp;
    public static Block salt_grass;
    public static Block salt_dirt_lite;
    public static Block salt_dirt;
    public static Block grass_top;
    public static Block reeds_block;
    public static Block mineral_mud;
    public static Block wet_mud_brick;
    public static Block dry_mud_brick;
    public static Block dry_mud_brick_stairs;
    public static BlockSlab dry_mud_brick_slab;
    public static BlockSlab double_dry_mud_brick_slab;
    public static BlockWall dry_mud_brick_wall;
    public static Block salt_crusted_oak_log;
    public static Block evaporator;
    public static Block lit_evaporator;
    public static Block steam_evaporator;
    public static Block fish_farm;
    public static Block bee_nest_temperate;
    public static Block bee_nest_boreal;
    public static Block bee_burrow_spruce;
    public static Block bee_burrow_birch;
    public static Block bee_burrow_spruce_stripped;
    public static Block bee_burrow_birch_stripped;
    public static Block apiary;
    public static Block stove;
    public static Block lit_stove;
    public static Block mill;
    public static Block press;
    public static Block cooking_pot;
    public static Block clay_oven;
    public static Block storage_crate;
    public static Block storage_barrel;
    public static Block storage_sack;
    public static Block salt_crystal;
    public static Block onions;
    public static Block saltworts;
    public static Block salt_flower_d;
    public static Block salt_flower_s;
    public static Block marsh_reeds_t;
    public static Block marsh_reeds_b;


    public static void init() {

        dev_block = new BlockDevBlock("dev_block", tab);

        salt_ore = new BlockSaltOre("salt_ore", tab);
        deepslate_salt_ore = new BlockSaltDeepslateOre(salt_ore, "deepslate_salt_ore", tab);
        salt_lake = new BlockSaltLake("salt_lake", tab);

        salt_block = new BlockSaltBlock(tab);
        salt_brick_stairs = new BlockSaltBrickStairs("salt_brick_stairs", tab);
        salt_slab = new BlockSaltSlab(false, "salt_slab", tab);
        double_salt_slab = new BlockSaltSlab(true, "double_salt_slab", null);
        salt_lamp = new BlockSaltLamp("salt_lamp", tab);

        salt_grass = new BlockSaltGrass("salt_grass", tab);
        salt_dirt_lite = new BlockSaltDirtLite("salt_dirt_lite", tab);
        salt_dirt = new BlockSaltDirt("salt_dirt", tab);
        grass_top = new BlockGrassTop("grass_top", null);

        reeds_block = new BlockReedsBale("reeds_block", tab);

        mineral_mud = new BlockMineralMud("mineral_mud", tab);
        wet_mud_brick = new BlockWetMudBrick("wet_mud_brick", tab);
        dry_mud_brick = new BlockDryMudBrick("dry_mud_brick", tab);
        dry_mud_brick_stairs = new BlockDryMudBrickStairs("dry_mud_brick_stairs", tab);
        dry_mud_brick_slab = new BlockDryMudBrickSlab(false, "dry_mud_brick_slab", tab);
        double_dry_mud_brick_slab = new BlockDryMudBrickSlab(true, "double_dry_mud_brick_slab", null);
        dry_mud_brick_wall = new BlockDryMudBrickWall(ModBlocks.dry_mud_brick, tab);

        salt_crusted_oak_log = new BlockSaltCrustedLog("salt_crusted_oak_log", tab);

        evaporator = new BlockEvaporator("evaporator", tab, false, false);
        lit_evaporator = new BlockEvaporator("evaporator", null, true, false).setLightLevel(0.9F);
        steam_evaporator = new BlockEvaporator("evaporator", null, true, true).setLightLevel(0.9F);

        fish_farm = new BlockFishFarm("fish_farm", tab);

        bee_nest_temperate = new BlockBeeNest("bee_nest", tab, BlockBeeNest.BeeNestType.TEMPERATE);
        bee_nest_boreal = new BlockBeeNest("bee_nest", tab, BlockBeeNest.BeeNestType.BOREAL);
        bee_burrow_spruce = new BlockBeeBurrow("bee_burrow", tab, BlockBeeBurrow.BeeBurrowType.SPRUCE);
        bee_burrow_birch = new BlockBeeBurrow("bee_burrow", tab, BlockBeeBurrow.BeeBurrowType.BIRCH);
        bee_burrow_spruce_stripped = new BlockBeeBurrowStripped("bee_burrow_stripped", tab, BlockBeeBurrowStripped.BeeBurrowType.SPRUCE);
        bee_burrow_birch_stripped = new BlockBeeBurrowStripped("bee_burrow_stripped", tab, BlockBeeBurrowStripped.BeeBurrowType.BIRCH);
        apiary = new BlockApiary("apiary", tab);

        stove = new BlockStove("stove", tab);
        lit_stove = new BlockStoveLit("stove", null);
        press = new BlockPress("press", tab);
        mill = new BlockMill("mill", tab);
        cooking_pot = new BlockCookingPot("cooking_pot", tab);
        clay_oven = new BlockClayOven("clay_oven", tab);

        storage_crate = new BlockStorageCrate("storage_crate", tab);
        storage_barrel = new BlockStorageBarrel("storage_barrel", tab);
        storage_sack = new BlockStorageSack("storage_sack", tab);

        salt_crystal = new BlockSaltCrystal("salt_crystal", tab);

        onions = new BlockOnions("onions", null);
        saltworts = new BlockSaltworts("saltworts", null);
        salt_flower_d = new BlockSaltFlowerDirt();
        salt_flower_s = new BlockSaltFlowerSand();

        marsh_reeds_t = new BlockMarshReedsTop("marsh_reeds", null);
        marsh_reeds_b = new BlockMarshReedsBottom("marsh_reeds", tab);


        ConditionalRegistrar.registerBlock(dev_block, "dev_block");
        ConditionalRegistrar.registerBlock(salt_ore, "salt_ore", ModConfigurationBlocks.enableSaltOre);
        ConditionalRegistrar.registerBlock(deepslate_salt_ore, "deepslate_salt_ore", ModConfigurationBlocks.enableSaltOre, Loader.isModLoaded("etfuturum"), ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate, ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslateOres);
        ConditionalRegistrar.registerBlock(salt_lake, "salt_lake", ModConfigurationWorldGeneration.enableSaltLakes);
        ConditionalRegistrar.registerBlock(salt_block, ItemBlockSaltBlock.class, "salt_block", ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.registerBlock(salt_brick_stairs, "salt_brick_stairs", ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.registerBlock(salt_slab, ItemBlockSaltSlab.class, "salt_slab", ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.registerBlock(double_salt_slab, ItemBlockSaltSlab.class, "double_salt_slab", ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.registerBlock(salt_lamp, "salt_lamp", ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.registerBlock(salt_grass, "salt_grass", ModConfigurationBlocks.enableSaltDirt);
        ConditionalRegistrar.registerBlock(salt_dirt_lite, "salt_dirt_lite", ModConfigurationBlocks.enableSaltDirt);
        ConditionalRegistrar.registerBlock(salt_dirt, ItemBlockSaltDirt.class, "salt_dirt", ModConfigurationBlocks.enableSaltDirt);
        ConditionalRegistrar.registerBlock(grass_top, "grass_top", ModConfigurationBlocks.enableSaltDirt);
        ConditionalRegistrar.registerBlock(reeds_block, "reeds_block", ModConfigurationWorldGeneration.enableSaltMarsh);
        ConditionalRegistrar.registerBlock(mineral_mud, "mineral_mud", ModConfigurationItems.enableMineralMud);
        ConditionalRegistrar.registerBlock(wet_mud_brick, "wet_mud_brick", ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.registerBlock(dry_mud_brick, "dry_mud_brick", ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.registerBlock(dry_mud_brick_stairs, "dry_mud_brick_stairs", ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.registerBlock(dry_mud_brick_slab, ItemBlockMudBrickDrySlab.class, "dry_mud_brick_slab", ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.registerBlock(double_dry_mud_brick_slab, ItemBlockMudBrickDrySlab.class, "double_dry_mud_brick_slab", ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.registerBlock(dry_mud_brick_wall, "dry_mud_brick_wall", ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks, Loader.isModLoaded("etfuturum"), ModConfigurationModCompatibility.enableMudBrickWall);
        ConditionalRegistrar.registerBlock(salt_crusted_oak_log, "salt_crusted_oak_log", ModConfigurationWorldGeneration.enableSaltMarsh);
        ConditionalRegistrar.registerBlock(evaporator, "evaporator", ModConfigurationBlocks.enableEvaporator);
        ConditionalRegistrar.registerBlock(lit_evaporator, "lit_evaporator", ModConfigurationBlocks.enableEvaporator);
        ConditionalRegistrar.registerBlock(steam_evaporator, "steam_evaporator", ModConfigurationBlocks.enableEvaporator);
        ConditionalRegistrar.registerBlock(fish_farm, "fish_farm", ModConfigurationBlocks.enableFishFarm);
        ConditionalRegistrar.registerBlock(bee_nest_temperate, ItemBlockBeeNest.class, "bee_nest_temperate", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(bee_nest_boreal, ItemBlockBeeNest.class, "bee_nest_boreal", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(bee_burrow_spruce, ItemBlockBeeBurrow.class, "bee_burrow_spruce", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(bee_burrow_birch, ItemBlockBeeBurrow.class, "bee_burrow_birch", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(bee_burrow_spruce_stripped, ItemBlockBeeBurrow.class, "bee_burrow_spruce_stripped", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(bee_burrow_birch_stripped, ItemBlockBeeBurrow.class, "bee_burrow_birch_stripped", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(apiary, "apiary", ModConfigurationBlocks.enableApiary);
        ConditionalRegistrar.registerBlock(stove, "stove", ModConfigurationBlocks.enableMachines);
        ConditionalRegistrar.registerBlock(lit_stove, "lit_stove", ModConfigurationBlocks.enableMachines);
        ConditionalRegistrar.registerBlock(press, "press", ModConfigurationBlocks.enableMachines);
        ConditionalRegistrar.registerBlock(mill, "mill", ModConfigurationBlocks.enableMachines);
        ConditionalRegistrar.registerBlock(cooking_pot, ItemBlockCookingPot.class, "cooking_pot", ModConfigurationBlocks.enableMachines);
        ConditionalRegistrar.registerBlock(clay_oven, ItemBlockClayOven.class, "clay_oven", ModConfigurationBlocks.enableMachines);
        ConditionalRegistrar.registerBlock(storage_crate, ItemBlockStorageCrate.class, "storage_crate", ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.registerBlock(storage_barrel, ItemBlockStorageBarrel.class, "storage_barrel", ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.registerBlock(storage_sack, ItemBlockStorageSack.class, "storage_sack", ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.registerBlock(salt_crystal, "salt_crystal", ModConfigurationBlocks.enableSaltCrystal);
        ConditionalRegistrar.registerBlock(onions, "onions", ModConfigurationItems.enableOnion);
        ConditionalRegistrar.registerBlock(saltworts, "saltworts");
        ConditionalRegistrar.registerBlock(salt_flower_d, ItemBlockSaltFlowerDirt.class, "salt_flower_d", ModConfigurationBlocks.enableSaltFlowers);
        ConditionalRegistrar.registerBlock(salt_flower_s, ItemBlockSaltFlowerSand.class, "salt_flower_s", ModConfigurationBlocks.enableSaltFlowers, Loader.isModLoaded("etfuturum"));
        ConditionalRegistrar.registerBlock(marsh_reeds_t, ItemBlockMarshReeds.class,"marsh_reeds_t", ModConfigurationWorldGeneration.enableSaltMarsh);
        ConditionalRegistrar.registerBlock(marsh_reeds_b, ItemBlockMarshReeds.class, "marsh_reeds_b", ModConfigurationWorldGeneration.enableSaltMarsh);
    }
}
