package darkbum.saltymod.world.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import darkbum.saltymod.init.ModBlocks;

public class WorldGenSaltwort extends WorldGenerator {

    private final int GroupSize;

    public WorldGenSaltwort(int size) {
        this.GroupSize = size;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        for (int l = 0; l < this.GroupSize; ++l) {
            int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);

            if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 - 1, k1) == ModBlocks.salt_dirt
                || world.getBlock(i1, j1 - 1, k1) == ModBlocks.salt_dirt)) {

                world.setBlock(i1, j1, k1, ModBlocks.saltworts, random.nextInt(5), 3);

            }

        }

        return true;
    }
}
