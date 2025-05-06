package darkbum.saltymod.block;

import java.util.Objects;
import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.common.proxy.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.tileentity.TileEntityEvaporator;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the evaporator block.
 * The evaporator is a tile entity container block that stores fluids and produces item in an evaporation context.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockEvaporator extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    private static boolean isBurning;

    private final boolean isActive;

    private final boolean isEvaporating;

    private final Random random = new Random();

    /**
     * Constructs a new block instance with a given name, a creative tab and active/evaporating states.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name  The internal name of the block.
     * @param tab   The creative tab in which the block appears.
     */
    public BlockEvaporator(String name, CreativeTabs tab, boolean active, boolean evaporating) {
        super(Material.rock);
        this.isActive = active;
        this.isEvaporating = evaporating;
        setBlockName(name);
        setCreativeTab(tab);
        propertiesEvaporator(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon  The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconSide = icon.registerIcon("furnace_side");
        this.iconFront = icon.registerIcon(this.isActive ? "saltymod:evaporator_front_on" : "saltymod:evaporator_front_off");
        this.iconTop = icon.registerIcon("saltymod:evaporator_top");
        this.iconBottom = icon.registerIcon("furnace_top");
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side  The side of the block being rendered.
     * @param meta  The metadata of the block.
     * @return the icon to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons = {iconBottom, iconTop, iconSide, iconFront};
        return switch (side) {
            case 0 -> icons[0];
            case 1 -> icons[1];
            default -> (side != meta) ? icons[2] : icons[3];
        };
    }

    /**
     * Gets the render type for this block.
     *
     * @return a custom render type ID, provided by the client proxy.
     */
    @Override
    public int getRenderType() {
        return ClientProxy.evaporatorRenderType;
    }

    /**
     * Creates a new tile entity for this block.
     *
     * @param meta The metadata of the block.
     * @return a new tile entity.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityEvaporator();
    }

    /**
     * Called when the block is placed in the world by an entity.
     * Determines the facing based on the placing entity's yaw rotation
     * and applies a custom display name if available.
     *
     * @param world     The world in which the block is placed.
     * @param x         X-coordinate of the block.
     * @param y         Y-coordinate of the block.
     * @param z         Z-coordinate of the block.
     * @param entity    The entity placing the block.
     * @param stack     The item stack used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int l = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
        if (l == 0) world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if (l == 1) world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        if (l == 2) world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if (l == 3) world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        if (stack.hasDisplayName())
            ((TileEntityEvaporator) world.getTileEntity(x, y, z)).func_145951_a(stack.getDisplayName());
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player    The player interacting with the block.
     * @param side      The side the block is interacted with.
     * @param hitX      The x-coordinate of the hit location on the block.
     * @param hitY      The y-coordinate of the hit location on the block.
     * @param hitZ      The z-coordinate of the hit location on the block.
     * @return true, if a GUI was opened, false otherwise
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) return true;
        TileEntityEvaporator tileEntityEvaporator = (TileEntityEvaporator) world.getTileEntity(x, y, z);
        if (tileEntityEvaporator != null) {
            ItemStack itemstack = player.inventory.getCurrentItem();
            if (!fillTank(world, x, y, z, tileEntityEvaporator, itemstack, player) && !drainTank(world, x, y, z, tileEntityEvaporator, itemstack, player))
                player.openGui(SaltyMod.instance, 0, world, x, y, z);
        }
        return true;
    }

    /**
     * Attempts to fill the evaporator's internal tank from a fluid container
     * held by the player. If successful, consumes the held item and replaces
     * it with the container's empty version or adds it to the inventory.
     *
     * @return true if a fluid was successfully transferred into the tank, false otherwise.
     */
    public static boolean fillTank(World world, int x, int y, int z, IFluidHandler tank, ItemStack stack, EntityPlayer player) {
        if (stack != null) {
            FluidStack heldContents = FluidContainerRegistry.getFluidForFilledItem(stack);
            if (heldContents != null && stack.getItem() != Items.potionitem) {
                int used = tank.fill(ForgeDirection.UNKNOWN, heldContents, true);
                if (used > 0) {
                    ItemStack consumedStack = Objects.requireNonNull(stack.getItem()).getContainerItem(stack);
                    if (consumedStack != null && !player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, stack, player, consumedStack);
                    return true;
                }
            } else if (stack.getItem() == Items.potionitem) {
                heldContents = new FluidStack(FluidRegistry.WATER, 333);
                int used = tank.fill(ForgeDirection.UNKNOWN, heldContents, true);
                if (used > 0) {
                    if (!player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, stack, player, new ItemStack(Items.glass_bottle));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Attempts to drain fluid from the evaporator's internal tank into a container item
     * held by the player. If successful, replaces the held item with the filled container
     * or adds it to the inventory.
     *
     * @return true if a fluid was successfully drained into a container, false otherwise.
     */
    private boolean drainTank(World world, int x, int y, int z, IFluidHandler tank, ItemStack stack, EntityPlayer player) {
        if (stack != null) {
            FluidStack heldContents;
            FluidStack available = tank.drain(ForgeDirection.UNKNOWN, 2147483647, false);
            if (available != null) {
                ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, stack);
                heldContents = FluidContainerRegistry.getFluidForFilledItem(filled);
                if (available.getFluid() == FluidRegistry.WATER && stack.getItem() == Items.glass_bottle
                    && available.amount >= 333) {
                    if (!player.capabilities.isCreativeMode)
                        playerInvChange(world, x, y, z, stack, player, new ItemStack(Items.potionitem));
                    tank.drain(ForgeDirection.UNKNOWN, 333, true);
                    return true;
                }
                if (heldContents != null) {
                    if (!player.capabilities.isCreativeMode) playerInvChange(world, x, y, z, stack, player, filled);
                    tank.drain(ForgeDirection.UNKNOWN, heldContents.amount, true);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Handles the inventory changes when the player interacts with the fluid container.
     * Removes or replaces the held item accordingly and drops overflow into the world.
     *
     * @param held   The held item stack to be consumed.
     * @param player The player interacting.
     * @param stack  The resulting stack after interaction.
     */
    private static void playerInvChange(World world, int x, int y, int z, ItemStack held, EntityPlayer player, ItemStack stack) {
        if (--held.stackSize <= 0) player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
        if (player.inventory.getCurrentItem() != null) {
            if (!player.inventory.addItemStackToInventory(stack)) {
                world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 1.5D, z + 0.5D, stack));
            } else if (player instanceof EntityPlayerMP) {
                ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
            }
        } else {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
            if (player instanceof EntityPlayerMP)
                ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
        }
    }

    /**
     * Updates the evaporator's state based on whether it is burning
     * and/or evaporating, while preserving metadata and tile entity.
     *
     * @param burning     Whether the block is currently burning (i.e., has fuel).
     * @param evaporator  Whether the block is currently evaporating (i.e., processing).
     */
    public static void updateEvaporatorState(boolean burning, boolean evaporator, World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        isBurning = true;
        if (burning) {
            if (evaporator) {
                world.setBlock(x, y, z, ModBlocks.steam_evaporator);
            } else {
                world.setBlock(x, y, z, ModBlocks.lit_evaporator);
            }
        } else {
            world.setBlock(x, y, z, ModBlocks.evaporator);
        }
        isBurning = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    /**
     * Called when the block is broken, including handling inventory drops.
     * <p>
     * The block will get the tile entity at the block's position, and if it is valid, will start iterating through the block's inventory,
     * before generating a random offset inside of the block space for the items to drop at. Afterwards it will drop the stacks in those random positions,
     * in stacks of 10-30 items, until there are none left, while keeping the NBT data intact. It adds a slight movement to the stack entities and spawns them,
     * before calling on the breakBlock method of the superclass.
     *
     * @param block     The block that was replaced.
     * @param meta      The metadata of the block.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!isBurning) {
            TileEntityEvaporator tileEntityEvaporator = (TileEntityEvaporator) world.getTileEntity(x, y, z);

            if (tileEntityEvaporator != null) {
                Random random = this.random;

                for (int i1 = 0; i1 < tileEntityEvaporator.getSizeInventory(); i1++) {
                    ItemStack stack = tileEntityEvaporator.getStackInSlot(i1);

                    if (stack != null) {
                        float dx = random.nextFloat() * 0.8F + 0.1F;
                        float dy = random.nextFloat() * 0.8F + 0.1F;
                        float dz = random.nextFloat() * 0.8F + 0.1F;

                        while (stack.stackSize > 0) {
                            int dropAmount = random.nextInt(21) + 10;
                            if (dropAmount > stack.stackSize) dropAmount = stack.stackSize;
                            stack.stackSize -= dropAmount;
                            EntityItem entityItem = new EntityItem(world, (x + dx), (y + dy), (z + dz), new ItemStack(stack.getItem(), dropAmount, stack.getItemDamage()));

                            if (stack.hasTagCompound()) entityItem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());

                            entityItem.motionX = (float) random.nextGaussian() * 0.05F;
                            entityItem.motionY = (float) random.nextGaussian() * 0.05F + 0.2F;
                            entityItem.motionZ = (float) random.nextGaussian() * 0.05F;
                            world.spawnEntityInWorld(entityItem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
            super.breakBlock(world, x, y, z, block, meta);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Returns the item that is selected through pickBlock.
     *
     * @return The item associated with the unlit evaporator.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.evaporator);
    }

    /**
     * Returns the item dropped when the slab is broken.
     * Always returns the single (half) slab, regardless of whether the block is a double slab.
     *
     * @param meta      The metadata of the block.
     * @param random    Random number generator.
     * @param fortune   The fortune level of the player's tool.
     * @return the item representing the single slab.
     */
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.evaporator);
    }

    /**
     * Called randomly on the client side to display audiovisual effects such as particles and sounds.
     *
     * @param random A random number generator.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (this.isActive) {
            int meta = world.getBlockMetadata(x, y, z);
            float centerX = x + 0.5F;
            float centerY = y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float centerZ = z + 0.5F;

            float sideOffset = 0.52F;
            float randomOffset = random.nextFloat() * 0.6F - 0.3F;

            double particleX = (x + random.nextFloat() * 0.4F + 0.3F);
            double particleZ = (z + random.nextFloat() * 0.4F + 0.3F);

            double dripX = (x + random.nextFloat());
            double dripZ = (z + random.nextFloat());

            boolean isAboveClear = (!world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN) && FluidRegistry.lookupFluidForBlock(world.getBlock(x, y + 1, z)) == null);
            boolean hasCeiling = world.isSideSolid(x, y + 2, z, ForgeDirection.DOWN);

            if (meta == 4) {
                world.spawnParticle("smoke", (centerX - sideOffset), centerY, (centerZ + randomOffset), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (centerX - sideOffset), centerY, (centerZ + randomOffset), 0.0D, 0.0D, 0.0D);
            } else if (meta == 5) {
                world.spawnParticle("smoke", (centerX + sideOffset), centerY, (centerZ + randomOffset), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (centerX + sideOffset), centerY, (centerZ + randomOffset), 0.0D, 0.0D, 0.0D);
            } else if (meta == 2) {
                world.spawnParticle("smoke", (centerX + randomOffset), centerY, (centerZ - sideOffset), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (centerX + randomOffset), centerY, (centerZ - sideOffset), 0.0D, 0.0D, 0.0D);
            } else if (meta == 3) {
                world.spawnParticle("smoke", (centerX + randomOffset), centerY, (centerZ + sideOffset), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (centerX + randomOffset), centerY, (centerZ + sideOffset), 0.0D, 0.0D, 0.0D);
            } else if (meta == 1) {
                world.spawnParticle("smoke", (centerX + randomOffset), centerY, (centerZ + sideOffset), 0.0D, 0.0D, 0.0D);
            }
            if (this.isEvaporating && isAboveClear) {
                world.spawnParticle("explode", particleX, y + 1.1D, particleZ, 0.0D, 0.1D, 0.0D);
                if (hasCeiling && random.nextInt(10) == 0)
                    world.spawnParticle("dripWater", dripX, y + 1.95D, dripZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Whether the block has comparator input for redstone signals.
     *
     * @return true, to allow comparators to read inventory state.
     */
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    /**
     * Provides comparator redstone output based on the inventory.
     *
     * @param world     The world.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param side      The side the comparator is on.
     * @return a redstone level from 0–15.
     */
    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
        TileEntityEvaporator tileEntityEvaporator = (TileEntityEvaporator) world.getTileEntity(x, y, z);
        return (tileEntityEvaporator.tank.getFluid() != null) ? tileEntityEvaporator.getFluidAmountScaled(15) : 0;
    }
}
