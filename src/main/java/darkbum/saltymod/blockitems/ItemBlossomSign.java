package darkbum.saltymod.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;

public class ItemBlossomSign extends ItemBlockWithMetadata {

    public ItemBlossomSign(Block block) {
        super(block, block);
        setUnlocalizedName("blossom_sign");
    }
}
