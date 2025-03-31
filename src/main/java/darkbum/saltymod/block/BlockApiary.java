package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityApiary;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockApiary extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

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
        this.TOP = icon.registerIcon("saltymod:apiary_top");
        this.SIDE = icon.registerIcon("saltymod:apiary_side");
    }

    public IIcon getIcon(int side, int meta) {
        if(side > 0) {
            if (side == 1)
                return this.TOP;
            return this.SIDE;
        }
        return this.TOP;
    }

    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityApiary();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord, float yCoord, float zCoord) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile == null || player.isSneaking())
            return false;
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
                            if (j1 > itemstack.stackSize)
                                j1 = itemstack.stackSize;
                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (x + f), (y + f1), (z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                            if (itemstack.hasTagCompound())
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            float f3 = 0.05F;
                            entityitem.motionX = ((float)this.random.nextGaussian() * f3);
                            entityitem.motionY = ((float)this.random.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = ((float)this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    protected boolean canSilkHarvest() {
        return false;
    }
}
