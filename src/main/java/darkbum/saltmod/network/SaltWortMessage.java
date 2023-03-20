package darkbum.saltmod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.init.ModBlocks;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityFlowerPot;

public class SaltWortMessage implements IMessage {
    int x;

    int y;

    int z;

    int i;

    public SaltWortMessage() {}

    public SaltWortMessage(int x, int y, int z, int i) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.i = i;
    }

    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.i = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
        buf.writeInt(this.i);
    }

    public static class Handler implements IMessageHandler<SaltWortMessage, IMessage> {
        public IMessage onMessage(SaltWortMessage message, MessageContext ctx) {
            SaltWortMessage.act(message.x, message.y, message.z, message.i);
            return null;
        }
    }

    @SideOnly(Side.CLIENT)
    private static void act(int x, int y, int z, int i) {
        WorldClient world = (Minecraft.getMinecraft()).theWorld;
        if (world.getTileEntity(x, y, z) != null && world
            .getTileEntity(x, y, z) instanceof TileEntityFlowerPot) {
            TileEntityFlowerPot te = (TileEntityFlowerPot)world.getTileEntity(x, y, z);
            te.func_145964_a(Item.getItemFromBlock(ModBlocks.saltworts), i);
            world.markBlockForUpdate(x, y, z);
        }
    }
}
