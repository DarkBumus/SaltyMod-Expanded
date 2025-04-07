package darkbum.saltymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDevBlock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon SIDE0BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE1TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE2NORTH;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE3SOUTH;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE4WEST;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE5EAST;

    public BlockDevBlock(String name, CreativeTabs tab) {
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.0F);
        setResistance(1.0F);
        setHarvestLevel("pickaxe", 0);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0) return SIDE0BOTTOM;
        if (side == 1) return SIDE1TOP;
        if (side == 2) return SIDE2NORTH;
        if (side == 3) return SIDE3SOUTH;
        if (side == 4) return SIDE4WEST;
        if (side == 5) return SIDE5EAST;
        return null;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        SIDE0BOTTOM = iconRegister.registerIcon("saltymod:dev/dev_side0bottom");
        SIDE1TOP = iconRegister.registerIcon("saltymod:dev/dev_side1top");
        SIDE2NORTH = iconRegister.registerIcon("saltymod:dev/dev_side2north");
        SIDE3SOUTH = iconRegister.registerIcon("saltymod:dev/dev_side3south");
        SIDE4WEST = iconRegister.registerIcon("saltymod:dev/dev_side4west");
        SIDE5EAST = iconRegister.registerIcon("saltymod:dev/dev_side5east");
    }
}
