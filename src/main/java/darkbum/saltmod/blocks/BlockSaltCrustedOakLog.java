package darkbum.saltmod.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	    this.BOTTOM = icon.registerIcon("saltmod:oak_log_crusted_bottom");
	    this.SIDE = icon.registerIcon("saltmod:oak_log_crusted");
        this.LTOP = icon.registerIcon("log_oak");
        this.LBOTTOM = icon.registerIcon("saltmod:oak_log_crusted_lying_bottom");
        this.LSIDE = icon.registerIcon("saltmod:oak_log_crusted_lying");
        this.LEND = icon.registerIcon("saltmod:oak_log_crusted_lying_end");
    }

	public IIcon getIcon(int side, int meta) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.TOP;
            else
                return this.SIDE;
        }

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(Blocks.log);
	}

	protected boolean canSilkHarvest() {
		return false;
	}
}
