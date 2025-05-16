package darkbum.saltymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

import static darkbum.saltymod.util.ItemUtils.*;

/**
 * Item class for the chocolate bar item.
 * The chocolate bar is a salt food item with a special tooltip and message.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemChocolateBar extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified base name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemChocolateBar(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        variantsChocolateBar(this);
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
     * Called when the player consumes the food item.
     *
     * @param stack  The consumed ItemStack.
     * @param world  The world in which the food was eaten.
     * @param player The player who ate the food.
     */
    @Override
    protected void onFoodEaten(ItemStack stack, net.minecraft.world.World world, EntityPlayer player) {
        sendRandomFullChatMessage(world, player, getUnlocalizedName(), 4);
    }
}
