package darkbum.saltymod.block.itemblock;

import darkbum.saltymod.block.BlockStorageCrate;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

/**
 * ItemBlock class for {@link BlockStorageCrate}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemBlockStorageCrate extends ItemBlockWithMetadata {

    private static final String[] types = new String[] {"carrot", "potato", "poisonous_potato", "onion", "beetroot"};

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockStorageCrate(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    /**
     * Returns the unlocalized name for the item based on its metadata.
     * The unlocalized name is constructed using the base name and the variant.
     *
     * @param stack The ItemStack to get the unlocalized name for.
     * @return the unlocalized name with the appropriate variant suffix.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta < 0 || meta >= types.length) meta = 0;
        return getUnlocalizedName() + "_" + types[meta];
    }
}
