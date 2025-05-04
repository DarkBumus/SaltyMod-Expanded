package darkbum.saltymod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Block class for the grass top block.
 * The bee burrow is a helper block that is used for rendering salt grass.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockGrassTop extends Block {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockGrassTop(String name, CreativeTabs tab) {
        super(Material.grass);
        setBlockName(name);
        setCreativeTab(tab);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("minecraft:grass_top");
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
        return (side > 1) ? BlockGrass.getIconSideOverlay() : this.blockIcon;
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
     * Determines whether a particular side of the block should be rendered.
     * Only non-bottom sides (side > 0) will be rendered if the superclass allows it.
     *
     * @param blockAccess   The block access used to check adjacent blocks.
     * @param x             The x-coordinate of the block face being queried.
     * @param y             The y-coordinate of the block face being queried.
     * @param z             The z-coordinate of the block face being queried.
     * @param side          The side to be checked for rendering.
     * @return true if the side should be rendered, false otherwise.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return (side > 0 && super.shouldSideBeRendered(blockAccess, x, y, z, side));
    }

    /**
     * Returns the base block color used when rendering the block in inventory or default context.
     * This implementation uses the grass colorizer with fixed temperature/humidity values.
     *
     * @return the RGB color value for the block (in 0xRRGGBB format).
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        double temperature = 0.5D;
        double humidity = 1.0D;
        return ColorizerGrass.getGrassColor(temperature, humidity);
    }

    /**
     * Returns the render color for a specific block metadata value.
     *
     * @return the RGB color value for the block (in 0xRRGGBB format).
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int meta) {
        return getBlockColor();
    }

    /**
     * Multiplies the block's color based on the surrounding biome's grass colors.
     * This creates smoother color transitions by averaging the colors of a 3x3 biome area.
     *
     * @param world The world the block is in.
     * @param x     The x-coordinate of the block.
     * @param y     The y-coordinate of the block.
     * @param z     The z-coordinate of the block.
     * @return the averaged RGB color value (in 0xRRGGBB format).
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        for (int offsetZ = -1; offsetZ <= 1; offsetZ++) {
            for (int offsetX = -1; offsetX <= 1; offsetX++) {
                int color = world.getBiomeGenForCoords(x + offsetX, z + offsetZ).getBiomeGrassColor(x + offsetX, y, z + offsetZ);
                redSum += (color & 0xFF0000) >> 16;
                greenSum += (color & 0xFF00) >> 8;
                blueSum += color & 0xFF;
            }
        }
        return (redSum / 9 & 0xFF) << 16 | (greenSum / 9 & 0xFF) << 8 | blueSum / 9 & 0xFF;
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
        return null;
    }


}
