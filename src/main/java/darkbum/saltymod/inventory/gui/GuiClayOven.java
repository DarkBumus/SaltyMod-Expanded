package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerClayOven;
import darkbum.saltymod.tileentity.TileEntityClayOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Collections;

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
        fontRendererObj.drawString(string, xSize / 2 - fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(resourceLocation);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        if (tileEntityClayOven.isRunning()) {
            int progress = tileEntityClayOven.getBakeProgressScale(24);
            drawTexturedModalRect(x + 81, y + 25, 176, 14, progress + 1, 17);
        }

        if (tileEntityClayOven.isHeaterBelow) {
            drawTexturedModalRect(x + 50, y + 54, 176, 0, 14, 14);
        }

        if (slotClayOvenOutputLocked != null && !slotClayOvenOutputLocked.canTakeStack(mc.thePlayer) && slotClayOvenOutputLocked.getHasStack()) {
            drawTexturedModalRect(x + 129, y + 22, 176, 31, 7, 7);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        if (slotClayOvenOutputLocked != null
            && !slotClayOvenOutputLocked.canTakeStack(mc.thePlayer)
            && slotClayOvenOutputLocked.getHasStack()
            && mouseX >= x + 129 && mouseX < x + 136
            && mouseY >= y + 22 && mouseY < y + 29) {

            String tooltip = I18n.format("container.clay_oven.output_locked");

            drawHoveringText(
                Collections.singletonList(tooltip),
                mouseX,
                mouseY,
                fontRendererObj
            );
        }
    }
}
