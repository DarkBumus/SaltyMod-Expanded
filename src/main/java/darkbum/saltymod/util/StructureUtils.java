package darkbum.saltymod.util;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.List;

public final class StructureUtils {

    public enum Rotation {
        NORTH, EAST, SOUTH, WEST;

        public static Rotation fromIndex(int index) {
            return values()[index % values().length];
        }
    }

    public static int[] rotatePosition(int dx, int dz, Rotation rotation) {
        return switch (rotation) {
            case EAST -> new int[]{-dz, dx};
            case SOUTH -> new int[]{-dx, -dz};
            case WEST -> new int[]{dz, -dx};
            default -> new int[]{dx, dz};
        };
    }

    public static Rotation rotateRelative(Rotation initial, Rotation by) {
        int index = (initial.ordinal() + getRotationSteps(by)) % 4;
        return Rotation.values()[index];
    }

    public static int getRotationSteps(Rotation rotation) {
        return switch (rotation) {
            case EAST -> 1;
            case SOUTH -> 2;
            case WEST -> 3;
            default -> 0;
        };
    }

    public static int rotateChestMeta(int meta, Rotation rotation) {
        for (int i = 0; i < getRotationSteps(rotation); i++) {
            switch (meta) {
                case 0: meta = 5; break;
                case 1: meta = 3; break;
                case 2: meta = 4; break;
                case 3: meta = 2; break;
            }
        }
        return meta;
    }

    public static int rotateBedMeta(int meta, Rotation rotation) {
        boolean isHead = (meta & 8) != 0;
        int dir = meta & 3;
        dir = (dir + getRotationSteps(rotation)) % 4;
        return (isHead ? 8 : 0) | dir;
    }

    public static int rotateGateMeta(int meta, Rotation rotation) {
        return (meta + getRotationSteps(rotation)) % 4;
    }

    public static int rotateLogMeta(int meta, Rotation rotation) {
        int variant = meta & 3;
        int axisBits = meta & 12;

        int newAxis = switch (axisBits) {
            case 0 -> 0;
            case 4 -> (rotation == Rotation.EAST || rotation == Rotation.WEST) ? 8 : 4;
            case 8 -> (rotation == Rotation.EAST || rotation == Rotation.WEST) ? 4 : 8;
            default -> axisBits;
        };

        return variant | newAxis;
    }

    public static void place(World world, int baseX, int baseY, int baseZ,
                             int dx, int dy, int dz,
                             StructureUtils.Rotation rotation,
                             Block block, int meta) {
        int[] pos = StructureUtils.rotatePosition(dx, dz, rotation);
        world.setBlock(baseX + pos[0], baseY + dy, baseZ + pos[1], block, meta, 2);
    }

    public static void fillRow(World world, int baseX, int baseY, int baseZ,
                               int startX, int dy, int startZ, int endX, int endZ,
                               StructureUtils.Rotation rotation,
                               Block block, int meta) {
        int stepX = Integer.compare(endX, startX);
        int stepZ = Integer.compare(endZ, startZ);

        int x = startX;
        int z = startZ;
        while (true) {
            int[] pos = StructureUtils.rotatePosition(x, z, rotation);
            world.setBlock(baseX + pos[0], baseY + dy, baseZ + pos[1], block, meta, 2);

            if (x == endX && z == endZ) break;
            if (x != endX) x += stepX;
            if (z != endZ) z += stepZ;
        }
    }

    public static void fillArea(World world, int baseX, int baseY, int baseZ,
                                int startX, int dy, int startZ, int endX, int endZ,
                                StructureUtils.Rotation rotation,
                                Block block, int meta) {
        int stepX = Integer.compare(endX, startX);
        int stepZ = Integer.compare(endZ, startZ);

        for (int x = startX; x != endX + stepX; x += stepX) {
            for (int z = startZ; z != endZ + stepZ; z += stepZ) {
                int[] pos = StructureUtils.rotatePosition(x, z, rotation);
                world.setBlock(baseX + pos[0], baseY + dy, baseZ + pos[1], block, meta, 2);
            }
        }
    }

    public static boolean isGroundValid(World world, int baseX, int baseY, int baseZ, int width, int length, List<Block> validBlocks) {
        for (int x = 0; x < width; x++) {
            for (int z = 0; z < length; z++) {
                int checkX = baseX + x;
                int checkZ = baseZ + z;
                int checkY = baseY - 1;

                Block block = world.getBlock(checkX, checkY, checkZ);
                if (!validBlocks.contains(block)) {
                    return false;
                }

                // Optional: Stelle sicher, dass alles gleich hoch ist
                int surfaceY = world.getTopSolidOrLiquidBlock(checkX, checkZ);
                if (surfaceY != baseY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int findBaseY(World world, int baseX, int baseZ, int width, int length) {
        int minY = Integer.MAX_VALUE;
        for (int x = 0; x < width; x++) {
            for (int z = 0; z < length; z++) {
                int y = world.getTopSolidOrLiquidBlock(baseX + x, baseZ + z);
                if (y < minY) {
                    minY = y;
                }
            }
        }
        return minY;
    }
}
