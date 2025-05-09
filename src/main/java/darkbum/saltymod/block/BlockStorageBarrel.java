package darkbum.saltymod.block;

import java.util.List;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.config.ModConfigurationItems;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the storage barrel block.
 * The storage barrel is a regular block with different variations.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockStorageBarrel extends Block {

    public static final String[] types = new String[] {"cod", "salmon", "clownfish", "tailor", "pufferfish"};

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconCod;

    @SideOnly(Side.CLIENT)
    private IIcon iconSalmon;

    @SideOnly(Side.CLIENT)
    private IIcon iconClownfish;

    @SideOnly(Side.CLIENT)
    private IIcon iconTailor;

    @SideOnly(Side.CLIENT)
    private IIcon iconPufferfish;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockStorageBarrel(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesStorageBarrelStorageCrate(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        iconBottom = icon.registerIcon("saltymod:storage_barrel_bottom");
        iconSide = icon.registerIcon("saltymod:storage_barrel");
        iconCod = icon.registerIcon("saltymod:storage_barrel_cod");
        iconSalmon = icon.registerIcon("saltymod:storage_barrel_salmon");
        iconClownfish = icon.registerIcon("saltymod:storage_barrel_clownfish");
        iconTailor = icon.registerIcon("saltymod:storage_barrel_tailor");
        iconPufferfish = icon.registerIcon("saltymod:storage_barrel_pufferfish");
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
        IIcon[] icons = {iconBottom, iconSide, iconCod, iconSalmon, iconClownfish, iconTailor, iconPufferfish};

        if (side > 0) {
            return switch (meta) {
                case 0 -> side == 1 ? icons[2] : icons[1];
                case 1 -> side == 1 ? icons[3] : icons[1];
                case 2 -> side == 1 ? icons[4] : icons[1];
                case 3 -> side == 1 ? icons[5] : icons[1];
                case 4 -> side == 1 ? icons[6] : icons[1];
                default -> icons[0];
            };
        }
        return icons[0];
    }

    /**
     * Adds the available sub-blocks of this item to the creative tab.
     * This method is used to specify the different variations of this item
     * that can be displayed in the creative inventory.
     *
     * @param item The item to add sub-blocks for.
     * @param tabs The creative tab where the item is being displayed.
     * @param list The list of item stacks to add the sub-blocks to.
     */
    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
        for (int i = 0; i < types.length; ++i) {
            if (i == 3 && !ModConfigurationItems.enableTailor) continue;
            list.add(new ItemStack(item, 1, i));
        }
    }

    /**
     * Returns the damage (meta value) associated with the block when it is dropped.
     *
     * @return the meta value that is dropped when the block is destroyed.
     */
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
