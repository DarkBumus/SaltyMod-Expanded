package darkbum.saltymod.world.generator;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.SaltConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class SaltLakeGenerator implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.dimensionId == 0) {
            generateOverworld(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateOverworld(World world, Random rand, int X1, int Z1) {
        int radius = SaltConfig.saltLakeRadius;
        int originX = X1 + rand.nextInt(16);
        int originZ = Z1 + rand.nextInt(16);
        if(rand.nextInt(SaltConfig.saltLakeGroupRarity) != 0 || world.getBiomeGenForCoords(originX, originZ) == BiomeGenBase.swampland) {
            return;
        }
        for(int lake = 0; lake < SaltConfig.saltLakeQuantity; lake++) {
            for(int originY = 60; originY < 75; originY++) {
                Block other = world.getBlock(originX, originY, originZ);
                if((other instanceof BlockGrass || other == Blocks.stone || other == ModBlocks.salt_grass) &&
                    world.getBlock(originX - 2, originY, originZ).getMaterial().isSolid() &&
                    world.getBlock(originX + 2, originY, originZ).getMaterial().isSolid() &&
                    world.getBlock(originX, originY, originZ - 2).getMaterial().isSolid() &&
                    world.getBlock(originX, originY, originZ + 2).getMaterial().isSolid() &&
                    world.getBlock(originX, originY - 3, originZ).getMaterial().isSolid() &&
                    world.getFullBlockLightValue(originX, originY + 1, originZ) >= 13 &&
                    world.getFullBlockLightValue(originX - 2, originY + 1, originZ) >= 13 &&
                    world.getFullBlockLightValue(originX + 2, originY + 1, originZ) >= 13 &&
                    world.getFullBlockLightValue(originX, originY + 1, originZ - 2) >= 13 &&
                    world.getFullBlockLightValue(originX, originY + 1, originZ + 2) >= 13) {

                    world.setBlockToAir(originX, originY + 1, originZ);
                    world.setBlockToAir(originX, originY - 1, originZ);
                    world.setBlock(originX, originY - 2, originZ, ModBlocks.salt_lake_ore);
                    world.setBlock(originX, originY - 3, originZ, ModBlocks.salt_ore);
                    world.setBlock(originX, originY - 4, originZ, ModBlocks.salt_ore);
                    world.setBlock(originX, originY - 5, originZ, Blocks.stone);
                    world.setBlock(originX, originY - 6, originZ, Blocks.stone);
                    for(int i = 2; i <= radius; i++) {
                        int j;
                        for(j = originX - i; j <= originX + i; j++) {
                            for(int z = originZ - i; z <= originZ + i; z++) {
                                if (rand.nextInt(2) == 0 &&
                                    world.getBlock(j - 1, originY, z).getMaterial().isSolid() &&
                                    world.getBlock(j + 1, originY, z).getMaterial().isSolid() &&
                                    world.getBlock(j, originY, z - 1).getMaterial().isSolid() &&
                                    world.getBlock(j, originY, z + 1).getMaterial().isSolid() &&
                                    world.getBlock(j, originY - 3, z).getMaterial().isSolid() &&
                                    world.getFullBlockLightValue(j, originY + 1, z) >= 14 &&
                                    (world.getBlock(j - 1, originY - 2, z) == ModBlocks.salt_lake_ore ||
                                        world.getBlock(j + 1, originY - 2, z) == ModBlocks.salt_lake_ore ||
                                        world.getBlock(j, originY - 2, z - 1) == ModBlocks.salt_lake_ore ||
                                        world.getBlock(j, originY - 2, z + 1) == ModBlocks.salt_lake_ore)) {
                                    world.setBlockToAir(j, originY + 1, z);
                                    world.setBlockToAir(j, originY - 1, z);
                                    world.setBlock(j, originY - 2, z, ModBlocks.salt_block);
                                }
                            }
                        }
                        for (j = originX - i; j <= originX + i; j++) {
                            for (int z = originZ - i; z <= originZ + i; z++) {
                                if (world.getBlock(j, originY - 2, z) == ModBlocks.salt_block) {
                                    world.setBlock(j, originY - 2, z, ModBlocks.salt_lake_ore);
                                    world.setBlock(j, originY - 5, z, Blocks.stone);
                                    if (rand.nextInt(2) == 0) {
                                        world.setBlock(j, originY - 3, z, ModBlocks.salt_ore);
                                        world.setBlock(j, originY - 6, z, Blocks.stone);
                                        if (rand.nextInt(5) == 0) {
                                            world.setBlock(j, originY - 4, z, ModBlocks.salt_ore);
                                        } else {
                                            world.setBlock(j, originY - 4, z, Blocks.stone);
                                        }
                                    } else {
                                        world.setBlock(j, originY - 3, z, Blocks.stone);
                                    }
                                    if (world.getFullBlockLightValue(j, originY + 1, z) <= 14 && rand.nextInt(5) == 0)
                                        if (rand.nextInt(4) == 0) {
                                            world.setBlock(j, originY - 1, z, ModBlocks.salt_crystal, 1, 3);
                                        } else {
                                            world.setBlock(j, originY - 1, z, ModBlocks.salt_crystal, 2, 3);
                                        }
                                }
                            }
                        }
                    }
                    int x;
                    for (x = originX - radius; x <= originX + radius; x++) {
                        for (int z = originZ - radius; z <= originZ + radius; z++) {
                            if (world.getBlock(x, originY - 2, z) == ModBlocks.salt_lake_ore) {
                                world.setBlockToAir(x, originY, z);
                            } else {
                                int mask1 = 0;
                                if (world.getBlock(x, originY - 2, z - 1) == ModBlocks.salt_lake_ore)
                                    mask1++;
                                if (world.getBlock(x + 1, originY - 2, z) == ModBlocks.salt_lake_ore)
                                    mask1 += 2;
                                if (world.getBlock(x, originY - 2, z + 1) == ModBlocks.salt_lake_ore)
                                    mask1 += 4;
                                if (world.getBlock(x - 1, originY - 2, z) == ModBlocks.salt_lake_ore)
                                    mask1 += 8;
                                int mask2 = 0;
                                if (world.getBlock(x + 1, originY - 2, z - 1) == ModBlocks.salt_lake_ore)
                                    mask2++;
                                if (world.getBlock(x + 1, originY - 2, z + 1) == ModBlocks.salt_lake_ore)
                                    mask2 += 2;
                                if (world.getBlock(x - 1, originY - 2, z + 1) == ModBlocks.salt_lake_ore)
                                    mask2 += 4;
                                if (world.getBlock(x - 1, originY - 2, z - 1) == ModBlocks.salt_lake_ore)
                                    mask2 += 8;
                                int crustMeta = 0;
                                if (mask1 == 0 && mask2 == 1) {
                                    crustMeta = 3;
                                } else if (mask1 == 0 && mask2 == 2) {
                                    crustMeta = 4;
                                } else if (mask1 == 0 && mask2 == 4) {
                                    crustMeta = 5;
                                } else if (mask1 == 0 && mask2 == 8) {
                                    crustMeta = 6;
                                } else if ((mask1 == 0 && mask2 == 9) || (mask1 == 1 && (mask2 <= 1 || mask2 == 8 || mask2 == 9))) {
                                    crustMeta = 7;
                                } else if ((mask1 == 0 && mask2 == 3) || (mask1 == 2 && (mask2 <= 1 || mask2 == 2 || mask2 == 3))) {
                                    crustMeta = 8;
                                } else if ((mask1 == 0 && mask2 == 6) || (mask1 == 4 && (mask2 == 0 || mask2 == 2 || mask2 == 4 || mask2 == 6))) {
                                    crustMeta = 9;
                                } else if ((mask1 == 0 && mask2 == 12) || (mask1 == 8 && (mask2 == 0 || mask2 == 4 || mask2 == 8 || mask2 == 12))) {
                                    crustMeta = 10;
                                } else if ((mask1 == 0 && mask2 == 11) || (mask1 == 1 && (mask2 == 2 || mask2 == 3 || mask2 == 10 || mask2 == 11)) || (mask1 == 2 && mask2 >= 8 && mask2 <= 11) || (mask1 == 3 && ((mask2 >= 0 && mask2 <= 3) || (mask2 >= 8 && mask2 <= 11)))) {
                                    crustMeta = 11;
                                } else if ((mask1 == 0 && mask2 == 7) || (mask1 == 2 && mask2 >= 4 && mask2 <= 7) || (mask1 == 4 && (mask2 == 1 || mask2 == 3 || mask2 == 5 || mask2 == 7)) || (mask1 == 6 && ((mask2 >= 0 && mask2 <= 3) || (mask2 >= 4 && mask2 <= 7)))) {
                                    crustMeta = 12;
                                } else if ((mask1 == 0 && mask2 == 14) || (mask1 == 4 && (mask2 == 8 || mask2 == 10 || mask2 == 12 || mask2 == 14)) || (mask1 == 8 && (mask2 == 2 || mask2 == 6 || mask2 == 10 || mask2 == 14)) || (mask1 == 12 && (mask2 == 0 || mask2 == 2 || mask2 == 4 || mask2 == 6 || mask2 == 8 || mask2 == 10 || mask2 == 12 || mask2 == 14))) {
                                    crustMeta = 13;
                                } else if ((mask1 == 0 && mask2 == 13) || (mask1 == 1 && (mask2 == 4 || mask2 == 5 || mask2 == 12 || mask2 == 13)) || (mask1 == 8 && (mask2 == 1 || mask2 == 5 || mask2 == 9 || mask2 == 13)) || (mask1 == 9 && (mask2 == 0 || mask2 == 1 || mask2 == 4 || mask2 == 5 || mask2 == 8 || mask2 == 9 || mask2 == 12 || mask2 == 13))) {
                                    crustMeta = 14;
                                } else {
                                    crustMeta = 15;
                                }
                                if (mask1 > 0) {
                                    if (world.getBlock(x, originY - 2, z) != ModBlocks.salt_lake_dirt && world.getBlock(x, originY - 2, z) != ModBlocks.salt_dirt && world.getBlock(x, originY - 2, z) != ModBlocks.salt_ore)
                                        if (world.isAirBlock(x - 1, originY - 2, z) || world.isAirBlock(x + 1, originY - 2, z) || world
                                            .isAirBlock(x, originY - 2, z - 1) || world.isAirBlock(x, originY - 2, z + 1)) {
                                            world.setBlock(x, originY - 2, z, Blocks.stone);
                                        } else {
                                            world.setBlock(x, originY - 2, z, ModBlocks.salt_ore);
                                        }
                                    if (rand.nextInt(2) != 0)
                                        world.setBlock(x, originY - 3, z, Blocks.stone);
                                    if (world.getBlock(x, originY - 1, z) == Blocks.stone || world.getBlock(x, originY - 1, z) == Blocks.coal_ore ||
                                        world.getBlock(x, originY - 1, z) == Blocks.iron_ore || (world.getBlock(x, originY - 1, z) == ModBlocks.salt_ore && world.getBlockMetadata(x, originY - 1, z) == 0))
                                        world.setBlock(x, originY - 1, z, ModBlocks.salt_ore, mask1, 3);
                                    if (world.getBlock(x, originY - 1, z) instanceof BlockDirt || world.getBlock(x, originY - 1, z) == ModBlocks.mineral_mud) {
                                        world.setBlock(x, originY - 1, z, ModBlocks.salt_dirt, crustMeta, 3);
                                    }
                                    if (world.isAirBlock(x, originY - 1, z)) {
                                        int jld = 0;
                                        if (world.getBlock(x, originY - 3, z - 1) == ModBlocks.salt_lake_ore || world.getBlock(x, originY - 3, z - 1) == ModBlocks.salt_lake_dirt)
                                            jld++;
                                        if (world.getBlock(x + 1, originY - 3, z) == ModBlocks.salt_lake_ore || world.getBlock(x + 1, originY - 3, z) == ModBlocks.salt_lake_dirt)
                                            jld += 2;
                                        if (world.getBlock(x, originY - 3, z + 1) == ModBlocks.salt_lake_ore || world.getBlock(x, originY - 3, z + 1) == ModBlocks.salt_lake_dirt)
                                            jld += 4;
                                        if (world.getBlock(x - 1, originY - 3, z) == ModBlocks.salt_lake_ore || world.getBlock(x - 1, originY - 3, z) == ModBlocks.salt_lake_dirt)
                                            jld += 8;
                                        if (jld > 0) {
                                            world.setBlock(x, originY - 2, z, ModBlocks.salt_lake_ore, jld, 3);
                                        } else {
                                            world.setBlock(x, originY - 2, z, ModBlocks.salt_lake_dirt, 1, 3);
                                        }
                                    }
                                    if(world.getFullBlockLightValue(x, originY + 1, z) >= 12) {
                                        if(world.getBlock(x - 1, originY - 1, z) == ModBlocks.salt_lake_ore ||
                                            world.getBlock(x + 1, originY - 1, z) == ModBlocks.salt_lake_ore ||
                                            world.getBlock(x, originY - 1, z - 1) == ModBlocks.salt_lake_ore ||
                                            world.getBlock(x, originY - 1, z + 1) == ModBlocks.salt_lake_ore ||
                                            world.getBlock(x - 1, originY - 1, z) == ModBlocks.salt_lake_dirt ||
                                            world.getBlock(x + 1, originY - 1, z) == ModBlocks.salt_lake_dirt ||
                                            world.getBlock(x, originY - 1, z - 1) == ModBlocks.salt_lake_dirt ||
                                            world.getBlock(x, originY - 1, z + 1) == ModBlocks.salt_lake_dirt) {
                                            int jl = 0;
                                            if (world.getBlock(x, originY - 2, z - 1) == ModBlocks.salt_lake_ore || world.getBlock(x, originY - 2, z - 1) == ModBlocks.salt_lake_dirt)
                                                jl++;
                                            if (world.getBlock(x + 1, originY - 2, z) == ModBlocks.salt_lake_ore || world.getBlock(x + 1, originY - 2, z) == ModBlocks.salt_lake_dirt)
                                                jl += 2;
                                            if (world.getBlock(x, originY - 2, z + 1) == ModBlocks.salt_lake_ore || world.getBlock(x, originY - 2, z + 1) == ModBlocks.salt_lake_dirt)
                                                jl += 4;
                                            if (world.getBlock(x - 1, originY - 2, z) == ModBlocks.salt_lake_ore || world.getBlock(x - 1, originY - 2, z) == ModBlocks.salt_lake_dirt)
                                                jl += 8;
                                            world.setBlock(x, originY - 1, z, ModBlocks.salt_lake_ore, jl, 3);
                                        }
                                        if (!(world.getBlock(x - 1, originY, z).getMaterial() instanceof MaterialLiquid) &&
                                            !(world.getBlock(x + 1, originY, z).getMaterial() instanceof MaterialLiquid) &&
                                            !(world.getBlock(x, originY, z - 1).getMaterial() instanceof MaterialLiquid) &&
                                            !(world.getBlock(x, originY, z + 1).getMaterial() instanceof MaterialLiquid)) {
                                            if (world.getBlock(x, originY - 1, z) == ModBlocks.salt_dirt && (world.getBlock(x, originY, z) instanceof BlockGrass) || world.getBlock(x, originY, z) == ModBlocks.salt_grass) {
                                                world.setBlock(x, originY - 1, z, ModBlocks.salt_grass, crustMeta, 3);
                                            }
                                            world.setBlockToAir(x, originY + 1, z);
                                            world.setBlockToAir(x, originY, z);
                                            other = world.getBlock(x, originY - 1, z);
                                            if (rand.nextInt(10) == 0 && (other == ModBlocks.salt_grass || other == ModBlocks.salt_dirt)) {
                                                world.setBlock(x, originY, z, ModBlocks.saltworts, 4, 3);
                                            }
                                        }
                                    } else if (world.getFullBlockLightValue(x, originY + 2, z) >= 12 &&
                                        rand.nextInt(2) == 0 &&
                                        !(world.getBlock(x - 1, originY + 1, z).getMaterial() instanceof MaterialLiquid) &&
                                        !(world.getBlock(x + 1, originY + 1, z).getMaterial() instanceof MaterialLiquid) &&
                                        !(world.getBlock(x, originY + 1, z - 1).getMaterial() instanceof MaterialLiquid) &&
                                        !(world.getBlock(x, originY + 1, z + 1).getMaterial() instanceof MaterialLiquid)) {
                                        if (world.getBlock(x, originY, z) instanceof BlockDirt || world.getBlock(x, originY, z) == ModBlocks.mineral_mud) {
                                            world.setBlock(x, originY, z, world.getBlock(x, originY + 1, z));
                                        } else if (world.getBlock(x, originY, z) == ModBlocks.salt_dirt) {
                                            world.setBlock(x, originY, z, ModBlocks.salt_grass, world.getBlockMetadata(x, originY, z), 3);
                                        }
                                        world.setBlockToAir(x, originY + 2, z);
                                        world.setBlockToAir(x, originY + 1, z);
                                    }
                                } else if (mask2 > 0) {
                                    if (world.getBlock(x, originY - 1, z).getMaterial().isSolid() && world.getBlock(x, originY - 2, z) != ModBlocks.salt_dirt && world.getBlock(x, originY - 2, z) != ModBlocks.salt_ore) {
                                        world.setBlock(x, originY - 2, z, Blocks.stone);
                                    }
                                    if (world.getBlock(x, originY - 1, z) instanceof BlockGrass || world.getBlock(x, originY - 1, z) == ModBlocks.salt_grass) {
                                        world.setBlockToAir(x, originY, z);
                                        world.setBlock(x, originY - 1, z, ModBlocks.salt_grass, crustMeta, 3);
                                    } else if (world.getBlock(x, originY - 1, z) instanceof BlockDirt || world.getBlock(x, originY - 1, z) == ModBlocks.mineral_mud) {
                                        world.setBlock(x, originY - 1, z, ModBlocks.salt_dirt, crustMeta, 3);
                                    }
                                }
                            }
                        }
                    }
                    for(x = originX - radius; x <= originX + radius; x++) {
                        for(int z = originZ - radius; z <= originZ + radius; z++) {
                            if (world.getBlock(x, originY - 2, z) == ModBlocks.salt_lake_ore &&
                                rand.nextInt(3) == 0) {
                                world.setBlock(x, originY - 2, z, ModBlocks.salt_lake_dirt, 1, 3);
                                world.setBlock(x, originY - 3, z, ModBlocks.mineral_mud);
                            }
                            other = world.getBlock(x, originY - 1, z);
                            if ((other == ModBlocks.salt_grass || other == ModBlocks.salt_dirt) &&
                                world.isAirBlock(x, originY, z) && ((
                                world.getBlock(x - 1, originY, z) == ModBlocks.saltworts && world.getBlockMetadata(x - 1, originY, z) == 4) ||
                                (world.getBlock(x + 1, originY, z) == ModBlocks.saltworts && world.getBlockMetadata(x + 1, originY, z) == 4) ||
                                (world.getBlock(x, originY, z - 1) == ModBlocks.saltworts && world.getBlockMetadata(x, originY, z - 1) == 4) ||
                                (world.getBlock(x, originY, z + 1) == ModBlocks.saltworts && world.getBlockMetadata(x, originY, z + 1) == 4)) && rand.nextInt(2) == 0) {
                                world.setBlock(x, originY, z, ModBlocks.saltworts, rand.nextInt(2) + 2, 3);
                            }
                        }
                    }
                }
            }
            originX = originX + rand.nextInt(SaltConfig.saltLakeDistance) - SaltConfig.saltLakeDistance / 2;
            originZ = originZ + rand.nextInt(SaltConfig.saltLakeDistance) - SaltConfig.saltLakeDistance / 2;
        }
    }

}
