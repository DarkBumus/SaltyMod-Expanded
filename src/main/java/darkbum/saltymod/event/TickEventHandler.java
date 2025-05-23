package darkbum.saltymod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBiomes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Event handler class for chunk population-related events.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class TickEventHandler {

    private static final List<TickEventHandler.DelayedAchievement> delayedAchievements = new ArrayList<>();

    /**
     * Handles awarding the player the "Navigate Salt Marsh" achievement if they are located in the Salt Marsh biome.
     *
     * @param event The {@link TickEvent.PlayerTickEvent} instance.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        int px = MathHelper.floor_double(event.player.posX);
        int pz = MathHelper.floor_double(event.player.posZ);

        if (event.player.worldObj.getBiomeGenForCoords(px, pz) == ModBiomes.saltMarsh) {
            event.player.addStat(ModAchievementList.nav_salt_marsh, 1);
        }
    }


    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<DelayedAchievement> iterator = delayedAchievements.iterator();
            while (iterator.hasNext()) {
                DelayedAchievement da = iterator.next();
                da.tick();
                if (da.isReady()) {
                    da.grant();
                    iterator.remove();
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public static void addDelayedAchievement(EntityPlayer player, Achievement achievement, int delayTicks) {
        delayedAchievements.add(new DelayedAchievement(player, achievement, delayTicks));
    }

    @SuppressWarnings("unused")
    public static void addDelayedAchievement(EntityPlayer player, Achievement achievement) {
        delayedAchievements.add(new DelayedAchievement(player, achievement, 63));
    }

    private static class DelayedAchievement {
        private final EntityPlayer player;
        private final Achievement achievement;
        private int remainingTicks;

        public DelayedAchievement(EntityPlayer player, Achievement achievement, int delayTicks) {
            this.player = player;
            this.achievement = achievement;
            this.remainingTicks = delayTicks;
        }

        public void tick() {
            remainingTicks--;
        }

        public boolean isReady() {
            return remainingTicks <= 0;
        }

        public void grant() {
            player.addStat(achievement, 1);
        }
    }
}
