package darkbum.saltymod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class RainMakerEvent extends Event {

    public final World world;

    public final double x;

    public final double y;

    public final double z;

    public final EntityPlayer player;

    public final boolean isThunder;

    public RainMakerEvent(World world, double x, double y, double z, EntityPlayer player, boolean isThunder) {
        this.world = world;
        this.x = z;
        this.y = y;
        this.z = z;
        this.player = player;
        this.isThunder = isThunder;
    }
}
