package darkbum.saltmod.blocks;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlossomStairs extends BlockStairs {
    public BlockBlossomStairs(String name, CreativeTabs tab) {
        super(ModBlocks.blossom_planks, 5);
        setTickRandomly(false);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.0F);
        setResistance(3.0F);
        setHarvestLevel("axe", 0);
        setBlockTextureName("saltmod:blossom_planks");
        this.useNeighborBrightness = true;
    }
}
