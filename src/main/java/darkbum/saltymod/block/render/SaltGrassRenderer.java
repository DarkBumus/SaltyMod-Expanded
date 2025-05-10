package darkbum.saltymod.block.render;

import darkbum.saltymod.block.BlockSaltGrass;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import darkbum.saltymod.common.proxy.ClientProxy;
import darkbum.saltymod.init.ModBlocks;

/**
 * Renderer class for {@link BlockSaltGrass}.
 * <p>
 * Handles the custom rendering of the evaporator block in the world an in inventory.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class SaltGrassRenderer implements ISimpleBlockRenderingHandler {

    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        Tessellator tess = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        // Draw all faces of the block
        tess.startDrawingQuads();
        tess.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 0));
        tess.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 1));
        tess.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 2));
        tess.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 3));
        tess.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 4));
        tess.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 5));
        tess.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    /**
     * Renders the salt grass in the world like a normal block.
     *
     * @param world     The world access object.
     * @param x         The x-coordinate of the block.
     * @param y         The y-coordinate of the block.
     * @param z         The z-coordinate of the block.
     * @return true if the block was rendered.
     */
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
        RenderBlocks renderer) {
        renderer.renderStandardBlock(block, x, y, z);
        renderer.renderStandardBlock(ModBlocks.grass_top, x, y, z);
        return true;
    }

    /**
     * Whether this block should be rendered in 3D in the inventory.
     *
     * @return true for 3D render in inventory.
     */
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    /**
     * @return the salt grass render ID from {@link ClientProxy}.
     */
    public int getRenderId() {
        return ClientProxy.saltGrassRenderType;
    }
}
