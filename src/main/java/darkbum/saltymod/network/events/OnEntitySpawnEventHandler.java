package darkbum.saltymod.network.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.entity.ai.EntityAICustomEatGrass;

public class OnEntitySpawnEventHandler {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.entity;

        if (entity instanceof EntitySheep) {
            EntitySheep sheep = (EntitySheep) entity;
            sheep.tasks.addTask(4, new EntityAICustomEatGrass(sheep));
        }
    }
}
