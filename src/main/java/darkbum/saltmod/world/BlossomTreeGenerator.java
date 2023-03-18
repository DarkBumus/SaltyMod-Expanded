package darkbum.saltmod.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class BlossomTreeGenerator implements IWorldGenerator {

    protected final int offsetXZ(Random random) {
        return random.nextInt(16) - 8;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        int xx, yy, zz;
        int x = chunkX * 16 + 8, z = chunkZ * 16 + 8;
        String biomeName = world.getWorldChunkManager().getBiomeGenAt(x, z).biomeName;

        if (biomeName == null) {
            return;
        }

        if (biomeName == "Forest" || biomeName == "ForestHills" || biomeName == "Birch Forest" || biomeName == "Birch Forest Hills") {
            xx = x + offsetXZ(random);
            zz = z + offsetXZ(random);
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            if (random.nextInt(150) == 0) {
                (new WorldGenBlossomBigTree(false, false)).generate(world, random, xx, yy, zz);
            }
        }
    }
}
