package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;

/**
 * Block class for the bee burrow block.
 * The bee burrow is a regular block with two types, which produce special drops when destroyed.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockBeeBurrow extends Block {

    @SideOnly(Side.CLIENT)
    IIcon iconTop;

    @SideOnly(Side.CLIENT)
    IIcon iconSide;

    @SideOnly(Side.CLIENT)
    IIcon iconBurrow;

    /**
     * Enum to differentiate between the types of bee burrows.
     */
    public enum BeeBurrowType {
        SPRUCE, BIRCH
    }

    final BeeBurrowType type;

    /**
     * Constructs a new block instance with a given name, a creative tab and a type.
     * <p>
     * Also assigns a material and other base properties through {@link BlockHelper}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     * @param type The type of bee burrow.
     */
    public BlockBeeBurrow(String name, CreativeTabs tab, BeeBurrowType type) {
        super(Material.wood);
        this.type = type;
        setBlockName(name);
        setCreativeTab(tab);
        BlockHelper.propertiesBeeNest(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        if (type == BeeBurrowType.SPRUCE) {
            this.iconTop = icon.registerIcon("saltymod:bee_burrow_spruce_top");
            this.iconSide = icon.registerIcon("log_spruce");
            this.iconBurrow = icon.registerIcon("saltymod:bee_burrow_spruce");
        } else {
            this.iconTop = icon.registerIcon("saltymod:bee_burrow_birch_top");
            this.iconSide = icon.registerIcon("log_birch");
            this.iconBurrow = icon.registerIcon("saltymod:bee_burrow_birch");
        }
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
        IIcon[] icons = {iconTop, iconTop, iconSide, iconSide, iconBurrow, iconSide};
        int facing = meta % 4;
        return switch (facing) {
            case 0 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 3 ? 4 : 2))];
            case 1 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 4 ? 4 : 2))];
            case 2 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 2 ? 4 : 2))];
            case 3 -> icons[side == 0 ? 0 : (side == 1 ? 1 : (side == 5 ? 4 : 2))];
            default -> null;
        };
    }

    /**
     * Called when the block is placed by an entity.
     * Sets metadata based on player's rotation and block type.
     *
     * @param world  The world the block is in.
     * @param x      The x-coordinate of the block.
     * @param y      The y-coordinate of the block.
     * @param z      The z-coordinate of the block.
     * @param entity The entity placing the block.
     * @param stack  The item used to place the block.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int directionMeta = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int baseMeta = (type == BeeBurrowType.BIRCH) ? 4 : 0;
        world.setBlockMetadataWithNotify(x, y, z, baseMeta + directionMeta, 2);
    }

    /**
     * Handles right-click interaction with the block.
     *
     * @param player The player interacting with the block.
     * @param side   The side the block is interacted with.
     * @param hitX   The x-coordinate of the hit location on the block.
     * @param hitY   The y-coordinate of the hit location on the block.
     * @param hitZ   The z-coordinate of the hit location on the block.
     * @return true, if the block was successfully stripped, false otherwise.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        return heldItem != null && tryStripBlock(world, x, y, z, player, heldItem);
    }

    /**
     * Attempts to strip the block if the player is holding an axe and Et Futurum Requiem is loaded.
     * <p>
     * The block will be replaced with a stripped version, and the player will receive the "Swarmed" effect.
     *
     * @param heldItem The item the player is holding.
     * @return true if the block was successfully stripped, false otherwise.
     */
    private boolean tryStripBlock(World world, int x, int y, int z, EntityPlayer player, ItemStack heldItem) {
        if (!Loader.isModLoaded("etfuturum") || !(heldItem.getItem() instanceof ItemAxe)) return false;
        if (world.isRemote) return true;
        int meta = world.getBlockMetadata(x, y, z);
        Block replacement = (type == BeeBurrowType.SPRUCE)
            ? ModBlocks.bee_burrow_spruce_stripped
            : (type == BeeBurrowType.BIRCH)
            ? ModBlocks.bee_burrow_birch_stripped
            : null;

        if (replacement != null) {
            world.setBlock(x, y, z, replacement, meta, 3);

            if (!player.capabilities.isCreativeMode) {
                heldItem.damageItem(1, player);
                BlockHelper.applySwarmedEffect(world, player, x, y, z, 600);
            }
            return true;
        }
        return false;
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
     * Called when the block is harvested by the player.
     * If the player is not in creative mode, it applies the "Swarmed" effect to the player when the block is harvested.
     */
    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            BlockHelper.applySwarmedEffect(world, player, x, y, z, 900);
        }
    }

    /**
     * Determines the drops when the block is harvested. The drops are dependent on the block's type.
     * <p>
     * This block will always drop a bee for the specific burrow type, aswell as having a 30% chance
     * to drop 1-3 combs of the appropriate type.
     *
     * @param fortune The fortune level of the player's tool.
     * @return a list of item stacks representing the items dropped by the block.
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        Random random = new Random();

        BeeBurrowType actualType = (meta >= 4) ? BeeBurrowType.BIRCH : BeeBurrowType.SPRUCE;    // 4+ means birch
        ItemStack bee = (actualType == BeeBurrowType.SPRUCE) ? new ItemStack(ModItems.carpenter_bee) : new ItemStack(ModItems.regal_bee);
        ItemStack comb = (actualType == BeeBurrowType.SPRUCE) ? new ItemStack(ModItems.waxcomb) : new ItemStack(ModItems.honeycomb);
        drops.add(bee);

        if (random.nextFloat() < 0.3f) {
            int count = random.nextInt(3) + 1;  // 1-3 combs
            ItemStack stack = comb.copy();
            stack.stackSize = count;
            drops.add(stack);
        }
        return drops;
    }

    /**
     * Whether this block can sustain leaves.
     *
     * @return true when it can sustain leaves.
     */
    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }
}
