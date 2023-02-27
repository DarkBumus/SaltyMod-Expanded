package darkbum.saltmod.block;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class BlossomStairs extends BlockStairs {
    public BlossomStairs(String name, CreativeTabs tab) {
        super(ModBlocks.blossomPlanks, 5);
        setTickRandomly(false);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.0F);
        setResistance(3.0F);
        setHarvestLevel("axe", 0);
        setBlockTextureName("saltmod:Blossom");
        this.useNeighborBrightness = true;
    }
}
