package darkbum.saltmod.item;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemSaltSlab extends ItemSlab {
    public ItemSaltSlab(Block block) {
        super(block, ModBlocks.saltSlab, ModBlocks.saltSlabDouble, false);
        setHasSubtypes(true);
    }
}
