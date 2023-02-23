package ru.liahim.saltmod.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import ru.liahim.saltmod.init.ModBlocks;

public class SaltWortMix extends WorldGenerator
{

	
    private int GroupSize;

    public SaltWortMix(int size)
    {
        this.GroupSize = size;
    }


    public boolean generate(World world, Random random, int x, int y, int z)
    {
        for (int l = 0; l < this.GroupSize; ++l)
        {
            int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);
           
            if (world.isAirBlock(i1, j1, k1) && (world.getBlock(i1, j1 - 1, k1) == ModBlocks.saltDirtLite || world.getBlock(i1, j1 - 1, k1) == ModBlocks.saltDirt)) {
            	
            	world.setBlock(i1, j1, k1, ModBlocks.saltWort, random.nextInt(5), 2);
            	
            	}

        }

        return true;
    }
}