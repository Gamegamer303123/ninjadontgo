package net.gamegamer.ninjago;

import net.fabricmc.api.ClientModInitializer;
import net.gamegamer.ninjago.entities.client.ModEntityRenderers;

public class NinjadontgoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityRenderers.register();

    }
}
