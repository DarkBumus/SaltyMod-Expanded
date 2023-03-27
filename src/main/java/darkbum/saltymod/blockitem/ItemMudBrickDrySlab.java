package darkbum.saltymod.blockitem;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemMudBrickDrySlab extends ItemSlab {
    public ItemMudBrickDrySlab(Block block) {
        super(block, ModBlocks.dry_mud_brick_slab, ModBlocks.double_dry_mud_brick_slab, false);
        setHasSubtypes(true);
    }
}
