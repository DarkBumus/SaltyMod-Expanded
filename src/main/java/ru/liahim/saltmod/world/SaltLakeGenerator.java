package ru.liahim.saltmod.world;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.SaltConfig;

public class SaltLakeGenerator implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                generateOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    public void generateOverworld(World world, Random rand, int X1, int Z1) {
        if (!world.isRemote) {
            int rad = SaltConfig.saltLakeRadius;
            int randPosX = X1 + rand.nextInt(16);
            int randPosZ = Z1 + rand.nextInt(16);
            if (rand.nextInt(SaltConfig.saltLakeGroupRarity) == 0 && world
                .getBiomeGenForCoords(randPosX, randPosZ) != BiomeGenBase.swampland)
                for (int G = 0; G < SaltConfig.saltLakeQuantity; G++) {
                    for (int randPosY = 60; randPosY < 75; randPosY++) {
                        if ((world.getBlock(randPosX, randPosY, randPosZ) instanceof BlockGrass ||
                            world.getBlock(randPosX, randPosY, randPosZ) == Blocks.stone ||
                            world.getBlock(randPosX, randPosY, randPosZ) == ModBlocks.saltGrass) &&
                            world.getBlock(randPosX - 2, randPosY, randPosZ).getMaterial().isSolid() &&
                            world.getBlock(randPosX + 2, randPosY, randPosZ).getMaterial().isSolid() &&
                            world.getBlock(randPosX, randPosY, randPosZ - 2).getMaterial().isSolid() &&
                            world.getBlock(randPosX, randPosY, randPosZ + 2).getMaterial().isSolid() &&
                            world.getBlock(randPosX, randPosY - 3, randPosZ).getMaterial().isSolid() &&
                            world.getFullBlockLightValue(randPosX, randPosY + 1, randPosZ) >= 13 &&
                            world.getFullBlockLightValue(randPosX - 2, randPosY + 1, randPosZ) >= 13 &&
                            world.getFullBlockLightValue(randPosX + 2, randPosY + 1, randPosZ) >= 13 &&
                            world.getFullBlockLightValue(randPosX, randPosY + 1, randPosZ - 2) >= 13 &&
                            world.getFullBlockLightValue(randPosX, randPosY + 1, randPosZ + 2) >= 13) {
                            world.setBlockToAir(randPosX, randPosY + 1, randPosZ);
                            world.setBlockToAir(randPosX, randPosY - 1, randPosZ);
                            world.setBlock(randPosX, randPosY - 2, randPosZ, ModBlocks.saltLake);
                            world.setBlock(randPosX, randPosY - 3, randPosZ, ModBlocks.saltOre);
                            world.setBlock(randPosX, randPosY - 4, randPosZ, ModBlocks.saltOre);
                            world.setBlock(randPosX, randPosY - 5, randPosZ, Blocks.stone);
                            world.setBlock(randPosX, randPosY - 6, randPosZ, Blocks.stone);
                            for (int i = 2; i <= rad; i++) {
                                int j;
                                for (j = randPosX - i; j <= randPosX + i; j++) {
                                    for (int z = randPosZ - i; z <= randPosZ + i; z++) {
                                        if (rand.nextInt(2) == 0 &&
                                            world.getBlock(j - 1, randPosY, z).getMaterial().isSolid() &&
                                            world.getBlock(j + 1, randPosY, z).getMaterial().isSolid() &&
                                            world.getBlock(j, randPosY, z - 1).getMaterial().isSolid() &&
                                            world.getBlock(j, randPosY, z + 1).getMaterial().isSolid() &&
                                            world.getBlock(j, randPosY - 3, z).getMaterial().isSolid() &&
                                            world.getFullBlockLightValue(j, randPosY + 1, z) >= 14 &&
                                            (world.getBlock(j - 1, randPosY - 2, z) == ModBlocks.saltLake ||
                                                world.getBlock(j + 1, randPosY - 2, z) == ModBlocks.saltLake ||
                                                world.getBlock(j, randPosY - 2, z - 1) == ModBlocks.saltLake ||
                                                world.getBlock(j, randPosY - 2, z + 1) == ModBlocks.saltLake)) {
                                            world.setBlockToAir(j, randPosY + 1, z);
                                            world.setBlockToAir(j, randPosY - 1, z);
                                            world.setBlock(j, randPosY - 2, z, ModBlocks.saltBlock);
                                        }
                                    }
                                }
                                for (j = randPosX - i; j <= randPosX + i; j++) {
                                    for (int z = randPosZ - i; z <= randPosZ + i; z++) {
                                        if (world.getBlock(j, randPosY - 2, z) == ModBlocks.saltBlock) {
                                            world.setBlock(j, randPosY - 2, z, ModBlocks.saltLake);
                                            world.setBlock(j, randPosY - 5, z, Blocks.stone);
                                            if (rand.nextInt(2) == 0) {
                                                world.setBlock(j, randPosY - 3, z, ModBlocks.saltOre);
                                                world.setBlock(j, randPosY - 6, z, Blocks.stone);
                                                if (rand.nextInt(5) == 0) {
                                                    world.setBlock(j, randPosY - 4, z, ModBlocks.saltOre);
                                                } else {
                                                    world.setBlock(j, randPosY - 4, z, Blocks.stone);
                                                }
                                            } else {
                                                world.setBlock(j, randPosY - 3, z, Blocks.stone);
                                            }
                                            if (world.getFullBlockLightValue(j, randPosY + 1, z) <= 14 && rand.nextInt(5) == 0)
                                                if (rand.nextInt(4) == 0) {
                                                    world.setBlock(j, randPosY - 1, z, ModBlocks.saltCrystal, 1, 3);
                                                } else {
                                                    world.setBlock(j, randPosY - 1, z, ModBlocks.saltCrystal, 2, 3);
                                                }
                                        }
                                    }
                                }
                            }
                            int x;
                            for (x = randPosX - rad; x <= randPosX + rad; x++) {
                                for (int z = randPosZ - rad; z <= randPosZ + rad; z++) {
                                    if (world.getBlock(x, randPosY - 2, z) == ModBlocks.saltLake) {
                                        world.setBlockToAir(x, randPosY, z);
                                    } else {
                                        int jf = 0;
                                        if (world.getBlock(x, randPosY - 2, z - 1) == ModBlocks.saltLake)
                                            jf++;
                                        if (world.getBlock(x + 1, randPosY - 2, z) == ModBlocks.saltLake)
                                            jf += 2;
                                        if (world.getBlock(x, randPosY - 2, z + 1) == ModBlocks.saltLake)
                                            jf += 4;
                                        if (world.getBlock(x - 1, randPosY - 2, z) == ModBlocks.saltLake)
                                            jf += 8;
                                        int jc = 0;
                                        if (world.getBlock(x + 1, randPosY - 2, z - 1) == ModBlocks.saltLake)
                                            jc++;
                                        if (world.getBlock(x + 1, randPosY - 2, z + 1) == ModBlocks.saltLake)
                                            jc += 2;
                                        if (world.getBlock(x - 1, randPosY - 2, z + 1) == ModBlocks.saltLake)
                                            jc += 4;
                                        if (world.getBlock(x - 1, randPosY - 2, z - 1) == ModBlocks.saltLake)
                                            jc += 8;
                                        int j = 0;
                                        if (jf == 0 && jc == 1) {
                                            j = 3;
                                        } else if (jf == 0 && jc == 2) {
                                            j = 4;
                                        } else if (jf == 0 && jc == 4) {
                                            j = 5;
                                        } else if (jf == 0 && jc == 8) {
                                            j = 6;
                                        } else if ((jf == 0 && jc == 9) || (jf == 1 && (jc == 0 || jc == 1 || jc == 8 || jc == 9))) {
                                            j = 7;
                                        } else if ((jf == 0 && jc == 3) || (jf == 2 && (jc == 0 || jc == 1 || jc == 2 || jc == 3))) {
                                            j = 8;
                                        } else if ((jf == 0 && jc == 6) || (jf == 4 && (jc == 0 || jc == 2 || jc == 4 || jc == 6))) {
                                            j = 9;
                                        } else if ((jf == 0 && jc == 12) || (jf == 8 && (jc == 0 || jc == 4 || jc == 8 || jc == 12))) {
                                            j = 10;
                                        } else if ((jf == 0 && jc == 11) || (jf == 1 && (jc == 2 || jc == 3 || jc == 10 || jc == 11)) || (jf == 2 && jc >= 8 && jc <= 11) || (jf == 3 && ((jc >= 0 && jc <= 3) || (jc >= 8 && jc <= 11)))) {
                                            j = 11;
                                        } else if ((jf == 0 && jc == 7) || (jf == 2 && jc >= 4 && jc <= 7) || (jf == 4 && (jc == 1 || jc == 3 || jc == 5 || jc == 7)) || (jf == 6 && ((jc >= 0 && jc <= 3) || (jc >= 4 && jc <= 7)))) {
                                            j = 12;
                                        } else if ((jf == 0 && jc == 14) || (jf == 4 && (jc == 8 || jc == 10 || jc == 12 || jc == 14)) || (jf == 8 && (jc == 2 || jc == 6 || jc == 10 || jc == 14)) || (jf == 12 && (jc == 0 || jc == 2 || jc == 4 || jc == 6 || jc == 8 || jc == 10 || jc == 12 || jc == 14))) {
                                            j = 13;
                                        } else if ((jf == 0 && jc == 13) || (jf == 1 && (jc == 4 || jc == 5 || jc == 12 || jc == 13)) || (jf == 8 && (jc == 1 || jc == 5 || jc == 9 || jc == 13)) || (jf == 9 && (jc == 0 || jc == 1 || jc == 4 || jc == 5 || jc == 8 || jc == 9 || jc == 12 || jc == 13))) {
                                            j = 14;
                                        } else {
                                            j = 15;
                                        }
                                        if (jf > 0) {
                                            if (world.getBlock(x, randPosY - 2, z) != ModBlocks.saltDirt && world.getBlock(x, randPosY - 2, z) != ModBlocks.saltDirtLite && world.getBlock(x, randPosY - 2, z) != ModBlocks.saltOre)
                                                if (world.isAirBlock(x - 1, randPosY - 2, z) || world.isAirBlock(x + 1, randPosY - 2, z) || world
                                                    .isAirBlock(x, randPosY - 2, z - 1) || world.isAirBlock(x, randPosY - 2, z + 1)) {
                                                    world.setBlock(x, randPosY - 2, z, Blocks.stone);
                                                } else {
                                                    world.setBlock(x, randPosY - 2, z, ModBlocks.saltOre);
                                                }
                                            if (rand.nextInt(2) != 0)
                                                world.setBlock(x, randPosY - 3, z, Blocks.stone);
                                            if (world.getBlock(x, randPosY - 1, z) == Blocks.stone || world.getBlock(x, randPosY - 1, z) == Blocks.coal_ore ||
                                                world.getBlock(x, randPosY - 1, z) == Blocks.iron_ore || (world.getBlock(x, randPosY - 1, z) == ModBlocks.saltOre && world.getBlockMetadata(x, randPosY - 1, z) == 0))
                                                world.setBlock(x, randPosY - 1, z, ModBlocks.saltOre, jf, 3);
                                            if (world.getBlock(x, randPosY - 1, z) instanceof BlockDirt || world.getBlock(x, randPosY - 1, z) == ModBlocks.mudBlock)
                                                world.setBlock(x, randPosY - 1, z, ModBlocks.saltDirtLite, j, 3);
                                            if (world.isAirBlock(x, randPosY - 1, z)) {
                                                int jld = 0;
                                                if (world.getBlock(x, randPosY - 3, z - 1) == ModBlocks.saltLake || world.getBlock(x, randPosY - 3, z - 1) == ModBlocks.saltDirt)
                                                    jld++;
                                                if (world.getBlock(x + 1, randPosY - 3, z) == ModBlocks.saltLake || world.getBlock(x + 1, randPosY - 3, z) == ModBlocks.saltDirt)
                                                    jld += 2;
                                                if (world.getBlock(x, randPosY - 3, z + 1) == ModBlocks.saltLake || world.getBlock(x, randPosY - 3, z + 1) == ModBlocks.saltDirt)
                                                    jld += 4;
                                                if (world.getBlock(x - 1, randPosY - 3, z) == ModBlocks.saltLake || world.getBlock(x - 1, randPosY - 3, z) == ModBlocks.saltDirt)
                                                    jld += 8;
                                                if (jld > 0) {
                                                    world.setBlock(x, randPosY - 2, z, ModBlocks.saltLake, jld, 3);
                                                } else {
                                                    world.setBlock(x, randPosY - 2, z, ModBlocks.saltDirt, 1, 3);
                                                }
                                            }
                                            if (world.getFullBlockLightValue(x, randPosY + 1, z) >= 12) {
                                                if (world.getBlock(x - 1, randPosY - 1, z) == ModBlocks.saltLake ||
                                                    world.getBlock(x + 1, randPosY - 1, z) == ModBlocks.saltLake ||
                                                    world.getBlock(x, randPosY - 1, z - 1) == ModBlocks.saltLake ||
                                                    world.getBlock(x, randPosY - 1, z + 1) == ModBlocks.saltLake ||
                                                    world.getBlock(x - 1, randPosY - 1, z) == ModBlocks.saltDirt ||
                                                    world.getBlock(x + 1, randPosY - 1, z) == ModBlocks.saltDirt ||
                                                    world.getBlock(x, randPosY - 1, z - 1) == ModBlocks.saltDirt ||
                                                    world.getBlock(x, randPosY - 1, z + 1) == ModBlocks.saltDirt) {
                                                    int jl = 0;
                                                    if (world.getBlock(x, randPosY - 2, z - 1) == ModBlocks.saltLake || world.getBlock(x, randPosY - 2, z - 1) == ModBlocks.saltDirt)
                                                        jl++;
                                                    if (world.getBlock(x + 1, randPosY - 2, z) == ModBlocks.saltLake || world.getBlock(x + 1, randPosY - 2, z) == ModBlocks.saltDirt)
                                                        jl += 2;
                                                    if (world.getBlock(x, randPosY - 2, z + 1) == ModBlocks.saltLake || world.getBlock(x, randPosY - 2, z + 1) == ModBlocks.saltDirt)
                                                        jl += 4;
                                                    if (world.getBlock(x - 1, randPosY - 2, z) == ModBlocks.saltLake || world.getBlock(x - 1, randPosY - 2, z) == ModBlocks.saltDirt)
                                                        jl += 8;
                                                    world.setBlock(x, randPosY - 1, z, ModBlocks.saltLake, jl, 3);
                                                }
                                                if (world.getBlock(x - 1, randPosY, z).getMaterial() != Material.water &&
                                                    world.getBlock(x + 1, randPosY, z).getMaterial() != Material.water &&
                                                    world.getBlock(x, randPosY, z - 1).getMaterial() != Material.water &&
                                                    world.getBlock(x, randPosY, z + 1).getMaterial() != Material.water &&
                                                    world.getBlock(x - 1, randPosY, z).getMaterial() != Material.lava &&
                                                    world.getBlock(x + 1, randPosY, z).getMaterial() != Material.lava &&
                                                    world.getBlock(x, randPosY, z - 1).getMaterial() != Material.lava &&
                                                    world.getBlock(x, randPosY, z + 1).getMaterial() != Material.lava) {
                                                    if (world.getBlock(x, randPosY - 1, z) == ModBlocks.saltDirtLite &&
                                                        (world.getBlock(x, randPosY, z) instanceof BlockGrass) || world.getBlock(x, randPosY, z) == ModBlocks.saltGrass)
                                                        world.setBlock(x, randPosY - 1, z, ModBlocks.saltGrass, j, 3);
                                                    world.setBlockToAir(x, randPosY + 1, z);
                                                    world.setBlockToAir(x, randPosY, z);
                                                    if (rand.nextInt(10) == 0 && (world.getBlock(x, randPosY - 1, z) == ModBlocks.saltGrass ||
                                                        world.getBlock(x, randPosY - 1, z) == ModBlocks.saltDirtLite))
                                                        world.setBlock(x, randPosY, z, ModBlocks.saltWort, 4, 3);
                                                }
                                            } else if (world.getFullBlockLightValue(x, randPosY + 2, z) >= 12 &&
                                                rand.nextInt(2) == 0 && world.getBlock(x - 1, randPosY + 1, z).getMaterial() != Material.water &&
                                                world.getBlock(x + 1, randPosY + 1, z).getMaterial() != Material.water &&
                                                world.getBlock(x, randPosY + 1, z - 1).getMaterial() != Material.water &&
                                                world.getBlock(x, randPosY + 1, z + 1).getMaterial() != Material.water &&
                                                world.getBlock(x - 1, randPosY + 1, z).getMaterial() != Material.lava &&
                                                world.getBlock(x + 1, randPosY + 1, z).getMaterial() != Material.lava &&
                                                world.getBlock(x, randPosY + 1, z - 1).getMaterial() != Material.lava &&
                                                world.getBlock(x, randPosY + 1, z + 1).getMaterial() != Material.lava) {
                                                if (world.getBlock(x, randPosY, z) instanceof BlockDirt || world.getBlock(x, randPosY, z) == ModBlocks.mudBlock) {
                                                    world.setBlock(x, randPosY, z, world.getBlock(x, randPosY + 1, z));
                                                } else if (world.getBlock(x, randPosY, z) == ModBlocks.saltDirtLite) {
                                                    world.setBlock(x, randPosY, z, ModBlocks.saltGrass, world.getBlockMetadata(x, randPosY, z), 3);
                                                }
                                                world.setBlockToAir(x, randPosY + 2, z);
                                                world.setBlockToAir(x, randPosY + 1, z);
                                            }
                                        } else if (jc > 0) {
                                            if (world.getBlock(x, randPosY - 1, z).getMaterial().isSolid() && world.getBlock(x, randPosY - 2, z) != ModBlocks.saltDirtLite && world.getBlock(x, randPosY - 2, z) != ModBlocks.saltOre)
                                                world.setBlock(x, randPosY - 2, z, Blocks.stone);
                                            if (world.getBlock(x, randPosY - 1, z) instanceof BlockGrass || world.getBlock(x, randPosY - 1, z) == ModBlocks.saltGrass) {
                                                world.setBlockToAir(x, randPosY, z);
                                                world.setBlock(x, randPosY - 1, z, ModBlocks.saltGrass, j, 3);
                                            } else if (world.getBlock(x, randPosY - 1, z) instanceof BlockDirt || world.getBlock(x, randPosY - 1, z) == ModBlocks.mudBlock) {
                                                world.setBlock(x, randPosY - 1, z, ModBlocks.saltDirtLite, j, 3);
                                            }
                                        }
                                    }
                                }
                            }
                            for (x = randPosX - rad; x <= randPosX + rad; x++) {
                                for (int z = randPosZ - rad; z <= randPosZ + rad; z++) {
                                    if (world.getBlock(x, randPosY - 2, z) == ModBlocks.saltLake &&
                                        rand.nextInt(3) == 0) {
                                        world.setBlock(x, randPosY - 2, z, ModBlocks.saltDirt, 1, 3);
                                        world.setBlock(x, randPosY - 3, z, ModBlocks.mudBlock);
                                    }
                                    if ((world.getBlock(x, randPosY - 1, z) == ModBlocks.saltGrass || world.getBlock(x, randPosY - 1, z) == ModBlocks.saltDirtLite) &&
                                        world.isAirBlock(x, randPosY, z) && ((
                                        world.getBlock(x - 1, randPosY, z) == ModBlocks.saltWort && world.getBlockMetadata(x - 1, randPosY, z) == 4) ||
                                        (world.getBlock(x + 1, randPosY, z) == ModBlocks.saltWort && world.getBlockMetadata(x + 1, randPosY, z) == 4) ||
                                        (world.getBlock(x, randPosY, z - 1) == ModBlocks.saltWort && world.getBlockMetadata(x, randPosY, z - 1) == 4) ||
                                        (world.getBlock(x, randPosY, z + 1) == ModBlocks.saltWort && world.getBlockMetadata(x, randPosY, z + 1) == 4)) && rand.nextInt(2) == 0)
                                        world.setBlock(x, randPosY, z, ModBlocks.saltWort, rand.nextInt(2) + 2, 3);
                                }
                            }
                        }
                    }
                    randPosX = randPosX + rand.nextInt(SaltConfig.saltLakeDistance) - SaltConfig.saltLakeDistance / 2;
                    randPosZ = randPosZ + rand.nextInt(SaltConfig.saltLakeDistance) - SaltConfig.saltLakeDistance / 2;
                }
        }
    }
}
