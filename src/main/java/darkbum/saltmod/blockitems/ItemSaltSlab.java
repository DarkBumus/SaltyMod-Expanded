package darkbum.saltmod.blockitems;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemSaltSlab extends ItemSlab {
    public ItemSaltSlab(Block block) {
        super(block, ModBlocks.salt_slab, ModBlocks.double_salt_slab, false);
        setHasSubtypes(true);
    }
}
