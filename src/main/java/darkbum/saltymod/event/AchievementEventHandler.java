package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.AchievementEvent;

/**
 * Event handler class for achievement-related events.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class AchievementEventHandler {

    /**
     * Handles the display of a custom chat message when the player earns the "effect_swarmed" achievement.
     * <p>
     * The message will only be shown once per player, using persistent NBT data to track its state.
     *
     * @param event The achievement event containing the player and the achievement data.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onAchievement(AchievementEvent event) {
        if (!(event.entityPlayer instanceof EntityPlayerMP player)) return;

        if (event.achievement == ModAchievementList.effect_swarmed) {
            NBTTagCompound data = player.getEntityData();
            NBTTagCompound persist = data.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

            if (!data.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
                data.setTag(EntityPlayer.PERSISTED_NBT_TAG, persist);
            }
            if (!persist.getBoolean("effect_swarmed_shown")) {
                persist.setBoolean("effect_swarmed_shown", true);

                player.addChatMessage(new ChatComponentText(
                    I18n.format("achievementevent.effect_swarmed.mess")
                ));
            }
        }
    }
}
