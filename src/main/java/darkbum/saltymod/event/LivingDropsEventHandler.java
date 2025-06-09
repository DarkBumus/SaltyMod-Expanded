package darkbum.saltymod.event;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Items.*;

/**
 * Event handler class for entity drops-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class LivingDropsEventHandler {

    public static Random random;
    public static int dropped;

    /**
     * Handles the custom drops for specific mobs.
     *
     * @param event The event containing drop information for the dying entity.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onLivingDrop(LivingDropsEvent event) {
        EntityLivingBase entity = event.entityLiving;
        boolean isBurning = entity.isBurning();
        boolean isChild = entity.isChild();

        if (entity instanceof EntityZombie && !isChild) {
            handleZombieDrops(entity);
        } else if (entity instanceof EntitySquid) {
            handleSquidDrops(entity, isBurning);
        } else if (entity instanceof EntityHorse && !isChild) {
            handleHorseDrops(entity, isBurning);
        } else if (entity instanceof EntityBat) {
            handleBatDrops(entity, isBurning);
        } else if (babyChickensDropFeathers && entity instanceof EntityChicken && isChild) {
            handleBabyChickenDrops(entity);
        } else if (chickensAlwaysDropFeathers && entity instanceof EntityChicken && !isChild) {
            handleChickenDrops(entity, event);
        }
    }

    /**
     * Handles custom drops for zombies.
     *
     * @param entity The zombie entity.
     */
    private void handleZombieDrops(EntityLivingBase entity) {
        int dropChance = ThreadLocalRandom.current().nextInt(1000);
        if (dropChance < 25) {
            if (onion != null) entity.entityDropItem(new ItemStack(onion, 1), 0.0f);
        }
    }

    /**
     * Handles custom drops for squids.
     *
     * @param entity   The squid entity.
     * @param isBurning Whether the squid is burning.
     */
    private void handleSquidDrops(EntityLivingBase entity, boolean isBurning) {
        int amount = getDropAmount(1, 3);
        int meta = isBurning ? 1 : 0;
        if (calamari != null) entity.entityDropItem(new ItemStack(calamari, amount, meta), 0.0f);
    }

    /**
     * Handles custom drops for horses.
     *
     * @param entity   The horse entity.
     * @param isBurning Whether the horse is burning.
     */
    private void handleHorseDrops(EntityLivingBase entity, boolean isBurning) {
        int amount = getDropAmount(1, 2);
        int meta = isBurning ? 1 : 0;
        if (haunch != null) entity.entityDropItem(new ItemStack(haunch, amount, meta), 0.0f);
    }

    /**
     * Handles custom drops for bats.
     *
     * @param entity   The bat entity.
     * @param isBurning Whether the bat is burning.
     */
    private void handleBatDrops(EntityLivingBase entity, boolean isBurning) {
        int meta = isBurning ? 1 : 0;
        if (strider != null) entity.entityDropItem(new ItemStack(strider, 1, meta), 0.0f);
    }

    /**
     * Handles custom drops for baby chickens.
     *
     * @param entity   The bat entity.
     */
    private void handleBabyChickenDrops(EntityLivingBase entity) {
        int amount = getDropAmount(chickensAlwaysDropFeathers ? 1 : 0, 1);
        entity.entityDropItem(new ItemStack(feather, amount, 0), 0.0f);
    }

    /**
     * Handles custom drops for chickens.
     *
     * @param entity   The bat entity.
     */
    private void handleChickenDrops(EntityLivingBase entity, LivingDropsEvent event) {
        boolean hasFeatherAlready = false;

        for (EntityItem drop : event.drops) {
            ItemStack stack = drop.getEntityItem();
            if (stack != null && stack.getItem() == feather) {
                hasFeatherAlready = true;
                break;
            }
        }
        if (!hasFeatherAlready) {
            entity.entityDropItem(new ItemStack(feather, 1, 0), 0.0f);
        }
    }

    /**
     * Generates a random drop amount within the specified range.
     *
     * @param max The maximum amount (inclusive).
     * @return The randomly generated drop amount.
     */
    public static int getDropAmount(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min may not be larger than max!");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
