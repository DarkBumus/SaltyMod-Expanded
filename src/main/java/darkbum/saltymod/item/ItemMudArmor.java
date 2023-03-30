package darkbum.saltymod.item;

import java.util.Random;

import darkbum.saltymod.init.ModAchievementList;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.init.ModConfiguration;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
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
        return "saltymod:textures/armor/mud_layer_" + ((this.armorType == 2) ? "2" : "1") + ".png";
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
        return (material.getItem() == ModItems.mineral_mud_ball || super.getIsRepairable(toRepair, material));
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (!world.isRemote && stack.getItem() != null && ModConfiguration.mudArmorWaterDam) {
            Random rand = new Random();
            if (stack.getItem() == ModItems.mud_helmet) {
                if (((world.isRaining() && player.isWet() && !player.isInsideOfMaterial(Material.water)) || player
                    .isInsideOfMaterial(Material.water)) && rand.nextInt(100) == 0)
                    stack.damageItem(1, player);
                if (stack.getItemDamage() >= stack.getMaxDamage()) {
                    player.setCurrentItemOrArmor(4, null);
                    player.addStat(ModAchievementList.discomfort, 1);
                }
            }
            if (stack.getItem() == ModItems.mud_chestplate) {
                if ((world.isRaining() || (player.isInsideOfMaterial(Material.water) && player
                    .isInWater())) && player.isWet() && rand.nextInt(100) == 0)
                    stack.damageItem(1, player);
                if (!world.isRaining() && !player.isInsideOfMaterial(Material.water) && player
                    .isInWater() && player.isWet() && rand.nextInt(200) == 0)
                    stack.damageItem(1, player);
                if (stack.getItemDamage() >= stack.getMaxDamage()) {
                    player.setCurrentItemOrArmor(3, null);
                    player.addStat(ModAchievementList.discomfort, 1);
                }
            }
            if (stack.getItem() == ModItems.mud_leggings) {
                if (player.isInWater() && player.isWet() && rand.nextInt(100) == 0)
                    stack.damageItem(1, player);
                if (world.isRaining() && !player.isInWater() && player.isWet() && rand.nextInt(200) == 0)
                    stack.damageItem(1, player);
                if (stack.getItemDamage() >= stack.getMaxDamage()) {
                    player.setCurrentItemOrArmor(2, null);
                    player.addStat(ModAchievementList.discomfort, 1);
                }
            }
            if (stack.getItem() == ModItems.mud_boots) {
                if (player.isInWater() && player.isWet() && rand.nextInt(100) == 0)
                    stack.damageItem(1, player);
                if (!player.isInWater() && world.isRaining() && player.isWet() && rand.nextInt(200) == 0)
                    stack.damageItem(1, player);
                if (stack.getItemDamage() >= stack.getMaxDamage()) {
                    player.setCurrentItemOrArmor(1, null);
                    player.addStat(ModAchievementList.discomfort, 1);
                }
            }
        }
    }
}
