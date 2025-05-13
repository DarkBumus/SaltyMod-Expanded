package darkbum.saltymod.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.config.ModConfigurationEffects;

/**
 * Custom base class for all mod-specific potion effects.
 * This class extends the default Minecraft `Potion` class to provide additional functionality
 * and custom visuals for potion effects.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModPotion extends Potion {

    private static final ResourceLocation POTION_ICONS = new ResourceLocation("saltymod:textures/gui/container/potions.png");

    public static final DamageSource SWARMED_DAMAGE = new DamageSource("beesDamage").setDamageBypassesArmor();

    public static Potion swarmed;
    public static Potion wellFed;
    public static Potion inspired;

    /**
     * Constructs a new mod potion effect.
     *
     * @param id     The ID of the potion effect.
     * @param isBad  Indicates whether the effect is considered harmful.
     * @param color  The color of the potion effect (used in the HUD).
     */
    protected ModPotion(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    /**
     * Initializes the custom potion effects for the mod.
     * Must be called during the mod initialization phase.
     */
    public static void init() {
        swarmed = new PotionSwarmed(ModConfigurationEffects.swarmedEffectID, true, 0x000000);
        wellFed = new PotionWellFed(ModConfigurationEffects.wellFedEffectID, false, 0xFFD32D);
        inspired = new PotionInspired(ModConfigurationEffects.inspiredEffectID, false, 0x3FB314);
    }

    /**
     * Determines if this potion effect has a custom icon in the HUD.
     *
     * @return false, indicating that the default icon will not be used.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon() {
        return false;
    }

    /**
     * Renders the custom icon for the potion effect in the inventory GUI.
     *
     * @param x        The x-coordinate of the icon position.
     * @param y        The y-coordinate of the icon position.
     * @param effect   The current potion effect instance.
     * @param minecraft The Minecraft instance.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft minecraft) {
        minecraft.getTextureManager().bindTexture(POTION_ICONS);
        int l = getStatusIconIndex();
        minecraft.currentScreen.drawTexturedModalRect(x + 6, y + 7, l % 14 * 18, l / 14 * 18, 18, 18);
    }
}
