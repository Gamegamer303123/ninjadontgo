package net.gamegamer.ninjago.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.gamegamer.ninjago.Ninjadontgo;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {


    public static final EntityType<FireWave> FIREWAVE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Ninjadontgo.MOD_ID, "firewave"),
            EntityType.Builder.create(FireWave::new, SpawnGroup.MISC)
                    .dimensions(5.0f, 0.001f)
                    .build()
    );


    public static final EntityType<SpinjitzuEntity> SPINJITZU_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Ninjadontgo.MOD_ID, "spinjitzu"),
            EntityType.Builder.create(SpinjitzuEntity::new, SpawnGroup.MISC)
                    .dimensions(0.6f, 1.8f) // size same as player
                    .build()
    );


 /*   public static final EntityType<FireWave> FIREWAVE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Ninjadontgo.MOD_ID, "firewave"),
            EntityType.Builder.create(FireWave::new, SpawnGroup.MISC)
                    .dimensions(5.0f, 0.1f)
                    .build()
    );




   public static final EntityType<FireWave> FIREWAVE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Ninjadontgo.MOD_ID, "firewave"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireWave::new)
                    .dimensions(EntityDimensions.fixed(5.0F, 0.0001F))
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(),
                            Identifier.of(Ninjadontgo.MOD_ID, "firewave"))));

    public static final EntityType<FireWave> FIREWAVE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Ninjadontgo.MOD_ID, "firewave"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireWave::new)
                    .dimensions(EntityDimensions.fixed(5.0F, 0.1F))
                    .build());

    */


    //Cannot resolve method 'register(DefaultedRegistry<EntityType<?>>, Identifier, FabricEntityTypeBuilder<T>)'
    //public static final EntityType<ModEntities> SHOCKWAVE = Registry.register

    public static void initialize() {
    }
}

