package darkbum.saltymod.event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

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
     * @param event The RainmakerEvent containing world, player, and thunder status information.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onRainmaker(RainmakerEvent event) {
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

    /**
     * Static event class for handling rain-making actions.
     * This event is fired when the rain-making action occurs, containing the relevant information
     * about the world, position, player, and whether it is thunder or just rain.
     */
    @Cancelable
    public static class RainmakerEvent extends Event {

        public final World world;
        public final double x;
        public final double y;
        public final double z;
        public final EntityPlayer player;
        public final boolean isThunder;

        /**
         * Constructs a new RainmakerEvent.
         *
         * @param world the world where the event takes place
         * @param x the X coordinate of the event's position
         * @param y the Y coordinate of the event's position
         * @param z the Z coordinate of the event's position
         * @param player the player who triggered the event
         * @param isThunder whether the event is thunder or just rain
         */
        public RainmakerEvent(World world, double x, double y, double z, EntityPlayer player, boolean isThunder) {
            this.world = world;
            this.x = x;
            this.y = y;
            this.z = z;
            this.player = player;
            this.isThunder = isThunder;
        }
    }
}
