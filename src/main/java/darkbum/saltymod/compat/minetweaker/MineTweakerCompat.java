
package darkbum.saltymod.compat.minetweaker;

import cpw.mods.fml.common.Loader;
import minetweaker.MineTweakerAPI;

import static darkbum.saltymod.SaltyMod.*;
import static darkbum.saltymod.common.config.ModConfigurationModCompatibility.*;

public class MineTweakerCompat {

    public static void init() {
        if (Loader.isModLoaded("MineTweaker3") && enableMineTweakerSupport) {

            MineTweakerAPI.registerClass(CookingPot.class);
            MineTweakerAPI.registerClass(ClayOven.class);
            MineTweakerAPI.registerClass(Press.class);

            logger.info("Initialized MineTweaker Integration");
        }
    }
}
