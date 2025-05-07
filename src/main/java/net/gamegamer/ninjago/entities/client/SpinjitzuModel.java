package net.gamegamer.ninjago.entities.client;

import net.gamegamer.ninjago.entities.SpinjitzuEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.Identifier;

public class SpinjitzuModel extends SinglePartEntityModel<SpinjitzuEntity> {

    private final ModelPart root;

    public SpinjitzuModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData part = modelData.getRoot().addChild("main",
                ModelPartBuilder.create().uv(0, 0)
                        .cuboid(-4.0f, 0.0f, -4.0f, 8.0f, 1.0f, 8.0f),
                ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(SpinjitzuEntity entity, float limbAngle, float limbDistance, float age, float headYaw, float headPitch) {
        // spinning handled in renderer
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
