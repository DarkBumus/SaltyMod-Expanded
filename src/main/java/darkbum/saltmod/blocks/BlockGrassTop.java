package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;

public class BlockGrassTop extends Block {
    public BlockGrassTop(String name, CreativeTabs tab) {
        super(Material.grass);
        setBlockName(name);
        setCreativeTab(tab);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (side > 1) ? BlockGrass.getIconSideOverlay() : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("minecraft:grass_top");
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess access, int x, int y, int z, int side) {
        return (side > 0 && super.shouldSideBeRendered(access, x, y, z, side));
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_) {
        return getBlockColor();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        int l = 0;
        int i = 0;
        int j = 0;
        for (int k1 = -1; k1 <= 1; k1++) {
            for (int l1 = -1; l1 <= 1; l1++) {
                int i2 = world.getBiomeGenForCoords(x + l1, z + k1).getBiomeGrassColor(x + l1, y, z + k1);
                l += (i2 & 0xFF0000) >> 16;
                i += (i2 & 0xFF00) >> 8;
                j += i2 & 0xFF;
            }
        }
        return (l / 9 & 0xFF) << 16 | (i / 9 & 0xFF) << 8 | j / 9 & 0xFF;
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return null;
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
