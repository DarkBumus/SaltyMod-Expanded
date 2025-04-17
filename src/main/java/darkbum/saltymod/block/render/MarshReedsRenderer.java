package darkbum.saltymod.block.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import darkbum.saltymod.block.BlockMarshReeds;
import darkbum.saltymod.common.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class MarshReedsRenderer implements ISimpleBlockRenderingHandler {

    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        renderer.drawCrossedSquares(block.getIcon(0, world.getBlockMetadata(x, y, z)), x, y, z, 1.0F);
        renderer.drawCrossedSquares(((BlockMarshReeds) ModBlocks.marsh_reeds).LOWER, x, (double) y - 1.0D, z, 1.0F);
        return true;
    }

    @Override
    public int getRenderId() {
        return ClientProxy.marshReedsRenderType;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }
}
