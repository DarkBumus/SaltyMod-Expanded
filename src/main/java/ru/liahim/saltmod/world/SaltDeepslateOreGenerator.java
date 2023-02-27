package ru.liahim.saltmod.world;

import java.util.Random;

import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.SaltConfig;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SaltDeepslateOreGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateOverworld(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }

    }

    private void generateNether(World world, Random rand, int i, int j) {
    }

    private void generateOverworld(World world, Random rand, int chunkX, int chunkZ) {
        generateOre(ModBlocks.saltDeepslateOre, world, rand, chunkX, chunkZ, SaltConfig.saltOreSize, SaltConfig.saltOreFrequency, 1, SaltConfig.saltDeepslateOreHeight, Blocks.stone);

    }

    public void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int veinSize, int chance, int minY, int maxY, Block generateIn) {
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
        for (int i = 0; i < SaltConfig.saltOreFrequency; i++) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(heightRange) + minY;
            int randPosZ = chunkZ + rand.nextInt(16);
            gen.generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }

    private void generateEnd(World world, Random random, int i, int j) {
    }
}
