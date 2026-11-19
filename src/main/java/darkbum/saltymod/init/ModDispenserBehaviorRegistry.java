package darkbum.saltymod.init;

import darkbum.saltymod.dispenser.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;

import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;
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

    private static final DispenserBehaviorShovel shovelBehavior = new DispenserBehaviorShovel();

    private static final DispenserBehaviorHoe hoeBehavior = new DispenserBehaviorHoe();

    private static final DispenserBehaviorBoneMeal bonemealBehavior = new DispenserBehaviorBoneMeal();

    /**
     * Initializes and registers all custom dispenser behaviors.
     */
    public static void init() {
        dispenseBehaviorRegistry.putObject(potionitem, new DispenserBehaviorPotion());
        dispenseBehaviorRegistry.putObject(glass_bottle, new DispenserBehaviorBottle());
        dispenseBehaviorRegistry.putObject(rainmaker, new DispenserBehaviorRainmaker());
        dispenseBehaviorRegistry.putObject(salt_pinch, new DispenserBehaviorSaltPinch());
        dispenseBehaviorRegistry.putObject(flint_and_steel, new DispenserBehaviorFlintAndSteel());
        dispenseBehaviorRegistry.putObject(fire_charge, new DispenserBehaviorFireCharge());
        dispenseBehaviorRegistry.putObject(water_bucket, new DispenserBehaviorWaterBucket());

        if (enableDispenserBonemealing) {
            bonemealBehavior.register();
        }
    }

    /**
     * Registers all items extending ItemSpade.
     */
    public static void registerShovels() {
        for (Object key : Item.itemRegistry.getKeys()) {
            Item item = (Item) Item.itemRegistry.getObject(key);

            if (item instanceof ItemSpade) {
                shovelBehavior.register(item);
            }
        }
    }

    /**
     * Registers all items extending ItemHoe.
     */
    public static void registerHoes() {
        if (!enableDispenserHarvesting) return;

        for (Object key : Item.itemRegistry.getKeys()) {
            Item item = (Item) Item.itemRegistry.getObject(key);

            if (item instanceof ItemHoe) {
                hoeBehavior.register(item);
            }
        }
    }
}
