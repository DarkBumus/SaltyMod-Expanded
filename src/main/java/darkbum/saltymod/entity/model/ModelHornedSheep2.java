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
        super(12, 0.0f);
        textureWidth = 64;
        textureHeight = 64;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        head.setRotationPoint(0.0f, 6.0f, -8.0f);
        body = new ModelRenderer(this, 28, 8);
        body.addBox(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        body.setRotationPoint(0.0f, 5.0f, 2.0f);
        leg1 = new ModelRenderer(this, 0, 16);
        leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        leg1.setRotationPoint(-3.0f, 12.0f, 7.0f);
        leg2 = new ModelRenderer(this, 0, 16);
        leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        leg2.setRotationPoint(3.0f, 12.0f, 7.0f);
        leg3 = new ModelRenderer(this, 0, 16);
        leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        leg3.setRotationPoint(-3.0f, 12.0f, -5.0f);
        leg4 = new ModelRenderer(this, 0, 16);
        leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        leg4.setRotationPoint(3.0f, 12.0f, -5.0f);
        if (!ModConfigurationEntities.hornedSheepThinHorns) {
            head.setTextureOffset(0, 32).addBox(-7.0f, -5.0f, -4.5f, 4, 7, 6, 0.0f);
            head.setTextureOffset(0, 45).addBox(-7.0f, -1.0f, -7.5f, 4, 3, 3, 0.0f);
            ModelRenderer leftHorn1 = new ModelRenderer(this, 0, 32);
            leftHorn1.mirror = true;
            leftHorn1.setTextureOffset(0, 32).addBox(3.0f, -5.0f, -4.5f, 4, 7, 6, 0.0f);
            head.addChild(leftHorn1);
            ModelRenderer leftHorn2 = new ModelRenderer(this, 0, 45);
            leftHorn2.mirror = true;
            leftHorn2.setTextureOffset(0, 45).addBox(3.0f, -1.0f, -7.5f, 4, 3, 3, 0.0f);
            head.addChild(leftHorn2);
        }
        if (ModConfigurationEntities.hornedSheepThinHorns) {
            head.setTextureOffset(20, 32).addBox(-5.0f, -5.0f, -4.5f, 2, 7, 6, 0.0f);
            head.setTextureOffset(20, 45).addBox(-5.0f, -1.0f, -7.5f, 2, 3, 3, 0.0f);
            ModelRenderer leftHorn1 = new ModelRenderer(this, 0, 32);
            leftHorn1.mirror = true;
            leftHorn1.setTextureOffset(20, 32).addBox(3.0f, -5.0f, -4.5f, 2, 7, 6, 0.0f);
            head.addChild(leftHorn1);
            ModelRenderer leftHorn2 = new ModelRenderer(this, 0, 45);
            leftHorn2.mirror = true;
            leftHorn2.setTextureOffset(20, 45).addBox(3.0f, -1.0f, -7.5f, 2, 3, 3, 0.0f);
            head.addChild(leftHorn2);
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
        head.rotationPointY = 6.0f + ((EntityHornedSheep)entityLivingBase).func_70894_j(entityTickTime) * 9.0f;
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
