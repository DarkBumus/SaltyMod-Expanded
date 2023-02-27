package darkbum.saltmod.init;

import darkbum.saltmod.biome.SaltMarshBiome;
import net.minecraft.world.biome.BiomeGenBase;

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
