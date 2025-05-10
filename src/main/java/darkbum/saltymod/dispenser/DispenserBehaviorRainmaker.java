package darkbum.saltymod.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import darkbum.saltymod.entity.EntityRainmaker;

/**
 * Custom dispenser behavior for dispensing the Rainmaker entity.
 * When the dispenser is triggered, it attempts to spawn a Rainmaker entity
 * at a valid position in front of the dispenser. If the position is blocked,
 * an auxiliary sound effect is played instead.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class DispenserBehaviorRainmaker implements IBehaviorDispenseItem {

    /**
     * Dispenses the Rainmaker entity from the dispenser.
     * It spawns the Rainmaker entity in the world if the target position is air.
     * If the position is blocked, it plays a different sound effect.
     *
     * @param source The source block of the dispenser.
     * @param stack  The item stack being dispensed.
     * @return the updated item stack after dispensing.
     */
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing enumFacing = BlockDispenser.func_149937_b(source.getBlockMetadata());
        IPosition iPosition = BlockDispenser.func_149939_a(source);
        double d0 = source.getX() + enumFacing.getFrontOffsetX();
        double d1 = (source.getYInt() + 0.2F);
        double d2 = source.getZ() + enumFacing.getFrontOffsetZ();
        int x = MathHelper.floor_double(iPosition.getX());
        int y = MathHelper.floor_double(iPosition.getY());
        int z = MathHelper.floor_double(iPosition.getZ());

        if (world.isAirBlock(x, y, z)) {
            EntityRainmaker entityRainmaker = new EntityRainmaker(source.getWorld(), d0, d1, d2, null);
            source.getWorld().spawnEntityInWorld(entityRainmaker);
            source.getWorld().playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.pop", 1.0f, 1.0f);
            source.getWorld().playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.bow", 1.0f, 1.0f);
            stack.splitStack(1);
        } else {
            source.getWorld().playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 1.0f);
        }
        return stack;
    }
}
