package darkbum.saltymod.init.recipes;

import darkbum.saltymod.configuration.configs.ModConfigurationVanillaChanges;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ModShapedRecipes {

    public static void init() {

        GameRegistry.addRecipe(new ItemStack(Items.sugar), "xxx", "xxx", "xxx", 'x', ModItems.sugar_pinch);
        if (ModConfigurationVanillaChanges.enableRecipeChanges) {
            if (ModConfigurationItems.enableDough) {
                GameRegistry.addRecipe(
                    new ItemStack(Items.cake),
                    " x ",
                    "yzy",
                    " a ",
                    'x',
                    Items.milk_bucket,
                    'y',
                    Items.sugar,
                    'z',
                    Items.egg,
                    'a',
                    ModItems.dough);
            }
        }

        if (ModConfigurationBlocks.enableSaltBlocks) {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.salt_block), "xxx", "xxx", "xxx", 'x', ModItems.salt);
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_block, 4, 5),
                "xx",
                "xx",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 0));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_block, 2, 2),
                "x",
                "x",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 0));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_block, 1, 1),
                "x",
                "x",
                'x',
                new ItemStack(ModBlocks.salt_slab, 1, 0));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_block, 1, 8),
                "x",
                "x",
                'x',
                new ItemStack(ModBlocks.salt_slab, 1, 1));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_block, 1, 9),
                "x",
                "x",
                'x',
                new ItemStack(ModBlocks.salt_slab, 1, 2));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_brick_stairs, 6),
                "x  ",
                "xx ",
                "xxx",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 5));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_slab, 6, 0),
                "xxx",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 0));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_slab, 6, 1),
                "xxx",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 5));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_slab, 6, 2),
                "xxx",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 2));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.salt_lamp),
                "x",
                "y",
                'x',
                new ItemStack(ModBlocks.salt_block, 1, 0),
                'y',
                new ItemStack(Blocks.torch));
        }
        if (ModConfigurationItems.enableMineralMud) {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.mineral_mud), "xx", "xx", 'x', ModItems.mineral_mud_ball);
        }
        if (ModConfigurationItems.enableMineralMud && ModConfigurationBlocks.enableMudBricks) {
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.wet_mud_brick, 2),
                "xy",
                "yx",
                'x',
                ModBlocks.mineral_mud,
                'y',
                new ItemStack(Items.wheat));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.dry_mud_brick_stairs, 4),
                "x  ",
                "xx ",
                "xxx",
                'x',
                new ItemStack(ModBlocks.dry_mud_brick));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.dry_mud_brick_slab, 6),
                "xxx",
                'x',
                new ItemStack(ModBlocks.dry_mud_brick));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.dry_mud_brick_wall, 6),
                "xxx",
                "xxx",
                'x',
                new ItemStack(ModBlocks.dry_mud_brick));
        }
        if (ModConfigurationBlocks.enableEvaporator) {
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.evaporator),
                "xyx",
                "x x",
                "xxx",
                'x',
                Blocks.cobblestone,
                'y',
                Items.cauldron);
        }
        if (ModConfigurationBlocks.enableFishFarm) {
            GameRegistry.addRecipe(
                new ShapedOreRecipe(
                    new ItemStack(ModBlocks.fish_farm),
                    "xxx",
                    "yzy",
                    "xax",
                    'x',
                    "plankWood",
                    'y',
                    Items.stick,
                    'z',
                    Items.fishing_rod,
                    'a',
                    Blocks.chest));
        }
        if (ModConfigurationItems.enableHoney) {
            GameRegistry.addRecipe(
                new ShapedOreRecipe(
                    new ItemStack(ModBlocks.apiary),
                    "xxx",
                    "yyy",
                    "xzx",
                    'x',
                    "plankWood",
                    'y',
                    Items.item_frame,
                    'z',
                    Blocks.chest));
        }
        if (ModConfigurationBlocks.enableStorageBlocks) {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.storage_crate), "xxx", "xxx", "xxx", 'x', Items.carrot);
            GameRegistry
                .addRecipe(new ItemStack(ModBlocks.storage_crate, 1, 1), "xxx", "xxx", "xxx", 'x', Items.potato);
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.storage_crate, 1, 2),
                "xxx",
                "xxx",
                "xxx",
                'x',
                Items.poisonous_potato);
            if (ModConfigurationItems.enableOnion) {
                GameRegistry.addRecipe(
                    new ItemStack(ModBlocks.storage_crate, 1, 3),
                    "xxx",
                    "xxx",
                    "xxx",
                    'x',
                    new ItemStack(ModItems.onion));
            }
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.storage_barrel),
                "xxx",
                "xxx",
                "xxx",
                'x',
                new ItemStack(Items.fish));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.storage_barrel, 1, 1),
                "xxx",
                "xxx",
                "xxx",
                'x',
                new ItemStack(Items.fish, 1, 1));
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.storage_barrel, 1, 2),
                "xxx",
                "xxx",
                "xxx",
                'x',
                new ItemStack(Items.fish, 1, 2));
            if (ModConfigurationItems.enableTailor) {
                GameRegistry.addRecipe(
                    new ItemStack(ModBlocks.storage_barrel, 1, 3),
                    "xxx",
                    "xxx",
                    "xxx",
                    'x',
                    new ItemStack(ModItems.tailor));
            }
            GameRegistry.addRecipe(
                new ItemStack(ModBlocks.storage_barrel, 1, 4),
                "xxx",
                "xxx",
                "xxx",
                'x',
                new ItemStack(Items.fish, 1, 3));
            GameRegistry.addRecipe(new ItemStack(ModBlocks.storage_sack), "xxx", "xxx", "xxx", 'x', Items.wheat_seeds);
            GameRegistry
                .addRecipe(new ItemStack(ModBlocks.storage_sack, 1, 1), "xxx", "xxx", "xxx", 'x', Items.melon_seeds);
            GameRegistry
                .addRecipe(new ItemStack(ModBlocks.storage_sack, 1, 2), "xxx", "xxx", "xxx", 'x', Items.pumpkin_seeds);
            GameRegistry
                .addRecipe(new ItemStack(ModBlocks.storage_sack, 1, 3), "xxx", "xxx", "xxx", 'x', ModItems.saltwort);
        }

        GameRegistry.addRecipe(new ItemStack(ModItems.salt), "xxx", "xxx", "xxx", 'x', ModItems.salt_pinch);
        GameRegistry.addRecipe(
            new ItemStack(ModItems.golden_saltwort),
            "xxx",
            "xyx",
            "xxx",
            'x',
            Items.gold_nugget,
            'y',
            ModItems.saltwort);
        GameRegistry.addRecipe(
            new ItemStack(ModItems.golden_potato),
            "xxx",
            "xyx",
            "xxx",
            'x',
            Items.gold_nugget,
            'y',
            Items.potato);
        GameRegistry.addRecipe(
            new ItemStack(ModItems.cured_meat),
            "xxx",
            "xyx",
            "xxx",
            'x',
            ModItems.salt_pinch,
            'y',
            Items.rotten_flesh);
        if (ModConfigurationBlocks.enableEvaporator) {
            GameRegistry.addRecipe(
                new ItemStack(ModItems.chocolate_bar),
                "xyx",
                'x',
                new ItemStack(Items.dye, 1, 3),
                'y',
                ModItems.powdered_milk);
        } else {
            GameRegistry.addRecipe(
                new ItemStack(ModItems.chocolate_bar),
                "xyx",
                'x',
                new ItemStack(Items.dye, 1, 3),
                'y',
                Items.milk_bucket);
        }
        if (ModConfigurationItems.enableMineralMud && ModConfigurationItems.enableMudArmor) {
            GameRegistry.addRecipe(new ItemStack(ModItems.mud_helmet), "xxx", "x x", 'x', ModItems.mineral_mud_ball);
            GameRegistry
                .addRecipe(new ItemStack(ModItems.mud_chestplate), "x x", "xxx", "xxx", 'x', ModItems.mineral_mud_ball);
            GameRegistry
                .addRecipe(new ItemStack(ModItems.mud_leggings), "xxx", "x x", "x x", 'x', ModItems.mineral_mud_ball);
            GameRegistry.addRecipe(new ItemStack(ModItems.mud_boots), "x x", "x x", 'x', ModItems.mineral_mud_ball);
        }
    }
}
