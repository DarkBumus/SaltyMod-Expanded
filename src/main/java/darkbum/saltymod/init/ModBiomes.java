package darkbum.saltymod.init;

import darkbum.saltymod.configuration.ModConfiguration;
import darkbum.saltymod.world.biome.SaltMarshBiome;
import net.minecraft.world.biome.BiomeGenBase;

public class ModBiomes {

	public static void SaltyMod(){
		initializeBiome();
	}

	public static BiomeGenBase saltMarsh;

	public static void initializeBiome(){
		if(ModConfiguration.enableSaltMarsh && ModConfiguration.saltMarshBiomeID != -1) {
		saltMarsh = new SaltMarshBiome(ModConfiguration.saltMarshBiomeID).setBiomeName("Salt Marsh");
		}
	}
}
