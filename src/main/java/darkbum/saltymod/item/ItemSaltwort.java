package darkbum.saltymod.item;

import darkbum.saltymod.block.BlockSaltworts;
import darkbum.saltymod.util.ItemSaltFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.NetworkRegistry;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.network.SaltwortMessage;

import static darkbum.saltymod.init.ModBlocks.*;
import static darkbum.saltymod.util.ItemUtils.*;

/**
 * Item class for the saltwort item.
 * The saltwort is a salt food item with a that can also plant the {@link BlockSaltworts}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemSaltwort extends ItemSaltFood {

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param baseName The base name of the item.
     * @param tab The creative tab to display this item in.
     */
    public ItemSaltwort(String baseName, CreativeTabs tab) {
        super(baseName);
        setCreativeTab(tab);
        variantsSaltwort(this);
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
        if (saltworts.canBlockStay(world, x, y + 1, z) && side == 1 && world.isAirBlock(x, y + 1, z)) {
            world.setBlock(x, y + 1, z, saltworts);
            world.playSoundEffect(x + 0.5D, y + 1.0D, z + 0.5D, saltworts.stepSound.getBreakSound(), 1.0F, 0.8F);
            stack.stackSize--;
            return true;
        }
        if (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityFlowerPot tileEntityFlowerPot) {
            if (tileEntityFlowerPot.getFlowerPotItem() == null) {
                if (!world.isRemote) {
                    int i = world.rand.nextInt(2);
                    tileEntityFlowerPot.func_145964_a(Item.getItemFromBlock(saltworts), i);
                    CommonProxy.network.sendToAllAround(new SaltwortMessage(x, y, z, i), new NetworkRegistry.TargetPoint(world.provider.dimensionId, x, y, z, 256.0D));
                    tileEntityFlowerPot.markDirty();
                    world.markBlockForUpdate(x, y, z);
                }
                stack.stackSize--;
                return true;
            }
            return false;
        }
        return false;
    }
}
