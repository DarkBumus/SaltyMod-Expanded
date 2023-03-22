package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import darkbum.saltmod.init.ModBlocks;
import darkbum.saltmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import darkbum.saltmod.common.ClientProxy;

public class BlockSaltGrass extends Block {

    public static final byte[] sideTwo = {7, 7, 7, 7, 11, 14, 7, 0, 11, 15, 14, 8, 15, 15, 10, 9};
    public static final byte[] sideThree = {9, 9, 9, 12, 9, 9, 13, 15, 12, 0, 13, 15, 8, 10, 15, 7};
    public static final byte[] sideFour = {10, 10, 10, 14, 13, 10, 10, 14, 15, 13, 0, 15, 15, 9, 7, 8};
    public static final byte[] sideFive = {8, 8, 8, 8, 8, 12, 11, 11, 0, 12, 15, 7, 9, 15, 15, 10};

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

    public BlockSaltGrass(String name, CreativeTabs tab) {
        super(Material.grass);
        setTickRandomly(true);
        setCreativeTab(tab);
        setStepSound(soundTypeGrass);
        setBlockName(name);
        setHardness(0.5F);
        setResistance(1.0F);
        setHarvestLevel("shovel", 0);
    }

    @Override
    public int getRenderType() {
        return ClientProxy.saltGrassRenderType;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 1) ? this.TOP : ((side == 0 && meta > 0) ? this.BOTTOM1 : ((side == 0 && meta == 0) ? this.BOTTOM0 : (((side == 2 && (meta == 7 || meta == 11 || meta == 14 || meta == 15)) || (side == 5 && (meta == 8 || meta == 11 || meta == 12 || meta == 15)) || (side == 3 && (meta == 9 || meta == 12 || meta == 13 || meta == 15)) || (side == 4 && (meta == 10 || meta == 13 || meta == 14 || meta == 15))) ? this.SIDE : (((side == 2 && (meta == 3 || meta == 8 || meta == 12)) || (side == 5 && (meta == 4 || meta == 9 || meta == 13)) || (side == 3 && (meta == 5 || meta == 10 || meta == 14)) || (side == 4 && (meta == 6 || meta == 7 || meta == 11))) ? this.SIDE_L : (((side == 2 && (meta == 6 || meta == 10 || meta == 13)) || (side == 5 && (meta == 3 || meta == 7 || meta == 14)) || (side == 3 && (meta == 4 || meta == 8 || meta == 11)) || (side == 4 && (meta == 5 || meta == 9 || meta == 12))) ? this.SIDE_R : this.blockIcon)))));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("saltmod:slightly_saline_grass");
        TOP = iconRegister.registerIcon("saltmod:slightly_saline_grass_top");
        SIDE = iconRegister.registerIcon("saltmod:slightly_saline_grass_side_0");
        SIDE_L = iconRegister.registerIcon("saltmod:slightly_saline_grass_side_1");
        SIDE_R = iconRegister.registerIcon("saltmod:slightly_saline_grass_side_2");
        BOTTOM0 = iconRegister.registerIcon("saltmod:slightly_saline_dirt_0");
        BOTTOM1 = iconRegister.registerIcon("saltmod:slightly_saline_dirt_bottom");
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote) {
            if(world.getBlock(x, y + 1, z) == Blocks.snow_layer) {
                world.setBlockToAir(x, y + 1, z);
            }
            if(world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
                int j = world.getBlockMetadata(x, y, z);
                world.setBlock(x, y, z, ModBlocks.lite_salt_dirt, j, 3);
            } else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int l = 0; l < 4; l++) {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);
                    if(!block.isOpaqueCube() && world.getBlock(i1, j1, k1) == ModBlocks.lite_salt_dirt && world.getBlockMetadata(i1, j1, k1) == 0 && world
                        .getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
                        world.setBlock(i1, j1, k1, ModBlocks.salt_grass);
                    }
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        ItemStack heldSTack = player.getCurrentEquippedItem();
        if(heldSTack != null && heldSTack.getItem() == ModItems.salt) {
            int meta = world.getBlockMetadata(x, y, z);
            switch(side) {
                case 0:
                case 1:
                    if (meta == 0) {
                        meta = 3;
                    } else if (meta < 3 || meta > 5) {
                        meta = 0;
                    } else {
                        meta++;
                    }
                    break;
                case 2:
                    meta = sideTwo[meta];
                    break;
                case 3:
                    meta = sideThree[meta];
                    break;
                case 4:
                    meta = sideFour[meta];
                    break;
                case 5:
                    meta = sideFive[meta];
                    break;
            }

            world.setBlock(x, y, z, this, meta, 3);
            return true;
        }
        return false;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModBlocks.lite_salt_dirt.getItemDropped(0, random, fortune);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBlockColor() {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        return 16777215;
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        if(plantable == Blocks.tallgrass || plantable instanceof BlockFlower || plantable == ModBlocks.saltworts) {
            return true;
        }

        return false;
    }

}
