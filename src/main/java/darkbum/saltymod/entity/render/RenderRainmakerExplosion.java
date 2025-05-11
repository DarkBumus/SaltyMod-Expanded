package darkbum.saltymod.entity.render;

import darkbum.saltymod.entity.EntityRainmakerExplosion;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Renderer class for {@link EntityRainmakerExplosion}.
 * This renderer is currently a placeholder and does not render any visual effects.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class RenderRainmakerExplosion extends Render {

    /**
     * Does not render any visuals for the Rainmaker Explosion entity.
     *
     * @param entity The entity to render.
     * @param x The X position to render at.
     * @param y The Y position to render at.
     * @param z The Z position to render at.
     * @param width The width parameter (unused).
     * @param height The height parameter (unused).
     */
    @Override
    public void doRender(Entity entity, double x, double y, double z, float width, float height) {}

    /**
     * Returns the texture resource for the entity.
     * As this renderer does not render any visuals, this method returns null.
     *
     * @param entity The entity for which the texture is requested.
     * @return null, as no texture is associated with this renderer.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}
