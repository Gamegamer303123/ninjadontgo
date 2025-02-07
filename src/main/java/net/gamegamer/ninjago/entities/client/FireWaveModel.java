package net.gamegamer.ninjago.entities.client;

import com.ibm.icu.text.Normalizer;
import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.entities.FireWave;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class FireWaveModel extends Model {
    private final ModelPart base;

    public FireWaveModel(ModelPart root) {
        super(root, RenderLayer::getEntityCutoutNoCull);
        this.base = root.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // Create a flat plane (5x5)
        root.addChild("base", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-2.5F, 0F, -2.5F, 5F, 0.1F, 5F),
                ModelTransform.pivot(0F, 0F, 0F));

        return TexturedModelData.of(modelData, 32, 32);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertices, light, overlay);
    }


}