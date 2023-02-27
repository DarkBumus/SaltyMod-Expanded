package darkbum.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;
import darkbum.saltmod.SaltMod;
import darkbum.saltmod.common.ClientProxy;
import darkbum.saltmod.tileentity.TileEntityExtractor;

public class Extractor extends BlockContainer {
    @SideOnly(Side.CLIENT)
    private IIcon TOP;

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon SIDE;

    private static boolean isBurning;

    private final Random random = new Random();

    private final boolean isActive;

    private final boolean isExtract;

    public Extractor(boolean act, boolean ext, String name, CreativeTabs tab) {
        super(Material.rock);
        this.isActive = act;
        this.isExtract = ext;
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(5.0F);
        setResistance(10.0F);
    }

    public int getRenderType() {
        return ClientProxy.extractorRenderType;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (side == 1) ? this.TOP : ((side == 0) ? this.BOTTOM : ((side != meta) ? this.SIDE : this.blockIcon));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1) {
        this.SIDE = par1.registerIcon("furnace_side");
        this.blockIcon = par1.registerIcon(this.isActive ? "saltmod:Extractor_Fase_On" : "saltmod:Extractor_Fase_Off");
        this.TOP = par1.registerIcon("saltmod:Extractor_Top");
        this.BOTTOM = par1.registerIcon("furnace_top");
    }

    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemFromBlock(ModBlocks.extractor);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        direction(world, x, y, z);
    }

    private void direction(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;
            if (block.func_149730_j() && !block1.func_149730_j())
                b0 = 3;
            if (block1.func_149730_j() && !block.func_149730_j())
                b0 = 2;
            if (block2.func_149730_j() && !block3.func_149730_j())
                b0 = 5;
            if (block3.func_149730_j() && !block2.func_149730_j())
                b0 = 4;
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (world.isRemote)
            return true;
        TileEntityExtractor te = (TileEntityExtractor)world.getTileEntity(x, y, z);
        if (te != null) {
            ItemStack itemstack = player.inventory.getCurrentItem();
            if (!fillTank(world, x, y, z, (IFluidHandler)te, itemstack, player) &&
                !drainTank(world, x, y, z, (IFluidHandler)te, itemstack, player))
                player.openGui(SaltMod.instance, 0, world, x, y, z);
        }
        return true;
    }

    public static boolean fillTank(World world, int x, int y, int z, IFluidHandler tank, ItemStack held, EntityPlayer player) {
        if (held != null) {
            FluidStack heldContents = FluidContainerRegistry.getFluidForFilledItem(held);
            if (heldContents != null && held.getItem() != Items.potionitem) {
                int used = tank.fill(ForgeDirection.UNKNOWN, heldContents, true);
                if (used > 0) {
                    ItemStack consumed = held.getItem().getContainerItem(held);
                    if (consumed != null && !player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, held, player, consumed);
                    return true;
                }
            } else if (held.getItem() == Items.potionitem) {
                heldContents = new FluidStack(FluidRegistry.WATER, 333);
                int used = tank.fill(ForgeDirection.UNKNOWN, heldContents, true);
                if (used > 0) {
                    if (!player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, held, player, new ItemStack(Items.glass_bottle));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean drainTank(World world, int x, int y, int z, IFluidHandler tank, ItemStack held, EntityPlayer player) {
        if (held != null) {
            FluidStack heldContents = FluidContainerRegistry.getFluidForFilledItem(held);
            FluidStack available = tank.drain(ForgeDirection.UNKNOWN, 2147483647, false);
            if (available != null) {
                ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, held);
                heldContents = FluidContainerRegistry.getFluidForFilledItem(filled);
                if (available.getFluid() == FluidRegistry.WATER && held.getItem() == Items.glass_bottle && available.amount >= 333) {
                    if (!player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, held, player, new ItemStack((Item)Items.potionitem));
                    tank.drain(ForgeDirection.UNKNOWN, 333, true);
                    return true;
                }
                if (heldContents != null) {
                    if (!player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, held, player, filled);
                    tank.drain(ForgeDirection.UNKNOWN, heldContents.amount, true);
                    return true;
                }
            }
        }
        return false;
    }

    private static void playerInvChange(World world, int x, int y, int z, ItemStack held, EntityPlayer player, ItemStack stack) {
        if (--held.stackSize <= 0)
            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
        if (player.inventory.getCurrentItem() != null) {
            if (!player.inventory.addItemStackToInventory(stack)) {
                world.spawnEntityInWorld((Entity)new EntityItem(world, x + 0.5D, y + 1.5D, z + 0.5D, stack));
            } else if (player instanceof EntityPlayerMP) {
                ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
            }
        } else {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
            if (player instanceof EntityPlayerMP)
                ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
        }
    }

    public static void updateExtractorBlockState(boolean burning, boolean extracting, World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        isBurning = true;
        if (burning) {
            if (extracting) {
                world.setBlock(x, y, z, ModBlocks.extractorSteam);
            } else {
                world.setBlock(x, y, z, ModBlocks.extractorLit);
            }
        } else {
            world.setBlock(x, y, z, ModBlocks.extractor);
        }
        isBurning = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return (TileEntity)new TileEntityExtractor();
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
        if (l == 0)
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if (l == 1)
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        if (l == 2)
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if (l == 3)
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        if (itemStack.hasDisplayName())
            ((TileEntityExtractor)world.getTileEntity(x, y, z)).func_145951_a(itemStack.getDisplayName());
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!isBurning) {
            TileEntityExtractor TileEntitySaltExtractor = (TileEntityExtractor)world.getTileEntity(x, y, z);
            if (TileEntitySaltExtractor != null) {
                for (int i1 = 0; i1 < TileEntitySaltExtractor.getSizeInventory(); i1++) {
                    ItemStack itemstack = TileEntitySaltExtractor.getStackInSlot(i1);
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
                            world.spawnEntityInWorld((Entity)entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (this.isActive) {
            int l = world.getBlockMetadata(x, y, z);
            float f = x + 0.5F;
            float f1 = y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            double f5 = (x + random.nextFloat() * 0.4F + 0.3F);
            double f6 = (z + random.nextFloat() * 0.4F + 0.3F);
            double f7 = (x + random.nextFloat());
            double f8 = (z + random.nextFloat());
            boolean clear = (!world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN) && FluidRegistry.lookupFluidForBlock(world.getBlock(x, y + 1, z)) == null);
            boolean ceiling = world.isSideSolid(x, y + 2, z, ForgeDirection.DOWN);
            if (l == 4) {
                world.spawnParticle("smoke", (f - f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (f - f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
            } else if (l == 5) {
                world.spawnParticle("smoke", (f + f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (f + f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
            } else if (l == 2) {
                world.spawnParticle("smoke", (f + f4), f1, (f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (f + f4), f1, (f2 - f3), 0.0D, 0.0D, 0.0D);
            } else if (l == 3) {
                world.spawnParticle("smoke", (f + f4), f1, (f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (f + f4), f1, (f2 + f3), 0.0D, 0.0D, 0.0D);
            } else if (l == 1) {
                world.spawnParticle("smoke", (f + f4), f1, (f2 + f3), 0.0D, 0.0D, 0.0D);
            }
            if (this.isExtract && clear) {
                world.spawnParticle("explode", f5, y + 1.1D, f6, 0.0D, 0.1D, 0.0D);
                if (ceiling && random.nextInt(10) == 0)
                    world.spawnParticle("dripWater", f7, y + 1.95D, f8, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public boolean hasComparatorInputOverride() {
        return true;
    }

    public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
        TileEntityExtractor te = (TileEntityExtractor)world.getTileEntity(x, y, z);
        return (te.tank.getFluid() != null) ? te.getFluidAmountScaled(15) : 0;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.extractor);
    }
}
