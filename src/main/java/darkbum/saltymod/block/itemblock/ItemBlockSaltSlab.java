package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import darkbum.saltymod.init.ModBlocks;

public class ItemBlockSaltSlab extends ItemSlab {

    public ItemBlockSaltSlab(Block block) {
        super(block, ModBlocks.salt_slab, ModBlocks.double_salt_slab, false);
        setHasSubtypes(true);
    }
}
