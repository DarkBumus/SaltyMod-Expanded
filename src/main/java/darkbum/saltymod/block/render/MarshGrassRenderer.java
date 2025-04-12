package darkbum.saltymod.block.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import darkbum.saltymod.block.BlockMarshGrass;
import darkbum.saltymod.block.BlockMarshReeds;
import darkbum.saltymod.common.ClientProxy;
import darkbum.saltymod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MarshGrassRenderer implements ISimpleBlockRenderingHandler {

    private IIcon waterIcon;

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        this.waterIcon = Blocks.water.getIcon(0, 0);
        Tessellator tessellator = Tessellator.instance;

/*        tessellator.startDrawingQuads();
        renderAsWater(world, x, y, z, tessellator);*/

        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);


        renderer.drawCrossedSquares(((BlockMarshGrass) ModBlocks.marsh_grass).BOTTOM, x, y, z, 1.0F);
//        renderer.drawCrossedSquares(((BlockMarshGrass) ModBlocks.marsh_grass).TOP, x, y + 1, z, 1.0F);

        return true;
    }

    private void renderAsWater(World world, int x, int y, int z, Tessellator tessellator) {
        // Diese Methode sorgt dafür, dass der Block als Wasser aussieht.
        Block block = world.getBlock(x, y, z);

        // Definiere die Textur des Blocks (Wasser)
        tessellator.setNormal(0.0F, 1.0F, 0.0F);

        // Hier wird die Textur auf das Block-Gitter angewendet
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        block.renderAsNormalBlock();
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    @Override
    public int getRenderId() {
        return ClientProxy.marshGrassRenderType;
    }
}
