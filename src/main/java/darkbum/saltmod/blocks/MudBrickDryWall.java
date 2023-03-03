package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class MudBrickDryWall extends BlockWall {

	public MudBrickDryWall(Block block, CreativeTabs tab) {
		super(block);
		setTickRandomly(false);
		setStepSound(soundTypeStone);
		setBlockName("mudBrickDryWall");
		setCreativeTab(tab);
		setHardness(1.5F);
		setResistance(3.0F);
        setStepSound(ModSounds.soundTypeDryMudBrick);
        setHarvestLevel("pickaxe", 0);
        this.useNeighborBrightness = true;
		setBlockTextureName("saltmod:mud_bricks");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ModBlocks.mudBrickDry.getIcon(side, meta);
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.mudBrickDryWall);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
    }

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        ItemStack stack = new ItemStack(this, 1, world.getBlockMetadata(x,y,z));
        return stack;
    }
}
