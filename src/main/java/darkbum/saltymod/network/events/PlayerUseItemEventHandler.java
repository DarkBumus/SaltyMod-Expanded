package darkbum.saltymod.network.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.item.ItemSaltFood;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

public class PlayerUseItemEventHandler {

    @SubscribeEvent
    public void playerUseItem(PlayerUseItemEvent.Finish event) {
        if (event.item != null && event.item.getItem() instanceof ItemSaltFood) {
            EntityPlayer player = event.entityPlayer;

            if (event.item.getItem() == ModItems.muffin) {
                if (player.isPotionActive(ModPotion.wellFed)) {
                    player.addStat(ModAchievementList.consumespec_muffin, 1);
                }
            }
        }
    }
}
