package darkbum.saltymod.inventory.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.inventory.container.ContainerEvaporator;
import darkbum.saltymod.network.EvaporatorButtonMessage;
import darkbum.saltymod.tileentity.TileEntityEvaporator;

@SideOnly(Side.CLIENT)
public class GuiEvaporator extends GuiContainer {

    private static final ResourceLocation guiTextures = new ResourceLocation(
        "saltymod:textures/gui/container/evaporator.png");

    private TileEntityEvaporator tileEntityEvaporator;

    private GuiEvaporatorButton button;

    public GuiEvaporator(InventoryPlayer player, TileEntityEvaporator tileEntityEvaporator) {
        super(new ContainerEvaporator(player, tileEntityEvaporator));
        this.tileEntityEvaporator = tileEntityEvaporator;
    }

    public void initGui() {
        super.initGui();
        this.buttonList.add(this.button = new GuiEvaporatorButton(guiTextures, 1, this.guiLeft + 97, this.guiTop + 16));
        this.button.enabled = false;
    }

    public void updateScreen() {
        super.updateScreen();
        this.button.enabled = (this.tileEntityEvaporator.liquidLevel > 0);
    }

    protected void actionPerformed(GuiButton button) {
        CommonProxy.network.sendToServer(new EvaporatorButtonMessage(this.tileEntityEvaporator.xCoord, this.tileEntityEvaporator.yCoord, this.tileEntityEvaporator.zCoord));
    }

    protected void drawGuiContainerForegroundLayer(int par_1, int par_2) {
        String s = this.tileEntityEvaporator.hasCustomInventoryName() ? this.tileEntityEvaporator.getInventoryName()
            : I18n.format(this.tileEntityEvaporator.getInventoryName());
        this.fontRendererObj
            .drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par_1, int par_2, int par_3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager()
            .bindTexture(guiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (this.tileEntityEvaporator.isBurning()) {
            int i1 = this.tileEntityEvaporator.getBurnTimeRemainingScaled(13);
            drawTexturedModalRect(k + 71, l + 54 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        }
        if (this.tileEntityEvaporator.liquidLevel > 0) {
            int i1 = this.tileEntityEvaporator.getEvaporateProgressScaled(17);
            drawTexturedModalRect(k + 96, l + 36, 176, 14, i1 + 1, 10);
        }
        if (this.tileEntityEvaporator.pressure > 0)
            drawTexturedModalRect(k + 59, l + 32 - this.tileEntityEvaporator.pressure, 176, 40 - this.tileEntityEvaporator.pressure, 1, this.tileEntityEvaporator.pressure);
        if (this.tileEntityEvaporator.getFluidAmountScaledClient(32) > 0) {
            drawTank(
                k,
                l,
                62,
                17,
                32,
                this.tileEntityEvaporator.getFluidAmountScaledClient(32),
                new FluidStack(this.tileEntityEvaporator.liquidID, this.tileEntityEvaporator.liquidLevel));
            this.mc.getTextureManager()
                .bindTexture(guiTextures);
        }
    }

    protected void drawTank(int w, int h, int wp, int hp, int width, int amount, FluidStack fluidstack) {
        if (fluidstack == null) return;
        IIcon icon = null;
        Fluid fluid = fluidstack.getFluid();
        int color = fluid.getColor();
        if (fluid.getStillIcon() != null) icon = fluid.getStillIcon();
        this.mc.getTextureManager()
            .bindTexture(TextureMap.locationBlocksTexture);
        float r = (color >> 16 & 0xFF) / 255.0F;
        float g = (color >> 8 & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        GL11.glColor4f(r, g, b, 1.0F);
        drawTexturedModelRectFromIcon(w + wp, h + hp + 32 - amount, icon, width, amount);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        int w = (this.width - this.xSize) / 2;
        int h = (this.height - this.ySize) / 2;
        if (mouseX >= w + 62 && mouseY >= h + 17 && mouseX < w + 62 + 32 && mouseY < h + 17 + 32) {
            ArrayList<String> toolTip = new ArrayList<String>();
            if (this.tileEntityEvaporator.liquidLevel > 0)
                toolTip.add((new FluidStack(this.tileEntityEvaporator.liquidID, this.tileEntityEvaporator.liquidLevel)).getLocalizedName());
            drawText(toolTip, mouseX, mouseY, this.fontRendererObj);
        }
        if (mouseX >= w + 97 && mouseY >= h + 16 && mouseX < w + 97 + 3 && mouseY < h + 16 + 3) {
            ArrayList<String> toolTip = new ArrayList<String>();
            if (this.tileEntityEvaporator.liquidLevel > 0) toolTip.add(I18n.format("container.discard"));
            drawText(toolTip, mouseX, mouseY, this.fontRendererObj);
        }
    }

    protected void drawText(List<String> list, int par2, int par3, FontRenderer font) {
        if (!list.isEmpty()) {
            GL11.glDisable(32826);
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int k = 0;
            for (String aList : list) {
                String s = aList;
                int l = font.getStringWidth(s);
                if (l > k) k = l;
            }
            int i1 = par2 + 12;
            int j1 = par3 - 12;
            int k1 = 8;
            if (list.size() > 1) k1 += 2 + (list.size() - 1) * 10;
            if (i1 + k > this.width) i1 -= 28 + k;
            if (j1 + k1 + 6 > this.height) j1 = this.height - k1 - 6;
            this.zLevel = 300.0F;
            itemRender.zLevel = 300.0F;
            int l1 = -267386864;
            drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
            drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
            drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
            drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
            drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
            int i2 = 1347420415;
            int j2 = (i2 & 0xFEFEFE) >> 1 | i2 & 0xFF000000;
            drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
            drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
            drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
            drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);
            for (int k2 = 0; k2 < list.size(); k2++) {
                String s1 = list.get(k2);
                font.drawStringWithShadow(s1, i1, j1, -1);
                if (k2 == 0) j1 += 2;
                j1 += 10;
            }
            this.zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(32826);
        }
    }
}
