package darkbum.saltymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import darkbum.saltymod.init.ModSounds;

public class BlockDryMudBrick extends Block {

    public BlockDryMudBrick(String name, CreativeTabs tab) {
        super(Material.rock);
        setStepSound(ModSounds.soundTypeDryMudBrick);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 0);
        setBlockTextureName("saltymod:mud_bricks");
        setTickRandomly(false);
    }
}
