package darkbum.saltymod.block.itemblock;

import darkbum.saltymod.block.BlockBeeNest;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * ItemBlock class for {@link BlockBeeNest}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemBlockBeeNest extends ItemBlock {

    private static final String[] VARIANTS = new String[] { "temperate", "boreal" };

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockBeeNest(Block block) {
        super(block);
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
        int type = meta / 4;
        if (type < 0 || type >= VARIANTS.length) type = 0;
        return super.getUnlocalizedName() + "_" + VARIANTS[type];
    }

    /**
     * Returns the metadata value for the item stack.
     * This method ensures that the metadata is preserved when placing the block.
     *
     * @param meta The original metadata value.
     * @return the metadata value to be used.
     */
    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
