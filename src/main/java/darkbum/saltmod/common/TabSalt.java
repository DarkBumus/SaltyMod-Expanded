package darkbum.saltmod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabSalt extends CreativeTabs {
    public TabSalt(String label) {
        super(label);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() { return ModItems.salt; }
}
