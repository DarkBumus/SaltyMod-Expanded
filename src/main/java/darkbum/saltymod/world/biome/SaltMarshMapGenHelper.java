package darkbum.saltymod.world.biome;

import darkbum.saltymod.init.ModBiomes;
import net.minecraft.world.World;

public class SaltMarshMapGenHelper {

    private SaltMarshMapGenHelper() {}

    public static boolean isSaltMarsh(
        World world,
        int chunkX,
        int chunkZ,
        int localX,
        int localZ
    ) {
        int worldX = chunkX * 16 + localX;
        int worldZ = chunkZ * 16 + localZ;

        return world.getBiomeGenForCoords(
            worldX, worldZ
        ) == ModBiomes.saltMarsh;
    }
}
