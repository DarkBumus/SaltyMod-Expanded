package ru.liahim.saltmod.block;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class Apiary extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT0;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT1;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT2;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT3;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT4;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT5;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT6;


    public Apiary(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.6F);
        setResistance(0.6F);
        setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltmod:Apiary_Top");
        this.SIDE = icon.registerIcon("saltmod:Apiary_Side");
        this.FRONT0 = icon.registerIcon("saltmod:Apiary_Front_0");
        this.FRONT1 = icon.registerIcon("saltmod:Apiary_Front_1");
        this.FRONT2 = icon.registerIcon("saltmod:Apiary_Front_2");
        this.FRONT3 = icon.registerIcon("saltmod:Apiary_Front_3");
        this.FRONT4 = icon.registerIcon("saltmod:Apiary_Front_4");
        this.FRONT5 = icon.registerIcon("saltmod:Apiary_Front_5");
        this.FRONT6 = icon.registerIcon("saltmod:Apiary_Front_6");
    }

    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 7)
            meta = 0;

        if (meta == 0) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT0;
            return this.SIDE;
        }
        if (meta == 1) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT1;
            return this.SIDE;
        }
        if (meta == 2) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT2;
            return this.SIDE;
        }
        if (meta == 3) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT3;
            return this.SIDE;
        }
        if (meta == 4) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT4;
            return this.SIDE;
        }
        if (meta == 5) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT5;
            return this.SIDE;
        }
        if (meta == 6) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            if (side == 4)
                return this.FRONT6;
            return this.SIDE;
        }
        return null; // ???
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
