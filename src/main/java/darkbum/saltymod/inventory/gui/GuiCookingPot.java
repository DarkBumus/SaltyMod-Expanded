package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.inventory.container.ContainerCookingPot;
import darkbum.saltymod.tileentity.TileEntityCookingPot;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import static darkbum.saltymod.inventory.container.ContainerCookingPot.SLOT_OUTPUT;

public class GuiCookingPot extends GuiContainer {

    private final TileEntityCookingPot tileEntityCookingPot;

    Slot slotCookingPotOutputLocked = inventorySlots.getSlot(SLOT_OUTPUT);

    private static final ResourceLocation resourceLocation = new ResourceLocation("saltymod", "textures/gui/container/cooking_pot.png");

    public GuiCookingPot(InventoryPlayer par1InventoryPlayer, TileEntityCookingPot par2TileEntityCookingPot) {
        super(new ContainerCookingPot(par1InventoryPlayer, par2TileEntityCookingPot));
        tileEntityCookingPot = par2TileEntityCookingPot;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String string = I18n.format("container.cooking_pot");
        fontRendererObj.drawString(string, xSize / 2 - fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(resourceLocation);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        if (tileEntityCookingPot.isRunning()) {
            int progress = tileEntityCookingPot.getCookProgressScale(24);
            drawTexturedModalRect(x + 89, y + 25, 176, 14, progress + 1, 17);  // Höhe jetzt 17, nicht 16
        }

        if (tileEntityCookingPot.isHeaterBelow) {
            drawTexturedModalRect(x + 49, y + 54, 176, 0, 14, 14);
        }

        if (slotCookingPotOutputLocked != null && !slotCookingPotOutputLocked.canTakeStack(mc.thePlayer) && slotCookingPotOutputLocked.getHasStack()) {
            drawTexturedModalRect(x + 137, y + 22, 176, 31, 7, 7);
        }
    }
}
