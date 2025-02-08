package net.gamegamer.ninjago.particles;

import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.gamegamer.ninjago.Ninjadontgo;

public class ModParticles {
    public static final SimpleParticleType FIREWAVE_PARTICLE = register("firewave_particle", false);

    private static SimpleParticleType register(String name, boolean alwaysShow) {
        // Use the built-in factory method for SimpleParticleType
        return Registry.register(Registries.PARTICLE_TYPE,
                Identifier.of(Ninjadontgo.MOD_ID, name),
                new SimpleParticleType(alwaysShow) {} // Anonymous subclass to access protected constructor
        );
    }

    public static void registerParticles() {
        // This method is called during mod initialization to register the particles.
    }
}