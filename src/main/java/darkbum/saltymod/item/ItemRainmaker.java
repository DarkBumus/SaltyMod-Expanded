package darkbum.saltymod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

import darkbum.saltymod.entity.EntityRainmaker;

import static darkbum.saltymod.util.ItemUtils.*;

/**
 * Item class for the rainmaker item.
 * The rainmaker is a firework-like item with a that spawns the {@link EntityRainmaker}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemRainmaker extends Item {

    public static NBTTagCompound tag = new NBTTagCompound();
    private static final NBTTagCompound TAG_1 = new NBTTagCompound();
    private static final NBTTagList NBT_LIST = new NBTTagList();

    /**
     * Constructs a new item instance with the specified name and creative tab,
     * aswell as a couple of properties related to its firework-like nature.
     *
     * @param name The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemRainmaker(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
        TAG_1.setIntArray("Colors", new int[] { 2651799, 4312372 });
        TAG_1.setIntArray("FadeColors", new int[] { 15790320 });
        TAG_1.setBoolean("Trail", true);
        TAG_1.setByte("Type", (byte) 1);
        NBT_LIST.appendTag(TAG_1);
        tag.setTag("Explosions", NBT_LIST);
    }

    /**
     * Adds additional information to the item tooltip when hovering over the item in the inventory.
     * <p>
     * The tooltip text is retrieved from a localized key.
     * If no translation is found, the tooltip is not displayed.
     *
     * @param stack     The ItemStack for which the information is being added.
     * @param player    The player viewing the tooltip.
     * @param list      The list to which the tooltip lines are added.
     * @param advanced  Whether advanced tooltips are enabled.
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
        addItemTooltip(stack, list);
    }

    /**
     * Called when the player right-clicks a block with this item.
     *
     * @param stack The ItemStack being used.
     * @param player The player using the item.
     * @param world The current world.
     * @param x The X coordinate of the targeted block.
     * @param y The Y coordinate of the targeted block.
     * @param z The Z coordinate of the targeted block.
     * @param side The side of the block that was clicked.
     * @param hitX The exact X coordinate where the block was clicked.
     * @param hitY The exact Y coordinate where the block was clicked.
     * @param hitZ The exact Z coordinate where the block was clicked.
     * @return true, if the action was successful and the item was used, false otherwise.
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            EntityRainmaker entityRainmaker = new EntityRainmaker(world, (x + hitX), (y + hitY), (z + hitZ), player);
            world.spawnEntityInWorld(entityRainmaker);
            if (!player.capabilities.isCreativeMode) stack.stackSize--;
            return true;
        }
        return false;
    }
}
