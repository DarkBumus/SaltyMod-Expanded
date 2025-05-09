package darkbum.saltymod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the stove block.
 * The stove is a regular block with different variations.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockStove extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name  The internal name of the block.
     * @param tab   The creative tab in which the block appears.
     */
    public BlockStove(String name, CreativeTabs tab) {
        super(Material.rock);
        setTickRandomly(false);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesStove(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconTop = icon.registerIcon("saltymod:stove_top");
        this.iconBottom = icon.registerIcon("saltymod:stove_bottom");
        this.iconSide = icon.registerIcon("saltymod:stove_side");
        this.iconFront = icon.registerIcon("saltymod:stove_front");
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
        IIcon[] icons = {iconBottom, iconTop, iconSide, iconFront};

        return switch (meta) {
            case 0 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 3 -> icons[3];
                default -> icons[2];
            };
            case 1 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 4 -> icons[3];
                default -> icons[2];
            };
            case 2 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 2 -> icons[3];
                default -> icons[2];
            };
            case 3 -> switch (side) {
                case 0 -> icons[0];
                case 1 -> icons[1];
                case 5 -> icons[3];
                default -> icons[2];
            };
            default -> null;
        };
    }

    /**
     * Called when the block is placed by an entity.
     * Sets metadata based on player's rotation.
     *
     * @param entity The entity placing the block.
     * @param stack  The item used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        setBlockDirectionFromEntity(world, x, y, z, entity);
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player    The player interacting with the block.
     * @param side      The side the block is interacted with.
     * @param hitX      The x-coordinate of the hit location on the block.
     * @param hitY      The y-coordinate of the hit location on the block.
     * @param hitZ      The z-coordinate of the hit location on the block.
     * @return true, if a GUI was opened, false otherwise
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        return heldItem != null && igniteBlock(world, x, y, z, player, heldItem);
    }
}
