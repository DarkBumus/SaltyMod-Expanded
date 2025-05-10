package darkbum.saltymod.block.itemblock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.block.BlockCookingPot;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

/**
 * ItemBlock class for {@link BlockCookingPot}.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemBlockCookingPot extends ItemBlock {

    @SideOnly(Side.CLIENT)
    private IIcon iconCookingPot;

    /**
     * Constructs a new itemblock instance with the associated block.
     *
     * @param block The associated block instance.
     */
    public ItemBlockCookingPot(Block block) {
        super(block);
        setHasSubtypes(false);
        setMaxStackSize(1);
    }

    /**
     * Registers the icon for the item.
     * This method is called during initialization to assign the texture to the item.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    public void registerIcons(IIconRegister icon) {
        iconCookingPot = icon.registerIcon("saltymod:cooking_pot");
    }

    /**
     * Returns the icon to be used for rendering based on the item's damage value.
     *
     * @param meta The damage value of the item.
     * @return the icon for the item.
     */
    @Override
    public IIcon getIconFromDamage(int meta) {
        return iconCookingPot;
    }
}
