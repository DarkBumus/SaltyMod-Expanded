package darkbum.saltymod.world.generator;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModConfiguration;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class SaltCrystalGenerator implements IWorldGenerator {

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            generateOverworld(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateOverworld(World world, Random rand, int x, int z) {
        int dimensionSpawnHeight = 40;
        for (int y = 8; y < dimensionSpawnHeight; y++) {
            for (int x1 = x; x1 < x + 16; x1++) {
                for (int z1 = z; z1 < z + 16; z1++) {
                    if (world.getBlock(x1, y - 1, z1) == ModBlocks.salt_ore && world.isAirBlock(x1, y, z1) && world.getFullBlockLightValue(x1, y, z1) < 13)
                        if (rand.nextInt(2) == 0) {
                            world.setBlock(x1, y, z1, ModBlocks.salt_crystal, 1, 3);
                        } else {
                            world.setBlock(x1, y, z1, ModBlocks.salt_crystal);
                        }
                }
            }
        }
    }
}
