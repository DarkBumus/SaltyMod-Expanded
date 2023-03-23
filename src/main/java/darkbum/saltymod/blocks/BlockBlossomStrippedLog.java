package darkbum.saltymod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockBlossomStrippedLog extends BlockRotatedPillar {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    public BlockBlossomStrippedLog(String name, CreativeTabs tab) {
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
        return this.TOP;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int par1) {
        return this.SIDE;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltymod:blossom_log_stripped_top");
        this.SIDE = icon.registerIcon("saltymod:blossom_log_stripped");
    }

    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return false;
    }

    public boolean isWood(IBlockAccess world, int x, int y, int z) {
        return true;
    }
}
