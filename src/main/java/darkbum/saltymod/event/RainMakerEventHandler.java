package darkbum.saltymod.event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.util.RainMakerEvent;
import darkbum.saltymod.init.ModAchievementList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

/**
 * Event handler class for rainmaker-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class RainMakerEventHandler {


    /**
     * Handles setting rain or thunder conditions in the world and notifying the player through a localized chat message.
     *
     * @param event The RainMakerEvent containing world, player, and thunder status information.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void rainMaker1(RainMakerEvent event) {
        if (!event.world.isRemote) {
            int durationTicks = (300 + (new Random()).nextInt(600)) * 20;
            event.world.getWorldInfo().setRainTime(durationTicks);
            event.world.getWorldInfo().setRaining(true);

            String messageKey;

            if (event.isThunder) {
                event.world.getWorldInfo().setThunderTime(durationTicks);
                event.world.getWorldInfo().setThundering(true);
                messageKey = "item.rainmaker.mess.thunder";
            } else {
                event.world.getWorldInfo().setThundering(false);
                messageKey = "item.rainmaker.mess.rain";
            }
            if (event.player != null) {
                event.player.addStat(ModAchievementList.make_rain, 1);
                String localizedMessage = StatCollector.translateToLocal(messageKey);
                event.player.addChatMessage(new ChatComponentText(localizedMessage));
            }
        }
    }
}
