package darkbum.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlossomStrippedBark extends BlockRotatedPillar {
    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    public BlossomStrippedBark(String name, CreativeTabs tab) {
        super(Material.wood);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.0F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int par1) {
        return this.SIDE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int par1) {
        return this.SIDE;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.SIDE = icon.registerIcon("saltmod:BlossomStrippedLog_Side");
    }

    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    public boolean isWood(IBlockAccess world, int x, int y, int z) {
        return true;
    }
}
