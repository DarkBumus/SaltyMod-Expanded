package darkbum.saltymod.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import darkbum.saltymod.inventory.container.ContainerApiary;
import darkbum.saltymod.tileentity.TileEntityApiary;

public class GuiApiary extends GuiContainer {

    private static final ResourceLocation guiTextures = new ResourceLocation(
        "saltymod:textures/gui/container/apiary.png");

    private final TileEntityApiary tileEntityApiary;

    public GuiApiary(InventoryPlayer inventoryPlayer, TileEntityApiary tileEntityApiary) {
        super(new ContainerApiary(inventoryPlayer, tileEntityApiary));
        this.tileEntityApiary = tileEntityApiary;
    }

    protected void drawGuiContainerForegroundLayer(int par_1, int par_2) {
        String s = this.tileEntityApiary.hasCustomInventoryName() ? this.tileEntityApiary.getInventoryName()
            : I18n.format(this.tileEntityApiary.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 4, 4210752);
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
