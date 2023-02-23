package ru.liahim.saltmod.init;

import ru.liahim.saltmod.biome.SaltMarshBiome;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes {

	public static void SaltMod(){
		initializeBiome();

	}
	
	public static BiomeGenBase saltMarsh;
	
	public static void initializeBiome(){
		
		if (SaltConfig.SaltMarshBiomeID != -1) {
		saltMarsh = new SaltMarshBiome(SaltConfig.SaltMarshBiomeID).setBiomeName("SaltMarsh");
		}
	}
}