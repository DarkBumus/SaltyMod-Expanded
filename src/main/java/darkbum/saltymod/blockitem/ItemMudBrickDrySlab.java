package darkbum.saltymod.blockitem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import darkbum.saltymod.init.ModBlocks;

public class ItemMudBrickDrySlab extends ItemSlab {

    public ItemMudBrickDrySlab(Block block) {
        super(block, ModBlocks.dry_mud_brick_slab, ModBlocks.double_dry_mud_brick_slab, false);
        setHasSubtypes(true);
    }
}
