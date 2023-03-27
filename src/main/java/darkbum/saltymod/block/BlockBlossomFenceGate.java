package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockBlossomFenceGate extends BlockFenceGate {
    public BlockBlossomFenceGate(String name, CreativeTabs tab) {
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.0F);
        setResistance(5.0F);
        setStepSound(soundTypeWood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int _meta) {
        return ModBlocks.blossom_planks.getIcon(side, 0);
    }
}
