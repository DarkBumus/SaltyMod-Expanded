package darkbum.saltmod.inventory.gui;

import darkbum.saltmod.inventory.container.ContainerApiary;
import darkbum.saltmod.tileentities.TileEntityApiary;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiApiary extends GuiContainer {

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltmod", "textures/gui/apiary.png");
    public GuiApiary(InventoryPlayer inventoryPlayer, TileEntityApiary tileentityapiary) {
        super(new ContainerApiary(inventoryPlayer, tileentityapiary));
    }

    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        this.fontRendererObj.drawString("Apiary", 8, 8, 4210752);
        this.fontRendererObj.drawString(
            StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 4, 4210752);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}
