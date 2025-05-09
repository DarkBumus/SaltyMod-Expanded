package darkbum.saltymod.util;

import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModSounds;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import static darkbum.saltymod.init.ModSounds.*;
import static ganymedes01.etfuturum.client.sound.ModSounds.*;

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

    public static boolean isSaltVulnerableEntity(Entity entity) {
        return ((entity instanceof EntitySlime) && !(entity instanceof EntityMagmaCube)) || (entity instanceof EntityWitch);
    }

    public static void handleEntityWalkingSaltVulnerableUpdate(World world, int x, int y, int z, Entity entity, Block sourceBlock) {
        if (!world.isRemote
            && entity instanceof EntityLivingBase
            && isSaltVulnerableEntity(entity)) {
            world.scheduleBlockUpdate(x, y, z, sourceBlock, 0);
        }
    }

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

    public static void tryGrowSaltCrystal(World world, int x, int y, int z, Random rand) {
        if (!canGrowCrystal(world, x, y, z)) return;

        if (rand.nextInt(ModConfigurationBlocks.saltCrystalGrowthSpeed) != 0) return;

        Block above = world.getBlock(x, y + 1, z);
        int meta = world.getBlockMetadata(x, y + 1, z);

        if (above == Blocks.air) {
            world.setBlock(x, y + 1, z, ModBlocks.salt_crystal, 2, 3);
        } else if (above == ModBlocks.salt_crystal && meta == 2) {
            world.setBlock(x, y + 1, z, ModBlocks.salt_crystal, 1, 3);
        } else if (above == ModBlocks.salt_crystal && meta == 1) {
            world.setBlock(x, y + 1, z, ModBlocks.salt_crystal);
        }

        crystal = true;
    }

    private static boolean canGrowCrystal(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        if (block == ModBlocks.salt_block
            || block == ModBlocks.double_salt_slab
            || (block == ModBlocks.salt_slab && meta >= 8)
            || (block == ModBlocks.salt_brick_stairs && meta >= 4)) {

            return (world.getBlock(x + 1, y + 1, z) == ModBlocks.salt_block
                || world.getBlock(x + 1, y + 1, z) == ModBlocks.double_salt_slab)
                && (world.getBlock(x - 1, y + 1, z) == ModBlocks.salt_block
                || world.getBlock(x - 1, y + 1, z) == ModBlocks.double_salt_slab)
                && (world.getBlock(x, y + 1, z + 1) == ModBlocks.salt_block
                || world.getBlock(x, y + 1, z + 1) == ModBlocks.double_salt_slab)
                && (world.getBlock(x, y + 1, z - 1) == ModBlocks.salt_block
                || world.getBlock(x, y + 1, z - 1) == ModBlocks.double_salt_slab)
                && (world.getBlock(x + 1, y + 1, z + 1).getMaterial() == Material.water)
                && (world.getBlock(x + 1, y + 1, z - 1).getMaterial() == Material.water)
                && (world.getBlock(x - 1, y + 1, z + 1).getMaterial() == Material.water)
                && (world.getBlock(x - 1, y + 1, z - 1).getMaterial() == Material.water)
                && world.getFullBlockLightValue(x, y + 1, z) < 8;
        }
        return false;
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

    private static boolean isAdjacentToSaltOrWater(World world, int bx, int by, int bz, int x, int y, int z, Block sourceBlock) {
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

    public static boolean igniteBlock(World world, int x, int y, int z, EntityPlayer player, ItemStack heldItem) {
        int meta = world.getBlockMetadata(x, y, z);

        if (heldItem.getItem() == Items.fire_charge || heldItem.getItem() == Items.flint_and_steel) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, ModBlocks.lit_stove, meta, 3);

                String sound = heldItem.getItem() == Items.fire_charge ? "mob.ghast.fireball" : "fire.ignite";
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, sound, 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);

                if (!player.capabilities.isCreativeMode) {
                    if (heldItem.getItem() == Items.flint_and_steel) {
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

    public static boolean extinguishBlock(World world, int x, int y, int z, EntityPlayer player, ItemStack heldItem) {
        int meta = world.getBlockMetadata(x, y, z);

        if (heldItem.getItem() == Items.water_bucket || heldItem.getItem() instanceof ItemSpade) {
            if (!world.isRemote) {
                world.setBlock(x, y, z, ModBlocks.stove, meta, 3);
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);

                if (!player.capabilities.isCreativeMode) {
                    if (heldItem.getItem() == Items.water_bucket) {
                        player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
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
        block.setStepSound(soundDeepslate);
        block.setHarvestLevel("pickaxe", 0);
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
