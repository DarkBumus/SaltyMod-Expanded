package darkbum.saltymod.block;

import java.util.Random;

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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityFishFarm;

public class BlockFishFarm extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    private final Random random = new Random();

    private static boolean isBurning;

    public BlockFishFarm(String name, CreativeTabs tab) {
        super(Material.wood);
        setTickRandomly(true);
        setStepSound(soundTypeWood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.6F);
        setResistance(0.6F);
        setHarvestLevel("axe", 0);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltymod:fish_farm_bottom");
        this.SIDE = icon.registerIcon("saltymod:fish_farm_side");
    }

    public IIcon getIcon(int side, int meta) {
        if (side > 1) {
            return this.SIDE;
        }
        return this.BOTTOM;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityFishFarm();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xCoord,
        float yCoord, float zCoord) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile == null || player.isSneaking()) {
            return false;
        }
        player.openGui(SaltyMod.instance, 1, world, x, y, z);
        return true;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!isBurning) {
            TileEntityFishFarm tileEntityFishFarm = (TileEntityFishFarm) world.getTileEntity(x, y, z);
            if (tileEntityFishFarm != null) {
                for (int i1 = 0; i1 < tileEntityFishFarm.getSizeInventory(); i1++) {
                    ItemStack itemstack = tileEntityFishFarm.getStackInSlot(i1);
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
}
