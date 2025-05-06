package darkbum.saltymod.util;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModSounds;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static darkbum.saltymod.init.ModSounds.*;
import static darkbum.saltymod.block.BlockSaltBlock.*;

public class BlockHelper {

    public static void setBlockDirectionFromEntity(World world, int x, int y, int z, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            int direction = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
            world.setBlockMetadataWithNotify(x, y, z, direction, 2);
        }
    }

    public static void applySwarmedEffect(World world, EntityPlayer player, int x, int y, int z, int durationTicks) {
        if (!player.capabilities.isCreativeMode) {
            PotionEffect effect = new PotionEffect(ModPotion.swarmed.id, durationTicks, 0, true);
            effect.getCurativeItems().clear();
            player.addPotionEffect(effect);
            world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "saltymod:block.bee_burrow.bees", 1.0F, 1.5F);
        }
    }

    public static boolean isTargetEntity(Entity entity) {
        String name = EntityList.getEntityString(entity);
        if (name == null) return false;

        name = name.toLowerCase();
        return (name.contains("slime") && !name.contains("lava")) || name.contains("witch");
    }

    public static void handleEntityWalkingSaltEffect(World world, int x, int y, int z, Entity entity, Block sourceBlock) {
        if (!world.isRemote
            && entity instanceof EntityLivingBase
            && isTargetEntity(entity)) {
            world.scheduleBlockUpdate(x, y, z, sourceBlock, 0);
        }
    }

    public static void checkAndDamageNearbyEntities(World world, int x, int y, int z, Block sourceBlock) {
        AxisAlignedBB area = AxisAlignedBB
            .getBoundingBox(x, y, z, x + 1, y + 1, z + 1)
            .expand(0.0625D, 0.0625D, 0.0625D);

        List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, area);

        for (Entity entity : entities) {
            if (entity instanceof EntityLivingBase && isTargetEntity(entity)) {
                entity.attackEntityFrom(DamageSource.cactus, 1.0F);
                updateNearbySaltBlocks(world, x, y, z, sourceBlock);
            }
        }
    }

    private static void updateNearbySaltBlocks(World world, int x, int y, int z, Block sourceBlock) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                Block block = world.getBlock(x + dx, y, z + dz);
                if (block == ModBlocks.salt_block
                    || block == ModBlocks.salt_lamp
                    || block == ModBlocks.salt_lake
                    || block == ModBlocks.salt_dirt
                    || block == ModBlocks.salt_brick_stairs
                    || block == ModBlocks.salt_slab
                    || block == ModBlocks.double_salt_slab) {
                    world.scheduleBlockUpdate(x + dx, y, z + dz, sourceBlock, 10);
                }
            }
        }
    }

    public static void tryMeltIceAndSnow(World world, int x, int y, int z, Random rand, Block sourceBlock) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    int nz = z + dz;
                    Block block = world.getBlock(nx, ny, nz);

                    if ((block == Blocks.ice || block == Blocks.snow || block == Blocks.snow_layer) && isAdjacentToSaltOrWater(world, nx, ny, nz, x, y, z, sourceBlock)) {
                        crystal = false;
                        world.scheduleBlockUpdate(x, y, z, sourceBlock, 5);

                        if (rand.nextInt(20) == 0) {
                            if (block == Blocks.ice || block == Blocks.snow) {
                                world.setBlock(nx, ny, nz, Blocks.water);
                                crystal = true;
                            } else if (block == Blocks.snow_layer) {
                                world.setBlockToAir(nx, ny, nz);
                                crystal = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isAdjacentToSaltOrWater(World world, int bx, int by, int bz, int x, int y, int z, Block sourceBlock) {
        if (bx - 1 == x)
            return (world.getBlock(bx - 1, by, bz) == sourceBlock || world.getBlock(bx - 1, by, bz).getMaterial() == Material.water);
        if (bx + 1 == x)
            return (world.getBlock(bx + 1, by, bz) == sourceBlock || world.getBlock(bx + 1, by, bz).getMaterial() == Material.water);
        if (by - 1 == y)
            return (world.getBlock(bx, by - 1, bz) == sourceBlock || world.getBlock(bx, by - 1, bz).getMaterial() == Material.water);
        if (by + 1 == y)
            return (world.getBlock(bx, by + 1, bz) == sourceBlock || world.getBlock(bx, by + 1, bz).getMaterial() == Material.water);
        if (bz - 1 == z)
            return (world.getBlock(bx, by, bz - 1) == sourceBlock || world.getBlock(bx, by, bz - 1).getMaterial() == Material.water);
        if (bz + 1 == z)
            return (world.getBlock(bx, by, bz + 1) == sourceBlock || world.getBlock(bx, by, bz + 1).getMaterial() == Material.water);
        return false;
    }

    public static void propertiesApiaryFishFarm(Block block) {
        block.setHardness(0.6F);
        block.setResistance(0.6F);
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
        block.setHardness(0.5F);
        block.setResistance(3.5F);
        block.setStepSound(soundTypeStone);
    }

    public static void propertiesCookingPot(Block block) {
        block.setHardness(0.5F);
        block.setResistance(6.0F);
        block.setStepSound(soundTypeCookingPot);
    }

    public static void propertiesDryMudBrick(Block block) {
        block.setHardness(1.5F);
        block.setResistance(3.0F);
        block.setStepSound(soundTypeDryMudBrick);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesEvaporator(Block block) {
        block.setHardness(3.5F);
        block.setResistance(3.5F);
        block.setStepSound(soundTypeStone);
    }

    public static void propertiesMarshReedsOnions(Block block) {
        block.setHardness(0.0f);
        block.setResistance(0.0f);
        block.setStepSound(soundTypeGrass);
    }

    public static void propertiesMillPress(Block block) {
        block.setHardness(2.5F);
        block.setResistance(2.5F);
        block.setStepSound(soundTypeWood);
    }

    public static void propertiesMineralMud(Block block) {
        block.setHardness(0.5F);
        block.setResistance(0.5F);
        block.setStepSound(ModSounds.soundTypeMud);
        block.setHarvestLevel("shovel", 0);
    }

    public static void propertiesReedsBale(Block block) {
        block.setHardness(0.5F);
        block.setResistance(0.5F);
        block.setStepSound(soundTypeGrass);
    }

    public static void propertiesSaltBlock(Block block) {
        block.setHardness(3.0F);
        block.setResistance(6.0F);
        block.setStepSound(soundTypeStone);
        block.setHarvestLevel("pickaxe", 1);
    }
}
