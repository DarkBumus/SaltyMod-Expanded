package darkbum.saltymod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

/**
 * Item class for the dev item.
 * The dev item is a placeholder item.
 * DO NOT EXTEND THIS!
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemDevItem extends Item {

    private IIcon[] icon;

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemDevItem(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setHasSubtypes(true);
    }

    /**
     * Registers item icons for each variant.
     *
     * @param iconRegister The icon register.
     */
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.icon = new IIcon[3];
        for (int i = 0; i < this.icon.length; i++) {
            this.icon[i] = iconRegister.registerIcon("saltymod:dev/achievement_icon_" + i);}
    }

    /**
     * Retrieves the icon for the specified metadata.
     *
     * @param meta The metadata value.
     * @return the icon for the variant.
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }
}
