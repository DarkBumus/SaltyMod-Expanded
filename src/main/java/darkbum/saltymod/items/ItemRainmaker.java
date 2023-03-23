package darkbum.saltymod.items;

import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import darkbum.saltymod.entities.EntityRainmaker;

public class ItemRainmaker extends Item {
    public static NBTTagCompound tag = new NBTTagCompound();

    private static NBTTagCompound tag1 = new NBTTagCompound();

    private static NBTTagList nbtlist = new NBTTagList();

    public ItemRainmaker(String name, CreativeTabs tab) {
        setUnlocalizedName(name);
        setCreativeTab(tab);
        tag1.setIntArray("Colors", new int[] { 2651799, 4312372 });
        tag1.setIntArray("FadeColors", new int[] { 15790320 });
        tag1.setBoolean("Trail", true);
        tag1.setByte("Type", (byte)1);
        nbtlist.appendTag(tag1);
        tag.setTag("Explosions", nbtlist);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
        list.add(I18n.format(getUnlocalizedName() + ".tooltip"));
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            EntityRainmaker entityRainmaker = new EntityRainmaker(world, (x + hitX), (y + hitY), (z + hitZ), player);
            world.spawnEntityInWorld(entityRainmaker);
            if (!player.capabilities.isCreativeMode)
                stack.stackSize--;
            return true;
        }
        return false;
    }
}
