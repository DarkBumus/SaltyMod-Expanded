package darkbum.saltymod.init.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static cpw.mods.fml.common.Loader.isModLoaded;
import static darkbum.saltymod.init.ModExternalItemLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static net.minecraftforge.oredict.OreDictionary.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.cake;
import static net.minecraft.init.Items.cauldron;
import static net.minecraft.init.Items.wheat;

/**
 * Recipe class for Shaped Recipes.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModShapedRecipes {

    /**
     * Initializes all shaped recipes.
     */
    public static void init() {

        Item beetroot = etFuturumItems.get("beetroot");
        Item beetroot_seeds = etFuturumItems.get("beetroot_seeds");
        Item sweet_berries = etFuturumItems.get("sweet_berries");
        Block honeycomb_block = etFuturumBlocks.get("honeycomb_block");
        Block beehive = etFuturumBlocks.get("beehive");

        Block campfire = campfireBackportBlocks.get("campfire");


        addShapedRecipe(new ItemStack(sugar),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(sugar_pinch)});

        addShapedRecipe(new ItemStack(cake),
            new Object[]{" x ", "yzy", " a ",
                'x', new ItemStack(milk_bucket),
                'y', new ItemStack(sugar),
                'z', new ItemStack(egg),
                'a', new ItemStack(dough)},
            enableRecipeChanges, enableDough);

        addShapedRecipe(new ItemStack(honeycomb_block),
            new Object[]{"xx", "xx",
                'x', new ItemStack(waxcomb)},
            honeycomb_block != null, enableEFRHoneyCompatibility);
        addShapedOreRecipe(new ItemStack(beehive),
            new Object[]{"xxx", "yyy", "xxx",
                'x', "plankWood",
                'y', new ItemStack(waxcomb)},
            beehive != null, enableEFRHoneyCompatibility);

        addShapedRecipe(new ItemStack(salt_block),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(salt)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_block, 4, 5),
            new Object[]{"xx", "xx",
                'x', new ItemStack(salt_block, 1, 0)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_block, 2, 2),
            new Object[]{"x", "x",
                'x', new ItemStack(salt_block, 1, 0)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_block, 1, 1),
            new Object[]{"x", "x",
                'x', new ItemStack(salt_slab, 1, 0)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_block, 1, 8),
            new Object[]{"x", "x",
                'x', new ItemStack(salt_slab, 1, 1)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_block, 1, 9),
            new Object[]{"x", "x",
                'x', new ItemStack(salt_slab, 1, 2)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_block, 6),
            new Object[]{"x  ", "xx ", "xxx",
                'x', new ItemStack(salt_block, 1, 5)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_slab, 6, 0),
            new Object[]{"xxx",
                'x', new ItemStack(salt_block, 1, 0)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_slab, 6, 1),
            new Object[]{"xxx",
                'x', new ItemStack(salt_block, 1, 5)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_slab, 6, 2),
            new Object[]{"xxx",
                'x', new ItemStack(salt_block, 1, 2)},
            enableSaltBlocks);
        addShapedRecipe(new ItemStack(salt_lamp),
            new Object[]{"x", "y",
                'x', new ItemStack(salt_block, 1, 0),
                'y', new ItemStack(torch)},
            enableSaltBlocks);

        addShapedRecipe(new ItemStack(reeds_block),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(marsh_reeds_b)},
            enableSaltMarsh);

        addShapedRecipe(new ItemStack(mineral_mud),
            new Object[]{"xx", "xx",
                'x', new ItemStack(mineral_mud_ball)},
            enableMineralMud);

        addShapedRecipe(new ItemStack(wet_mud_brick, 2),
            new Object[]{"xy", "yx",
                'x', new ItemStack(mineral_mud),
                'y', new ItemStack(wheat)},
            enableMineralMud, enableMudBricks);
        addShapedRecipe(new ItemStack(dry_mud_brick_stairs, 4),
            new Object[]{"x  ", "xx ", "xxx",
                'x', new ItemStack(dry_mud_brick)},
            enableMineralMud, enableMudBricks);
        addShapedRecipe(new ItemStack(dry_mud_brick_slab, 6),
            new Object[]{"xxx",
                'x', new ItemStack(dry_mud_brick)},
            enableMineralMud, enableMudBricks);
        addShapedRecipe(new ItemStack(dry_mud_brick_wall, 6),
            new Object[]{"xxx", "xxx",
                'x', new ItemStack(dry_mud_brick)},
            enableMineralMud, enableMudBricks);

        addShapedRecipe(new ItemStack(evaporator),
            new Object[]{"xyx", "x x", "xxx",
                'x', new ItemStack(cobblestone),
                'y', new ItemStack(cauldron)},
            enableEvaporator);

        addShapedOreRecipe(new ItemStack(fish_farm),
            new Object[]{"xxx", "yzy", "xax",
                'x', "plankWood",
                'y', new ItemStack(stick),
                'z', new ItemStack(fishing_rod),
                'a', new ItemStack(chest)},
            enableFishFarm);

        addShapedOreRecipe(new ItemStack(apiary),
            new Object[]{"xxx", "yyy", "xzx",
                'x', "plankWood",
                'y', new ItemStack(item_frame),
                'z', new ItemStack(chest)},
            enableApiary);

        addShapedRecipe(new ItemStack(stove),
            new Object[]{"xxx", "y y", "yzy",
                'x', new ItemStack(iron_ingot),
                'y', new ItemStack(brick_block),
                'z', new ItemStack(campfire)},
            enableMachines, isModLoaded("campfirebackport"));
        addShapedRecipe(new ItemStack(stove),
            new Object[]{"xxx", "y y", "yzy",
                'x', new ItemStack(iron_ingot),
                'y', new ItemStack(brick_block),
                'z', new ItemStack(furnace)},
            enableMachines, !isModLoaded("campfirebackport"));

        addShapedOreRecipe(new ItemStack(press),
            new Object[]{"xyx", "z z", "xxx",
                'x', "plankWood",
                'y', new ItemStack(hopper),
                'z', new ItemStack(piston)},
            enableMachines);

        addShapedOreRecipe(new ItemStack(mill),
            new Object[]{"xxx", "yzz", "xxx",
                'x', "plankWood",
                'y', new ItemStack(piston),
                'z', new ItemStack(redstone)},
            enableMachines);

        addShapedRecipe(new ItemStack(cooking_pot),
            new Object[]{"xyx", "zaz", "zzz",
                'x', new ItemStack(brick),
                'y', new ItemStack(wooden_shovel, 1, WILDCARD_VALUE),
                'z', new ItemStack(iron_ingot),
                'a', new ItemStack(water_bucket)},
            enableMachines);

        addShapedRecipe(new ItemStack(clay_oven),
            new Object[]{"xxx", "x x", "xyx",
                'x', new ItemStack(brick),
                'y', new ItemStack(stone_slab, 1, 0)},
            enableMachines);

        addShapedRecipe(new ItemStack(storage_crate),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(carrot)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_crate, 1, 1),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(potato)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_crate, 1, 2),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(poisonous_potato)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_crate, 1, 3),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(onion)},
            enableStorageBlocks, enableOnion);
        addShapedRecipe(new ItemStack(storage_crate, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', beetroot},
            beetroot != null, enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_barrel),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(fish)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_barrel, 1, 1),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(fish, 1, 1)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_barrel, 1, 2),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(fish, 1, 2)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_barrel, 1, 3),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(tailor)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_barrel, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(fish, 1, 3)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_sack),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(wheat_seeds)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_sack, 1, 1),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(melon_seeds)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_sack, 1, 2),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(pumpkin_seeds)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_sack, 1, 3),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(saltwort)},
            enableStorageBlocks);
        addShapedRecipe(new ItemStack(storage_sack, 1, 4),
            new Object[]{"xxx", "xxx", "xxx",
                'x', beetroot_seeds},
            beetroot_seeds != null, enableStorageBlocks);

        addShapedRecipe(new ItemStack(marsh_reeds_b, 9),
            new Object[]{"x",
                'x', new ItemStack(reeds_block)},
            enableSaltMarsh);

        addShapedRecipe(new ItemStack(salt),
            new Object[]{"xxx", "xxx", "xxx",
                'x', new ItemStack(salt_pinch)});

        addShapedRecipe(new ItemStack(golden_saltwort),
            new Object[]{"xxx", "xyx", "xxx",
                'x', new ItemStack(gold_nugget),
                'y', new ItemStack(saltwort)});
        addShapedRecipe(new ItemStack(golden_potato),
            new Object[]{"xxx", "xyx", "xxx",
                'x', new ItemStack(gold_nugget),
                'y', new ItemStack(potato)});
        addShapedRecipe(new ItemStack(golden_berries),
            new Object[]{"xxx", "xyx", "xxx",
                'x', gold_nugget,
                'y', sweet_berries},
            sweet_berries != null);
        addShapedRecipe(new ItemStack(golden_berries, 1, 1),
            new Object[]{"xxx", "xyx", "xxx",
                'x', gold_block,
                'y', sweet_berries},
            sweet_berries != null);

        addShapedRecipe(new ItemStack(cured_meat),
            new Object[]{"xxx", "xyx", "xxx",
                'x', new ItemStack(salt_pinch),
                'y', new ItemStack(rotten_flesh)});

        addShapedOreRecipe(new ItemStack(chocolate_bar),
            new Object[]{"xyx",
                'x', new ItemStack(dye, 1, 3),
                'y', "itemMilk"},
            enableEvaporator);
        addShapedRecipe(new ItemStack(chocolate_bar),
            new Object[]{"xyx",
                'x', new ItemStack(dye, 1, 3),
                'y', new ItemStack(milk_bucket)},
            !enableEvaporator);

        addShapedRecipe(new ItemStack(mud_helmet),
            new Object[]{"xxx", "x x",
                'x', mineral_mud_ball},
            enableMineralMud, enableMudArmor);
        addShapedRecipe(new ItemStack(mud_chestplate),
            new Object[]{"x x", "xxx", "xxx",
                'x', mineral_mud_ball},
            enableMineralMud, enableMudArmor);
        addShapedRecipe(new ItemStack(mud_leggings),
            new Object[]{"xxx", "x x", "x x",
                'x', mineral_mud_ball},
            enableMineralMud, enableMudArmor);
        addShapedRecipe(new ItemStack(mud_boots),
            new Object[]{"x x", "x x",
                'x', mineral_mud_ball},
            enableMineralMud, enableMudArmor);

        addShapedRecipe(new ItemStack(salt_pickaxe),
            new Object[]{"xxx", " y ", " y ",
            'x', salt_shard,
            'y', stick},
            enableSaltPickaxe);
    }
}
