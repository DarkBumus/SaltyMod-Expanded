package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import darkbum.saltymod.init.ModBlocks;

public class ItemBlockMudBrickDrySlab extends ItemSlab {

    public ItemBlockMudBrickDrySlab(Block block) {
        super(block, ModBlocks.dry_mud_brick_slab, ModBlocks.double_dry_mud_brick_slab, false);
        setHasSubtypes(true);
    }
}
