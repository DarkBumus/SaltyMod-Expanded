package darkbum.saltymod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenWaterlily;

import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.world.*;
import darkbum.saltymod.world.generator.SaltLakeGenerator;

public class SaltMarshDecorator {

    private final WorldGenMinable worldGenSaltOre = new WorldGenMinable(
        ModBlocks.salt_ore,
        ModConfigurationWorldGeneration.saltoreVeinSize,
        Blocks.stone);
    private final SaltLakeGenerator saltLakeGenerator = new SaltLakeGenerator();
    private final NewWorldGenClay newWorldGenClay = new NewWorldGenClay(20);
    private final WorldGenSaltTree worldGenSaltTree = new WorldGenSaltTree(false, 3);
    private final WorldGenSaltLogs worldGenSaltLogs = new WorldGenSaltLogs(false, 3);
    private final WorldGenSaltBigTree worldGenSaltBigTree = new WorldGenSaltBigTree(false, false);
    private final SaltMarshPlantMix saltMarshPlantMix = new SaltMarshPlantMix(64);
    private final SaltwortMix saltWortMix = new SaltwortMix(32);
    private final AlliumPatch alliumPatch = new AlliumPatch(16);

    private final WorldGenWaterlily worldGenWaterlily = new WorldGenWaterlily();
    private final WorldGenReed worldGenReed = new WorldGenReed();

    protected final int offsetXZ(Random rand) {
        return rand.nextInt(16) + 8;
    }

    public final void decorate(World world, Random rand, int x, int z) {
        int pass, passX, passZ;

        if (ModConfigurationWorldGeneration.saltMarshAdditionalSaltOre) {
            for (pass = 0; pass < ModConfigurationWorldGeneration.saltMarshSaltOreFrequency; ++pass) {
                worldGenSaltOre.generate(world, rand, x + rand.nextInt(16), rand.nextInt(96) + 1, z + rand.nextInt(16));
            }
        }

        /*
         * if(ModConfiguration.enableSaltLakes) {
         * for (pass = 0; pass < 7; ++pass) {
         * saltLakeGenerator.generateOverworld(world, rand, x + offsetXZ(rand), z + offsetXZ(rand));
         * }
         * }
         */

        for (pass = 0; pass < 5; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            newWorldGenClay.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        if (rand.nextInt(3) == 0) {
            worldGenSaltTree.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        if (rand.nextInt(3) == 0) {
            worldGenSaltLogs.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        if (rand.nextInt(20) == 0) {
            worldGenSaltBigTree.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 5; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            saltMarshPlantMix.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 5; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            saltWortMix.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        alliumPatch.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);

        for (pass = 0; pass < 4; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenWaterlily.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 3; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenReed.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }
    }

}
