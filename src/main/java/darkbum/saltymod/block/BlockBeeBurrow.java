package darkbum.saltymod.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Loader;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtils.*;

/**
 * Block class for the bee burrow block.
 * The bee burrow is a regular block with two types, which produce special drops when destroyed.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class BlockBeeBurrow extends Block {

    @SideOnly(Side.CLIENT)
    IIcon iconTopSpruce;

    @SideOnly(Side.CLIENT)
    IIcon iconSideSpruce;

    @SideOnly(Side.CLIENT)
    IIcon iconBurrowSpruce;

    @SideOnly(Side.CLIENT)
    IIcon iconTopBirch;

    @SideOnly(Side.CLIENT)
    IIcon iconSideBirch;

    @SideOnly(Side.CLIENT)
    IIcon iconBurrowBirch;

    /**
     * Constructs a new block instance with a given name, a creative tab and a type.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtils}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockBeeBurrow(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        propertiesBeeNest(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        iconTopSpruce = icon.registerIcon("saltymod:bee_burrow_spruce_top");
        iconSideSpruce = icon.registerIcon("log_spruce");
        iconBurrowSpruce = icon.registerIcon("saltymod:bee_burrow_spruce");
        iconTopBirch = icon.registerIcon("saltymod:bee_burrow_birch_top");
        iconSideBirch = icon.registerIcon("log_birch");
        iconBurrowBirch = icon.registerIcon("saltymod:bee_burrow_birch");
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
        int facing = meta % 4;
        boolean isBirch = meta >= 4;

        IIcon top = isBirch ? iconTopBirch : iconTopSpruce;
        IIcon sideIcon = isBirch ? iconSideBirch : iconSideSpruce;
        IIcon burrow = isBirch ? iconBurrowBirch : iconBurrowSpruce;

        if (side == 0 || side == 1) return top;

        return switch (facing) {
            case 0 -> (side == 3) ? burrow : sideIcon;
            case 1 -> (side == 4) ? burrow : sideIcon;
            case 2 -> (side == 2) ? burrow : sideIcon;
            case 3 -> (side == 5) ? burrow : sideIcon;
            default -> sideIcon;
        };
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
        list.add(new ItemStack(item, 1, 4));
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
    @SideOnly(Side.CLIENT)
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        int meta = world.getBlockMetadata(x, y, z);
        int baseMeta = (meta >= 4) ? 4 : 0;
        return new ItemStack(this, 1, baseMeta);
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
        int baseMeta = (stack.getItemDamage() >= 4) ? 4 : 0;
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
        Block replacement = ModBlocks.bee_burrow_stripped;

        if (replacement != null) {
            world.setBlock(x, y, z, replacement, meta, 3);
            if (!player.capabilities.isCreativeMode) {
                heldItem.damageItem(1, player);
                BlockUtils.applySwarmedEffect(world, player, x, y, z, 600);
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
            BlockUtils.applySwarmedEffect(world, player, x, y, z, 900);
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
        boolean isBirch = meta >= 4;

        ItemStack bee = isBirch ? new ItemStack(ModItems.regal_bee) : new ItemStack(ModItems.carpenter_bee);
        ItemStack comb = isBirch ? new ItemStack(ModItems.honeycomb) : new ItemStack(ModItems.waxcomb);

        drops.add(bee);
        if (random.nextFloat() < 0.3f) {
            comb.stackSize = random.nextInt(3) + 1;
            drops.add(comb);
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
