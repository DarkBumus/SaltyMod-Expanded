package darkbum.saltymod.block;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import static darkbum.saltymod.util.BlockHelper.*;
import static ganymedes01.etfuturum.ModBlocks.*;

/**
 * Block class for the salt deepslate ore block.
 * The salt deepslate ore is a regular block that only gets loaded with Et Futurum Requiem.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltDeepslateOre extends BlockSaltOre {

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    /**
     * Constructs a new block instance with parent ore block.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param block The parent ore this block belongs to.
     */
    public BlockSaltDeepslateOre(Block block, String name, CreativeTabs tab) {
        super(name, tab);
        setBlockName("deepslate_salt_ore");
        setCreativeTab(CommonProxy.tabSaltBlocks);
        propertiesSaltDeepslateOre(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister icon) {
        blockIcon = icon.registerIcon("saltymod:deepslate_salt_ore");
        iconSide = icon.registerIcon("saltymod:deepslate_salt_ore_side");
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
        return (side == 1 && meta > 0) ? deepslate.getBlockTextureFromSide(side)
            : (((side == 2 && meta % 2 == 1) || (side == 5 && meta % 4 >= 2)
            || (side == 3 && meta % 8 >= 4)
            || (side == 4 && meta >= 8)) ? this.iconSide : this.blockIcon);
    }
}
