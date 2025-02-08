package net.gamegamer.ninjago.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class FireWave extends PathAwareEntity {

    public FireWave(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}


