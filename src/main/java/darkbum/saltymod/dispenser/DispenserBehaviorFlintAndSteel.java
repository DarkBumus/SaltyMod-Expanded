package darkbum.saltymod.dispenser;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import static net.minecraft.init.Items.flint_and_steel;

/**
 * Custom dispenser behavior for flint and steel.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class DispenserBehaviorFlintAndSteel implements IBehaviorDispenseItem {

    private final IBehaviorDispenseItem defaultBehavior;

    public DispenserBehaviorFlintAndSteel() {
        this.defaultBehavior = (IBehaviorDispenseItem) BlockDispenser.dispenseBehaviorRegistry.getObject(flint_and_steel);
    }

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing facing = BlockDispenser.func_149937_b(source.getBlockMetadata());

        int x = source.getXInt() + facing.getFrontOffsetX();
        int y = source.getYInt() + facing.getFrontOffsetY();
        int z = source.getZInt() + facing.getFrontOffsetZ();

        if (world.getBlock(x, y, z) != ModBlocks.stove) {
            return defaultBehavior.dispense(source, stack);
        }

        int meta = world.getBlockMetadata(x, y, z);

        if (!world.isRemote) {
            world.setBlock(x, y, z, ModBlocks.lit_stove, meta, 3);

            world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);

            stack.setItemDamage(stack.getItemDamage() + 1);
            if (stack.getItemDamage() >= stack.getMaxDamage()) {
                stack.stackSize--;
            }
        }

        return stack;
    }
}
