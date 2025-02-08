/*package net.gamegamer.ninjago.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
public class FirewaveParticle extends BillboardParticle {

    private static final Identifier TEXTURE = Identifier.of("ninjadontgo", "textures/particle/firewave_particle.png");

    protected FirewaveParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.maxAge = 20; // Lifespan of the particle (in ticks)
        this.scale = 2.0F; // Size of the particle
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM; // Use a custom particle sheet
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        // Render the particle as a flat, static texture
        Vec3d cameraPos = camera.getPos();
        float x = (float) (MathHelper.lerp(tickDelta, this.prevPosX, this.x) - cameraPos.getX());
        float y = (float) (MathHelper.lerp(tickDelta, this.prevPosY, this.y) - cameraPos.getY());
        float z = (float) (MathHelper.lerp(tickDelta, this.prevPosZ, this.z) - cameraPos.getZ());

        MatrixStack matrixStack = new MatrixStack();
        matrixStack.translate(x, y, z);
        matrixStack.multiply(camera.getRotation());

        // Render the particle as a flat plane
        float size = this.getSize(tickDelta);
        int light = this.getBrightness(tickDelta);

        // Define the vertices of the particle
        vertexConsumer.vertex(matrixStack.peek().getPositionMatrix(), -size, -size, 0)
                .color(this.red, this.green, this.blue, this.alpha)
                .texture(0, 1)
                .light(light)
                .next();
        vertexConsumer.vertex(matrixStack.peek().getPositionMatrix(), -size, size, 0)
                .color(this.red, this.green, this.blue, this.alpha)
                .texture(0, 0)
                .light(light)
                .next();
        vertexConsumer.vertex(matrixStack.peek().getPositionMatrix(), size, size, 0)
                .color(this.red, this.green, this.blue, this.alpha)
                .texture(1, 0)
                .light(light)
                .next();
        vertexConsumer.vertex(matrixStack.peek().getPositionMatrix(), size, -size, 0)
                .color(this.red, this.green, this.blue, this.alpha)
                .texture(1, 1)
                .light(light)
                .next();
    }

    @Override
    protected float getMinU() {
        return 0.0F; // Minimum U texture coordinate
    }

    @Override
    protected float getMaxU() {
        return 1.0F; // Maximum U texture coordinate
    }

    @Override
    protected float getMinV() {
        return 0.0F; // Minimum V texture coordinate
    }

    @Override
    protected float getMaxV() {
        return 1.0F; // Maximum V texture coordinate
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final TextureManager textureManager;

        public Factory(TextureManager textureManager) {
            this.textureManager = textureManager;
        }

        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new FirewaveParticle(world, x, y, z, velocityX, velocityY, velocityZ);
        }
    }
}*/