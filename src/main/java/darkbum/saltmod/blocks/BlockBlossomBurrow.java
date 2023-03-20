package darkbum.saltmod.blocks;

import java.util.Random;

import darkbum.saltmod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockBlossomBurrow extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BURROW;

    public BlockBlossomBurrow(String name, CreativeTabs tab) {
        super(Material.wood);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(2.0F);
        setHarvestLevel("axe", 0);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.carpenter_bee;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltmod:blossom_log_top");
        this.SIDE = icon.registerIcon("saltmod:blossom_log");
        this.BURROW = icon.registerIcon("saltmod:blossom_burrow");
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 0)
            return this.TOP;
        if (side == 1)
            return this.TOP;
        if (side == 3)
            return this.BURROW;
        return this.SIDE;
    }

    protected boolean canSilkHarvest () {
        return false;
    }
}
