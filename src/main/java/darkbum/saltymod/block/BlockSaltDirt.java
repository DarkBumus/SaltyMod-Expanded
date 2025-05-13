package darkbum.saltymod.block;

import java.util.*;

import darkbum.saltymod.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtil.*;
import static darkbum.saltymod.block.BlockSaltBlock.*;

/**
 * Block class for the salt dirt block.
 * The salt dirt block is a regular block with multiple variations.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class BlockSaltDirt extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    private long lastMessageTime = -1;

    private static final int COOLDOWN_TICKS = 20;

    /**
     * Constructs a new block instance with a given name and a creative tab.
     * <p>
     * Also assigns a material and other base properties through {@link BlockUtil}.
     *
     * @param name The internal name of the block.
     * @param tab  The creative tab in which the block appears.
     */
    public BlockSaltDirt(String name, CreativeTabs tab) {
        super(Material.ground);
        setBlockName(name);
        setCreativeTab(tab);
        setTickRandomly(true);
        propertiesSaltDirtSaltDirtLite(this);
    }

    /**
     * Registers the textures for the different sides of the block.
     *
     * @param icon The icon register used to load textures.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("saltymod:salt_dirt");
        this.iconTop = icon.registerIcon("saltymod:salt_lake_dirt_top");
        this.iconSide = icon.registerIcon("saltymod:salt_lake_dirt");
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
        IIcon[] icons = {this.blockIcon, this.iconTop, this.iconSide};
        if (meta == 1) {
            return icons[side == 1 ? 1 : (side > 1 ? 2 : 0)];
        }
        return icons[0];
    }

    /**
     * Returns the map color used for this block in maps.
     *
     * @param meta The metadata of the block.
     * @return the map color.
     */
    @Override
    public MapColor getMapColor(int meta) {
        if (meta == 1) return MapColor.quartzColor;
        return MapColor.dirtColor;
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
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 0));
    }

    /**
     * Returns the item stack to be picked when the block is targeted in creative mode.
     * Always returns a single slab, even if targeting a double slab.
     *
     * @param target The targeted block hit result.
     * @param world  The world the block is in.
     * @param x      The x-coordinate of the block.
     * @param y      The y-coordinate of the block.
     * @param z      The z-coordinate of the block.
     * @param player The player picking the block.
     * @return an item stack of the single dry mud brick slab.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        int meta = world.getBlockMetadata(x, y, z);
        return new ItemStack(this, 1, meta);
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) return false;

        int meta = world.getBlockMetadata(x, y, z);
        long currentTick = world.getTotalWorldTime();

        if (meta == 0) {
            ItemStack heldItem = player.getCurrentEquippedItem();
            if (heldItem != null && heldItem.getItem() == ModItems.salt_pinch) {
                if (currentTick - lastMessageTime >= COOLDOWN_TICKS) {
                    player.addChatMessage(new ChatComponentText(I18n.format(getUnlocalizedName() + ".mess")));
                    lastMessageTime = currentTick;
                }
                return true;
            }
        }
        return false;
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
        tryMeltIceAndSnow(world, x, y, z, rand, this);
        crystal = false;
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
        if (entity instanceof EntityPlayer && world.getBlockMetadata(x, y, z) == 1) {
            ((EntityPlayer) entity).addStat(ModAchievementList.nav_salt_lake, 1);
        }
    }
}
