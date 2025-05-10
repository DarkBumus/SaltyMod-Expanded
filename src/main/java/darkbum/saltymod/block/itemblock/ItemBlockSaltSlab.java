package darkbum.saltymod.block.itemblock;

import darkbum.saltymod.block.BlockSaltSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import darkbum.saltymod.init.ModBlocks;

/**
 * ItemBlock class for {@link BlockSaltSlab}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemBlockSaltSlab extends ItemSlab {

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockSaltSlab(Block block) {
        super(block, ModBlocks.salt_slab, ModBlocks.double_salt_slab, false);
        setHasSubtypes(true);
    }
}
