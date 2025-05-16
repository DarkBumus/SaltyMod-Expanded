package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;
import darkbum.saltymod.tileentity.TileEntityClayOven;
import darkbum.saltymod.util.BlockUtils;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static darkbum.saltymod.tileentity.TileEntityClayOven.*;
import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the clay oven block.
 * The clay oven is a tile entity container block that produces item in a cooking context.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockClayOven extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    private final Random random = new Random();

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockClayOven(String name, CreativeTabs tab) {
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesClayOven(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        iconBottom = icon.registerIcon("saltymod:clay_oven_bottom");
        iconSide = icon.registerIcon("saltymod:clay_oven_side");
        iconTop = icon.registerIcon("saltymod:clay_oven_top");
        iconFront = icon.registerIcon("saltymod:clay_oven_front");
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
        IIcon[] icons = {iconBottom, iconTop, iconSide, iconFront};
        return switch (meta) {
            case 0 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 3 ? 3 : 2))];
            case 1 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 4 ? 3 : 2))];
            case 2 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 2 ? 3 : 2))];
            case 3 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 5 ? 3 : 2))];
            default -> null;
        };
    }

    /**
     * @return the icon name for the block.
     */
    @Override
    public String getItemIconName() {
        return "clay_oven";
    }

    /**
     * Whether the block is rendered as a normal block (solid) or as a custom model.
     *
     * @return false, as this block is rendered as a custom model.
     */
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Whether the block is opaque or not. This method is necessary for proper rendering.
     *
     * @return false, as this block is not opaque.
     */
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * Sets the bounding box for the block based on its current state.
     *
     * @param world     The world the block is in.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        float minX = 2.0f / 16.0f;
        float minY = 0.0f;
        float minZ = 2.0f / 16.0f;

        float maxX = 14.0f / 16.0f;
        float maxY = 12.0f / 16.0f;
        float maxZ = 14.0f / 16.0f;

        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
    }

    /**
     * Gets the collision bounding box for this block.
     *
     * @return the collision bounding box.
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return AxisAlignedBB.getBoundingBox(
            x + 2.0 / 16.0, y, z + 2.0 / 16.0,
            x + 14.0 / 16.0, y + 12.0 / 16.0, z + 14.0 / 16.0
        );
    }

    /**
     * Creates a new tile entity for this block.
     *
     * @param meta  The metadata of the block.
     * @return a new tile entity.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityClayOven();
    }

    /**
     * Whether this block can be placed at the specified coordinates.
     *
     * @return true if the block can be placed, false otherwise.
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block blockBelow = world.getBlock(x, y - 1, z);

        return blockBelow.getMaterial().isSolid();
    }

    /**
     * Called when the block is placed by an entity.
     * Sets metadata based on player's rotation.
     *
     * @param entity The entity placing the block.
     * @param stack  The item used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        BlockUtils.setBlockDirectionFromEntity(world, x, y, z, entity);
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
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) return false;
        player.openGui(SaltyMod.instance, 5, world, x, y, z);
        return true;
    }

    /**
     * Called when the block is broken, including handling inventory drops.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityClayOven) {
            dropInventory(world, x, y, z, (TileEntityClayOven) tileEntity);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Drops the inventory of the tile entity when the block is broken.
     *
     * @param tileEntityClayOven    The TileEntityClayOven instance to drop items from.
     */
    private void dropInventory(World world, int x, int y, int z, TileEntityClayOven tileEntityClayOven) {
        for (int i1 = 0; i1 < tileEntityClayOven.getSizeInventory(); i1++) {
            if (i1 != slotOutput[0]) {
                ItemStack itemStack = tileEntityClayOven.getStackInSlot(i1);
                if (itemStack != null) {
                    spawnItemStack(world, x, y, z, itemStack);
                }
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
            EntityItem entityItem = new EntityItem(world, x + dx, y + dy, z + dz, new ItemStack(stack.getItem(), dropAmount, stack.getItemDamage()));

            if (stack.hasTagCompound()) {
                entityItem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
            }

            entityItem.motionX = (float) random.nextGaussian() * 0.05F;
            entityItem.motionY = (float) random.nextGaussian() * 0.05F + 0.2F;
            entityItem.motionZ = (float) random.nextGaussian() * 0.05F;
            world.spawnEntityInWorld(entityItem);
        }
    }

    /**
     * Whether this block can be silk-harvested.
     *
     * @return false, silk touch is not supported.
     */
    protected boolean canSilkHarvest() {
        return false;
    }
}
