package ru.liahim.saltmod.inventory.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiExtractorButton extends GuiButton {
  private final ResourceLocation res;
  
  protected GuiExtractorButton(ResourceLocation res, int id, int xpos, int ypos) {
    super(id, xpos, ypos, 3, 3, "");
    this.res = res;
  }
  
  public void drawButton(Minecraft mc, int w, int h) {
    if (this.visible) {
      mc.getTextureManager().bindTexture(this.res);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146123_n = (w >= this.xPosition && h >= this.yPosition && w < this.xPosition + this.width && h < this.yPosition + this.height);
      if (this.enabled && this.field_146123_n)
        drawTexturedModalRect(this.xPosition, this.yPosition, 190, 0, this.width, this.height); 
    } 
  }
}