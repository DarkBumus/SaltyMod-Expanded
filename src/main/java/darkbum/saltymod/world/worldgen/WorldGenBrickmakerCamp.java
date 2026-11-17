package darkbum.saltymod.world.worldgen;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.util.StructureUtils;
import darkbum.saltymod.util.StructureUtils.Rotation;
import darkbum.saltymod.world.structure.*;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static darkbum.saltymod.util.StructureUtils.rotateRelative;

public class WorldGenBrickmakerCamp extends WorldGenerator {

    private static final List<Integer> WOOL_META_LIST =
        Arrays.asList(0, 7, 8, 12, 15);

    private static final List<Block> VALID_GROUND =
        Arrays.asList(
            Blocks.grass,
            Blocks.dirt,
            ModBlocks.salt_grass
        );

    //private static final int MAX_HEIGHT_DIFFERENCE = 1;

    private static final int AREA_START_X = 0;
    private static final int AREA_END_X = 19;
    private static final int AREA_START_Z = 0;
    private static final int AREA_END_Z = -16;

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {

        Rotation rotation = Rotation.fromIndex(rand.nextInt(4));

        int baseY = prepareGround(world, x, z, rotation);

        if (baseY < 0) {
            return false;
        }

        StructureUtils.fillArea(
            world, x, baseY, z,
            AREA_START_X, 0, AREA_START_Z,
            AREA_END_X, AREA_END_Z,
            rotation, Blocks.air, 0
        );

        StructureUtils.fillArea(
            world, x, baseY, z,
            AREA_START_X, 1, AREA_START_Z,
            AREA_END_X, AREA_END_Z,
            rotation, Blocks.air, 0
        );

        // Weitere 8 Ebenen freiräumen.
        for (int i = 2; i <= 9; i++) {
            StructureUtils.fillArea(
                world, x, baseY, z,
                AREA_START_X, i, AREA_START_Z,
                AREA_END_X, AREA_END_Z,
                rotation, Blocks.air, 0
            );
        }

        class Pos {
            int[] get(int dx, int dz) {
                int[] offset = StructureUtils.rotatePosition(dx, dz, rotation);
                return new int[]{x + offset[0], z + offset[1]};
            }
        }

        Pos pos = new Pos();

        // --------------------------------------------------
        // ZUFÄLLIGE AUSWAHL DER CAMP-BESTANDTEILE
        // --------------------------------------------------

        // Mindestens ein Zelt ist immer vorhanden.
        boolean generateTent1 = rand.nextBoolean();
        boolean generateTent2 = !generateTent1 || rand.nextBoolean();

        // Der DryingPlace ist optional.
        boolean generateDryingPlace = rand.nextBoolean();

        // --------------------------------------------------
        // STRUKTUREN ERSTELLEN
        // --------------------------------------------------

        int woolMetaTent1 =
            WOOL_META_LIST.get(rand.nextInt(WOOL_META_LIST.size()));
        boolean hasChestTent1 = rand.nextBoolean();
        Tent1 tent1 = new Tent1(woolMetaTent1, hasChestTent1);

        int woolMetaTent2 =
            WOOL_META_LIST.get(rand.nextInt(WOOL_META_LIST.size()));
        boolean hasChestTent2 = rand.nextBoolean();
        Tent2 tent2 = new Tent2(woolMetaTent2, hasChestTent2);

        Campfire campfire = new Campfire();

        boolean hasChestDryingPlace = rand.nextBoolean();
        DryingPlace dryingPlace = new DryingPlace(hasChestDryingPlace);

        // --------------------------------------------------
        // ROTATIONEN
        // --------------------------------------------------

        Rotation tent1Rot = rotateRelative(Rotation.WEST, rotation);
        Rotation tent2Rot = rotateRelative(Rotation.NORTH, rotation);
        Rotation campfireRot = rotateRelative(Rotation.NORTH, rotation);
        Rotation dryingRot = rotateRelative(Rotation.NORTH, rotation);

        // --------------------------------------------------
        // POSITIONEN
        // --------------------------------------------------

        int[] tent1Pos = pos.get(7, -1);
        int[] tent2Pos = pos.get(11, -9);
        int[] campfirePos = pos.get(10, 0);
        int[] dryingPos = pos.get(1, -7);

        // --------------------------------------------------
        // TENT 1
        // --------------------------------------------------

        if (generateTent1) {
            placeFoundationRectangle(
                world,
                tent1Pos[0], baseY, tent1Pos[1],
                4,
                tent1Rot
            );
        }

        // --------------------------------------------------
        // TENT 2
        // --------------------------------------------------

        if (generateTent2) {
            placeFoundationRectangle(
                world,
                tent2Pos[0], baseY, tent2Pos[1],
                7,
                tent2Rot
            );
        }

        // --------------------------------------------------
        // CAMPFIRE – IMMER VORHANDEN
        // --------------------------------------------------

        for (int dz = -2; dz >= -4; dz--) {
            placeFoundationBlock(
                world,
                campfirePos[0], baseY, campfirePos[1],
                0, -1, dz,
                campfireRot
            );
        }

        for (int dx = 2; dx <= 4; dx++) {
            placeFoundationBlock(
                world,
                campfirePos[0], baseY, campfirePos[1],
                dx, -1, -6,
                campfireRot
            );
        }

        placeFoundationBlock(
            world,
            campfirePos[0], baseY, campfirePos[1],
            3, -2, -3,
            campfireRot
        );

        // --------------------------------------------------
        // DRYING PLACE
        // --------------------------------------------------

        if (generateDryingPlace) {
            for (int dx = 1; dx <= 7; dx += 2) {
                for (int dz = -1; dz >= -7; dz -= 2) {

                    int foundationY = (
                        hasChestDryingPlace && dx == 5 && dz == -5
                    ) ? -2 : -1;

                    placeFoundationBlock(
                        world,
                        dryingPos[0], baseY, dryingPos[1],
                        dx, foundationY, dz,
                        dryingRot
                    );
                }
            }
        }

        // --------------------------------------------------
        // STRUKTUREN PLATZIEREN
        // --------------------------------------------------

        if (generateTent1) {
            tent1.placeAt(
                world, tent1Pos[0], baseY, tent1Pos[1], tent1Rot
            );
        }

        if (generateTent2) {
            tent2.placeAt(
                world, tent2Pos[0], baseY, tent2Pos[1], tent2Rot
            );
        }

        // Das Campfire wird immer platziert.
        campfire.placeAt(
            world, campfirePos[0], baseY, campfirePos[1], campfireRot
        );

        if (generateDryingPlace) {
            dryingPlace.placeAt(
                world, dryingPos[0], baseY, dryingPos[1], dryingRot
            );
        }

        return true;
    }

