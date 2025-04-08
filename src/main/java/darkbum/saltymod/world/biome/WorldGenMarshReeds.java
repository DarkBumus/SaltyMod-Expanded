package darkbum.saltymod.world.biome;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMarshReeds extends WorldGenerator {

    public boolean generate(World world, Random random, int x, int y, int z)
    {
        for (int l = 0; l < 50; ++l)
        {
            int i1 = x + random.nextInt(16) - random.nextInt(16);
            int j1 = y + random.nextInt(8) - random.nextInt(8);
            int k1 = z + random.nextInt(16) - random.nextInt(16);

            if (world.isAirBlock(i1, j1, k1) && ModBlocks.marsh_reeds.canPlaceBlockAt(world, i1, j1, k1))
            {
                world.setBlock(i1, j1, k1, ModBlocks.marsh_reeds, 0, 2);
            }
        }
        return true;
    }
}
