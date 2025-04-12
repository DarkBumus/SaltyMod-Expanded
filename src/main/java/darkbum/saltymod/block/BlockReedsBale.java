package darkbum.saltymod.block;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import ganymedes01.etfuturum.api.HoeRegistry;

public class BlockReedsBale extends BlockRotatedPillar {

    public BlockReedsBale(String name, CreativeTabs tab) {
        super(Material.grass);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(0.5F);
        setStepSound(soundTypeGrass);
        if(Loader.isModLoaded("etfuturum")) {
            HoeRegistry.addToHoeArray(this);
        }
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_) {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        this.field_150164_N = reg.registerIcon("saltymod:reeds_block_top");
        this.blockIcon = reg.registerIcon("saltymod:reeds_block_side");
    }

    @Override
    public String getHarvestTool(int meta) {
        return "hoe";
    }
}
