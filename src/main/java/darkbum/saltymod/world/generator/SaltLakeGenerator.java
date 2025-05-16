package darkbum.saltymod.world.generator;

import java.util.Random;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModBlocks;

public class SaltLakeGenerator implements IWorldGenerator {

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
        IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            generateOverworld(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateOverworld(World world, Random random, int chunkX, int chunkZ) {
        if (!world.isRemote) {
            int lakeRadius = ModConfigurationWorldGeneration.saltLakeRadius;
            int startX = chunkX + random.nextInt(16);
            int startZ = chunkZ + random.nextInt(16);
            if (random.nextInt(ModConfigurationWorldGeneration.saltLakeFrequency) == 0
                && world.getBiomeGenForCoords(startX, startZ) != BiomeGenBase.swampland)

                for (int lakeAttempt = 0; lakeAttempt < ModConfigurationWorldGeneration.saltLakeQuantity; lakeAttempt++) {

                    for (int y = 60; y < 75; y++) {
                        if ((world.getBlock(startX, y, startZ) instanceof BlockGrass
                            || world.getBlock(startX, y, startZ) == Blocks.stone
                            || world.getBlock(startX, y, startZ) == ModBlocks.salt_grass)
                            && world.getBlock(startX - 2, y, startZ).getMaterial().isSolid()
                            && world.getBlock(startX + 2, y, startZ).getMaterial().isSolid()
                            && world.getBlock(startX, y, startZ - 2).getMaterial().isSolid()
                            && world.getBlock(startX, y, startZ + 2).getMaterial().isSolid()
                            && world.getBlock(startX, y - 3, startZ).getMaterial().isSolid()
                            && world.getFullBlockLightValue(startX, y + 1, startZ) >= 13
                            && world.getFullBlockLightValue(startX - 2, y + 1, startZ) >= 13
                            && world.getFullBlockLightValue(startX + 2, y + 1, startZ) >= 13
                            && world.getFullBlockLightValue(startX, y + 1, startZ - 2) >= 13
                            && world.getFullBlockLightValue(startX, y + 1, startZ + 2) >= 13) {
                            world.setBlockToAir(startX, y + 1, startZ);
                            world.setBlockToAir(startX, y - 1, startZ);
                            world.setBlock(startX, y - 2, startZ, ModBlocks.salt_lake);
                            world.setBlock(startX, y - 3, startZ, ModBlocks.salt_ore);
                            world.setBlock(startX, y - 4, startZ, ModBlocks.salt_ore);
                            world.setBlock(startX, y - 5, startZ, Blocks.stone);
                            world.setBlock(startX, y - 6, startZ, Blocks.stone);
                            for (int i = 2; i <= lakeRadius; i++) {
                                int j;
                                for (j = startX - i; j <= startX + i; j++) {
                                    for (int z = startZ - i; z <= startZ + i; z++) {
                                        if (random.nextInt(2) == 0 && world.getBlock(j - 1, y, z).getMaterial().isSolid()
                                            && world.getBlock(j + 1, y, z).getMaterial().isSolid()
                                            && world.getBlock(j, y, z - 1).getMaterial().isSolid()
                                            && world.getBlock(j, y, z + 1).getMaterial().isSolid()
                                            && world.getBlock(j, y - 3, z).getMaterial().isSolid()
                                            && world.getFullBlockLightValue(j, y + 1, z) >= 14
                                            && (world.getBlock(j - 1, y - 2, z) == ModBlocks.salt_lake
                                                || world.getBlock(j + 1, y - 2, z) == ModBlocks.salt_lake
                                                || world.getBlock(j, y - 2, z - 1) == ModBlocks.salt_lake
                                                || world.getBlock(j, y - 2, z + 1) == ModBlocks.salt_lake)) {
                                            world.setBlockToAir(j, y + 1, z);
                                            world.setBlockToAir(j, y - 1, z);
                                            world.setBlock(j, y - 2, z, ModBlocks.salt_block);
                                        }
                                    }
                                }
                                for (j = startX - i; j <= startX + i; j++) {
                                    for (int z = startZ - i; z <= startZ + i; z++) {
                                        if (world.getBlock(j, y - 2, z) == ModBlocks.salt_block) {
                                            world.setBlock(j, y - 2, z, ModBlocks.salt_lake);
                                            world.setBlock(j, y - 5, z, Blocks.stone);
                                            if (random.nextInt(2) == 0) {
                                                world.setBlock(j, y - 3, z, ModBlocks.salt_ore);
                                                world.setBlock(j, y - 6, z, Blocks.stone);
                                                if (random.nextInt(5) == 0) {
                                                    world.setBlock(j, y - 4, z, ModBlocks.salt_ore);
                                                } else {
                                                    world.setBlock(j, y - 4, z, Blocks.stone);
                                                }
                                            } else {
                                                world.setBlock(j, y - 3, z, Blocks.stone);
                                            }
                                            if (world.getFullBlockLightValue(j, y + 1, z) <= 14
                                                && random.nextInt(5) == 0) if (random.nextInt(4) == 0) {
                                                    world.setBlock(j, y - 1, z, ModBlocks.salt_crystal, 1, 3);
                                                } else {
                                                    world.setBlock(j, y - 1, z, ModBlocks.salt_crystal, 2, 3);
                                                }
                                        }
                                    }
                                }
                            }
                            int x;
                            for (x = startX - lakeRadius; x <= startX + lakeRadius; x++) {
                                for (int z = startZ - lakeRadius; z <= startZ + lakeRadius; z++) {
                                    if (world.getBlock(x, y - 2, z) == ModBlocks.salt_lake) {
                                        world.setBlockToAir(x, y, z);
                                    } else {
                                        int horizontalAdjacentFlags = 0;
                                        if (world.getBlock(x, y - 2, z - 1) == ModBlocks.salt_lake) horizontalAdjacentFlags++;
                                        if (world.getBlock(x + 1, y - 2, z) == ModBlocks.salt_lake) horizontalAdjacentFlags += 2;
                                        if (world.getBlock(x, y - 2, z + 1) == ModBlocks.salt_lake) horizontalAdjacentFlags += 4;
                                        if (world.getBlock(x - 1, y - 2, z) == ModBlocks.salt_lake) horizontalAdjacentFlags += 8;
                                        int diagonalAdjacentFlags = 0;
                                        if (world.getBlock(x + 1, y - 2, z - 1) == ModBlocks.salt_lake) diagonalAdjacentFlags++;
                                        if (world.getBlock(x + 1, y - 2, z + 1) == ModBlocks.salt_lake) diagonalAdjacentFlags += 2;
                                        if (world.getBlock(x - 1, y - 2, z + 1) == ModBlocks.salt_lake) diagonalAdjacentFlags += 4;
                                        if (world.getBlock(x - 1, y - 2, z - 1) == ModBlocks.salt_lake) diagonalAdjacentFlags += 8;
                                        int j = getJ(horizontalAdjacentFlags, diagonalAdjacentFlags);
                                        if (horizontalAdjacentFlags > 0) {
                                            if (world.getBlock(x, y - 2, z) != ModBlocks.salt_dirt
                                                && world.getBlock(x, y - 2, z) != ModBlocks.salt_dirt_lite
                                                && world.getBlock(x, y - 2, z) != ModBlocks.salt_ore)
                                                if (world.isAirBlock(x - 1, y - 2, z)
                                                    || world.isAirBlock(x + 1, y - 2, z)
                                                    || world.isAirBlock(x, y - 2, z - 1)
                                                    || world.isAirBlock(x, y - 2, z + 1)) {
                                                        world.setBlock(x, y - 2, z, Blocks.stone);
                                                    } else {
                                                        world.setBlock(x, y - 2, z, ModBlocks.salt_ore);
                                                    }
                                            if (random.nextInt(2) != 0) world.setBlock(x, y - 3, z, Blocks.stone);
                                            if (world.getBlock(x, y - 1, z) == Blocks.stone
                                                || world.getBlock(x, y - 1, z) == Blocks.coal_ore
                                                || world.getBlock(x, y - 1, z) == Blocks.iron_ore
                                                || (world.getBlock(x, y - 1, z) == ModBlocks.salt_ore
                                                    && world.getBlockMetadata(x, y - 1, z) == 0))
                                                world.setBlock(x, y - 1, z, ModBlocks.salt_ore, horizontalAdjacentFlags, 3);
                                            if (world.getBlock(x, y - 1, z) instanceof BlockDirt
                                                || world.getBlock(x, y - 1, z) == ModBlocks.mineral_mud)
                                                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt_lite, j, 3);
                                            if (world.isAirBlock(x, y - 1, z)) {
                                                int jld = 0;
                                                if (world.getBlock(x, y - 3, z - 1) == ModBlocks.salt_lake
                                                    || world.getBlock(x, y - 3, z - 1) == ModBlocks.salt_dirt)
                                                    jld++;
                                                if (world.getBlock(x + 1, y - 3, z) == ModBlocks.salt_lake
                                                    || world.getBlock(x + 1, y - 3, z) == ModBlocks.salt_dirt)
                                                    jld += 2;
                                                if (world.getBlock(x, y - 3, z + 1) == ModBlocks.salt_lake
                                                    || world.getBlock(x, y - 3, z + 1) == ModBlocks.salt_dirt)
                                                    jld += 4;
                                                if (world.getBlock(x - 1, y - 3, z) == ModBlocks.salt_lake
                                                    || world.getBlock(x - 1, y - 3, z) == ModBlocks.salt_dirt)
                                                    jld += 8;
                                                if (jld > 0) {
                                                    world.setBlock(x, y - 2, z, ModBlocks.salt_lake, jld, 3);
                                                } else {
                                                    world.setBlock(x, y - 2, z, ModBlocks.salt_dirt, 1, 3);
                                                }
                                            }
                                            if (world.getFullBlockLightValue(x, y + 1, z) >= 12) {
                                                if (world.getBlock(x - 1, y - 1, z) == ModBlocks.salt_lake
                                                    || world.getBlock(x + 1, y - 1, z) == ModBlocks.salt_lake
                                                    || world.getBlock(x, y - 1, z - 1) == ModBlocks.salt_lake
                                                    || world.getBlock(x, y - 1, z + 1) == ModBlocks.salt_lake
                                                    || world.getBlock(x - 1, y - 1, z) == ModBlocks.salt_dirt
                                                    || world.getBlock(x + 1, y - 1, z) == ModBlocks.salt_dirt
                                                    || world.getBlock(x, y - 1, z - 1) == ModBlocks.salt_dirt
                                                    || world.getBlock(x, y - 1, z + 1) == ModBlocks.salt_dirt) {
                                                    int jl = 0;
                                                    if (world.getBlock(x, y - 2, z - 1) == ModBlocks.salt_lake
                                                        || world.getBlock(x, y - 2, z - 1)
                                                            == ModBlocks.salt_dirt)
                                                        jl++;
                                                    if (world.getBlock(x + 1, y - 2, z) == ModBlocks.salt_lake
                                                        || world.getBlock(x + 1, y - 2, z)
                                                            == ModBlocks.salt_dirt)
                                                        jl += 2;
                                                    if (world.getBlock(x, y - 2, z + 1) == ModBlocks.salt_lake
                                                        || world.getBlock(x, y - 2, z + 1)
                                                            == ModBlocks.salt_dirt)
                                                        jl += 4;
                                                    if (world.getBlock(x - 1, y - 2, z) == ModBlocks.salt_lake
                                                        || world.getBlock(x - 1, y - 2, z)
                                                            == ModBlocks.salt_dirt)
                                                        jl += 8;
                                                    world.setBlock(x, y - 1, z, ModBlocks.salt_lake, jl, 3);
                                                }
                                                if (world.getBlock(x - 1, y, z)
                                                    .getMaterial() != Material.water
                                                    && world.getBlock(x + 1, y, z)
                                                        .getMaterial() != Material.water
                                                    && world.getBlock(x, y, z - 1)
                                                        .getMaterial() != Material.water
                                                    && world.getBlock(x, y, z + 1)
                                                        .getMaterial() != Material.water
                                                    && world.getBlock(x - 1, y, z)
                                                        .getMaterial() != Material.lava
                                                    && world.getBlock(x + 1, y, z)
                                                        .getMaterial() != Material.lava
                                                    && world.getBlock(x, y, z - 1)
                                                        .getMaterial() != Material.lava
                                                    && world.getBlock(x, y, z + 1)
                                                        .getMaterial() != Material.lava) {
                                                    if (world.getBlock(x, y - 1, z) == ModBlocks.salt_dirt_lite
                                                        && (world.getBlock(x, y, z) instanceof BlockGrass)
                                                        || world.getBlock(x, y, z) == ModBlocks.salt_grass)
                                                        world.setBlock(x, y - 1, z, ModBlocks.salt_grass, j, 3);
                                                    world.setBlockToAir(x, y + 1, z);
                                                    world.setBlockToAir(x, y, z);
                                                    if (random.nextInt(10) == 0
                                                        && (world.getBlock(x, y - 1, z) == ModBlocks.salt_grass
                                                            || world.getBlock(x, y - 1, z)
                                                                == ModBlocks.salt_dirt_lite))
                                                        world.setBlock(x, y, z, ModBlocks.saltworts, 4, 3);
                                                }
                                            } else if (world.getFullBlockLightValue(x, y + 2, z) >= 12
                                                && random.nextInt(2) == 0
                                                && world.getBlock(x - 1, y + 1, z)
                                                    .getMaterial() != Material.water
                                                && world.getBlock(x + 1, y + 1, z)
                                                    .getMaterial() != Material.water
                                                && world.getBlock(x, y + 1, z - 1)
                                                    .getMaterial() != Material.water
                                                && world.getBlock(x, y + 1, z + 1)
                                                    .getMaterial() != Material.water
                                                && world.getBlock(x - 1, y + 1, z)
                                                    .getMaterial() != Material.lava
                                                && world.getBlock(x + 1, y + 1, z)
                                                    .getMaterial() != Material.lava
                                                && world.getBlock(x, y + 1, z - 1)
                                                    .getMaterial() != Material.lava
                                                && world.getBlock(x, y + 1, z + 1)
                                                    .getMaterial() != Material.lava) {
                                                        if (world.getBlock(x, y, z) instanceof BlockDirt
                                                            || world.getBlock(x, y, z) == ModBlocks.mineral_mud) {
                                                            world.setBlock(x, y, z, world.getBlock(x, y + 1, z));
                                                        } else if (world.getBlock(x, y, z) == ModBlocks.salt_dirt_lite) {
                                                                world.setBlock(x, y, z, ModBlocks.salt_grass, world.getBlockMetadata(x, y, z), 3);
                                                            }
                                                        world.setBlockToAir(x, y + 2, z);
                                                        world.setBlockToAir(x, y + 1, z);
                                                    }
                                        } else if (diagonalAdjacentFlags > 0) {
                                            if (world.getBlock(x, y - 1, z).getMaterial().isSolid()
                                                && world.getBlock(x, y - 2, z) != ModBlocks.salt_dirt_lite
                                                && world.getBlock(x, y - 2, z) != ModBlocks.salt_ore)
                                                world.setBlock(x, y - 2, z, Blocks.stone);
                                            if (world.getBlock(x, y - 1, z) instanceof BlockGrass
                                                || world.getBlock(x, y - 1, z) == ModBlocks.salt_grass) {
                                                world.setBlockToAir(x, y, z);
                                                world.setBlock(x, y - 1, z, ModBlocks.salt_grass, j, 3);
                                            } else if (world.getBlock(x, y - 1, z) instanceof BlockDirt
                                                || world.getBlock(x, y - 1, z) == ModBlocks.mineral_mud) {
                                                    world.setBlock(x, y - 1, z, ModBlocks.salt_dirt_lite, j, 3);
                                                }
                                        }
                                    }
                                }
                            }
                            for (x = startX - lakeRadius; x <= startX + lakeRadius; x++) {
                                for (int z = startZ - lakeRadius; z <= startZ + lakeRadius; z++) {
                                    if (world.getBlock(x, y - 2, z) == ModBlocks.salt_lake
                                        && random.nextInt(3) == 0) {
                                        world.setBlock(x, y - 2, z, ModBlocks.salt_dirt, 1, 3);
                                        world.setBlock(x, y - 3, z, ModBlocks.mineral_mud);
                                    }
                                    if ((world.getBlock(x, y - 1, z) == ModBlocks.salt_grass
                                        || world.getBlock(x, y - 1, z) == ModBlocks.salt_dirt_lite)
                                        && world.isAirBlock(x, y, z)
                                        && ((world.getBlock(x - 1, y, z) == ModBlocks.saltworts
                                            && world.getBlockMetadata(x - 1, y, z) == 4)
                                            || (world.getBlock(x + 1, y, z) == ModBlocks.saltworts
                                                && world.getBlockMetadata(x + 1, y, z) == 4)
                                            || (world.getBlock(x, y, z - 1) == ModBlocks.saltworts
                                                && world.getBlockMetadata(x, y, z - 1) == 4)
                                            || (world.getBlock(x, y, z + 1) == ModBlocks.saltworts
                                                && world.getBlockMetadata(x, y, z + 1) == 4))
                                        && random.nextInt(2) == 0)
                                        world.setBlock(x, y, z, ModBlocks.saltworts, random.nextInt(2) + 2, 3);
                                }
                            }
                        }
                    }
                    startX = startX + random.nextInt(ModConfigurationWorldGeneration.saltLakeDistance)
                        - ModConfigurationWorldGeneration.saltLakeDistance / 2;
                    startZ = startZ + random.nextInt(ModConfigurationWorldGeneration.saltLakeDistance)
                        - ModConfigurationWorldGeneration.saltLakeDistance / 2;
                }
        }
    }

