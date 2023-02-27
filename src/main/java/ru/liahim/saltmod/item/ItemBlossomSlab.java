package ru.liahim.saltmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import ru.liahim.saltmod.init.ModBlocks;

public class ItemBlossomSlab extends ItemSlab {
    public ItemBlossomSlab(Block block) {
        super(block, ModBlocks.blossomSlab, ModBlocks.blossomSlabDouble, false);
        setHasSubtypes(true);
    }
}
