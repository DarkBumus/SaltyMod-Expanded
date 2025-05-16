package darkbum.saltymod.block;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.BlockHay;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the reeds bale block.
 * The reeds bale is a normal block..
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockReedsBale extends BlockHay {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockReedsBale(String name, CreativeTabs tab) {
        super();
        setBlockName(name);
        setCreativeTab(tab);
        propertiesReedsBale(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.field_150164_N = icon.registerIcon("saltymod:reeds_block_top");
        this.blockIcon = icon.registerIcon("saltymod:reeds_block_side");
    }

    /**
     * Returns the icon for a given side of the block.
     * <p>
     * This method is used to retrieve the icon associated with a specific side of the block.
     *
     * @param sideIndex The index or identifier for the side of the block.
     * @return the icon for the specified side.
     */
    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int sideIndex) {
        return this.blockIcon;
    }

    /**
     * Reduces fall damage by 80% when an entity lands on this block.
     *
     * @param world  The world object.
     * @param x      The x-coordinate of the block.
     * @param y      The y-coordinate of the block.
     * @param z      The z-coordinate of the block.
     * @param entity The entity that landed on the block.
     * @param fallDistance The distance the entity fell.
     */
    @Override
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float fallDistance) {
        if (Loader.isModLoaded("etfuturum")) {
            float reducedFallDistance = fallDistance * 0.225F;
            entity.fallDistance = reducedFallDistance;
            super.onFallenUpon(world, x, y, z, entity, reducedFallDistance);
        }
    }
}
