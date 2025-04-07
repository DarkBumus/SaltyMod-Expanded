package darkbum.saltymod.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import darkbum.saltymod.init.ModBlocks;

public class EntityAICustomEatGrass extends EntityAIBase {

    private final EntityLiving field_151500_b;
    private final World field_151501_c;
    int field_151502_a;

    public EntityAICustomEatGrass(EntityLiving entityLiving) {
        this.field_151500_b = entityLiving;
        this.field_151501_c = entityLiving.worldObj;
        this.setMutexBits(7);
    }

    public boolean shouldExecute() {
        if (this.field_151500_b.getRNG()
            .nextInt(this.field_151500_b.isChild() ? 50 : 1000) != 0) {
            return false;
        } else {
            int i = MathHelper.floor_double(this.field_151500_b.posX);
            int j = MathHelper.floor_double(this.field_151500_b.posY);
            int k = MathHelper.floor_double(this.field_151500_b.posZ);
            return this.field_151501_c.getBlock(i, j, k) == Blocks.tallgrass
                && this.field_151501_c.getBlockMetadata(i, j, k) == 1
                || this.field_151501_c.getBlock(i, j - 1, k) == ModBlocks.salt_grass;
        }
    }

    public void startExecuting() {
        this.field_151502_a = 40;
        this.field_151501_c.setEntityState(this.field_151500_b, (byte) 10);
        this.field_151500_b.getNavigator()
            .clearPathEntity();
    }

    public void resetTask() {
        this.field_151502_a = 0;
    }

    public boolean continueExecuting() {
        return this.field_151502_a > 0;
    }

    public int func_151499_f() {
        return this.field_151502_a;
    }

    public void updateTask() {
        this.field_151502_a = Math.max(0, this.field_151502_a - 1);

        if (this.field_151502_a == 4) {
            int i = MathHelper.floor_double(this.field_151500_b.posX);
            int j = MathHelper.floor_double(this.field_151500_b.posY);
            int k = MathHelper.floor_double(this.field_151500_b.posZ);

            if (this.field_151501_c.getBlock(i, j, k) == Blocks.tallgrass) {
                if (this.field_151501_c.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing")) {
                    this.field_151501_c.func_147480_a(i, j, k, false);
                }

                this.field_151500_b.eatGrassBonus();
            } else if (this.field_151501_c.getBlock(i, j - 1, k) == Blocks.grass) {
                if (this.field_151501_c.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing")) {
                    this.field_151501_c.playAuxSFX(2001, i, j - 1, k, Block.getIdFromBlock(ModBlocks.salt_grass));
                    this.field_151501_c.setBlock(i, j - 1, k, ModBlocks.salt_dirt_lite, 0, 2);
                }

                this.field_151500_b.eatGrassBonus();
            }
        }
    }
}
