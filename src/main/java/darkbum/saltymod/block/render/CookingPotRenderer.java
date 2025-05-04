package darkbum.saltymod.block.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import darkbum.saltymod.block.BlockCookingPot;
import darkbum.saltymod.common.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Renderer class for {@link BlockCookingPot}.
 *
 * Handles the custom rendering of the cooking pot block in the world an in inventory.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class CookingPotRenderer implements ISimpleBlockRenderingHandler {

    /**
     * No special inventory rendering for this block.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
    }

    /**
     * Renders the cooking pot in the world based on its metadata.
     * The pot consists of a main body and various additional parts depending on its orientation.
     *
     * @param world     The world access object.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @param block     The block to render.
     * @param modelId   The model ID for this renderer.
     * @param renderer  The render helper.
     * @return true if the block was rendered.
     */
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator tess = Tessellator.instance;

        // Set brightness and color values
        tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        int metadata = world.getBlockMetadata(x, y, z);

        // Render main pot body (12x12x10) - from (2,0,2) to (14,10,14)
        if (metadata >= 0 && metadata <= 7) {
            renderer.setRenderBounds(2.0 / 16.0, 0.0, 2.0 / 16.0, 14.0 / 16.0, 10.0 / 16.0, 14.0 / 16.0);
            renderer.renderStandardBlock(block, x, y, z);
        }

        // Render additional parts based on metadata (orientation/state)
        switch (metadata) {
            case 0:
                addBoxRightGrip0246(tess, x, y, z, renderer);
                addBoxLeftGrip0246(tess, x, y, z, renderer);
                addBoxSpoon04(tess, x, y, z, renderer);
                break;
            case 1:
                addBoxRightGrip1357(tess, x, y, z, renderer);
                addBoxLeftGrip1357(tess, x, y, z, renderer);
                addBoxSpoon15(tess, x, y, z, renderer);
                break;
            case 2:
                addBoxRightGrip0246(tess, x, y, z, renderer);
                addBoxLeftGrip0246(tess, x, y, z, renderer);
                addBoxSpoon26(tess, x, y, z, renderer);
                break;
            case 3:
                addBoxRightGrip1357(tess, x, y, z, renderer);
                addBoxLeftGrip1357(tess, x, y, z, renderer);
                addBoxSpoon37(tess, x, y, z, renderer);
                break;
            case 4:
                addBoxRightGrip0246(tess, x, y, z, renderer);
                addBoxLeftGrip0246(tess, x, y, z, renderer);
                addBoxHandleRight46(tess, x, y, z, renderer);
                addBoxHandleLeft46(tess, x, y, z, renderer);
                addBoxHandleUp46(tess, x, y, z, renderer);
                addBoxHoop46(tess, x, y, z, renderer);
                addBoxSpoon04(tess, x, y, z, renderer);
                break;
            case 5:
                addBoxRightGrip1357(tess, x, y, z, renderer);
                addBoxLeftGrip1357(tess, x, y, z, renderer);
                addBoxHandleRight57(tess, x, y, z, renderer);
                addBoxHandleLeft57(tess, x, y, z, renderer);
                addBoxHandleUp57(tess, x, y, z, renderer);
                addBoxHoop57(tess, x, y, z, renderer);
                addBoxSpoon15(tess, x, y, z, renderer);
                break;
            case 6:
                addBoxRightGrip0246(tess, x, y, z, renderer);
                addBoxLeftGrip0246(tess, x, y, z, renderer);
                addBoxHandleRight46(tess, x, y, z, renderer);
                addBoxHandleLeft46(tess, x, y, z, renderer);
                addBoxHandleUp46(tess, x, y, z, renderer);
                addBoxHoop46(tess, x, y, z, renderer);
                addBoxSpoon26(tess, x, y, z, renderer);
                break;
            case 7:
                addBoxRightGrip1357(tess, x, y, z, renderer);
                addBoxLeftGrip1357(tess, x, y, z, renderer);
                addBoxHandleRight57(tess, x, y, z, renderer);
                addBoxHandleLeft57(tess, x, y, z, renderer);
                addBoxHandleUp57(tess, x, y, z, renderer);
                addBoxHoop57(tess, x, y, z, renderer);
                addBoxSpoon37(tess, x, y, z, renderer);
                break;
        }

        // Reset the render bounds after custom drawing
        renderer.overrideBlockTexture = null;
        renderer.setRenderBounds(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);

        return true;
    }

    /**
     * Whether this block should be rendered in 3D in the inventory.
     *
     * @return false for no 3D render in inventory.
     */
    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    /**
     * @return the cooking pot render ID from {@link ClientProxy}.
     */
    @Override
    public int getRenderId() {
        return ClientProxy.cookingPotRenderType;
    }

    /**
     * Renders the right grip for the cooking pot with the metadata 0, 2, 4 and 6.
     * The grip is made of a small cuboid to the side of the main body.
     *
     * @param tess      The tesselator that is used for drawing.
     */
    private void addBoxRightGrip0246(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double grx1 = x + 14.0 / 16.0;
        double grx2 = x + 16.0 / 16.0;
        double gry1 = y + 7.0 / 16.0;
        double gry2 = y + 9.0 / 16.0;
        double grz1 = z + 5.0 / 16.0;
        double grz2 = z + 11.0 / 16.0;

        // Down - UV: [4, 2, 10, 4]
        float minU = parts.getInterpolatedU(4);
        float maxU = parts.getInterpolatedU(10);
        float minV = parts.getInterpolatedV(2);
        float maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(grx2, gry1, grz1, maxU, minV);
        tess.addVertexWithUV(grx2, gry1, grz2, minU, minV);
        tess.addVertexWithUV(grx1, gry1, grz2, minU, maxV);
        tess.addVertexWithUV(grx1, gry1, grz1, maxU, maxV);

        // Up - UV: [4, 0, 10, 2]
        minU = parts.getInterpolatedU(10);
        maxU = parts.getInterpolatedU(4);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(0);
        tess.addVertexWithUV(grx1, gry2, grz1, maxU, minV);
        tess.addVertexWithUV(grx1, gry2, grz2, minU, minV);
        tess.addVertexWithUV(grx2, gry2, grz2, minU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz1, maxU, maxV);

        // North - UV: [10, 0, 12, 2]
        minU = parts.getInterpolatedU(10);
        maxU = parts.getInterpolatedU(12);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(grx1, gry1, grz1, maxU, maxV);
        tess.addVertexWithUV(grx1, gry2, grz1, maxU, minV);
        tess.addVertexWithUV(grx2, gry2, grz1, minU, minV);
        tess.addVertexWithUV(grx2, gry1, grz1, minU, maxV);

        // South - UV: [2, 0, 4, 2]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(4);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(grx2, gry1, grz2, maxU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz2, maxU, minV);
        tess.addVertexWithUV(grx1, gry2, grz2, minU, minV);
        tess.addVertexWithUV(grx1, gry1, grz2, minU, maxV);

        // East - UV: [4, 2, 10, 4]
        minU = parts.getInterpolatedU(4);
        maxU = parts.getInterpolatedU(10);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(grx2, gry1, grz1, minU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz1, minU, minV);
        tess.addVertexWithUV(grx2, gry2, grz2, maxU, minV);
        tess.addVertexWithUV(grx2, gry1, grz2, maxU, maxV);
    }

    /**
     * Renders the left grip for the cooking pot with the metadata 0, 2, 4 and 6.
     */
    private void addBoxLeftGrip0246(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double glx1 = x + 0.0 / 16.0;
        double glx2 = x + 2.0 / 16.0;
        double gly1 = y + 7.0 / 16.0;
        double gly2 = y + 9.0 / 16.0;
        double glz1 = z + 5.0 / 16.0;
        double glz2 = z + 11.0 / 16.0;

        // Down - UV: [4, 2, 10, 4]
        float minU = parts.getInterpolatedU(4);
        float maxU = parts.getInterpolatedU(10);
        float minV = parts.getInterpolatedV(2);
        float maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(glx2, gly1, glz1, minU, maxV);
        tess.addVertexWithUV(glx2, gly1, glz2, maxU, maxV);
        tess.addVertexWithUV(glx1, gly1, glz2, maxU, minV);
        tess.addVertexWithUV(glx1, gly1, glz1, minU, minV);

        // Up - UV: [4, 0, 10, 2]
        minU = parts.getInterpolatedU(4);
        maxU = parts.getInterpolatedU(10);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(glx1, gly2, glz1, maxU, minV);
        tess.addVertexWithUV(glx1, gly2, glz2, minU, minV);
        tess.addVertexWithUV(glx2, gly2, glz2, minU, maxV);
        tess.addVertexWithUV(glx2, gly2, glz1, maxU, maxV);

        // North  - UV: [2, 0, 4, 2]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(4);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(glx1, gly1, glz1, maxU, maxV);
        tess.addVertexWithUV(glx1, gly2, glz1, maxU, minV);
        tess.addVertexWithUV(glx2, gly2, glz1, minU, minV);
        tess.addVertexWithUV(glx2, gly1, glz1, minU, maxV);

        // South - UV: [10, 0, 12, 2]
        minU = parts.getInterpolatedU(10);
        maxU = parts.getInterpolatedU(12);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(glx2, gly1, glz2, maxU, maxV);
        tess.addVertexWithUV(glx2, gly2, glz2, maxU, minV);
        tess.addVertexWithUV(glx1, gly2, glz2, minU, minV);
        tess.addVertexWithUV(glx1, gly1, glz2, minU, maxV);

        // West - UV: [4, 2, 10, 4]
        minU = parts.getInterpolatedU(4);
        maxU = parts.getInterpolatedU(10);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(glx1, gly1, glz2, minU, maxV);
        tess.addVertexWithUV(glx1, gly2, glz2, minU, minV);
        tess.addVertexWithUV(glx1, gly2, glz1, maxU, minV);
        tess.addVertexWithUV(glx1, gly1, glz1, maxU, maxV);
    }

    /**
     * Renders the right grip for the cooking pot with the metadata 1, 3, 5 and 7.
     */
    private void addBoxRightGrip1357(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double grx1 = x + 5.0 / 16.0;
        double grx2 = x + 11.0 / 16.0;
        double gry1 = y + 7.0 / 16.0;
        double gry2 = y + 9.0 / 16.0;
        double grz1 = z + 14.0 / 16.0;
        double grz2 = z + 16.0 / 16.0;

        // Down - UV: [4, 2, 10, 4]
        float minU = parts.getInterpolatedU(4);
        float maxU = parts.getInterpolatedU(10);
        float minV = parts.getInterpolatedV(2);
        float maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(grx2, gry1, grz1, maxU, maxV);
        tess.addVertexWithUV(grx2, gry1, grz2, maxU, minV);
        tess.addVertexWithUV(grx1, gry1, grz2, minU, minV);
        tess.addVertexWithUV(grx1, gry1, grz1, minU, maxV);

        // Up - UV: [4, 0, 10, 2]
        minU = parts.getInterpolatedU(10);
        maxU = parts.getInterpolatedU(4);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(0);
        tess.addVertexWithUV(grx1, gry2, grz1, minU, minV);
        tess.addVertexWithUV(grx1, gry2, grz2, minU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz2, maxU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz1, maxU, minV);

        // South - UV: [4, 2, 10, 4]
        minU = parts.getInterpolatedU(4);
        maxU = parts.getInterpolatedU(10);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(grx2, gry1, grz2, maxU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz2, maxU, minV);
        tess.addVertexWithUV(grx1, gry2, grz2, minU, minV);
        tess.addVertexWithUV(grx1, gry1, grz2, minU, maxV);

        // West - UV: [2, 0, 4, 2]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(4);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(grx1, gry1, grz2, maxU, maxV);
        tess.addVertexWithUV(grx1, gry2, grz2, maxU, minV);
        tess.addVertexWithUV(grx1, gry2, grz1, minU, minV);
        tess.addVertexWithUV(grx1, gry1, grz1, minU, maxV);

        // East - UV: [10, 0, 12, 2]
        minU = parts.getInterpolatedU(10);
        maxU = parts.getInterpolatedU(12);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(grx2, gry1, grz1, maxU, maxV);
        tess.addVertexWithUV(grx2, gry2, grz1, maxU, minV);
        tess.addVertexWithUV(grx2, gry2, grz2, minU, minV);
        tess.addVertexWithUV(grx2, gry1, grz2, minU, maxV);
    }

    /**
     * Renders the left grip for the cooking pot with the metadata 1, 3, 5 and 7.
     */
    private void addBoxLeftGrip1357(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double glx1 = x + 5.0 / 16.0;
        double glx2 = x + 11.0 / 16.0;
        double gly1 = y + 7.0 / 16.0;
        double gly2 = y + 9.0 / 16.0;
        double glz1 = z + 0.0 / 16.0;
        double glz2 = z + 2.0 / 16.0;

        // Down - UV: [4, 2, 10, 4]
        float minU = parts.getInterpolatedU(4);
        float maxU = parts.getInterpolatedU(10);
        float minV = parts.getInterpolatedV(2);
        float maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(glx2, gly1, glz1, maxU, minV);
        tess.addVertexWithUV(glx2, gly1, glz2, maxU, maxV);
        tess.addVertexWithUV(glx1, gly1, glz2, minU, maxV);
        tess.addVertexWithUV(glx1, gly1, glz1, minU, minV);

        // Up - UV: [4, 0, 10, 2]
        minU = parts.getInterpolatedU(4);
        maxU = parts.getInterpolatedU(10);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(glx1, gly2, glz1, minU, minV);
        tess.addVertexWithUV(glx1, gly2, glz2, minU, maxV);
        tess.addVertexWithUV(glx2, gly2, glz2, maxU, maxV);
        tess.addVertexWithUV(glx2, gly2, glz1, maxU, minV);

        // North  - UV: [4, 2, 10, 4]
        minU = parts.getInterpolatedU(4);
        maxU = parts.getInterpolatedU(10);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(4);
        tess.addVertexWithUV(glx1, gly1, glz1, maxU, maxV);
        tess.addVertexWithUV(glx1, gly2, glz1, maxU, minV);
        tess.addVertexWithUV(glx2, gly2, glz1, minU, minV);
        tess.addVertexWithUV(glx2, gly1, glz1, minU, maxV);

        // West - UV: [10, 0, 12, 2]
        minU = parts.getInterpolatedU(10);
        maxU = parts.getInterpolatedU(12);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(glx1, gly1, glz2, maxU, maxV);
        tess.addVertexWithUV(glx1, gly2, glz2, maxU, minV);
        tess.addVertexWithUV(glx1, gly2, glz1, minU, minV);
        tess.addVertexWithUV(glx1, gly1, glz1, minU, maxV);

        // East - UV: UV: [2, 0, 4, 2]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(4);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(glx2, gly1, glz1, maxU, maxV);
        tess.addVertexWithUV(glx2, gly2, glz1, maxU, minV);
        tess.addVertexWithUV(glx2, gly2, glz2, minU, minV);
        tess.addVertexWithUV(glx2, gly1, glz2, minU, maxV);
    }

    /**
     * Renders the right handle for the cooking pot with the metadata 4 and 6.
     */
    private void addBoxHandleRight46(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hrx1 = x + 15.0 / 16.0;
        double hrx2 = x + 15.0 / 16.0;
        double hry1 = y + 8.0 / 16.0;
        double hry2 = y + 16.0 / 16.0;
        double hrz1 = z + 7.0 / 16.0;
        double hrz2 = z + 9.0 / 16.0;

        // West/East - UV: [0, 0, 2, 8]
        float minU = handle.getInterpolatedU(0);
        float maxU = handle.getInterpolatedU(2);
        float minV = handle.getInterpolatedV(0);
        float maxV = handle.getInterpolatedV(8);
        tess.addVertexWithUV(hrx2, hry1, hrz1, maxU, maxV);
        tess.addVertexWithUV(hrx2, hry1, hrz2, minU, maxV);
        tess.addVertexWithUV(hrx2, hry2, hrz2, minU, minV);
        tess.addVertexWithUV(hrx2, hry2, hrz1, maxU, minV);

        tess.addVertexWithUV(hrx2, hry1, hrz1, maxU, maxV);
        tess.addVertexWithUV(hrx2, hry2, hrz1, maxU, minV);
        tess.addVertexWithUV(hrx2, hry2, hrz2, minU, minV);
        tess.addVertexWithUV(hrx2, hry1, hrz2, minU, maxV);
    }

    /**
     * Renders the left handle for the cooking pot with the metadata 4 and 6.
     */
    private void addBoxHandleLeft46(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hlx1 = x + 1.0 / 16.0;
        double hlx2 = x + 1.0 / 16.0;
        double hly1 = y + 8.0 / 16.0;
        double hly2 = y + 16.0 / 16.0;
        double hlz1 = z + 7.0 / 16.0;
        double hlz2 = z + 9.0 / 16.0;

        // West/East - UV: [0, 0, 2, 8]
        float minU = handle.getInterpolatedU(0);
        float maxU = handle.getInterpolatedU(2);
        float minV = handle.getInterpolatedV(0);
        float maxV = handle.getInterpolatedV(8);
        tess.addVertexWithUV(hlx2, hly1, hlz1, maxU, maxV);
        tess.addVertexWithUV(hlx2, hly1, hlz2, minU, maxV);
        tess.addVertexWithUV(hlx2, hly2, hlz2, minU, minV);
        tess.addVertexWithUV(hlx2, hly2, hlz1, maxU, minV);

        tess.addVertexWithUV(hlx2, hly1, hlz1, maxU, maxV);
        tess.addVertexWithUV(hlx2, hly2, hlz1, maxU, minV);
        tess.addVertexWithUV(hlx2, hly2, hlz2, minU, minV);
        tess.addVertexWithUV(hlx2, hly1, hlz2, minU, maxV);
    }

    /**
     * Renders the upper handle for the cooking pot with the metadata 4 and 6.
     */
    private void addBoxHandleUp46(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hux1 = x + 1.0 / 16.0;
        double hux2 = x + 15.0 / 16.0;
        double huy1 = y + 15.999 / 16.0;
        double huy2 = y + 15.999 / 16.0;
        double huz1 = z + 7.0 / 16.0;
        double huz2 = z + 9.0 / 16.0;

        // Up/Down - UV: [2, 0, 16, 2]
        float minU = handle.getInterpolatedU(2);
        float maxU = handle.getInterpolatedU(16);
        float minV = handle.getInterpolatedV(0);
        float maxV = handle.getInterpolatedV(2);
        tess.addVertexWithUV(hux1, huy1, huz1, maxU, maxV);
        tess.addVertexWithUV(hux1, huy1, huz2, maxU, minV);
        tess.addVertexWithUV(hux2, huy1, huz2, minU, minV);
        tess.addVertexWithUV(hux2, huy1, huz1, minU, maxV);

        tess.addVertexWithUV(hux2, huy2, huz1, minU, maxV);
        tess.addVertexWithUV(hux2, huy2, huz2, minU, minV);
        tess.addVertexWithUV(hux1, huy2, huz2, maxU, minV);
        tess.addVertexWithUV(hux1, huy2, huz1, maxU, maxV);
    }

    /**
     * Renders the handle hoop for the cooking pot with the metadata 4 and 6.
     */
    private void addBoxHoop46(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hox1 = x + 1.0 / 16.0;
        double hox2 = x + 15.0 / 16.0;
        double hoy1 = y + 8.0 / 16.0;
        double hoy2 = y + 16.0 / 16.0;
        double hoz1 = z + 8.0 / 16.0;
        double hoz2 = z + 8.0 / 16.0;

        // North/South - UV: [1, 8, 15, 16]
        float minU = handle.getInterpolatedU(1);
        float maxU = handle.getInterpolatedU(15);
        float minV = handle.getInterpolatedV(8);
        float maxV = handle.getInterpolatedV(16);
        tess.addVertexWithUV(hox1, hoy1, hoz1, maxU, maxV);
        tess.addVertexWithUV(hox1, hoy2, hoz1, maxU, minV);
        tess.addVertexWithUV(hox2, hoy2, hoz1, minU, minV);
        tess.addVertexWithUV(hox2, hoy1, hoz1, minU, maxV);

        tess.addVertexWithUV(hox2, hoy1, hoz2, maxU, maxV);
        tess.addVertexWithUV(hox2, hoy2, hoz2, maxU, minV);
        tess.addVertexWithUV(hox1, hoy2, hoz2, minU, minV);
        tess.addVertexWithUV(hox1, hoy1, hoz2, minU, maxV);
    }

    /**
     * Renders the right handle for the cooking pot with the metadata 5 and 7.
     */
    private void addBoxHandleRight57(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hrx1 = x + 7.0 / 16.0;
        double hrx2 = x + 9.0 / 16.0;
        double hry1 = y + 8.0 / 16.0;
        double hry2 = y + 16.0 / 16.0;
        double hrz1 = z + 15.0 / 16.0;
        double hrz2 = z + 15.0 / 16.0;

        // West/East - UV: [0, 0, 2, 8]
        float minU = handle.getInterpolatedU(0);
        float maxU = handle.getInterpolatedU(2);
        float minV = handle.getInterpolatedV(0);
        float maxV = handle.getInterpolatedV(8);
        tess.addVertexWithUV(hrx2, hry1, hrz2, maxU, maxV);
        tess.addVertexWithUV(hrx2, hry2, hrz2, maxU, minV);
        tess.addVertexWithUV(hrx1, hry2, hrz2, minU, minV);
        tess.addVertexWithUV(hrx1, hry1, hrz2, minU, maxV);

        tess.addVertexWithUV(hrx1, hry1, hrz1, minU, maxV);
        tess.addVertexWithUV(hrx1, hry2, hrz1, minU, minV);
        tess.addVertexWithUV(hrx2, hry2, hrz1, maxU, minV);
        tess.addVertexWithUV(hrx2, hry1, hrz1, maxU, maxV);
    }

    /**
     * Renders the left handle for the cooking pot with the metadata 5 and 7.
     */
    private void addBoxHandleLeft57(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hlx1 = x + 7.0 / 16.0;
        double hlx2 = x + 9.0 / 16.0;
        double hly1 = y + 8.0 / 16.0;
        double hly2 = y + 16.0 / 16.0;
        double hlz1 = z + 1.0 / 16.0;
        double hlz2 = z + 1.0 / 16.0;

        // West/East - UV: [0, 0, 2, 8]
        float minU = handle.getInterpolatedU(0);
        float maxU = handle.getInterpolatedU(2);
        float minV = handle.getInterpolatedV(0);
        float maxV = handle.getInterpolatedV(8);
        tess.addVertexWithUV(hlx2, hly1, hlz2, maxU, maxV);
        tess.addVertexWithUV(hlx2, hly2, hlz2, maxU, minV);
        tess.addVertexWithUV(hlx1, hly2, hlz2, minU, minV);
        tess.addVertexWithUV(hlx1, hly1, hlz2, minU, maxV);

        tess.addVertexWithUV(hlx1, hly1, hlz1, minU, maxV);
        tess.addVertexWithUV(hlx1, hly2, hlz1, minU, minV);
        tess.addVertexWithUV(hlx2, hly2, hlz1, maxU, minV);
        tess.addVertexWithUV(hlx2, hly1, hlz1, maxU, maxV);
    }

    /**
     * Renders the upper handle for the cooking pot with the metadata 5 and 7.
     */
    private void addBoxHandleUp57(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hux1 = x + 7.0 / 16.0;
        double hux2 = x + 9.0 / 16.0;
        double huy1 = y + 15.999 / 16.0;
        double huy2 = y + 15.999 / 16.0;
        double huz1 = z + 1.0 / 16.0;
        double huz2 = z + 15.0 / 16.0;

        // Up/Down - UV: [2, 0, 16, 2]
        float minU = handle.getInterpolatedU(2);
        float maxU = handle.getInterpolatedU(16);
        float minV = handle.getInterpolatedV(0);
        float maxV = handle.getInterpolatedV(2);
        tess.addVertexWithUV(hux1, huy1, huz1, maxU, minV);
        tess.addVertexWithUV(hux1, huy1, huz2, minU, minV);
        tess.addVertexWithUV(hux2, huy1, huz2, minU, maxV);
        tess.addVertexWithUV(hux2, huy1, huz1, maxU, maxV);

        tess.addVertexWithUV(hux2, huy2, huz1, maxU, maxV);
        tess.addVertexWithUV(hux2, huy2, huz2, minU, maxV);
        tess.addVertexWithUV(hux1, huy2, huz2, minU, minV);
        tess.addVertexWithUV(hux1, huy2, huz1, maxU, minV);
    }

    /**
     * Renders the handle hoop for the cooking pot with the metadata 5 and 7.
     */
    private void addBoxHoop57(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon handle = BlockCookingPot.getHandleIcon();
        renderer.overrideBlockTexture = handle;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double hox1 = x + 8.0 / 16.0;
        double hox2 = x + 8.0 / 16.0;
        double hoy1 = y + 8.0 / 16.0;
        double hoy2 = y + 16.0 / 16.0;
        double hoz1 = z + 1.0 / 16.0;
        double hoz2 = z + 15.0 / 16.0;

        // North/South - UV: [1, 8, 15, 16]
        float minU = handle.getInterpolatedU(1);
        float maxU = handle.getInterpolatedU(15);
        float minV = handle.getInterpolatedV(8);
        float maxV = handle.getInterpolatedV(16);
        tess.addVertexWithUV(hox1, hoy1, hoz2, maxU, maxV);
        tess.addVertexWithUV(hox1, hoy2, hoz2, maxU, minV);
        tess.addVertexWithUV(hox1, hoy2, hoz1, minU, minV);
        tess.addVertexWithUV(hox1, hoy1, hoz1, minU, maxV);

        tess.addVertexWithUV(hox2, hoy1, hoz1, maxU, maxV);
        tess.addVertexWithUV(hox2, hoy2, hoz1, maxU, minV);
        tess.addVertexWithUV(hox2, hoy2, hoz2, minU, minV);
        tess.addVertexWithUV(hox2, hoy1, hoz2, minU, maxV);
    }

    /**
     * Renders the spoon for the cooking pot with the metadata 0 and 4.
     */
    private void addBoxSpoon04(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double sx1 = x + 4.0 / 16.0;
        double sx2 = x + 6.0 / 16.0;
        double sy1 = y + 2.0 / 16.0;
        double sy2 = y + 14.0 / 16.0;
        double sz1 = z + 5.0 / 16.0;
        double sz2 = z + 7.0 / 16.0;

        // Down - UV: [0, 0, 2, 2]
        float minU = parts.getInterpolatedU(0);
        float maxU = parts.getInterpolatedU(2);
        float minV = parts.getInterpolatedV(0);
        float maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);

        // Up - UV: [0, 0, 2, 2]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, maxV);

        // North - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz1, minU, maxV);

        // South - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);

        // West - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz1, minU, maxV);

        // East - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, maxV);
    }

    /**
     * Renders the spoon for the cooking pot with the metadata 1 and 5.
     */
    private void addBoxSpoon15(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double sx1 = x + 9.0 / 16.0;
        double sx2 = x + 11.0 / 16.0;
        double sy1 = y + 2.0 / 16.0;
        double sy2 = y + 14.0 / 16.0;
        double sz1 = z + 4.0 / 16.0;
        double sz2 = z + 6.0 / 16.0;

        // Down - UV: [0, 0, 2, 2]
        float minU = parts.getInterpolatedU(0);
        float maxU = parts.getInterpolatedU(2);
        float minV = parts.getInterpolatedV(0);
        float maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);

        // Up - UV: [0, 0, 2, 2]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, maxV);

        // North - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz1, minU, maxV);

        // South - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);

        // West - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz1, minU, maxV);

        // East - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, maxV);
    }

    /**
     * Renders the spoon for the cooking pot with the metadata 2 and 6.
     */
    private void addBoxSpoon26(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double sx1 = x + 10.0 / 16.0;
        double sx2 = x + 12.0 / 16.0;
        double sy1 = y + 2.0 / 16.0;
        double sy2 = y + 14.0 / 16.0;
        double sz1 = z + 9.0 / 16.0;
        double sz2 = z + 11.0 / 16.0;

        // Down - UV: [0, 0, 2, 2]
        float minU = parts.getInterpolatedU(0);
        float maxU = parts.getInterpolatedU(2);
        float minV = parts.getInterpolatedV(0);
        float maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);

        // Up - UV: [0, 0, 2, 2]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, maxV);

        // North - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz1, minU, maxV);

        // South - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);

        // West - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz1, minU, maxV);

        // East - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, maxV);
    }

    /**
     * Renders the spoon for the cooking pot with the metadata 3 and 7.
     */
    private void addBoxSpoon37(Tessellator tess, int x, int y, int z, RenderBlocks renderer) {
        // Assign a texture to the box from the block class
        IIcon parts = BlockCookingPot.getPartsIcon();
        renderer.overrideBlockTexture = parts;
        prepareLighting(tess, renderer, x, y, z);

        // Define coordinates for the cuboid in the space of the block
        double sx1 = x + 5.0 / 16.0;
        double sx2 = x + 7.0 / 16.0;
        double sy1 = y + 2.0 / 16.0;
        double sy2 = y + 14.0 / 16.0;
        double sz1 = z + 10.0 / 16.0;
        double sz2 = z + 12.0 / 16.0;

        // Down - UV: [0, 0, 2, 2]
        float minU = parts.getInterpolatedU(0);
        float maxU = parts.getInterpolatedU(2);
        float minV = parts.getInterpolatedV(0);
        float maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);

        // Up - UV: [0, 0, 2, 2]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(0);
        maxV = parts.getInterpolatedV(2);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, maxV);

        // North - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz1, minU, maxV);

        // South - UV: [2, 2, 0, 14]
        minU = parts.getInterpolatedU(2);
        maxU = parts.getInterpolatedU(0);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz2, minU, maxV);

        // West - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx1, sy1, sz2, maxU, maxV);
        tess.addVertexWithUV(sx1, sy2, sz2, maxU, minV);
        tess.addVertexWithUV(sx1, sy2, sz1, minU, minV);
        tess.addVertexWithUV(sx1, sy1, sz1, minU, maxV);

        // East - UV: [0, 2, 2, 14]
        minU = parts.getInterpolatedU(0);
        maxU = parts.getInterpolatedU(2);
        minV = parts.getInterpolatedV(2);
        maxV = parts.getInterpolatedV(14);
        tess.addVertexWithUV(sx2, sy1, sz1, maxU, maxV);
        tess.addVertexWithUV(sx2, sy2, sz1, maxU, minV);
        tess.addVertexWithUV(sx2, sy2, sz2, minU, minV);
        tess.addVertexWithUV(sx2, sy1, sz2, minU, maxV);
    }

    /**
     * Helper method to prep the lighting properly for each of the boxes.
     */
    private void prepareLighting(Tessellator tess, RenderBlocks renderer, int x, int y, int z) {
        int brightness = renderer.blockAccess.getLightBrightnessForSkyBlocks(x, y, z, 0);
        tess.setBrightness(brightness);

        float ambient = Minecraft.getMinecraft().theWorld.getLightBrightness(x, y, z);
        float adjustedAmbient = 0.4F + ambient * 0.6F;
        adjustedAmbient = Math.min(adjustedAmbient, 0.85F);
        tess.setColorOpaque_F(adjustedAmbient, adjustedAmbient, adjustedAmbient);
    }
}
