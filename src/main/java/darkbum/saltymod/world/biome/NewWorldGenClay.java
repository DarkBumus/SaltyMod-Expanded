package darkbum.saltymod.world.biome;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class NewWorldGenClay extends WorldGenerator
{
    private Block clay;
    private int numberOfBlocks;

    public NewWorldGenClay(int number) {
        this.clay = ModBlocks.mineral_mud;
        this.numberOfBlocks = number;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial() != Material.water) {
            return false;
        } else {
            int l = random.nextInt(this.numberOfBlocks - 2) + 2;
            byte b0 = 1;

            for (int i1 = x - l; i1 <= x + l; ++i1) {
                for (int j1 = z - l; j1 <= z + l; ++j1) {
                    int k1 = i1 - x;
                    int l1 = j1 - z;

                    if (k1 * k1 + l1 * l1 <= l * l) {
                        for (int i2 = y - b0; i2 <= y + b0; ++i2) {
                            Block block = world.getBlock(i1, i2, j1);

                            if(block instanceof BlockDirt || block == Blocks.clay || block == ModBlocks.salt_dirt || block == ModBlocks.salt_dirt_lite) {
                                world.setBlock(i1, i2, j1, this.clay, 0, 2);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}
