package darkbum.saltymod.init;

import darkbum.saltymod.block.itemblock.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;

import darkbum.saltymod.block.*;
import darkbum.saltymod.block.BlockSaltBlock;
import darkbum.saltymod.block.BlockSaltFlowerDirt;

import static darkbum.saltymod.block.BlockBeeBurrow.BeeBurrowType.*;
import static darkbum.saltymod.block.BlockBeeNest.BeeNestType.*;
import static darkbum.saltymod.block.BlockMarshReeds.*;
import static darkbum.saltymod.block.BlockStove.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;
import static darkbum.saltymod.common.proxy.CommonProxy.*;
import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.registerBlock;
import static ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.*;

/**
 * Blocks class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModBlocks {

    static CreativeTabs tab = tabSaltBlocks;

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

    /**
     * Initializes and registers all blocks.
     */
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
        lit_evaporator = new BlockEvaporator("evaporator", null, true, false).setLightLevel(0.875f);
        steam_evaporator = new BlockEvaporator("evaporator", null, true, true).setLightLevel(0.875f);

        fish_farm = new BlockFishFarm("fish_farm", tab);

        bee_nest_temperate = new BlockBeeNest("bee_nest", tab, TEMPERATE);
        bee_nest_boreal = new BlockBeeNest("bee_nest", tab, BOREAL);
        bee_burrow_spruce = new BlockBeeBurrow("bee_burrow", tab, SPRUCE);
        bee_burrow_birch = new BlockBeeBurrow("bee_burrow", tab, BIRCH);
        bee_burrow_spruce_stripped = new BlockBeeBurrowStripped("bee_burrow_stripped", tab, SPRUCE);
        bee_burrow_birch_stripped = new BlockBeeBurrowStripped("bee_burrow_stripped", tab, BIRCH);
        apiary = new BlockApiary("apiary", tab);

        stove = new BlockStoveUnlit("stove", tab);
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


//        registerBlock(dev_block, "dev_block");
        registerBlock(salt_ore, "salt_ore", enableSaltOre);
        if (efr) {
            if (enableDeepslate && enableDeepslateOres) {
                registerBlock(deepslate_salt_ore, "deepslate_salt_ore", enableSaltOre);
            }
        }
        registerBlock(salt_lake, "salt_lake", enableSaltLakes);
        registerBlock(salt_block, ItemBlockSaltBlock.class, "salt_block", enableSaltBlocks);
        registerBlock(salt_brick_stairs, "salt_brick_stairs", enableSaltBlocks);
        registerBlock(salt_slab, ItemBlockSaltSlab.class, "salt_slab", enableSaltBlocks);
        registerBlock(double_salt_slab, ItemBlockSaltSlab.class, "double_salt_slab", enableSaltBlocks);
        registerBlock(salt_lamp, "salt_lamp", enableSaltBlocks);
        registerBlock(salt_grass, "salt_grass", enableSaltDirt);
        registerBlock(salt_dirt_lite, "salt_dirt_lite", enableSaltDirt);
        registerBlock(salt_dirt, ItemBlockSaltDirt.class, "salt_dirt", enableSaltDirt);
        registerBlock(grass_top, "grass_top", enableSaltDirt);
        registerBlock(reeds_block, "reeds_block", enableSaltMarsh);
        registerBlock(mineral_mud, "mineral_mud", enableMineralMud);
        registerBlock(wet_mud_brick, "wet_mud_brick", enableMineralMud, enableMudBricks);
        registerBlock(dry_mud_brick, "dry_mud_brick", enableMineralMud, enableMudBricks);
        registerBlock(dry_mud_brick_stairs, "dry_mud_brick_stairs", enableMineralMud, enableMudBricks);
        registerBlock(dry_mud_brick_slab, ItemBlockMudBrickDrySlab.class, "dry_mud_brick_slab", enableMineralMud, enableMudBricks);
        registerBlock(double_dry_mud_brick_slab, ItemBlockMudBrickDrySlab.class, "double_dry_mud_brick_slab", enableMineralMud, enableMudBricks);
        registerBlock(dry_mud_brick_wall, "dry_mud_brick_wall", enableMineralMud, enableMudBricks, efr, enableMudBrickWall);
        registerBlock(salt_crusted_oak_log, "salt_crusted_oak_log", enableSaltMarsh);
        registerBlock(evaporator, "evaporator", enableEvaporator);
        registerBlock(lit_evaporator, "lit_evaporator", enableEvaporator);
        registerBlock(steam_evaporator, "steam_evaporator", enableEvaporator);
        registerBlock(fish_farm, "fish_farm", enableFishFarm);
        registerBlock(bee_nest_temperate, ItemBlockBeeNest.class, "bee_nest_temperate", enableApiary);
        registerBlock(bee_nest_boreal, ItemBlockBeeNest.class, "bee_nest_boreal", enableApiary);
        registerBlock(bee_burrow_spruce, ItemBlockBeeBurrow.class, "bee_burrow_spruce", enableApiary);
        registerBlock(bee_burrow_birch, ItemBlockBeeBurrow.class, "bee_burrow_birch", enableApiary);
        registerBlock(bee_burrow_spruce_stripped, ItemBlockBeeBurrow.class, "bee_burrow_spruce_stripped", enableApiary);
        registerBlock(bee_burrow_birch_stripped, ItemBlockBeeBurrow.class, "bee_burrow_birch_stripped", enableApiary);
        registerBlock(apiary, "apiary", enableApiary);
        registerBlock(stove, "stove", enableMachines);
        registerBlock(lit_stove, "lit_stove", enableMachines);
        registerBlock(press, "press", enableMachines);
        registerBlock(mill, "mill", enableMachines);
        registerBlock(cooking_pot, ItemBlockCookingPot.class, "cooking_pot", enableMachines);
        registerBlock(clay_oven, ItemBlockClayOven.class, "clay_oven", enableMachines);
        registerBlock(storage_crate, ItemBlockStorageCrate.class, "storage_crate", enableStorageBlocks);
        registerBlock(storage_barrel, ItemBlockStorageBarrel.class, "storage_barrel", enableStorageBlocks);
        registerBlock(storage_sack, ItemBlockStorageSack.class, "storage_sack", enableStorageBlocks);
        registerBlock(salt_crystal, "salt_crystal", enableSaltCrystal);
        registerBlock(onions, "onions", enableOnion);
        registerBlock(saltworts, "saltworts");
        registerBlock(salt_flower_d, ItemBlockSaltFlowerDirt.class, "salt_flower_d", enableSaltFlowers);
        registerBlock(salt_flower_s, ItemBlockSaltFlowerSand.class, "salt_flower_s", enableSaltFlowers, efr);
        registerBlock(marsh_reeds_t, ItemBlockMarshReeds.class,"marsh_reeds_t", enableSaltMarsh);
        registerBlock(marsh_reeds_b, ItemBlockMarshReeds.class, "marsh_reeds_b", enableSaltMarsh);
    }
}
