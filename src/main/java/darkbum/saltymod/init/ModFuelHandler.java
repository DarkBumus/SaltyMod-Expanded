package darkbum.saltymod.init;

import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.IFuelHandler;
import darkbum.saltymod.common.config.ModConfigurationItems;

/**
 * Fuel Handler class for custom fuels.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModFuelHandler implements IFuelHandler {

    /**
     * Gets the burn time for a specific {@link ItemStack}.
     *
     * @param itemStack The {@link ItemStack} for which the burn time is being checked.
     * @return the burn time in ticks (or 0 if the item is not registered as fuel).
     */
    public int getBurnTime(ItemStack itemStack) {
        if (itemStack == null) return 0;

        if (ModConfigurationItems.enableHoney) {
            if (itemStack.getItem() == ModItems.waxcomb) return 400;
        }
        if (ModConfigurationWorldGeneration.enableSaltMarsh) {
            if (itemStack.getItem() == Item.getItemFromBlock(ModBlocks.marsh_reeds_b)) return 80;
            if (itemStack.getItem() == Item.getItemFromBlock(ModBlocks.reeds_block)) return 800;
        }
        return 0;
    }
}
