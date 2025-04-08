package darkbum.saltymod.network.events;

import net.minecraft.util.MathHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBiomes;

public class TickPlayerTickEventHandler {

    @SubscribeEvent
    public void TickPlayerTick1(TickEvent.PlayerTickEvent event) {
        int px = MathHelper.floor_double(event.player.posX);
        int pz = MathHelper.floor_double(event.player.posZ);
        if (event.player.worldObj.getBiomeGenForCoords(px, pz) == ModBiomes.saltMarsh) {
            event.player.addStat(ModAchievementList.navSaltMarsh, 1);
        }
    }
}
