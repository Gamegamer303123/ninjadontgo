package net.gamegamer.ninjago.entities;

import net.gamegamer.ninjago.item.FireSword;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class FireWave extends Entity {
    public FireWave(EntityType<?> type, World world) {
        super(type, world);
        this.setNoGravity(true);


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

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
    }
}

