package ru.liahim.saltmod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.liahim.saltmod.init.ModItems;

public class SaltTab extends CreativeTabs {
    public SaltTab(String lable) {
        super(lable);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() { return ModItems.salt; }
}
