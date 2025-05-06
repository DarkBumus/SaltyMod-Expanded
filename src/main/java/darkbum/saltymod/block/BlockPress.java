package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityPress;
import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the press block.
 * The press is a tile entity container block that turns items into others through recipes.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockPress extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSides;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    @SideOnly(Side.CLIENT)
    private IIcon iconBack;

    private final Random random = new Random();

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockPress(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesMillPress(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconBottom = icon.registerIcon("saltymod:press_bottom");
        this.iconTop = icon.registerIcon("saltymod:press_top");
        this.iconSides = icon.registerIcon("saltymod:press_side");
        this.iconFront = icon.registerIcon("saltymod:press_front");
        this.iconBack = icon.registerIcon("saltymod:press_back");
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side The side of the block being rendered.
     * @param meta The metadata of the block.
     * @return the icon to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons = {iconBottom, iconTop, iconSides, iconSides, iconFront, iconBack};
        int facing = meta % 4;
        return switch (facing) {
            case 0 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 2 ? 5 : (side == 3 ? 4 : 2)))];
            case 1 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 4 ? 4 : (side == 5 ? 5 : 2)))];
            case 2 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 2 ? 4 : (side == 3 ? 5 : 2)))];
            case 3 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 5 ? 4 : (side == 4 ? 5 : 2)))];
            default -> null;
        };
    }

    /**
     * Creates a new tile entity for this block.
     *
     * @param world The world the block is in.
     * @param meta  The metadata of the block.
     * @return a new tile entity.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityPress();
    }

    /**
     * Called when the block is placed by an entity.
     * Sets metadata based on player's rotation.
     *
     * @param world  The world the block is in.
     * @param x      The x-coordinate of the block.
     * @param y      The y-coordinate of the block.
     * @param z      The z-coordinate of the block.
     * @param entity The entity placing the block.
     * @param stack  The item used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        BlockHelper.setBlockDirectionFromEntity(world, x, y, z, entity);
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player The player interacting with the block.
     * @param side   The side the block is interacted with.
     * @param hitX   The x-coordinate of the hit location on the block.
     * @param hitY   The y-coordinate of the hit location on the block.
     * @param hitZ   The z-coordinate of the hit location on the block.
     * @return true, if a GUI was opened, false otherwise
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) return false;
        player.openGui(SaltyMod.instance, 3, world, x, y, z);
        return true;
    }

    /**
     * Called when the block is broken, including handling inventory drops.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileEntityPress) {
            dropInventory(world, x, y, z, (TileEntityPress) tile);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Drops the inventory of the tile entity when the block is broken.
     *
     * @param tileEntityPress    The TileEntityClayOven instance to drop items from.
     */
    private void dropInventory(World world, int x, int y, int z, TileEntityPress tileEntityPress) {
        for (int i1 = 0; i1 < tileEntityPress.getSizeInventory(); i1++) {
            ItemStack itemstack = tileEntityPress.getStackInSlot(i1);
            if (itemstack != null) {
                spawnItemStack(world, x, y, z, itemstack);
            }
        }
        world.func_147453_f(x, y, z, this);
    }

    /**
     * Spawns an itemstack as an entity in the world at the given coordinates.
     * <p>
     * This block will start iterating through the block's inventory,
     * before generating a random offset inside of the block space for the items to drop at. Afterwards it will drop the stacks in those random positions,
     * in stacks of 10-30 items, until there are none left, while keeping the NBT data intact. It adds a slight movement to the stack entities and spawns them,
     * before calling on the breakBlock method of the superclass.
     */
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

    /**
     * Whether this block can be silk-harvested.
     *
     * @return false, silk touch is not supported.
     */
    @Override
    protected boolean canSilkHarvest() {
        return false;
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
     * @param side      The side the comparator is on.
     * @return a redstone level from 0–15.
     */
    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof IInventory) return Container.calcRedstoneFromInventory((IInventory) tile);
        return 0;
    }
}
