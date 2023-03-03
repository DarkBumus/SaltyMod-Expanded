package darkbum.saltmod.items;

import java.util.List;

import darkbum.saltmod.init.ModItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MainItems extends Item {
    public MainItems(String name, CreativeTabs tab, String textureName) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setTextureName("saltmod:" + textureName);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        if (getUnlocalizedName().equals(ModItems.powderedMilk.getUnlocalizedName()))
            list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }
}
