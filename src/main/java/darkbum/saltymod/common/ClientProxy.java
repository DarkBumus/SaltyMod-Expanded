package darkbum.saltymod.common;

import net.minecraft.client.renderer.entity.RenderSnowball;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.block.renderer.EvaporatorRenderer;
import darkbum.saltymod.block.renderer.SaltGrassRenderer;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import darkbum.saltymod.entity.model.ModelHornedSheep;
import darkbum.saltymod.entity.model.ModelHornedSheepFur;
import darkbum.saltymod.entity.renderer.RenderHornedSheep;
import darkbum.saltymod.entity.renderer.RenderRainmakerDust;
import darkbum.saltymod.init.ModItems;

public class ClientProxy extends CommonProxy {

    public static int saltGrassRenderType;

    public static int evaporatorRenderType;

    public static void setBlockRenderers() {
        saltGrassRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new SaltGrassRenderer());
        evaporatorRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new EvaporatorRenderer());
    }

    @SideOnly(Side.CLIENT)
    public static void setEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmaker.class, new RenderSnowball(ModItems.rainmaker));
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmakerDust.class, new RenderRainmakerDust());
        RenderingRegistry.registerEntityRenderingHandler(
            EntityHornedSheep.class,
            new RenderHornedSheep(new ModelHornedSheep(), new ModelHornedSheepFur(), 0.7F));
    }
}
