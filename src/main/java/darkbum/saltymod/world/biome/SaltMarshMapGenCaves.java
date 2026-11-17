package darkbum.saltymod.world.biome;

import net.minecraft.block.Block;
import net.minecraft.world.gen.MapGenCaves;

public class SaltMarshMapGenCaves extends MapGenCaves {

    @Override
    protected void digBlock(
        Block[] data,
        int index,
        int x,
        int y,
        int z,
        int chunkX,
        int chunkZ,
        boolean foundTop
    ) {
        if (foundTop && SaltMarshMapGenHelper.isSaltMarsh(
            worldObj, chunkX, chunkZ, x, z
        )) {
            return;
        }

        super.digBlock(
            data, index, x, y, z,
            chunkX, chunkZ, foundTop
        );
    }
}
