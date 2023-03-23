package darkbum.saltymod.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AlliumPatch extends WorldGenerator
{


    private int GroupSize;

    public AlliumPatch(int size)
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

            if (world.isAirBlock(i1, j1, k1) && Blocks.red_flower.canReplace(world, i1, j1, k1, 0, new ItemStack(Blocks.red_flower, 1, 2))) {

                world.setBlock(i1, j1, k1, Blocks.red_flower, 2, 2);
            }
        }
        return true;
    }
}
