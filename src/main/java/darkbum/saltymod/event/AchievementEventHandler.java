package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModAchievementList;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.AchievementEvent;

public class AchievementEventHandler {

    @SubscribeEvent
    public void onAchievementEarned(AchievementEvent event) {
        if (!(event.entityPlayer instanceof EntityPlayerMP)) return;

        EntityPlayerMP player = (EntityPlayerMP) event.entityPlayer;

        if (event.achievement == ModAchievementList.effect_swarmed) {
            NBTTagCompound data = player.getEntityData();
            NBTTagCompound persist;

            // Sicherstellen, dass es den "Persisted"-Tag gibt
            if (!data.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
                persist = new NBTTagCompound();
                data.setTag(EntityPlayer.PERSISTED_NBT_TAG, persist);
            } else {
                persist = data.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
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
