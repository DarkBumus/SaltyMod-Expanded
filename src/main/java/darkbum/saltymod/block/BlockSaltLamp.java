package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;


import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the salt grass block.
 * The salt grass is a regular block with multiple variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltLamp extends Block {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltLamp(String name, CreativeTabs tab) {
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltymod:salt_lamp");
        setTickRandomly(true);
        propertiesSaltLamp(this);
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
    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        BlockHelper.handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
    }
}
