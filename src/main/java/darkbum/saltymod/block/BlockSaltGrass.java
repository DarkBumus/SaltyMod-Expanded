package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
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
import darkbum.saltymod.common.ClientProxy;

public class BlockSaltGrass extends Block {

    public static final byte[] sideTwo = {7, 7, 7, 7, 11, 14, 7, 0, 11, 15, 14, 8, 15, 15, 10, 9};
    public static final byte[] sideThree = {9, 9, 9, 12, 9, 9, 13, 15, 12, 0, 13, 15, 8, 10, 15, 7};
    public static final byte[] sideFour = {10, 10, 10, 14, 13, 10, 10, 14, 15, 13, 0, 15, 15, 9, 7, 8};
    public static final byte[] sideFive = {8, 8, 8, 8, 8, 12, 11, 11, 0, 12, 15, 7, 9, 15, 15, 10};

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM0;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM1;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon SALTSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon SALTSIDE_L;

    @SideOnly(Side.CLIENT)
    private IIcon SALTSIDE_R;

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
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return BOTTOM0;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return SIDE;
                }
                break;
            case 7:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE;
                    case 3:
                        return SIDE;
                    case 4:
                        return SALTSIDE_L;
                    case 5:
                        return SALTSIDE_R;
                }
            case 8:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_L;
                    case 3:
                        return SALTSIDE_R;
                    case 4:
                        return SIDE;
                    case 5:
                        return SALTSIDE;
                }
            case 9:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SIDE;
                    case 3:
                        return SALTSIDE;
                    case 4:
                        return SALTSIDE_R;
                    case 5:
                        return SALTSIDE_L;
                }
            case 10:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_R;
                    case 3:
                        return SALTSIDE_L;
                    case 4:
                        return SALTSIDE;
                    case 5:
                        return SIDE;
                }
            case 11:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                    case 5:
                        return SALTSIDE;
                    case 3:
                        return SALTSIDE_R;
                    case 4:
                        return SALTSIDE_L;
                }
            case 12:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_L;
                    case 3:
                    case 5:
                        return SALTSIDE;
                    case 4:
                        return SALTSIDE_R;
                }
            case 13:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                        return SALTSIDE_R;
                    case 3:
                    case 4:
                        return SALTSIDE;
                    case 5:
                        return SALTSIDE_L;
                }
            case 14:
                switch (side) {
                    case 0:
                        return BOTTOM1;
                    case 2:
                    case 4:
                        return SALTSIDE;
                    case 3:
                        return SALTSIDE_L;
                    case 5:
                        return SALTSIDE_R;
                }
        }
        return TOP;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        BOTTOM0 = iconRegister.registerIcon("saltymod:salt_dirt_0");
        BOTTOM1 = iconRegister.registerIcon("saltymod:salt_dirt_bottom");
        TOP = iconRegister.registerIcon("saltymod:salt_grass_top");
        SIDE = iconRegister.registerIcon("saltymod:salt_grass");
        SALTSIDE = iconRegister.registerIcon("saltymod:salt_grass_saltside");
        SALTSIDE_L = iconRegister.registerIcon("saltymod:salt_grass_saltside_l");
        SALTSIDE_R = iconRegister.registerIcon("saltymod:salt_grass_saltside_r");
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote) {
            if(world.getBlock(x, y + 1, z) == Blocks.snow_layer) {
                world.setBlockToAir(x, y + 1, z);
            }
            if(world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
                int j = world.getBlockMetadata(x, y, z);
                world.setBlock(x, y, z, ModBlocks.salt_dirt, j, 3);
            } else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int l = 0; l < 4; l++) {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);
                    if(!block.isOpaqueCube() && world.getBlock(i1, j1, k1) == ModBlocks.salt_dirt && world.getBlockMetadata(i1, j1, k1) == 0 && world
                        .getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
                        world.setBlock(i1, j1, k1, ModBlocks.salt_grass);
                    }
                }
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        ItemStack heldStack = player.getCurrentEquippedItem();
        if(heldStack != null && heldStack.getItem() == ModItems.salt) {
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
        return ModBlocks.salt_dirt.getItemDropped(0, random, fortune);
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
