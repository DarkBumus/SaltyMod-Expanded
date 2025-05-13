package darkbum.saltymod.block;

import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Block class for the dry mud brick stairs block.
 * The dry mud brick stairs is a regular stairs block.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockDryMudBrickStairs extends BlockStairs {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockDryMudBrickStairs(String name, CreativeTabs tab) {
        super(ModBlocks.dry_mud_brick, 5);
        setBlockName(name);
        setCreativeTab(tab);
        setBlockTextureName("saltymod:mud_bricks");
        this.useNeighborBrightness = true;
        propertiesDryMudBrick(this);
    }
}
