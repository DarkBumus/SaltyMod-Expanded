package darkbum.saltymod.event;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModItems;

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
    public void onLivingDrops(LivingDropsEvent event) {
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
            entity.entityDropItem(new ItemStack(ModItems.onion, 1), 0.0F);
        }
    }

    /**
     * Handles custom drops for squids.
     *
     * @param entity   The squid entity.
     * @param isBurning Whether the squid is burning.
     */
    private void handleSquidDrops(EntityLivingBase entity, boolean isBurning) {
        int amount = getDropAmount(3);
        int meta = isBurning ? 1 : 0;
        entity.entityDropItem(new ItemStack(ModItems.calamari, amount, meta), 0.0F);
    }

    /**
     * Handles custom drops for horses.
     *
     * @param entity   The horse entity.
     * @param isBurning Whether the horse is burning.
     */
    private void handleHorseDrops(EntityLivingBase entity, boolean isBurning) {
        int amount = getDropAmount(2);
        int meta = isBurning ? 1 : 0;
        entity.entityDropItem(new ItemStack(ModItems.haunch, amount, meta), 0.0F);
    }

    /**
     * Handles custom drops for bats.
     *
     * @param entity   The bat entity.
     * @param isBurning Whether the bat is burning.
     */
    private void handleBatDrops(EntityLivingBase entity, boolean isBurning) {
        int meta = isBurning ? 1 : 0;
        entity.entityDropItem(new ItemStack(ModItems.strider, 1, meta), 0.0F);
    }

    /**
     * Generates a random drop amount within the specified range.
     *
     * @param max The maximum amount (inclusive).
     * @return The randomly generated drop amount.
     */
    private int getDropAmount(int max) {
        return ThreadLocalRandom.current().nextInt(1, max + 1);
    }
}
