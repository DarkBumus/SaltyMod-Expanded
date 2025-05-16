package darkbum.saltymod.block;

import java.util.Random;

import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the salt ore block.
 * The salt ore is a regular block with multiple variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltOre extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltOre(String name, CreativeTabs tab) {
        super(Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesSaltOre(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        blockIcon = icon.registerIcon("saltymod:salt_ore");
        iconSide = icon.registerIcon("saltymod:salt_ore_side");
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
        return (side == 1 && meta > 0) ? Blocks.stone.getBlockTextureFromSide(side)
            : (((side == 2 && meta % 2 == 1) || (side == 5 && meta % 4 >= 2)
            || (side == 3 && meta % 8 >= 4)
            || (side == 4 && meta >= 8)) ? this.iconSide : this.blockIcon);
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player The player interacting with the block.
     * @param side   The side the block is interacted with.
     * @param hitX   The x-coordinate of the hit location on the block.
     * @param hitY   The y-coordinate of the hit location on the block.
     * @param hitZ   The z-coordinate of the hit location on the block.
     * @return true, if a GUI was opened, false otherwise
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.capabilities.isCreativeMode && side > 1 && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.salt) {
            int metadata = world.getBlockMetadata(x, y, z);

            switch (side) {
                case 2:
                    metadata += (metadata % 2 < 1) ? 1 : -1;
                    break;
                case 5:
                    metadata += (metadata % 4 < 2) ? 2 : -2;
                    break;
                case 3:
                    metadata += (metadata % 8 < 4) ? 4 : -4;
                    break;
                case 4:
                    metadata += (metadata < 8) ? 8 : -8;
                    break;
            }

            world.setBlock(x, y, z, this, metadata, 3);
            return true;
        }
        return false;
    }

    /**
     * Returns the item dropped by the block when it is broken.
     *
     * @param meta    The metadata of the block.
     * @param random  A random number generator to simulate randomness in the drop.
     * @param fortune The fortune level of the tool used to break the block.
     * @return the item to drop when the block is broken. In this case, it returns ModItems.salt.
     */
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.salt;
    }

    /**
     * Returns the number of items to drop when the block is broken.
     *
     * @return the quantity of items to drop. It will return a random number between 1 and 3.
     */
    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(3);
    }

    /**
     * Returns the number of items to drop when the block is broken, taking into account the fortune level.
     *
     * @return The quantity of items to drop, with potential for extra items based on the fortune level.
     */
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int j = random.nextInt(fortune + 1);
            if (j > 2) return 2;
            return quantityDropped(random) + j;
        }
        return quantityDropped(random);
    }

    /**
     * Returns the amount of experience to drop when the block is broken.
     *
     * @return The amount of experience to drop. In this case, it always returns 1.
     */
    @Override
    public int getExpDrop(IBlockAccess world, int meta, int fortune) {
        return 1;
    }
}
