package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the salt brick stairs.
 * The salt brick stairs is a regular stairs block.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltBrickStairs extends BlockStairs {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltBrickStairs(String name, CreativeTabs tab) {
        super(ModBlocks.salt_block, 5);
        setTickRandomly(true);
        setBlockName(name);
        setCreativeTab(tab);
        this.useNeighborBrightness = true;
        propertiesSaltBlock(this);
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    public MapColor getMapColor(int meta) {
        return MapColor.quartzColor;
    }

    /**
     * Updates the block's state during a tick.
     * This method is called on each tick to update the block's behavior.
     * It checks for nearby entities, tries to grow salt crystals, and attempts to melt ice or snow.
     *
     * @param rand The random number generator for events like crystal growth.
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.isRemote) return;

        checkAndDamageNearbyEntities(world, x, y, z, this);
        tryMeltIceAndSnow(world, x, y, z, rand, this);
    }

    /**
     * Handles the effect when an entity walks on this block.
     * This method is used to apply effects or trigger actions when an entity steps on the block.
     *
     * @param entity The entity that is walking on the block.
     */
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
    }

    /**
     * Handles the effect when an entity collides with this block.
     * This method is used to apply effects or trigger actions when an entity collides with the block.
     *
     * @param entity The entity that is colliding with the block.
     */
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
    }
}
