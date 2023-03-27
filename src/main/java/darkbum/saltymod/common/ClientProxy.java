package darkbum.saltymod.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModItems;
import net.minecraft.client.renderer.entity.RenderSnowball;
import darkbum.saltymod.block.render.ExtractorRenderer;
import darkbum.saltymod.block.render.SaltGrassRenderer;
import darkbum.saltymod.entities.EntityRainmaker;
import darkbum.saltymod.entities.EntityRainmakerDust;
import darkbum.saltymod.entities.render.RenderRainmakerDust;

public class ClientProxy extends CommonProxy {
    public static int saltGrassRenderType;

    public static int extractorRenderType;

    public static void setBlockRenderers() {
        saltGrassRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new SaltGrassRenderer());
        extractorRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new ExtractorRenderer());
    }

    @SideOnly(Side.CLIENT)
    public static void setEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmaker.class, new RenderSnowball(ModItems.rainmaker));
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmakerDust.class, new RenderRainmakerDust());
    }
}
