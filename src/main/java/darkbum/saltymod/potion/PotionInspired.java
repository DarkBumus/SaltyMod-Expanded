package darkbum.saltymod.potion;

public class PotionInspired extends ModPotion {

    public PotionInspired(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.inspired");
        setIconIndex(2, 0);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return false;
    }
}
