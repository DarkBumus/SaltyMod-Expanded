package darkbum.saltymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.util.ItemUtils.*;

/**
 * Item class for the egg bowl item.
 * The egg bowl is an item with a right-click function.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemEggBowl extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab      The creative tab to display this item in.
     */
    public ItemEggBowl(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setAlwaysEdible();
        variantsEggBowl(this);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }
}
