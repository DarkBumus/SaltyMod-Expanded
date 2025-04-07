package darkbum.saltymod.blockitem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import darkbum.saltymod.init.ModBlocks;

public class ItemSaltSlab extends ItemSlab {

    public ItemSaltSlab(Block block) {
        super(block, ModBlocks.salt_slab, ModBlocks.double_salt_slab, false);
        setHasSubtypes(true);
    }
}
