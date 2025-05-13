package darkbum.saltymod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import darkbum.saltymod.common.proxy.CommonProxy;

import static darkbum.saltymod.common.config.ModConfigurationItems.*;
import static darkbum.saltymod.init.ModAchievementList.*;
import static darkbum.saltymod.init.ModItems.*;

/**
 * Item class for the mud armor items.
 * The mud armor is an armor item made with mineral mud.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ItemMudArmor extends ItemArmor {

    /**
     * Constructs a new item instance with the specified name, material and type.
     *
     * @param name The base name of the item.
     * @param material The armor's material
     * @param type The type of the armor (helmet, chestplate, leggings, shoes).
     */
    public ItemMudArmor(String name, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        setUnlocalizedName(name);
        setCreativeTab(CommonProxy.tabSaltItems);
        setTextureName("saltymod:" + name);
    }

    /**
     * Returns the texture for the armor model based on the armor type.
     *
     * @param stack The ItemStack representing the armor item.
     * @param entity The entity wearing the armor.
     * @param slot The armor slot (helmet, chestplate, leggings, boots).
     * @param type The type of the armor (helmet, chestplate, etc.).
     * @return the path to the texture for the armor.
     */
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "saltymod:textures/models/armor/mud_layer_" + (armorType == 2 ? "2" : "1") + ".png";
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
        return (material.getItem() == mineral_mud_ball || super.getIsRepairable(toRepair, material));
    }

    /**
     * Called every tick when the player wears the armor.
     *
     * @param world The world the player is in.
     * @param player The player wearing the armor.
     * @param stack The ItemStack of the armor item being worn.
     */
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (!world.isRemote) {
            if (stack.getItem() == mud_helmet && mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(4, null);
                        player.addStat(destroy_mud_armor, 1);
                    }
                }
            }
            if (stack.getItem() == mud_chestplate && mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(3, null);
                        player.addStat(destroy_mud_armor, 1);
                    }
                }
            }
            if (stack.getItem() == mud_leggings && mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(2, null);
                        player.addStat(destroy_mud_armor, 1);
                    }
                }
            }
            if (stack.getItem() == mud_boots && mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(1, null);
                        player.addStat(destroy_mud_armor, 1);
                    }
                }
            }
            if (mudArmorHealthBoost) {
                if (armorType == 0
                    && player.getEquipmentInSlot(1) != null
                    && player.getEquipmentInSlot(1).getItem() instanceof ItemMudArmor
                    && player.getEquipmentInSlot(2) != null
                    && player.getEquipmentInSlot(2).getItem() instanceof ItemMudArmor
                    && player.getEquipmentInSlot(3) != null
                    && player.getEquipmentInSlot(3).getItem() instanceof ItemMudArmor) {
                    player.addStat(full_mud_armor, 1);
                    if (player.isPotionActive(health_boost)) {
                        player.getActivePotionEffect(Potion.field_76434_w).duration = 2;
                    } else {
                        player.addPotionEffect(new PotionEffect(health_boost, 2, mudArmorHealthBoostValue, true));
                    }
                }
            }
        }
    }
}
