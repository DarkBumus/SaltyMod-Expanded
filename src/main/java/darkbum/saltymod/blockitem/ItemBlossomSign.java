package darkbum.saltymod.blockitem;

import darkbum.saltymod.block.BlockBlossomSign;
import darkbum.saltymod.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSign;

public class ItemBlossomSign extends ItemSign {

    public BlockBlossomSign wall;

    public BlockBlossomSign standing;

    public ItemBlossomSign(Block blossomSignWall, Block blossomSignStanding) {
        wall = (BlockBlossomSign)blossomSignWall;
        standing = (BlockBlossomSign)blossomSignStanding;
        setUnlocalizedName("item_blossom_sign");
        setTextureName("saltymod:blossom_sign");
        setCreativeTab(CommonProxy.tabSalt);
        setMaxStackSize(16);
    }
}
