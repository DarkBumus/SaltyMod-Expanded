package darkbum.saltymod.world.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLakesMod extends WorldGenerator {
    private final Block fluidBlock;
    private final Block subWaterBlock;
    private final int fixedRadius;
    private final int minY;
    private final int maxY;

    public WorldGenLakesMod(Block fluidBlock, Block subWaterBlock, int radius, int minY, int maxY) {
        this.fluidBlock = fluidBlock;
        this.subWaterBlock = subWaterBlock;
        this.fixedRadius = radius;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        int radius = rand.nextInt(3) + fixedRadius;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {

                double distX = dx + rand.nextGaussian() * 0.5;
                double distZ = dz + rand.nextGaussian() * 0.5;
                double dist = distX * distX + distZ * distZ;

                if (dist <= radius * radius) {
                    int realX = x + dx;
                    int realZ = z + dz;

                    int topY = world.getHeightValue(realX, realZ);
                    int waterY = topY - 1;

                    if (waterY < minY || waterY > maxY) continue;

                    Block blockBelow = world.getBlock(realX, waterY, realZ);
                    Block blockAbove = world.getBlock(realX, waterY + 1, realZ);

                    if (blockBelow.getMaterial().isSolid() && !blockAbove.getMaterial().isSolid() && isBlockSurroundedBySolidOrWater(world, realX, waterY, realZ)) {
                        // Setze den Block unter dem Wasser
                        world.setBlock(realX, waterY - 1, realZ, subWaterBlock, 0, 2);
                        // Setze den Wasserblock
                        world.setBlock(realX, waterY, realZ, fluidBlock, 0, 2);
                    }
                }
            }
        }

        return true;
    }

    private boolean isBlockSurroundedBySolidOrWater(World world, int x, int y, int z) {
        return (world.getBlock(x + 1, y, z).getMaterial().isSolid() || world.getBlock(x + 1, y, z).getMaterial().isLiquid())
            && (world.getBlock(x - 1, y, z).getMaterial().isSolid() || world.getBlock(x - 1, y, z).getMaterial().isLiquid())
            && (world.getBlock(x, y, z + 1).getMaterial().isSolid() || world.getBlock(x, y, z + 1).getMaterial().isLiquid())
            && (world.getBlock(x, y, z - 1).getMaterial().isSolid() || world.getBlock(x, y, z - 1).getMaterial().isLiquid())
            && (world.getBlock(x, y - 1, z).getMaterial().isSolid() || world.getBlock(x, y - 1, z).getMaterial().isLiquid());
    }
}
