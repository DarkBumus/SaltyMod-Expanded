package darkbum.saltymod.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.configuration.configs.ModConfigurationEffects;

public class ModPotion extends Potion {

    protected ModPotion(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    private static final ResourceLocation POTION_ICONS = new ResourceLocation(
        "saltymod:textures/gui/container/potions.png");

    public static final DamageSource swarmedDamage = new DamageSource("beesDamage").setDamageBypassesArmor();

    public static Potion swarmed;

    public static Potion wellFed;

    public static void init() {

        swarmed = new PotionSwarmed(ModConfigurationEffects.swarmedEffectID, true, 0x000000);
        wellFed = new PotionWellFed(ModConfigurationEffects.wellFedEffectID, false, 0xFFD32D);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) {
        mc.getTextureManager()
            .bindTexture(POTION_ICONS);
        int l = getStatusIconIndex();
        mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, l % 14 * 18, l / 14 * 18, 18, 18);
    }
}
