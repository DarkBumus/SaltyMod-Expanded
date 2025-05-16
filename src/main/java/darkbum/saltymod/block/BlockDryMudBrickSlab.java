package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the dry mud brick slab block.
 * The dry mud brick slab is a regular slab block.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockDryMudBrickSlab extends BlockSlab {

    /**
     * Constructs a new block instance with a boolean for isDouble, a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockDryMudBrickSlab(boolean isDouble, String name, CreativeTabs tab) {
        super(isDouble, Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltymod:mud_bricks");
        this.useNeighborBrightness = true;
        propertiesDryMudBrick(this);
    }

    /**
     * Returns the unlocalized name for this slab variant.
     * In this case, only one variant exists, so the base name is returned.
     *
     * @param meta      The metadata of the block.
     * @return the unlocalized name of the block.
     */
    @Override
    public String func_150002_b(int meta) {     //getUnlocalizedName()
        return getUnlocalizedName();
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
        return new ItemStack(ModBlocks.dry_mud_brick_slab, 1, 0);
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
        return Item.getItemFromBlock(ModBlocks.dry_mud_brick_slab);
    }
}
