package darkbum.saltymod.init;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.IFuelHandler;
import darkbum.saltymod.configuration.configs.ModConfigurationItems;

public class ModFuelHandler implements IFuelHandler {

    public int getBurnTime(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        if (ModConfigurationItems.enableHoney) {
            if (ModItems.waxcomb != null) {
                if (itemStack.getItem() == ModItems.waxcomb) {
                    return 400;
                }
            }
        }
        return 0;
    }
}
