package darkbum.saltymod.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import darkbum.saltymod.inventory.container.ContainerApiary;
import darkbum.saltymod.tileentity.TileEntityApiary;

public class GuiApiary extends GuiContainer {

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod:textures/gui/container/apiary.png");

    public GuiApiary(InventoryPlayer inventoryPlayer, TileEntityApiary tileEntityApiary) {
        super(new ContainerApiary(inventoryPlayer, tileEntityApiary));
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String string = I18n.format("container.apiary");
        fontRendererObj.drawString(string, xSize / 2 - fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(resourceLocation);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
