package darkbum.saltymod.common;

import cpw.mods.fml.common.IFuelHandler;
import darkbum.saltymod.init.ModItems;
import net.minecraft.item.ItemStack;

public class ModFuelHandler implements IFuelHandler {

    public int getBurnTime(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        if (itemStack.getItem() == ModItems.waxcomb) {
            return 400;
        }
        return 0;
    }
}
