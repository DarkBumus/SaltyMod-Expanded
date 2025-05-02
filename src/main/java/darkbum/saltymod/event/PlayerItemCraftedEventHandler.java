package darkbum.saltymod.event;

import net.minecraft.item.Item;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class PlayerItemCraftedEventHandler {

    @SubscribeEvent
    public void playerItemCrafted1(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == ModItems.mineral_mud_ball) {
            event.player.addStat(ModAchievementList.find_mineral_mud, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(ModBlocks.apiary)) {
            event.player.addStat(ModAchievementList.craft_apiary, 1);
        }
    }
}
