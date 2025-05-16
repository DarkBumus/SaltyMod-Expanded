package darkbum.saltymod.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

import java.util.Random;

import static darkbum.saltymod.util.ItemUtils.*;

/**
 * Item class for the chorus cookie item.
 * The chorus coookie is a salt food item with a special teleport function.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemChorusCookie extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified base name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemChorusCookie(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setAlwaysEdible();
        variantsChorusCookie(this);
    }

    /**
     * Called when the player consumes this item.
     *
     * @param stack  The ItemStack that was consumed.
     * @param world  The world in which the item was consumed.
     * @param player The player consuming the item.
     * @return the resulting ItemStack after the item is consumed.
     */
    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        ItemStack result = super.onEaten(stack, world, player);
        Vec3 look = player.getLookVec();
        Random rand = player.getRNG();

        for (int attempt = 0; attempt < 16; ++attempt) {
            double baseDistance = 8.0 + rand.nextDouble() * 8.0;
            double dx = look.xCoord * baseDistance;
            double dy = look.yCoord * baseDistance;
            double dz = look.zCoord * baseDistance;

            double targetX = player.posX + dx + (rand.nextDouble() - 0.5);
            double targetY = player.posY + dy + (rand.nextDouble() - 0.5);
            double targetZ = player.posZ + dz + (rand.nextDouble() - 0.5);

            int x = MathHelper.floor_double(targetX);
            int y = MathHelper.floor_double(targetY);
            int z = MathHelper.floor_double(targetZ);

            for (int offset = 0; offset <= 16; ++offset) {
                int yy = y - offset;
                if (!world.blockExists(x, yy, z)) continue;

                if (isValidTeleportSpot(world, x, yy, z)) {
                    if (teleportTo(player, x + 0.5, yy, z + 0.5)) {
                        player.fallDistance = 0.0F;
                        return result;
                    }
                    break;
                }
            }

            for (int offset = 1; offset <= 16; ++offset) {
                int yy = y + offset;
                if (!world.blockExists(x, yy, z)) continue;

                if (isValidTeleportSpot(world, x, yy, z)) {
                    if (teleportTo(player, x + 0.5, yy, z + 0.5)) {
                        player.fallDistance = 0.0F;
                        return result;
                    }
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Checks if a specific coordinate is a valid teleportation spot.
     *
     * @param world The world to check in.
     * @param x     The X coordinate to check.
     * @param y     The Y coordinate to check.
     * @param z     The Z coordinate to check.
     * @return true, if the spot is valid, false otherwise.
     */
    private static boolean isValidTeleportSpot(World world, int x, int y, int z) {
        Block below = world.getBlock(x, y - 1, z);
        boolean solidBelow = below.getMaterial().blocksMovement();
        boolean airHere = world.isAirBlock(x, y, z);
        boolean airAbove = world.isAirBlock(x, y + 1, z);

        Block targetBlock = world.getBlock(x, y, z);
        boolean isLava = targetBlock.getMaterial() == net.minecraft.block.material.Material.lava;

        return solidBelow && airHere && airAbove && !isLava;
    }

    /**
     * Attempts to teleport the specified entity to the given coordinates.
     *
     * @param entity The entity to teleport.
     * @param x      The target X coordinate.
     * @param y      The target Y coordinate.
     * @param z      The target Z coordinate.
     * @return true, if the teleportation was successful, false otherwise.
     */
    private static boolean teleportTo(EntityLivingBase entity, double x, double y, double z) {
        EnderTeleportEvent event = new EnderTeleportEvent(entity, x, y, z, 0.0F);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        } else {
            double startX = entity.posX;
            double startY = entity.posY;
            double startZ = entity.posZ;
            entity.posX = event.targetX;
            entity.posY = event.targetY;
            entity.posZ = event.targetZ;
            boolean flag = false;
            int i = MathHelper.floor_double(entity.posX);
            int j = MathHelper.floor_double(entity.posY);
            int k = MathHelper.floor_double(entity.posZ);
            if (entity.worldObj.blockExists(i, j, k)) {
                boolean flag1 = false;

                while(!flag1 && j > 0) {
                    Block block = entity.worldObj.getBlock(i, j - 1, k);
                    if (block.getMaterial().blocksMovement()) {
                        flag1 = true;
                    } else {
                        --entity.posY;
                        --j;
                    }
                }

                if (flag1) {
                    entity.setPositionAndUpdate(entity.posX, entity.posY, entity.posZ);
                    if (entity.worldObj.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty() && !entity.worldObj.isAnyLiquid(entity.boundingBox)) {
                        flag = true;
                    }
                }
            }

            if (!flag) {
                entity.setPosition(startX, startY, startZ);
                return false;
            } else {
                short short1 = 128;

                for(int l = 0; l < short1; ++l) {
                    double d6 = (double)l / ((double)short1 - (double)1.0F);
                    float f = (entity.getRNG().nextFloat() - 0.5F) * 0.2F;
                    float f1 = (entity.getRNG().nextFloat() - 0.5F) * 0.2F;
                    float f2 = (entity.getRNG().nextFloat() - 0.5F) * 0.2F;
                    double d7 = startX + (entity.posX - startX) * d6 + (entity.getRNG().nextDouble() - (double)0.5F) * (double)entity.width * (double)2.0F;
                    double d8 = startY + (entity.posY - startY) * d6 + entity.getRNG().nextDouble() * (double)entity.height;
                    double d9 = startZ + (entity.posZ - startZ) * d6 + (entity.getRNG().nextDouble() - (double)0.5F) * (double)entity.width * (double)2.0F;
                    entity.worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
                }

                entity.worldObj.playSoundEffect(startX, startY, startZ, "saltymod:item.chorus_cookie.portal", 1.0F, 1.0F);
                entity.playSound("saltymod:item.chorus_cookie.portal", 1.0F, 1.0F);
                return true;
            }
        }
    }
}
