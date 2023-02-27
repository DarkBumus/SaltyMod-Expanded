package darkbum.saltmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public interface IDegradable {
    int getMudBrickWetMeta(int paramInt);

    default int getFinalMudBrickWetMeta(int meta, int worldMeta) {
        return getMudBrickWetMeta(meta);
    }

    Block getMudBrickWetFromMeta(int paramInt);

    default void tickDegradation(World world, int x, int y, int z, Random random) {
        if (!world.isRemote && random.nextFloat() < 0.05688889F) tryDegrade(world, x, y, z, random);
    }

    default void tryDegrade(World world, int x, int y, int z, Random random) {
        int i = getMudBrickWetMeta(world.getBlockMetadata(x, y, z));
        int j = 0;
        int k = 0;
        if (i < 7 && i % 4 != 3) {
            for (int x1 = -4; x1 <= 4; x1++) {
                for (int y1 = -4; y1 <= 4; y1++) {
                    for (int z1 = -4; z1 <= 4; z1++) {
                        Block block = world.getBlock(x1 + x, y1 + y, z1 + z);
                        if (block instanceof IDegradable && (x1 != 0 || y1 != 0 || z1 != 0) && Math.abs(x1) + Math.abs(y1) + Math.abs(z1) <= 4) {
                            int m = ((IDegradable)block).getMudBrickWetMeta(world.getBlockMetadata(x1 + x, y1 + y, z1 + z));
                            if (m <= 7) {
                                m %= 4;
                                if (m < i % 4)
                                    return;
                                if (m > i % 4) {
                                    k++;
                                } else {
                                    j++;
                                }
                            }
                        }
                    }
                }
            }
            float f = (k + 1) / (k + j+ 1);
            float g = f * f * ((i % 4 == 0) ? 0.75F : 1.0F);
            if (random.nextFloat() < g) {
                Block block = getMudBrickWetFromMeta(i + 1);
                world.setBlock(x, y, z, block, (block instanceof net.minecraft.block.BlockStairs) ? world.getBlockMetadata(x, y, z) : getFinalMudBrickWetMeta(i + 1, world.getBlockMetadata(x, y, z)), 2);
            }
        }
    }
}
