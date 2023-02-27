package ru.liahim.saltmod.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderSnowball;
import ru.liahim.saltmod.block.render.ExtractorRenderer;
import ru.liahim.saltmod.block.render.SaltGrassRenderer;
import ru.liahim.saltmod.entity.EntityRainmaker;
import ru.liahim.saltmod.entity.EntityRainmakerDust;
import ru.liahim.saltmod.entity.render.RenderRainmakerDust;
import ru.liahim.saltmod.init.ModItems;

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
