package darkbum.saltymod.dispenser;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Custom dispenser behavior for water buckets.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class DispenserBehaviorWaterBucket implements IBehaviorDispenseItem {

    private final IBehaviorDispenseItem defaultBehavior;

    public DispenserBehaviorWaterBucket() {
        this.defaultBehavior = (IBehaviorDispenseItem) BlockDispenser.dispenseBehaviorRegistry.getObject(Items.water_bucket);
    }

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing facing = BlockDispenser.func_149937_b(source.getBlockMetadata());

        int x = source.getXInt() + facing.getFrontOffsetX();
        int y = source.getYInt() + facing.getFrontOffsetY();
        int z = source.getZInt() + facing.getFrontOffsetZ();

        if (world.getBlock(x, y, z) != ModBlocks.lit_stove) {
            return defaultBehavior.dispense(source, stack);
        }

        int meta = world.getBlockMetadata(x, y, z);

        if (!world.isRemote) {
            world.setBlock(x, y, z, ModBlocks.stove, meta, 3);

            world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
        }

        return new ItemStack(Items.bucket);
    }
}
