package darkbum.saltymod.world.biome;

import java.util.Random;

import darkbum.saltymod.world.worldgen.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenWaterlily;


import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.init.ModBlocks;

public class SaltMarshDecorator {

    private final WorldGenMinable worldGenSaltOre = new WorldGenMinable(
        ModBlocks.salt_ore,
        ModConfigurationWorldGeneration.saltoreVeinSize,
        Blocks.stone);
    private final WorldGenLakesMod worldGenLakesMod = new WorldGenLakesMod(Blocks.water, ModBlocks.mineral_mud, 4, 62, 62);
    private final WorldGenMineralMud worldGenMineralMud = new WorldGenMineralMud(5);
    private final WorldGenSaltTree worldGenSaltTree = new WorldGenSaltTree(false, 3);
    private final WorldGenSaltLogs worldGenSaltLogs = new WorldGenSaltLogs(false, 3);
    private final WorldGenSaltBigTree worldGenSaltBigTree = new WorldGenSaltBigTree(false, false);
    private final WorldGenSaltMarshPlants worldGenSaltMarshPlants = new WorldGenSaltMarshPlants(64);
    private final WorldGenSaltwort worldGenSaltwort = new WorldGenSaltwort(32);
    private final WorldGenAlliumMod worldGenAlliumMod = new WorldGenAlliumMod(16);
    private final WorldGenBrickmakerCamp worldGenBrickmakerCamp = new WorldGenBrickmakerCamp();
    private final WorldGenMarshReeds worldGenMarshReeds = new WorldGenMarshReeds();
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

        for (pass = 0; pass < ModConfigurationWorldGeneration.saltMarshWetness; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenLakesMod.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 150; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenMineralMud.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 5; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenSaltMarshPlants.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 5; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenSaltwort.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        worldGenAlliumMod.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);

        if(ModConfigurationWorldGeneration.enableBrickmakerCamp) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            if (rand.nextInt(ModConfigurationWorldGeneration.brickmakerCampFrequency) == 0) {
                worldGenBrickmakerCamp.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
            }
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        if (rand.nextInt(5) == 0) {
            worldGenSaltTree.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        if (rand.nextInt(5) == 0) {
            worldGenSaltLogs.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        passX = x + offsetXZ(rand);
        passZ = z + offsetXZ(rand);
        if (rand.nextInt(30) == 0) {
            worldGenSaltBigTree.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 4; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenWaterlily.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }
        for (pass = 0; pass < 4; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenMarshReeds.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }

        for (pass = 0; pass < 3; ++pass) {
            passX = x + offsetXZ(rand);
            passZ = z + offsetXZ(rand);
            worldGenReed.generate(world, rand, passX, world.getTopSolidOrLiquidBlock(passX, passZ), passZ);
        }
    }
}
