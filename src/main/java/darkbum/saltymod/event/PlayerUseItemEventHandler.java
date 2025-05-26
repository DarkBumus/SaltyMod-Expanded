package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.item.ItemSaltFoodBase;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

/**
 * Event handler class for item use-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class PlayerUseItemEventHandler {

    /**
     * Handles awarding a specific achievement
     * when the player consumes a muffin while under the "Well Fed" potion effect.
     *
     * @param event The PlayerUseItemEvent.Finish event containing item and player information.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerUseItemFinish(PlayerUseItemEvent.Finish event) {
        if (event.item == null || !(event.item.getItem() instanceof ItemSaltFoodBase)) return;

        EntityPlayer player = event.entityPlayer;

        if (event.item.getItem() == ModItems.muffin && player.isPotionActive(ModPotion.wellFed)) {
            player.addStat(ModAchievementList.consumespec_muffin, 1);
        }
    }
}
