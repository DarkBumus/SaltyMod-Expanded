package darkbum.saltymod.entity;

import java.util.Random;

import darkbum.saltymod.init.ModItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHornedSheep extends EntitySheep {

    public EntityHornedSheep(World world) {
        super(world);
        setSize(0.9F, 1.3F);
    }

    public static int getRandomFleeceColor(Random random) {
        int i = random.nextInt(100);
        return i < 5 ? 15 : (i < 10 ? 7 : (i < 15 ? 8 : (i < 18 ? 12 : (random.nextInt(500) == 0 ? 6 : 0))));
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
        iEntityLivingData = super.onSpawnWithEgg(iEntityLivingData);
        this.setFleeceColor(getRandomFleeceColor(this.worldObj.rand));
        return iEntityLivingData;
    }

    public EntityHornedSheep createChild(EntityAgeable entityanimal) {
        EntityHornedSheep otherParent = (EntityHornedSheep) entityanimal;
        EntityHornedSheep babySheep = new EntityHornedSheep(this.worldObj);
        if (this.rand.nextBoolean()) {
            babySheep.setFleeceColor(getFleeceColor());
        } else {
            babySheep.setFleeceColor(otherParent.getFleeceColor());
        }
        return babySheep;
    }

/*    protected String getLivingSound() {
        return "saltymod:mob.horned_sheep.say";
    }


    protected String getHurtSound() {
        return "saltymod:mob.horned_sheep.say";
    }


    protected String getDeathSound() {
        return "saltymod:mob.horned_sheep.say";
    }*/

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingLevel) {
        if (!this.getSheared()) {
            this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, this.getFleeceColor()),
                0.0F
            );
            if (this.rand.nextFloat() < 0.5F) {
                this.dropItem(ModItems.horn, 1);
            }
        }
    }
}
