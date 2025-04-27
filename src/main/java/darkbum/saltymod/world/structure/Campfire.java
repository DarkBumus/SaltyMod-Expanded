package darkbum.saltymod.world.structure;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.world.StructureUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import darkbum.saltymod.world.StructureUtils.Rotation;

public class Campfire {

    public Campfire() {
    }

    public void placeAt(World world, int baseX, int baseY, int baseZ, Rotation rotation) {
        // Y = -1 - 0
        if (Loader.isModLoaded("campfirebackport")) {
            Block campfire = GameRegistry.findBlock("campfirebackport", "campfire");
            if (campfire != null) {
                StructureUtils.place(world, baseX, baseY, baseZ, 3, -1, -3, rotation, Blocks.hay_block, 0);
                StructureUtils.place(world, baseX, baseY, baseZ, 3, 0, -3, rotation, campfire, 3);
            }
        } else {
            StructureUtils.place(world, baseX, baseY, baseZ, 3, -1, -3, rotation, Blocks.netherrack, 0);
            StructureUtils.place(world, baseX, baseY, baseZ, 3, 0, -3, rotation, Blocks.fire, 0);
        }

        // Y = 0
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 0, 0, -2, 0, -4, rotation, ModBlocks.salt_crusted_oak_log, StructureUtils.rotateLogMeta(8, rotation));
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 2, 0, -6, 4, -6, rotation, ModBlocks.salt_crusted_oak_log, StructureUtils.rotateLogMeta(4, rotation));
    }
}
