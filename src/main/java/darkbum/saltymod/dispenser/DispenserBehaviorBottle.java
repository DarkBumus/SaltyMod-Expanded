package darkbum.saltymod.dispenser;

import net.minecraft.block.Block;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class DispenserBehaviorBottle implements IBehaviorDispenseItem {

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();
        EnumFacing facing = EnumFacing.getFront(source.getBlockMetadata());
        int x = source.getXInt() + facing.getFrontOffsetX();
        int y = source.getYInt() + facing.getFrontOffsetY();
        int z = source.getZInt() + facing.getFrontOffsetZ();

        Block blockInFront = world.getBlock(x, y, z);

        if (stack.getItem() == Items.glass_bottle &&
            (blockInFront == Blocks.water || blockInFront == Blocks.flowing_water)) {

            ItemStack waterBottle = new ItemStack(Items.potionitem, 1, 0); // Wasserflasche, keine Effekte

            if (stack.stackSize == 1) {
                // Nur eine leere Flasche: einfach ersetzen
                return waterBottle;
            } else {
                // Mehrere leere Flaschen: versuche Wasserflasche im Dispenser zu verstauen
                IInventory dispenser = (IInventory) source.getBlockTileEntity();
                boolean stored = false;

                for (int i = 0; i < dispenser.getSizeInventory(); i++) {
                    ItemStack slotStack = dispenser.getStackInSlot(i);
                    if (slotStack == null) {
                        dispenser.setInventorySlotContents(i, waterBottle);
                        stored = true;
                        break;
                    }
                }

                stack.stackSize--;

                if (!stored) {
                    // Kein Platz gefunden, also ausspucken
                    world.spawnEntityInWorld(new EntityItem(world, source.getX(), source.getY(), source.getZ(), waterBottle));
                }

                return stack;
            }
        }

        return stack;
    }
}
