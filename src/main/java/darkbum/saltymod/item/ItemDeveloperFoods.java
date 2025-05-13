package darkbum.saltymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

import static darkbum.saltymod.util.ItemUtil.*;

/**
 * Item class for the developer foods item.
 * The developer foods is a salt food item for testing purposes.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemDeveloperFoods extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified base name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemDeveloperFoods(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setAlwaysEdible();
        variantsDeveloperFoods(this);
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

    /**
     * Called when the player consumes this item.
     *
     * @param stack  The ItemStack that was consumed.
     * @param world  The world in which the item was consumed.
     * @param player The player consuming the item.
     * @return the resulting ItemStack after the item is consumed.
     */
    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            int meta = stack.getItemDamage();
            if (meta == 0 || meta == 1) {
                player.clearActivePotions();
            }
            super.onEaten(stack, world, player);
        }
        return stack;
    }
}
