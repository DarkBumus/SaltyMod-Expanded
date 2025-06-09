package darkbum.saltymod.init;

import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerExplosion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<Class<? extends Entity>, Integer> ENTITY_IDS = new HashMap<>();
    static int startEntityId = 600;

    /**
     * Initializes and registers all entities.
     */
    public static void init() {
        if (enableRainmaker) {
            int rainmakerId = getUniqueEntityId();
            registerModEntity(EntityRainmaker.class, "rainmaker", rainmakerId, SaltyMod.instance, 64, 20, true);
            int rainmakerExplosionId = getUniqueEntityId();
            registerModEntity(EntityRainmakerExplosion.class, "rainmaker_explosion", rainmakerExplosionId, SaltyMod.instance, 64, 20, false);
        }
        if (enableHornedSheep) {
            int hornedSheepId = getUniqueEntityId();
            registerModEntity(EntityHornedSheep.class, "horned_sheep", hornedSheepId, SaltyMod.instance, 64, 3, true);
            registerEntityEgg(EntityHornedSheep.class, hornedSheepId, 15198183, 9663326);
        }
    }

    /**
     * Finds a unique entity ID that is not currently in use.
     * This method ensures that entity IDs do not conflict with other mods.
     *
     * @return a unique entity ID.
     */
    public static int getUniqueEntityId() {
        while (EntityList.getStringFromID(startEntityId) != null) {
            startEntityId++;
        }
        int id = startEntityId;
        startEntityId++;
        return id;
    }

    /**
     * Registers a spawn egg for a custom entity.
     * The egg will be assigned a primary and secondary color for its appearance in the game.
     *
     * @param entity        The entity class to register the egg for.
     * @param primaryColor  The primary color of the spawn egg.
     * @param secondaryColor The secondary color of the spawn egg.
     */
    public static void registerEntityEgg(Class<? extends Entity> entity, int id, int primaryColor, int secondaryColor) {
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
        ENTITY_IDS.put(entity, id);
    }

    /**
     * Retrieves the spawn egg meta associated with the given entity class.
     *
     * @param clazz The entity class for which to get the spawn egg ID.
     * @return the spawn egg metadata if registered, otherwise null.
     */
    public static Integer getEntityEggId(Class<? extends Entity> clazz) {
        return ENTITY_IDS.get(clazz);
    }
}
