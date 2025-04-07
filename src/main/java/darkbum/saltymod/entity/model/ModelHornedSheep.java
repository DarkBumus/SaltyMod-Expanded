package darkbum.saltymod.entity.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSheep1;

public class ModelHornedSheep extends ModelSheep1 {

    /*
     * public ModelHornedSheep() {
     * // super(12, 0.0F);
     * this.head = new ModelRenderer(this, 0, 0);
     * this.head.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
     * this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
     * this.body = new ModelRenderer(this, 28, 8);
     * this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
     * this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
     * float f = 0.5F;
     * this.leg1 = new ModelRenderer(this, 0, 16);
     * this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
     * this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
     * this.leg2 = new ModelRenderer(this, 0, 16);
     * this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
     * this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
     * this.leg3 = new ModelRenderer(this, 0, 16);
     * this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
     * this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
     * this.leg4 = new ModelRenderer(this, 0, 16);
     * this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
     * this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
     * }
     */

    public ModelHornedSheep() {
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 7, 0.0F);
        this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.body = new ModelRenderer(this, 36, 10);
        this.body.addBox(-4.0F, -9.0F, -7.0F, 8, 15, 6, 0.0F);
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
        this.head.setTextureOffset(28, 16)
            .addBox(-5.0F, -4.0F, -4.0F, 2, 2, 2, 0.0F);
        this.head.setTextureOffset(16, 13)
            .addBox(-6.0F, -5.0F, -3.0F, 2, 2, 4, 0.0F);
        this.head.setTextureOffset(16, 19)
            .addBox(-7.0F, -4.0F, 0.0F, 2, 5, 2, 0.0F);
        this.head.setTextureOffset(18, 27)
            .addBox(-8.0F, 0.0F, -2.0F, 2, 2, 3, 0.0F);
        this.head.setTextureOffset(28, 27)
            .addBox(-9.0F, -1.0F, -3.0F, 2, 2, 1, 0.0F);
        this.head.setTextureOffset(28, 16)
            .addBox(3.0F, -4.0F, -4.0F, 2, 2, 2, 0.0F);
        this.head.setTextureOffset(16, 13)
            .addBox(4.0F, -5.0F, -3.0F, 2, 2, 4, 0.0F);
        this.head.setTextureOffset(16, 19)
            .addBox(5.0F, -4.0F, 0.0F, 2, 5, 2, 0.0F);
        this.head.setTextureOffset(18, 27)
            .addBox(6.0F, 0.0F, -2.0F, 2, 2, 3, 0.0F);
        this.head.setTextureOffset(28, 27)
            .addBox(7.0F, -1.0F, -3.0F, 2, 2, 1, 0.0F);
    }
}
