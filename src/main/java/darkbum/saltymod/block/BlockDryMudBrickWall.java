package darkbum.saltymod.block;

import java.util.List;
import java.util.Random;

import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Block class for the dry mud brick wall block.
 * The dry mud brick wall is a regular wall block.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockDryMudBrickWall extends BlockWall {

    /**
     * Constructs a new block instance with a parent block and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param tab  The creative tab in which the block appears.
     */
    public BlockDryMudBrickWall(Block block, CreativeTabs tab) {
        super(block);
        setBlockName("dry_mud_brick_wall");
        setCreativeTab(tab);
        setBlockTextureName("saltymod:mud_bricks");
        this.useNeighborBrightness = true;
        propertiesDryMudBrick(this);
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
        return ModBlocks.dry_mud_brick.getIcon(side, meta);
    }

    /**
     * Adds the wall block as a single variant to the creative inventory.
     *
     * @param item  The item corresponding to this block.
     * @param tab   The creative tab to which the item belongs.
     * @param list  The list of sub-items to display in the creative inventory.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        list.add(new ItemStack(item, 1, 0));
    }

    /**
     * Returns the item stack to be picked when the block is targeted in creative mode.
     * Always returns a single slab, even if targeting a double slab.
     *
     * @param target    The targeted block hit result.
     * @param world     The world the block is in.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param player    The player picking the block.
     * @return an item stack of the single dry mud brick slab.
     */
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(this, 1, world.getBlockMetadata(x, y, z));
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
        return Item.getItemFromBlock(ModBlocks.dry_mud_brick_wall);
    }

    /**
     * Whether a torch can be placed on top of the wall block.
     *
     * @return true, allowing torches to be placed on top of the wall.
     */
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }
}
