package ru.liahim.saltmod.block;

import java.util.Random;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import ru.liahim.saltmod.init.ModBlocks;

public class MudBrickDrySlab extends BlockSlab {

    public MudBrickDrySlab(boolean isDouble, String name, CreativeTabs tab) {
        super(isDouble, Material.rock);
        setTickRandomly(false);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(3.0F);
        setHarvestLevel("pickaxe", 0);
        this.useNeighborBrightness = true;
        setBlockTextureName("saltmod:MudBrickDry");
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.mudBrickDrySlab);
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    public String func_150002_b(int par1) {
        return getUnlocalizedName();
    }

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return getPickBlock(target, world, x, y, z);
    }
}
