package net.gamegamer.ninjago.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.gamegamer.ninjago.Ninjadontgo;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModEntities extends Entity {
    public ModEntities(EntityType<?> type, World world) {
        super(type, world);

    }


    public static final EntityType<ModEntities> SHOCKWAVE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Ninjadontgo.MOD_ID, "firewave"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ModEntities::new)
                    .dimensions(EntityDimensions.fixed(5.0F, 0.1F)) // Size of the shockwave
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(Ninjadontgo.MOD_ID, "firewave"))) // Corrected
    );



    //Cannot resolve method 'register(DefaultedRegistry<EntityType<?>>, Identifier, FabricEntityTypeBuilder<T>)'
    //public static final EntityType<ModEntities> SHOCKWAVE = Registry.register

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return EntityDimensions.fixed(5.0F, 0.1F); // 5 blocks wide, very flat
    }


    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        this.setNoGravity(true);
        this.setBoundingBox(this.getDimensions(EntityPose.STANDING).getBoxAt(this.getPos())); // Updates the hitbox
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

    public static void initialize() {
    }
}
