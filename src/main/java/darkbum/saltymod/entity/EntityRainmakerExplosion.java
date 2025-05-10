package darkbum.saltymod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import darkbum.saltymod.util.RainMakerEvent;
import darkbum.saltymod.common.config.ModConfigurationOther;

/**
 * Entity class for the rainmaker explosion entity.
 * The rainmaker explosion is the entity that handles the weather change event mentioned in {@link EntityRainmaker}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EntityRainmakerExplosion extends Entity {

    private int lifeTime;
    private boolean rain = false;
    private final EntityPlayer player;
    private final int cloudLevel;

    /**
     * Default constructor required for Minecraft entity instantiation.
     *
     * @param world The world in which the entity exists.
     */
    @SuppressWarnings("unused")
    public EntityRainmakerExplosion(World world) {
        this(world, 0, 0, 0, null);
    }

    /**
     * Constructs a new rainmaker explosion entity instance at the specified position with a specified player.
     *
     * @param world The world in which the entity exists.
     * @param x The X-coordinate of the spawn position.
     * @param y The Y-coordinate of the spawn position.
     * @param z The Z-coordinate of the spawn position.
     * @param player The player who initiated the Rainmaker.
     */
    public EntityRainmakerExplosion(World world, double x, double y, double z, EntityPlayer player) {
        super(world);
        this.player = player;
        setPosition(x, y, z);
        this.cloudLevel = ModConfigurationOther.cloudLevel.getOrDefault(world.provider.dimensionId, 128);
    }

    /**
     * Initializes the data watcher. Unused in this implementation.
     */
    @Override
    protected void entityInit() {
    }

    /**
     * Updates the entity every tick. Handles particle effects, weather event triggering,
     * and entity removal after a certain lifetime.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.lifeTime++;
        setInvisible(true);

        handleParticleEffect();
        handleWeatherEffect();
        checkEntityLifetime();
    }

    /**
     * Generates particle effects after the entity's lifetime exceeds 30 ticks.
     * The particles simulate fireworks spark effects.
     */
    private void handleParticleEffect() {
        if (this.lifeTime <= 30 || this.worldObj.isRemote) return;

        double particleX = this.posX + this.rand.nextGaussian() * this.lifeTime / 25.0;
        double particleY = this.posY + this.rand.nextGaussian() * 4.0 - (this.lifeTime / 15.0);
        double particleZ = this.posZ + this.rand.nextGaussian() * this.lifeTime / 25.0;

        this.worldObj.spawnParticle("fireworksSpark", particleX, particleY, particleZ, 0.0, 0.0, 0.0);
    }

    /**
     * Checks whether the entity has reached the cloud level and triggers a rain event if the conditions are met.
     * The event is only triggered once and is based on a random chance to produce thunder.
     */
    private void handleWeatherEffect() {
        if (this.worldObj.isRemote || this.rain || this.lifeTime <= 200 || this.posY < this.cloudLevel) return;

        boolean isRaining = this.worldObj.isRaining();
        boolean isThunder = this.rand.nextInt(5) == 0 || isRaining;

        MinecraftForge.EVENT_BUS.post(new RainMakerEvent(this.worldObj, this.posX, this.posY, this.posZ, this.player, isThunder));

        this.rain = true;
    }

    /**
     * Writes the entity's state to NBT.
     *
     * @param tag The NBTTagCompound to write to.
     */
    @Override
    protected void writeEntityToNBT(NBTTagCompound tag) {
        tag.setInteger("Life", this.lifeTime);
        tag.setBoolean("Rain", this.rain);
    }

    /**
     * Reads the entity's state from NBT.
     *
     * @param tag The NBTTagCompound to read from.
     */
    @Override
    protected void readEntityFromNBT(NBTTagCompound tag) {
        this.lifeTime = tag.getInteger("Life");
        this.rain = tag.getBoolean("Rain");
    }

    /**
     * Checks the entity's lifetime and removes it if it exceeds the defined limit.
     */
    private void checkEntityLifetime() {
        if (this.lifeTime > 250) {
            this.rain = false;
            setDead();
        }
    }

    /**
     * Whether the entity can be attacked with an item.
     *
     * @return false, as the rainmaker explosion is not a combat entity.
     */
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
}
