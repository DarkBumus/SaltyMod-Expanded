package darkbum.saltymod.creativetab;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSaltBlocks extends CreativeTabs {

    public TabSaltBlocks(String label) {
        super(label);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ModBlocks.salt_block);
    }
}
