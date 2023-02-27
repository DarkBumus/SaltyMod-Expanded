package darkbum.saltmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemStorageCrate extends ItemBlockWithMetadata {
    private static final String[] types = new String[] {"Carrot", "Potato", "PoiPotato", "Onion", "Beetroot"};

    public ItemStorageCrate(Block block) {
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
