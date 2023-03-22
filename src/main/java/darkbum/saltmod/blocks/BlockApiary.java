package darkbum.saltmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.SaltMod;
import darkbum.saltmod.tileentities.TileEntityApiary;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockApiary extends Block {

    private static boolean field_149934_M;

    private final Random random = new Random();

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT0;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT1;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT2;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT3;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT4;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT5;

    @SideOnly(Side.CLIENT)
    private IIcon FRONT6;


    public BlockApiary(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.6F);
        setResistance(0.6F);
        setStepSound(soundTypeWood);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_) {
        TileEntityApiary tileentityapiary;
        if (!field_149934_M && (

            tileentityapiary = (TileEntityApiary)world.getTileEntity(x, y, z)) != null) {
            for (int i1 = 0; i1 < tileentityapiary.getSizeInventory(); i1++) {
                ItemStack itemstack = tileentityapiary.getStackInSlot(i1);
                if (itemstack != null) {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.random.nextFloat() * 0.8F + 0.1F;
                    while (itemstack.stackSize > 0) {
                        int j1 = this.random.nextInt(21) + 10;
                        if (j1 > itemstack.stackSize)
                            j1 = itemstack.stackSize;
                        itemstack.stackSize -= j1;
                        EntityItem entityitem = new EntityItem(world, (x + f), (y + f1), (z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        if (itemstack.hasTagCompound())
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack
                                .getTagCompound().copy());
                        float f3 = 0.05F;
                        entityitem.motionX = ((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = ((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = ((float)this.random.nextGaussian() * f3);
                        world.spawnEntityInWorld((Entity)entityitem);
                    }
                }
            }
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, p_149749_6_);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord, float yCoord, float zCoord) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile == null || player.isSneaking())
            return false;
        player.openGui(SaltMod.instance, 0, world, x, y, z);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.TOP = icon.registerIcon("saltmod:apiary_top");
        this.FRONT0 = icon.registerIcon("saltmod:apiary_front_0");
        this.FRONT1 = icon.registerIcon("saltmod:apiary_front_1");
        this.FRONT2 = icon.registerIcon("saltmod:apiary_front_2");
        this.FRONT3 = icon.registerIcon("saltmod:apiary_front_3");
        this.FRONT4 = icon.registerIcon("saltmod:apiary_front_4");
        this.FRONT5 = icon.registerIcon("saltmod:apiary_front_5");
        this.FRONT6 = icon.registerIcon("saltmod:apiary_front_6");
    }

    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 7)
            meta = 0;

        if (meta == 0) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT0;
        }
        if (meta == 1) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT1;
        }
        if (meta == 2) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT2;
        }
        if (meta == 3) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT3;
        }
        if (meta == 4) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT4;
        }
        if (meta == 5) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT5;
        }
        if (meta == 6) {
            if (side == 0)
                return this.TOP;
            if (side == 1)
                return this.TOP;
            else
                return this.FRONT6;
        }
        return null;
    }

    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityApiary();
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
