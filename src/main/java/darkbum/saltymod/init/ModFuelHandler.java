package darkbum.saltymod.init;

import darkbum.saltymod.configuration.configs.ModConfigurationBlocks;
import darkbum.saltymod.configuration.configs.ModConfigurationWorldGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
        if (ModConfigurationWorldGeneration.enableSaltMarsh) {
            if (ModBlocks.reeds_block != null) {
                if (itemStack.getItem() == Item.getItemFromBlock(ModBlocks.reeds_block)) {
                    return 800;
                }
            }
        }
        return 0;
    }
}
