package darkbum.saltymod.world.worldgen;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.util.StructureUtils;
import darkbum.saltymod.world.structure.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import darkbum.saltymod.util.StructureUtils.Rotation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static darkbum.saltymod.util.StructureUtils.rotateRelative;

public class WorldGenBrickmakerCamp extends WorldGenerator {
    private static final List<Integer> woolMetaList = Arrays.asList(0, 7, 8, 12, 15);

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        Rotation rotation = StructureUtils.Rotation.fromIndex(rand.nextInt(4));

        List<Block> validGround = Arrays.asList(Blocks.grass, Blocks.dirt, ModBlocks.salt_grass);

        int baseY = StructureUtils.findBaseY(world, x, z, 19, 16);
        if (!StructureUtils.isGroundValid(world, x, baseY, z, 19, 16, validGround)) {
            return false;
        }

        class Pos {
            int[] get(int dx, int dz) {
                int[] offset = StructureUtils.rotatePosition(dx, dz, rotation);
                return new int[]{x + offset[0], z + offset[1]};
            }
        }
        Pos pos = new Pos();

        StructureUtils.fillArea(world, x, y, z, 0, -3, 0, 19, -16, rotation, ModBlocks.salt_dirt_lite, 0);
        StructureUtils.fillArea(world, x, y, z, 0, -2, 0, 19, -16, rotation, ModBlocks.salt_dirt_lite, 0);
        StructureUtils.fillArea(world, x, y, z, 0, -1, 0, 19, -16, rotation, ModBlocks.salt_grass, 0);

        for (int i = 0; i <= 9; i++) {
            StructureUtils.fillArea(world, x, y, z, 0, i, 0, 19, -16, rotation, Blocks.air, 0);
        }

        int woolMetaTent1 = woolMetaList.get(rand.nextInt(woolMetaList.size()));
        boolean hasChestTent1 = rand.nextBoolean();
        Tent1 tent1 = new Tent1(woolMetaTent1, hasChestTent1);

        int woolMetaTent2 = woolMetaList.get(rand.nextInt(woolMetaList.size()));
        boolean hasChestTent2 = rand.nextBoolean();
        Tent2 tent2 = new Tent2(woolMetaTent2, hasChestTent2);

        Campfire campfire = new Campfire();

        boolean hasChestDryingPlace = rand.nextBoolean();
        DryingPlace dryingPlace = new DryingPlace(hasChestDryingPlace);

        Rotation tent1Rot = rotateRelative(Rotation.WEST, rotation);
        Rotation tent2Rot = rotateRelative(Rotation.NORTH, rotation);
        Rotation campfireRot = rotateRelative(Rotation.NORTH, rotation);
        Rotation dryingRot = rotateRelative(Rotation.NORTH, rotation);

        {
            int[] p = pos.get(7, -1);
            tent1.placeAt(world, p[0], baseY, p[1], tent1Rot);
        }{
            int[] p = pos.get(11, -9);
            tent2.placeAt(world, p[0], baseY, p[1], tent2Rot);
        }{
            int[] p = pos.get(10, 0);
            campfire.placeAt(world, p[0], baseY, p[1], campfireRot);
        }{
            int[] p = pos.get(1, -7);
            dryingPlace.placeAt(world, p[0], baseY, p[1], dryingRot);
        }

        return true;
    }
}
