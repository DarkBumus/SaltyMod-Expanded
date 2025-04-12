package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerCookingPot;
import darkbum.saltymod.tileentity.TileEntityCookingPot;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCookingPot extends GuiContainer {

    private TileEntityCookingPot tileEntityCookingPot;

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod", "textures/gui/container/cooking_pot.png");

    public GuiCookingPot(InventoryPlayer par1InventoryPlayer, TileEntityCookingPot par2TileEntityCookingPot) {
        super(new ContainerCookingPot(par1InventoryPlayer, par2TileEntityCookingPot));
        this.tileEntityCookingPot = par2TileEntityCookingPot;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
/*        if (this.tileEntityCookingPot.isRunning()) {
            int progress = this.tileEntityCookingPot.getCookProgressScaled(24);
            drawTexturedModalRect(x + 76, y + 38, 176, 18, progress + 1, 16);
        }*/
    }
}
