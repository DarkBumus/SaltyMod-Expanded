package darkbum.saltymod.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModSounds;

public class BlockDryMudBrickStairs extends BlockStairs {

    public BlockDryMudBrickStairs(String name, CreativeTabs tab) {
        super(ModBlocks.dry_mud_brick, 5);
        setTickRandomly(false);
        setStepSound(ModSounds.soundTypeDryMudBrick);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 0);
        setBlockTextureName("saltymod:mud_bricks");
        this.useNeighborBrightness = true;
    }
}
