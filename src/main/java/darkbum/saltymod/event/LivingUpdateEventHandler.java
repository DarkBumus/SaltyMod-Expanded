package darkbum.saltymod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.*;

import static darkbum.saltymod.common.config.ModConfigurationEntities.*;
import static darkbum.saltymod.common.config.ModConfigurationVanillaChanges.enableVineClimbing;
import static darkbum.saltymod.event.LivingDropsEventHandler.*;
import static net.minecraft.init.Items.*;

public class LivingUpdateEventHandler {

    private final Map<EntityChicken, Integer> lastEggTimers = new WeakHashMap<>();

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onServerLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entity.worldObj.isRemote || !(event.entityLiving instanceof EntityChicken entity) || !chickensShedFeathers) return;
        if (entity.isChild() && !babyChickensDropFeathers) return;

        if (entity.worldObj.rand.nextInt(featherSheddingFrequency) == 0) {
            entity.entityDropItem(new ItemStack(feather, 1, 0), 0.0f);
        }

        if (chickensShedFeathersWithEggs && !entity.isChild() && entity.func_152116_bZ()) {
            int current = entity.timeUntilNextEgg;
            Integer previous = lastEggTimers.get(entity);

            if (previous != null && current >= 6000 && current > previous) {
                int amount = getDropAmount(chickensAlwaysDropFeathers ? 1 : 0, 1);
                entity.entityDropItem(new ItemStack(feather, amount, 0), 0.0f);
            }

            lastEggTimers.put(entity, current);
        }
    }

    private static final Set<Block> ADDITIONAL_CLIMBABLE_VINES = new HashSet<>(
        Arrays.asList(
            Block.getBlockFromName("plantmegapack:vineFlowersBurgundy"),
            Block.getBlockFromName("plantmegapack:vineFlowersRed"),
            Block.getBlockFromName("plantmegapack:vineFlowersCoral"),
            Block.getBlockFromName("plantmegapack:vineFlowersOrange"),
            Block.getBlockFromName("plantmegapack:vineFlowersYellow"),
            Block.getBlockFromName("plantmegapack:vineFlowersCyan"),
            Block.getBlockFromName("plantmegapack:vineFlowersGreen"),
            Block.getBlockFromName("plantmegapack:vineFlowersBlue"),
            Block.getBlockFromName("plantmegapack:vineFlowersRoyal"),
            Block.getBlockFromName("plantmegapack:vineFlowersPurple"),
            Block.getBlockFromName("plantmegapack:vineFlowersMagenta"),
            Block.getBlockFromName("plantmegapack:vineFlowersPink"),
            Block.getBlockFromName("plantmegapack:vineFlowersWhite"),
            Block.getBlockFromName("plantmegapack:vineJapaneseIvy"),
            Block.getBlockFromName("plantmegapack:vineSilverveinCreeper"),
            Block.getBlockFromName("plantmegapack:vineSwedishIvy"),
            Block.getBlockFromName("plantmegapack:vineSpanishMoss"),
            Block.getBlockFromName("plantmegapack:vineVariegatedPersianIvy")
        )
    );

    static {
        ADDITIONAL_CLIMBABLE_VINES.remove(null);
    }

    private static boolean isClimbableVine(Block block) {
        return block instanceof BlockVine || ADDITIONAL_CLIMBABLE_VINES.contains(block);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!enableVineClimbing || !(event.entityLiving instanceof EntityPlayer player)) {
            return;
        }

        int blockX = MathHelper.floor_double(player.posX);
        int blockY = MathHelper.floor_double(player.posY);
        int blockZ = MathHelper.floor_double(player.posZ);

        Block currentBlock = player.worldObj.getBlock(blockX, blockY, blockZ);

        if (isClimbableVine(currentBlock) && GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump) && player.motionY < 0.12D) {
            player.motionY = 0.12D;
        }
    }
}
