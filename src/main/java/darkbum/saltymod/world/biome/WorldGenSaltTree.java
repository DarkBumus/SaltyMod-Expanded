package darkbum.saltymod.world.biome;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenSaltTree extends WorldGenAbstractTree  {

    private final int minTreeHeight;

    public WorldGenSaltTree(boolean doBlockNotify) {
        this(doBlockNotify, 4);
    }

    public WorldGenSaltTree(boolean doBlockNotify, int minTreeHeight) {
        super(doBlockNotify);
        this.minTreeHeight = minTreeHeight;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        int heightRandomization = random.nextInt(3) + minTreeHeight;
        boolean shouldPlace = true;

        if (y >= 1 && y + heightRandomization + 1 <= 256) {
            byte checkDistance;
            int checkAtZ;
            Block block;

            for(int checkAtY = y; checkAtY <= y + 1 + heightRandomization; ++checkAtY) {
                checkDistance = 1;

                if(checkAtY == y) {
                    checkDistance = 0;
                } else if(checkAtY >= y + 1 + heightRandomization - 2) {
                    checkDistance = 2;
                }

                for(int checkAtX = x - checkDistance; checkAtX <= x + checkDistance && shouldPlace; ++checkAtX) {
                    for(checkAtZ = z - checkDistance; checkAtZ <= z + checkDistance && shouldPlace; ++checkAtZ) {
                        if(checkAtY >= 0 && checkAtY < 256) {
                            if(!isReplaceable(world, checkAtX, checkAtY, checkAtZ)) {
                                shouldPlace = false;
                            }
                        } else {
                            shouldPlace = false;
                        }
                    }
                }
            }

            if(!shouldPlace) {
                return false;
            } else {
                Block ground = world.getBlock(x, y - 1, z);

                boolean isSoil = ground.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                if(isSoil && y < 256 - heightRandomization - 1) {
                    ground.onPlantGrow(world, x, y - 1, z, x, y, z);

                    block = world.getBlock(x, y, z);

                    if(block.isAir(world, x, y, z) || block.isLeaves(world, x, y, z)) {
                        setBlockAndNotifyAdequately(world, x, y , z, ModBlocks.salt_crusted_oak_log, 0);
                    }

                    for(checkAtZ = 1; checkAtZ < heightRandomization; ++checkAtZ) {
                        block = world.getBlock(x, y + checkAtZ, z);

                        if(block.isAir(world, x, y + checkAtZ, z) || block.isLeaves(world, x, y + checkAtZ, z)) {
                            setBlockAndNotifyAdequately(world, x, y + checkAtZ, z, Blocks.log, 0);
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

}
