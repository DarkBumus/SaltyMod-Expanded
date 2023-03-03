package darkbum.saltmod.dispenser;

import darkbum.saltmod.entities.EntityRainmaker;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DispenserBehaviorRainmaker implements IBehaviorDispenseItem {
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing enumfacing = BlockDispenser.func_149937_b(source.getBlockMetadata());
        IPosition iposition = BlockDispenser.func_149939_a(source);
        double d0 = source.getX() + enumfacing.getFrontOffsetX();
        double d1 = (source.getYInt() + 0.2F);
        double d2 = source.getZ() + enumfacing.getFrontOffsetZ();
        int x = MathHelper.floor_double(iposition.getX());
        int y = MathHelper.floor_double(iposition.getY());
        int z = MathHelper.floor_double(iposition.getZ());
        if (world.isAirBlock(x, y, z)) {
            EntityRainmaker entityRainmaker = new EntityRainmaker(source.getWorld(), d0, d1, d2, null);
            source.getWorld().spawnEntityInWorld(entityRainmaker);
            source.getWorld().playAuxSFX(2000, x, y, z, enumfacing.getFrontOffsetX() + 1 + (enumfacing.getFrontOffsetZ() + 1) * 3);
            source.getWorld().playAuxSFX(1002, x, y, z, 0);
            stack.splitStack(1);
        } else {
            source.getWorld().playAuxSFX(1001, x, y, z, 0);
        }
        return stack;
    }
}
