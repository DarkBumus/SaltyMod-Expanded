package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityCookingPot;
import darkbum.saltymod.tileentity.TileEntityCookingPot;
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
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCookingPot extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon SIDE0BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE1TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE2NORTH;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE3SOUTH;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE4WEST;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE5EAST;

    private final Random random = new Random();

    public BlockCookingPot(String name, CreativeTabs tab) {
        super(Material.iron);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(6.0F);
        setStepSound(soundTypeMetal);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        SIDE0BOTTOM = iconRegister.registerIcon("saltymod:dev/dev_side0bottom");
        SIDE1TOP = iconRegister.registerIcon("saltymod:dev/dev_side1top");
        SIDE2NORTH = iconRegister.registerIcon("saltymod:dev/dev_side2north");
        SIDE3SOUTH = iconRegister.registerIcon("saltymod:dev/dev_side3south");
        SIDE4WEST = iconRegister.registerIcon("saltymod:dev/dev_side4west");
        SIDE5EAST = iconRegister.registerIcon("saltymod:dev/dev_side5east");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0) return SIDE0BOTTOM;
        if (side == 1) return SIDE1TOP;
        if (side == 2) return SIDE2NORTH;
        if (side == 3) return SIDE3SOUTH;
        if (side == 4) return SIDE4WEST;
        if (side == 5) return SIDE5EAST;
        return null;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCookingPot();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) return false;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityCookingPot) {
            player.openGui(SaltyMod.instance, 4, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityCookingPot) {
            dropInventory(world, x, y, z, (TileEntityCookingPot) tile);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    private void dropInventory(World world, int x, int y, int z, TileEntityCookingPot TileEntityCookingPot) {
        for (int i1 = 0; i1 < TileEntityCookingPot.getSizeInventory(); i1++) {
            ItemStack itemstack = TileEntityCookingPot.getStackInSlot(i1);
            if (itemstack != null) {
                spawnItemStack(world, x, y, z, itemstack);
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

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack item) {
        int direction = MathHelper.floor_double((placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int meta;
        if (direction == 0 || direction == 2) {
            meta = 0;
        } else {
            meta = 1;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
