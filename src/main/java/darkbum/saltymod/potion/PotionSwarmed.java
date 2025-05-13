package darkbum.saltymod.potion;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;

import darkbum.saltymod.init.ModAchievementList;

/**
 * Custom potion effect class for the "Swarmed" effect.
 * The Swarmed effect simulates an attack by bees, causing periodic damage to the player.
 * Damage can be mitigated by wearing bee-resistant armor pieces.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class PotionSwarmed extends ModPotion {

    /**
     * Constructs a new instance of the Swarmed potion effect.
     *
     * @param id     The unique identifier for the potion effect.
     * @param isBad  Indicates whether the effect is considered harmful.
     * @param color  The color of the effect when displayed in the HUD.
     */
    protected PotionSwarmed(int id, boolean isBad, int color) {
        super(id, isBad, color);
        setPotionName("potion.swarmed");
        setIconIndex(0, 0);
        setEffectiveness(0.25D);
    }

    /**
     * Performs the effect logic for the Swarmed effect.
     * Applies periodic damage to the player unless they are wearing bee-resistant armor or submerged in liquid.
     *
     * @param entity The entity affected by the effect.
     * @param level  The effect amplifier level.
     */
    @Override
    public void performEffect(EntityLivingBase entity, int level) {
        if (entity instanceof EntityPlayer player) {

            float beeResistance = 0F;
            ArrayList<ItemStack> validStacks = OreDictionary.getOres("beeResistant");
            float[] resistanceValues = { 0.4F, 0.3F, 0.2F, 0.1F };

            for (int i = 0; i < 4; i++) {
                ItemStack itemStack = player.getCurrentArmor(i);
                if (itemStack != null) {
                    for (ItemStack validStack : validStacks) {
                        if (OreDictionary.itemMatches(validStack, itemStack, false)) {
                            beeResistance += resistanceValues[i];
                            break;
                        }
                    }
                }
            }

            int x = MathHelper.floor_double(player.posX);
            int y = MathHelper.floor_double(player.posY + player.getEyeHeight());
            int z = MathHelper.floor_double(player.posZ);

            if (!player.worldObj.getBlock(x, y, z).getMaterial().isLiquid() && !player.isBurning()) {
                player.addStat(ModAchievementList.effect_swarmed, 1);
                entity.attackEntityFrom(ModPotion.SWARMED_DAMAGE, Math.max(0.0F, 1.0F - beeResistance));
            }
        }
    }

    /**
     * Determines if the Swarmed effect should perform its action at a given tick interval.
     * The interval decreases with higher effect levels, increasing the frequency of the effect.
     *
     * @param duration  The remaining duration of the effect in ticks.
     * @param amplifier The effect amplifier level.
     * @return true if the effect should trigger an action, false otherwise.
     */
    @Override
    public boolean isReady(int duration, int amplifier) {
        int interval;
        interval = 10 >> amplifier;
        return interval == 0 || duration % interval == 0;
    }
}
