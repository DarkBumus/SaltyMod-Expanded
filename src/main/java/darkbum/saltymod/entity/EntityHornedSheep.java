package darkbum.saltymod.entity;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;

public class EntityHornedSheep extends EntitySheep {

    public EntityHornedSheep(World world) {
        super(world);
        setSize(0.9F, 1.3F);
    }

    public EntityHornedSheep(World world, double x, double y, double z) {
        this(world);
        setPosition(x, y, z);
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

    public EntitySheep createChild(EntityAgeable entityanimal) {
        EntityHornedSheep otherParent = (EntityHornedSheep) entityanimal;
        EntityHornedSheep babySheep = new EntityHornedSheep(this.worldObj);
        if (this.rand.nextBoolean()) {
            babySheep.setFleeceColor(getFleeceColor());
        } else {
            babySheep.setFleeceColor(otherParent.getFleeceColor());
        }
        return babySheep;
    }
}
