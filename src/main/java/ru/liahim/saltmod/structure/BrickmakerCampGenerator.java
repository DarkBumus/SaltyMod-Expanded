/*package ru.liahim.saltmod.structure;

import java.util.Random;

import ru.liahim.saltmod.biome.SaltBiomeBase;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class BrickmakerCampGenerator implements IWorldGenerator {
	private static BrickmakerCampStructure campGenerator = new MapGenCamp();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		Block[] ablock = new Block[65536];
		if (world.provider.dimensionId == 0 && world.getWorldInfo().isMapFeaturesEnabled()) {
			campGenerator = (MapGenCamp)TerrainGen.getModdedMapGen((MapGenBase)new MapGenCamp(), InitMapGenEvent.EventType.CUSTOM);
			if (MapGenCamp.canSpawnStructureAtCoords(world, chunkX, chunkZ)) {
				int chunkOffset = 2;
				for (int OM_x = -chunkOffset; OM_x <= chunkOffset - 1; OM_x++) {
					for (int OM_z = -chunkOffset; OM_z <= chunkOffset - 1; OM_z++) {
						this.campGenerator.func_151539_a(world.getChunkProvider(), world, random, chunkX, chunkZ, ablock);
						try {
							this;
							boolean bool = campGenerator.generateStructuresInChunk(world, random, chunkX + OM_x, chunkZ + OM_z);
						} catch (Exception exception) {}
					}
				}
			}
		}
	}
	
	public static MapGenCamp getCampGenerator() {
		return campGenerator;
	}	
}*/