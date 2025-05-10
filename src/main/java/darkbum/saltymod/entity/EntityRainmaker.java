package darkbum.saltymod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.item.ItemRainmaker;

/**
 * Entity class for the rainmaker entity.
 * The rainmaker is a firework rocket-like entity that flies into the air,
 * explodes and triggers an event that changes the weather, using {@link EntityRainmakerExplosion}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EntityRainmaker extends Entity {

    private int fireworkAge;
    private int lifetime;
    private final EntityPlayer player;

    /**
     * Default constructor required for Minecraft entity instantiation.
     *
     * @param world The world in which the entity exists.
     */
    @SuppressWarnings("unused")
    public EntityRainmaker(World world) {
        this(world, 0, 0, 0, null);
    }

    /**
     * Constructs a new rainmaker entity instance at the specified position with a specified player.
     *
     * @param world The world in which the entity exists.
     * @param x The X-coordinate of the spawn position.
     * @param y The Y-coordinate of the spawn position.
     * @param z The Z-coordinate of the spawn position.
     * @param player The player who initiated the Rainmaker.
     */
    public EntityRainmaker(World world, double x, double y, double z, EntityPlayer player) {
        super(world);
        this.player = player;
        setSize(0.25F, 0.25F);
        setPosition(x, y, z);
        initializeMotion();
        this.lifetime = calculateLifetime();
    }

    /**
     * Initializes data values for the entity.
     */
    @Override
    protected void entityInit() {
        this.dataWatcher.addObjectByDataType(8, 5);
    }

    /**
     * Initializes the entity's motion with a slight random trajectory.
     */
    private void initializeMotion() {
        this.motionX = this.rand.nextGaussian() * 0.0005;
        this.motionZ = this.rand.nextGaussian() * 0.0005;
        this.motionY = 0.05;
    }

    /**
     * Calculates the lifetime of the entity in ticks.
     *
     * @return the lifetime in ticks.
     */
    private int calculateLifetime() {
        return 45 + this.rand.nextInt(13);
    }

    /**
     * Updates the entity's state every tick. Handles movement, particle effects,
     * and entity death when the lifetime is reached.
     */
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();

        this.motionX *= 1.15D;
        this.motionZ *= 1.15D;
        this.motionY += 0.04D;
        moveEntity(this.motionX, this.motionY, this.motionZ);

        float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
        this.rotationPitch = (float) (Math.atan2(this.motionY, f) * 180.0D / Math.PI);

        if (this.fireworkAge == 1 && !this.worldObj.isRemote) {
            this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0F, 1.0F);
        }

        if (this.worldObj.isRemote && this.fireworkAge < this.lifetime) {
            double particleX = this.posX + this.rand.nextGaussian() * 0.05D;
            double particleY = this.posY - 0.3D;
            double particleZ = this.posZ + this.rand.nextGaussian() * 0.05D;
            double velocityX = this.rand.nextGaussian() * 0.05D;
            double velocityY = -this.motionY * 0.5D;
            double velocityZ = this.rand.nextGaussian() * 0.05D;

            this.worldObj.spawnParticle("fireworksSpark", particleX, particleY, particleZ, velocityX, velocityY, velocityZ);
        }

        this.fireworkAge++;

        if (!this.worldObj.isRemote && this.fireworkAge >= this.lifetime) {
            this.worldObj.setEntityState(this, (byte) 17);

            EntityRainmakerExplosion dust = new EntityRainmakerExplosion(this.worldObj, this.posX, this.posY, this.posZ, this.player);
            this.worldObj.spawnEntityInWorld(dust);

            setDead();
        }
    }

    /**
     * Handles client-side updates based on entity state.
     *
     * @param stateByte The state byte received from the server.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void handleHealthUpdate(byte stateByte) {
        if (stateByte == 17) {
            if (this.worldObj.isRemote) {
                this.worldObj.playSound(this.posX, this.posY, this.posZ, "fireworks.blast", 3.0F, 1.0F, false);

                this.worldObj.makeFireworks(
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.motionX,
                    this.motionY,
                    this.motionZ,
                    ItemRainmaker.tag
                );
            }
        }
        super.handleHealthUpdate(stateByte);
    }

    /**
     * Writes the entity's data to NBT.
     *
     * @param tag The NBT tag to write to.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        tag.setInteger("Life", this.fireworkAge);
        tag.setInteger("LifeTime", this.lifetime);
    }

    /**
     * Reads the entity's data from NBT.
     *
     * @param tag The NBT tag to read from.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        this.fireworkAge = tag.getInteger("Life");
        this.lifetime = tag.getInteger("LifeTime");
    }

    /**
     * Whether the entity can be attacked with an item.
     *
     * @return false, as the rainmaker is not a combat entity.
     */
    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    /**
     * Returns the shadow size of the entity.
     *
     * @return 0.0F, as the rainmaker has no visible shadow.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public float getShadowSize() {
        return 0.0F;
    }
}
