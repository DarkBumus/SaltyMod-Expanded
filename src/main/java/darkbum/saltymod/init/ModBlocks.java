package darkbum.saltymod.init;

import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.block.*;
import darkbum.saltymod.block.BlockSaltBlock;
import darkbum.saltymod.block.BlockSaltFlower;
import darkbum.saltymod.blockitem.*;
import darkbum.saltymod.common.CommonProxy;
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.configuration.configs.ModConfigurationModCompatibility;
import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;

public class ModBlocks {

    static CreativeTabs tab = CommonProxy.tabSalt;

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

    public static Block bee_nest_boreal;

    public static Block bee_nest_temperate;

    public static Block bee_burrow_spruce;

    public static Block bee_burrow_spruce_stripped;

    public static Block bee_burrow_birch;

    public static Block bee_burrow_birch_stripped;

    public static Block apiary;

    public static Block heater;

    public static Block press;

    public static Block storage_crate;

    public static Block storage_barrel;

    public static Block storage_sack;

    public static Block salt_crystal;

    public static Block onions;

    public static Block saltworts;

    public static Block salt_flower;

    public static Block marsh_reeds;

    public static void init() {
        SaltyMod.logger.info("Start to initialize SaltyMod Blocks");

        dev_block = new BlockDevBlock("dev_block", tab);
        GameRegistry.registerBlock(dev_block, "dev_block");
        salt_ore = new BlockSaltOre("salt_ore", tab);
        GameRegistry.registerBlock(salt_ore, "salt_ore");
        if (Loader.isModLoaded("etfuturum")
            && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate
            && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslateOres) {
            deepslate_salt_ore = new BlockSaltDeepslateOre(salt_ore);
            GameRegistry.registerBlock(deepslate_salt_ore, "deepslate_salt_ore");
        }
        if (ModConfigurationWorldGeneration.enableSaltLakes) {
            salt_lake = new BlockSaltLake("salt_lake", tab);
            GameRegistry.registerBlock(salt_lake, "salt_lake");
        }
        if (ModConfigurationBlocks.enableSaltBlocks) {
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
        }
        if (ModConfigurationBlocks.enableSaltDirt) {
            salt_grass = new BlockSaltGrass("salt_grass", tab);
            GameRegistry.registerBlock(salt_grass, "salt_grass");
            salt_dirt_lite = new BlockSaltDirtLite("salt_dirt_lite", tab);
            GameRegistry.registerBlock(salt_dirt_lite, "salt_dirt_lite");
            salt_dirt = new BlockSaltDirt("salt_dirt", tab);
            GameRegistry.registerBlock(salt_dirt, ItemSaltDirt.class, "salt_dirt");
            grass_top = new BlockGrassTop("grass_top", null);
            GameRegistry.registerBlock(grass_top, "grass_top");
        }
        if (ModConfigurationItems.enableMineralMud) {
            mineral_mud = new BlockMineralMud("mineral_mud", tab);
            GameRegistry.registerBlock(mineral_mud, "mineral_mud");
            if (ModConfigurationBlocks.enableMudBricks) {
                wet_mud_brick = new BlockWetMudBrick("wet_mud_brick", tab);
                GameRegistry.registerBlock(wet_mud_brick, "wet_mud_brick");
                dry_mud_brick = new BlockDryMudBrick("dry_mud_brick", tab);
                GameRegistry.registerBlock(dry_mud_brick, "dry_mud_brick");
                dry_mud_brick_stairs = new BlockDryMudBrickStairs("dry_mud_brick_stairs", tab);
                GameRegistry.registerBlock(dry_mud_brick_stairs, "dry_mud_brick_stairs");
                dry_mud_brick_slab = new BlockDryMudBrickSlab(false, "dry_mud_brick_slab", tab);
                GameRegistry.registerBlock(dry_mud_brick_slab, ItemMudBrickDrySlab.class, "dry_mud_brick_slab");
                double_dry_mud_brick_slab = new BlockDryMudBrickSlab(true, "double_dry_mud_brick_slab", null);
                GameRegistry
                    .registerBlock(double_dry_mud_brick_slab, ItemMudBrickDrySlab.class, "double_dry_mud_brick_slab");
                if (Loader.isModLoaded("etfuturum") && ModConfigurationModCompatibility.enableMudBrickWall) {
                    dry_mud_brick_wall = new BlockDryMudBrickWall(ModBlocks.dry_mud_brick, tab);
                    GameRegistry.registerBlock(dry_mud_brick_wall, "dry_mud_brick_wall");
                }
            }
        }
        if (ModConfigurationWorldGeneration.enableSaltMarsh) {
            salt_crusted_oak_log = new BlockSaltCrustedOakLog("salt_crusted_oak_log", tab);
            GameRegistry.registerBlock(salt_crusted_oak_log, "salt_crusted_oak_log");
        }
        if (ModConfigurationBlocks.enableEvaporator) {
            evaporator = new BlockEvaporator(false, false, "evaporator", tab);
            GameRegistry.registerBlock(evaporator, "evaporator");
            lit_evaporator = new BlockEvaporator(true, false, "evaporator", null);
            GameRegistry.registerBlock(lit_evaporator, "lit_evaporator")
                .setLightLevel(0.9F);
            steam_evaporator = new BlockEvaporator(true, true, "evaporator", null);
            GameRegistry.registerBlock(steam_evaporator, "steam_evaporator")
                .setLightLevel(0.9F);
        }
        if (ModConfigurationBlocks.enableFishFarm) {
            fish_farm = new BlockFishFarm("fish_farm", tab);
            GameRegistry.registerBlock(fish_farm, "fish_farm");
        }
        if (ModConfigurationBlocks.enableApiary) {
            bee_nest_temperate = new BlockBeeNestTemperate("bee_nest_temperate", tab);
            GameRegistry.registerBlock(bee_nest_temperate, "bee_nest_temperate");
            bee_nest_boreal = new BlockBeeNestBoreal("bee_nest_boreal", tab);
            GameRegistry.registerBlock(bee_nest_boreal, "bee_nest_boreal");
            bee_burrow_spruce = new BlockBeeBurrowSpruce("bee_burrow_spruce", tab);
            GameRegistry.registerBlock(bee_burrow_spruce, "bee_burrow_spruce");
            bee_burrow_spruce_stripped = new BlockBeeBurrowSpruceStripped("bee_burrow_spruce_stripped", tab);
            GameRegistry.registerBlock(bee_burrow_spruce_stripped, "bee_burrow_spruce_stripped");
            bee_burrow_birch = new BlockBeeBurrowBirch("bee_burrow_birch", tab);
            GameRegistry.registerBlock(bee_burrow_birch, "bee_burrow_birch");
            bee_burrow_birch_stripped = new BlockBeeBurrowBirchStripped("bee_burrow_birch_stripped", tab);
            GameRegistry.registerBlock(bee_burrow_birch_stripped, "bee_burrow_birch_stripped");
            apiary = new BlockApiary("apiary", tab);
            GameRegistry.registerBlock(apiary, "apiary");
        }
        if (ModConfigurationBlocks.enableHeater) {
            heater = new BlockHeater("heater", tab);
            GameRegistry.registerBlock(heater, "heater");
            press = new BlockPress("press", tab);
            GameRegistry.registerBlock(press, "press");
        }
        if (ModConfigurationBlocks.enableStorageBlocks) {
            storage_crate = new BlockStorageCrate("storage_crate", tab);
            GameRegistry.registerBlock(storage_crate, ItemStorageCrate.class, "storage_crate");
            storage_barrel = new BlockStorageBarrel("storage_barrel", tab);
            GameRegistry.registerBlock(storage_barrel, ItemStorageBarrel.class, "storage_barrel");
            storage_sack = new BlockStorageSack("storage_sack", tab);
            GameRegistry.registerBlock(storage_sack, ItemStorageSack.class, "storage_sack");
        }
        if (ModConfigurationBlocks.enableSaltCrystal) {
            salt_crystal = new BlockSaltCrystal("salt_crystal", tab);
            GameRegistry.registerBlock(salt_crystal, "salt_crystal");
        }
        if (ModConfigurationItems.enableOnion) {
            onions = new BlockOnions("onions", null);
            GameRegistry.registerBlock(onions, "onions");
        }
        saltworts = new BlockSaltworts("saltworts", null);
        GameRegistry.registerBlock(saltworts, "saltworts");
        if (ModConfigurationBlocks.enableSaltFlowers) {
            salt_flower = new BlockSaltFlower();
            GameRegistry.registerBlock(salt_flower, ItemSaltFlower.class, "salt_flower");
        }
        if (ModConfigurationWorldGeneration.enableSaltMarsh) {
            marsh_reeds = new BlockMarshReeds("marsh_reeds", null);
            GameRegistry.registerBlock(marsh_reeds, "marsh_reeds");
        }

        SaltyMod.logger.info("Finished initializing SaltyMod Blocks");
    }
}
