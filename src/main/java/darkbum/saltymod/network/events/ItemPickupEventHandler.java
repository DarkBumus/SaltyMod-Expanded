package darkbum.saltymod.network.events;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class ItemPickupEventHandler {

    @SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event) {
        World world = event.entityPlayer.worldObj;
        if (!world.isRemote) {
            if (event.item.getEntityItem()
                .getItem() == ModItems.salt) {
                event.entityPlayer.addStat(ModAchievementList.findSalt, 1);
            }
            if (event.item.getEntityItem()
                .getItem() == ModItems.salt_shard) {
                event.entityPlayer.addStat(ModAchievementList.findSaltCrystal, 1);
            }
            if (event.item.getEntityItem()
                .getItem() == ModItems.mineral_mud_ball) {
                event.entityPlayer.addStat(ModAchievementList.findMineralMud, 1);
            }
            if (event.item.getEntityItem()
                .getItem() == ModItems.saltwort) {
                event.entityPlayer.addStat(ModAchievementList.findSaltwort, 1);
            }
            if (event.item.getEntityItem()
                .getItem() == Item.getItemFromBlock(ModBlocks.dry_mud_brick)) {
                event.entityPlayer.addStat(ModAchievementList.findMudBrick, 1);
            }
            if (event.item.getEntityItem()
                .getItem() == ModItems.onion) {
                event.entityPlayer.addStat(ModAchievementList.findOnion, 1);
            }
        }
    }
}
