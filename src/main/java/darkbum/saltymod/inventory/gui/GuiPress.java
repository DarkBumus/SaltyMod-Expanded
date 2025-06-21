package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerPress;
import darkbum.saltymod.tileentity.TileEntityPress;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiPress extends GuiContainer {

    private final TileEntityPress tileEntityPress;

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod:textures/gui/container/press.png");

    public GuiPress(InventoryPlayer par1InventoryPlayer, TileEntityPress par2TileEntityPress) {
        super(new ContainerPress(par1InventoryPlayer, par2TileEntityPress));
        tileEntityPress = par2TileEntityPress;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String string = I18n.format("container.press");
        fontRendererObj.drawString(string, xSize / 2 - fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(resourceLocation);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        if (tileEntityPress.isRunning()) {
            int progress = tileEntityPress.getPressProgressScale(16);

            drawTexturedModalRect(x + 73, y + 36, 176, 14, progress, 14);
            drawTexturedModalRect(x + 88 + (15 - progress), y + 36, 191 + (15 - progress), 14, progress, 14);
        }

        if (tileEntityPress.isHeaterNearby) {
            drawTexturedModalRect(x + 63, y + 18, 176, 0, 14, 14);
        }

        if (tileEntityPress.isMillNearby) {
            drawTexturedModalRect(x + 99, y + 18, 190, 0, 14, 14);
        }
    }
}
