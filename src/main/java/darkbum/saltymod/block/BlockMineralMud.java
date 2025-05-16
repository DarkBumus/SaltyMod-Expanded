package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the mill block.
 * The mill is a regular block with no real function on its own, that can be powered to provide auxiliary properties to the press.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockMineralMud extends Block {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockMineralMud(String name, CreativeTabs tab) {
        super(Material.ground);
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltymod:mineral_mud");
        propertiesMineralMud(this);
    }

    /**
     * Gets the collision bounding box for this block.
     *
     * @return the collision bounding box.
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), ((y + 1) - f), (z + 1));
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    @Override
    public MapColor getMapColor(int meta) {
        return MapColor.grayColor;
    }

    /**
     * Returns the item dropped when this block is broken.
     * Returns null so that nothing is dropped directly.
     *
     * @param random    Random number generator.
     * @param fortune The fortune level of the player's tool.
     * @return null, indicating no item drop.
     */
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.mineral_mud_ball;
    }

    /**
     * Returns the quantity of items dropped when the block is broken.
     *
     * @return always 4.
     */
    @Override
    public int quantityDropped(Random random) {
        return 4;
    }

    /**
     * Whether this block can support a given plant.
     *
     * @param world         The block access object.
     * @param x             The x-coordinate of the block.
     * @param y             The y-coordinate of the block.
     * @param z             The z-coordinate of the block.
     * @param direction     The planting direction.
     * @param plantable     The plant to check.
     * @return true, if the plant can be sustained, false otherwise.
     */
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        return plant != Blocks.cactus;
    }
}
