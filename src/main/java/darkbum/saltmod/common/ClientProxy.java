package darkbum.saltmod.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltmod.init.ModItems;
import net.minecraft.client.renderer.entity.RenderSnowball;
import darkbum.saltmod.blocks.render.ExtractorRenderer;
import darkbum.saltmod.blocks.render.SaltGrassRenderer;
import darkbum.saltmod.entities.EntityRainmaker;
import darkbum.saltmod.entities.EntityRainmakerDust;
import darkbum.saltmod.entities.render.RenderRainmakerDust;

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
