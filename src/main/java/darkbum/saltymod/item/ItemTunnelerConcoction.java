package darkbum.saltymod.item;

import darkbum.saltymod.util.ItemSaltFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

import static darkbum.saltymod.util.ItemUtils.*;
/**
 * Item class for the tunneler's concoction item.
 * The tunneler's concoction is a salt food item with a special tooltip and message.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemTunnelerConcoction extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified base name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemTunnelerConcoction(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setAlwaysEdible();
        variantsTunnelerConcoction(this);
    }

    /**
     * Adds additional information to the item tooltip when hovering over the item in the inventory.
     * <p>
     * The tooltip text is retrieved from a localized key.
     * If no translation is found, the tooltip is not displayed.
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
