package darkbum.saltymod.common.proxy;

import darkbum.saltymod.block.render.*;
import darkbum.saltymod.common.config.ModConfigurationBlocks;
import darkbum.saltymod.common.config.ModConfigurationWorldGeneration;
import net.minecraft.client.renderer.entity.RenderSnowball;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.entity.EntityHornedSheep;
import darkbum.saltymod.entity.EntityRainmaker;
import darkbum.saltymod.entity.EntityRainmakerExplosion;
import darkbum.saltymod.entity.model.ModelHornedSheep1;
import darkbum.saltymod.entity.model.ModelHornedSheep2;
import darkbum.saltymod.entity.render.RenderHornedSheep;
import darkbum.saltymod.entity.render.RenderRainmakerExplosion;
import darkbum.saltymod.init.ModItems;
import net.minecraft.util.IIcon;

import static cpw.mods.fml.client.registry.RenderingRegistry.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;
import static darkbum.saltymod.common.config.ModConfigurationWorldGeneration.*;

/**
 * Client-side proxy class responsible for client-only initializations like custom renderers for blocks and entities.
 * This class extends behavior defined in {@link CommonProxy}.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ClientProxy extends CommonProxy {

    /** Custom icon for milk. */
    @SideOnly(Side.CLIENT)
    public static IIcon MILK;

    /** Custom render IDs for special block renderers. */
    @SideOnly(Side.CLIENT)
    public static int saltGrassRenderType;

    @SideOnly(Side.CLIENT)
    public static int cookingPotRenderType;

    @SideOnly(Side.CLIENT)
    public static int marshReedsRenderType;

    /**
     * Helper method that overrides from CommonProxy and makes sure the renderer methods are only called client-side.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void setRenderers() {
        setBlockRenderers();
        setEntityRenderers();
    }

    /**
     * Registers custom block renderers using unique render IDs.
     * Called during client-side initialization.
     */
    public void setBlockRenderers() {
        if (enableSaltDirt) {
            saltGrassRenderType = getNextAvailableRenderId();
            registerBlockHandler(new SaltGrassRenderer());
        }

        if (enableMachines) {
            cookingPotRenderType = getNextAvailableRenderId();
            registerBlockHandler(new CookingPotRenderer());
        }

        if (enableSaltMarsh) {
            marshReedsRenderType = getNextAvailableRenderId();
            registerBlockHandler(new MarshReedsRenderer());
        }
    }

    /**
     * Registers custom entity renderers.
     * This method must only be called on the client side.
     */
    public void setEntityRenderers() {
        registerEntityRenderingHandler(EntityRainmaker.class, new RenderSnowball(ModItems.rainmaker));
        registerEntityRenderingHandler(EntityRainmakerExplosion.class, new RenderRainmakerExplosion());
        registerEntityRenderingHandler(EntityHornedSheep.class, new RenderHornedSheep(new ModelHornedSheep2(), new ModelHornedSheep1(), 0.7f));
    }
}
