package darkbum.saltmod.block;

import java.util.Random;

import darkbum.saltmod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlossomBurrow extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlossomBurrow(String name, CreativeTabs tab) {
        super(Material.wood);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.queenBee;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.TOP : (side == 0 ? this.TOP : (side != meta ? this.SIDE : this.BURROW));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltmod:BlossomLog_Top");
        this.SIDE = icon.registerIcon("saltmod:BlossomLog_Side");
        this.BURROW = icon.registerIcon("saltmod:BlossomBurrow");
    }

    public void onBlockAdded(World worldIn, int x, int y, int z) {
        super.onBlockAdded(worldIn, x, y, z);
        this.func_149930_e(worldIn, x, y, z);
    }

    private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_) {
        if (!p_149930_1_.isRemote) {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;
            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }
            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }
            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }
            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }
            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
