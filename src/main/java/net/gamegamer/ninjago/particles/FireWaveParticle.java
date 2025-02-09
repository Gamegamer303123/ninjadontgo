package net.gamegamer.ninjago.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.gamegamer.ninjago.Ninjadontgo;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class FireWaveParticle extends SpriteBillboardParticle {

    private static final Identifier TEXTURE = Identifier.of(Ninjadontgo.MOD_ID, "textures/particle/fire_wave_particle.png");

    protected FireWaveParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.maxAge = 20; // Lifespan of the particle (in ticks)
        this.scale(2.0f); // Size of the particle
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        this.angle = 0; // Reset the angle to prevent rotation
        super.buildGeometry(vertexConsumer, camera, tickDelta);

    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;  // Use a custom particle sheet
    }
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            FireWaveParticle particle = new FireWaveParticle(world, x, y, z, velocityX, velocityY, velocityZ);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}
