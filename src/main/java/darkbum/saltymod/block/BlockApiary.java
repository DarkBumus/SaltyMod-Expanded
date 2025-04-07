package darkbum.saltymod.block;

import java.util.Random;

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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityApiary;

public class BlockApiary extends BlockContainer {

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

    public BlockApiary(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.6F);
        setResistance(0.6F);
        setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltymod:apiary_bottom");
        this.TOP = icon.registerIcon("saltymod:apiary_top");
        this.SIDE = icon.registerIcon("saltymod:apiary_side");
        this.FRONT = icon.registerIcon("saltymod:apiary_front");
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
        return new TileEntityApiary();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord,
        float yCoord, float zCoord) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile == null || player.isSneaking()) return false;
        player.openGui(SaltyMod.instance, 2, world, x, y, z);
        return true;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!isBurning) {
            TileEntityApiary tileEntityApiary = (TileEntityApiary) world.getTileEntity(x, y, z);
            if (tileEntityApiary != null) {
                for (int i1 = 0; i1 < tileEntityApiary.getSizeInventory(); i1++) {
                    ItemStack itemstack = tileEntityApiary.getStackInSlot(i1);
                    if (itemstack != null) {
                        float f = this.random.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.random.nextFloat() * 0.8F + 0.1F;
                        while (itemstack.stackSize > 0) {
                            int j1 = this.random.nextInt(21) + 10;
                            if (j1 > itemstack.stackSize) j1 = itemstack.stackSize;
                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(
                                world,
                                (x + f),
                                (y + f1),
                                (z + f2),
                                new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                            if (itemstack.hasTagCompound()) entityitem.getEntityItem()
                                .setTagCompound(
                                    (NBTTagCompound) itemstack.getTagCompound()
                                        .copy());
                            float f3 = 0.05F;
                            entityitem.motionX = ((float) this.random.nextGaussian() * f3);
                            entityitem.motionY = ((float) this.random.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = ((float) this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        worldIn.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
