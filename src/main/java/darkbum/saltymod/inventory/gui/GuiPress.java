package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerPress;
import darkbum.saltymod.tileentity.TileEntityPress;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiPress extends GuiContainer {

    private TileEntityPress tileEntityPress;

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod", "textures/gui/container/press.png");

    public GuiPress(InventoryPlayer par1InventoryPlayer, TileEntityPress par2TileEntityPress) {
        super(new ContainerPress(par1InventoryPlayer, par2TileEntityPress));
        this.tileEntityPress = par2TileEntityPress;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.tileEntityPress.hasCustomInventoryName() ? this.tileEntityPress.getInventoryName()
            : I18n.format(this.tileEntityPress.getInventoryName());
        this.fontRendererObj
            .drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj
            .drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 4, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        if (this.tileEntityPress.isRunning()) {
            int progress = this.tileEntityPress.getCookProgressScaled(24);
            drawTexturedModalRect(x + 76, y + 38, 176, 18, progress + 1, 16);
        }
    }
}
