package darkbum.saltymod.inventory.gui;

import darkbum.saltymod.util.EvaporatingRecipe;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.proxy.CommonProxy;
import darkbum.saltymod.inventory.container.ContainerEvaporator;
import darkbum.saltymod.network.EvaporatorButtonMessage;
import darkbum.saltymod.tileentity.TileEntityEvaporator;

import java.util.ArrayList;
import java.util.List;

import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;

@SideOnly(Side.CLIENT)
public class GuiEvaporator extends GuiContainer {

    private static final ResourceLocation resourceLocation = new ResourceLocation(
        "saltymod:textures/gui/container/evaporator.png");

    private final TileEntityEvaporator tileEntityEvaporator;

    private GuiEvaporatorButton button;

    public GuiEvaporator(InventoryPlayer player, TileEntityEvaporator tileEntityEvaporator) {
        super(new ContainerEvaporator(player, tileEntityEvaporator));
        this.tileEntityEvaporator = tileEntityEvaporator;
    }

    public void initGui() {
        super.initGui();
        buttonList.add(button = new GuiEvaporatorButton(resourceLocation, 1, guiLeft + 49, guiTop + 62));
        button.enabled = false;
    }

    public void updateScreen() {
        super.updateScreen();
        button.enabled = (tileEntityEvaporator.liquidLevel > 0);
    }

    protected void actionPerformed(GuiButton button) {
        CommonProxy.network.sendToServer(new EvaporatorButtonMessage(tileEntityEvaporator.xCoord, tileEntityEvaporator.yCoord, tileEntityEvaporator.zCoord));
    }

