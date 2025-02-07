package net.gamegamer.ninjago.entities.client;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gamegamer.ninjago.entities.ModEntityTypes;
@Environment(EnvType.CLIENT)
public class ModEntityRenderers {
    public static void register() {
        EntityRendererRegistry.register(ModEntityTypes.FIREWAVE, FireWaveRenderer::new);
    }
}