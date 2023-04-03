package darkbum.saltymod.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemSaltPie extends ItemSaltFood {

    private static final String[] types = new String[]
        {"chocolate", "birthday", "apple", "sweetberry", "carrot", "mushroom", "potato", "onion", "shepherds", "cod", "salmon", "tropical_fish", "tailor", "calamari", "saltwort"};

    private static final int[] amount = new int[]
        {7, 9, 8, 7, 8, 7, 7, 8, 10, 7, 7, 7, 7, 7, 7};

    private static final float[] saturation = new float[]
        {0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F, 0.9F};

    private static final Potion[] potions = new Potion[]
        {Potion.digSpeed, null, null, null, Potion.nightVision, Potion.damageBoost, null, null, null, Potion.waterBreathing, Potion.waterBreathing, Potion.waterBreathing, Potion.waterBreathing, Potion.waterBreathing, Potion.regeneration};

    private static final int[] duration = new int[]
        {900, 0, 0, 0, 1200, 300, 0, 0, 0, 300, 300, 300, 300, 300, 600};

    private static final int[] amplifier = new int[]
        {2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    private IIcon[] textures;

    public ItemSaltPie(String name, CreativeTabs tab) {
        super(name, 0, 0.0F);
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setHasSubtypes(true);
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta < 0 || meta >= types.length)
            meta = 0;
        return "item." + types[meta] + "_pie";
    }

    public int func_150905_g(ItemStack itemStack) {
        return amount[itemStack.getItemDamage()];
    }

    public float func_150906_h(ItemStack itemStack) {
        return saturation[itemStack.getItemDamage()];
    }



    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < types.length; i++) {
            if (i != 7)
                list.add(new ItemStack(item, 1, i));
        }
    }

    public void registerIcons(IIconRegister iconRegister) {
        this.textures = new IIcon[types.length];
        for (int i = 0; i < types.length; i++)
            this.textures[i] = iconRegister.registerIcon("saltymod:" + types[i] + "_pie");
    }

    public IIcon getIconFromDamage(int meta) {
        if (meta < 0 || meta >= this.textures.length)
            meta = 0;
        return this.textures[meta];
    }
}
