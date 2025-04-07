package darkbum.saltymod.entity.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHornedSheep extends RenderSheep {

    private static final ResourceLocation sheared = new ResourceLocation(
        "saltymod:textures/entity/horned_sheep/old.png");

    public RenderHornedSheep(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return sheared;
    }
}
