package darkbum.saltymod.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.blockitem.*;
import darkbum.saltymod.block.*;
import darkbum.saltymod.block.BlockSaltBlock;
import darkbum.saltymod.block.BlockSaltFlower;
import darkbum.saltymod.configuration.ModConfiguration;
import net.minecraft.block.*;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.creativetab.CreativeTabs;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.CommonProxy;

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

    public static Block bee_burrow_spruce;

    public static Block bee_burrow_spruce_stripped;

    public static Block bee_burrow_birch;

    public static Block bee_burrow_birch_stripped;

    public static Block apiary;

    public static Block storage_crate;

    public static Block storage_barrel;

    public static Block storage_sack;

    public static Block salt_crystal;

    public static Block saltworts;

    public static Block onions;

    public static Block salt_flower;

    public static void init() {
        SaltyMod.logger.info("Start to initialize SaltyMod Blocks");

        dev_block = new BlockDevBlock("dev_block", tab);
        GameRegistry.registerBlock(dev_block, "dev_block");
        salt_ore = new BlockSaltOre("salt_ore", tab);
        GameRegistry.registerBlock(salt_ore, "salt_ore");
        if (Loader.isModLoaded("etfuturum") && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate && ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslateOres) {
            deepslate_salt_ore = new BlockSaltDeepslateOre(salt_ore);
            GameRegistry.registerBlock(deepslate_salt_ore, "deepslate_salt_ore");
        }
        if(ModConfiguration.enableSaltLakes) {
            salt_lake = new BlockSaltLake("salt_lake", tab);
            GameRegistry.registerBlock(salt_lake, "salt_lake");
        }
        if(ModConfiguration.enableSaltBlocks) {
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
        if(ModConfiguration.enableSaltDirt) {
            salt_grass = new BlockSaltGrass("salt_grass", tab);
            GameRegistry.registerBlock(salt_grass, "salt_grass");
            salt_dirt_lite = new BlockSaltDirtLite("salt_dirt_lite", tab);
            GameRegistry.registerBlock(salt_dirt_lite, "salt_dirt_lite");
            salt_dirt = new BlockSaltDirt("salt_dirt", tab);
            GameRegistry.registerBlock(salt_dirt, ItemSaltDirt.class, "salt_dirt");
            grass_top = new BlockGrassTop("grass_top", null);
            GameRegistry.registerBlock(grass_top, "grass_top");
        }
        if(ModConfiguration.enableMineralMud) {
            mineral_mud = new BlockMineralMud("mineral_mud", tab);
            GameRegistry.registerBlock(mineral_mud, "mineral_mud");
            if (ModConfiguration.enableMudBricks) {
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
                if (Loader.isModLoaded("etfuturum") && ModConfiguration.enableMudBrickWall) {
                    dry_mud_brick_wall = new BlockDryMudBrickWall(ModBlocks.dry_mud_brick, tab);
                    GameRegistry.registerBlock(dry_mud_brick_wall, "dry_mud_brick_wall");
                }
            }
        }
        if(ModConfiguration.enableSaltMarsh) {
            salt_crusted_oak_log = new BlockSaltCrustedOakLog("salt_crusted_oak_log", tab);
            GameRegistry.registerBlock(salt_crusted_oak_log, "salt_crusted_oak_log");
        }
        if(ModConfiguration.enableEvaporator) {
            evaporator = new BlockEvaporator(false, false, "evaporator", tab);
            GameRegistry.registerBlock(evaporator, "evaporator");
            lit_evaporator = new BlockEvaporator(true, false, "evaporator", null);
            GameRegistry.registerBlock(lit_evaporator, "lit_evaporator").setLightLevel(0.9F);
            steam_evaporator = new BlockEvaporator(true, true, "evaporator", null);
            GameRegistry.registerBlock(steam_evaporator, "steam_evaporator").setLightLevel(0.9F);
        }
        if(ModConfiguration.enableFishFarm) {
            fish_farm = new BlockFishFarm("fish_farm", tab);
            GameRegistry.registerBlock(fish_farm, "fish_farm");
        }
        if(ModConfiguration.enableApiary) {
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
        if(ModConfiguration.enableStorageBlocks) {
            storage_crate = new BlockStorageCrate("storage_crate", tab);
            GameRegistry.registerBlock(storage_crate, ItemStorageCrate.class, "storage_crate");
            storage_barrel = new BlockStorageBarrel("storage_barrel", tab);
            GameRegistry.registerBlock(storage_barrel, ItemStorageBarrel.class, "storage_barrel");
            storage_sack = new BlockStorageSack("storage_sack", tab);
            GameRegistry.registerBlock(storage_sack, ItemStorageSack.class, "storage_sack");
        }
        if(ModConfiguration.enableSaltCrystal) {
            salt_crystal = new BlockSaltCrystal("salt_crystal", tab);
            GameRegistry.registerBlock(salt_crystal, "salt_crystal");
        }
        saltworts = new BlockSaltworts("saltworts", null);
        GameRegistry.registerBlock(saltworts, "saltworts");
        if(ModConfiguration.enableOnion) {
            onions = new BlockOnions("onions", null);
            GameRegistry.registerBlock(onions, "onions");
        }
        if(ModConfiguration.enableSaltFlowers) {
            salt_flower = new BlockSaltFlower();
            GameRegistry.registerBlock(salt_flower, ItemSaltFlower.class, "salt_flower");
        }

        SaltyMod.logger.info("Finished initializing SaltyMod Blocks");
    }
}
