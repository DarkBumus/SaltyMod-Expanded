package darkbum.saltymod.blockitem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaltFlower extends ItemBlockWithMetadata {

    public static final String[] types = new String[] {"daucus", "wild_carrot", "solanum", "wild_potato", "wild_onion", "maritima", "wild_beet"};

    public ItemSaltFlower(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    public int getMetadata(int meta) {
        return meta;
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= types.length)
            meta = 0;
        return getUnlocalizedName() + "_" + types[meta];
    }
}
