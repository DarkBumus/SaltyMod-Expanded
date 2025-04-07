package darkbum.saltymod.network;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import darkbum.saltymod.tileentity.TileEntityEvaporator;
import io.netty.buffer.ByteBuf;

public class EvaporatorButtonMessage implements IMessage {

    int x;

    int y;

    int z;

    public EvaporatorButtonMessage() {}

    public EvaporatorButtonMessage(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
    }

    public static class Handler implements IMessageHandler<EvaporatorButtonMessage, IMessage> {

        public IMessage onMessage(EvaporatorButtonMessage message, MessageContext ctx) {
            World world = (ctx.getServerHandler()).playerEntity.worldObj;
            TileEntity te = world.getTileEntity(message.x, message.y, message.z);
            if (te instanceof TileEntityEvaporator) ((TileEntityEvaporator) te).tank.setFluid(null);
            return null;
        }
    }
}