    private static int getJ(int horizontalAdjacentFlags, int diagonalAdjacentFlags) {
        int j;
        if (horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 1) {
            j = 3;
        } else if (horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 2) {
            j = 4;
        } else if (horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 4) {
            j = 5;
        } else if (horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 8) {
            j = 6;
        } else if ((horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 9)
            || (horizontalAdjacentFlags == 1 && (diagonalAdjacentFlags == 0 || diagonalAdjacentFlags == 1 || diagonalAdjacentFlags == 8 || diagonalAdjacentFlags == 9))) {
                j = 7;
            } else if ((horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 3)
                || (horizontalAdjacentFlags == 2 && (diagonalAdjacentFlags == 0 || diagonalAdjacentFlags == 1 || diagonalAdjacentFlags == 2 || diagonalAdjacentFlags == 3))) {
                    j = 8;
                } else if ((horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 6)
                    || (horizontalAdjacentFlags == 4 && (diagonalAdjacentFlags == 0 || diagonalAdjacentFlags == 2 || diagonalAdjacentFlags == 4 || diagonalAdjacentFlags == 6))) {
                        j = 9;
                    } else if ((horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 12)
                        || (horizontalAdjacentFlags == 8 && (diagonalAdjacentFlags == 0 || diagonalAdjacentFlags == 4 || diagonalAdjacentFlags == 8 || diagonalAdjacentFlags == 12))) {
                            j = 10;
                        } else if (horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 11 || horizontalAdjacentFlags == 1 && (diagonalAdjacentFlags == 2 || diagonalAdjacentFlags == 3 || diagonalAdjacentFlags == 10 || diagonalAdjacentFlags == 11) || horizontalAdjacentFlags == 2 && diagonalAdjacentFlags >= 8 && diagonalAdjacentFlags <= 11 || horizontalAdjacentFlags == 3 && (diagonalAdjacentFlags <= 3 || diagonalAdjacentFlags >= 8 && diagonalAdjacentFlags <= 11)) {
                                    j = 11;
                                } else
                            if (horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 7 || horizontalAdjacentFlags == 2 && diagonalAdjacentFlags <= 7 || horizontalAdjacentFlags == 4 && (diagonalAdjacentFlags == 1 || diagonalAdjacentFlags == 3 || diagonalAdjacentFlags == 5 || diagonalAdjacentFlags == 7) || horizontalAdjacentFlags == 6 && (diagonalAdjacentFlags <= 7)) {
                                        j = 12;
                                    } else
                                if ((horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 14) || (horizontalAdjacentFlags == 4
                                    && (diagonalAdjacentFlags == 8 || diagonalAdjacentFlags == 10 || diagonalAdjacentFlags == 12 || diagonalAdjacentFlags == 14))
                                    || (horizontalAdjacentFlags == 8
                                        && (diagonalAdjacentFlags == 2 || diagonalAdjacentFlags == 6 || diagonalAdjacentFlags == 10 || diagonalAdjacentFlags == 14))
                                    || (horizontalAdjacentFlags == 12 && (diagonalAdjacentFlags == 0 || diagonalAdjacentFlags == 2
                                        || diagonalAdjacentFlags == 4
                                        || diagonalAdjacentFlags == 6
                                        || diagonalAdjacentFlags == 8
                                        || diagonalAdjacentFlags == 10
                                        || diagonalAdjacentFlags == 12
                                        || diagonalAdjacentFlags == 14))) {
                                            j = 13;
                                        } else
                                    if ((horizontalAdjacentFlags == 0 && diagonalAdjacentFlags == 13) || (horizontalAdjacentFlags == 1
                                        && (diagonalAdjacentFlags == 4 || diagonalAdjacentFlags == 5 || diagonalAdjacentFlags == 12 || diagonalAdjacentFlags == 13))
                                        || (horizontalAdjacentFlags == 8 && (diagonalAdjacentFlags == 1 || diagonalAdjacentFlags == 5
                                            || diagonalAdjacentFlags == 9
                                            || diagonalAdjacentFlags == 13))
                                        || (horizontalAdjacentFlags == 9 && (diagonalAdjacentFlags == 0 || diagonalAdjacentFlags == 1
                                            || diagonalAdjacentFlags == 4
                                            || diagonalAdjacentFlags == 5
                                            || diagonalAdjacentFlags == 8
                                            || diagonalAdjacentFlags == 9
                                            || diagonalAdjacentFlags == 12
                                            || diagonalAdjacentFlags == 13))) {
                                                j = 14;
                                            } else {
                                                j = 15;
                                            }
        return j;
    }
}
