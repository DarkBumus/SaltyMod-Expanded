package darkbum.saltmod.blockitems;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlossomSlab extends ItemSlab {
    public ItemBlossomSlab(Block block) {
        super(block, ModBlocks.blossomSlab, ModBlocks.blossomSlabDouble, false);
        setHasSubtypes(true);
    }
}
