package darkbum.saltmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;

public class ItemToughJelly extends ItemSaltFood {
    public ItemToughJelly(String name, CreativeTabs tab, String textureName) {
        super("toughjelly", 1, 0.3F);
        setUnlocalizedName(name);
        setCreativeTab(tab);
        setTextureName("saltmod:" + textureName);
        setPotionEffect(Potion.confusion.id, 15, 0, 0.3F);
        setAlwaysEdible();
    }
}
