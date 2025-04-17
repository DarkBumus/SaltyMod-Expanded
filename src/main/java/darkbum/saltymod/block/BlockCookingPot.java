package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.ClientProxy;
import darkbum.saltymod.init.ModSounds;
import darkbum.saltymod.tileentity.TileEntityCookingPot;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

import static darkbum.saltymod.tileentity.TileEntityCookingPot.slotOutput;

public class BlockCookingPot extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    public static IIcon PARTS;

    @SideOnly(Side.CLIENT)
    public static IIcon HANDLE;

    private final Random random = new Random();

    public BlockCookingPot(String name, CreativeTabs tab) {
        super(Material.iron);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(0.5F);
        setResistance(6.0F);
        setStepSound(ModSounds.soundTypeCookingPot);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        BOTTOM = icon.registerIcon("saltymod:cooking_pot_bottom");
        SIDE = icon.registerIcon("saltymod:cooking_pot_side");
        TOP = icon.registerIcon("saltymod:cooking_pot_top");
        PARTS = icon.registerIcon("saltymod:cooking_pot_parts");
        HANDLE = icon.registerIcon("saltymod:cooking_pot_handle");
    }

    public int getRenderType() {
        return ClientProxy.cookingPotRenderType;
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 1) {
            return this.TOP;
        } else if (side == 0) {
            return this.BOTTOM;
        } else {
            return this.SIDE;
        }
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getPartsIcon() {
        return PARTS;
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getHandleIcon() {
        return HANDLE;
    }

    @Override
    public String getItemIconName() {
        return "cooking_pot";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityCookingPot) {
            TileEntityCookingPot pot = (TileEntityCookingPot) tile;
            boolean hasAnyItem = false;
            for (int i = 0; i <= 6; i++) {
                if (pot.getStackInSlot(i) != null) {
                    hasAnyItem = true;
                    break;
                }
            }

            if (pot.isHeaterBelow) {
                if (rand.nextDouble() < 0.1) {
                    if (hasAnyItem) {
                        world.playSound(x + 0.5, y + 0.5, z + 0.5, "saltymod:block.cooking_pot.boil_full", 1.0F, rand.nextFloat() * 0.1F + 0.9F, false);
                    } else {
                        world.playSound(x + 0.5, y + 0.5, z + 0.5, "saltymod:block.cooking_pot.boil_empty", 1.0F, rand.nextFloat() * 0.1F + 0.9F, false);
                    }
                }
            }
        }
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
            // Überprüfen, ob der Slot ein Output-Slot ist (Slot 6)
            if (i1 != slotOutput[0]) { // slotOutput[0] ist der Index des Output-Slots
                ItemStack itemstack = TileEntityCookingPot.getStackInSlot(i1);
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

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(Item.getItemFromBlock(this)));
        return drops;
    }

    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        int direction = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

        boolean isBlockSolid = worldIn.getBlock(x, y - 1, z).isOpaqueCube();

        int metadata = -1;

        if (isBlockSolid) {
            switch (direction) {
                case 0:
                    metadata = 0;
                    break;
                case 1:
                    metadata = 1;
                    break;
                case 2:
                    metadata = 2;
                    break;
                case 3:
                    metadata = 3;
                    break;
            }
        } else {
            switch (direction) {
                case 0:
                    metadata = 4;
                    break;
                case 1:
                    metadata = 5;
                    break;
                case 2:
                    metadata = 6;
                    break;
                case 3:
                    metadata = 7;
                    break;
            }
        }
        worldIn.setBlockMetadataWithNotify(x, y, z, metadata, 2);
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
        float maxY = 10.0f / 16.0f;
        float maxZ = 14.0f / 16.0f;

        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(
            x + 2.0 / 16.0, y, z + 2.0 / 16.0,
            x + 14.0 / 16.0, y + 10.0 / 16.0, z + 14.0 / 16.0
        );
    }
}
