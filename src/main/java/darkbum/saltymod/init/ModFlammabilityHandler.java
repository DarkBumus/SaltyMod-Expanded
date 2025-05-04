package darkbum.saltymod.init;

import net.minecraft.block.BlockFire;
import net.minecraft.init.Blocks;

public class ModFlammabilityHandler {

    public static void init() {
        BlockFire fire = Blocks.fire;

        fire.setFireInfo(ModBlocks.salt_crusted_oak_log, 5, 20);
        fire.setFireInfo(ModBlocks.fish_farm, 5, 20);
        fire.setFireInfo(ModBlocks.bee_nest_temperate, 10, 40);
        fire.setFireInfo(ModBlocks.bee_nest_boreal, 10, 40);
        fire.setFireInfo(ModBlocks.bee_burrow_spruce, 5, 20);
        fire.setFireInfo(ModBlocks.bee_burrow_birch, 5, 20);
        fire.setFireInfo(ModBlocks.bee_burrow_spruce_stripped, 5, 20);
        fire.setFireInfo(ModBlocks.bee_burrow_birch_stripped, 5, 20);
        fire.setFireInfo(ModBlocks.apiary, 5, 20);
        fire.setFireInfo(ModBlocks.press, 5, 20);
        fire.setFireInfo(ModBlocks.mill, 5, 20);
        fire.setFireInfo(ModBlocks.storage_crate, 5, 20);
        fire.setFireInfo(ModBlocks.storage_barrel, 5, 20);
        fire.setFireInfo(ModBlocks.storage_sack, 30, 60);
        fire.setFireInfo(ModBlocks.salt_flower, 60, 100);
        fire.setFireInfo(ModBlocks.marsh_reeds_t, 60, 100);
    }
}
