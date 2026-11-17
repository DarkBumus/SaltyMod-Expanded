package darkbum.saltymod.init.recipes;

import darkbum.saltymod.tileentity.TileEntityPress;
import darkbum.saltymod.util.PotcookingRecipe;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.init.ModExternalLoader.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;
import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.PressingRecipe.ore;
import static darkbum.saltymod.util.PressingRecipe.stack;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraftforge.oredict.OreDictionary.*;

/**
 * Recipe class for {@link TileEntityPress}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModPressRecipes {

    /**
     * Initializes all custom press recipes.
     * <p>
     * Recipe definition:
     * OvenbakingRecipe.baking().registerRecipe(OUTPUT(ItemStack), HEATER?(boolean), XPCHANCE(float), INPUTS(ItemStack));
     * If you want to use this in your own mod, you need to import the static methods for stack and ore ingredients from {@link PotcookingRecipe}.
     * NOTE:    The requiresHeater boolean intentionally functions in a way where setting the value to "false" will require the heater to NOT
     * be present for the recipe to function.
     */
    public static void init() {

        Block efrstone = etFuturumBlocks.get("efrstone");
        Block prismarine_block = etFuturumBlocks.get("prismarine_block");
        Block red_sandstone = etFuturumBlocks.get("red_sandstone");
        Block end_bricks = etFuturumBlocks.get("end_bricks");
        Block nether_gold_ore = etFuturumBlocks.get("nether_gold_ore");
        Block smooth_red_sandstone = etFuturumBlocks.get("smooth_red_sandstone");
        Block smooth_stone = etFuturumBlocks.get("smooth_stone");
        Block concrete = etFuturumBlocks.get("concrete");
        Block concrete_powder = etFuturumBlocks.get("concrete_powder");
        Block copper_ore = etFuturumBlocks.get("copper_ore");
        Block deepslate_copper_ore = etFuturumBlocks.get("deepslate_copper_ore");
        Block deepslate = etFuturumBlocks.get("deepslate");
        Block cobbled_deepslate = etFuturumBlocks.get("cobbled_deepslate");
        Block polished_deepslate = etFuturumBlocks.get("polished_deepslate");
        Block deepslate_bricks = etFuturumBlocks.get("deepslate_bricks");
        Block tuff = etFuturumBlocks.get("tuff");
        Block basalt = etFuturumBlocks.get("basalt");
        Block deepslate_coal_ore = etFuturumBlocks.get("deepslate_coal_ore");
        Block deepslate_iron_ore = etFuturumBlocks.get("deepslate_iron_ore");
        Block deepslate_gold_ore = etFuturumBlocks.get("deepslate_gold_ore");
        Block deepslate_redstone_ore = etFuturumBlocks.get("deepslate_redstone_ore");
        Block deepslate_lapis_ore = etFuturumBlocks.get("deepslate_lapis_ore");
        Block deepslate_diamond_ore = etFuturumBlocks.get("deepslate_diamond_ore");
        Block deepslate_emerald_ore = etFuturumBlocks.get("deepslate_emerald_ore");
        Block blackstone = etFuturumBlocks.get("blackstone");
        Block gilded_blackstone = etFuturumBlocks.get("gilded_blackstone");

        Item raw_ore = etFuturumItems.get("raw_ore");
        Item honey_bottle = etFuturumItems.get("honey_bottle");

        addPressRecipe(stack(new ItemStack(stone)),
            new ItemStack(cobblestone),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(cobblestone)),
            new ItemStack(gravel),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(gravel)),
            new ItemStack(sand, 1, 0),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(gravel)),
            new ItemStack(sand, 1, 1),
            null,
            false,
            true,
            new ItemStack(dye, 1, 1));

        addPressRecipe(stack(new ItemStack(gold_ore)),
            new boolean[]{raw_ore != null},
            new ItemStack(cobblestone),
            new ItemStack(raw_ore, 1, 2),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(iron_ore)),
            new boolean[]{raw_ore != null},
            new ItemStack(cobblestone),
            new ItemStack(raw_ore, 1, 1),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(iron_ore)),
            new ItemStack(cobblestone),
            new ItemStack(coal, 1, 0),
            false,
            true,
            null);

        addPressRecipe(ore("blockGlass"),
            new ItemStack(sand, 1, 0),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(lapis_ore)),
            new ItemStack(cobblestone),
            new ItemStack(dye, 3, 4),
            false,
            true,
            null);

        addPressRecipe(ore("blockSandstone"),
            new ItemStack(sand, 1, 0),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(brick_block)),
            new ItemStack(bucket),
            new ItemStack(clay, 1, 0),
            false,
            true,
            new ItemStack(water_bucket));
        addPressRecipe(stack(new ItemStack(mossy_cobblestone)),
            new ItemStack(gravel),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(diamond_ore)),
            new ItemStack(cobblestone),
            new ItemStack(diamond),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(redstone_ore)),
            new ItemStack(cobblestone),
            new ItemStack(redstone, 3, 0),
            false,
            true,
            null);

        addPressRecipe(ore("blockIce"),
            new ItemStack(snow),
            null,
            false,
            true,
            null);
        addPressRecipe(ore("blockIce"),
            new ItemStack(water_bucket),
            null,
            true,
            false,
            new ItemStack(bucket));
        addPressRecipe(stack(new ItemStack(glowstone)),
            new ItemStack(glowstone_dust, 2, 0),
            null,
            false,
            true,
            null);

        addPressRecipe(ore("blockStoneBrick"),
            new ItemStack(cobblestone),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(emerald_ore)),
            new ItemStack(cobblestone),
            new ItemStack(emerald),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(quartz_ore)),
            new ItemStack(netherrack),
            new ItemStack(quartz),
            false,
            true,
            null);

        addPressRecipe(ore("blockQuartz"),
            new ItemStack(netherrack),
            new ItemStack(quartz, 4, 0),
            false,
            true,
            null);
        addPressRecipe(ore("blockTerracotta"),
            new ItemStack(bucket),
            new ItemStack(clay, 1, 0),
            false,
            true,
            new ItemStack(water_bucket));

        addPressRecipe(ore("blockSkeletonSkull"),
            new ItemStack(dye, 3, 15),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(Items.skull, 1, 2)),
            new ItemStack(dye, 3, 15),
            new ItemStack(rotten_flesh),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(Items.skull, 1, 4)),
            new ItemStack(dye, 3, 15),
            new ItemStack(gunpowder),
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(bone)),
            new ItemStack(dye, 3, 15),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(brick)),
            new ItemStack(glass_bottle),
            new ItemStack(clay_ball),
            false,
            true,
            new ItemStack(potionitem, 1, 0));

        addPressRecipe(stack(new ItemStack(efrstone, 1, 2)),
            new boolean[]{efrstone != null},
            new ItemStack(efrstone, 1, 1),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(efrstone, 1, 4)),
            new boolean[]{efrstone != null},
            new ItemStack(efrstone, 1, 3),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(efrstone, 1, 6)),
            new boolean[]{efrstone != null},
            new ItemStack(efrstone, 1, 5),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(prismarine_block, 1, 1)),
            new boolean[]{prismarine_block != null},
            new ItemStack(prismarine_block, 1, 0),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(prismarine_block, 1, 2)),
            new boolean[]{prismarine_block != null},
            new ItemStack(prismarine_block, 1, 0),
            null,
            false,
            true,
            null);

        addPressRecipe(ore("blockSandstoneRed"),
            new boolean[]{red_sandstone != null, smooth_red_sandstone != null},
            new ItemStack(sand, 1, 1),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(end_bricks)),
            new boolean[]{end_bricks != null},
            new ItemStack(end_stone),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(nether_gold_ore)),
            new boolean[]{nether_gold_ore != null},
            new ItemStack(netherrack),
            new ItemStack(gold_nugget, 3, 0),
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(smooth_stone)),
            new boolean[]{smooth_stone != null},
            new ItemStack(cobblestone),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(concrete, 1, WILDCARD_VALUE)),
            new boolean[]{concrete != null, concrete_powder != null},
            new ItemStack(concrete_powder),
            null,
            false,
            true,
            null,
            true);

        addPressRecipe(stack(new ItemStack(copper_ore)),
            new boolean[]{copper_ore != null},
            new ItemStack(cobblestone),
            new ItemStack(raw_ore, 3, 0),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_copper_ore)),
            new boolean[]{deepslate_copper_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(raw_ore, 3, 0),
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(deepslate)),
            new boolean[]{deepslate != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(polished_deepslate)),
            new boolean[]{polished_deepslate != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_bricks, 1, WILDCARD_VALUE)),
            new boolean[]{deepslate_bricks != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            null,
            false,
            true,
            null);
        addPressRecipe(ore("blockTuffRefined"),
            new boolean[]{tuff != null},
            new ItemStack(tuff, 1 ,0),
            null,
            false,
            true,
            null);
        addPressRecipe(ore("blockBasaltRefined"),
            new boolean[]{basalt != null},
            new ItemStack(basalt, 1 ,0),
            null,
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(deepslate_coal_ore)),
            new boolean[]{deepslate_coal_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(coal, 1, 0),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_iron_ore)),
            new boolean[]{deepslate_iron_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(raw_ore, 1, 1),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_gold_ore)),
            new boolean[]{deepslate_gold_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(raw_ore, 1, 2),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_redstone_ore)),
            new boolean[]{deepslate_redstone_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(redstone, 3, 0),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_lapis_ore)),
            new boolean[]{deepslate_lapis_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(dye, 3, 4),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_diamond_ore)),
            new boolean[]{deepslate_diamond_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(diamond),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_emerald_ore)),
            new boolean[]{deepslate_emerald_ore != null, cobbled_deepslate != null},
            new ItemStack(cobbled_deepslate),
            new ItemStack(emerald),
            false,
            true,
            null);

        addPressRecipe(ore("blockBlackstoneRefined"),
            new boolean[]{blackstone != null},
            new ItemStack(blackstone, 1 ,0),
            null,
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(gilded_blackstone)),
            new boolean[]{blackstone != null},
            new ItemStack(blackstone, 1 ,0),
            new ItemStack(gold_nugget, 3, 0),
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(honeycomb)),
            new boolean[]{enableHoney, honey_bottle != null},
            new ItemStack(honey_bottle),
            new ItemStack(waxcomb),
            false,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(stack(new ItemStack(frozen_honey)),
            new boolean[]{enableHoney, honey_bottle != null},
            new ItemStack(honey_bottle),
            null,
            true,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(stack(new ItemStack(honeycomb)),
            new boolean[]{enableHoney, honey_bottle == null},
            new ItemStack(royal_jelly),
            new ItemStack(waxcomb),
            false,
            false,
            new ItemStack(glass_bottle));
        addPressRecipe(stack(new ItemStack(frozen_honey)),
            new boolean[]{enableHoney, honey_bottle == null},
            new ItemStack(royal_jelly),
            null,
            true,
            false,
            new ItemStack(glass_bottle));

        addPressRecipe(stack(new ItemStack(sheep_horn)),
            new boolean[]{enableHornedSheep},
            new ItemStack(tunneler_concoction),
            null,
            true,
            true,
            new ItemStack(fizzy_drink));

        addPressRecipe(stack(new ItemStack(salt_ore)),
            new ItemStack(cobblestone),
            new ItemStack(salt),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(deepslate_salt_ore)),
            new ItemStack(cobbled_deepslate),
            new ItemStack(salt),
            false,
            true,
            null);
        addPressRecipe(stack(new ItemStack(salt_lake)),
            new ItemStack(cobblestone),
            new ItemStack(salt),
            false,
            true,
            null);

        addPressRecipe(stack(new ItemStack(dry_mud_brick)),
            new ItemStack(bucket),
            new ItemStack(wet_mud_brick, 1, 0),
            false,
            true,
            new ItemStack(water_bucket));
    }
}
