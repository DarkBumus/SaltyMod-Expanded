package darkbum.saltmod.dispenser;

import darkbum.saltmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DispenserBehaviorSaltPinch implements IBehaviorDispenseItem {
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing enumfacing = BlockDispenser.func_149937_b(source.getBlockMetadata());
        IPosition iposition = BlockDispenser.func_149939_a(source);
        int x = MathHelper.floor_double(iposition.getX());
        int y = MathHelper.floor_double(iposition.getY());
        int z = MathHelper.floor_double(iposition.getZ());
        Block blockFase = world.getBlock(x, y, z);
        Block soil = world.getBlock(x, y - 1, z);
        boolean chek = false;
        if (blockFase == ModBlocks.lite_salt_dirt) {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta == 0 || meta > 2) {
                world.setBlock(x, y, z, ModBlocks.lite_salt_dirt, 1, 3);
                stack.splitStack(1);
                chek = true;
            } else if (meta == 1) {
                world.setBlock(x, y, z, ModBlocks.lite_salt_dirt, 2, 3);
                stack.splitStack(1);
                chek = true;
            } else if (meta == 2) {
                world.setBlock(x, y, z, ModBlocks.salt_dirt);
                stack.splitStack(1);
                chek = true;
            }
        } else if (soil == ModBlocks.lite_salt_dirt && (world.isAirBlock(x, y, z) || blockFase == ModBlocks.saltworts)) {
            int meta = world.getBlockMetadata(x, y - 1, z);
            if (meta == 0 || meta > 2) {
                world.setBlock(x, y - 1, z, ModBlocks.lite_salt_dirt, 1, 3);
                stack.splitStack(1);
                chek = true;
            } else if (meta == 1) {
                world.setBlock(x, y - 1, z, ModBlocks.lite_salt_dirt, 2, 3);
                stack.splitStack(1);
                chek = true;
            } else if (meta == 2) {
                world.setBlock(x, y - 1, z, ModBlocks.salt_dirt);
                stack.splitStack(1);
                chek = true;
            }
        } else if (blockFase != ModBlocks.salt_dirt && (soil != ModBlocks.salt_dirt || (
            !world.isAirBlock(x, y, z) && blockFase != ModBlocks.saltworts))) {
            BehaviorDefaultDispenseItem.doDispense(world, stack.splitStack(1), 1, enumfacing, iposition);
            chek = true;
        }
        if (chek) {
            source.getWorld().playAuxSFX(1000, x, y, z, 0);
        } else {
            source.getWorld().playAuxSFX(1001, x, y, z, 0);
        }
        source.getWorld().playAuxSFX(2000, x, y, z, enumfacing.getFrontOffsetX() + 1 + (enumfacing.getFrontOffsetZ() + 1) * 3);
        return stack;
    }
}
