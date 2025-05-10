package darkbum.saltymod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;

/**
 * Custom Creative Tab for SaltyMod Expanded Items.
 * This tab will display items in the creative inventory.
 * The icon of this tab is the Salt Item.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class TabSaltItems extends CreativeTabs {

    /**
     * Constructs the custom Creative Tab.
     *
     * @param label The label for the creative tab.
     */
    public TabSaltItems(String label) {
        super(label);
    }

    /**
     * Returns the item icon that will be displayed for this tab in the creative inventory.
     *
     * @return The item to be displayed as the tab's icon.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.salt;
    }
}
