package ru.liahim.saltmod.item;

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
                nameDirt = "saltDirt";
                break;
            case 1:
                nameDirt = "saltDirtLake";
                break;
        }
        return "tile." + nameDirt;
    }
}
