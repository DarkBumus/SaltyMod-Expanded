package darkbum.saltymod.network.events;

import darkbum.saltymod.entity.ai.EntityAICustomEatGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModItems;

public class EntityJoinWorldEventHandler {

    @SubscribeEvent
    public void entityJoinWorld1(EntityJoinWorldEvent event) {
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

    @SubscribeEvent
    public void entityJoinWorld2(EntityJoinWorldEvent event) {
        Entity entity = event.entity;

        if (entity instanceof EntitySheep) {
            EntitySheep sheep = (EntitySheep) entity;
            sheep.tasks.addTask(4, new EntityAICustomEatGrass(sheep));
        }
    }
}
