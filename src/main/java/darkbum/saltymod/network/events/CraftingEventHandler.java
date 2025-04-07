package darkbum.saltymod.network.events;

import net.minecraft.item.Item;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class CraftingEventHandler {

    @SubscribeEvent
    public void crafting(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == ModItems.mineral_mud_ball) {
            event.player.addStat(ModAchievementList.findMineralMud, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(ModBlocks.apiary)) {
            event.player.addStat(ModAchievementList.craftApiary, 1);
        }
    }
}
