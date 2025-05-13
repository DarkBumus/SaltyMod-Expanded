package darkbum.saltymod.block;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Block class for the salt crusted log block.
 * The salt crusted log is a regular block that emulates {@link BlockRotatedPillar} without actually extending it.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockSaltCrustedLog extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconLTop0;

    @SideOnly(Side.CLIENT)
    private IIcon iconLTop1;

    @SideOnly(Side.CLIENT)
    private IIcon iconLBottom0;

    @SideOnly(Side.CLIENT)
    private IIcon iconLBottom1;

    @SideOnly(Side.CLIENT)
    private IIcon iconLSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconLEnd;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param name  The internal name of the block.
     * @param tab   The creative tab in which the block appears.
     */
    public BlockSaltCrustedLog(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesSaltCrustedLog(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon  The icon register used to load textures.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.iconTop = icon.registerIcon("log_oak_top");
        this.iconBottom = icon.registerIcon("saltymod:oak_log_crusted_bottom");
        this.iconSide = icon.registerIcon("saltymod:oak_log_crusted");
        this.iconLTop0 = icon.registerIcon("log_oak");
        this.iconLTop1 = icon.registerIcon("saltymod:log_oak_1");
        this.iconLBottom0 = icon.registerIcon("saltymod:oak_log_crusted_lying_bottom_0");
        this.iconLBottom1 = icon.registerIcon("saltymod:oak_log_crusted_lying_bottom_1");
        this.iconLSide = icon.registerIcon("saltymod:oak_log_crusted_lying");
        this.iconLEnd = icon.registerIcon("saltymod:oak_log_crusted_lying_end");
    }

    /**
     * Returns the appropriate icon for a given side and metadata value.
     *
     * @param side  The side of the block being rendered.
     * @param meta  The metadata of the block.
     * @return the icon to render.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        IIcon[] icons0 = {iconBottom, iconTop, iconSide, iconSide, iconSide, iconSide};
        IIcon[] icons4 = {iconLBottom1, iconLTop1, iconLSide, iconLSide, iconLEnd, iconLEnd};
        IIcon[] icons8 = {iconLBottom0, iconLTop0, iconLEnd, iconLEnd, iconLSide, iconLSide};

        IIcon[] selectedIcons = switch (meta) {
            case 4 -> icons4;
            case 8 -> icons8;
            default -> icons0;
        };

        return selectedIcons[Math.min(side, 5)];
    }

    /**
     * Determines the metadata for the block when it is placed.
     * This method sets the appropriate metadata based on the side of placement.
     *
     * @param world The world in which the block is placed.
     * @param x The x-coordinate of the block.
     * @param y The y-coordinate of the block.
     * @param z The z-coordinate of the block.
     * @param side The side of the block that is being placed.
     * @param hitX The X coordinate of the hit point on the block.
     * @param hitY The Y coordinate of the hit point on the block.
     * @param hitZ The Z coordinate of the hit point on the block.
     * @param meta The metadata of the block.
     * @return The updated metadata based on the placement side.
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        int j1 = meta & 3;
        byte b0 = switch (side) {
            case 2, 3 -> 8;
            case 4, 5 -> 4;
            default -> 0;
        };

        return j1 | b0;
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player The player interacting with the block.
     * @return true, if the block was successfully stripped, false otherwise.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!Loader.isModLoaded("etfuturum")) return false;

        Block logStripped = GameRegistry.findBlock("etfuturum", "log_stripped");
        if (logStripped == null) return false;

        ItemStack heldItem = player.getHeldItem();
        if (heldItem == null || !(heldItem.getItem() instanceof ItemAxe)) return false;

        int meta = world.getBlockMetadata(x, y, z);
        if (meta != 0 && meta != 4 && meta != 8) return false;

        if (!world.isRemote) {
            world.setBlock(x, y, z, logStripped, meta, 3);
            world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 1.0, z + 0.5, new ItemStack(ModItems.salt_pinch)));
            world.playSoundEffect(x, y, z, "saltymod:item.axe.strip", 1.0F, 1.5F);
            heldItem.damageItem(2, player);
        }

        return true;
    }

    /**
     * Called when the block is broken, including handling secondary drops.
     *
     * @param block     The block that was replaced.
     * @param meta      The metadata of the block.
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (!world.isRemote) {
            ItemStack logDrop = new ItemStack(Blocks.log);
            dropBlockAsItem(world, x, y, z, logDrop);

            ItemStack saltDrop = new ItemStack(ModItems.salt_pinch);
            dropBlockAsItem(world, x, y, z, saltDrop);
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    /**
     * Whether this block can be silk-harvested.
     *
     * @return false, silk touch is not supported.
     */
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }

    /**
     * Returns the item dropped when the block is broken.
     *
     * @param meta      The metadata of the block.
     * @param random    Random number generator.
     * @param fortune   The fortune level of the player's tool.
     * @return null, as special drops are handled by breakBlock().
     */
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return null;
    }
}
