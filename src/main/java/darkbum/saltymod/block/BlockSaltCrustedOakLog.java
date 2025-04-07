package darkbum.saltymod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSaltCrustedOakLog extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon LTOP0;

    @SideOnly(Side.CLIENT)
    private IIcon LTOP1;

    @SideOnly(Side.CLIENT)
    private IIcon LBOTTOM0;

    @SideOnly(Side.CLIENT)
    private IIcon LBOTTOM1;

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
        this.LTOP0 = icon.registerIcon("log_oak");
        this.LTOP1 = icon.registerIcon("saltymod:log_oak_1");
        this.LBOTTOM0 = icon.registerIcon("saltymod:oak_log_crusted_lying_bottom_0");
        this.LBOTTOM1 = icon.registerIcon("saltymod:oak_log_crusted_lying_bottom_1");
        this.LSIDE = icon.registerIcon("saltymod:oak_log_crusted_lying");
        this.LEND = icon.registerIcon("saltymod:oak_log_crusted_lying_end");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return SIDE;
                }
            case 4:
                switch (side) {
                    case 0:
                        return LBOTTOM1;
                    case 1:
                        return LTOP1;
                    case 2:
                    case 3:
                        return LSIDE;
                    case 4:
                    case 5:
                        return LEND;
                }
            case 8:
                switch (side) {
                    case 0:
                        return LBOTTOM0;
                    case 1:
                        return LTOP0;
                    case 2:
                    case 3:
                        return LEND;
                    case 4:
                    case 5:
                        return LSIDE;
                }
        }
        return null;
    }

    /*
     * public IIcon getIcon(int side, int meta) {
     * switch (side) {
     * case 0:
     * return BOTTOM;
     * case 1:
     * return TOP;
     * }
     * return SIDE;
     * }
     */

    public int onBlockPlaced(World worldIn, int x, int y, int z, int side, float subX, float subY, float subZ,
        int meta) {
        int j1 = meta & 3;
        byte b0 = 0;

        switch (side) {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 8;
                break;
            case 4:
            case 5:
                b0 = 4;
        }
        return j1 | b0;
    }

    public Item getItemDropped(int par1, Random random, int par2) {
        return Item.getItemFromBlock(Blocks.log);
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
