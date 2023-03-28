package darkbum.saltymod.world.biome;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AlliumPatch extends WorldGenerator {

    private static final Block[] flowers = {Blocks.red_flower, ModBlocks.salt_flower};

    private static final int[] flowersMeta = {2, 4};

    private int groupSize;

    public AlliumPatch(int size) {
        groupSize = size;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        for (int l = 0; l < groupSize; ++l) {
            int xPos = x + random.nextInt(8) - random.nextInt(8);
            int yPos = y + random.nextInt(4) - random.nextInt(4);
            int zPos = z + random.nextInt(8) - random.nextInt(8);

            int weight = random.nextFloat() < 0.5F ? 0 : 1;

            if (world.isAirBlock(xPos, yPos, zPos) && Blocks.red_flower.canReplace(world, xPos, yPos, zPos, 0, new ItemStack(Blocks.red_flower, 1, 2))) {

                world.setBlock(xPos, yPos, zPos, flowers[weight], flowersMeta[weight], 2);
            }
        }
        return true;
    }
}
