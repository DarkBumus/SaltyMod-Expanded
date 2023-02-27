package ru.liahim.saltmod.world;

import java.util.Random;

import net.minecraft.block.BlockGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import ru.liahim.saltmod.init.ModBlocks;

public class SaltMarshPlantMix   extends WorldGenerator
{


    private int GroupSize;

    public SaltMarshPlantMix(int size)
    {
        this.GroupSize = size;
    }


    public boolean generate(World world, Random random, int x, int y, int z) {
        for (int l = 0; l < this.GroupSize; ++l) {
            int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);
            int varPlant = random.nextInt(50);
            if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 - 1, k1) instanceof BlockGrass || world.getBlock(i1, j1 - 1, k1) == ModBlocks.saltGrass)) {

                if (varPlant <= 4) {
//					Vanilla Saltwort Placement: world.setBlock(i1, j1, k1, ModBlocks.saltWort, random.nextInt(5), 2);
                    world.setBlock(i1, j1, k1, ModBlocks.saltWort, random.nextInt(5), 2);
                }
                else if (varPlant == 5) {
                    world.setBlock(i1, j1, k1, Blocks.tallgrass, 0, 2);
                }
                else

                    world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 2);

            }

        }

        return true;
    }
}
