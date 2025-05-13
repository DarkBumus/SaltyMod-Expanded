package darkbum.saltymod.init;

import darkbum.saltymod.tileentity.*;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.util.ConditionalRegistrar.*;

/**
 * Tile Entity class.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModTileEntities {

    /**
     * Initializes all tile entities.
     */
    public static void init() {
        registerTileEntity(TileEntityEvaporator.class, enableEvaporator);
        registerTileEntity(TileEntityFishFarm.class, enableFishFarm);
        registerTileEntity(TileEntityApiary.class, enableApiary);
        registerTileEntity(TileEntityPress.class, enableMachines);
        registerTileEntity(TileEntityCookingPot.class, enableMachines);
        registerTileEntity(TileEntityClayOven.class, enableMachines);
    }
}
