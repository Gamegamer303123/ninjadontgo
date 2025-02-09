package net.gamegamer.ninjago.entities.client;

import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.NinjadontgoClient;
import net.gamegamer.ninjago.entities.FireWave;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import static net.gamegamer.ninjago.NinjadontgoClient.MODEL_CUBE_LAYER;

public class FireWaveRenderer extends EntityRenderer<FireWave> {

    private final FireWaveModel model;

    public FireWaveRenderer(EntityRendererFactory.Context context) {
        super(context);

        this.model = new FireWaveModel(context.getPart(MODEL_CUBE_LAYER));
    }

    @Override
    public void render(FireWave entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        // Apply rotation or transformations if needed
        this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(getTexture(entity))), light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(FireWave entity) {
        return Identifier.of(Ninjadontgo.MOD_ID, "textures/entity/firewave.png");
    }
}