package darkbum.saltymod.network.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.configuration.configs.ModConfigurationEffects;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraft.potion.PotionEffect;

public class PlayerPickupXpEventHandler {

    @SubscribeEvent
    public void playerPickupXp(PlayerPickupXpEvent event) {
        EntityPlayer player = event.entityPlayer;
        EntityXPOrb orb = event.orb;

        if (player.isPotionActive(ModPotion.inspired)) {

            PotionEffect effect = player.getActivePotionEffect(ModPotion.inspired);

            int level = effect.getAmplifier();

            int originalXP = orb.xpValue;
            orb.xpValue = 0;

            float multiplier = Math.max(ModConfigurationEffects.inspiredEffectStrength * (level + 1), 0.0f);

            int newXP = Math.round(originalXP * (1.0f + multiplier));

            player.addExperience(newXP);
        }
    }
}
