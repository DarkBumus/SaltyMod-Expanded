package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.tileentity.TileEntityApiary;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import darkbum.saltymod.inventory.container.ContainerFishFarm;
import darkbum.saltymod.tileentity.TileEntityFishFarm;

public class GuiFishFarm extends GuiContainer {

    private TileEntityFishFarm tileEntityFishFarm;

    private static final ResourceLocation guiTextures = new ResourceLocation(
        "saltymod:textures/gui/container/fish_farm.png");

    public GuiFishFarm(InventoryPlayer inventoryPlayer, TileEntityFishFarm tileEntityFishFarm) {
        super(new ContainerFishFarm(inventoryPlayer, tileEntityFishFarm));
        this.tileEntityFishFarm = tileEntityFishFarm;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.tileEntityFishFarm.hasCustomInventoryName() ? this.tileEntityFishFarm.getInventoryName()
            : I18n.format(this.tileEntityFishFarm.getInventoryName());
        this.fontRendererObj
            .drawString(s, 8, 6, 4210752);
        this.fontRendererObj
            .drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 4, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager()
            .bindTexture(guiTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}
