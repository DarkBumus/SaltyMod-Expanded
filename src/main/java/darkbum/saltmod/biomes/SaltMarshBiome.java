package darkbum.saltmod.biomes;

import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.SaltConfig;

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

    private final SaltMarshDecorator decorator;
    public SaltMarshBiome(int id){

        super(id);

        this.decorator = new SaltMarshDecorator();

        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.SWAMP);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.WET);

        BiomeManager.addSpawnBiome(this);

//		Height and Height variation (Vanilla: -0.1F, -0.025F)
//		this.setHeight(new BiomeGenBase.Height(-0.1F, -0.025F));
//		this.setHeight(height_PartiallySubmerged); is the same as: this.setHeight(new BiomeGenBase.Height(-0.2F, 0.1F));
        this.setHeight(new BiomeGenBase.Height(-0.1F, -0.025F));

//		Making the biome able to spawn in the specified climate with the weight compared to all others in this climate
//		Multiple entries are possible
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeEntry(this, SaltConfig.SaltMarshBiomeWeight));

        this.waterColorMultiplier = 14745518;
        this.setTemperatureRainfall(0.9F, 0.9F);

//		Bonemeal in this biome. grass would always generate, you can add it for additional grass in bonemeal
        this.flowers.clear();
        this.addFlower(Blocks.red_flower, 2, 10);
        this.addFlower(Blocks.tallgrass, 0, 2);
        this.addFlower(ModBlocks.saltworts, 0, 5);

        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 8, 4, 4));
//	    this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 4, 4, 4));
    }

    public void genTerrainBlocks(World world, Random random, Block[] blocks, byte[] bytes, int x, int z, double doub) {

//      Top Meta
        field_150604_aj = 0;
//      Filler Meta
        field_76754_C = 0;

        if (doub > 2.4D) {
            topBlock = ModBlocks.salt_grass;
            fillerBlock = ModBlocks.lite_salt_dirt;
        } else if (doub > -1.5D) {
            topBlock = ModBlocks.salt_grass;
            fillerBlock = ModBlocks.lite_salt_dirt;
        } else {
            topBlock = Blocks.grass;
            fillerBlock = Blocks.dirt;
        }

        genBiomeTerrain(world, random, blocks, bytes, x, z, doub);
    }

//  Different grass color depending on coordinates in Biome
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int x, int y, int z) {
        double d0 = plantNoise.func_151601_a((double)x * 0.0225D, (double)z * 0.0225D);
        return d0 < -0.01D ? 6331695 : 8953651;
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int x, int y, int z) {
        double d0 = plantNoise.func_151601_a((double)x * 0.0225D, (double)z * 0.0225D);
        return d0 < -0.01D ? 6331695 : 8953651;
    }

    @Override
    public void decorate(World world, Random rand, int x, int z) {
        decorator.decorate(world, rand, x, z);
    }
}
