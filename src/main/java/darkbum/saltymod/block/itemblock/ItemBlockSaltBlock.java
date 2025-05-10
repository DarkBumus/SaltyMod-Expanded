package darkbum.saltymod.block.itemblock;

import darkbum.saltymod.block.BlockSaltBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

/**
 * ItemBlock class for {@link BlockSaltBlock}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemBlockSaltBlock extends ItemBlockWithMetadata {

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockSaltBlock(Block block) {
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
        String nameBlock = switch (stack.getItemDamage()) {
            case 0 -> "salt_block";
            case 1 -> "salt_chiseled_block";
            case 2, 3, 4 -> "salt_pillar";
            case 5 -> "salt_brick";
            case 6 -> "salt_cracked_block";
            case 7 -> "salt_cracked_brick";
            case 8 -> "salt_chiseled_brick";
            case 9, 10 -> "salt_chapiter";
            default -> "";
        };
        return "tile." + nameBlock;
    }
}
