package darkbum.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;

public class BlossomLeaves extends BlockLeavesBase implements IShearable {
    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public ArrayList onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        return null;
    }

    public enum LeafCategory {
        CAT1;
    }

    @SideOnly(Side.CLIENT)
    private IIcon FANCY;

    @SideOnly(Side.CLIENT)
    private IIcon FAST;

    private static final float[] fallingLeavesChance = new float[] {
        0.1F, 0.008F, 0.016F, 0.008F, 0.0F, 0.008F, 0.016F, 0.1F, 0.008F, 0.1F,
        0.008F, 0.1F, 0.008F, 0.008F };

    private final LeafCategory category;

    int[] adjacentTreeBlocks;

    public BlossomLeaves(String name, CreativeTabs tab, LeafCategory cat) {
        super(Material.leaves, false);
        this.category = cat;
        setTickRandomly(true);
        setHardness(0.2F);
        setResistance(0.2F);
        setStepSound(soundTypeGrass);
        setLightOpacity(1);
        setBlockName(name);
    }

    public void registerBlockIcons(IIconRegister icon) {
        this.FANCY = icon.registerIcon("saltmod:BlossomLeaves");
        this.FAST = icon.registerIcon("saltmod:BlossomLeaves_Opaque");
    }

    public IIcon getIcon(int side, int meta) {
        if (isOpaqueCube()) {
            return this.FAST;
        } else {
            return this.FANCY;
        }
    }

    public boolean isOpaqueCube() {
        return Blocks.leaves.isOpaqueCube();
    }

    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }

    public void beginLeavesDecay(World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 0x8, 4);
    }

    public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

}
