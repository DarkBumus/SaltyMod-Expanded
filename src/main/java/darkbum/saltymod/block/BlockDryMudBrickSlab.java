package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModSounds;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockDryMudBrickSlab extends BlockSlab {

    public BlockDryMudBrickSlab(boolean isDouble, String name, CreativeTabs tab) {
        super(isDouble, Material.rock);
        setTickRandomly(false);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.5F);
        setResistance(3.0F);
        setStepSound(ModSounds.soundTypeDryMudBrick);
        setHarvestLevel("pickaxe", 0);
        this.useNeighborBrightness = true;
        setBlockTextureName("saltymod:mud_bricks");
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.dry_mud_brick_slab);
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    public String func_150002_b(int par1) {
        return getUnlocalizedName();
    }

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        ItemStack stack = new ItemStack(this, 1, world.getBlockMetadata(x,y,z));
        return stack;
    }
}
