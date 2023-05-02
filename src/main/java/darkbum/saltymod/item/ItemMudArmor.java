package darkbum.saltymod.item;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.configuration.ModConfiguration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import darkbum.saltymod.common.CommonProxy;

public class ItemMudArmor extends ItemArmor {
    public ItemMudArmor(String name, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        setUnlocalizedName(name);
        setCreativeTab(CommonProxy.tabSalt);
        setTextureName("saltymod:" + name);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "saltymod:textures/armor/mud_layer_" + (armorType == 2 ? "2" : "1") + ".png";
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
        return (material.getItem() == ModItems.mineral_mud_ball || super.getIsRepairable(toRepair, material));
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (!world.isRemote) {
            if (stack.getItem() == ModItems.mud_helmet && ModConfiguration.mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(4, null);
                        player.addStat(ModAchievementList.destroyMudArmor, 1);
                    }
                }
            }
            if (stack.getItem() == ModItems.mud_chestplate && ModConfiguration.mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(3, null);
                        player.addStat(ModAchievementList.destroyMudArmor, 1);
                    }
                }
            }
            if (stack.getItem() == ModItems.mud_leggings && ModConfiguration.mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(2, null);
                        player.addStat(ModAchievementList.destroyMudArmor, 1);
                    }
                }
            }
            if (stack.getItem() == ModItems.mud_boots && ModConfiguration.mudArmorWaterDamage) {
                if (player.isWet() && itemRand.nextInt(100) == 0) {
                    stack.damageItem(1, player);
                    if (stack.getItemDamage() >= stack.getMaxDamage()) {
                        player.setCurrentItemOrArmor(1, null);
                        player.addStat(ModAchievementList.destroyMudArmor, 1);
                    }
                }
            }
            //MOD CONFIG!!!
            if (armorType == 0 &&
                player.getEquipmentInSlot(1) != null &&
                player.getEquipmentInSlot(1).getItem() instanceof ItemMudArmor &&
                player.getEquipmentInSlot(2) != null &&
                player.getEquipmentInSlot(2).getItem() instanceof ItemMudArmor &&
                player.getEquipmentInSlot(3) != null &&
                player.getEquipmentInSlot(3).getItem() instanceof ItemMudArmor) {
                player.addStat(ModAchievementList.fullMudArmor, 1);
                if (player.isPotionActive(Potion.field_76434_w.id)) {
                    player.getActivePotionEffect(Potion.field_76434_w).duration = 2;
                } else {
                    player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 2, ModConfiguration.mudArmorHealthBoostValue, true));
                }
            }
        }
    }
}
