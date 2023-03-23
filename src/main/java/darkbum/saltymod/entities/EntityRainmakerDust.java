package darkbum.saltymod.entities;

import darkbum.saltymod.api.RainMakerEvent;
import darkbum.saltymod.init.SaltConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityRainmakerDust extends Entity {
    private int lifeTime;

    private boolean rain = false;

    private EntityPlayer player;

    private int cloud = SaltConfig.cloudLevel.containsKey(this.worldObj.provider.dimensionId) ? SaltConfig.cloudLevel
        .get(this.worldObj.provider.dimensionId) : 128;

    public EntityRainmakerDust(World world) {
        super(world);
    }

    public EntityRainmakerDust(World world, double x, double y, double z, EntityPlayer player) {
        super(world);
        setPosition(x, y, z);
        this.player = player;
    }

    protected void entityInit() {}

    public void onUpdate() {
        this.lifeTime++;
        setInvisible(true);
        if (this.lifeTime > 30) {
            double x = this.posX + this.rand.nextGaussian() * this.lifeTime / 25.0D;
            double y = this.posY + this.rand.nextGaussian() * 4.0D - (this.lifeTime / 15);
            double z = this.posZ + this.rand.nextGaussian() * this.lifeTime / 25.0D;
            this.worldObj.spawnParticle("fireworksSpark", x, y, z, 0.0D, 0.0D, 0.0D);
        }
        if (!this.worldObj.isRemote && this.lifeTime > 200 && this.posY >= this.cloud && !this.rain && !this.worldObj.getWorldInfo().isThundering()) {
            if (this.rand.nextInt(5) == 0 || this.worldObj.isRaining()) {
                MinecraftForge.EVENT_BUS.post(new RainMakerEvent(this.worldObj, this.posX, this.posY, this.posZ, this.player, true));
            } else {
                MinecraftForge.EVENT_BUS.post(new RainMakerEvent(this.worldObj, this.posX, this.posY, this.posZ, this.player, false));
            }
            this.rain = true;
        }
        if (this.lifeTime > 250) {
            this.rain = false;
            setDead();
        }
    }

    public void writeEntityToNBT(NBTTagCompound tag) {
        tag.setInteger("Life", this.lifeTime);
        tag.setBoolean("Rain", this.rain);
    }

    public void readEntityFromNBT(NBTTagCompound tag) {
        this.lifeTime = tag.getInteger("Life");
        this.rain = tag.getBoolean("Rain");
    }

    public boolean canAttackWithItem() {
        return false;
    }
}
