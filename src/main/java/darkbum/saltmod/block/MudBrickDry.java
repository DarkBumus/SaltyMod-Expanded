package darkbum.saltmod.block;

import darkbum.saltmod.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MudBrickDry extends Block {
    public MudBrickDry(String name, CreativeTabs tab) {
        super(Material.rock);
        setStepSound(ModSounds.soundTypeDryMudBrick);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 0);
        setBlockTextureName("saltmod:MudBrickDry");
        setTickRandomly(false);
    }
}
