package net.gamegamer.ninjago.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class SpinjitzuEntity extends Entity {

    public SpinjitzuEntity(EntityType<?> type, World world) {
        super(type, world);
        this.noClip = true; // if you want it to ignore collisions
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }


    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}

    @Override
    public void tick() {
        super.tick();

        if (this.age == 1) {
            System.out.println("[DEBUG] SpinjitzuEntity exists and is ticking.");
        }




        if (this.hasVehicle()) {
            // Follow the player closely
            this.setPosition(this.getVehicle().getX(), this.getVehicle().getY(), this.getVehicle().getZ());
        }

    }
}
