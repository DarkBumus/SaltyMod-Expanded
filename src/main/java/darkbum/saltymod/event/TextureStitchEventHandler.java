package darkbum.saltymod.event;

import darkbum.saltymod.common.proxy.ClientProxy;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import static darkbum.saltymod.init.recipes.ModEvaporatorRecipes.milk;

public class TextureStitchEventHandler {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureStitchPre1(TextureStitchEvent.Pre event) {
        if (event.map.getTextureType() == 0 && FluidRegistry.isFluidRegistered(milk)) {
            ClientProxy.MILK = event.map.registerIcon("saltymod:milk");
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureStitchPost1(TextureStitchEvent.Post event) {
        if (FluidRegistry.isFluidRegistered(milk)) {
            milk.setIcons(ClientProxy.MILK);
        }
    }
}
