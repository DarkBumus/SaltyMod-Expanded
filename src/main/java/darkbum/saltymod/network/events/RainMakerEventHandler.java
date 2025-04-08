package darkbum.saltymod.network.events;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.api.RainMakerEvent;
import darkbum.saltymod.init.ModAchievementList;

public class RainMakerEventHandler {

    @SubscribeEvent
    public void rainMaker1(RainMakerEvent event) {
        if (!event.world.isRemote) {
            int i = (300 + (new Random()).nextInt(600)) * 20;
            event.world.getWorldInfo()
                .setRainTime(i);
            event.world.getWorldInfo()
                .setRaining(true);
            if (event.isThunder) {
                event.world.getWorldInfo()
                    .setThunderTime(i);
                event.world.getWorldInfo()
                    .setThundering(true);
            } else {
                event.world.getWorldInfo()
                    .setThundering(false);
            }
            if (event.player != null) {
                event.player.addStat(ModAchievementList.makeRain, 1);
            }
        }
    }
}
