package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerCookingPot;
import darkbum.saltymod.tileentity.TileEntityCookingPot;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import static darkbum.saltymod.inventory.container.ContainerCookingPot.SLOT_OUTPUT;

public class GuiCookingPot extends GuiContainer {

    private TileEntityCookingPot tileEntityCookingPot;

    Slot slotCookingPotOutputLocked = inventorySlots.getSlot(SLOT_OUTPUT);

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod", "textures/gui/container/cooking_pot.png");

    public GuiCookingPot(InventoryPlayer par1InventoryPlayer, TileEntityCookingPot par2TileEntityCookingPot) {
        super(new ContainerCookingPot(par1InventoryPlayer, par2TileEntityCookingPot));
        this.tileEntityCookingPot = par2TileEntityCookingPot;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.tileEntityCookingPot.hasCustomInventoryName() ? this.tileEntityCookingPot.getInventoryName()
            : I18n.format(this.tileEntityCookingPot.getInventoryName());
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

        if (this.tileEntityCookingPot.isRunning()) {
            int progress = this.tileEntityCookingPot.getCookProgressScale(24);
            drawTexturedModalRect(x + 89, y + 25, 176, 14, progress + 1, 17);  // Höhe jetzt 17, nicht 16
        }

        if (this.tileEntityCookingPot.isHeaterBelow) {
            drawTexturedModalRect(x + 49, y + 54, 176, 0, 14, 14);
        }

        if (slotCookingPotOutputLocked != null && !this.slotCookingPotOutputLocked.canTakeStack(mc.thePlayer) && slotCookingPotOutputLocked.getHasStack()) {
            drawTexturedModalRect(x + 137, y + 22, 176, 31, 7, 7);
        }
    }
}
