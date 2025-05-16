package darkbum.saltymod.world.structure;

import darkbum.saltymod.util.StructureUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import darkbum.saltymod.util.StructureUtils.Rotation;
import net.minecraftforge.common.ChestGenHooks;

import java.util.Random;

public class Tent2 {
    private final int woolMeta;
    private final boolean hasChest;
    Random rand = new Random();

    public Tent2(int woolMeta, boolean hasChest) {
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
            int chestZ = baseZ + chestPos[1];

            TileEntity tileEntity = world.getTileEntity(chestX, baseY, chestZ);
            if (tileEntity instanceof IInventory) {
                ChestGenHooks info = ChestGenHooks.getInfo("campChest_II");
                Random rand = world.rand;
                WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), (IInventory) tileEntity, info.getCount(rand));
            }
        }
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 4, 0, 0, 4, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 5, 0, -1, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 5, 0, -6, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 6, 0, -1, rotation, Blocks.fence_gate, StructureUtils.rotateGateMeta(2, rotation));
        StructureUtils.place(world, baseX, baseY, baseZ, 6, 0, -6, rotation, Blocks.fence, 0);
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 7, 0, -1, 7, -6, rotation, Blocks.fence, 0);
        placeHayRandom(world, baseX, baseY, baseZ, 5, 0, -3, rotation, Blocks.hay_block, 0.5f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 5, 0, -4, rotation, Blocks.hay_block, 0.5f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 5, 0, -5, rotation, Blocks.hay_block, 0.5f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 6, 0, -3, rotation, Blocks.hay_block, 0.25f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 6, 0, -4, rotation, Blocks.hay_block, 0.5f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 6, 0, -5, rotation, Blocks.hay_block, 0.25f, rand);

        // Y = 1
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 0, 1, 0, 0, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 1, 0, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 1, -7, rotation, Blocks.fence, 0);
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 4, 1, 0, 4, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 7, 1, -1, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 7, 1, -6, rotation, Blocks.fence, 0);
        placeHayRandom(world, baseX, baseY, baseZ, 5, 1, -4, rotation, Blocks.hay_block, 0.25f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 5, 1, -5, rotation, Blocks.hay_block, 0.1f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 6, 1, -4, rotation, Blocks.hay_block, 0.1f, rand);
        placeHayRandom(world, baseX, baseY, baseZ, 6, 1, -5, rotation, Blocks.hay_block, 0.25f, rand);

        // Y = 2
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 1, 2, 0, 1, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 2, 0, rotation, Blocks.fence, 0);
        StructureUtils.place(world, baseX, baseY, baseZ, 2, 2, -7, rotation, Blocks.fence, 0);
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 3, 2, 0, 3, -7, rotation, Blocks.wool, woolMeta);
        StructureUtils.fillArea(world, baseX, baseY, baseZ, 4, 2, -1, 7, -6, rotation, Blocks.wooden_slab, 0);

        // Y = 3
        StructureUtils.fillRow(world, baseX, baseY, baseZ, 2, 3, 0, 2, -7, rotation, Blocks.wool, woolMeta);
    }

    public static void placeHayRandom(World world, int baseX, int baseY, int baseZ,
                                                       int dx, int dy, int dz,
                                                       StructureUtils.Rotation rotation,
                                                       Block block,
                                                       float chance, Random random) {
        int[] pos = StructureUtils.rotatePosition(dx, dz, rotation);
        int x = baseX + pos[0];
        int y = baseY + dy;
        int z = baseZ + pos[1];

        if (world.getBlock(x, y - 1, z) != Blocks.air && random.nextFloat() < chance) {
            int[] metaOptions = {0, 4, 8};
            int meta = metaOptions[random.nextInt(metaOptions.length)];
            world.setBlock(x, y, z, block, meta, 2);
        }
    }
}
