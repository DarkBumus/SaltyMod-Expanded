/*package darkbum.saltymod.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemHorn extends Item {

    public static final String[] types = { "ponder", "sing", "seek", "feel", "admire", "call", "yearn", "dream" };

    private final Map<EntityPlayer, Long> lastUsedTime = new HashMap<>();

    public ItemHorn(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
        maxStackSize = 1;
    }

    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < types.length; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    public void addInformation(ItemStack stack, net.minecraft.entity.player.EntityPlayer player, List<String> tooltip, boolean advanced) {
        int metadata = stack.getItemDamage();
        String type = types[metadata];
        tooltip.add(I18n.format(this.getUnlocalizedName() + "." + type + ".tooltip"));
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.bow;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int useTime = this.getMaxItemUseDuration(stack) - count;

        if (useTime >= 140) {
            player.stopUsingItem();
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int timeLeft) {
        int heldTime = this.getMaxItemUseDuration(stack) - timeLeft;

        if (heldTime < 140) return;
        String soundName = "saltymod:item.horn." + types[stack.getItemDamage()];

        if (!world.isRemote) {
            for (EntityPlayer otherPlayer : world.playerEntities) {
                if (player.getDistanceToEntity(otherPlayer) <= 256.0) {
                    world.playSoundAtEntity(otherPlayer, soundName, 100.0F, 1.0F);
                }
            }
        }
    }
}*/
