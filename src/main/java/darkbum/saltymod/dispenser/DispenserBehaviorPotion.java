package darkbum.saltymod.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DispenserBehaviorPotion implements IBehaviorDispenseItem {

    private static final Set<Integer> ALLOWED_META = new HashSet<>(Arrays.asList(0, 16, 32, 64, 8192));
    private final IBehaviorDispenseItem defaultBehavior;

    public DispenserBehaviorPotion() {
        this.defaultBehavior = (IBehaviorDispenseItem) BlockDispenser.dispenseBehaviorRegistry.getObject(Items.potionitem);
    }

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        if (!ALLOWED_META.contains(stack.getItemDamage())) {
            return defaultBehavior.dispense(source, stack);
        }

        World world = source.getWorld();
        EnumFacing facing = BlockDispenser.func_149937_b(source.getBlockMetadata());
        double x = source.getX() + facing.getFrontOffsetX() * 0.7 + 0.5;
        double y = source.getY() + facing.getFrontOffsetY() * 0.7 + 0.5;
        double z = source.getZ() + facing.getFrontOffsetZ() * 0.7 + 0.5;

        stack.stackSize--;

        ItemStack emptyBottle = new ItemStack(Items.glass_bottle);

        if (stack.stackSize <= 0) {
            return emptyBottle;
        } else {
            TileEntityDispenser dispenser = (TileEntityDispenser) source.getBlockTileEntity();
            int slot = dispenser.func_146017_i(); // Nächster freier Slot
            if (slot >= 0 && dispenser.getStackInSlot(slot) == null) {
                dispenser.setInventorySlotContents(slot, emptyBottle);
            } else {
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, emptyBottle));
            }
            return stack;
        }
    }
}
