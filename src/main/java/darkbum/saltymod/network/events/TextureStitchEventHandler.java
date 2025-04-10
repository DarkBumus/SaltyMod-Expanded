package darkbum.saltymod.network.events;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.common.CommonProxy;

public class TextureStitchEventHandler {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureStitchPre1(TextureStitchEvent.Pre event) {
        if (event.map.getTextureType() == 0 && FluidRegistry.isFluidRegistered(CommonProxy.milk)) {
            CommonProxy.milkIcon = event.map.registerIcon("saltymod:milk");
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureStitchPost1(TextureStitchEvent.Post event) {
        if (FluidRegistry.isFluidRegistered(CommonProxy.milk)) {
            CommonProxy.milk.setIcons(CommonProxy.milkIcon);
        }
    }
}
