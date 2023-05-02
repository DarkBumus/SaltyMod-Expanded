package darkbum.saltymod.common;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;
import darkbum.saltymod.tileentity.TileEntityBlossomSign;
import darkbum.saltymod.tileentity.renderer.TileEntityBlossomSignRenderer;
import net.minecraft.client.renderer.entity.RenderSnowball;
import darkbum.saltymod.block.renderer.EvaporatorRenderer;
import darkbum.saltymod.block.renderer.SaltGrassRenderer;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import darkbum.saltymod.entity.render.RenderRainmakerDust;

public class ClientProxy extends CommonProxy {
    public static int saltGrassRenderType;

    public static int evaporatorRenderType;

    public static void setBlockRenderers() {
        saltGrassRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new SaltGrassRenderer());
        evaporatorRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new EvaporatorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlossomSign.class, new TileEntityBlossomSignRenderer());
    }

    @SideOnly(Side.CLIENT)
    public static void setEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmaker.class, new RenderSnowball(ModItems.rainmaker));
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmakerDust.class, new RenderRainmakerDust());
    }
}
