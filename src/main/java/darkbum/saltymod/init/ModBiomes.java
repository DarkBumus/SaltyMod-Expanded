package darkbum.saltymod.init;

import darkbum.saltymod.world.biome.BiomeGenSaltMarsh;
import net.minecraft.world.biome.BiomeGenBase;

import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;

/**
 * Biome class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModBiomes {

    public static BiomeGenBase saltMarsh;

    /**
     * Initializes all biomes.
     */
    public static void init() {
        if (enableSaltMarsh && saltMarshBiomeID != -1) {
            saltMarsh = new BiomeGenSaltMarsh(saltMarshBiomeID).setBiomeName("Salt Marsh");
        }
    }
}
