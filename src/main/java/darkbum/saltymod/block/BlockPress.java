package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityPress;
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

public class BlockPress extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT;

    private final Random random = new Random();

    private static boolean isBurning;

    public BlockPress(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.6F);
        setResistance(0.6F);
        setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltymod:press_bottom");
        this.TOP = icon.registerIcon("saltymod:press_top");
        this.SIDE = icon.registerIcon("saltymod:press_side");
        this.FRONT = icon.registerIcon("saltymod:press_front");
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

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPress();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) return false;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityPress) {
            player.openGui(SaltyMod.instance, 3, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityPress) {
            dropInventory(world, x, y, z, (TileEntityPress) tile);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    private void dropInventory(World world, int x, int y, int z, TileEntityPress tileEntityPress) {
        for (int i1 = 0; i1 < tileEntityPress.getSizeInventory(); i1++) {
            ItemStack itemstack = tileEntityPress.getStackInSlot(i1);
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
    public void onBlockPlacedBy(World world, int x, int y, int z,
                                EntityLivingBase placer, ItemStack item) {
        int direction = MathHelper.floor_double((placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
