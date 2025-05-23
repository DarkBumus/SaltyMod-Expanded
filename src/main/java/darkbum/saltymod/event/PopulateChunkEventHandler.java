package darkbum.saltymod.event;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModBlocks;

/**
 * Event handler class for chunk population-related events.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class PopulateChunkEventHandler {

    private static final Random rand = new Random();

    /**
     * Handles populating certain biomes with bee burrows or nests based on the specific biome type and block metadata.
     *
     * @param event The PopulateChunkEvent.Post event containing chunk and world information.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onChunkPopulatePost(PopulateChunkEvent.Post event) {
        World world = event.world;

        int chunkX = event.chunkX * 16;
        int chunkZ = event.chunkZ * 16;

        BiomeGenBase taiga = BiomeGenBase.taiga;
        BiomeGenBase taigaHills = BiomeGenBase.taigaHills;
        BiomeGenBase taigaM = null;
        BiomeGenBase taigaHillsM = null;
        BiomeGenBase birchForest = BiomeGenBase.birchForest;
        BiomeGenBase birchForestHills = BiomeGenBase.birchForestHills;
        BiomeGenBase birchForestM = null;
        BiomeGenBase birchForestHillsM = null;
        BiomeGenBase forest = BiomeGenBase.forest;
        BiomeGenBase forestHills = BiomeGenBase.forestHills;
        BiomeGenBase forestM = null;
        BiomeGenBase swampland = BiomeGenBase.swampland;
        BiomeGenBase swamplandM = null;
        BiomeGenBase roofedForest = BiomeGenBase.roofedForest;
        BiomeGenBase roofedForestM = null;
        BiomeGenBase icePlains = BiomeGenBase.icePlains;
        BiomeGenBase iceMountains = BiomeGenBase.iceMountains;
        BiomeGenBase coldTaiga = BiomeGenBase.coldTaiga;
        BiomeGenBase coldTaigaHills = BiomeGenBase.coldTaigaHills;
        BiomeGenBase coldTaigaM = null;

        for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
            if (biome != null) {
                switch (biome.biomeName) {
                    case "Taiga M":
                        taigaM = biome;
                        break;
                    case "Taiga Hills M":
                        taigaHillsM = biome;
                        break;
                    case "Birch Forest M":
                        birchForestM = biome;
                        break;
                    case "Birch Forest Hills M":
                        birchForestHillsM = biome;
                        break;
                    case "Flower Forest":
                        forestM = biome;
                        break;
                    case "Swampland M":
                        swamplandM = biome;
                        break;
                    case "Roofed Forest M":
                        roofedForestM = biome;
                        break;
                    case "Cold Taiga M":
                        coldTaigaM = biome;
                        break;
                }
            }
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = chunkX + x;
                int worldZ = chunkZ + z;
                BiomeGenBase biome = world.getBiomeGenForCoords(worldX, worldZ);

                if (biome == taiga
                    || biome == taigaHills
                    || biome == taigaM
                    || biome == taigaHillsM) {
                    for (int y = 0; y < world.getHeight(); y++) {
                        Block blockAtCurrentHeight = world.getBlock(worldX, y, worldZ);
                        int metadata = world.getBlockMetadata(worldX, y, worldZ);

                        if (blockAtCurrentHeight == Blocks.log && metadata == 1) {
                            Block blockBelow = world.getBlock(worldX, y - 1, worldZ);
                            if (blockBelow == Blocks.log) {
                                if (rand.nextFloat() < 0.005f) {
                                    int meta = rand.nextInt(3);
                                    world.setBlock(worldX, y, worldZ, ModBlocks.bee_burrow, meta, 3);
                                }
                            }
                        }
                    }
                }
                if (biome == birchForest
                    || biome == birchForestHills
                    || biome == birchForestM
                    || biome == birchForestHillsM) {
                    for (int y = 0; y < world.getHeight(); y++) {
                        Block blockAtCurrentHeight = world.getBlock(worldX, y, worldZ);
                        int metadata = world.getBlockMetadata(worldX, y, worldZ);

                        if (blockAtCurrentHeight == Blocks.log && metadata == 2) {
                            Block blockBelow = world.getBlock(worldX, y - 1, worldZ);
                            if (blockBelow == Blocks.log) {
                                if (rand.nextFloat() < 0.005f) {
                                    int meta = 4 + rand.nextInt(4);
                                    world.setBlock(worldX, y, worldZ, ModBlocks.bee_burrow, meta, 3);
                                }
                            }
                        }
                    }
                }
                if (biome == forest
                    || biome == forestHills
                    || biome == swampland
                    || biome == swamplandM
                    || biome == roofedForest
                    || biome == roofedForestM) {
                    for (int y = 0; y < world.getHeight(); y++) {
                        Block blockAtCurrentHeight = world.getBlock(worldX, y, worldZ);
                        int metadata = world.getBlockMetadata(worldX, y, worldZ);

                        if (blockAtCurrentHeight == Blocks.leaves
                            && (metadata == 0 || metadata == 4 || metadata == 8 || metadata == 12)) {
                            Block blockBelow = world.getBlock(worldX, y - 1, worldZ);
                            if (blockBelow == Blocks.air) {
                                if (rand.nextFloat() < 0.001f) {
                                    int meta = rand.nextInt(3);
                                    world.setBlock(worldX, y, worldZ, ModBlocks.bee_nest, meta, 3);
                                }
                            }
                        }
                        if (blockAtCurrentHeight == Blocks.leaves2
                            && (metadata == 1 || metadata == 5 || metadata == 9 || metadata == 13)) {
                            Block blockBelow = world.getBlock(worldX, y - 1, worldZ);
                            if (blockBelow == Blocks.air) {
                                if (rand.nextFloat() < 0.0005f) {
                                    int meta = rand.nextInt(3);
                                    world.setBlock(worldX, y, worldZ, ModBlocks.bee_nest, meta, 3);
                                }
                            }
                        }
                    }
                }
                if (biome == forestM) {
                    for (int y = 0; y < world.getHeight(); y++) {
                        Block blockAtCurrentHeight = world.getBlock(worldX, y, worldZ);
                        int metadata = world.getBlockMetadata(worldX, y, worldZ);

                        if (blockAtCurrentHeight == Blocks.leaves
                            && (metadata == 0 || metadata == 4 || metadata == 8 || metadata == 12)) {
                            Block blockBelow = world.getBlock(worldX, y - 1, worldZ);
                            if (blockBelow == Blocks.air) {
                                if (rand.nextFloat() < 0.002f) {
                                    int meta = rand.nextInt(3);
                                    world.setBlock(worldX, y, worldZ, ModBlocks.bee_nest, meta, 3);
                                }
                            }
                        }
                    }
                }
                if (biome == icePlains
                    || biome == iceMountains
                    || biome == coldTaiga
                    || biome == coldTaigaHills
                    || biome == coldTaigaM) {
                    for (int y = 0; y < world.getHeight(); y++) {
                        Block blockAtCurrentHeight = world.getBlock(worldX, y, worldZ);
                        int metadata = world.getBlockMetadata(worldX, y, worldZ);

                        if (blockAtCurrentHeight == Blocks.leaves
                            && (metadata == 1 || metadata == 5 || metadata == 9 || metadata == 13)) {
                            Block blockBelow = world.getBlock(worldX, y - 1, worldZ);
                            if (blockBelow == Blocks.air) {
                                if (rand.nextFloat() < 0.002f) {
                                    int meta = 4 + rand.nextInt(4);
                                    world.setBlock(worldX, y, worldZ, ModBlocks.bee_nest, meta, 3);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
