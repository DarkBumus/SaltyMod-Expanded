package darkbum.saltmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemAchievementItem extends Item {
    private IIcon[] icon;

    public ItemAchievementItem(String name, CreativeTabs tab) {
        setCreativeTab(tab);
        setMaxStackSize(1);
        setMaxDamage(0);
        setHasSubtypes(true);
        setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        this.icon = new IIcon[3];
        for (int i = 0; i < this.icon.length; i++)
            this.icon[i] = reg.registerIcon("saltmod:" + "dev/" + "achievement_icon_" + i);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }
}
