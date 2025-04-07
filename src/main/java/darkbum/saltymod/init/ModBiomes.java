package darkbum.saltymod.init;

import net.minecraft.world.biome.BiomeGenBase;

import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import darkbum.saltymod.world.biome.SaltMarshBiome;

public class ModBiomes {

    public static void SaltyMod() {
        initializeBiome();
    }

    public static BiomeGenBase saltMarsh;

    public static void initializeBiome() {
        if (ModConfigurationWorldGeneration.enableSaltMarsh && ModConfigurationWorldGeneration.saltMarshBiomeID != -1) {
            saltMarsh = new SaltMarshBiome(ModConfigurationWorldGeneration.saltMarshBiomeID).setBiomeName("Salt Marsh");
        }
    }
}
