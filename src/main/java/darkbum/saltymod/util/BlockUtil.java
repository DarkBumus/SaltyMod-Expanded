package darkbum.saltymod.util;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static darkbum.saltymod.block.BlockSaltBlock.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.init.ModSounds.*;
import static ganymedes01.etfuturum.client.sound.ModSounds.*;
import static net.minecraft.block.material.Material.*;
import static net.minecraft.init.Blocks.snow_layer;
import static net.minecraft.init.Blocks.snow;
import static net.minecraft.init.Blocks.ice;
import static net.minecraft.init.Items.*;

/**
 * Utility class for handling various block-related functionalities.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockUtil {

    /**
     * Sets the block metadata based on the direction the player is facing when placing the block.
     *
     * @param world  The world where the block is placed.
     * @param x      The x-coordinate of the block.
     * @param y      The y-coordinate of the block.
     * @param z      The z-coordinate of the block.
     * @param entity The entity placing the block, expected to be a player.
     */
    public static void setBlockDirectionFromEntity(World world, int x, int y, int z, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            int direction = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
            world.setBlockMetadataWithNotify(x, y, z, direction, 2);
        }
    }

    /**
     * Applies the "Swarmed" effect to a player, causing a debuff effect for a specified duration.
     * This effect is typically associated with being attacked by bees or similar entities.
     *
     * @param player       The player receiving the effect.
     * @param durationTicks The duration of the effect in ticks.
     */
    public static void applySwarmedEffect(World world, EntityPlayer player, int x, int y, int z, int durationTicks) {
        if (!player.capabilities.isCreativeMode) {
            PotionEffect effect = new PotionEffect(swarmed, durationTicks, 0, true);
            effect.getCurativeItems().clear();
            player.addPotionEffect(effect);
            world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "saltymod:block.bee_burrow.bees", 1.0F, 1.5F);
        }
    }

    /**
     * Determines whether the specified entity is vulnerable to salt-related effects.
     * Slimes (excluding Magma Cubes) and Witches are considered vulnerable.
     *
     * @param entity The entity to check.
     * @return true, if the entity is vulnerable to salt effects, false otherwise.
     */
    public static boolean isSaltVulnerableEntity(Entity entity) {
        return ((entity instanceof EntitySlime) && !(entity instanceof EntityMagmaCube)) || (entity instanceof EntityWitch);
    }

    /**
     * Checks if a salt-vulnerable entity is walking over a specific block and schedules
     * a block update if the condition is met.
     *
     * @param sourceBlock The block being interacted with.
     */
    public static void handleEntityWalkingSaltVulnerableUpdate(World world, int x, int y, int z, Entity entity, Block sourceBlock) {
        if (!world.isRemote
            && entity instanceof EntityLivingBase
            && isSaltVulnerableEntity(entity)) {
            world.scheduleBlockUpdate(x, y, z, sourceBlock, 0);
        }
    }

    /**
     * Checks for entities in close proximity to a specified block and applies
     * salt-based damage to vulnerable entities.
     */
    public static void checkAndDamageNearbyEntities(World world, int x, int y, int z, Block sourceBlock) {
        AxisAlignedBB area = AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1).expand(0.0625D, 0.0625D, 0.0625D);

        List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, area);

        for (Entity entity : entities) {
            if (entity instanceof EntityLivingBase && isSaltVulnerableEntity(entity)) {
                entity.attackEntityFrom(DamageSource.cactus, 1.0F);
                updateNearbySaltBlocks(world, x, y, z, sourceBlock);
            }
        }
    }

    /**
     * Schedules block updates for nearby salt-based blocks when a salt effect is triggered.
     */
    private static void updateNearbySaltBlocks(World world, int x, int y, int z, Block sourceBlock) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                Block block = world.getBlock(x + dx, y, z + dz);
                if (block == salt_block
                    || block == salt_lamp
                    || block == salt_lake
                    || block == salt_dirt
                    || block == salt_brick_stairs
                    || block == salt_slab
                    || block == double_salt_slab) {
                    world.scheduleBlockUpdate(x + dx, y, z + dz, sourceBlock, 10);
                }
            }
        }
    }

    /**
     * Attempts to grow a salt crystal block at a specified location if the conditions are met.
     * A salt crystal can only grow if there is a water source block directly above the target block.
     */
    public static void tryGrowSaltCrystal(World world, int x, int y, int z, Random rand) {
        if (!canGrowCrystal(world, x, y, z)) return;

        if (rand.nextInt(saltCrystalGrowthSpeed) != 0) return;

        Block above = world.getBlock(x, y + 1, z);
        int meta = world.getBlockMetadata(x, y + 1, z);

        if (above == Blocks.air) {
            world.setBlock(x, y + 1, z, salt_crystal, 2, 3);
        } else if (above == salt_crystal && meta == 2) {
            world.setBlock(x, y + 1, z, salt_crystal, 1, 3);
        } else if (above == salt_crystal && meta == 1) {
            world.setBlock(x, y + 1, z, salt_crystal);
        }

        crystal = true;
    }

    /**
     * Determines whether a crystal can grow at the given position in the world.
     * This checks if the block at the specified position is either a salt-related block or a related structure
     * and if adjacent blocks meet the necessary criteria for crystal growth.
     *
     * @return true, if a crystal can grow at the specified position, false otherwise.
     */
    private static boolean canGrowCrystal(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        if (block == salt_block
            || block == double_salt_slab
            || (block == salt_slab && meta >= 8)
            || (block == salt_brick_stairs && meta >= 4)) {

            return (world.getBlock(x + 1, y + 1, z) == salt_block
                || world.getBlock(x + 1, y + 1, z) == double_salt_slab)
                && (world.getBlock(x - 1, y + 1, z) == salt_block
                || world.getBlock(x - 1, y + 1, z) == double_salt_slab)
                && (world.getBlock(x, y + 1, z + 1) == salt_block
                || world.getBlock(x, y + 1, z + 1) == double_salt_slab)
                && (world.getBlock(x, y + 1, z - 1) == salt_block
                || world.getBlock(x, y + 1, z - 1) == double_salt_slab)
                && (world.getBlock(x + 1, y + 1, z + 1).getMaterial() == water)
                && (world.getBlock(x + 1, y + 1, z - 1).getMaterial() == water)
                && (world.getBlock(x - 1, y + 1, z + 1).getMaterial() == water)
                && (world.getBlock(x - 1, y + 1, z - 1).getMaterial() == water)
                && world.getFullBlockLightValue(x, y + 1, z) < 8;
        }
        return false;
    }

    /**
     * Attempts to melt ice and snow blocks around the specified coordinates based on adjacent salt or water blocks.
     * If the conditions are met, the blocks are replaced with water or removed, simulating the melting process.
     *
     * @param rand A random number generator used to simulate randomness in melting.
     */
    public static void tryMeltIceAndSnow(World world, int x, int y, int z, Random rand, Block sourceBlock) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    int nz = z + dz;
                    Block block = world.getBlock(nx, ny, nz);

                    if ((block == ice || block == snow || block == snow_layer) && isAdjacentToSaltOrWater(world, nx, ny, nz, x, y, z, sourceBlock)) {
                        crystal = false;
                        world.scheduleBlockUpdate(x, y, z, sourceBlock, 5);

                        if (rand.nextInt(20) == 0) {
                            if (block == ice || block == snow) {
                                world.setBlock(nx, ny, nz, Blocks.water);
                                crystal = true;
                            } else if (block == snow_layer) {
                                world.setBlockToAir(nx, ny, nz);
                                crystal = true;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Checks if the given block is adjacent to a salt or water block.
     *
     * @return true, if the block is adjacent to a salt or water block, false otherwise.
     */
    private static boolean isAdjacentToSaltOrWater(World world, int bx, int by, int bz, int x, int y, int z, Block sourceBlock) {
        if (bx - 1 == x)
            return (world.getBlock(bx - 1, by, bz) == sourceBlock || world.getBlock(bx - 1, by, bz).getMaterial() == water);
        if (bx + 1 == x)
            return (world.getBlock(bx + 1, by, bz) == sourceBlock || world.getBlock(bx + 1, by, bz).getMaterial() == water);
        if (by - 1 == y)
            return (world.getBlock(bx, by - 1, bz) == sourceBlock || world.getBlock(bx, by - 1, bz).getMaterial() == water);
        if (by + 1 == y)
            return (world.getBlock(bx, by + 1, bz) == sourceBlock || world.getBlock(bx, by + 1, bz).getMaterial() == water);
        if (bz - 1 == z)
            return (world.getBlock(bx, by, bz - 1) == sourceBlock || world.getBlock(bx, by, bz - 1).getMaterial() == water);
        if (bz + 1 == z)
            return (world.getBlock(bx, by, bz + 1) == sourceBlock || world.getBlock(bx, by, bz + 1).getMaterial() == water);
        return false;
    }

    /**
     * Calculates the new metadata for a block based on the current metadata and the specified side of the block.
     * This method adjusts the block's metadata depending on the side it is connected to, allowing for different states.
     *
     * @param currentMeta The current metadata of the block.
     * @param side The side of the block (0-5) to determine the new metadata for.
     * @return the new metadata value based on the current metadata and side.
     */
    public static int calculateSaltDirtSaltGrassNewMeta(int currentMeta, int side) {
        if (side <= 1) {
            if (currentMeta == 0) return 3;
            else if (currentMeta < 3 || currentMeta > 5) return 0;
            else return currentMeta + 1;
        }

        if (side == 2) {
            if (currentMeta == 4) return 11;
            else if (currentMeta == 5) return 14;
            else if (currentMeta < 7) return 7;
            else if (currentMeta == 7) return 0;
            else if (currentMeta == 8) return 11;
            else if (currentMeta == 9) return 15;
            else if (currentMeta == 10) return 14;
            else if (currentMeta == 11) return 8;
            else if (currentMeta == 14) return 10;
            else if (currentMeta < 15) return 15;
            else return 9;
        }

        if (side == 5) {
            if (currentMeta == 5) return 12;
            else if (currentMeta == 6) return 11;
            else if (currentMeta < 7) return 8;
            else if (currentMeta == 7) return 11;
            else if (currentMeta == 8) return 0;
            else if (currentMeta == 9) return 12;
            else if (currentMeta == 10) return 15;
            else if (currentMeta == 11) return 7;
            else if (currentMeta == 12) return 9;
            else if (currentMeta < 15) return 15;
            else return 10;
        }

        if (side == 3) {
            if (currentMeta == 3) return 12;
            else if (currentMeta == 6) return 13;
            else if (currentMeta < 7) return 9;
            else if (currentMeta == 7) return 15;
            else if (currentMeta == 8) return 12;
            else if (currentMeta == 9) return 0;
            else if (currentMeta == 10) return 13;
            else if (currentMeta == 12) return 8;
            else if (currentMeta == 13) return 10;
            else if (currentMeta < 15) return 15;
            else return 7;
        }

        if (side == 4) {
            if (currentMeta == 3) return 14;
            else if (currentMeta == 4) return 13;
            else if (currentMeta < 7) return 10;
            else if (currentMeta == 7) return 14;
            else if (currentMeta == 8) return 15;
            else if (currentMeta == 9) return 13;
            else if (currentMeta == 10) return 0;
            else if (currentMeta == 13) return 9;
            else if (currentMeta == 14) return 7;
            else if (currentMeta < 15) return 15;
            else return 8;
        }
        return currentMeta;
    }

    /**
     * Attempts to ignite a block using a fire charge or flint and steel held by the player.
     * The block will be set to a lit version if ignition is successful.
     *
     * @param heldItem The item the player is holding, either a fire charge or flint and steel.
     * @return true, if the block was successfully ignited, false otherwise.
     */
    public static boolean igniteBlock(World world, int x, int y, int z, EntityPlayer player, ItemStack heldItem) {
        int meta = world.getBlockMetadata(x, y, z);

        if (heldItem.getItem() == fire_charge || heldItem.getItem() == flint_and_steel) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, lit_stove, meta, 3);

                String sound = heldItem.getItem() == fire_charge ? "mob.ghast.fireball" : "fire.ignite";
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, sound, 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);

                if (!player.capabilities.isCreativeMode) {
                    if (heldItem.getItem() == flint_and_steel) {
                        heldItem.damageItem(1, player);
                        if (heldItem.getItemDamage() >= heldItem.getMaxDamage()) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                    } else {
                        heldItem.stackSize--;
                        if (heldItem.stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Attempts to extinguish a block using a water bucket or a spade held by the player.
     * If the block is extinguishable, it will be replaced with a non-lit version.
     *
     * @return true, if the block was successfully extinguished, false otherwise.
     */
    public static boolean extinguishBlock(World world, int x, int y, int z, EntityPlayer player, ItemStack heldItem) {
        int meta = world.getBlockMetadata(x, y, z);

        if (heldItem.getItem() == water_bucket || heldItem.getItem() instanceof ItemSpade) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, stove, meta, 3);
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);

                if (!player.capabilities.isCreativeMode) {
                    if (heldItem.getItem() == water_bucket) {
                        player.setCurrentItemOrArmor(0, new ItemStack(bucket));
                    } else if (heldItem.getItem() instanceof ItemSpade) {
                        heldItem.damageItem(1, player);
                    }

                    if (heldItem.stackSize <= 0 || (heldItem.getItem() instanceof ItemSpade && heldItem.getItemDamage() >= heldItem.getMaxDamage())) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Sets properties for a block, including hardness, resistance, step sound, and harvest level.
     *
     * @param block The block to set the properties for.
     */
    public static void propertiesApiaryFishFarm(Block block) {
        block.setHardness(0.6f);
        block.setResistance(0.6f);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesBeeNest(Block block) {
        block.setHardness(1.5f);
        block.setResistance(2.0f);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesClayOven(Block block) {
        block.setHardness(0.5f);
        block.setResistance(3.5f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesCookingPot(Block block) {
        block.setHardness(0.5f);
        block.setResistance(6.0f);
        block.setStepSound(soundTypeCookingPot);
    }

    public static void propertiesDryMudBrick(Block block) {
        block.setHardness(1.5f);
        block.setResistance(3.0f);
        block.setStepSound(soundTypeDryMudBrick);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesEvaporator(Block block) {
        block.setHardness(3.5f);
        block.setResistance(3.5f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesSaltPlantsAll(Block block) {
        block.setHardness(0.0f);
        block.setResistance(0.0f);
        block.setStepSound(soundTypeGrass);
    }

    public static void propertiesMillPress(Block block) {
        block.setHardness(2.5f);
        block.setResistance(2.5f);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesMineralMud(Block block) {
        block.setHardness(0.5f);
        block.setResistance(0.5f);
        block.setStepSound(ModSounds.soundTypeMud);
        block.setHarvestLevel("shovel", 0);
    }

    public static void propertiesReedsBale(Block block) {
        block.setHardness(0.5f);
        block.setResistance(0.5f);
        block.setStepSound(soundTypeGrass);
    }

    public static void propertiesSaltBlock(Block block) {
        block.setHardness(3.0f);
        block.setResistance(6.0f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 1);
    }

    public static void propertiesSaltCrustedLog(Block block) {
        block.setHardness(2.5f);
        block.setResistance(2.0f);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesSaltCrystal(Block block) {
        block.setHardness(1.5f);
        block.setResistance(1.5f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesSaltDeepslateOre(Block block) {
        block.setHardness(4.5f);
        block.setResistance(3.0f);
        block.setHarvestLevel("pickaxe", 0);
        if (Loader.isModLoaded("etfuturum")) {
            block.setStepSound(soundDeepslate);
        }
    }

    public static void propertiesSaltDirtSaltDirtLite(Block block) {
        block.setHardness(0.5f);
        block.setResistance(1.0f);
        block.setStepSound(soundTypeGravel);
        block.setHarvestLevel("shovel", 0);
    }

    public static void propertiesSaltGrass(Block block) {
        block.setHardness(0.5f);
        block.setResistance(1.0f);
        block.setStepSound(soundTypeGrass);
        block.setHarvestLevel("shovel", 0);
    }

    public static void propertiesSaltOre(Block block) {
        block.setHardness(3.0f);
        block.setResistance(3.0f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 1);
    }

    public static void propertiesSaltLamp(Block block) {
        block.setHardness(0.3f);
        block.setResistance(0.3f);
        block.setLightLevel(1.0f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 1);
    }

    public static void propertiesStorageBarrelStorageCrate(Block block) {
        block.setHardness(2.5f);
        block.setResistance(2.5f);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesStorageSack(Block block) {
        block.setHardness(0.5f);
        block.setResistance(1.0f);
        block.setStepSound(soundTypeSnow);
        block.setHarvestLevel("shears", 0);
    }

    public static void propertiesStove(Block block) {
        block.setHardness(3.5f);
        block.setResistance(3.5f);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesWetMudBrick(Block block) {
        block.setHardness(1.0f);
        block.setResistance(3.0f);
        block.setStepSound(soundTypeWetMudBrick);
        block.setHarvestLevel("shovel", 0);
    }
}
