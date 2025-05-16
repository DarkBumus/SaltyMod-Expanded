package darkbum.saltymod.block;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the onions block.
 * The onions are a regular crop block.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockOnions extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockOnions(String name, CreativeTabs tab) {
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        setBlockTextureName("saltymod:onions");
        propertiesSaltPlantsAll(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.icons = new IIcon[4];
        for (int i = 0; i < this.icons.length; i++) this.icons[i] = icon.registerIcon(getTextureName() + "_stage_" + i);
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
        if (meta < 7) {
            if (meta == 6) meta = 5;
            return this.icons[meta >> 1];
        }
        return this.icons[3];
    }

    /**
     * Returns the crop item that is harvested from this plant.
     * This is typically the same as the seed, unless differentiated.
     *
     * @return the item dropped on harvest.
     */
    @Override
    protected Item func_149865_P() {    //getCrop()
        return ModItems.onion;
    }

    /**
     * Returns the seed item for this crop.
     * This determines what item is required to plant the crop.
     *
     * @return the item used to plant onions.
     */
    @Override
    protected Item func_149866_i() {    //getSeed()
        return ModItems.onion;
    }
}
