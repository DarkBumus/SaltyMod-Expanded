package darkbum.saltymod.world.biome;

import java.util.Random;

import net.minecraft.block.BlockGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import darkbum.saltymod.init.ModBlocks;

public class SaltMarshPlantMix extends WorldGenerator {

    private int groupsize;

    public SaltMarshPlantMix(int size) {
        groupsize = size;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        for (int pass = 0; pass < groupsize; ++pass) {
            int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);
            int varPlant = random.nextInt(50);
            if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 - 1, k1) instanceof BlockGrass
                || world.getBlock(i1, j1 - 1, k1) == ModBlocks.salt_grass)) {
                if (varPlant <= 4) {
                    // Vanilla Saltwort Placement: world.setBlock(i1, j1, k1, ModBlocks.saltWort, random.nextInt(5), 2);
                    world.setBlock(i1, j1, k1, ModBlocks.saltworts, random.nextInt(4), 2);
                } else if (varPlant == 5) {
                    world.setBlock(i1, j1, k1, Blocks.tallgrass, 0, 2);
                } else world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 2);
            }
        }
        return true;
    }
}
