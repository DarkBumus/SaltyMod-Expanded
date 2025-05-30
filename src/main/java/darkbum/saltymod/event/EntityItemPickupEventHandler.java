package darkbum.saltymod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import static darkbum.saltymod.init.ModAchievementList.*;
import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.init.ModItems.*;
import static darkbum.saltymod.util.AchievementHelper.*;
import static net.minecraft.item.Item.*;

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

            tryAward(player, pickedItem, salt, find_salt);
            tryAward(player, pickedItem, salt_shard, find_salt_shard);
            tryAward(player, pickedItem, mineral_mud_ball, find_mineral_mud);
            tryAward(player, pickedItem, saltwort, find_saltwort);
            tryAward(player, pickedItem, dough, find_dough);
            tryAward(player, pickedItem, getItemFromBlock(dry_mud_brick), find_mud_brick);
            tryAward(player, pickedItem, onion, find_onion);
        }
    }
}
