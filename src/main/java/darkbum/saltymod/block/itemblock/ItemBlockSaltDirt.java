package darkbum.saltymod.block.itemblock;

import darkbum.saltymod.block.BlockSaltDirt;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

/**
 * ItemBlock class for {@link BlockSaltDirt}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemBlockSaltDirt extends ItemBlockWithMetadata {

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockSaltDirt(Block block) {
        super(block, block);
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
        String nameDirt = switch (stack.getItemDamage()) {
            case 0 -> "salt_dirt";
            case 1 -> "salt_dirt_lake";
            default -> "";
        };
        return "tile." + nameDirt;
    }
}
