package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Map;
import java.util.WeakHashMap;

import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.event.LivingDropsEventHandler.*;
import static net.minecraft.init.Items.*;

public class LivingUpdateEventHandler {

    private final Map<EntityChicken, Integer> lastEggTimers = new WeakHashMap<>();

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entity.worldObj.isRemote || !(event.entityLiving instanceof EntityChicken entity) || !chickensShedFeathers) return;
        if (entity.isChild() && !babyChickensDropFeathers) return;

        if (entity.worldObj.rand.nextInt(featherSheddingFrequency) == 0) {
            entity.entityDropItem(new ItemStack(feather, 1, 0), 0.0f);
        }

        if (chickensShedFeathersWithEggs) {
            int current = entity.timeUntilNextEgg;
            Integer previous = lastEggTimers.get(entity);

            if (previous != null && current > previous) {
                int amount = getDropAmount(chickensAlwaysDropFeathers ? 1 : 0, 1);
                entity.entityDropItem(new ItemStack(feather, amount, 0), 0.0f);
            }

            lastEggTimers.put(entity, current);
        }
    }
}
