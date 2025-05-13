package darkbum.saltymod.block;

import java.util.List;
import java.util.Random;

import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Block class for the salt brick slab.
 * The salt brick slab is a regular slab block.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltSlab extends BlockSlab {

    protected boolean crystal = true;

    public static final String[] type = new String[]{"block", "brick", "pillar"};

    @SideOnly(Side.CLIENT)
    private IIcon iconSaltBlock;

    @SideOnly(Side.CLIENT)
    private IIcon iconSaltBlockSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconSaltBrickTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSaltBrickBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconSaltPillar;

    @SideOnly(Side.CLIENT)
    private IIcon iconSaltPillarTop;

    /**
     * Constructs a new block instance with a double slab boolean, a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltSlab(boolean isDouble, String name, CreativeTabs tab) {
        super(isDouble, Material.rock);
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        this.useNeighborBrightness = true;
        propertiesSaltBlock(this);
    }

    /**
     * Returns the unlocalized name for this slab variant.
     * In this case, only one variant exists, so the base name is returned.
     *
     * @param meta      The metadata of the block.
     * @return the unlocalized name of the block.
     */
    @Override
    public String func_150002_b(int meta) {
        if (meta < 0 || meta >= type.length) meta = 0;
        return getUnlocalizedName() + "." + type[meta];
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("saltymod:salt_bricks");
        this.iconSaltBrickTop = icon.registerIcon("saltymod:salt_bricks_top");
        this.iconSaltBrickBottom = icon.registerIcon("saltymod:salt_bricks_bottom");
        this.iconSaltBlock = icon.registerIcon("saltymod:salt_block");
        this.iconSaltBlockSide = icon.registerIcon("saltymod:salt_slab_side");
        this.iconSaltPillar = icon.registerIcon("saltymod:salt_pillar");
        this.iconSaltPillarTop = icon.registerIcon("saltymod:salt_pillar_top");
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
        if (meta < 0 || (meta > 2 && meta < 8) || meta > 10) meta = 0;
        if (meta == 0 || meta == 8) {
            if (side == 0 || side == 1) return this.iconSaltBlock;
            return this.iconSaltBlockSide;
        }
        if (meta == 2 || meta == 10) {
            if (side == 0 || side == 1) return this.iconSaltPillarTop;
            return this.iconSaltPillar;
        }
        if (side == 0) return this.iconSaltBrickBottom;
        if (side == 1) return this.iconSaltBrickTop;
        return this.blockIcon;
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    @Override
    public MapColor getMapColor(int meta) {
        return MapColor.quartzColor;
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
        if (item != Item.getItemFromBlock(ModBlocks.double_salt_slab)) {
            list.add(new ItemStack(item, 1, 0));
            list.add(new ItemStack(item, 1, 1));
            list.add(new ItemStack(item, 1, 2));
        }
    }

    /**
     * Returns the item stack to be picked when the block is targeted in creative mode.
     * Always returns a single slab, even if targeting a double slab.
     *
     * @param target    The targeted block hit result.
     * @param world     The world the block is in.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param player    The player picking the block.
     * @return an item stack of the single dry mud brick slab.
     */
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        int meta = world.getBlockMetadata(x, y, z);
        return (meta >= 0 && meta <= 2) ? new ItemStack(ModBlocks.salt_slab, 1, meta) : null;
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
     * Returns the item dropped when the slab is broken.
     * Always returns the single (half) slab, regardless of whether the block is a double slab.
     *
     * @param meta      The metadata of the block.
     * @param random    Random number generator.
     * @param fortune   The fortune level of the player's tool.
     * @return the item representing the single slab.
     */
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.salt_slab);
    }

    /**
     * Updates the block's state during a tick.
     * This method is called on each tick to update the block's behavior.
     * It checks for nearby entities, tries to grow salt crystals, and attempts to melt ice or snow.
     *
     * @param rand The random number generator for events like crystal growth.
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.isRemote) return;

        checkAndDamageNearbyEntities(world, x, y, z, this);
        tryGrowSaltCrystal(world, x, y, z, rand);
        tryMeltIceAndSnow(world, x, y, z, rand, this);
    }

    /**
     * Handles the effect when an entity walks on this block.
     * This method is used to apply effects or trigger actions when an entity steps on the block.
     *
     * @param entity The entity that is walking on the block.
     */
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
    }

    /**
     * Handles the effect when an entity collides with this block.
     * This method is used to apply effects or trigger actions when an entity collides with the block.
     *
     * @param entity The entity that is colliding with the block.
     */
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
    }
}
