/*package ru.liahim.saltmod.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.common.BiomeDictionary;
import ru.liahim.saltmod.biome.SaltBiomeBase;
import ru.liahim.saltmod.init.ModBiomes;
import scala.actors.threadpool.Arrays;

public class MapGenCamp extends MapGenStructure {
	private static List biomelist = Arrays.asList(new BiomeGenBase[] { ModBiomes.saltMarsh });
	
	private List scatteredFeatureSpawnList;
	
	private static int maxDistanceBetweenScatteredFeatures;
	
	private static int minDistanceBetweenScatteredFeatures;
	
	public MapGenCamp() {
		this.scatteredFeatureSpawnList = new ArrayList();
		this.maxDistanceBetweenScatteredFeatures = 32;
		this.minDistanceBetweenScatteredFeatures = 8;
	}
	
	public MapGenCamp(Map p_i2061_1_) {
		this();
		Iterator iterator = p_i2061_1_.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry)iterator.next();
			if (((String)entry.getKey()).equals("distance")) {
				this.maxDistanceBetweenScatteredFeatures = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.maxDistanceBetweenScatteredFeatures, this.minDistanceBetweenScatteredFeatures + 1);
			}
		}
	}
	
	public String func_143025_1() {
		return "Temple";
	}
	
	public boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
		return canSpawnStructureAtCoords(this.worldObj, chunkX, chunkZ);
	}
	
	protected static boolean canSpawnStructureAtCoords(World worldIn, int chunkX, int chunkZ) {
		int k = chunkX;
		int l = chunkZ;
		if (chunkX < 0)
			chunkX -= maxDistanceBetweenScatteredFeatures - 1;
		if (chunkZ < 0)
			chunkZ -= maxDistanceBetweenScatteredFeatures - 1;
		int i1 = chunkX / maxDistanceBetweenScatteredFeatures;
		int j1 = chunkZ / maxDistanceBetweenScatteredFeatures;
		Random random = worldIn.setRandomSeed(i1, j1, 14357617);
		i1 *= maxDistanceBetweenScatteredFeatures;
		j1 *= minDistanceBetweenScatteredFeatures;
		i1 += random.nextInt(maxDistanceBetweenScatteredFeatures - minDistanceBetweenScatteredFeatures);
		j1 += random.nextInt(maxDistanceBetweenScatteredFeatures - minDistanceBetweenScatteredFeatures);
		if (k == i1 && 1 == j1) {
			BiomeGenBase biomegenbase = worldIn.getWorldChunkManager().getBiomeGenAt(k * 16 + 8,  1 * 16 + 8);
			Iterator iterator = biomelist.iterator();
			while (iterator.hasNext()) {
				BiomeGenBase biomegenbase1 = (BiomeGenBase)iterator.next();
				if (biomegenbase == biomegenbase1)
					return true;
			}
		}
		return false;
	}
	
	public String func_143025_a() {
		return "BrickmakerCamp";
	}
	
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		return new MapGenCamp.Start(this.worldObj, this.rand, chunkX, chunkZ);
	}
	
	public boolean func_143030_a(int func_143030_1_, int func_143030_2_, int func_143030_3_) {
		StructureStart structurestart = func_143028_c(func_143030_1_, func_143030_2_, func_143030_3_);
		if (structurestart != null && structurestart instanceof Start && !structurestart.getComponents().isEmpty()) {
			StructureComponent structurecomponent = (StructureComponent)structurestart.getComponents().getFirst();
			return false;
		}
		return false;
	}
	
	public List getScatteredFeatureSpawnList() {
		return this.scatteredFeatureSpawnList;
	}
	
	public static class Start extends StructureStart {
		public Start() {}
		
		public Start(World worldIn, Random rand, int chunkX, int chunkZ){
			super(chunkX, chunkZ);
			BiomeGenBase biomegenbase = worldIn.getBiomeGenForCoords(chunkX * 16 + 8, chunkZ * 16 + 8);
		
		if(biomegenbase == ModBiomes.saltMarsh) {
			ComponentCampPieces.Camp camp = new ComponentCampPieces.Camp(rand, chunkX * 16, chunkZ * 16);
			this.components.add(camp);
		}
		updateBoundingBox();
		}
	}
}*/