package darkbum.saltymod.dispenser;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Custom dispenser behavior for shovels.
 * Automatically supports all items extending ItemSpade.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class DispenserBehaviorShovel implements IBehaviorDispenseItem {

    private final Map<Item, IBehaviorDispenseItem> defaultBehaviors =
        new IdentityHashMap<>();

    /**
     * Registers a shovel and stores its original dispenser behavior.
     *
     * @param item The shovel item to register.
     */
    public void register(Item item) {
        if (!(item instanceof ItemSpade)) {
            return;
        }

        IBehaviorDispenseItem behavior = (IBehaviorDispenseItem) BlockDispenser.dispenseBehaviorRegistry.getObject(item);

        if (behavior == this) {
            return;
        }

        if (behavior == null) {
            behavior = new BehaviorDefaultDispenseItem();
        }

        defaultBehaviors.put(item, behavior);
        BlockDispenser.dispenseBehaviorRegistry.putObject(item, this);
    }

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing facing = BlockDispenser.func_149937_b(source.getBlockMetadata());

        int x = source.getXInt() + facing.getFrontOffsetX();
        int y = source.getYInt() + facing.getFrontOffsetY();
        int z = source.getZInt() + facing.getFrontOffsetZ();

        if (world.getBlock(x, y, z) != ModBlocks.lit_stove) {
            return defaultDispense(source, stack);
        }

        int meta = world.getBlockMetadata(x, y, z);

        if (!world.isRemote) {
            world.setBlock(x, y, z, ModBlocks.stove, meta, 3);

            world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);

            stack.setItemDamage(stack.getItemDamage() + 1);

            if (stack.getItemDamage() >= stack.getMaxDamage()) {
                stack.stackSize--;
            }
        }

        return stack;
    }

    /**
     * Executes the original dispenser behavior of the shovel.
     *
     * @param source The source block of the dispenser.
     * @param stack  The item stack being dispensed.
     * @return The updated item stack.
     */
    private ItemStack defaultDispense(IBlockSource source, ItemStack stack) {
        IBehaviorDispenseItem behavior = defaultBehaviors.get(stack.getItem());

        if (behavior == null) {
            behavior = new BehaviorDefaultDispenseItem();
        }

        return behavior.dispense(source, stack);
    }
}
