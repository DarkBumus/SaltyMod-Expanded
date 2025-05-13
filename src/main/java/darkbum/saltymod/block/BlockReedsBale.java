package darkbum.saltymod.block;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import ganymedes01.etfuturum.api.HoeRegistry;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Block class for the reeds bale block.
 * The reeds bale is a normal block..
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockReedsBale extends BlockRotatedPillar {

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockReedsBale(String name, CreativeTabs tab) {
        super(Material.grass);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesReedsBale(this);
        if(Loader.isModLoaded("etfuturum")) {
            HoeRegistry.addToHoeArray(this);
        }
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
}
