package darkbum.saltymod.common;

import darkbum.saltymod.block.render.MarshReedsRenderer;
import net.minecraft.client.renderer.entity.RenderSnowball;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.block.render.EvaporatorRenderer;
import darkbum.saltymod.block.render.SaltGrassRenderer;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerDust;
import darkbum.saltymod.entity.model.ModelHornedSheep1;
import darkbum.saltymod.entity.model.ModelHornedSheep2;
import darkbum.saltymod.entity.render.RenderHornedSheep;
import darkbum.saltymod.entity.render.RenderRainmakerDust;
import darkbum.saltymod.init.ModItems;

public class ClientProxy extends CommonProxy {

    public static int evaporatorRenderType;

    public static int saltGrassRenderType;

    public static int marshReedsRenderType;

    public static void setBlockRenderers() {
        evaporatorRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new EvaporatorRenderer());
        saltGrassRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new SaltGrassRenderer());
        marshReedsRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new MarshReedsRenderer());
    }

    @SideOnly(Side.CLIENT)
    public static void setEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmaker.class, new RenderSnowball(ModItems.rainmaker));
        RenderingRegistry.registerEntityRenderingHandler(EntityRainmakerDust.class, new RenderRainmakerDust());
        RenderingRegistry.registerEntityRenderingHandler(
            EntityHornedSheep.class,
            new RenderHornedSheep(new ModelHornedSheep2(), new ModelHornedSheep1(), 0.7F));
    }
}
