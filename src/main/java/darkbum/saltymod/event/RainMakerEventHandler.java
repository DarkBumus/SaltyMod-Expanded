package darkbum.saltymod.event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.util.RainMakerEvent;
import darkbum.saltymod.init.ModAchievementList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

public class RainMakerEventHandler {

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void rainMaker1(RainMakerEvent event) {
        if (!event.world.isRemote) {
            int i = (300 + (new Random()).nextInt(600)) * 20;
            event.world.getWorldInfo().setRainTime(i);
            event.world.getWorldInfo().setRaining(true);

            String messageKey;

            if (event.isThunder) {
                event.world.getWorldInfo().setThunderTime(i);
                event.world.getWorldInfo().setThundering(true);
                messageKey = "item.rainmaker.thunder.message";
            } else {
                event.world.getWorldInfo().setThundering(false);
                messageKey = "item.rainmaker.rain.message";
            }
            if (event.player != null) {
                event.player.addStat(ModAchievementList.make_rain, 1);
                String localizedMessage = StatCollector.translateToLocal(messageKey);
                event.player.addChatMessage(new ChatComponentText(localizedMessage));
            }
        }
    }
}
