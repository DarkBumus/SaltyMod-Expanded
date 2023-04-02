package darkbum.saltymod.potion;

import net.minecraft.potion.Potion;

public class PotionWellFed extends ModPotion {
    public PotionWellFed(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.wellFed");
        setIconIndex(1, 0);
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public boolean isReady(int p_76397_1_, int p_76397_2_) {
        int k;
        k = 10 >> p_76397_2_;
        return k > 0 ? p_76397_1_ % k == 0 : true;
    }
}
