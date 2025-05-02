package darkbum.saltymod.init;

import net.minecraft.block.BlockFire;
import net.minecraft.init.Blocks;

public class ModFlammabilityHandler {

    public static void init() {
        BlockFire fire = Blocks.fire;

        fire.setFireInfo(ModBlocks.bee_nest_temperate, 10, 40);
        fire.setFireInfo(ModBlocks.bee_nest_boreal, 10, 40);
        fire.setFireInfo(ModBlocks.bee_burrow_spruce, 5, 20);
        fire.setFireInfo(ModBlocks.bee_burrow_birch, 5, 20);
        fire.setFireInfo(ModBlocks.bee_burrow_spruce_stripped, 5, 20);
        fire.setFireInfo(ModBlocks.bee_burrow_birch_stripped, 5, 20);
    }
}
