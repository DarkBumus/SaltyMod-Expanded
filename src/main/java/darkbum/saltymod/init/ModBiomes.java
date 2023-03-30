package darkbum.saltymod.init;

import darkbum.saltymod.world.biome.SaltMarshBiome;
import net.minecraft.world.biome.BiomeGenBase;

public class ModBiomes {

	public static void SaltMod(){
		initializeBiome();

	}

	public static BiomeGenBase saltMarsh;

	public static void initializeBiome(){

		if (ModConfiguration.SaltMarshBiomeID != -1) {
		saltMarsh = new SaltMarshBiome(ModConfiguration.SaltMarshBiomeID).setBiomeName("SaltMarsh");
		}
	}
}
