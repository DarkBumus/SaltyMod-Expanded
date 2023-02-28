package darkbum.saltmod.biome;

import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.SaltConfig;
import darkbum.saltmod.world.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenWaterlily;

import java.util.Random;

public class SaltMarshDecorator {

    protected World world;
    protected Random rand;
    protected int x, z;
    protected int xx, yy, zz, attempt;

    protected final int offsetXZ() {
        return rand.nextInt(16) + 8;
    }

    public final void decorate(World world, Random rand, int x, int z) {

        this.world = world;
        this.rand = rand;
        this.x = x;
        this.z = z;

        decorate();
    }

    protected void decorate() {
        for (attempt = 0; attempt < 7; ++attempt) {
            (new SaltLakeGenerator()).generateOverworld(world, rand, x + offsetXZ(), z + offsetXZ());
        }

        for (attempt = 0; attempt < 5; ++attempt) {
            xx = x + offsetXZ();
            zz = z + offsetXZ();
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            (new NewWorldGenClay(20)).generate(world, rand, xx, yy, zz);
        }

        xx = x + offsetXZ();
        zz = z + offsetXZ();
        yy = world.getTopSolidOrLiquidBlock(xx, zz);
        if (rand.nextInt(3) == 0) {
            (new WorldGenSaltTree(false, 3)).generate(world, rand, xx, yy, zz);
        }

        xx = x + offsetXZ();
        zz = z + offsetXZ();
        yy = world.getTopSolidOrLiquidBlock(xx, zz);
        if (rand.nextInt(20) == 0) {
            (new WorldGenSaltBigTree(false, false)).generate(world, rand, xx, yy, zz);
        }

        xx = x + offsetXZ();
        zz = z + offsetXZ();
        yy = world.getTopSolidOrLiquidBlock(xx, zz);
        if (rand.nextInt(20) == 0) {
            (new WorldGenBlossomBigTree(false, false)).generate(world, rand, xx, yy, zz);
        }

        for (attempt = 0; attempt < 5; ++attempt) {
            xx = x + offsetXZ();
            zz = z + offsetXZ();
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            (new SaltMarshPlantMix(64)).generate(world, rand, xx, yy, zz);
        }

        for (attempt = 0; attempt < 5; ++attempt) {
            xx = x + offsetXZ();
            zz = z + offsetXZ();
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            (new SaltWortMix(32)).generate(world, rand, xx, yy, zz);
        }

        for (attempt = 0; attempt < 1; ++attempt) {
            xx = x + offsetXZ();
            zz = z + offsetXZ();
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            (new AlliumPatch(16)).generate(world, rand, xx, yy, zz);
        }

        for (attempt = 0; attempt < 4; ++attempt) {
            xx = x + offsetXZ();
            zz = z + offsetXZ();
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            (new WorldGenWaterlily()).generate(world, rand, xx, yy, zz);
        }

        for (attempt = 0; attempt < 3; ++attempt) {
            xx = x + offsetXZ();
            zz = z + offsetXZ();
            yy = world.getTopSolidOrLiquidBlock(xx, zz);
            (new WorldGenReed()).generate(world, rand, xx, yy, zz);
        }

        if (SaltConfig.saltOreBiome) {
            WorldGenMinable gen = new WorldGenMinable(ModBlocks.saltOre, SaltConfig.saltOreSize, Blocks.stone);
            int maxY = 96;
            int minY = 1;
            int heightRange = maxY - minY;
            for (attempt = 0; attempt < SaltConfig.saltOreFrequencyBiome; attempt++) {
                xx = x + rand.nextInt(16);
                yy = rand.nextInt(heightRange) + minY;
                zz = z + rand.nextInt(16);
                gen.generate(world, rand, xx, yy, zz);
            }
        }
    }
}
