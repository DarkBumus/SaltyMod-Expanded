package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import darkbum.saltymod.common.config.ModConfigurationItems;
import darkbum.saltymod.init.ModAchievementList;

import static darkbum.saltymod.util.ItemUtils.addItemTooltip;
import static darkbum.saltymod.util.ItemUtils.variantsFizzyDrink;

/**
 * Item class for the fizzy drink item.
 * The fizzy drink is an item with potion curing functionality.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemFizzyDrink extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemFizzyDrink(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setAlwaysEdible();
        variantsFizzyDrink(this);
    }

    /**
     * Adds additional information to the item tooltip when hovering over the item in the inventory.
     * <p>
     * The tooltip text is retrieved from the localized key: {@code <item name>.tooltip}.
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
     * Called when the player right-clicks with this item.
     *
     * @param stack  The ItemStack being right-clicked.
     * @param world  The world in which the action occurs.
     * @param player The player using the item.
     * @return the modified ItemStack after the action.
     */
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.setItemInUse(stack, getMaxItemUseDuration(stack));
        return stack;
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
        if (!player.capabilities.isCreativeMode) stack.stackSize--;
        if (!world.isRemote) {
            if (ModConfigurationItems.fizzyDrinkEffect) {
                player.clearActivePotions();
            } else {
                player.curePotionEffects(new ItemStack(Items.milk_bucket));
            }
            if (player.isBurning()) {
                player.addStat(ModAchievementList.consume_fizzy_drink, 1);
                player.extinguish();
            }
        }
        return (stack.stackSize <= 0) ? new ItemStack(Items.glass_bottle) : stack;
    }
}
