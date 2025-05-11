package darkbum.saltymod.dispenser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModBlocks;

/**
 * Custom dispenser behavior for dispensing salt pinch items.
 * When triggered, it interacts with the salt dirt blocks and modifies
 * the block state or behavior based on the current metadata.
 * Plays sound effects based on the action performed.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class DispenserBehaviorSaltPinch implements IBehaviorDispenseItem {

    /**
     * Dispenses a salt pinch item and modifies the state of nearby salt dirt blocks.
     * If the block in front is salt dirt, the metadata is used to determine the action to take,
     * updating the block state. If the block is not salt dirt, the item is dispensed normally.
     * Plays different sound effects based on whether the action was successful or not.
     *
     * @param source The source block of the dispenser.
     * @param stack  The item stack being dispensed.
     * @return the updated item stack after dispensing.
     */
    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing enumFacing = BlockDispenser.func_149937_b(source.getBlockMetadata());
        IPosition iPosition = BlockDispenser.func_149939_a(source);
        int x = MathHelper.floor_double(iPosition.getX());
        int y = MathHelper.floor_double(iPosition.getY());
        int z = MathHelper.floor_double(iPosition.getZ());
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        Block blockBelow = world.getBlock(x, y - 1, z);
        int metaBelow = world.getBlockMetadata(x, y - 1, z);

        if (block == Blocks.grass) {
            if (meta == 0) {
                world.setBlock(x, y, z, ModBlocks.salt_grass, 0, 3);
                stack.splitStack(1);
            }
        } else if (blockBelow == Blocks.grass && (world.isAirBlock(x, y, z) || block == ModBlocks.saltworts)) {
            if (meta == 0) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_grass, 0, 3);
                stack.splitStack(1);
            }
        } else if (block == Blocks.dirt) {
            if (meta == 0) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt_lite, 0, 3);
                stack.splitStack(1);
            }
        } else if (blockBelow == Blocks.dirt && (world.isAirBlock(x, y, z) || block == ModBlocks.saltworts)) {
            if (meta == 0) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt_lite, 0, 3);
                stack.splitStack(1);
            }
        } else if (block == ModBlocks.salt_dirt_lite) {
            if (meta == 0 || meta > 2) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt_lite, 1, 3);
                stack.splitStack(1);
            } else if (meta == 1) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt_lite, 2, 3);
                stack.splitStack(1);
            } else if (meta == 2) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt, 0, 3);
                stack.splitStack(1);
            }
        } else if (blockBelow == ModBlocks.salt_dirt_lite && (world.isAirBlock(x, y, z) || block == ModBlocks.saltworts)) {
            if (metaBelow == 0 || metaBelow > 2) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt_lite, 1, 3);
                stack.splitStack(1);
            } else if (metaBelow == 1) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt_lite, 2, 3);
                stack.splitStack(1);
            } else if (metaBelow == 2) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt, 0, 3);
                stack.splitStack(1);
            }
        } else if (block == ModBlocks.salt_dirt) {
            if (meta == 0) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt, 1, 3);
                stack.splitStack(1);
            }
        } else if (blockBelow == ModBlocks.salt_dirt && (world.isAirBlock(x, y, z) || block == ModBlocks.saltworts)) {
            if (metaBelow == 0) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt, 1, 3);
                stack.splitStack(1);
            }
        } else {
            BehaviorDefaultDispenseItem.doDispense(world, stack.splitStack(1), 1, enumFacing, iPosition);
        }
        source.getWorld().playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 1.0f);
        source.getWorld().playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.pop", 1.0f, 1.0f);
        return stack;
    }
}
