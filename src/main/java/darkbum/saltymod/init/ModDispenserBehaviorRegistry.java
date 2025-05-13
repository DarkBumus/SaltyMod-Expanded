package darkbum.saltymod.init;

import darkbum.saltymod.dispenser.DispenserBehaviorBottle;
import darkbum.saltymod.dispenser.DispenserBehaviorPotion;
import darkbum.saltymod.dispenser.DispenserBehaviorRainmaker;
import darkbum.saltymod.dispenser.DispenserBehaviorSaltPinch;

import static net.minecraft.block.BlockDispenser.*;
import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Items.*;

/**
 * Dispenser behavior registry class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModDispenserBehaviorRegistry {

    /**
     * Initializes and registers all custom dispenser behaviors.
     */
    public static void init() {
        dispenseBehaviorRegistry.putObject(potionitem, new DispenserBehaviorPotion());
        dispenseBehaviorRegistry.putObject(glass_bottle, new DispenserBehaviorBottle());
        dispenseBehaviorRegistry.putObject(rainmaker, new DispenserBehaviorRainmaker());
        dispenseBehaviorRegistry.putObject(salt_pinch, new DispenserBehaviorSaltPinch());
    }
}
