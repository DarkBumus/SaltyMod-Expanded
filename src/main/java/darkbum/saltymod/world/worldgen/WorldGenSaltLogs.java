package darkbum.saltymod.world.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import darkbum.saltymod.init.ModBlocks;

public class WorldGenSaltLogs extends WorldGenAbstractTree {

    private final int minTreeHeight;

    public WorldGenSaltLogs(boolean doBlockNotify) {
        this(doBlockNotify, 4);
    }

    public WorldGenSaltLogs(boolean doBlockNotify, int minTreeHeight) {
        super(doBlockNotify);
        this.minTreeHeight = minTreeHeight;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        while (!world.isAirBlock(x, y, z) && y > 2) y++;
        int length = 3 + random.nextInt(3);
        int direction = random.nextInt(2);
        boolean isAllowed = true;
        int i;
        for (i = 0; i < length; i++) {
            int ix = 0;
            int iz = 0;
            if (direction == 0) {
                ix = i;
            } else {
                iz = i;
            }
            if (!world.isAirBlock(x + ix, y, z + iz) || world.getBlock(x + ix, y - 1, z + iz) != Blocks.grass
                && world.getBlock(x + ix, y - 1, z + iz) != ModBlocks.salt_grass) {
                isAllowed = false;
                break;
            }
        }
        if (isAllowed) {
            for (i = 0; i < length; i++) {
                if (direction == 0) {
                    world.setBlock(x + i, y, z, ModBlocks.salt_crusted_oak_log, 4, 2);
                } else {
                    world.setBlock(x, y, z + i, ModBlocks.salt_crusted_oak_log, 8, 2);
                }
            }
            return true;
        }
        return false;
    }
}
