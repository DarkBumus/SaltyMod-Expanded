package darkbum.saltymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;

import static darkbum.saltymod.util.BlockUtil.*;

/**
 * Item class for the salt shard item.
 * The salt shard is a tool item made with a special entity interaction.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ItemSaltShard extends Item {

    private static final float ENTITY_DAMAGE = 30.0F;

    /**
     * Constructs a new item instance with the specified name and creative tab.
     *
     * @param name The base name of the item.
     * @param tab  The creative tab to display this item in.
     */
    public ItemSaltShard(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
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
            stack.stackSize--;
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
}
