package darkbum.saltymod.potion;

public class PotionInspired extends ModPotion {

    public PotionInspired(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.inspired");
        setIconIndex(2, 0);
    }

    @Override
    public boolean isInstant() {
        return false;
    }

    @Override
    public boolean isReady(int p_76397_1_, int p_76397_2_) {
        return false;
    }
}
