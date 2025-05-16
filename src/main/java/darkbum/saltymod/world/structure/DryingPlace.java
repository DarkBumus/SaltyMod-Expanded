package darkbum.saltymod.world.structure;

import darkbum.saltymod.init.ModBlocks;
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

public class DryingPlace {
    private final boolean hasChest;
    Random rand = new Random();

    public DryingPlace(boolean hasChest) {
        this.hasChest = hasChest;
    }

    public void placeAt(World world, int baseX, int baseY, int baseZ, Rotation rotation) {
        // Y = -1
        if (hasChest) {
            StructureUtils.place(world, baseX, baseY, baseZ, 5, -1, -5, rotation, Blocks.chest, StructureUtils.rotateChestMeta(3, rotation));

            int[] chestPos = StructureUtils.rotatePosition(5, -5, rotation); // dieselben dx, dz wie oben!
            int chestX = baseX + chestPos[0];
            int chestY = baseY - 1;
            int chestZ = baseZ + chestPos[1];

            TileEntity tileEntity = world.getTileEntity(chestX, chestY, chestZ);
            if (tileEntity instanceof IInventory) {
                ChestGenHooks info = ChestGenHooks.getInfo("campChest_III");
                Random rand = world.rand;
                WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), (IInventory) tileEntity, info.getCount(rand));
            }
        }

        // Y = 0
        placeMudRandom(world, baseX, baseY, baseZ, 1, 0, -1, rotation, ModBlocks.wet_mud_brick, 0.5f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 3, 0, -1, rotation, ModBlocks.wet_mud_brick, 0.5f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 5, 0, -1, rotation, ModBlocks.wet_mud_brick, 0.25f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 7, 0, -1, rotation, ModBlocks.wet_mud_brick, 0.25f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 1, 0, -3, rotation, ModBlocks.wet_mud_brick, 0.75f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 3, 0, -3, rotation, ModBlocks.wet_mud_brick, 0.75f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 5, 0, -3, rotation, ModBlocks.wet_mud_brick, 0.5f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 7, 0, -3, rotation, ModBlocks.wet_mud_brick, 0.5f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 1, 0, -5, rotation, ModBlocks.wet_mud_brick, 1f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 3, 0, -5, rotation, ModBlocks.wet_mud_brick, 1f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 5, 0, -5, rotation, ModBlocks.wet_mud_brick, 1f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 7, 0, -5, rotation, ModBlocks.wet_mud_brick, 0.75f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 1, 0, -7, rotation, ModBlocks.wet_mud_brick, 1f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 3, 0, -7, rotation, ModBlocks.wet_mud_brick, 1f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 5, 0, -7, rotation, ModBlocks.wet_mud_brick, 1f, rand);
        placeMudRandom(world, baseX, baseY, baseZ, 7, 0, -7, rotation, ModBlocks.wet_mud_brick, 0.75f, rand);
    }

    public static void placeMudRandom(World world, int baseX, int baseY, int baseZ,
                                      int dx, int dy, int dz,
                                      StructureUtils.Rotation rotation,
                                      Block block,
                                      float chance, Random random) {
        int[] pos = StructureUtils.rotatePosition(dx, dz, rotation);
        int x = baseX + pos[0];
        int y = baseY + dy;
        int z = baseZ + pos[1];

        if (world.getBlock(x, y - 1, z) != Blocks.air && random.nextFloat() < chance) {
            int[] metaOptions = {0, 1, 2};
            int meta = metaOptions[random.nextInt(metaOptions.length)];
            world.setBlock(x, y, z, block, meta, 2);
        }
    }
}
