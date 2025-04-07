package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPowderedMilk extends Item {

    private IIcon[] icon;

    public ItemPowderedMilk(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setHasSubtypes(true);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }

    // The following just exists so that I don't have to waste another item ID by registering an item just to affix a
    // texture to three distinct achievements
    // Thanks to Mojang for forcing achievements to take textures from items, instead of allowing raw texture file
    // input. Fuck you.

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.icon = new IIcon[4];
        for (int i = 0; i < this.icon.length; i++) {
            this.icon[i] = iconRegister.registerIcon("saltymod:dev/achievement_icon_" + i);
            this.icon[0] = iconRegister.registerIcon("saltymod:powdered_milk");
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }
}
