package darkbum.saltymod.init;

import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerExplosion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import static cpw.mods.fml.common.registry.EntityRegistry.*;
import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.*;

/**
 * Entities class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModEntities {

    static int startEntityId = 600;

    /**
     * Initializes and registers all entities.
     */
    public static void init() {
        if (enableRainmaker) {
            registerModEntity(EntityRainmaker.class, "rainmaker", 0, SaltyMod.instance, 64, 20, true);
            registerModEntity(EntityRainmakerExplosion.class, "rainmaker_dust", 1, SaltyMod.instance, 64, 20, false);
        }
        if (enableHornedSheep) {
            registerModEntity(EntityHornedSheep.class, "horned_sheep", 2, SaltyMod.instance, 64, 3, true);
            registerEntityEgg(EntityHornedSheep.class, 15198183, 9663326);
        }
    }

    /**
     * Finds a unique entity ID that is not currently in use.
     * This method ensures that entity IDs do not conflict with other mods.
     *
     * @return a unique entity ID.
     */
    public static int getUniqueEntityId() {
        while (true) {
            startEntityId++;
            if (EntityList.getStringFromID(startEntityId) == null) return startEntityId;
        }
    }

    /**
     * Registers a spawn egg for a custom entity.
     * The egg will be assigned a primary and secondary color for its appearance in the game.
     *
     * @param entity        The entity class to register the egg for.
     * @param primaryColor  The primary color of the spawn egg.
     * @param secondaryColor The secondary color of the spawn egg.
     */
    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
