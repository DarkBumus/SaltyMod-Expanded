package darkbum.saltymod.item;

import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSaltPickaxe extends ItemPickaxe {

    public ItemSaltPickaxe(String name, CreativeTabs tab) {
        super(ToolMaterial.STONE);
        setHarvestLevel("pickaxe", 1);
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setMaxStackSize(1);
    }

    @Override
    public boolean func_150897_b(Block block) {
        return block == Blocks.ice;
    }

    @Override
    public boolean getIsRepairable(ItemStack tool, ItemStack material) {
        return material.getItem() == ModItems.salt_shard;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
        if (player.worldObj.isRemote)
            return false;
        if (!player.capabilities.isCreativeMode)
            if (player.worldObj.getBlock(x, y, z) == Blocks.ice) {
                player.worldObj.setBlockToAir(x, y, z);
                dropStack(player.worldObj, x, y, z, new ItemStack(Blocks.ice));
                return true;
            }
        return false;
    }

    public static void dropStack(World world, int x, int y, int z, ItemStack stack) {
        if (!world.isRemote && stack != null && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
            float f = 0.7F;
            double d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            EntityItem entityItem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
            entityItem.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entityItem);
        }
    }
}
