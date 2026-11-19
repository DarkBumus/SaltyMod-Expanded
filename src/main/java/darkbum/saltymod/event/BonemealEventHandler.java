package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

import java.util.Random;

import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
import static darkbum.saltymod.init.ModExternalLoader.etFuturumBlocks;

/**
 * Event handler for extended bonemeal functionality.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BonemealEventHandler {

    /**
     * Handles bonemeal interactions with various blocks.
     */
    @SubscribeEvent
    public void onBonemeal(BonemealEvent event) {
        World world = event.world;
        Block block = event.block;
        int x = event.x;
        int y = event.y;
        int z = event.z;

        // All world modifications are performed server-side.
        if (world.isRemote) {
            return;
        }

        if (block == Blocks.cactus) {
            if (enableBoneMealCactus) {
                growCactusOrSugarCane(event);
            }
        } else if (block == Blocks.reeds) {
            if (enableBoneMealSugarCane) {
                growCactusOrSugarCane(event);
            }
        } else if (block == Blocks.nether_wart) {
            if (enableBoneMealNetherWart) {
                int meta = world.getBlockMetadata(x, y, z);

                if (meta < 3) {
                    world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
                    event.setResult(Event.Result.ALLOW);
                }
            }
        } else if (block == Blocks.vine) {
            if (enableBoneMealVines) {
                growVine(event);
            }
        } else if (block == Blocks.melon_stem) {
            if (enableBoneMealMelons) {
                growMelonOrPumpkin(event);
            }
        } else if (block == Blocks.pumpkin_stem) {
            if (enableBoneMealPumpkin) {
                growMelonOrPumpkin(event);
            }
        } else if (block == Blocks.waterlily) {
            if (enableBoneMealLilyPads) {
                block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block instanceof BlockFlower) {
            if (enableBoneMealFlowers) {
                block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block == Blocks.sand || block == Blocks.hardened_clay || block == Blocks.stained_hardened_clay) {
            if (enableBoneMealSandClay) {
                growDeadBush(event);
            }
        } else if (block == Blocks.mycelium) {
            if (enableBoneMealMycelium) {
                growMushroom(event);
            }
        } else if (enableBoneMealStone) {
            growMoss(event);
        }
    }

    /**
     * Immediately attempts to grow cactus or sugar cane.
     */
    private static void growCactusOrSugarCane(BonemealEvent event) {
        World world = event.world;
        Block block = event.block;

        int x = event.x;
        int y = event.y;
        int z = event.z;

        // Find the uppermost block of the plant.
        while (y + 1 < world.getHeight() && world.getBlock(x, y + 1, z) == block) {
            y++;
        }

        world.setBlockMetadataWithNotify(x, y, z, 15, 4);
        block.updateTick(world, x, y, z, world.rand);

        event.setResult(Event.Result.ALLOW);
    }

    /**
     * Immediately attempts to grow a vine.
     */
    private static void growVine(BonemealEvent event) {
        World world = event.world;
        Random originalRandom = world.rand;

        try {
            world.rand = new ZeroFirstIntRandom();
            event.block.updateTick(world, event.x, event.y, event.z, originalRandom);
        } finally {
            world.rand = originalRandom;
        }

        event.setResult(Event.Result.ALLOW);
    }

    /**
     * Immediately attempts to grow a melon or pumpkin.
     * Only mature stems can produce fruit.
     */
    private static void growMelonOrPumpkin(BonemealEvent event) {
        World world = event.world;

        if (world.getBlockMetadata(event.x, event.y, event.z) == 7) {
            event.block.updateTick(world, event.x, event.y, event.z, new ZeroFirstIntRandom());
            event.setResult(Event.Result.ALLOW);
        }
    }

    /**
     * Attempts to grow a dead bush above sand or hardened clay.
     */
    private static void growDeadBush(BonemealEvent event) {
        World world = event.world;

        int x = event.x;
        int y = event.y + 1;
        int z = event.z;

        if (world.isAirBlock(x, y, z) && Blocks.deadbush.canBlockStay(world, x, y, z)) {

            if (world.setBlock(x, y, z, Blocks.deadbush, 0, 3)) {
                event.setResult(Event.Result.ALLOW);
            }
        }
    }

    /**
     * Attempts to grow a red or brown mushroom above mycelium.
     */
    private static void growMushroom(BonemealEvent event) {
        World world = event.world;

        int x = event.x;
        int y = event.y + 1;
        int z = event.z;

        if (!world.isAirBlock(x, y, z)) {
            return;
        }

        Block firstMushroom = world.rand.nextBoolean() ? Blocks.red_mushroom : Blocks.brown_mushroom;
        Block secondMushroom = firstMushroom == Blocks.red_mushroom ? Blocks.brown_mushroom : Blocks.red_mushroom;
        Block mushroom = firstMushroom.canBlockStay(world, x, y, z) ? firstMushroom : secondMushroom;

        if (mushroom.canBlockStay(world, x, y, z)) {
            if (world.setBlock(x, y, z, mushroom, 0, 3)) {
                event.setResult(Event.Result.ALLOW);
            }
        }
    }

    /**
     * Applies the moss transformations from Expanded Bonemeal.
     */
    private static void growMoss(BonemealEvent event) {
        World world = event.world;

        int x = event.x;
        int y = event.y;
        int z = event.z;

        Block stone_slab = etFuturumBlocks.get("stone_slab");
        Block double_stone_slab = etFuturumBlocks.get("double_stone_slab");
        Block mossy_stone_brick_stairs = etFuturumBlocks.get("mossy_stone_brick_stairs");
        Block mossy_cobblestone_stairs = etFuturumBlocks.get("mossy_cobblestone_stairs");
        Block stone_wall = etFuturumBlocks.get("stone_wall");

        Block block = event.block;
        int meta = world.getBlockMetadata(x, y, z);

        if (block == Blocks.cobblestone) {
            if (world.setBlock(x, y, z, Blocks.mossy_cobblestone, 0, 3)) {
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block == Blocks.cobblestone_wall || block == Blocks.stonebrick) {
            if (meta == 0) {
                world.setBlockMetadataWithNotify(x, y, z, 1, 2);
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block == Blocks.monster_egg) {
            if (meta == 2) {
                world.setBlockMetadataWithNotify(x, y, z, 3, 2);
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block == Blocks.stone_slab && stone_slab != null) {
            if (meta == 3) {
                if (world.setBlock(x, y, z, stone_slab, 1, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            } else if (meta == 11) {
                if (world.setBlock(x, y, z, stone_slab, 9, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            } else if (meta == 5) {
                if (world.setBlock(x, y, z, stone_slab, 2, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            } else if (meta == 13) {
                if (world.setBlock(x, y, z, stone_slab, 10, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            }
        } else if (block == Blocks.double_stone_slab && double_stone_slab != null) {
            if (meta == 3) {
                if (world.setBlock(x, y, z, double_stone_slab, 1, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            } else if (meta == 5) {
                if (world.setBlock(x, y, z, double_stone_slab, 2, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            }
        } else if (block == Blocks.stone_brick_stairs && mossy_stone_brick_stairs != null) {
            if (world.setBlock(x, y, z, mossy_stone_brick_stairs, meta, 3)) {
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block == Blocks.stone_stairs && mossy_cobblestone_stairs != null) {
            if (world.setBlock(x, y, z, mossy_cobblestone_stairs, meta, 3)) {
                event.setResult(Event.Result.ALLOW);
            }
        } else if (block == stone_wall && stone_wall != null) {
            if (meta == 0) {
                if (world.setBlock(x, y, z, stone_wall, 1, 3)) {
                    event.setResult(Event.Result.ALLOW);
                }
            }
        }
    }

    /**
     * Random implementation that returns zero on its first nextInt call.
     */
    private static class ZeroFirstIntRandom extends Random {

        private boolean firstTime = true;

        @Override
        public int nextInt(int bound) {
            if (firstTime) {
                firstTime = false;
                return 0;
            }

            return super.nextInt(bound);
        }
    }
}
