package darkbum.saltymod.network.events;

import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModItems;

public class AddTemptEventHandler {

    @SubscribeEvent
    public void addTempt(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityAnimal) {
            EntityAnimal animal = (EntityAnimal) event.entity;
            if (animal instanceof net.minecraft.entity.passive.EntityCow
                || animal instanceof net.minecraft.entity.passive.EntityHorse) {
                animal.tasks.addTask(3, new EntityAITempt(animal, 1.25D, ModItems.salt, false));
            }
            if (animal instanceof net.minecraft.entity.passive.EntityPig) {
                animal.tasks.addTask(3, new EntityAITempt(animal, 1.25D, ModItems.onion, false));
            }
        }
    }
}
