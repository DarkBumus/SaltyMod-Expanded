package darkbum.saltymod.event;

import net.minecraft.util.MathHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBiomes;

/**
 * Event handler class for chunk population-related events.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class TickPlayerTickEventHandler {

    /**
     * Handles awarding the player the "Navigate Salt Marsh" achievement if they are located in the Salt Marsh biome.
     *
     * @param event The {@link TickEvent.PlayerTickEvent} instance.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void TickPlayerTick(TickEvent.PlayerTickEvent event) {
        int px = MathHelper.floor_double(event.player.posX);
        int pz = MathHelper.floor_double(event.player.posZ);

        if (event.player.worldObj.getBiomeGenForCoords(px, pz) == ModBiomes.saltMarsh) {
            event.player.addStat(ModAchievementList.nav_salt_marsh, 1);
        }
    }
}
