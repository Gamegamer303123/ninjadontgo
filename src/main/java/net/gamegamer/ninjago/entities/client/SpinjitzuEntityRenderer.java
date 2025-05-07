package net.gamegamer.ninjago.entities.client;

import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.NinjadontgoClient;
import net.gamegamer.ninjago.entities.SpinjitzuEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class SpinjitzuEntityRenderer extends EntityRenderer<SpinjitzuEntity> {

    private static final Identifier TEXTURE = Identifier.of(Ninjadontgo.MOD_ID, "textures/entity/firewave.png");
    private final SpinjitzuModel model;

    public SpinjitzuEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new SpinjitzuModel(ctx.getPart(NinjadontgoClient.SPINJITZU_LAYER));
    }

    @Override
    public void render(SpinjitzuEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        float spin = (entity.age + tickDelta) * 30f;
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(spin));

        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        model.getPart().render(matrices, vc, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(SpinjitzuEntity entity) {
        return TEXTURE;
    }
}