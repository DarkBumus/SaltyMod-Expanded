package darkbum.saltymod.entity.model;

import darkbum.saltymod.configuration.configs.ModConfigurationEntities;
import darkbum.saltymod.entity.EntityHornedSheep;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelHornedSheep2 extends ModelQuadruped {

    private float field_78153_i;

    public ModelHornedSheep2() {
        super(12, 0.0F);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
        this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
        if (ModConfigurationEntities.hornedSheepThinHorns) {
            this.head.setTextureOffset(0, 32).addBox(3.0F, -5.0F, -4.5F, 2, 7, 6, 0.0F);
            this.head.setTextureOffset(0, 45).addBox(3.0F, -1.0F, -7.5F, 2, 3, 3, 0.0F);
            this.head.setTextureOffset(20, 32).addBox(-5.0F, -5.0F, -4.5F, 2, 7, 6, 0.0F);
            this.head.setTextureOffset(14, 45).addBox(-5.0F, -1.0F, -7.5F, 2, 3, 3, 0.0F);
        }
        if (!ModConfigurationEntities.hornedSheepThinHorns) {
            this.head.setTextureOffset(0, 32).addBox(3.0F, -5.0F, -4.5F, 4, 7, 6, 0.0F);
            this.head.setTextureOffset(0, 45).addBox(3.0F, -1.0F, -7.5F, 4, 3, 3, 0.0F);
            this.head.setTextureOffset(20, 32).addBox(-7.0F, -5.0F, -4.5F, 4, 7, 6, 0.0F);
            this.head.setTextureOffset(14, 45).addBox(-7.0F, -1.0F, -7.5F, 4, 3, 3, 0.0F);
        }
    }

    public void setLivingAnimations(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAngle, float entityTickTime) {
        super.setLivingAnimations(entityLivingBase, limbSwing, limbSwingAngle, entityTickTime);
        this.head.rotationPointY = 6.0F + ((EntityHornedSheep)entityLivingBase).func_70894_j(entityTickTime) * 9.0F;
        this.field_78153_i = ((EntityHornedSheep)entityLivingBase).func_70890_k(entityTickTime);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAngles, float entityTickTime, float rotationYaw, float rotationPitch, float unitPixel, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAngles, entityTickTime, rotationYaw, rotationPitch, unitPixel, entity);
        this.head.rotateAngleX = this.field_78153_i;
    }
}
