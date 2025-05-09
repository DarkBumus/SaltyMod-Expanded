package darkbum.saltymod.block;

import java.util.List;
import java.util.Random;

import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import static darkbum.saltymod.util.BlockHelper.*;

/**
 * Block class for the salt block.
 * The salt block is a regular block with different variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltBlock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconPillar;

    @SideOnly(Side.CLIENT)
    private IIcon iconPillarTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconChiseled;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrick;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconBlockCracked;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickCracked;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickCrackedTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickCrackedBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickChiseled;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickChiseledTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconBrickChiseledBottom;

    @SideOnly(Side.CLIENT)
    private IIcon iconChapiterUp;

    @SideOnly(Side.CLIENT)
    private IIcon iconChapiterDown;

    @SideOnly(Side.CLIENT)
    private IIcon iconChapiterTop;

    public static boolean crystal = true;

    /**
     * Constructs a new block instance with a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param tab The creative tab in which the block appears.
     */
    public BlockSaltBlock(CreativeTabs tab) {
        super(Material.rock);
        setTickRandomly(true);
        setCreativeTab(tab);
        propertiesSaltBlock(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("saltymod:salt_block");
        this.iconChiseled = icon.registerIcon("saltymod:chiseled_salt_block");
        this.iconPillar = icon.registerIcon("saltymod:salt_pillar");
        this.iconPillarTop = icon.registerIcon("saltymod:salt_pillar_top");
        this.iconBrick = icon.registerIcon("saltymod:salt_bricks");
        this.iconBrickTop = icon.registerIcon("saltymod:salt_bricks_top");
        this.iconBrickBottom = icon.registerIcon("saltymod:salt_bricks_bottom");
        this.iconBlockCracked = icon.registerIcon("saltymod:cracked_salt_block");
        this.iconBrickCracked = icon.registerIcon("saltymod:cracked_salt_bricks");
        this.iconBrickCrackedTop = icon.registerIcon("saltymod:cracked_salt_bricks_top");
        this.iconBrickCrackedBottom = icon.registerIcon("saltymod:cracked_salt_bricks_bottom");
        this.iconBrickChiseled = icon.registerIcon("saltymod:chiseled_salt_bricks");
        this.iconBrickChiseledTop = icon.registerIcon("saltymod:chiseled_salt_bricks_top");
        this.iconBrickChiseledBottom = icon.registerIcon("saltymod:chiseled_salt_bricks_bottom");
        this.iconChapiterUp = icon.registerIcon("saltymod:salt_chapiter_up");
        this.iconChapiterDown = icon.registerIcon("saltymod:salt_chapiter_down");
        this.iconChapiterTop = icon.registerIcon("saltymod:salt_chapiter_top");
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
        return switch (meta) {
            case 1 -> this.iconChiseled;
            case 2 -> side < 2 ? this.iconPillarTop : this.iconPillar;
            case 3 -> side > 3 ? this.iconPillarTop : this.iconPillar;
            case 4 -> (side == 2 || side == 3) ? this.iconPillarTop : this.iconPillar;
            case 5 -> side == 1 ? this.iconBrickTop : (side == 0 ? this.iconBrickBottom : this.iconBrick);
            case 6 -> this.iconBlockCracked;
            case 7 ->
                side == 1 ? this.iconBrickCrackedTop : (side == 0 ? this.iconBrickCrackedBottom : this.iconBrickCracked);
            case 8 ->
                side == 1 ? this.iconBrickChiseledTop : (side == 0 ? this.iconBrickChiseledBottom : this.iconBrickChiseled);
            case 9 -> side == 1 ? this.iconChapiterTop : (side == 0 ? this.iconPillarTop : this.iconChapiterUp);
            case 10 -> side == 1 ? this.iconPillarTop : (side == 0 ? this.iconChapiterTop : this.iconChapiterDown);
            default -> this.blockIcon;
        };
    }

    /**
     * Gets the render type for this block.
     *
     * @return a custom render type ID, provided by the client proxy.
     */
    @Override
    public int getRenderType() {
        return 39;
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
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 5));
        list.add(new ItemStack(item, 1, 6));
        list.add(new ItemStack(item, 1, 7));
        list.add(new ItemStack(item, 1, 8));
        list.add(new ItemStack(item, 1, 9));
    }

    /**
     * Creates the stacked block item for the given metadata.
     * This method defines the item stack that is returned when this block is stacked in the inventory.
     *
     * @param meta The metadata of the block.
     * @return The item stack for the stacked block.
     */
    @Override
    protected ItemStack createStackedBlock(int meta) {
        return switch (meta) {
            case 3, 4 -> new ItemStack(Item.getItemFromBlock(this), 1, 2);
            case 10 -> new ItemStack(Item.getItemFromBlock(this), 1, 9);
            default -> super.createStackedBlock(meta);
        };
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
        if (meta == 2) {
            meta = switch (side) {
                case 0, 1 -> 2;
                case 2, 3 -> 4;
                case 4, 5 -> 3;
                default -> meta;
            };
        }
        if (meta == 9) {
            meta = switch (side) {
                case 0 -> 9;
                case 1 -> 10;
                default -> meta;
            };
        }
        return meta;
    }

    /**
     * Returns the metadata for the block that is dropped when this block is destroyed.
     * This method is used to specify which variant of the block is dropped based on its metadata.
     *
     * @param meta The metadata of the block.
     * @return The metadata of the dropped item.
     */
    @Override
    public int damageDropped(int meta) {
        return switch (meta) {
            case 3, 4 -> 2;
            case 10 -> 9;
            default -> meta;
        };
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
    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        handleEntityWalkingSaltVulnerableUpdate(world, x, y, z, entity, this);
    }
}
