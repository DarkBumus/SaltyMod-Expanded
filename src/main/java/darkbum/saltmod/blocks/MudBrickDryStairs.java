package darkbum.saltmod.blocks;

import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModSounds;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class MudBrickDryStairs extends BlockStairs {
    public MudBrickDryStairs(String name, CreativeTabs tab) {
        super(ModBlocks.mudBrickDry, 5);
        setTickRandomly(false);
        setStepSound(ModSounds.soundTypeDryMudBrick);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 0);
        setBlockTextureName("saltmod:mud_bricks");
        this.useNeighborBrightness = true;
    }
}
