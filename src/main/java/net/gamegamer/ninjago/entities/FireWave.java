package net.gamegamer.ninjago.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.attribute.EntityAttributes;

public class FireWave extends Entity {

    public FireWave(EntityType<? extends Entity> entityType, World world) {
        super(entityType, world);
        this.noClip = true; // Make the entity pass through blocks
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    public void tick() {
        super.tick();

        // Update hitbox dynamically
        this.setBoundingBox(this.getDimensions(EntityPose.STANDING).getBoxAt(this.getPos()));

        // Debugging: Check if entity is ticking
        System.out.println("Shockwave entity is ticking at: " + this.getPos());

        // Despawn after 1 second (20 ticks)
        if (this.age > 20) {
            this.discard();
        }
    }



    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }


    public boolean isInvulnerableTo(DamageSource damageSource) {
        return true; // Make the entity invulnerable
    }

    @Override
    public boolean isCollidable() {
        return false; // Disable collisions
    }


}