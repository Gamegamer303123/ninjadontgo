package net.gamegamer.ninjago.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class FireWave extends Entity {

    public FireWave(EntityType<? extends FireWave> entityType, World world) {
        super(entityType, world);
        this.noClip = true;
        this.setNoGravity(true);
    }


    protected void initDataTracker() {
        // No data to track for now
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        // Read entity data from NBT (if needed)
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        // Write entity data to NBT (if needed)
    }

    @Override
    public boolean isPushable() {
        return false; // Can't be pushed
    }

    public boolean isInvulnerableTo(DamageSource damageSource) {
        return true; // Make the entity invulnerable
    }

    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return false; // Disable collisions
    }


    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    public boolean canHit() {
        return false; // Can't be hit by projectiles or attacks
    }
}
