/*package ru.liahim.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlossomDoor extends BlockDoor {

    private Item item;

    public BlossomDoor(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(3.0F);
        setResistance(3.0F);
        setBlockName("saltmod:" + name);
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return this.item;
    }

    public Item getItemDropped(int meta, Random rand, int fortune) {
        return ((meta & 0x8) != 0) ? null : this.item;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
        if (this.blockMaterial == Material.iron)
            return false;
        int i1 = func_150012_g(world, x, y, z);
        int j1 = i1 & 0x7;
        j1 ^= 0x4;
        if ((i1 & 0x8) == 0) {
            world.setBlockMetadataWithNotify(x, y, z, j1, 2);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        } else {
            world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
            world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
        }
        world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
        return true;
    }

    public Item getItem() {
        return this.item;
    }
}*/
