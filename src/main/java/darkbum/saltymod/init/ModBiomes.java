package darkbum.saltymod.init;

import darkbum.saltymod.world.biome.BiomeGenSaltMarsh;
import net.minecraft.world.biome.BiomeGenBase;

import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;

public class ModBiomes {

    public static void SaltyMod() {
        initializeBiome();
    }

    public static BiomeGenBase saltMarsh;

    public static void initializeBiome() {
        if (ModConfigurationWorldGeneration.enableSaltMarsh && ModConfigurationWorldGeneration.saltMarshBiomeID != -1) {
            saltMarsh = new BiomeGenSaltMarsh(ModConfigurationWorldGeneration.saltMarshBiomeID).setBiomeName("Salt Marsh");
        }
    }
}
