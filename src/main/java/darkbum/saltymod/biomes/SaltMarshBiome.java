package darkbum.saltymod.biomes;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.SaltConfig;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class SaltMarshBiome extends BiomeGenBase {

    private final SaltMarshDecorator decorator = new SaltMarshDecorator();

    public SaltMarshBiome(int id) {
        super(id);

        setHeight(new BiomeGenBase.Height(-0.1F, -0.025F));
        setTemperatureRainfall(0.9F, 0.9F);
        waterColorMultiplier = 14745518;

        flowers.clear();
        addFlower(Blocks.red_flower, 2, 10);
        addFlower(Blocks.tallgrass, 0, 2);
        addFlower(ModBlocks.saltworts, 0, 5);

        spawnableCreatureList.clear();
        spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 8, 4, 4));

        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET);
        BiomeManager.addSpawnBiome(this);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeEntry(this, SaltConfig.SaltMarshBiomeWeight));
    }

    @Override
    public void genTerrainBlocks(World world, Random random, Block[] blocks, byte[] bytes, int x, int z, double doub) {
        if(doub > -1.5D) {
            topBlock = ModBlocks.salt_grass;
            fillerBlock = ModBlocks.lite_salt_dirt;
        } else {
            topBlock = Blocks.grass;
            fillerBlock = Blocks.dirt;
        }

        genBiomeTerrain(world, random, blocks, bytes, x, z, doub);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeGrassColor(int x, int y, int z) {
        double noise = plantNoise.func_151601_a((double)x * 0.0225D, (double)z * 0.0225D);
        return noise < -0.01D ? 6331695 : 8953651;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeFoliageColor(int x, int y, int z) {
        double noise = plantNoise.func_151601_a((double)x * 0.0225D, (double)z * 0.0225D);
        return noise < -0.01D ? 6331695 : 8953651;
    }

    @Override
    public void decorate(World world, Random rand, int x, int z) {
        decorator.decorate(world, rand, x, z);
    }

}
