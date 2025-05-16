package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.util.ItemUtils.addItemTooltip;

/**
 * Item class for the powdered milk item.
 * The powdered milk is an item with a special tooltip.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemPowderedMilk extends Item {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemPowderedMilk(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    /**
     * Adds additional information to the item tooltip when hovering over the item in the inventory.
     *
     * @param stack     The ItemStack for which the information is being added.
     * @param player    The player viewing the tooltip.
     * @param list      The list to which the tooltip lines are added.
     * @param advanced  Whether advanced tooltips are enabled.
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
        addItemTooltip(stack, list);
    }
}
