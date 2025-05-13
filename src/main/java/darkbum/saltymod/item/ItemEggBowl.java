package darkbum.saltymod.item;

import darkbum.saltymod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Item class for the egg bowl item.
 * The egg bowl is an item with a right-click function.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemEggBowl extends Item {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemEggBowl(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    /**
     * Called when the player right-clicks with this item.
     *
     * @param stack  The ItemStack being right-clicked.
     * @param world  The world in which the action occurs.
     * @param player The player using the item.
     * @return the modified ItemStack after the action.
     */
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            ItemStack saltEggStack = new ItemStack(ModItems.salt_egg, 4);
            ItemStack bowlStack = new ItemStack(Items.bowl, 1);
            float pitch = 0.9F + (world.rand.nextFloat() * 0.2F);

            if (!player.inventory.addItemStackToInventory(saltEggStack)) {
                world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, saltEggStack));
            } else {
                world.playSoundAtEntity(player, "random.pop", 0.1F, pitch);
            }

            if (!player.inventory.addItemStackToInventory(bowlStack)) {
                world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, bowlStack));
            } else {
                world.playSoundAtEntity(player, "random.pop", 0.1F, pitch);
            }
            stack.stackSize--;
        }
        return stack;
    }
}
