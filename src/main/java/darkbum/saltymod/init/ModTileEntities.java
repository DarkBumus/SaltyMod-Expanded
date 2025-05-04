package darkbum.saltymod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.tileentity.*;

public class ModTileEntities {

    public static void init() {

        if(ModConfigurationBlocks.enableEvaporator) {
            GameRegistry.registerTileEntity(TileEntityEvaporator.class, "tileEntityEvaporator");
        }
        if(ModConfigurationBlocks.enableFishFarm) {
            GameRegistry.registerTileEntity(TileEntityFishFarm.class, "tileEntityFishFarm");
        }
        if(ModConfigurationBlocks.enableApiary) {
            GameRegistry.registerTileEntity(TileEntityApiary.class, "tileEntityApiary");
        }
        if(ModConfigurationBlocks.enableMachines) {
            GameRegistry.registerTileEntity(TileEntityPress.class, "tileEntityPress");
            GameRegistry.registerTileEntity(TileEntityCookingPot.class, "tileEntityCookingPot");
            GameRegistry.registerTileEntity(TileEntityClayOven.class, "tileEntityClayOven");
        }
    }
}
