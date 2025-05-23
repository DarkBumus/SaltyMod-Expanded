package darkbum.saltymod.event;

import darkbum.saltymod.common.proxy.ClientProxy;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import static darkbum.saltymod.init.recipes.ModEvaporatorRecipes.milk;

/**
 * Event handler class for texture stitching-related events.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class TextureStitchEventHandler {

    /**
     * Handles the pre-stitch event for fluid textures.
     *
     * @param event The {@link TextureStitchEvent.Pre} event instance.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTextureStitchPre(TextureStitchEvent.Pre event) {
        if (event.map.getTextureType() == 0 && FluidRegistry.isFluidRegistered(milk)) {
            ClientProxy.MILK = event.map.registerIcon("saltymod:milk");
        }
    }

    /**
     * Handles the post-stitch event for fluid textures.
     *
     * @param event The {@link TextureStitchEvent.Post} event instance.
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTextureStitchPost(TextureStitchEvent.Post event) {
        if (FluidRegistry.isFluidRegistered(milk)) {
            milk.setIcons(ClientProxy.MILK);
        }
    }
}
