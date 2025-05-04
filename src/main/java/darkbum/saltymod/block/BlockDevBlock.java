package darkbum.saltymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Block class for the dev block.
 * The dev is a testing block.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockDevBlock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconSide0Bottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide1Top;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide2North;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide3South;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide4West;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide5East;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockDevBlock(String name, CreativeTabs tab) {
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(1.0F);
        setResistance(1.0F);
        setHarvestLevel("pickaxe", 0);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        iconSide0Bottom = icon.registerIcon("saltymod:dev/dev_side0bottom");
        iconSide1Top = icon.registerIcon("saltymod:dev/dev_side1top");
        iconSide2North = icon.registerIcon("saltymod:dev/dev_side2north");
        iconSide3South = icon.registerIcon("saltymod:dev/dev_side3south");
        iconSide4West = icon.registerIcon("saltymod:dev/dev_side4west");
        iconSide5East = icon.registerIcon("saltymod:dev/dev_side5east");
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
        IIcon[] icons = {iconSide0Bottom, iconSide1Top, iconSide2North, iconSide3South, iconSide4West, iconSide5East};

        return switch (side) {
            case 0 -> icons[0];
            case 1 -> icons[1];
            case 2 -> icons[2];
            case 3 -> icons[3];
            case 4 -> icons[4];
            case 5 -> icons[5];
            default -> null;
        };
    }
}