    protected void drawGuiContainerForegroundLayer(int par_1, int par_2) {
        String string = I18n.format("container.evaporator");
        fontRendererObj.drawString(string, xSize / 2 - fontRendererObj.getStringWidth(string) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(resourceLocation);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        if (tileEntityEvaporator.isBurning()) {
            int burn = tileEntityEvaporator.getBurnTimeRemainingScale(13);
            drawTexturedModalRect(x + 56, y + 36 + 12 - burn, 176, 12 - burn, 14, burn + 1);
        }

        if (tileEntityEvaporator.liquidLevel > 0) {
            int progress = tileEntityEvaporator.getEvaporateProgressScale(24);
            drawTexturedModalRect(x + 79, y + 34, 176, 14, progress + 1, 17);
        }

        int pressureHeight = tileEntityEvaporator.getPressureProgressScale(16);
        if (pressureHeight > 0) {
            drawTexturedModalRect(x + 75, y + 17 + 16 - pressureHeight, 193, 31 + 16 - pressureHeight, 1, pressureHeight);
        }

        int fluidLevel = tileEntityEvaporator.getFluidAmountScaleClient(33);
        if (fluidLevel > 0) {
            drawTexturedModalRect(x + 48, y + 26 + 33 - fluidLevel, 176, 31 + 33 - fluidLevel, 5, fluidLevel);
        }

        if (tileEntityEvaporator.isBurning() && tileEntityEvaporator.liquidLevel > 0) {
            ItemStack outputStack = tileEntityEvaporator.getStackInSlot(0);
            ItemStack evaporatedItem = EvaporatingRecipe.instance().getEvaporateItemStack(
                FluidRegistry.getFluid(tileEntityEvaporator.liquidID)
            );
            boolean hasRoomInOutputSlot = (outputStack == null ||
                (outputStack.isItemEqual(evaporatedItem) &&
                    outputStack.stackSize + evaporatedItem.stackSize <= outputStack.getMaxStackSize()));

            if (hasRoomInOutputSlot) {
                int tick = (int) (System.currentTimeMillis() / 100) % 7;
                int yOffset = switch (tick) {
                    case 1 -> 6;
                    case 2 -> 11;
                    case 3 -> 16;
                    case 4 -> 20;
                    case 5 -> 24;
                    case 6 -> 29;
                    default -> 0;
                };
                if (yOffset > 0) {
                    drawTexturedModalRect(x + 34, y + 28 + 29 - yOffset, 181, 59 - yOffset, 12, yOffset);
                }
            }
        }

        if (tileEntityEvaporator.liquidLevel > 0) {
            FluidStack fluidstack = new FluidStack(FluidRegistry.getFluid(tileEntityEvaporator.liquidID), 1000);
            drawTank(x, y, fluidstack);
        }
    }

    protected void drawTank(int x, int y, FluidStack fluidstack) {
        if (fluidstack == null) return;
        IIcon icon = null;
        Fluid fluid = fluidstack.getFluid();
        int color = fluid.getColor();
        if (fluid.getStillIcon() != null) icon = fluid.getStillIcon();
        mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        float r = (color >> 16 & 0xFF) / 255.0F;
        float g = (color >> 8 & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        GL11.glColor4f(r, g, b, 1.0F);
        assert icon != null;
        drawTexturedModelRectFromIcon(x + 56, y + 17, icon, 16, 16);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        if (mouseX >= x + 55 && mouseY >= y + 16 && mouseX < x + 55 + 18 && mouseY < y + 16 + 18) {
            ArrayList<String> toolTip = new ArrayList<>();
            if (tileEntityEvaporator.liquidLevel > 0)
                toolTip.add((new FluidStack(FluidRegistry.getFluid(tileEntityEvaporator.liquidID), tileEntityEvaporator.liquidLevel)).getLocalizedName());
            drawText(toolTip, mouseX, mouseY, fontRendererObj);
        }
        if (mouseX >= x + 49 && mouseY >= y + 62 && mouseX < x + 49 + 3 && mouseY < y + 62 + 3) {
            ArrayList<String> toolTip = new ArrayList<>();
            if (tileEntityEvaporator.liquidLevel > 0) toolTip.add(I18n.format("container.evaporator.discard"));
            drawText(toolTip, mouseX, mouseY, fontRendererObj);
        }
        if (mouseX >= x + 48 && mouseY >= y + 26 && mouseX < x + 48 + 5 && mouseY < y + 26 + 33) {
            ArrayList<String> toolTip = new ArrayList<>();
            if (tileEntityEvaporator.liquidLevel > 0) {
                int currentLevel = tileEntityEvaporator.liquidLevel;
                int maxLevel = tileEntityEvaporator.maxCap;
                toolTip.add(currentLevel + " / " + maxLevel + " mB");
            } else {
                toolTip.add(I18n.format("container.evaporator.empty"));
            }
            drawText(toolTip, mouseX, mouseY, fontRendererObj);
        }
        if (mouseX >= x + 74 && mouseY >= y + 16 && mouseX < x + 74 + 3 && mouseY < y + 16 + 18) {
            ArrayList<String> toolTip = new ArrayList<>();
            if (tileEntityEvaporator.pressure > 0) {
                int currentLevel = tileEntityEvaporator.pressure;
                int maxLevel = evaporatorPressureBuildup;
                toolTip.add(I18n.format("container.evaporator.pressure") + ": " + currentLevel + " / " + maxLevel + " PU");
            }
            drawText(toolTip, mouseX, mouseY, fontRendererObj);
        }
    }

    protected void drawText(List<String> list, int mouseX, int mouseY, FontRenderer font) {
        if (!list.isEmpty()) {
            GL11.glDisable(32826);
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int k = 0;
            for (String aList : list) {
                int l = font.getStringWidth(aList);
                if (l > k) k = l;
            }
            int i1 = mouseX + 12;
            int j1 = mouseY - 12;
            int k1 = 8;
            if (list.size() > 1) k1 += 2 + (list.size() - 1) * 10;
            if (i1 + k > width) i1 -= 28 + k;
            if (j1 + k1 + 6 > height) j1 = height - k1 - 6;
            zLevel = 300.0F;
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
            zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(32826);
        }
    }
}
