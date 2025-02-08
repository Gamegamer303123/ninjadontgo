package net.gamegamer.ninjago;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gamegamer.ninjago.entities.ModEntityTypes;
import net.gamegamer.ninjago.entities.client.FireWaveRenderer;

import net.gamegamer.ninjago.particles.ModParticles;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import static net.gamegamer.ninjago.entities.ModEntityTypes.FIREWAVE;


public class NinjadontgoClient implements ClientModInitializer {

   /* private static final SpriteIdentifier FIREWAVE_PARTICLE_SPRITE = new SpriteIdentifier(
            SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE, // The particle atlas
            Identifier.of(Ninjadontgo.MOD_ID, "particle/firewave_particle") // Path to your texture
    );
*/

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntityTypes.FIREWAVE, FireWaveRenderer::new);
        //ParticleFactoryRegistry.getInstance().register(ModParticles.FIREWAVE_PARTICLE, FireWaveParticle.Factory::new);
      //  ParticleFactoryRegistry.getInstance().register(ModParticles.FIREWAVE_PARTICLE, (spriteProvider) -> {
          //  return new FireWaveParticle.Factory(spriteProvider);
        //});



    }
}
