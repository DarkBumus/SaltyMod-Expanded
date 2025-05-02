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

public class ItemChorusCookie extends ItemSaltFood {

    public ItemChorusCookie(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        this.addVariant(0, "chorus_cookie", "chorus_cookie", 2, 0.1f, false);
        setAlwaysEdible();
    }

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

    private static boolean isValidTeleportSpot(World world, int x, int y, int z) {
        Block below = world.getBlock(x, y - 1, z);
        boolean solidBelow = below.getMaterial().blocksMovement();
        boolean airHere = world.isAirBlock(x, y, z);
        boolean airAbove = world.isAirBlock(x, y + 1, z);

        Block targetBlock = world.getBlock(x, y, z);
        boolean isLava = targetBlock.getMaterial() == net.minecraft.block.material.Material.lava;

        return solidBelow && airHere && airAbove && !isLava;
    }

    private static boolean teleportTo(EntityLivingBase entity, double xx, double yy, double zz) {
        EnderTeleportEvent event = new EnderTeleportEvent(entity, xx, yy, zz, 0.0F);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        } else {
            double d3 = entity.posX;
            double d4 = entity.posY;
            double d5 = entity.posZ;
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
                entity.setPosition(d3, d4, d5);
                return false;
            } else {
                short short1 = 128;

                for(int l = 0; l < short1; ++l) {
                    double d6 = (double)l / ((double)short1 - (double)1.0F);
                    float f = (entity.getRNG().nextFloat() - 0.5F) * 0.2F;
                    float f1 = (entity.getRNG().nextFloat() - 0.5F) * 0.2F;
                    float f2 = (entity.getRNG().nextFloat() - 0.5F) * 0.2F;
                    double d7 = d3 + (entity.posX - d3) * d6 + (entity.getRNG().nextDouble() - (double)0.5F) * (double)entity.width * (double)2.0F;
                    double d8 = d4 + (entity.posY - d4) * d6 + entity.getRNG().nextDouble() * (double)entity.height;
                    double d9 = d5 + (entity.posZ - d5) * d6 + (entity.getRNG().nextDouble() - (double)0.5F) * (double)entity.width * (double)2.0F;
                    entity.worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
                }

                entity.worldObj.playSoundEffect(d3, d4, d5, "saltymod:item.chorus_cookie.portal", 1.0F, 1.0F);
                entity.playSound("saltymod:item.chorus_cookie.portal", 1.0F, 1.0F);
                return true;
            }
        }
    }
}
