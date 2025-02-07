package net.gamegamer.ninjago;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.client.FireWaveModel;
import net.gamegamer.ninjago.entities.client.FireWaveRenderer;

import static net.gamegamer.ninjago.entities.ModEntityTypes.FIREWAVE;


public class NinjadontgoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FIREWAVE, FireWaveRenderer::new);




    }
}
