package darkbum.saltymod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.item.ItemRainmaker;

public class EntityRainmaker extends Entity {

    private int fireworkAge;

    private int lifetime;

    private EntityPlayer player;

    public EntityRainmaker(World world) {
        super(world);
        setSize(0.25F, 0.25F);
    }

    protected void entityInit() {
        this.dataWatcher.addObjectByDataType(8, 5);
    }

    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return (distance < 4096.0D);
    }

    public EntityRainmaker(World world, double x, double y, double z, EntityPlayer player) {
        super(world);
        this.fireworkAge = 0;
        this.player = player;
        setSize(0.25F, 0.25F);
        setPosition(x, y, z);
        this.yOffset = 0.0F;
        this.motionX = this.rand.nextGaussian() * 5.0E-4D;
        this.motionZ = this.rand.nextGaussian() * 5.0E-4D;
        this.motionY = 0.05D;
        this.lifetime = 45 + this.rand.nextInt(6) + this.rand.nextInt(7);
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z) {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(x * x + z * z);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(x, z) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(y, f) * 180.0D / Math.PI);
        }
    }

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
        for (this.rotationPitch = (float) (Math.atan2(this.motionY, f) * 180.0D / Math.PI); this.rotationPitch
            - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
        while (this.rotationPitch - this.prevRotationPitch >= 180.0F) this.prevRotationPitch += 360.0F;
        while (this.rotationYaw - this.prevRotationYaw < -180.0F) this.prevRotationYaw -= 360.0F;
        while (this.rotationYaw - this.prevRotationYaw >= 180.0F) this.prevRotationYaw += 360.0F;
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        if (this.fireworkAge == 0) this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0F, 1.0F);
        this.fireworkAge++;
        if (this.worldObj.isRemote && this.fireworkAge % 2 < 2) this.worldObj.spawnParticle(
            "fireworksSpark",
            this.posX,
            this.posY - 0.3D,
            this.posZ,
            this.rand.nextGaussian() * 0.05D,
            -this.motionY * 0.5D,
            this.rand.nextGaussian() * 0.05D);
        if (!this.worldObj.isRemote && this.fireworkAge > this.lifetime) {
            this.worldObj.setEntityState(this, (byte) 17);
            EntityRainmakerDust dust = new EntityRainmakerDust(
                this.worldObj,
                this.posX,
                this.posY,
                this.posZ,
                this.player);
            this.worldObj.spawnEntityInWorld(dust);
            setDead();
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par_byte) {
        if (par_byte == 17 && this.worldObj.isRemote) this.worldObj.makeFireworks(
            this.posX,
            this.posY,
            this.posZ,
            this.motionX,
            this.motionY,
            this.motionZ,
            ItemRainmaker.tag);
        super.handleHealthUpdate(par_byte);
    }

    public void writeEntityToNBT(NBTTagCompound tag) {
        tag.setInteger("Life", this.fireworkAge);
        tag.setInteger("LifeTime", this.lifetime);
    }

    public void readEntityFromNBT(NBTTagCompound tag) {
        this.fireworkAge = tag.getInteger("Life");
        this.lifetime = tag.getInteger("LifeTime");
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0F;
    }

    public float getBrightness(float bright) {
        return super.getBrightness(bright);
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float bright) {
        return super.getBrightnessForRender(bright);
    }

    public boolean canAttackWithItem() {
        return false;
    }
}
