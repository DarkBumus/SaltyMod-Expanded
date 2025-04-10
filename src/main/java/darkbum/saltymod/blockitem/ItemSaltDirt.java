package darkbum.saltymod.blockitem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaltDirt extends ItemBlockWithMetadata {

    public ItemSaltDirt(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack stack) {
        String nameDirt = "";
        switch (stack.getItemDamage()) {
            case 0:
                nameDirt = "salt_dirt";
                break;
            case 1:
                nameDirt = "salt_dirt_lake";
                break;
        }
        return "tile." + nameDirt;
    }
}
