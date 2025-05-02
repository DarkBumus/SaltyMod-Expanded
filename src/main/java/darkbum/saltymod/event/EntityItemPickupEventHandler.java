package darkbum.saltymod.event;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

public class EntityItemPickupEventHandler {

    @SubscribeEvent
    public void entityItemPickup1(EntityItemPickupEvent event) {
        World world = event.entityPlayer.worldObj;
        if (!world.isRemote) {
            if (event.item.getEntityItem().getItem() == ModItems.salt) {
                event.entityPlayer.addStat(ModAchievementList.find_salt, 1);
            }
            if (event.item.getEntityItem().getItem() == ModItems.salt_shard) {
                event.entityPlayer.addStat(ModAchievementList.find_salt_crystal, 1);
            }
            if (event.item.getEntityItem().getItem() == ModItems.mineral_mud_ball) {
                event.entityPlayer.addStat(ModAchievementList.find_mineral_mud, 1);
            }
            if (event.item.getEntityItem().getItem() == ModItems.saltwort) {
                event.entityPlayer.addStat(ModAchievementList.find_saltwort, 1);
            }
            if (event.item.getEntityItem().getItem() == ModItems.dough) {
                event.entityPlayer.addStat(ModAchievementList.find_dough, 1);
            }
            if (event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.dry_mud_brick)) {
                event.entityPlayer.addStat(ModAchievementList.find_mud_brick, 1);
            }
            if (event.item.getEntityItem().getItem() == ModItems.onion) {
                event.entityPlayer.addStat(ModAchievementList.find_onion, 1);
            }
        }
    }
}
