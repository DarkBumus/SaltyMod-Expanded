package darkbum.saltymod.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class DispenserBehaviorBoneMeal implements IBehaviorDispenseItem {

    private IBehaviorDispenseItem defaultBehavior;

    /**
     * Registers the custom bonemeal dispenser behavior.
     */
    public void register() {
        IBehaviorDispenseItem behavior =
            (IBehaviorDispenseItem) BlockDispenser.dispenseBehaviorRegistry
                .getObject(Items.dye);

        if (behavior == this) return;

        if (behavior == null) {
            behavior = new BehaviorDefaultDispenseItem();
        }

        defaultBehavior = behavior;

        BlockDispenser.dispenseBehaviorRegistry.putObject(
            Items.dye,
            this
        );
    }

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();

        if (world.isRemote) return stack;

        // Only intercept bonemeal (dye metadata 15).
        if (stack.getItemDamage() != 15) {
            return defaultDispense(source, stack);
        }

        EnumFacing facing = BlockDispenser.func_149937_b(
            source.getBlockMetadata()
        );

        // Upward-facing dispensers retain their original behavior.
        if (facing == EnumFacing.UP) {
            return defaultDispense(source, stack);
        }

        // Determine the position of the block directly in front.
        int x = source.getXInt() + facing.getFrontOffsetX();
        int y = source.getYInt() + facing.getFrontOffsetY();
        int z = source.getZInt() + facing.getFrontOffsetZ();

        // Attempt to apply bonemeal.
        ItemDye.func_150919_a(stack, world, x, y, z);

        return stack;
    }

    /**
     * Executes the original dispenser behavior.
     */
    private ItemStack defaultDispense(
        IBlockSource source,
        ItemStack stack
    ) {
        if (defaultBehavior == null) {
            defaultBehavior = new BehaviorDefaultDispenseItem();
        }

        return defaultBehavior.dispense(source, stack);
    }
}
