package net.gamegamer.ninjago.entities.client;

import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.entities.FireWave;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class FireWaveRenderer extends EntityRenderer<FireWave> {

    private static final Identifier TEXTURE = Identifier.of(Ninjadontgo.MOD_ID, "textures/entity/firewave.png");

    public FireWaveRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }













    public Identifier getTexture(FireWave entity) {
        return TEXTURE;
    }
}