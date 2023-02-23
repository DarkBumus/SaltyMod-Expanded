package ru.liahim.saltmod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.ModItems;
import ru.liahim.saltmod.init.ModSounds;
import ru.liahim.saltmod.init.SaltConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MudBrickWet extends Block implements IDegradable {

	@SideOnly(Side.CLIENT)
		private IIcon SIDE_1;
	  
	@SideOnly(Side.CLIENT)
		private IIcon SIDE_2;

	public MudBrickWet(String name, CreativeTabs tab) {
		super (Material.clay);
		setStepSound(ModSounds.soundTypeWetMudBrick);
		setBlockName(name);
		setCreativeTab(tab);
		setHardness(1.0F);
		setResistance(0.5F);
		setHarvestLevel("shovel", 0);
		if(SaltConfig.mudBrickComplex) {
		setTickRandomly(true);	
		} else {
		setTickRandomly(false);
		}
	}

	@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta == 1) ? this.SIDE_1 : ((meta == 2) ? this.SIDE_2 : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister par1) {
			this.blockIcon = par1.registerIcon("saltMod:MudBrickWet_0");
			this.SIDE_1 = par1.registerIcon("saltMod:MudBrickWet_1");
			this.SIDE_2 = par1.registerIcon("saltMod:MudBrickWet_2");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side) {
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.stick) {
			ItemStack current = player.getCurrentEquippedItem();
			int meta = world.getBlockMetadata(x, y, z);
				if (meta == 0) {
					world.setBlock(x, y, z, this, (meta + 1), 3);
					if (!player.capabilities.isCreativeMode)
						current.stackSize--;
				} else if (meta == 1) {
					world.setBlock(x, y, z, this, (meta + 1), 3);
					if (!player.capabilities.isCreativeMode)
						current.stackSize--; 
				} else if (meta == 2) {
					world.setBlock(x, y, z, ModBlocks.mudBrickDry);
					if (!player.capabilities.isCreativeMode)
						current.stackSize--;
				} 
				return true;
		}
		return false;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		tickDegradation(world, x, y, z, rand);
	}

	@Override
	public int getMudBrickWetMeta(int paramInt) {
		return paramInt;
	}

	@Override
	public Block getMudBrickWetFromMeta(int paramInt) {
		return this;
	}
}