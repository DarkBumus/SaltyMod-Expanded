package darkbum.saltymod.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import darkbum.saltymod.inventory.container.ContainerFishFarm;
import darkbum.saltymod.tileentity.TileEntityFishFarm;

public class GuiFishFarm extends GuiContainer {

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod:textures/gui/container/fish_farm.png");

    public GuiFishFarm(InventoryPlayer inventoryPlayer, TileEntityFishFarm tileEntityFishFarm) {
        super(new ContainerFishFarm(inventoryPlayer, tileEntityFishFarm));
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String string = I18n.format("container.fish_farm");
        this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}
