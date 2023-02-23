package ru.liahim.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import ru.liahim.saltmod.common.ClientProxy;
import ru.liahim.saltmod.init.ModBlocks;
import ru.liahim.saltmod.init.ModItems;

public class SaltGrass extends Block implements IGrowable {
  @SideOnly(Side.CLIENT)
  private IIcon TOP;
  
  @SideOnly(Side.CLIENT)
  private IIcon SIDE;
  
  @SideOnly(Side.CLIENT)
  private IIcon SIDE_L;
  
  @SideOnly(Side.CLIENT)
  private IIcon SIDE_R;
  
  @SideOnly(Side.CLIENT)
  private IIcon BOTTOM0;
  
  @SideOnly(Side.CLIENT)
  private IIcon BOTTOM1;
  
  public SaltGrass(String name, CreativeTabs tab) {
    super(Material.grass);
    setTickRandomly(true);
    setCreativeTab(tab);
    setStepSound(soundTypeGrass);
    setBlockName(name);
    setHardness(0.5F);
    setResistance(1.0F);
    setHarvestLevel("shovel", 0);
  }
  
  public int getRenderType() {
    return ClientProxy.saltGrassRenderType;
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(int side, int meta) {
    return (side == 1) ? this.TOP : ((side == 0 && meta > 0) ? this.BOTTOM1 : ((side == 0 && meta == 0) ? this.BOTTOM0 : (((side == 2 && (meta == 7 || meta == 11 || meta == 14 || meta == 15)) || (side == 5 && (meta == 8 || meta == 11 || meta == 12 || meta == 15)) || (side == 3 && (meta == 9 || meta == 12 || meta == 13 || meta == 15)) || (side == 4 && (meta == 10 || meta == 13 || meta == 14 || meta == 15))) ? this.SIDE : (((side == 2 && (meta == 3 || meta == 8 || meta == 12)) || (side == 5 && (meta == 4 || meta == 9 || meta == 13)) || (side == 3 && (meta == 5 || meta == 10 || meta == 14)) || (side == 4 && (meta == 6 || meta == 7 || meta == 11))) ? this.SIDE_L : (((side == 2 && (meta == 6 || meta == 10 || meta == 13)) || (side == 5 && (meta == 3 || meta == 7 || meta == 14)) || (side == 3 && (meta == 4 || meta == 8 || meta == 11)) || (side == 4 && (meta == 5 || meta == 9 || meta == 12))) ? this.SIDE_R : this.blockIcon)))));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister par1) {
    this.blockIcon = par1.registerIcon("saltmod:SaltGrass");
    this.TOP = par1.registerIcon("saltmod:SaltGrass_Top");
    this.SIDE = par1.registerIcon("saltmod:SaltGrass_Side");
    this.SIDE_L = par1.registerIcon("saltmod:SaltGrass_Side_L");
    this.SIDE_R = par1.registerIcon("saltmod:SaltGrass_Side_R");
    this.BOTTOM0 = par1.registerIcon("saltmod:SaltDirtLite_0");
    this.BOTTOM1 = par1.registerIcon("saltmod:SaltDirtLite_Bottom");
  }
  
  public void updateTick(World world, int x, int y, int z, Random random) {
    if (!world.isRemote) {
      if (world.getBlock(x, y + 1, z) == Blocks.snow_layer)
        world.setBlockToAir(x, y + 1, z); 
      if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
        int j = world.getBlockMetadata(x, y, z);
        world.setBlock(x, y, z, ModBlocks.saltDirtLite, j, 3);
      } else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
        for (int l = 0; l < 4; l++) {
          int i1 = x + random.nextInt(3) - 1;
          int j1 = y + random.nextInt(5) - 3;
          int k1 = z + random.nextInt(3) - 1;
          Block block = world.getBlock(i1, j1 + 1, k1);
          if (world.getBlock(i1, j1, k1) == Blocks.dirt && world.getBlockMetadata(i1, j1, k1) == 0 && world
            .getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
            world.setBlock(i1, j1, k1, (Block)Blocks.grass); 
        } 
      } 
    } 
  }
  
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
    if (player.capabilities.isCreativeMode && player
      .getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.salt) {
      int i = world.getBlockMetadata(x, y, z);
      if (side <= 1)
        if (i == 0) {
          i = 3;
        } else if (i < 3 || i > 5) {
          i = 0;
        } else {
          i++;
        }  
      if (side == 2)
        if (i == 4) {
          i = 11;
        } else if (i == 5) {
          i = 14;
        } else if (i < 7) {
          i = 7;
        } else if (i == 7) {
          i = 0;
        } else if (i == 8) {
          i = 11;
        } else if (i == 9) {
          i = 15;
        } else if (i == 10) {
          i = 14;
        } else if (i == 11) {
          i = 8;
        } else if (i == 14) {
          i = 10;
        } else if (i < 15) {
          i = 15;
        } else {
          i = 9;
        }  
      if (side == 5)
        if (i == 5) {
          i = 12;
        } else if (i == 6) {
          i = 11;
        } else if (i < 7) {
          i = 8;
        } else if (i == 7) {
          i = 11;
        } else if (i == 8) {
          i = 0;
        } else if (i == 9) {
          i = 12;
        } else if (i == 10) {
          i = 15;
        } else if (i == 11) {
          i = 7;
        } else if (i == 12) {
          i = 9;
        } else if (i < 15) {
          i = 15;
        } else {
          i = 10;
        }  
      if (side == 3)
        if (i == 3) {
          i = 12;
        } else if (i == 6) {
          i = 13;
        } else if (i < 7) {
          i = 9;
        } else if (i == 7) {
          i = 15;
        } else if (i == 8) {
          i = 12;
        } else if (i == 9) {
          i = 0;
        } else if (i == 10) {
          i = 13;
        } else if (i == 12) {
          i = 8;
        } else if (i == 13) {
          i = 10;
        } else if (i < 15) {
          i = 15;
        } else {
          i = 7;
        }  
      if (side == 4)
        if (i == 3) {
          i = 14;
        } else if (i == 4) {
          i = 13;
        } else if (i < 7) {
          i = 10;
        } else if (i == 7) {
          i = 14;
        } else if (i == 8) {
          i = 15;
        } else if (i == 9) {
          i = 13;
        } else if (i == 10) {
          i = 0;
        } else if (i == 13) {
          i = 9;
        } else if (i == 14) {
          i = 7;
        } else if (i < 15) {
          i = 15;
        } else {
          i = 8;
        }  
      world.setBlock(x, y, z, this, i, 3);
      return true;
    } 
    return false;
  }
  
  public Item getItemDropped(int meta, Random random, int fortune) {
    return ModBlocks.saltDirtLite.getItemDropped(0, random, fortune);
  }

  @Override
  public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_,
  		boolean p_149851_5_) {
  	return true;
  }
  
  @Override
  public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
  	return true;
  }
  
  public void func_149853_b(World world, Random random, int x, int y, int z)
  {
      int l = 0;

      while (l < 128)
      {
          int i1 = x;
          int j1 = y + 1;
          int k1 = z;
          int l1 = 0;

          while (true)
          {
              if (l1 < l / 16)
              {
                  i1 += random.nextInt(3) - 1;
                  j1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                  k1 += random.nextInt(3) - 1;

                  if ((world.getBlock(i1, j1 - 1, k1) instanceof BlockGrass || world.getBlock(i1, j1 - 1, k1) == this) && !world.getBlock(i1, j1, k1).isNormalCube())
                  {
                      ++l1;
                      continue;
                  }
              }
              else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
              {
                  if (random.nextInt(8) != 0)
                  {
                      if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1))
                      {
                      	world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                      }
                  }
                  else
                  {
                  	world.getBiomeGenForCoords(i1, k1).plantFlower(world, random, i1, j1, k1);
                  }
              }

              ++l;
              break;
          }
      }
  }
  
  @SideOnly(Side.CLIENT)
  public int getBlockColor()
  {
      return 16777215;
  }

  @SideOnly(Side.CLIENT)
  public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
  {
      return 16777215;
  }
    
  @Override
  public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
  {
  	if (plantable == Blocks.reeds || plantable == Blocks.cactus || plantable == Blocks.deadbush) {
  		return false;
  	}
  	
       return true;
  }
}