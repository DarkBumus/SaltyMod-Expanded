
package darkbum.saltymod.world.biome;

import java.util.Random;

import darkbum.saltymod.init.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class SaltMarshUndergroundLakeGenerator {

    public static final int MIN_ROOF_THICKNESS = 4;

    private static final int MIN_GENERATION_Y = 16;

    private SaltMarshUndergroundLakeGenerator() {}

    public static boolean hasSaltMarshInPopulationArea(
        World world, int chunkX, int chunkZ
    ) {
        int startX = chunkX * 16 + 8;
        int startZ = chunkZ * 16 + 8;

        for (int x = startX; x < startX + 16; x++) {
            for (int z = startZ; z < startZ + 16; z++) {
                if (world.getBiomeGenForCoords(x, z) == ModBiomes.saltMarsh) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean generate(
        World world, Random random, int chunkX, int chunkZ, Block liquid
    ) {
        int startX = chunkX * 16 + 8;
        int startZ = chunkZ * 16 + 8;

        // Select a random position inside the Salt Marsh.
        int lakeX = 0;
        int lakeZ = 0;
        int saltMarshPositions = 0;

        for (int x = startX; x < startX + 16; x++) {
            for (int z = startZ; z < startZ + 16; z++) {
                if (world.getBiomeGenForCoords(x, z) != ModBiomes.saltMarsh) {
                    continue;
                }

                saltMarshPositions++;

                // Reservoir sampling: every valid position has
                // the same probability of being selected.
                if (random.nextInt(saltMarshPositions) == 0) {
                    lakeX = x;
                    lakeZ = z;
                }
            }
        }

        if (saltMarshPositions == 0) {
            return false;
        }

        // WorldGenLakes uses a 16x16 area beginning at
        // (lakeX - 8, lakeZ - 8).
        int maxSurfaceY = 0;

        for (int x = lakeX - 8; x < lakeX + 8; x++) {
            for (int z = lakeZ - 8; z < lakeZ + 8; z++) {
                maxSurfaceY = Math.max(
                    maxSurfaceY,
                    world.getTopSolidOrLiquidBlock(x, z)
                );
            }
        }

        // WorldGenLakes can extend its cavity up to two blocks
        // above the solid block it finds at its starting column.
        // Keep the configured number of solid roof blocks.
        int maxGenerationY =
            maxSurfaceY - MIN_ROOF_THICKNESS - 3;

        if (maxGenerationY < MIN_GENERATION_Y) {
            return false;
        }

        int y = MIN_GENERATION_Y
            + random.nextInt(maxGenerationY - MIN_GENERATION_Y + 1);

        // Preserve Vanilla's additional rarity check for
        // lava lakes above sea level.
        if (liquid == Blocks.lava
            && y >= 63
            && random.nextInt(10) != 0) {
            return false;
        }

        // Check where WorldGenLakes will find solid ground.
        // Its internal starting column is lakeX - 8, lakeZ - 8.
        int groundY = y;
        int anchorX = lakeX - 8;
        int anchorZ = lakeZ - 8;

        while (groundY > 5 && world.isAirBlock(anchorX, groundY, anchorZ)) {
            groundY--;
        }

        // Avoid generating lakes too close to the bottom of the world.
        if (groundY <= 8) {
            return false;
        }

        return new WorldGenLakes(liquid).generate(
            world, random, lakeX, y, lakeZ
        );
    }
}
