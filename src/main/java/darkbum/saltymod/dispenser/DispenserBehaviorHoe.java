package darkbum.saltymod.dispenser;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import darkbum.saltymod.util.HoeHarvestHelper;
import darkbum.saltymod.util.HoeHarvestRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.*;

public class DispenserBehaviorHoe implements IBehaviorDispenseItem {

    private final Map<Item, IBehaviorDispenseItem> defaultBehaviors =
        new IdentityHashMap<>();

    /**
     * Registers a hoe and stores its original dispenser behavior.
     *
     * @param item The hoe item to register.
     */
    public void register(Item item) {
        if (!(item instanceof ItemHoe)) return;

        IBehaviorDispenseItem behavior =
            (IBehaviorDispenseItem) BlockDispenser.dispenseBehaviorRegistry
                .getObject(item);

        if (behavior == this) return;

        if (behavior == null) {
            behavior = new BehaviorDefaultDispenseItem();
        }

        defaultBehaviors.put(item, behavior);
        BlockDispenser.dispenseBehaviorRegistry.putObject(item, this);
    }

    @Override
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        World world = source.getWorld();

        if (world.isRemote) return stack;

        EnumFacing facing = BlockDispenser.func_149937_b(
            source.getBlockMetadata()
        );

        // Upward-facing dispensers do not harvest.
        if (facing == EnumFacing.UP) {
            return defaultDispense(source, stack);
        }

        List<int[]> candidates;
        List<int[]> foundCrops = new ArrayList<>();

        if (facing == EnumFacing.DOWN) {
            candidates = collectCandidatesDownward(source, foundCrops);
        } else {
            candidates = collectCandidatesForward(source, facing, foundCrops);
        }

        // No mature crops found.
        if (candidates.isEmpty()) {
            // Keep the hoe if any crops were found, even if they are not mature.
            if (!foundCrops.isEmpty()) {
                return stack;
            }

            return defaultDispense(source, stack);
        }

        // Determine how many crops the hoe can still harvest.
        int availableDurability = stack.isItemStackDamageable()
            ? Math.max(0, stack.getMaxDamage() - stack.getItemDamage())
            : candidates.size();

        // The hoe has no durability left.
        if (availableDurability == 0) {
            return stack;
        }

        // Randomize the candidate order.
        for (int i = candidates.size() - 1; i > 0; i--) {
            int j = world.rand.nextInt(i + 1);

            int[] temporary = candidates.get(i);
            candidates.set(i, candidates.get(j));
            candidates.set(j, temporary);
        }

        // Only harvest as many crops as the hoe can withstand.
        int harvestLimit = Math.min(
            candidates.size(),
            availableDurability
        );

        List<ItemStack> harvestedDrops = new ArrayList<>();
        int harvestedCount = 0;

        for (int i = 0; i < harvestLimit; i++) {
            int[] position = candidates.get(i);

            List<ItemStack> result = HoeHarvestHelper.harvest(
                world,
                position[0],
                position[1],
                position[2]
            );

            if (result == null) continue;

            harvestedDrops.addAll(result);
            harvestedCount++;
        }

        if (harvestedCount <= 0) {
            return stack;
        }

        insertDropsIntoNearbyInventories(
            source, facing, harvestedDrops
        );

        // Eject any remaining drops in front of the dispenser.
        for (ItemStack drop : harvestedDrops) {
            if (drop != null && drop.stackSize > 0) {
                ejectDrop(source, facing, drop);
            }
        }

        // Damage the hoe once for every successfully harvested crop.
        damageHoe(stack, harvestedCount);

