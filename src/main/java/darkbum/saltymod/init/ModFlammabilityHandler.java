package darkbum.saltymod.init;

import net.minecraft.block.BlockFire;
import net.minecraft.init.Blocks;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationItems.enableOnion;
import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;
import static darkbum.saltymod.init.ModExternalLoader.*;

/**
 * Flammability Handler class.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModFlammabilityHandler {

    /**
     * Initializes all flammability values.
     */
    public static void init() {
        BlockFire fire = Blocks.fire;

        if (enableSaltMarsh) fire.setFireInfo(ModBlocks.salt_crusted_oak_log, 5, 5);
        if (enableFishFarm) fire.setFireInfo(ModBlocks.fish_farm, 5, 20);
        if (enableApiary) fire.setFireInfo(ModBlocks.bee_nest, 10, 40);
        if (enableApiary) fire.setFireInfo(ModBlocks.bee_burrow, 10, 10);
        if (enableApiary && efr) fire.setFireInfo(ModBlocks.bee_burrow_stripped, 10, 10);
        if (enableApiary) fire.setFireInfo(ModBlocks.apiary, 5, 20);
        if (enableMachines) fire.setFireInfo(ModBlocks.press, 5, 20);
        if (enableMachines) fire.setFireInfo(ModBlocks.mill, 5, 20);
        if (enableStorageBlocks) fire.setFireInfo(ModBlocks.storage_crate, 5, 20);
        if (enableStorageBlocks) fire.setFireInfo(ModBlocks.storage_barrel, 5, 20);
        if (enableStorageBlocks) fire.setFireInfo(ModBlocks.storage_sack, 30, 60);
        if (enableOnion) fire.setFireInfo(ModBlocks.onions, 60, 100);
        fire.setFireInfo(ModBlocks.saltworts, 60, 100);
        if (enableSaltFlowers) fire.setFireInfo(ModBlocks.salt_flower_d, 60, 100);
        if (enableSaltMarsh) fire.setFireInfo(ModBlocks.marsh_reeds_t, 60, 100);
    }
}
