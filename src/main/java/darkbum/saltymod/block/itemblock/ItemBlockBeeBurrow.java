package darkbum.saltymod.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBeeBurrow extends ItemBlock {

    private static final String[] VARIANTS = new String[] { "spruce", "birch" };

    public ItemBlockBeeBurrow(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        int type = meta / 4;
        if (type < 0 || type >= VARIANTS.length) type = 0;
        return super.getUnlocalizedName() + "_" + VARIANTS[type];
    }
}
