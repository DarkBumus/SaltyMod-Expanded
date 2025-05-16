package darkbum.saltymod.block;

import java.util.List;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.config.ModConfigurationItems;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the storage crate block.
 * The storage crate is a regular block with different variations.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockStorageCrate extends Block {

    public static final String[] types = new String[] {"carrot", "potato", "poisonous_potato", "onion", "beetroot"};

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconCarrotSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconCarrotTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconPotatoSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconPotatoTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconPoisonousPotatoSide;

    @SideOnly(Side.CLIENT)
    private IIcon getIconPoisonousPotatoTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconOnionSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconOnionTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBeetrootSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconBeetrootTop;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockStorageCrate(String name, CreativeTabs tab) {
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
        this.iconBottom = icon.registerIcon("saltymod:storage_crate_bottom");
        this.iconCarrotSide = icon.registerIcon("saltymod:storage_crate_carrot_side");
        this.iconCarrotTop = icon.registerIcon("saltymod:storage_crate_carrot_top");
        this.iconPotatoSide = icon.registerIcon("saltymod:storage_crate_potato_side");
        this.iconPotatoTop = icon.registerIcon("saltymod:storage_crate_potato_top");
        this.iconPoisonousPotatoSide = icon.registerIcon("saltymod:storage_crate_poisonous_potato_side");
        this.getIconPoisonousPotatoTop = icon.registerIcon("saltymod:storage_crate_poisonous_potato_top");
        this.iconOnionSide = icon.registerIcon("saltymod:storage_crate_onion_side");
        this.iconOnionTop = icon.registerIcon("saltymod:storage_crate_onion_top");
        this.iconBeetrootSide = icon.registerIcon("saltymod:storage_crate_beetroot_side");
        this.iconBeetrootTop = icon.registerIcon("saltymod:storage_crate_beetroot_top");
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
        IIcon[] icons = {iconBottom, iconCarrotSide, iconCarrotTop, iconPotatoSide, iconPotatoTop, iconPoisonousPotatoSide, getIconPoisonousPotatoTop, iconOnionSide, iconOnionTop, iconBeetrootSide, iconBeetrootTop};
        if (side > 0) {
            return switch (meta) {
                case 0 -> side == 1 ? icons[2] : icons[1];
                case 1 -> side == 1 ? icons[4] : icons[3];
                case 2 -> side == 1 ? icons[6] : icons[5];
                case 3 -> side == 1 ? icons[8] : icons[7];
                case 4 -> side == 1 ? icons[10] : icons[9];
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
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
        for (int i = 0; i < 5; ++i) {
            if (i == 3 && !ModConfigurationItems.enableOnion) continue;
            if (i == 4 && !Loader.isModLoaded("etfuturum")) continue;
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
