package darkbum.saltymod.event;

import darkbum.saltymod.entity.ai.EntityAICustomEatGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkbum.saltymod.init.ModItems;

/**
 * Event handler class for entity behavior-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EntityJoinWorldEventHandler {

    /**
     * Handles adding custom AI tasks to specific entities.
     *
     * @param event The event containing the entity joining the world.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityAnimal animal) {
            if (animal instanceof net.minecraft.entity.passive.EntityCow
                || animal instanceof net.minecraft.entity.passive.EntityHorse) {
                animal.tasks.addTask(3, new EntityAITempt(animal, 1.25D, ModItems.salt, false));
            }
            if (animal instanceof net.minecraft.entity.passive.EntityPig) {
                animal.tasks.addTask(4, new EntityAITempt(animal, 1.25D, ModItems.onion, false));
            }

            if (animal instanceof EntitySheep sheep) {
                sheep.tasks.addTask(4, new EntityAICustomEatGrass(sheep));
            }
        }
    }
}
