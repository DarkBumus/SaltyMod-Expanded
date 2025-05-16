package darkbum.saltymod.init;

import net.minecraft.block.BlockFire;
import net.minecraft.init.Blocks;

/**
 * Flammability Handler class.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModFlammabilityHandler {

    /**
     * Initializes all flammability values.
     */
    public static void init() {
        BlockFire fire = Blocks.fire;

        fire.setFireInfo(ModBlocks.salt_crusted_oak_log, 5, 5);
        fire.setFireInfo(ModBlocks.fish_farm, 5, 20);
        fire.setFireInfo(ModBlocks.bee_nest_temperate, 10, 40);
        fire.setFireInfo(ModBlocks.bee_nest_boreal, 10, 40);
        fire.setFireInfo(ModBlocks.bee_burrow_spruce, 10, 10);
        fire.setFireInfo(ModBlocks.bee_burrow_birch, 10, 10);
        fire.setFireInfo(ModBlocks.bee_burrow_spruce_stripped, 10, 10);
        fire.setFireInfo(ModBlocks.bee_burrow_birch_stripped, 10, 10);
        fire.setFireInfo(ModBlocks.apiary, 5, 20);
        fire.setFireInfo(ModBlocks.press, 5, 20);
        fire.setFireInfo(ModBlocks.mill, 5, 20);
        fire.setFireInfo(ModBlocks.storage_crate, 5, 20);
        fire.setFireInfo(ModBlocks.storage_barrel, 5, 20);
        fire.setFireInfo(ModBlocks.storage_sack, 30, 60);
        fire.setFireInfo(ModBlocks.onions, 60, 100);
        fire.setFireInfo(ModBlocks.saltworts, 60, 100);
        fire.setFireInfo(ModBlocks.salt_flower_d, 60, 100);
        fire.setFireInfo(ModBlocks.marsh_reeds_t, 60, 100);
    }
}
