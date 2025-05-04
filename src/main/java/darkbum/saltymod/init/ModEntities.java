package darkbum.saltymod.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.config.ModConfigurationEntities;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class ModEntities {

    static int startEntityId = 600;

    public static void init() {
        EntityRegistry.registerModEntity(EntityRainmaker.class, "rainmaker", 0, SaltyMod.instance, 64, 20, true);
        EntityRegistry.registerModEntity(EntityRainmakerDust.class, "rainmaker_dust", 1, SaltyMod.instance, 64, 20, false);
        if (ModConfigurationEntities.enableHornedSheep) {
            EntityRegistry.registerModEntity(EntityHornedSheep.class, "horned_sheep", 2, SaltyMod.instance, 64, 3, true);
            registerEntityEgg(EntityHornedSheep.class, 15198183, 9663326);
        }
    }

    public static int getUniqueEntityId() {
        while (true) {
            startEntityId++;
            if (EntityList.getStringFromID(startEntityId) == null) return startEntityId;
        }
    }

    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
        EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
