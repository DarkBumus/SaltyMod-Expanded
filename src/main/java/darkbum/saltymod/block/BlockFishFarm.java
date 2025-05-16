package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.tileentity.TileEntityFishFarm;
import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.SaltyMod;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the fish farm block.
 * The fish farm is a tile entity container block that stores and produces items in a bulk fishing context.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockFishFarm extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    private final Random random = new Random();

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name  The internal name of the block.
     * @param tab   The creative tab in which the block appears.
     */
    public BlockFishFarm(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        propertiesApiaryFishFarm(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon  The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconBottom = icon.registerIcon("saltymod:fish_farm_bottom");
        this.iconSide = icon.registerIcon("saltymod:fish_farm_side");
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
        if (side > 1) {
            return this.iconSide;
        }
        return this.iconBottom;
    }

    /**
     * Creates a new tile entity for this block.
     *
     * @param world     The world the block is in.
     * @param meta      The metadata of the block.
     * @return a new tile entity.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityFishFarm();
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
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile == null || player.isSneaking()) return false;
        player.openGui(SaltyMod.instance, 1, world, x, y, z);
        return true;
    }

    /**
     * Called when the block is broken, including handling inventory drops.
     * <p>
     * The block will get the tile entity at the block's position, and if it is valid, will start iterating through the block's inventory,
     * before generating a random offset inside of the block space for the items to drop at. Afterwards it will drop the stacks in those random positions,
     * in stacks of 10-30 items, until there are none left, while keeping the NBT data intact. It adds a slight movement to the stack entities and spawns them,
     * before calling on the breakBlock method of the superclass.
     *
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param block     The block that was replaced.
     * @param meta      The metadata of the block.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntityFishFarm tileEntityFishFarm = (TileEntityFishFarm) world.getTileEntity(x, y, z);

        if (tileEntityFishFarm != null) {
            Random random = this.random;

            for (int i1 = 0; i1 < tileEntityFishFarm.getSizeInventory(); i1++) {
                ItemStack stack = tileEntityFishFarm.getStackInSlot(i1);

                if (stack != null) {
                    float dx = random.nextFloat() * 0.8F + 0.1F;
                    float dy = random.nextFloat() * 0.8F + 0.1F;
                    float dz = random.nextFloat() * 0.8F + 0.1F;

                    while (stack.stackSize > 0) {
                        int dropAmount = random.nextInt(21) + 10;
                        dropAmount = Math.min(dropAmount, stack.stackSize);
                        stack.stackSize -= dropAmount;
                        EntityItem entityItem = new EntityItem(world, x + dx, y + dy, z + dz, new ItemStack(stack.getItem(), dropAmount, stack.getItemDamage()));

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
     * @param world     The world.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param side      The side the comparator is on.
     * @return a redstone level from 0–15.
     */
    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof IInventory) return ((TileEntityFishFarm) tile).getComparatorInputOverride();
        return 0;
    }
}
