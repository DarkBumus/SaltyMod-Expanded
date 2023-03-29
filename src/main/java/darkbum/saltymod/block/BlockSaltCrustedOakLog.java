package darkbum.saltymod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockSaltCrustedOakLog extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon LTOP;

    @SideOnly(Side.CLIENT)
    private IIcon LBOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon LSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon LEND;

    public BlockSaltCrustedOakLog(String name, CreativeTabs tab) {
        super(Material.wood);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.5F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("log_oak_top");
        this.BOTTOM = icon.registerIcon("saltymod:oak_log_crusted_bottom");
        this.SIDE = icon.registerIcon("saltymod:oak_log_crusted");
        this.LTOP = icon.registerIcon("log_oak");
        this.LBOTTOM = icon.registerIcon("saltymod:oak_log_crusted_lying_bottom");
        this.LSIDE = icon.registerIcon("saltymod:oak_log_crusted_lying");
        this.LEND = icon.registerIcon("saltymod:oak_log_crusted_lying_end");
    }

    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0:
                return BOTTOM;
            case 1:
                return TOP;
        }
        return SIDE;
    }

    public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(Blocks.log);
	}

	protected boolean canSilkHarvest() {
		return false;
	}
}
