package darkbum.saltymod.event;

import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;

import java.util.HashMap;
import java.util.Map;

/**
 * Event handler class for item pickup-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EntityItemPickupEventHandler {

    private static final Map<Item, Achievement> ACHIEVEMENT_MAP = new HashMap<>();

    static {
        ACHIEVEMENT_MAP.put(ModItems.salt, ModAchievementList.find_salt);
        ACHIEVEMENT_MAP.put(ModItems.salt_shard, ModAchievementList.find_salt_crystal);
        ACHIEVEMENT_MAP.put(ModItems.mineral_mud_ball, ModAchievementList.find_mineral_mud);
        ACHIEVEMENT_MAP.put(ModItems.saltwort, ModAchievementList.find_saltwort);
        ACHIEVEMENT_MAP.put(ModItems.dough, ModAchievementList.find_dough);
        ACHIEVEMENT_MAP.put(Item.getItemFromBlock(ModBlocks.dry_mud_brick), ModAchievementList.find_mud_brick);
        ACHIEVEMENT_MAP.put(ModItems.onion, ModAchievementList.find_onion);
    }

    /**
     * Handles awarding achievements for picking up specific items.
     *
     * @param event The pickup event, providing the player and the item they picked up.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        World world = event.entityPlayer.worldObj;
        if (!world.isRemote) {
            Item pickedItem = event.item.getEntityItem().getItem();
            Achievement achievement = ACHIEVEMENT_MAP.get(pickedItem);

            if (achievement != null) {
                event.entityPlayer.addStat(achievement, 1);
            }
        }
    }
}
