package darkbum.saltymod.item;

import darkbum.saltymod.util.ItemSaltFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

import static darkbum.saltymod.init.ModItems.*;
import static net.minecraft.init.Items.*;

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
        addVariant(0, "egg_bowl", "egg_bowl", 0, 0.0f, false, 16, Arrays.asList(new ItemStack(bowl), new ItemStack(salt_egg, 4, 0)));
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }
}
