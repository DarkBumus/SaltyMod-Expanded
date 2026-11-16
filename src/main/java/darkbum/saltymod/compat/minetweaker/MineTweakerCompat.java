
package darkbum.saltymod.compat.minetweaker;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.SaltyMod;
import minetweaker.MineTweakerAPI;

public class MineTweakerCompat {

    public static void init() {
        if (!Loader.isModLoaded("MineTweaker3")) {
            return;
        }

        MineTweakerAPI.registerClass(CookingPot.class);
        MineTweakerAPI.registerClass(ClayOven.class);
        MineTweakerAPI.registerClass(Press.class);

        SaltyMod.logger.info("MineTweaker integration initialized");
    }
}
