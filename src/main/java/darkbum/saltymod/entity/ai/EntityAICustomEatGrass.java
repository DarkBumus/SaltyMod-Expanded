package darkbum.saltymod.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModBlocks;

/**
 * AI task for entities to eat grass or salt grass.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class EntityAICustomEatGrass extends EntityAIBase {

    private final EntityLiving entity;
    private final World world;
    int eatingTimer;

    /**
     * Constructs a new EntityAICustomEatGrass instance.
     *
     * @param entity The entity that will perform the eating action.
     */
    public EntityAICustomEatGrass(EntityLiving entity) {
        this.entity = entity;
        world = entity.worldObj;
        setMutexBits(7);
    }

    /**
     * Determines if the AI task should start executing.
     *
     * @return true, if the entity should start eating grass.
     */
    @Override
    public boolean shouldExecute() {
        if (entity.getRNG().nextInt(entity.isChild() ? 50 : 1000) != 0) {
            return false;
        }

        int x = MathHelper.floor_double(entity.posX);
        int y = MathHelper.floor_double(entity.posY);
        int z = MathHelper.floor_double(entity.posZ);

        Block blockBelow = world.getBlock(x, y - 1, z);

        return (world.getBlock(x, y, z) == Blocks.tallgrass && world.getBlockMetadata(x, y, z) == 1)
            || blockBelow == ModBlocks.salt_grass;
    }

    /**
     * Called to start executing the AI task.
     */
    @Override
    public void startExecuting() {
        eatingTimer = 40;
        world.setEntityState(this.entity, (byte) 10);
        entity.getNavigator().clearPathEntity();
    }

    /**
     * Called to reset the AI task.
     */
    @Override
    public void resetTask() {
        eatingTimer = 0;
    }

    /**
     * Determines if the AI task should continue executing.
     *
     * @return true, if the entity is still eating.
     */
    @Override
    public boolean continueExecuting() {
        return eatingTimer > 0;
    }

    /**
     * Called every tick to update the AI task.
     */
    @Override
    public void updateTask() {
        this.eatingTimer = Math.max(0, this.eatingTimer - 1);

        if (this.eatingTimer == 4) {
            int i = MathHelper.floor_double(entity.posX);
            int j = MathHelper.floor_double(entity.posY);
            int k = MathHelper.floor_double(entity.posZ);

            if (world.getBlock(i, j, k) == Blocks.tallgrass) {
                if (world.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    world.func_147480_a(i, j, k, false);
                }
                entity.eatGrassBonus();
            } else if (world.getBlock(i, j - 1, k) == ModBlocks.salt_grass) {
                if (world.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    world.playAuxSFX(2001, i, j - 1, k, Block.getIdFromBlock(ModBlocks.salt_grass));
                    world.setBlock(i, j - 1, k, ModBlocks.salt_dirt_lite, 0, 2);
                }
                entity.eatGrassBonus();
            }
        }
    }
}
