package darkbum.saltymod.world;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenSaltBigTree extends WorldGenAbstractTree  {

    static final byte[] otherCoordPairs = new byte[] {(byte)2, (byte)0, (byte)0, (byte)1, (byte)2, (byte)1};

    Random rand = new Random();

    World worldObj;
    int[] basePos = new int[] {0, 0, 0};
    int heightLimit;
    int height;
    double heightAttenuation = 0.618D;
    double branchSlope = 0.381D;
    double scaleWidth = 1.0D;
    double leafDensity = 1.0D;

    int trunkSize = 1;

    int heightLimitLimit = 12;

    int leafDistanceLimit = 4;

    int[][] leafNodes;

    public WorldGenSaltBigTree(boolean doBlockNotify, boolean wideTrunk) {
        super(doBlockNotify);
        if(wideTrunk) {
            trunkSize = 2;
        }
    }


    void generateLeafNodeList() {
        height = (int)((double)heightLimit * heightAttenuation);

        if(height >= heightLimit) {
            height = heightLimit - 1;
        }

        int i = (int)(1.382D + Math.pow(leafDensity * (double)heightLimit / 13.0D, 2.0D));

        if (i < 1) {
            i = 1;
        }

        int[][] aint = new int[i * heightLimit][4];
        int j = basePos[1] + heightLimit - leafDistanceLimit;
        int k = 1;
        int l = basePos[1] + height;
        int i1 = j - basePos[1];
        aint[0][0] = basePos[0];
        aint[0][1] = j;
        aint[0][2] = basePos[2];
        aint[0][3] = l;
        --j;

        while(i1 >= 0) {
            int j1 = 0;
            float f = layerSize(i1);

            if (!(f < 0.0F)) {
                for (double d0 = 0.5D; j1 < i; ++j1) {
                    double d1 = scaleWidth * (double) f * ((double) rand.nextFloat() + 0.328D);
                    double d2 = (double) rand.nextFloat() * 2.0D * Math.PI;
                    int k1 = MathHelper.floor_double(d1 * Math.sin(d2) + (double) basePos[0] + d0);
                    int l1 = MathHelper.floor_double(d1 * Math.cos(d2) + (double) basePos[2] + d0);
                    int[] aint1 = new int[]{k1, j, l1};
                    int[] aint2 = new int[]{k1, j + leafDistanceLimit, l1};

                    if (checkBlockLine(aint1, aint2) == -1) {
                        int[] aint3 = new int[]{basePos[0], basePos[1], basePos[2]};
                        double d3 = Math.sqrt(Math.pow(Math.abs(basePos[0] - aint1[0]), 2.0D) + Math.pow(Math.abs(basePos[2] - aint1[2]), 2.0D));
                        double d4 = d3 * this.branchSlope;

                        if ((double) aint1[1] - d4 > (double) l) {
                            aint3[1] = l;
                        } else {
                            aint3[1] = (int) ((double) aint1[1] - d4);
                        }

                        if (checkBlockLine(aint3, aint1) == -1) {
                            aint[k][0] = k1;
                            aint[k][1] = j;
                            aint[k][2] = l1;
                            aint[k][3] = aint3[1];
                            ++k;
                        }
                    }
                }

            }
            --j;
            --i1;
        }

        leafNodes = new int[k][4];
        System.arraycopy(aint, 0, leafNodes, 0, k);
    }


    float layerSize(int p_76490_1_) {
        if((double)p_76490_1_ < (double)((float)this.heightLimit) * 0.3D) {
            return -1.618F;
        } else {
            float f = (float)heightLimit / 2.0F;
            float f1 = (float)heightLimit / 2.0F - (float)p_76490_1_;
            float f2;

            if(f1 == 0.0F) {
                f2 = f;
            } else if(Math.abs(f1) >= f) {
                f2 = 0.0F;
            } else {
                f2 = (float)Math.sqrt(Math.pow(Math.abs(f), 2.0D) - Math.pow(Math.abs(f1), 2.0D));
            }

            f2 *= 0.5F;
            return f2;
        }
    }

    void generateTrunkColumn(int[] bottomPos, int[] topPos) {
        int[] aint2 = new int[] {0, 0, 0};
        byte b1 = 0;

        for(byte coord = 0; coord < 3; ++coord) {
            aint2[coord] = topPos[coord] - bottomPos[coord];

            if(Math.abs(aint2[coord]) > Math.abs(aint2[b1])) {
                b1 = coord;
            }
        }

        if(aint2[b1] != 0) {
            byte b2 = otherCoordPairs[b1];
            byte b3 = otherCoordPairs[b1 + 3];
            byte direction;

            if(aint2[b1] > 0) {
                direction = 1;
            } else {
                direction = -1;
            }

            double d0 = (double)aint2[b2] / (double)aint2[b1];
            double d1 = (double)aint2[b3] / (double)aint2[b1];
            int[] finalPos = new int[] {0, 0, 0};
            int height = aint2[b1] + direction;


            for(int i = 0; i != height; i += direction) {
                finalPos[b1] = MathHelper.floor_double((double)(bottomPos[b1] + i) + 0.5D);
                finalPos[b2] = MathHelper.floor_double((double)bottomPos[b2] + (double)i * d0 + 0.5D);
                finalPos[b3] = MathHelper.floor_double((double)bottomPos[b3] + (double)i * d1 + 0.5D);
                byte meta = 0;
                int k = Math.abs(finalPos[0] - bottomPos[0]);
                int l = Math.abs(finalPos[2] - bottomPos[2]);
                int i1 = Math.max(k, l);

                if(i1 > 0) {
                    if(k == i1) {
                        meta = 4;
                    } else if(l == i1) {
                        meta = 8;
                    }
                }

                Block block = Blocks.log;
                Block otherBlock = worldObj.getBlock(finalPos[0], finalPos[1] - 1, finalPos[2]);
                if(otherBlock != block && otherBlock != ModBlocks.salt_crusted_oak_log && otherBlock.isOpaqueCube() && !otherBlock.isLeaves(worldObj, finalPos[0], finalPos[1] - 1, finalPos[2])) {
                    block = ModBlocks.salt_crusted_oak_log;
                }

                setBlockAndNotifyAdequately(worldObj, finalPos[0], finalPos[1], finalPos[2], block, meta);
            }
        }
    }


    void generateTrunk() {
        int x = basePos[0];
        int y = basePos[1];
        int yHeight = basePos[1] + height;
        int z = basePos[2];
        int[] bottomArray = new int[] {x, y, z};
        int[] topArray = new int[] {x, yHeight, z};
        generateTrunkColumn(bottomArray, topArray);

        if(trunkSize == 2) {
            ++bottomArray[0];
            ++topArray[0];
            generateTrunkColumn(bottomArray, topArray);
            ++bottomArray[2];
            ++topArray[2];
            generateTrunkColumn(bottomArray, topArray);
            bottomArray[0] -= 1;
            topArray[0] -= 1;
            generateTrunkColumn(bottomArray, topArray);
        }
    }


    void generateLeafNodeBases() {
        int i = 0;
        int j = leafNodes.length;

        for(int[] aint = new int[] {basePos[0], basePos[1], basePos[2]}; i < j; ++i) {
            int[] aint1 = leafNodes[i];
            int[] aint2 = new int[] {aint1[0], aint1[1], aint1[2]};
            aint[1] = aint1[3];
            int k = aint[1] - basePos[1];

            if(k >= 0.2D * heightLimit) {
                generateTrunkColumn(aint, aint2);
            }
        }
    }


    int checkBlockLine(int[] p_76496_1_, int[] p_76496_2_) {
        int[] aint2 = new int[] {0, 0, 0};
        byte b0 = 0;
        byte b1;

        for(b1 = 0; b0 < 3; ++b0) {
            aint2[b0] = p_76496_2_[b0] - p_76496_1_[b0];

            if(Math.abs(aint2[b0]) > Math.abs(aint2[b1])) {
                b1 = b0;
            }
        }

        if(aint2[b1] == 0) {
            return -1;
        } else {
            byte b2 = otherCoordPairs[b1];
            byte b3 = otherCoordPairs[b1 + 3];
            byte b4;

            if (aint2[b1] > 0) {
                b4 = 1;
            } else {
                b4 = -1;
            }

            double d0 = (double)aint2[b2] / (double)aint2[b1];
            double d1 = (double)aint2[b3] / (double)aint2[b1];
            int[] aint3 = new int[] {0, 0, 0};
            int i = 0;
            int j;

            for(j = aint2[b1] + b4; i != j; i += b4) {
                aint3[b1] = p_76496_1_[b1] + i;
                aint3[b2] = MathHelper.floor_double((double)p_76496_1_[b2] + (double)i * d0);
                aint3[b3] = MathHelper.floor_double((double)p_76496_1_[b3] + (double)i * d1);

                if (!this.isReplaceable(worldObj, aint3[0], aint3[1], aint3[2])) {
                    break;
                }
            }

            return i == j ? -1 : Math.abs(i);
        }
    }


    boolean validTreeLocation() {
        int[] aint = new int[] {basePos[0], basePos[1], basePos[2]};
        int[] aint1 = new int[] {basePos[0], basePos[1] + heightLimit - 1, basePos[2]};
        Block block = worldObj.getBlock(basePos[0], basePos[1] - 1, basePos[2]);

        boolean isSoil = block.canSustainPlant(worldObj, basePos[0], basePos[1] - 1, basePos[2], ForgeDirection.UP, (BlockSapling)Blocks.sapling);
        if(!isSoil) {
            return false;
        } else {
            int i = checkBlockLine(aint, aint1);

            if(i == -1) {
                return true;
            } else if(i < 6) {
                return false;
            } else {
                heightLimit = i;
                return true;
            }
        }
    }


    public void setScale(double heightLimit, double scaleWidth, double leafDensity) {
        heightLimitLimit = (int)(heightLimit * 12.0D);

        if(heightLimit > 0.5D) {
            leafDistanceLimit = 5;
        }

        this.scaleWidth = scaleWidth;
        this.leafDensity = leafDensity;
    }

    public boolean generate(World world, Random random, int x, int y, int z)  {
        worldObj = world;
        rand.setSeed(random.nextLong());
        basePos[0] = x;
        basePos[1] = y;
        basePos[2] = z;

        if(heightLimit == 0) {
            heightLimit = 5 + rand.nextInt(heightLimitLimit);
        }

        if(!validTreeLocation()) {
            worldObj = null;
            return false;
        } else {
            generateLeafNodeList();
            generateTrunk();
            generateLeafNodeBases();
            worldObj = null;
            return true;
        }
    }
}
