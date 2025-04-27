package darkbum.saltymod.world.structure;

import darkbum.saltymod.world.StructureUtils;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import darkbum.saltymod.world.StructureUtils.Rotation;
import net.minecraftforge.common.ChestGenHooks;

import java.util.Random;

public class Tent1 {
    private final int woolMeta;
    private final boolean hasChest;


    public Tent1(int woolMeta, boolean hasChest) {
        this.woolMeta = woolMeta;
        this.hasChest = hasChest;
    }

    public void placeAt(World world, int baseX, int baseY, int baseZ, Rotation rotation) {
        // Y = 0
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 0, 0, 0, 0, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 1, 0, -5, rotation, Blocks.bed, StructureUtils.rotateBedMeta(2, rotation));
        StructureUtils.place(world, baseX, baseY, baseZ, 1, 0, -6, rotation, Blocks.bed, StructureUtils.rotateBedMeta(10, rotation));
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 0, 0, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 0, -7, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 3, 0, -1, rotation, Blocks.bed, StructureUtils.rotateBedMeta(8, rotation));
        StructureUtils.place(world, baseX, baseY, baseZ, 3, 0, -2, rotation, Blocks.bed, StructureUtils.rotateBedMeta(0, rotation));
        if (hasChest) {
            StructureUtils.place(world, baseX, baseY, baseZ, 3, 0, -3, rotation, Blocks.chest, StructureUtils.rotateChestMeta(4, rotation));

            int[] chestPos = StructureUtils.rotatePosition(3, -3, rotation); // dieselben dx, dz wie oben!
            int chestX = baseX + chestPos[0];
            int chestY = baseY;
            int chestZ = baseZ + chestPos[1];

            TileEntity tileEntity = world.getTileEntity(chestX, chestY, chestZ);
            if (tileEntity instanceof IInventory) {
                ChestGenHooks info = ChestGenHooks.getInfo("campChest_I");
                Random rand = world.rand;
                WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), (IInventory) tileEntity, info.getCount(rand));
            }
        }
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 4, 0, 0, 4, -7, rotation, Blocks.wool, woolMeta);

        // Y = 1
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 0, 1, 0, 0, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 1, 0, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 1, -7, rotation, Blocks.fence, 0);
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 4, 1, 0, 4, -7, rotation, Blocks.wool, woolMeta);

        // Y = 2
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 1, 2, 0, 1, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 2, 0, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 2, -7, rotation, Blocks.fence, 0);
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 3, 2, 0, 3, -7, rotation, Blocks.wool, woolMeta);

        // Y = 3
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 2, 3, 0, 2, -7, rotation, Blocks.wool, woolMeta);
    }
}
