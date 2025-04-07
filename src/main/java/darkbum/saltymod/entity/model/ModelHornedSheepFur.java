package darkbum.saltymod.entity.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSheep2;

public class ModelHornedSheepFur extends ModelSheep2 {

    /*
     * public ModelHornedSheepFur() {
     * // super(12, 0.0F);
     * this.head = new ModelRenderer(this, 0, 0);
     * this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
     * this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
     * this.body = new ModelRenderer(this, 28, 8);
     * this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
     * this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
     * }
     */

    public ModelHornedSheepFur() {
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
        this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0F, -9.0F, -7.0F, 8, 15, 6, 0.5F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        float f = 0.4F;
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
        this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
        this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
        this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
        this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
    }
}
