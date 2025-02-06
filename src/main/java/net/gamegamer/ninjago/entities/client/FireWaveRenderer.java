package net.gamegamer.ninjago.entities.client;

import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.entities.FireWave;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.util.Identifier;

public class FireWaveRenderer extends EmptyEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(Ninjadontgo.MOD_ID, "textures/entities/firewave.png");

    public FireWaveRenderer(EntityRendererFactory.Context context) {
        super(context);
    }




    public Identifier getTexture(FireWave entity) {
        return TEXTURE;
    }
}
