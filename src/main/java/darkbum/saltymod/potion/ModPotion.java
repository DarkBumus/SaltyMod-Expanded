package darkbum.saltymod.potion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.SaltConfig;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

public class ModPotion extends Potion {

    protected ModPotion(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    private static final ResourceLocation POTION_ICONS = new ResourceLocation("saltymod:textures/gui/container/potions.png");

    public static Potion bees;

    public static Potion wellFed;

    public static void init() {

        bees = new PotionBees(SaltConfig.beesID, true, 0xFFD32D);
        wellFed = new PotionWellFed(SaltConfig.wellFedID, false, 0x7C402F);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) {
        mc.getTextureManager().bindTexture(POTION_ICONS);
        int l = getStatusIconIndex();
        mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, l % 14 * 18, l / 14 * 18, 18, 18);
    }
}
