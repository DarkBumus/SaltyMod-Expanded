package darkbum.saltymod.block.itemblock;

import darkbum.saltymod.block.BlockDryMudBrickSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import darkbum.saltymod.init.ModBlocks;

/**
 * ItemBlock class for {@link BlockDryMudBrickSlab}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemBlockMudBrickDrySlab extends ItemSlab {

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockMudBrickDrySlab(Block block) {
        super(block, ModBlocks.dry_mud_brick_slab, ModBlocks.double_dry_mud_brick_slab, false);
        setHasSubtypes(true);
    }
}
