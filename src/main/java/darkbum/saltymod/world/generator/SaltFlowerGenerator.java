package darkbum.saltymod.world.generator;

import cpw.mods.fml.common.IWorldGenerator;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class SaltFlowerGenerator implements IWorldGenerator {

    private final WorldGenFlowers[] worldGenFlowers = {
        new WorldGenFlowers(ModBlocks.salt_flower),
        new WorldGenFlowers(ModBlocks.salt_flower),
        new WorldGenFlowers(ModBlocks.salt_flower),
        new WorldGenFlowers(ModBlocks.salt_flower),
        new WorldGenFlowers(ModBlocks.salt_flower),
        new WorldGenFlowers(ModBlocks.salt_flower),
        new WorldGenFlowers(ModBlocks.salt_flower)
    };

    public SaltFlowerGenerator() {
        worldGenFlowers[1].func_150550_a(ModBlocks.salt_flower, 1);
        worldGenFlowers[2].func_150550_a(ModBlocks.salt_flower, 2);
        worldGenFlowers[3].func_150550_a(ModBlocks.salt_flower, 3);
        worldGenFlowers[4].func_150550_a(ModBlocks.salt_flower, 4);
        worldGenFlowers[5].func_150550_a(ModBlocks.salt_flower, 5);
        worldGenFlowers[6].func_150550_a(ModBlocks.salt_flower, 6);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.getWorldInfo().getTerrainType() != WorldType.FLAT ||
            world.getWorldInfo().getGeneratorOptions().contains("decoration") ||
            world.provider.dimensionId != 0) {
            int x;
            int z;

            BiomeGenBase biome;
            Type[] biomeList;

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.COLD) &&
                !ArrayUtils.contains(biomeList, Type.CONIFEROUS) &&
                !ArrayUtils.contains(biomeList, Type.SNOWY) &&
                !ArrayUtils.contains(biomeList, Type.SPARSE) &&
                !ArrayUtils.contains(biomeList, Type.MOUNTAIN) &&
                !ArrayUtils.contains(biomeList, Type.BEACH) &&
                world.getHeightValue(x, z) > 0 &&
                (ArrayUtils.contains(biomeList, Type.PLAINS) ||
                ArrayUtils.contains(biomeList, Type.FOREST) ||
                ArrayUtils.contains(biomeList, Type.SWAMP) ||
                ArrayUtils.contains(biomeList, Type.SAVANNA))) {
                worldGenFlowers[0].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.COLD) &&
                !ArrayUtils.contains(biomeList, Type.CONIFEROUS) &&
                !ArrayUtils.contains(biomeList, Type.SNOWY) &&
                !ArrayUtils.contains(biomeList, Type.SPARSE) &&
                !ArrayUtils.contains(biomeList, Type.MOUNTAIN) &&
                !ArrayUtils.contains(biomeList, Type.BEACH) &&
                world.getHeightValue(x, z) > 0 &&
                (ArrayUtils.contains(biomeList, Type.PLAINS) ||
                ArrayUtils.contains(biomeList, Type.FOREST) ||
                ArrayUtils.contains(biomeList, Type.SWAMP) ||
                ArrayUtils.contains(biomeList, Type.SAVANNA))) {
                worldGenFlowers[1].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.SNOWY) &&
                !ArrayUtils.contains(biomeList, Type.CONIFEROUS) &&
                !ArrayUtils.contains(biomeList, Type.MOUNTAIN) &&
                world.getHeightValue(x, z) > 0 &&
                (ArrayUtils.contains(biomeList, Type.FOREST))) {
                worldGenFlowers[2].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.SNOWY) &&
                !ArrayUtils.contains(biomeList, Type.CONIFEROUS) &&
                !ArrayUtils.contains(biomeList, Type.MOUNTAIN) &&
                world.getHeightValue(x, z) > 0 &&
                (ArrayUtils.contains(biomeList, Type.FOREST))) {
                worldGenFlowers[3].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.COLD) &&
                !ArrayUtils.contains(biomeList, Type.CONIFEROUS) &&
                !ArrayUtils.contains(biomeList, Type.SPOOKY) &&
                !ArrayUtils.contains(biomeList, Type.DENSE) &&
                !ArrayUtils.contains(biomeList, Type.SNOWY) &&
                !ArrayUtils.contains(biomeList, Type.MOUNTAIN) &&
                world.getHeightValue(x, z) > 0 &&
                (ArrayUtils.contains(biomeList, Type.FOREST))) {
                worldGenFlowers[4].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.SNOWY) &&
                world.getHeightValue(x, z) > 0 &&
                ArrayUtils.contains(biomeList, Type.CONIFEROUS)) {
                worldGenFlowers[5].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }

            x = chunkX * 16 + random.nextInt(16) + 8;
            z = chunkZ * 16 + random.nextInt(16) + 8;
            biome = world.getBiomeGenForCoords(x, z);
            biomeList = BiomeDictionary.getTypesForBiome(biome);
            if (!ArrayUtils.contains(biomeList, Type.SNOWY) &&
                world.getHeightValue(x, z) > 0 &&
                ArrayUtils.contains(biomeList, Type.CONIFEROUS)) {
                worldGenFlowers[6].generate(world, random, x, nextHeightInt(random, world.getHeightValue(x, z) * 2), z);
            }
        }
    }

    protected int nextHeightInt(Random rand, int i) {
        if (i <= 1)
            return 1;
        return rand.nextInt(i);
    }
}
