package darkbum.saltymod.util;

import darkbum.saltymod.init.ModSounds;
import darkbum.saltymod.potion.ModPotion;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import static darkbum.saltymod.init.ModSounds.*;
import static net.minecraft.block.Block.*;

public class BlockHelper {

    public static void setBlockDirectionFromEntity(World world, int x, int y, int z, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            int direction = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
            world.setBlockMetadataWithNotify(x, y, z, direction, 2);
        }
    }

    public static void applySwarmedEffect(World world, EntityPlayer player, int x, int y, int z, int durationTicks) {
        if (!player.capabilities.isCreativeMode) {
            PotionEffect effect = new PotionEffect(ModPotion.swarmed.id, durationTicks, 0, true);
            effect.getCurativeItems().clear();
            player.addPotionEffect(effect);
            world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "saltymod:block.bee_burrow.bees", 1.0F, 1.5F);
        }
    }

    public static void propertiesApiaryFishFarm(Block block) {
        block.setHardness(0.6F);
        block.setResistance(0.6F);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesBeeNest(Block block) {
        block.setHardness(1.5f);
        block.setResistance(2.0f);
        block.setStepSound(soundTypeWood);
        block.setHarvestLevel("axe", 0);
    }

    public static void propertiesClayoven(Block block) {
        block.setHardness(0.5F);
        block.setResistance(3.5F);
        block.setStepSound(soundTypeStone);
    }

    public static void propertiesCookingPot(Block block) {
        block.setHardness(0.5F);
        block.setResistance(6.0F);
        block.setStepSound(soundTypeCookingPot);
    }

    public static void propertiesDryMudBrick(Block block) {
        block.setHardness(1.5F);
        block.setResistance(3.0F);
        block.setStepSound(soundTypeDryMudBrick);
        block.setHarvestLevel("pickaxe", 0);
    }

    public static void propertiesEvaporator(Block block) {
        block.setHardness(3.5F);
        block.setResistance(3.5F);
        block.setStepSound(soundTypeStone);
    }

    public static void propertiesMarshReeds(Block block) {
        block.setHardness(0.0f);
        block.setResistance(0.0f);
        block.setStepSound(soundTypeGrass);
    }
}
