package darkbum.saltymod.init;

import darkbum.saltymod.dispenser.DispenserBehaviorBottle;
import darkbum.saltymod.dispenser.DispenserBehaviorPotion;
import darkbum.saltymod.dispenser.DispenserBehaviorRainmaker;
import darkbum.saltymod.dispenser.DispenserBehaviorSaltPinch;
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Items;

public class ModDispenserBehaviorRegistry {

    public static void init() {
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.potionitem, new DispenserBehaviorPotion());
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.glass_bottle, new DispenserBehaviorBottle());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.rainmaker, new DispenserBehaviorRainmaker());
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.salt_pinch, new DispenserBehaviorSaltPinch());
    }
}
