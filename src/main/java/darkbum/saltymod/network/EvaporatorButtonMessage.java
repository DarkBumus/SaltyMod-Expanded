package darkbum.saltymod.network;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import darkbum.saltymod.tileentity.TileEntityEvaporator;
import io.netty.buffer.ByteBuf;

/**
 * Message class to handle button interactions for the Evaporator block.
 * This message is sent to the server when a player interacts with a specific button in the Evaporator GUI.
 * It provides the server with the coordinates of the Evaporator to identify which instance to update.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class EvaporatorButtonMessage implements IMessage {

    int x;
    int y;
    int z;

    /**
     * Default constructor required by the network handling system.
     */
    @SuppressWarnings("unused")
    public EvaporatorButtonMessage() {}

    /**
     * Constructs a new message with the specified coordinates.
     *
     * @param x The x-coordinate of the Evaporator block.
     * @param y The y-coordinate of the Evaporator block.
     * @param z The z-coordinate of the Evaporator block.
     */
    public EvaporatorButtonMessage(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Reads the message data from the byte buffer.
     *
     * @param buf The buffer to read from.
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    /**
     * Writes the message data to the byte buffer.
     *
     * @param buf The buffer to write to.
     */
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
    }

    /**
     * Handles the received message on the server side.
     * Clears the fluid tank of the Evaporator at the specified coordinates.
     */
    public static class Handler implements IMessageHandler<EvaporatorButtonMessage, IMessage> {

        /**
         * Processes the received message.
         *
         * @param message The received message containing the Evaporator coordinates.
         * @param context The context of the message, providing server access.
         * @return a response message or null if no response is necessary.
         */
        @Override
        public IMessage onMessage(EvaporatorButtonMessage message, MessageContext context) {
            World world = (context.getServerHandler()).playerEntity.worldObj;
            TileEntity tileEntity = world.getTileEntity(message.x, message.y, message.z);
            if (tileEntity instanceof TileEntityEvaporator) ((TileEntityEvaporator) tileEntity).tank.setFluid(null);
            return null;
        }
    }
}
