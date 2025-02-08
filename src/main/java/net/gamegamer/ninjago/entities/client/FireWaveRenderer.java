package net.gamegamer.ninjago.entities.client;

import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.NinjadontgoClient;
import net.gamegamer.ninjago.entities.FireWave;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class FireWaveRenderer extends MobEntityRenderer<FireWave, FireWaveModel> {

    public FireWaveRenderer(EntityRendererFactory.Context context) {
        super(context, new FireWaveModel(context.getPart(NinjadontgoClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(FireWave entity) {
        return Identifier.of(Ninjadontgo.MOD_ID, "textures/entity/firewave.png");
    }
}