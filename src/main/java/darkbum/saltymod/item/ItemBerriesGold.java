package darkbum.saltymod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.util.ItemSaltFood;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import static darkbum.saltymod.util.ItemUtils.*;

/**
 * Item class for the golden berries item.
 * The golden berry is a salt food item with different variations.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemBerriesGold extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified base name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemBerriesGold(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        setHasSubtypes(true);
        setAlwaysEdible();
        variantsGoldenBerries(this);
    }

    /**
     * Determines the rarity of the item based on its metadata.
     *
     * @param stack The ItemStack instance to check.
     * @return the rarity of the item.
     */
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return stack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }

    /**
     * Checks whether the item has a visual effect (such as a glowing overlay).
     *
     * @param itemStack The ItemStack instance to check.
     * @param pass      The render pass (0 or 1). Unused in this implementation.
     * @return true, if the item has an effect, false otherwise.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int pass) {
        return itemStack.getItemDamage() > 0;
    }
}
