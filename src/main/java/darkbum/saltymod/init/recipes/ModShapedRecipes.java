package darkbum.saltymod.init.recipes;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.common.config.*;
import darkbum.saltymod.util.ConditionalRegistrar;
import darkbum.saltymod.init.ModExternalItemLoader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ModShapedRecipes {

    public static void init() {

        Item beetroot = ModExternalItemLoader.etFuturumItems.get("beetroot");
        Item beetroot_seeds = ModExternalItemLoader.etFuturumItems.get("beetroot_seeds");
        Item sweet_berries = ModExternalItemLoader.etFuturumItems.get("sweet_berries");
        Block honeycomb_block = ModExternalItemLoader.etFuturumBlocks.get("honeycomb_block");
        Block beehive = ModExternalItemLoader.etFuturumBlocks.get("beehive");

        Block campfire = ModExternalItemLoader.campfireBackportBlocks.get("campfire");


        ConditionalRegistrar.addShapedRecipe(new ItemStack(Items.sugar),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModItems.sugar_pinch)});

        ConditionalRegistrar.addShapedRecipe(new ItemStack(Items.cake),
            new Object[]{" x ", "yzy", " a ",
                'x', new ItemStack(Items.milk_bucket),
                'y', new ItemStack(Items.sugar),
                'z', new ItemStack(Items.egg),
                'a', new ItemStack(ModItems.dough)},
            ModConfigurationVanillaChanges.enableRecipeChanges, ModConfigurationItems.enableDough);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(honeycomb_block),
            new Object[]{"xx", "xx",
                'x', new ItemStack(ModItems.waxcomb)},
            honeycomb_block != null, ModConfigurationModCompatibility.enableEFRHoneyCompatibility);
        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(beehive),
            new Object[]{"xxx", "yyy", "xxx",
                'x', "plankWood",
                'y', new ItemStack(ModItems.waxcomb)},
            beehive != null, ModConfigurationModCompatibility.enableEFRHoneyCompatibility);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModItems.salt)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block, 4, 5),
            new Object[]{"xx", "xx",
                'x', new ItemStack(ModBlocks.salt_block, 1, 0)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block, 2, 2),
            new Object[]{"x", "x",
                'x', new ItemStack(ModBlocks.salt_block, 1, 0)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block, 1, 1),
            new Object[]{"x", "x",
                'x', new ItemStack(ModBlocks.salt_slab, 1, 0)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block, 1, 8),
            new Object[]{"x", "x",
                'x', new ItemStack(ModBlocks.salt_slab, 1, 1)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block, 1, 9),
            new Object[]{"x", "x",
                'x', new ItemStack(ModBlocks.salt_slab, 1, 2)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_block, 6),
            new Object[]{"x  ", "xx ", "xxx",
                'x', new ItemStack(ModBlocks.salt_block, 1, 5)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_slab, 6, 0),
            new Object[]{"xxx",
                'x', new ItemStack(ModBlocks.salt_block, 1, 0)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_slab, 6, 1),
            new Object[]{"xxx",
                'x', new ItemStack(ModBlocks.salt_block, 1, 5)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_slab, 6, 2),
            new Object[]{"xxx",
                'x', new ItemStack(ModBlocks.salt_block, 1, 2)},
            ModConfigurationBlocks.enableSaltBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.salt_lamp),
            new Object[]{"x", "y",
                'x', new ItemStack(ModBlocks.salt_block, 1, 0),
                'y', new ItemStack(Blocks.torch)},
            ModConfigurationBlocks.enableSaltBlocks);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.reeds_block),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModBlocks.marsh_reeds_b)},
            ModConfigurationWorldGeneration.enableSaltMarsh);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.mineral_mud),
            new Object[]{"xx", "xx",
                'x', new ItemStack(ModItems.mineral_mud_ball)},
            ModConfigurationItems.enableMineralMud);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.wet_mud_brick, 2),
            new Object[]{"xy", "yx",
                'x', new ItemStack(ModBlocks.mineral_mud),
                'y', new ItemStack(Items.wheat)},
            ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.dry_mud_brick_stairs, 4),
            new Object[]{"x  ", "xx ", "xxx",
                'x', new ItemStack(ModBlocks.dry_mud_brick)},
            ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.dry_mud_brick_slab, 6),
            new Object[]{"xxx",
                'x', new ItemStack(ModBlocks.dry_mud_brick)},
            ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.dry_mud_brick_wall, 6),
            new Object[]{"xxx", "xxx",
                'x', new ItemStack(ModBlocks.dry_mud_brick)},
            ModConfigurationItems.enableMineralMud, ModConfigurationBlocks.enableMudBricks);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.evaporator),
            new Object[]{"xyx", "x x", "xxx",
                'x', new ItemStack(Blocks.cobblestone),
                'y', new ItemStack(Items.cauldron)},
            ModConfigurationBlocks.enableEvaporator);

        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(ModBlocks.fish_farm),
            new Object[]{"xxx", "yzy", "xax",
                'x', "plankWood",
                'y', new ItemStack(Items.stick),
                'z', new ItemStack(Items.fishing_rod),
                'a', new ItemStack(Blocks.chest)},
            ModConfigurationBlocks.enableFishFarm);

        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(ModBlocks.apiary),
            new Object[]{"xxx", "yyy", "xzx",
                'x', "plankWood",
                'y', new ItemStack(Items.item_frame),
                'z', new ItemStack(Blocks.chest)},
            ModConfigurationBlocks.enableApiary);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.stove),
            new Object[]{"xxx", "y y", "yzy",
                'x', new ItemStack(Items.iron_ingot),
                'y', new ItemStack(Blocks.brick_block),
                'z', new ItemStack(campfire)},
            ModConfigurationBlocks.enableMachines, Loader.isModLoaded("campfirebackport"));
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.stove),
            new Object[]{"xxx", "y y", "yzy",
                'x', new ItemStack(Items.iron_ingot),
                'y', new ItemStack(Blocks.brick_block),
                'z', new ItemStack(Blocks.furnace)},
            ModConfigurationBlocks.enableMachines, !Loader.isModLoaded("campfirebackport"));

        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(ModBlocks.press),
            new Object[]{"xyx", "z z", "xxx",
                'x', "plankWood",
                'y', new ItemStack(Blocks.hopper),
                'z', new ItemStack(Blocks.piston)},
            ModConfigurationBlocks.enableMachines);

        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(ModBlocks.mill),
            new Object[]{"xxx", "yzz", "xxx",
                'x', "plankWood",
                'y', new ItemStack(Blocks.piston),
                'z', new ItemStack(Items.redstone)},
            ModConfigurationBlocks.enableMachines);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.cooking_pot),
            new Object[]{"xyx", "zaz", "zzz",
                'x', new ItemStack(Items.brick),
                'y', new ItemStack(Items.wooden_shovel, 1, OreDictionary.WILDCARD_VALUE),
                'z', new ItemStack(Items.iron_ingot),
                'a', new ItemStack(Items.water_bucket)},
            ModConfigurationBlocks.enableMachines);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.clay_oven),
            new Object[]{"xxx", "x x", "xyx",
                'x', new ItemStack(Items.brick),
                'y', new ItemStack(Blocks.stone_slab, 1, 0)},
            ModConfigurationBlocks.enableMachines);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_crate),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.carrot)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_crate, 1, 1),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.potato)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_crate, 1, 2),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.poisonous_potato)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_crate, 1, 3),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModItems.onion)},
            ModConfigurationBlocks.enableStorageBlocks, ModConfigurationItems.enableOnion);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_crate, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', beetroot},
            beetroot != null, ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_barrel),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.fish)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_barrel, 1, 1),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.fish, 1, 1)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_barrel, 1, 2),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.fish, 1, 2)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_barrel, 1, 3),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModItems.tailor)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_barrel, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.fish, 1, 3)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_sack),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.wheat_seeds)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_sack, 1, 1),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.melon_seeds)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_sack, 1, 2),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(Items.pumpkin_seeds)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_sack, 1, 3),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModItems.saltwort)},
            ModConfigurationBlocks.enableStorageBlocks);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.storage_sack, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', beetroot_seeds},
            beetroot_seeds != null, ModConfigurationBlocks.enableStorageBlocks);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModBlocks.marsh_reeds_b, 9),
            new Object[]{"x",
                'x', new ItemStack(ModBlocks.reeds_block)},
            ModConfigurationWorldGeneration.enableSaltMarsh);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.salt),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(ModItems.salt_pinch)});

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.golden_saltwort),
            new Object[]{"xxx", "xyx", "xxx",
                'x', new ItemStack(Items.gold_nugget),
                'y', new ItemStack(ModItems.saltwort)});
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.golden_potato),
            new Object[]{"xxx", "xyx", "xxx",
                'x', new ItemStack(Items.gold_nugget),
                'y', new ItemStack(Items.potato)});
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.golden_berries),
            new Object[]{"xxx", "xyx", "xxx",
                'x', Items.gold_nugget,
                'y', sweet_berries},
            sweet_berries != null);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.golden_berries, 1, 1),
            new Object[]{"xxx", "xyx", "xxx",
                'x', Blocks.gold_block,
                'y', sweet_berries},
            sweet_berries != null);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.cured_meat),
            new Object[]{"xxx", "xyx", "xxx",
                'x', new ItemStack(ModItems.salt_pinch),
                'y', new ItemStack(Items.rotten_flesh)});

        ConditionalRegistrar.addShapedOreRecipe(new ItemStack(ModItems.chocolate_bar),
            new Object[]{"xyx",
                'x', new ItemStack(Items.dye, 1, 3),
                'y', "itemMilk"},
            ModConfigurationBlocks.enableEvaporator);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.chocolate_bar),
            new Object[]{"xyx",
                'x', new ItemStack(Items.dye, 1, 3),
                'y', new ItemStack(Items.milk_bucket)},
            !ModConfigurationBlocks.enableEvaporator);

        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.mud_helmet),
            new Object[]{"xxx", "x x",
                'x', ModItems.mineral_mud_ball},
            ModConfigurationItems.enableMineralMud, ModConfigurationItems.enableMudArmor);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.mud_chestplate),
            new Object[]{"x x", "xxx", "xxx",
                'x', ModItems.mineral_mud_ball},
            ModConfigurationItems.enableMineralMud, ModConfigurationItems.enableMudArmor);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.mud_leggings),
            new Object[]{"xxx", "x x", "x x",
                'x', ModItems.mineral_mud_ball},
            ModConfigurationItems.enableMineralMud, ModConfigurationItems.enableMudArmor);
        ConditionalRegistrar.addShapedRecipe(new ItemStack(ModItems.mud_boots),
            new Object[]{"x x", "x x",
                'x', ModItems.mineral_mud_ball},
            ModConfigurationItems.enableMineralMud, ModConfigurationItems.enableMudArmor);
    }
}
