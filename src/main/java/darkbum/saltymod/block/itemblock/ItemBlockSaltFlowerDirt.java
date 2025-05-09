package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockSaltFlowerDirt extends ItemBlockWithMetadata {

    public static final String[] types = new String[] {"daucus", "wild_carrot", "solanum", "wild_potato", "wild_onion"};

    public ItemBlockSaltFlowerDirt(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= types.length) meta = 0;
        return getUnlocalizedName() + "_" + types[meta];
    }
}