    private static final int MAX_HEIGHT_DIFFERENCE = 1;
    private static final int MAX_UNEVEN_COLUMNS = 68;

    private int prepareGround(
        World world,
        int baseX,
        int baseZ,
        Rotation rotation
    ) {

        int width = AREA_END_X - AREA_START_X + 1;
        int length = Math.abs(AREA_END_Z - AREA_START_Z) + 1;

        int[][] surfaceHeights = new int[width][length];

        Map<Integer, Integer> heightCounts = new HashMap<>();

        // 1. Gelände prüfen und Höhen erfassen.
        for (int x = AREA_START_X; x <= AREA_END_X; x++) {
            for (int z = AREA_START_Z; z >= AREA_END_Z; z--) {

                int[] offset =
                    StructureUtils.rotatePosition(x, z, rotation);

                int worldX = baseX + offset[0];
                int worldZ = baseZ + offset[1];

                int surfaceY =
                    world.getTopSolidOrLiquidBlock(worldX, worldZ);

                Block groundBlock =
                    world.getBlock(worldX, surfaceY - 1, worldZ);

                if (!VALID_GROUND.contains(groundBlock)) {
                    return -1;
                }

                int arrayZ = Math.abs(z - AREA_START_Z);

                surfaceHeights[x - AREA_START_X][arrayZ] = surfaceY;

                heightCounts.put(
                    surfaceY,
                    heightCounts.getOrDefault(surfaceY, 0) + 1
                );
            }
        }

        // 2. Häufigste Geländehöhe als Basis bestimmen.
        int baseY = -1;
        int highestCount = 0;

        for (Map.Entry<Integer, Integer> entry : heightCounts.entrySet()) {

            int height = entry.getKey();
            int count = entry.getValue();

            if (count > highestCount
                || (count == highestCount && (baseY < 0 || height < baseY))) {

                baseY = height;
                highestCount = count;
            }
        }

        if (baseY < 0) {
            return -1;
        }

        // 3. Abweichende Spalten zählen.
        int unevenColumns = 0;

        for (int x = 0; x < width; x++) {
            for (int z = 0; z < length; z++) {

                int surfaceY = surfaceHeights[x][z];
                int difference = Math.abs(surfaceY - baseY);

                if (difference > MAX_HEIGHT_DIFFERENCE) {
                    return -1;
                }

                if (difference != 0) {
                    unevenColumns++;
                }

                if (unevenColumns > MAX_UNEVEN_COLUMNS) {
                    return -1;
                }
            }
        }

        // Keine Blöcke setzen oder entfernen!
        return baseY;
    }

    private void placeFoundationBlock(
        World world,
        int baseX,
        int baseY,
        int baseZ,
        int dx,
        int dy,
        int dz,
        Rotation rotation
    ) {
        int[] offset = StructureUtils.rotatePosition(dx, dz, rotation);

        int x = baseX + offset[0];
        int y = baseY + dy;
        int z = baseZ + offset[1];

        // Nur fehlende Blöcke ergänzen.
        // Vorhandenen natürlichen Boden niemals überschreiben.
        if (world.isAirBlock(x, y, z)) {
            world.setBlock(
                x, y, z,
                ModBlocks.salt_dirt_lite,
                0,
                2
            );
        }
    }

    private void placeFoundationRectangle(
        World world,
        int baseX,
        int baseY,
        int baseZ,
        int endX,
        Rotation rotation
    ) {
        for (int x = 0; x <= endX; x++) {
            for (int z = 0; z >= -7; z--) {
                placeFoundationBlock(
                    world,
                    baseX, baseY, baseZ,
                    x, -1, z,
                    rotation
                );
            }
        }
    }

}
