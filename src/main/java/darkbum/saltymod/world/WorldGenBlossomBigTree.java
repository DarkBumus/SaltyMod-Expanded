package darkbum.saltymod.world;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenBlossomBigTree extends WorldGenAbstractTree {

    static final byte[] otherCoordPairs = new byte[]{(byte) 2, (byte) 0, (byte) 0, (byte) 1, (byte) 2, (byte) 1};

    Random rand = new Random();

    World worldObj;
    int[] basePos = new int[]{0, 0, 0};
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

    public WorldGenBlossomBigTree(boolean doBlockNotify, boolean wideTrunk) {
        super(doBlockNotify);
        if (wideTrunk) {
            trunkSize = 2;
        }
    }


    void generateLeafNodeList() {
        height = (int)((double)heightLimit * heightAttenuation);

        if (height >= heightLimit) {
            height = heightLimit - 1;
        }

        int i = (int)(1.382 + Math.pow(leafDensity * (double)heightLimit / 13.0, 2.0));
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
            float f = this.layerSize(i1);

            if (!(f < 0.0F)) {
                for (double d0 = 0.5; j1 < i; ++j1) {
                    double d1 = this.scaleWidth * (double) f * ((double) this.rand.nextFloat() + 0.328);
                    double d2 = (double) this.rand.nextFloat() * 2.0 * Math.PI;
                    int k1 = MathHelper.floor_double(d1 * Math.sin(d2) + (double) this.basePos[0] + d0);
                    int l1 = MathHelper.floor_double(d1 * Math.cos(d2) + (double) this.basePos[2] + d0);
                    int[] aint1 = new int[]{k1, j, l1};
                    int[] aint2 = new int[]{k1, j + this.leafDistanceLimit, l1};
                    if (this.checkBlockLine(aint1, aint2) == -1) {
                        int[] aint3 = new int[]{this.basePos[0], this.basePos[1], this.basePos[2]};
                        double d3 = Math.sqrt(Math.pow((double) Math.abs(this.basePos[0] - aint1[0]), 2.0) + Math.pow(Math.abs(this.basePos[2] - aint1[2]), 2.0));
                        double d4 = d3 * this.branchSlope;
                        if ((double) aint1[1] - d4 > (double) l) {
                            aint3[1] = l;
                        } else {
                            aint3[1] = (int) ((double) aint1[1] - d4);
                        }

                        if (this.checkBlockLine(aint3, aint1) == -1) {
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

        this.leafNodes = new int[k][4];
        System.arraycopy(aint, 0, this.leafNodes, 0, k);
    }

    void func_150529_a(int p_150529_1_, int p_150529_2_, int p_150529_3_, float p_150529_4_, byte p_150529_5_, Block p_150529_6_) {
        int l = (int)((double)p_150529_4_ + 0.618);
        byte b1 = otherCoordPairs[p_150529_5_];
        byte b2 = otherCoordPairs[p_150529_5_ + 3];
        int[] aint = new int[]{p_150529_1_, p_150529_2_, p_150529_3_};
        int[] aint1 = new int[]{0, 0, 0};
        int i1 = -l;
        int j1 = -l;

        label33:
        for(aint1[p_150529_5_] = aint[p_150529_5_]; i1 <= l; ++i1) {
            aint1[b1] = aint[b1] + i1;
            j1 = -l;

            while(true) {
                while(true) {
                    if (j1 > l) {
                        continue label33;
                    }

                    double d0 = Math.pow((double)Math.abs(i1) + 0.5, 2.0) + Math.pow((double)Math.abs(j1) + 0.5, 2.0);
                    if (d0 > (double)(p_150529_4_ * p_150529_4_)) {
                        ++j1;
                    } else {
                        aint1[b2] = aint[b2] + j1;
                        Block block1 = this.worldObj.getBlock(aint1[0], aint1[1], aint1[2]);
                        if (!block1.isAir(this.worldObj, aint1[0], aint1[1], aint1[2]) && !block1.isLeaves(this.worldObj, aint1[0], aint1[1], aint1[2])) {
                            ++j1;
                        } else {
                            this.setBlockAndNotifyAdequately(this.worldObj, aint1[0], aint1[1], aint1[2], p_150529_6_, 0);
                            ++j1;
                        }
                    }
                }
            }
        }

    }

    float layerSize(int p_76490_1_) {
        if ((double)p_76490_1_ < (double)((float)this.heightLimit) * 0.3) {
            return -1.618F;
        } else {
            float f = (float)this.heightLimit / 2.0F;
            float f1 = (float)this.heightLimit / 2.0F - (float)p_76490_1_;
            float f2;
            if (f1 == 0.0F) {
                f2 = f;
            } else if (Math.abs(f1) >= f) {
                f2 = 0.0F;
            } else {
                f2 = (float)Math.sqrt(Math.pow((double)Math.abs(f), 2.0) - Math.pow((double)Math.abs(f1), 2.0));
            }

            f2 *= 0.5F;
            return f2;
        }
    }

    float leafSize(int p_76495_1_) {
        return p_76495_1_ >= 0 && p_76495_1_ < this.leafDistanceLimit ? (p_76495_1_ != 0 && p_76495_1_ != this.leafDistanceLimit - 1 ? 3.0F : 2.0F) : -1.0F;
    }

    void generateLeafNode(int p_76491_1_, int p_76491_2_, int p_76491_3_) {
        int l = p_76491_2_;

        for(int i1 = p_76491_2_ + this.leafDistanceLimit; l < i1; ++l) {
            float f = this.leafSize(l - p_76491_2_);
            this.func_150529_a(p_76491_1_, l, p_76491_3_, f, (byte)1, ModBlocks.blossom_leaves);
        }

    }

    void generateTrunkColumn(int[] p_150530_1_, int[] p_150530_2_, Block p_150530_3_) {
        int[] aint2 = new int[]{0, 0, 0};
        byte b0 = 0;

        byte b1;
        for(b1 = 0; b0 < 3; ++b0) {
            aint2[b0] = p_150530_2_[b0] - p_150530_1_[b0];
            if (Math.abs(aint2[b0]) > Math.abs(aint2[b1])) {
                b1 = b0;
            }
        }

        if (aint2[b1] != 0) {
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
            int[] aint3 = new int[]{0, 0, 0};
            int i = 0;

            for(int j = aint2[b1] + b4; i != j; i += b4) {
                aint3[b1] = MathHelper.floor_double((double)(p_150530_1_[b1] + i) + 0.5);
                aint3[b2] = MathHelper.floor_double((double)p_150530_1_[b2] + (double)i * d0 + 0.5);
                aint3[b3] = MathHelper.floor_double((double)p_150530_1_[b3] + (double)i * d1 + 0.5);
                byte b5 = 0;
                int k = Math.abs(aint3[0] - p_150530_1_[0]);
                int l = Math.abs(aint3[2] - p_150530_1_[2]);
                int i1 = Math.max(k, l);
                if (i1 > 0) {
                    if (k == i1) {
                        b5 = 4;
                    } else if (l == i1) {
                        b5 = 8;
                    }
                }

                this.setBlockAndNotifyAdequately(this.worldObj, aint3[0], aint3[1], aint3[2], p_150530_3_, b5);
            }
        }

    }

    void generateLeaves() {
        int i = 0;

        for(int j = this.leafNodes.length; i < j; ++i) {
            int k = this.leafNodes[i][0];
            int l = this.leafNodes[i][1];
            int i1 = this.leafNodes[i][2];
            this.generateLeafNode(k, l, i1);
        }

    }

    boolean leafNodeNeedsBase(int p_76493_1_) {
        return (double)p_76493_1_ >= (double)this.heightLimit * 0.2;
    }

/*    void generateTrunkColumn(int[] bottomPos, int[] topPos) {
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
                Block otherBlock = worldObj.getBlock(finalPos[0], finalPos[1] + 3, finalPos[2]);
                if(otherBlock != block && otherBlock != ModBlocks.blossom_burrow && otherBlock.isOpaqueCube() && !otherBlock.isLeaves(worldObj, finalPos[0], finalPos[1] - 1, finalPos[2])) {
                    block = ModBlocks.blossom_burrow;
                }

                setBlockAndNotifyAdequately(worldObj, finalPos[0], finalPos[1], finalPos[2], block, meta);
            }
        }
    }*/

    void generateTrunk() {
        int i = basePos[0];
        int j = basePos[1];
        int k = basePos[1] + height;
        int l = basePos[2];
        int[] aint = new int[]{i, j, l};
        int[] aint1 = new int[]{i, k, l};
        this.generateTrunkColumn(aint, aint1, ModBlocks.blossom_log);
        if (this.trunkSize == 2) {
            int var10002 = aint[0]++;
            var10002 = aint1[0]++;
            this.generateTrunkColumn(aint, aint1, ModBlocks.blossom_log);
            var10002 = aint[2]++;
            var10002 = aint1[2]++;
            this.generateTrunkColumn(aint, aint1, ModBlocks.blossom_log);
            aint[0] += -1;
            aint1[0] += -1;
            this.generateTrunkColumn(aint, aint1, ModBlocks.blossom_log);
        }
    }

    void generateLeafNodeBases() {
        int i = 0;
        int j = this.leafNodes.length;

        for(int[] aint = new int[]{this.basePos[0], this.basePos[1], this.basePos[2]}; i < j; ++i) {
            int[] aint1 = this.leafNodes[i];
            int[] aint2 = new int[]{aint1[0], aint1[1], aint1[2]};
            aint[1] = aint1[3];
            int k = aint[1] - this.basePos[1];
            if (this.leafNodeNeedsBase(k)) {
                this.generateTrunkColumn(aint, aint2, ModBlocks.blossom_log);
            }
        }
    }

    int checkBlockLine(int[] p_76496_1_, int[] p_76496_2_) {
        int[] aint2 = new int[]{0, 0, 0};
        byte b0 = 0;

        byte b1;
        for(b1 = 0; b0 < 3; ++b0) {
            aint2[b0] = p_76496_2_[b0] - p_76496_1_[b0];
            if (Math.abs(aint2[b0]) > Math.abs(aint2[b1])) {
                b1 = b0;
            }
        }

        if (aint2[b1] == 0) {
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
            int[] aint3 = new int[]{0, 0, 0};
            int i = 0;

            int j;
            for(j = aint2[b1] + b4; i != j; i += b4) {
                aint3[b1] = p_76496_1_[b1] + i;
                aint3[b2] = MathHelper.floor_double((double)p_76496_1_[b2] + (double)i * d0);
                aint3[b3] = MathHelper.floor_double((double)p_76496_1_[b3] + (double)i * d1);
                this.worldObj.getBlock(aint3[0], aint3[1], aint3[2]);
                if (!this.isReplaceable(this.worldObj, aint3[0], aint3[1], aint3[2])) {
                    break;
                }
            }

            return i == j ? -1 : Math.abs(i);
        }
    }

    boolean validTreeLocation() {
        int[] aint = new int[]{this.basePos[0], this.basePos[1], this.basePos[2]};
        int[] aint1 = new int[]{this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2]};
        Block block = this.worldObj.getBlock(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
        boolean isSoil = block.canSustainPlant(this.worldObj, this.basePos[0], this.basePos[1] - 1, this.basePos[2], ForgeDirection.UP, (BlockSapling)ModBlocks.blossom_sapling);
        if (!isSoil) {
            return false;
        } else {
            int i = this.checkBlockLine(aint, aint1);
            if (i == -1) {
                return true;
            } else if (i < 6) {
                return false;
            } else {
                this.heightLimit = i;
                return true;
            }
        }
    }

    public void setScale(double p_76487_1_, double p_76487_3_, double p_76487_5_) {
        this.heightLimitLimit = (int)(p_76487_1_ * 12.0);
        if (p_76487_1_ > 0.5) {
            this.leafDistanceLimit = 5;
        }

        this.scaleWidth = p_76487_3_;
        this.leafDensity = p_76487_5_;
    }

    public boolean generate(World world, Random random, int x, int y, int z) {
        worldObj = world;
        long l = random.nextLong();
        rand.setSeed(l);
        basePos[0] = x;
        basePos[1] = y;
        basePos[2] = z;
        if (this.heightLimit == 0) {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }

        if (!this.validTreeLocation()) {
            worldObj = null;
            return false;
        } else {
            generateLeafNodeList();
            generateLeaves();
            generateTrunk();
            generateLeafNodeBases();
            worldObj = null;
            return true;
        }
    }
}
