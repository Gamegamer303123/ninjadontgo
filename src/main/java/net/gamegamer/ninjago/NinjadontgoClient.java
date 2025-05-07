package net.gamegamer.ninjago;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.ModEntities;
import net.gamegamer.ninjago.entities.client.FireWaveModel;
import net.gamegamer.ninjago.entities.client.FireWaveRenderer;
import net.gamegamer.ninjago.entities.client.SpinjitzuEntityRenderer;
import net.gamegamer.ninjago.entities.client.SpinjitzuModel;
import net.gamegamer.ninjago.particles.FireWaveParticle;
import static net.gamegamer.ninjago.entities.ModEntities.SPINJITZU_ENTITY_TYPE;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static net.gamegamer.ninjago.entities.ModEntities.FIREWAVE;


public class NinjadontgoClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(Identifier.of(Ninjadontgo.MOD_ID, "textures/entity/cube"), "main");

    public static final EntityModelLayer SPINJITZU_LAYER = new EntityModelLayer(
            Identifier.of(Ninjadontgo.MOD_ID, "spinjitzu"), "main");



   /* private static final SpriteIdentifier FIREWAVE_PARTICLE_SPRITE = new SpriteIdentifier(
            SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE, // The particle atlas
            Identifier.of(Ninjadontgo.MOD_ID, "particle/firewave_particle") // Path to your texture
    );
*/

    @Override
    public void onInitializeClient() {
        // For this example, we will use the end rod particle behaviour.
        ParticleFactoryRegistry.getInstance().register(Ninjadontgo.FIREWAVEPARTICLE, FireWaveParticle.Factory::new);


        EntityRendererRegistry.register(ModEntities.SPINJITZU_ENTITY_TYPE, context ->
                new SpinjitzuEntityRenderer(context)
        );

        EntityModelLayerRegistry.registerModelLayer(SPINJITZU_LAYER, SpinjitzuModel::getTexturedModelData);

        //ParticleFactoryRegistry.getInstance().register(ModParticles.FIREWAVE_PARTICLE, FireWaveParticle.Factory::new);
      //  ParticleFactoryRegistry.getInstance().register(ModParticles.FIREWAVE_PARTICLE, (spriteProvider) -> {
          //  return new FireWaveParticle.Factory(spriteProvider);
        //});




    }
}
