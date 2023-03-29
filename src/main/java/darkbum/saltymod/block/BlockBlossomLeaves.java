package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBlossomLeaves extends BlockLeaves {

    public static final String[] leafTypes = new String[] {"blossom"};

    public BlockBlossomLeaves(String name, CreativeTabs tab) {
        super();
        setBlockName(name);
        setCreativeTab(tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        field_150129_M[0] = new IIcon[] {reg.registerIcon("saltymod:blossom_leaves")};
        field_150129_M[1] = new IIcon[] {reg.registerIcon("saltymod:blossom_leaves_opaque")};
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if(isOpaqueCube()) {
            return field_150129_M[1][0];
        } else {
            return field_150129_M[0][0];
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBlockColor() {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderColor(int meta) {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int colorMultiplier(IBlockAccess worldIn, int x, int y, int z) {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, int x, int y, int z, int side) {
        return !worldIn.getBlock(x, y, z).isOpaqueCube();
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.blossom_sapling);
    }

    @Override
    protected void func_150124_c(World world, int x, int y, int z, int metadata, int chance)  {
        chance *= 0.8f;
        if(world.rand.nextInt(chance) == 0) {
            dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.blossom, 1, 0));
        }
    }

    @Override
    public String[] func_150125_e() {
        return leafTypes;
    }

    @Override
    protected int func_150123_b(int metadata) {
        return 40;
    }

    @Override
    public boolean isOpaqueCube() {
        return Blocks.leaves.isOpaqueCube();
    }

}
