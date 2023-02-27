package ru.liahim.saltmod.block;

import java.util.Random;

import ru.liahim.saltmod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlossomBurrow extends Block {

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

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltmod:BlossomLog_Top");
        this.SIDE = icon.registerIcon("saltmod:BlossomLog_Side");
        this.BURROW = icon.registerIcon("saltmod:BlossomBurrow");
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 0)
            return this.TOP;
        if (side == 1)
            return this.TOP;
        if (side == 4)
            return this.BURROW;
        else
            return this.SIDE;
    }

    public Item getItemDropped(int par1, Random random, int par2) {
        return ModItems.queenBee;
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
