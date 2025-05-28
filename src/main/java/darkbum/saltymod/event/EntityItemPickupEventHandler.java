package darkbum.saltymod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import static darkbum.saltymod.init.ModAchievementList.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;

/**
 * Event handler class for item pickup-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EntityItemPickupEventHandler {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void onEntityItemPickup(EntityItemPickupEvent event) {
        EntityPlayer player = event.entityPlayer;
        World world = player.worldObj;

        if (!world.isRemote) {
            Item pickedItem = event.item.getEntityItem().getItem();

            if (pickedItem == salt) {
                player.addStat(find_salt, 1);
            } else if (pickedItem == salt_shard) {
                player.addStat(find_salt_crystal, 1);
            } else if (pickedItem == mineral_mud_ball) {
                player.addStat(find_mineral_mud, 1);
            } else if (pickedItem == saltwort) {
                player.addStat(find_saltwort, 1);
            } else if (pickedItem == dough) {
                player.addStat(find_dough, 1);
            } else if (pickedItem == Item.getItemFromBlock(dry_mud_brick)) {
                player.addStat(find_mud_brick, 1);
            } else if (pickedItem == onion) {
                player.addStat(find_onion, 1);
            }
        }
    }
}
