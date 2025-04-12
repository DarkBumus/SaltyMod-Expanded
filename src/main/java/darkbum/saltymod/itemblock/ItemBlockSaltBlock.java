package darkbum.saltymod.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockSaltBlock extends ItemBlockWithMetadata {

    public ItemBlockSaltBlock(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack stack) {
        String nameBlock = "";
        switch (stack.getItemDamage()) {
            case 0:
                nameBlock = "salt_block";
                break;
            case 1:
                nameBlock = "salt_chiseled_block";
                break;
            case 2:
                nameBlock = "salt_pillar";
                break;
            case 5:
                nameBlock = "salt_brick";
                break;
            case 6:
                nameBlock = "salt_cracked_block";
                break;
            case 7:
                nameBlock = "salt_cracked_brick";
                break;
            case 8:
                nameBlock = "salt_chiseled_brick";
                break;
            case 9:
                nameBlock = "salt_chapiter";
                break;
        }
        return "tile." + nameBlock;
    }
}
