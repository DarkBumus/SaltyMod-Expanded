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
     * @param type The type of bee burrow.
     */
    public BlockBeeBurrowStripped(String name, CreativeTabs tab, BeeBurrowType type) {
        super(name, tab, type);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        if (type == BeeBurrowType.SPRUCE) {
            this.iconTop = icon.registerIcon("saltymod:bee_burrow_spruce_stripped_top");
            this.iconSide = icon.registerIcon("saltymod:bee_burrow_spruce_stripped_side");
            this.iconBurrow = icon.registerIcon("saltymod:bee_burrow_spruce_stripped");
        } else {
            this.iconTop = icon.registerIcon("saltymod:bee_burrow_birch_stripped_top");
            this.iconSide = icon.registerIcon("saltymod:bee_burrow_birch_stripped_side");
            this.iconBurrow = icon.registerIcon("saltymod:bee_burrow_birch_stripped");
        }
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
