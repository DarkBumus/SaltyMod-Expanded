package darkbum.saltymod.item;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

import static darkbum.saltymod.init.ModExternalItemLoader.*;
import static darkbum.saltymod.util.BlockUtil.*;
import static darkbum.saltymod.util.ItemUtil.*;

/**
 * Item class for the salt pickaxe item.
 * The salt pickaxe is a tool item made with a special interaction.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemSaltPickaxe extends ItemPickaxe {

    private static final float ENTITY_DAMAGE = 30.0F;

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The base name of the item.
     * @param tab  The creative tab to display this item in.
     */
    public ItemSaltPickaxe(String name, CreativeTabs tab) {
        super(ToolMaterial.STONE);
        setHarvestLevel("pickaxe", 1);
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setMaxStackSize(1);
    }

    /**
     * Adds additional information to the item tooltip when hovering over the item in the inventory.
     *
     * @param stack    The ItemStack for which the information is being added.
     * @param player   The player viewing the tooltip.
     * @param list     The list to which the tooltip lines are added.
     * @param advanced Whether advanced tooltips are enabled.
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
        addItemTooltip(stack, list);
    }

    /**
     * Determines if the item is repairable using a specific material.
     *
     * @param toRepair The ItemStack to be repaired.
     * @param material The material used for repairing.
     * @return true, if the item can be repaired, false otherwise.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
        return material.getItem() == ModItems.salt_shard;
    }

    /**
     * Handles entity hit logic, applying extra damage to salt-vulnerable entities.
     *
     * @param stack    The ItemStack instance of the pickaxe.
     * @param target   The entity being attacked.
     * @param attacker The player using the pickaxe.
     * @return true, if the action was successful, false otherwise.
     */
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        World world = attacker.worldObj;

        if (isSaltVulnerableEntity(target)) {
            target.attackEntityFrom(DamageSource.generic, ENTITY_DAMAGE);
            world.playSoundEffect(attacker.posX, attacker.posY, attacker.posZ, "dig.stone", 2.0F, 1.0F);
            world.playSoundEffect(attacker.posX, attacker.posY, attacker.posZ, "dig.glass", 2.0F, 2.0F);
            int damageAmount = Math.max(1, (stack.getMaxDamage() / 3) + 1);
            stack.damageItem(damageAmount, attacker);
            if (target instanceof EntitySlime && !(target instanceof EntityMagmaCube)) {
                target.entityDropItem(new ItemStack(ModItems.tough_jelly, 1, 0), 0).delayBeforeCanPickup = 10;
                ((EntityPlayer) attacker).addStat(ModAchievementList.slime_salt_crystal, 1);
                return true;
            }
            if (target instanceof EntityWitch) {
                target.entityDropItem(new ItemStack(ModItems.salt_pinch, 1, 0), 0).delayBeforeCanPickup = 10;
                ((EntityPlayer) attacker).addStat(ModAchievementList.witch_salt_crystal, 1);
                return true;
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    /**
     * Called when the player starts breaking a block with this pickaxe.
     *
     * @param stack  The item stack being used to break the block.
     * @param x      The X coordinate of the block being broken.
     * @param y      The Y coordinate of the block being broken.
     * @param z      The Z coordinate of the block being broken.
     * @param player The player breaking the block.
     * @return true, if the custom behavior is applied and the block breaking process should be canceled, false otherwise.
     */
    @Override
    public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
        if (player.worldObj.isRemote) return false;

        Block block = player.worldObj.getBlock(x, y, z);
        World world = player.worldObj;

        if (!player.capabilities.isCreativeMode) {
            if (isIceBlock(block)) {
                world.setBlockToAir(x, y, z);
                dropStack(world, x, y, z, new ItemStack(block));
                stack.damageItem(1, player);

                if (stack.stackSize <= 0) {
                    player.destroyCurrentEquippedItem();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given block is considered an ice block, including mod-specific blocks.
     *
     * @param block The block to check.
     * @return true, if the block is an ice block, false otherwise.
     */
    private boolean isIceBlock(Block block) {
        Block blue_ice = etFuturumBlocks.get("blue_ice");

        return block == Blocks.ice || block == Blocks.packed_ice || block == blue_ice;
    }

    /**
     * Drops the specified item stack at the given coordinates in the world.
     *
     * @param world The world instance.
     * @param x     The X coordinate where the item will be dropped.
     * @param y     The Y coordinate where the item will be dropped.
     * @param z     The Z coordinate where the item will be dropped.
     * @param stack The item stack to be dropped.
     */
    public static void dropStack(World world, int x, int y, int z, ItemStack stack) {
        if (!world.isRemote && stack != null && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
            float f = 0.7f;
            double d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            EntityItem entityItem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
            entityItem.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entityItem);
        }
    }

    /**
     * Determines whether this pickaxe is effective against the specified block.
     *
     * @param block The block being targeted.
     * @return true, if the pickaxe is effective against the specified block, false otherwise.
     */
    @Override
    public boolean func_150897_b(Block block) {
        return isIceBlock(block) || super.func_150897_b(block);
    }

    /**
     * Overrides the digging speed against specific blocks, emulating Efficiency V.
     *
     * @param stack The item stack being used.
     * @param block The block being targeted.
     * @return the digging speed multiplier.
     */
    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if (isIceBlock(block)) {
            return 15.0f;
        }
        return super.getDigSpeed(stack, block, meta);
    }
}
