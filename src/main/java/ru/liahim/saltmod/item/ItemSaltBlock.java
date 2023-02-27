package ru.liahim.saltmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaltBlock extends ItemBlockWithMetadata {
    public ItemSaltBlock(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack stack) {
        String nameBlock = "";
        switch (stack.getItemDamage()) {
            case 0:
                nameBlock = "saltBlock";
                break;
            case 1:
                nameBlock = "saltBlockChiseled";
                break;
            case 2:
                nameBlock = "saltBlockPillar";
                break;
            case 5:
                nameBlock = "saltBrick";
                break;
            case 6:
                nameBlock = "saltBlockCracked";
                break;
            case 7:
                nameBlock = "saltBrickCracked";
                break;
            case 8:
                nameBlock = "saltBrickChiseled";
                break;
            case 9:
                nameBlock = "saltChapiter";
                break;
        }
        return "tile." + nameBlock;
    }
}
