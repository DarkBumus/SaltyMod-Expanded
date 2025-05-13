package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Item class for the bee item.
 * The bee is an item with different variations.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemBee extends Item {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The unlocalized name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemBee(String name, CreativeTabs tab) {
        isDamageable();
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    /**
     * Adds subitems of this item to the provided list. The subitems are distinguished
     * by their metadata values.
     * <p>
     * This method is only called on the client side.
     *
     * @param item The item instance.
     * @param tab The creative tab in which the subitems are displayed.
     * @param list The list to which subitems are added.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 18));
    }
}
