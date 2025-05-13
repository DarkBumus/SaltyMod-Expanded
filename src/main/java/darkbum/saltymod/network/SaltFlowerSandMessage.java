package darkbum.saltymod.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityFlowerPot;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModBlocks;
import io.netty.buffer.ByteBuf;

/**
 * Message class to update a Flower Pot (`TileEntityFlowerPot`) with a Saltwort item on the client side.
 * This message is sent from the server to the client to synchronize the contents of a Flower Pot with Salt Flowers.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class SaltFlowerSandMessage implements IMessage {

    int x;
    int y;
    int z;
    int i;

    /**
     * Default constructor required by the network handling system.
     */
    @SuppressWarnings("unused")
    public SaltFlowerSandMessage() {}

    /**
     * Constructs a new SaltFlowerSandMessage with specified coordinates and metadata value.
     *
     * @param x The x-coordinate of the Flower Pot tile entity.
     * @param y The y-coordinate of the Flower Pot tile entity.
     * @param z The z-coordinate of the Flower Pot tile entity.
     * @param i The metadata value of the Saltwort item.
     */
    public SaltFlowerSandMessage(int x, int y, int z, int i) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.i = i;
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
        this.i = buf.readInt();
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
        buf.writeInt(this.i);
    }

    /**
     * Handles the received SaltFlowerSandMessage on the client side.
     * Updates the specified Flower Pot to contain a Saltwort item with the specified metadata value.
     */
    public static class Handler implements IMessageHandler<SaltFlowerSandMessage, IMessage> {

        /**
         * Processes the received message.
         *
         * @param message The received SaltFlowerSandMessage containing the Flower Pot coordinates and metadata value.
         * @param context     The context of the message, providing client-side access.
         * @return A response message or null if no response is necessary.
         */
        @Override
        public IMessage onMessage(SaltFlowerSandMessage message, MessageContext context) {
            SaltFlowerSandMessage.act(message.x, message.y, message.z, message.i);
            return null;
        }
    }

    /**
     * Updates the Flower Pot at the specified coordinates to contain the Saltwort item.
     * This method is client-side only and is called when the SaltFlowerSandMessage is received.
     *
     * @param x The x-coordinate of the Flower Pot tile entity.
     * @param y The y-coordinate of the Flower Pot tile entity.
     * @param z The z-coordinate of the Flower Pot tile entity.
     * @param i The metadata value of the Saltwort item.
     */
    @SideOnly(Side.CLIENT)
    private static void act(int x, int y, int z, int i) {
        WorldClient world = (Minecraft.getMinecraft()).theWorld;
        if (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityFlowerPot tileEntity) {
            tileEntity.func_145964_a(Item.getItemFromBlock(ModBlocks.salt_flower_s), i);
            world.markBlockForUpdate(x, y, z);
        }
    }
}
