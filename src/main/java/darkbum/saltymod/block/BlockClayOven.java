package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityClayOven;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static darkbum.saltymod.tileentity.TileEntityCookingPot.slotOutput;

public class BlockClayOven extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT;

    private final Random random = new Random();

    public BlockClayOven(String name, CreativeTabs tab) {
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(3.5F);
        setStepSound(soundTypeStone);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        BOTTOM = icon.registerIcon("saltymod:clay_oven_bottom");
        SIDE = icon.registerIcon("saltymod:clay_oven_side");
        TOP = icon.registerIcon("saltymod:clay_oven_top");
        FRONT = icon.registerIcon("saltymod:clay_oven_front");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 4:
                    case 5:
                        return SIDE;
                    case 3:
                        return FRONT;
                }
            case 1:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 5:
                    case 3:
                        return SIDE;
                    case 4:
                        return FRONT;
                }
            case 2:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                        return FRONT;
                    case 4:
                    case 5:
                    case 3:
                        return SIDE;
                }
            case 3:
                switch (side) {
                    case 0:
                        return BOTTOM;
                    case 1:
                        return TOP;
                    case 2:
                    case 3:
                    case 4:
                        return SIDE;
                    case 5:
                        return FRONT;
                }
        }
        return null;
    }

    @Override
    public String getItemIconName() {
        return "clay_oven";
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block blockBelow = world.getBlock(x, y - 1, z);
        Block blockAbove = world.getBlock(x, y + 1, z);

        boolean solidBelow = blockBelow.getMaterial().isSolid();
        boolean solidAbove = blockAbove.getMaterial().isSolid();

        return solidBelow || solidAbove;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityClayOven();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) return false;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityClayOven) {
            player.openGui(SaltyMod.instance, 5, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityClayOven) {
            dropInventory(world, x, y, z, (TileEntityClayOven) tile);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    private void dropInventory(World world, int x, int y, int z, TileEntityClayOven TileEntityClayOven) {
        for (int i1 = 0; i1 < TileEntityClayOven.getSizeInventory(); i1++) {
            if (i1 != slotOutput[0]) {
                ItemStack itemstack = TileEntityClayOven.getStackInSlot(i1);
                if (itemstack != null) {
                    spawnItemStack(world, x, y, z, itemstack);
                }
            }
        }
        world.func_147453_f(x, y, z, this);
    }

    private void spawnItemStack(World world, int x, int y, int z, ItemStack stack) {
        float dx = random.nextFloat() * 0.8F + 0.1F;
        float dy = random.nextFloat() * 0.8F + 0.1F;
        float dz = random.nextFloat() * 0.8F + 0.1F;

        while (stack.stackSize > 0) {
            int dropAmount = random.nextInt(21) + 10;
            if (dropAmount > stack.stackSize) dropAmount = stack.stackSize;

            stack.stackSize -= dropAmount;
            ItemStack drop = new ItemStack(stack.getItem(), dropAmount, stack.getItemDamage());

            if (stack.hasTagCompound()) {
                drop.setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
            }

            EntityItem entity = new EntityItem(world, x + dx, y + dy, z + dz, drop);

            float speed = 0.05F;
            entity.motionX = random.nextGaussian() * speed;
            entity.motionY = random.nextGaussian() * speed + 0.2F;
            entity.motionZ = random.nextGaussian() * speed;

            world.spawnEntityInWorld(entity);
        }
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        worldIn.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, int x, int y, int z) {
        float minX = 2.0f / 16.0f;
        float minY = 0.0f;
        float minZ = 2.0f / 16.0f;

        float maxX = 14.0f / 16.0f;
        float maxY = 12.0f / 16.0f;
        float maxZ = 14.0f / 16.0f;

        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(
            x + 2.0 / 16.0, y, z + 2.0 / 16.0,
            x + 14.0 / 16.0, y + 12.0 / 16.0, z + 14.0 / 16.0
        );
    }
}