        return stack;
    }

    /**
     * Returns the configured harvesting area dimensions.
     *
     * @return An array containing width, height and depth.
     */
    private int[] getHarvestingArea() {
        return dispenserHarvestingArea;
    }

    /**
     * Checks whether a block is a supported crop.
     */
    private boolean isCrop(Block block) {
        return block instanceof BlockCrops || HoeHarvestRegistry.getHandler(block) != null;
    }

    /**
     * Searches a 5 x 2 x 5 area in front of a horizontally facing dispenser.
     * The first depth position is the block directly in front of the
     * dispenser. The search then continues four blocks farther forward.
     *
     * @return A list of mature crops.
     */
    private List<int[]> collectCandidatesForward(
        IBlockSource source,
        EnumFacing facing,
        List<int[]> foundCrops
    ) {
        World world = source.getWorld();

        List<int[]> candidates = new ArrayList<>();

        int originX = source.getXInt() + facing.getFrontOffsetX();
        int originY = source.getYInt();
        int originZ = source.getZInt() + facing.getFrontOffsetZ();

        int rightX = -facing.getFrontOffsetZ();
        int rightZ = facing.getFrontOffsetX();

        int[] area = getHarvestingArea();

        int widthStart = -(area[0] / 2);

        for (int depth = 0; depth < area[2]; depth++) {
            for (int width = widthStart; width < widthStart + area[0]; width++) {
                for (int height = 0; height < area[1]; height++) {
                    int x = originX
                        + facing.getFrontOffsetX() * depth
                        + rightX * width;

                    int y = originY + height;

                    int z = originZ
                        + facing.getFrontOffsetZ() * depth
                        + rightZ * width;

                    Block block = world.getBlock(x, y, z);

                    if (isCrop(block)) {
                        foundCrops.add(new int[] {x, y, z});

                        if (!HoeHarvestHelper.isHarvestable(world, x, y, z)) {
                            candidates.add(new int[] {x, y, z});
                        }
                    }
                }
            }
        }

        return candidates;
    }

    /**
     * Searches a 5 x 2 x 5 area below a downward-facing dispenser.
     *
     * @return A list of mature crops.
     */
    private List<int[]> collectCandidatesDownward(
        IBlockSource source,
        List<int[]> foundCrops
    ) {
        World world = source.getWorld();

        List<int[]> candidates = new ArrayList<>();

        int originX = source.getXInt();
        int originY = source.getYInt() - 1;
        int originZ = source.getZInt();

        int[] area = getHarvestingArea();

        int widthStart = -(area[0] / 2);
        int depthStart = -(area[2] / 2);

        for (int xOffset = widthStart; xOffset < widthStart + area[0]; xOffset++) {
            for (int zOffset = depthStart; zOffset < depthStart + area[2]; zOffset++) {
                for (int height = 0; height < area[1]; height++) {
                    int x = originX + xOffset;
                    int y = originY - height;
                    int z = originZ + zOffset;

                    Block block = world.getBlock(x, y, z);

                    if (isCrop(block)) {
                        foundCrops.add(new int[] {x, y, z});

                        if (!HoeHarvestHelper.isHarvestable(world, x, y, z)) {
                            candidates.add(new int[] {x, y, z});
                        }
                    }
                }
            }
        }

        return candidates;
    }

    /**
     * Tries to insert the harvested drops into adjacent inventories.
     * The dispenser's output side is intentionally excluded.
     */
    private void insertDropsIntoNearbyInventories(
        IBlockSource source,
        EnumFacing outputFacing,
        List<ItemStack> drops
    ) {
        World world = source.getWorld();

        for (EnumFacing direction : EnumFacing.values()) {
            if (direction == outputFacing) continue;

            int x = source.getXInt() + direction.getFrontOffsetX();
            int y = source.getYInt() + direction.getFrontOffsetY();
            int z = source.getZInt() + direction.getFrontOffsetZ();

            TileEntity tileEntity = world.getTileEntity(x, y, z);

            if (!(tileEntity instanceof IInventory inventory)) continue;

            // The side of the inventory facing the dispenser.
            int inventorySide = Facing.oppositeSide[direction.ordinal()];

            for (ItemStack stack : drops) {
                if (stack == null || stack.stackSize <= 0) continue;

                insertStack(inventory, stack, inventorySide);
            }

            inventory.markDirty();
        }
    }

    /**
     * Inserts as much of the stack as possible into an inventory.
     */
    private void insertStack(
        IInventory inventory,
        ItemStack stack,
        int side
    ) {
        int[] slots;

        if (inventory instanceof ISidedInventory sided) {
            slots = sided.getAccessibleSlotsFromSide(side);
        } else {
            slots = new int[inventory.getSizeInventory()];

            for (int i = 0; i < slots.length; i++) {
                slots[i] = i;
            }
        }

        for (int slot : slots) {
            if (stack.stackSize <= 0) return;

            if (slot < 0 || slot >= inventory.getSizeInventory()) {
                continue;
            }

            if (!inventory.isItemValidForSlot(slot, stack)) continue;

            if (inventory instanceof ISidedInventory sided) {

                if (!sided.canInsertItem(slot, stack, side)) {
                    continue;
                }
            }

            ItemStack existing = inventory.getStackInSlot(slot);

            if (existing == null) {
                int limit = Math.min(
                    inventory.getInventoryStackLimit(),
                    stack.getMaxStackSize()
                );

                int amount = Math.min(stack.stackSize, limit);

                if (amount <= 0) continue;

                ItemStack inserted = stack.copy();
                inserted.stackSize = amount;

                inventory.setInventorySlotContents(slot, inserted);
                stack.stackSize -= amount;

            } else if (
                existing.getItem() == stack.getItem()
                    && existing.getItemDamage() == stack.getItemDamage()
                    && ItemStack.areItemStackTagsEqual(existing, stack)
            ) {
                int limit = Math.min(
                    inventory.getInventoryStackLimit(),
                    existing.getMaxStackSize()
                );

                int space = limit - existing.stackSize;

                if (space <= 0) continue;

                int amount = Math.min(stack.stackSize, space);

                existing.stackSize += amount;
                stack.stackSize -= amount;

                inventory.setInventorySlotContents(slot, existing);
            }
        }
    }

    /**
     * Ejects a remaining stack in front of the dispenser.
     */
    private void ejectDrop(
        IBlockSource source,
        EnumFacing facing,
        ItemStack stack
    ) {
        World world = source.getWorld();

        while (stack.stackSize > 0) {
            int amount = Math.min(
                stack.stackSize,
                stack.getMaxStackSize()
            );

            ItemStack part = stack.splitStack(amount);

            double x = source.getX() + 0.5D
                + facing.getFrontOffsetX() * 0.7D;

            double y = source.getY() + 0.5D
                + facing.getFrontOffsetY() * 0.7D;

            double z = source.getZ() + 0.5D
                + facing.getFrontOffsetZ() * 0.7D;

            EntityItem entityItem = new EntityItem(
                world, x, y, z, part
            );

            entityItem.motionX =
                facing.getFrontOffsetX() * 0.2D
                    + world.rand.nextGaussian() * 0.0075D * 6.0D;

            entityItem.motionY =
                facing.getFrontOffsetY() * 0.2D
                    + 0.2D
                    + world.rand.nextGaussian() * 0.0075D * 6.0D;

            entityItem.motionZ =
                facing.getFrontOffsetZ() * 0.2D
                    + world.rand.nextGaussian() * 0.0075D * 6.0D;

            entityItem.delayBeforeCanPickup = 10;

            world.spawnEntityInWorld(entityItem);
        }
    }

    /**
     * Executes the original dispenser behavior of the hoe.
     */
    private ItemStack defaultDispense(
        IBlockSource source,
        ItemStack stack
    ) {
        IBehaviorDispenseItem behavior =
            defaultBehaviors.get(stack.getItem());

        if (behavior == null) {
            behavior = new BehaviorDefaultDispenseItem();
        }

        return behavior.dispense(source, stack);
    }

    /**
     * Damages the hoe once for every successfully harvested crop.
     */
    private void damageHoe(ItemStack stack, int amount) {
        if (stack == null || amount <= 0) return;
        if (!stack.isItemStackDamageable()) return;

        int newDamage = stack.getItemDamage() + amount;

        if (newDamage >= stack.getMaxDamage()) {
            stack.stackSize--;

            if (stack.stackSize <= 0) {
                stack.stackSize = 0;
            } else {
                stack.setItemDamage(0);
            }
        } else {
            stack.setItemDamage(newDamage);
        }
    }
}
