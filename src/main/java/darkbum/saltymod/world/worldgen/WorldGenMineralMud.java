package darkbum.saltymod.world.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import darkbum.saltymod.init.ModBlocks;

public class WorldGenMineralMud extends WorldGenerator {

    private final Block filler;
    private final int numberOfBlocks;

    public WorldGenMineralMud(int number) {
        this.filler = ModBlocks.mineral_mud;
        this.numberOfBlocks = number;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        int radius = random.nextInt(this.numberOfBlocks - 2) + 2;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                int distanceSquared = dx * dx + dz * dz;
                if (distanceSquared > radius * radius) continue;

                for (int dy = -1; dy <= 1; dy++) {
                    int blockX = x + dx;
                    int blockY = y + dy;
                    int blockZ = z + dz;

                    Block currentBlock = world.getBlock(blockX, blockY, blockZ);
                    Block blockAbove = world.getBlock(blockX, blockY + 1, blockZ);

                    if ((currentBlock instanceof BlockDirt || currentBlock == Blocks.clay
                        || currentBlock == ModBlocks.salt_dirt
                        || currentBlock == ModBlocks.salt_dirt_lite)
                        && blockAbove.getMaterial() == Material.water) {

                        world.setBlock(blockX, blockY, blockZ, this.filler, 0, 2);
                    }
                }
            }
        }
        return true;
    }
}
