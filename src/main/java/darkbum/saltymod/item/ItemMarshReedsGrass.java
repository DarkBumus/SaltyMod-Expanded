package darkbum.saltymod.item;

import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMarshReedsGrass extends Item {

    public ItemMarshReedsGrass(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
                             float hitX, float hitY, float hitZ) {

        if (world.isRemote || world.isAirBlock(x, y, z)) {
            return false;
        }
        switch (side) {
            case 0:
                if (canPlaceReeds(world, x, y - 3, y - 2, y - 1, z)) {
                    placeReeds(world, x, y - 1, z, player, stack);
                    return true;
                }
                break;
            case 1:
                if (canPlaceReeds(world, x, y, y + 1, y + 2, z)) {
                    placeReeds(world, x, y + 2, z, player, stack);
                    return true;
                }
                break;
            case 2:
                if (canPlaceReeds(world, x, y - 2, y - 1, y, z - 1)) {
                    placeReeds(world, x, y, z - 1, player, stack);
                    return true;
                }
                if (canPlaceReeds(world, x, y - 1, y, y + 1, z - 1)) {
                    placeReeds(world, x, y + 1, z - 1, player, stack);
                    return true;
                }
                break;
            case 3:
                if (canPlaceReeds(world, x, y - 2, y - 1, y, z + 1)) {
                    placeReeds(world, x, y, z + 1, player, stack);
                    return true;
                }
                if (canPlaceReeds(world, x, y - 1, y, y + 1, z + 1)) {
                    placeReeds(world, x, y + 1, z + 1, player, stack);
                    return true;
                }
                break;
            case 4:
                if (canPlaceReeds(world, x - 1, y - 2, y - 1, y, z)) {
                    placeReeds(world, x - 1, y, z, player, stack);
                    return true;
                }
                if (canPlaceReeds(world, x - 1, y - 1, y, y + 1, z)) {
                    placeReeds(world, x - 1, y + 1, z, player, stack);
                    return true;
                }
                break;
            case 5:
                if (canPlaceReeds(world, x + 1, y - 2, y - 1, y, z)) {
                    placeReeds(world, x + 1, y, z, player, stack);
                    return true;
                }
                if (canPlaceReeds(world, x + 1, y - 1, y, y + 1, z)) {
                    placeReeds(world, x + 1, y + 1, z, player, stack);
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean canPlaceReeds(World world, int x, int yMud, int yWater, int yAir, int z) {
        Block mud = world.getBlock(x, yMud, z);
        Block water = world.getBlock(x, yWater, z);
        Block air = world.getBlock(x, yAir, z);

        return mud == ModBlocks.mineral_mud
            && water == Blocks.water
            && air.isAir(world, x, yAir, z);
    }

    private void placeReeds(World world, int x, int y, int z, EntityPlayer player, ItemStack stack) {
        world.setBlock(x, y, z, ModBlocks.marsh_reeds);
        world.playSoundEffect(x + 0.5D, y + 2.0D, z + 0.5D, "dig.grass", 1.0F, 1.0F);
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }
    }
}
