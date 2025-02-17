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
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public class FireWaveParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;


    //private static final Identifier TEXTURE = Identifier.of(Ninjadontgo.MOD_ID, "textures/particle/fire_wave_particle.png");

    protected FireWaveParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.maxAge = 10; // Lifespan of the particle (in ticks)
        this.scale(20.0f); // Size of the particle
        this.spriteProvider = spriteProvider;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.velocityZ = 0.0;
        this.setSpriteForAge(spriteProvider);

    }

    public float getSize(float tickDelta) {
        return this.scale * MathHelper.clamp(((float)this.age + tickDelta) / (float)this.maxAge * 0.75F, 0.0F, 1.0F);
    }



    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(this.spriteProvider); // Change sprite as it ages
    }





    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        Quaternionf quaternionf = new Quaternionf();
        quaternionf.rotationX(-1.570796327F);
        this.method_60373(vertexConsumer, camera, quaternionf, tickDelta);
        quaternionf.rotationYXZ(0F, 1.570796327F, 1.570796327F);
        this.method_60373(vertexConsumer, camera, quaternionf, tickDelta);
    }




    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            FireWaveParticle particle = new FireWaveParticle(world, x, y + 0.01, z, velocityX, velocityY, velocityZ, this.spriteProvider);
            particle.setSpriteForAge(this.spriteProvider);
            return particle;
        }
    }
}
