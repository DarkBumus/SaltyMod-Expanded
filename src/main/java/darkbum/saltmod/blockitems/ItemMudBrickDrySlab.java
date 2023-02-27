package darkbum.saltmod.blockitems;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemMudBrickDrySlab extends ItemSlab {
    public ItemMudBrickDrySlab(Block block) {
        super(block, ModBlocks.mudBrickDrySlab, ModBlocks.mudBrickDrySlabDouble, false);
        setHasSubtypes(true);
    }
}
