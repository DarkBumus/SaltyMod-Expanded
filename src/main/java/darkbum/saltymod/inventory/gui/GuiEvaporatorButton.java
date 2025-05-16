package darkbum.saltymod.inventory.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiEvaporatorButton extends GuiButton {

    private final ResourceLocation res;

    protected GuiEvaporatorButton(ResourceLocation res, int id, int xpos, int ypos) {
        super(id, xpos, ypos, 3, 3, "");
        this.res = res;
    }

    public void drawButton(Minecraft mc, int w, int h) {
        if (visible) {
            mc.getTextureManager().bindTexture(res);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            field_146123_n = (w >= xPosition && h >= yPosition && w < xPosition + width && h < yPosition + height);
            if (enabled && field_146123_n)
                drawTexturedModalRect(xPosition, yPosition, 190, 0, width, height);
        }
    }
}
