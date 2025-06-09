package darkbum.saltymod.entity;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import darkbum.saltymod.init.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import static darkbum.saltymod.init.ModEntities.*;

/**
 * Entity class for the horned sheep entity.
 * The horned sheep is a sheep copy with horns.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EntityHornedSheep extends EntitySheep {

    /**
     * Constructs a new horned sheep entity instance.
     *
     * @param world The world in which the entity exists.
     */
    public EntityHornedSheep(World world) {
        super(world);
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Item.getItemFromBlock(ModBlocks.marsh_reeds_b), false));
    }

    /**
     * Sets up the entity's attributes, including health.
     */
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
    }

    /**
     * Generates a random fleece color for the sheep with a weighted probability distribution.
     *
     * @param random The random instance used for generating the fleece color.
     * @return the generated fleece color ID.
     */
    public static int getRandomFleeceColor(Random random) {
        int i = random.nextInt(100);
        return i < 5 ? 15 : (i < 10 ? 7 : (i < 15 ? 8 : (i < 18 ? 12 : (random.nextInt(500) == 0 ? 6 : 0))));
    }

    /**
     * Called when the entity is spawned using a spawn egg. Assigns a random fleece color.
     *
     * @param iEntityLivingData The initial spawn data for the entity.
     * @return the modified spawn data after applying the fleece color.
     */
    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
        iEntityLivingData = super.onSpawnWithEgg(iEntityLivingData);
        this.setFleeceColor(getRandomFleeceColor(this.worldObj.rand));
        return iEntityLivingData;
    }

    /**
     * Determines whether the provided item stack can be used to breed the sheep.
     *
     * @param itemStack The item stack being checked.
     * @return true if the item is Marsh Reeds; false otherwise.
     */
    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack != null && itemStack.getItem() == Item.getItemFromBlock(ModBlocks.marsh_reeds_b);
    }

    /**
     * Creates a child entity during breeding. The child inherits its fleece color
     * randomly from one of the parents.
     *
     * @param animal The other parent entity.
     * @return a new EntityHornedSheep instance representing the child.
     */
    @Override
    public EntityHornedSheep createChild(EntityAgeable animal) {
        EntityHornedSheep otherParent = (EntityHornedSheep) animal;
        EntityHornedSheep babySheep = new EntityHornedSheep(this.worldObj);
        if (this.rand.nextBoolean()) {
            babySheep.setFleeceColor(getFleeceColor());
        } else {
            babySheep.setFleeceColor(otherParent.getFleeceColor());
        }
        return babySheep;
    }

    /**
     * Returns the sound played when the sheep is alive and idle.
     *
     * @return the living sound identifier.
     */
    @Override
    protected String getLivingSound() {
        return "saltymod:mob.horned_sheep.say";
    }

    /**
     * Returns the sound played when the sheep is hurt.
     *
     * @return the hurt sound identifier.
     */
    @Override
    protected String getHurtSound() {
        return "saltymod:mob.horned_sheep.say";
    }

    /**
     * Returns the sound played when the sheep dies.
     *
     * @return the death sound identifier.
     */
    @Override
    protected String getDeathSound() {
        return "saltymod:mob.horned_sheep.say";
    }


    /**
     * Handles the item drops when the sheep is killed. Drops wool and has a chance to drop horns.
     *
     * @param wasRecentlyHit Whether the sheep was recently hit by a player.
     * @param lootingLevel   The level of Looting applied.
     */
    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingLevel) {
        if (!this.getSheared()) {
            this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, this.getFleeceColor()),
                0.0F
            );
            if (this.rand.nextFloat() < 0.5F) {
                this.dropItem(ModItems.sheep_horn, 1);
            }
        }
    }

    /**
     * Returns the spawn egg ItemStack corresponding to this entity when middle-clicked in creative mode.
     * Uses the entity's registered spawn egg metadata from ModEntities.
     *
     * @param target The targeted block or entity under the cursor.
     * @return an ItemStack of the spawn egg with the correct metadata for this entity, or null if none is registered.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getPickedResult(MovingObjectPosition target) {
        Integer id = getEntityEggId(this.getClass());
        return id != null ? new ItemStack(Items.spawn_egg, 1, id) : null;
    }
}
