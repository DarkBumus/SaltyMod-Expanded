//package ru.liahim.saltmod.block;

//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;

//import java.util.Random;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockSlab;
//import net.minecraft.block.material.MapColor;
//import net.minecraft.block.material.Material;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.item.Item;
//import ru.liahim.saltmod.init.ModBlocks;

//public class MudBrickDrySlab extends BlockSlab {
//  protected boolean crystal = true;
  
//  public static final String[] type = new String[] { "Block", "Brick", "Pillar" };
  
//  public MudBrickDrySlab(boolean isDouble, String name, CreativeTabs tab) {
//    super(isDouble, Material.rock);
//    setTickRandomly(true);
//    setBlockName(name);
//    setCreativeTab(tab);
//    setHardness(1.5F);
//    setResistance(3.0F);
//    setHarvestLevel("pickaxe", 0);
//    this.useNeighborBrightness = true;
//    setBlockTextureName("saltmod:MudBrickDry");
//  }
  
//  public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
//    return Item.getItemFromBlock((Block)ModBlocks.mudBrickDrySlab);
//  }
  
//  protected boolean canSilkHarvest() {
//    return false;
//  }
  
//  public String func_150002_b(int par1) {
//    if (par1 < 0 || par1 >= type.length)
//      par1 = 0; 
//    return getUnlocalizedName() + "." + type[par1];
//  }
  
//  public MapColor getMapColor(int meta) {
//    return MapColor.quartzColor;
//  }
//}