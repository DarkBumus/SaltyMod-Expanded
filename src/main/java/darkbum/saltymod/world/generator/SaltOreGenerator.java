package darkbum.saltymod.world.generator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;
import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModBlocks;

public class SaltOreGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
        IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateOverworld(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }

    }

    private void generateNether(World world, Random rand, int i, int j) {}

    private void generateOverworld(World world, Random rand, int chunkX, int chunkZ) {
        generateOre(
            ModBlocks.salt_ore,
            world,
            rand,
            chunkX,
            chunkZ,
            ModConfigurationWorldGeneration.saltoreVeinSize,
            ModConfigurationWorldGeneration.saltOreFrequency,
            1,
            96,
            Blocks.stone);

    }

    public void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int veinSize, int chance,
        int minY, int maxY, Block generateIn) {
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
        for (int i = 0; i < ModConfigurationWorldGeneration.saltOreFrequency; i++) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(heightRange) + minY;
            int randPosZ = chunkZ + rand.nextInt(16);
            gen.generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }

    private void generateEnd(World world, Random random, int i, int j) {}
}
