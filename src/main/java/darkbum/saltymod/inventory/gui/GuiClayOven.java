package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerClayOven;
import darkbum.saltymod.tileentity.TileEntityClayOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import static darkbum.saltymod.inventory.container.ContainerClayOven.SLOT_OUTPUT;

public class GuiClayOven extends GuiContainer {

    private final TileEntityClayOven tileEntityClayOven;

    Slot slotClayOvenOutputLocked = inventorySlots.getSlot(SLOT_OUTPUT);

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod", "textures/gui/container/clay_oven.png");

    public GuiClayOven(InventoryPlayer inventoryPlayer, TileEntityClayOven tileEntityClayOven) {
        super(new ContainerClayOven(inventoryPlayer, tileEntityClayOven));
        this.tileEntityClayOven = tileEntityClayOven;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String string = I18n.format("container.clay_oven");
        fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if (this.tileEntityClayOven.isRunning()) {
            int progress = this.tileEntityClayOven.getBakeProgressScale(24);
            drawTexturedModalRect(x + 81, y + 25, 176, 14, progress + 1, 17);
        }

        if (this.tileEntityClayOven.isHeaterBelow) {
            drawTexturedModalRect(x + 50, y + 54, 176, 0, 14, 14);
        }

        if (slotClayOvenOutputLocked != null && !this.slotClayOvenOutputLocked.canTakeStack(mc.thePlayer) && slotClayOvenOutputLocked.getHasStack()) {
            drawTexturedModalRect(x + 129, y + 22, 176, 31, 7, 7);
        }
    }
}
