package darkbum.saltymod.entity.model;

import darkbum.saltymod.common.config.ModConfigurationEntities;
import darkbum.saltymod.entity.EntityHornedSheep;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * Model class for {@link EntityHornedSheep}.
 * The horned sheep is a sheep-like entity with horns.
 *
 * @author DarkBum
 * @since 2.0.0
 */
public class ModelHornedSheep2 extends ModelQuadruped {

    private float headRotationAngle;

    /**
     * Constructs a new ModelHornedSheep2 instance and initializes the model parts.
     */
    public ModelHornedSheep2() {
        super(12, 0.0F);
        textureWidth = 64;
        textureHeight = 64;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
        head.setRotationPoint(0.0F, 6.0F, -8.0F);
        body = new ModelRenderer(this, 28, 8);
        body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
        body.setRotationPoint(0.0F, 5.0F, 2.0F);
        leg1 = new ModelRenderer(this, 0, 16);
        leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
        leg2 = new ModelRenderer(this, 0, 16);
        leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
        leg3 = new ModelRenderer(this, 0, 16);
        leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
        leg4 = new ModelRenderer(this, 0, 16);
        leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
        if (ModConfigurationEntities.hornedSheepThinHorns) {
            head.setTextureOffset(0, 32).addBox(3.0F, -5.0F, -4.5F, 2, 7, 6, 0.0F);
            head.setTextureOffset(0, 45).addBox(3.0F, -1.0F, -7.5F, 2, 3, 3, 0.0F);
            head.setTextureOffset(20, 32).addBox(-5.0F, -5.0F, -4.5F, 2, 7, 6, 0.0F);
            head.setTextureOffset(14, 45).addBox(-5.0F, -1.0F, -7.5F, 2, 3, 3, 0.0F);
        }
        if (!ModConfigurationEntities.hornedSheepThinHorns) {
            head.setTextureOffset(0, 32).addBox(3.0F, -5.0F, -4.5F, 4, 7, 6, 0.0F);
            head.setTextureOffset(0, 45).addBox(3.0F, -1.0F, -7.5F, 4, 3, 3, 0.0F);
            head.setTextureOffset(20, 32).addBox(-7.0F, -5.0F, -4.5F, 4, 7, 6, 0.0F);
            head.setTextureOffset(14, 45).addBox(-7.0F, -1.0F, -7.5F, 4, 3, 3, 0.0F);
        }
    }

    /**
     * Updates the model's animation parameters based on the entity's state.
     *
     * @param entityLivingBase The entity instance.
     * @param limbSwing The limb swing distance.
     * @param limbSwingAngle The limb swing angle.
     * @param entityTickTime The entity's tick time.
     */
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAngle, float entityTickTime) {
        super.setLivingAnimations(entityLivingBase, limbSwing, limbSwingAngle, entityTickTime);
        head.rotationPointY = 6.0F + ((EntityHornedSheep)entityLivingBase).func_70894_j(entityTickTime) * 9.0F;
        headRotationAngle = ((EntityHornedSheep)entityLivingBase).func_70890_k(entityTickTime);
    }

    /**
     * Sets the rotation angles for the model's parts.
     *
     * @param limbSwing The limb swing distance.
     * @param limbSwingAngles The limb swing angle.
     * @param entityTickTime The entity's tick time.
     * @param rotationYaw The entity's yaw rotation.
     * @param rotationPitch The entity's pitch rotation.
     * @param unitPixel The scaling factor.
     * @param entity The entity instance.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAngles, float entityTickTime, float rotationYaw, float rotationPitch, float unitPixel, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAngles, entityTickTime, rotationYaw, rotationPitch, unitPixel, entity);
        head.rotateAngleX = this.headRotationAngle;
    }
}
