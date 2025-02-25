package net.gamegamer.ninjago;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.ModEntities;
import net.gamegamer.ninjago.item.ModItems;
import net.gamegamer.ninjago.particles.ModParticles;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.gamegamer.ninjago.entities.ModEntities.FIREWAVE;

public class Ninjadontgo implements ModInitializer {
	public static final String MOD_ID = "ninjadontgo";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final SimpleParticleType FIREWAVEPARTICLE = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			PowerManager.loadPowers(server.getSavePath(WorldSavePath.ROOT));
		});

		ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
			PowerManager.savePowers(server.getSavePath(WorldSavePath.ROOT));
		});

		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "fire_wave_particle"), FIREWAVEPARTICLE);




		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModEntities.initialize();
		ModParticles.registerParticles();
	}
}