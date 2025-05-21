package darkbum.saltymod.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Block class for the stripped bee burrow block.
 * The stripped bee burrow is a copy of the regular bee burrow, but with the right-click functionality removed.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockBeeBurrowStripped extends BlockBeeBurrow {

    /**
     * Constructs a new block instance with a given name, a creative tab and a type.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockBeeBurrowStripped(String name, CreativeTabs tab) {
        super(name, tab);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
            this.iconTopSpruce = icon.registerIcon("saltymod:bee_burrow_spruce_stripped_top");
            this.iconSideSpruce = icon.registerIcon("saltymod:bee_burrow_spruce_stripped_side");
            this.iconBurrowSpruce = icon.registerIcon("saltymod:bee_burrow_spruce_stripped");
            this.iconTopBirch = icon.registerIcon("saltymod:bee_burrow_birch_stripped_top");
            this.iconSideBirch = icon.registerIcon("saltymod:bee_burrow_birch_stripped_side");
            this.iconBurrowBirch = icon.registerIcon("saltymod:bee_burrow_birch_stripped");
    }

    /**
     * Handles right-click interaction with the block.
     * Since this block extends the regular burrow, it's necessary to block the functionality.
     *
     * @param player The player interacting with the block.
     * @param side   The side the block is interacted with.
     * @param hitX   The x-coordinate of the hit location on the block.
     * @param hitY   The y-coordinate of the hit location on the block.
     * @param hitZ   The z-coordinate of the hit location on the block.
     * @return true, if the block was successfully stripped, false otherwise.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return false;
    }
}
