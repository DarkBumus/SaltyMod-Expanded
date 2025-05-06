package darkbum.saltymod.block.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import darkbum.saltymod.common.proxy.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

import static darkbum.saltymod.block.BlockMarshReeds.*;

/**
 * Renderer class for {@link BlockMarshReedsBottom}.
 *
 * Handles the custom rendering of the marhs reeds block in the world an in inventory.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class MarshReedsRenderer implements ISimpleBlockRenderingHandler {

    /**
     * No special inventory rendering for this block.
     */
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}

    /**
     * Renders the marhs reeds in the world.
     * The marsh reeds consist of an upper section that draws from the standard icon of the block,
     * aswell as a lower section that draws from the lower icon of the block.
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
        Block blockAbove = world.getBlock(x, y + 1, z);
        Block blockBelow = world.getBlock(x, y - 1, z);

        Tessellator tessellator = Tessellator.instance;

        if (block == ModBlocks.marsh_reeds_b) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);

            renderer.drawCrossedSquares(((BlockMarshReedsBottom) ModBlocks.marsh_reeds_b).iconBottom, x, y, z, 1.0f);
            if (blockAbove != ModBlocks.marsh_reeds_t && blockAbove != ModBlocks.marsh_reeds_b) {
                renderer.drawCrossedSquares(((BlockMarshReedsTop) ModBlocks.marsh_reeds_t).iconTop, x, y + 1, z, 1.0f);
            }
            renderer.renderBlockLiquid(Blocks.water, x, y, z);
        }
        if (block == ModBlocks.marsh_reeds_t) {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            tessellator.setColorOpaque_F(1.0f, 1.0f, 1.0f);

            renderer.drawCrossedSquares(((BlockMarshReedsTop) ModBlocks.marsh_reeds_t).iconTop, x, y, z, 1.0f);
            if (blockBelow != ModBlocks.marsh_reeds_t && blockBelow != ModBlocks.marsh_reeds_b) {
                renderer.drawCrossedSquares(((BlockMarshReedsBottom) ModBlocks.marsh_reeds_b).iconBottom, x, y - 1, z, 1.0f);
                renderer.renderBlockLiquid(Blocks.water, x, y - 1, z);
            }
        }

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
     * @return the marsh reeds render ID from {@link ClientProxy}.
     */
    @Override
    public int getRenderId() {
        return ClientProxy.marshReedsRenderType;
    }
}
