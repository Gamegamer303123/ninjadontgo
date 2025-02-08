package net.gamegamer.ninjago;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.ModEntities;
import net.gamegamer.ninjago.item.ModItems;
import net.gamegamer.ninjago.particles.ModParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.gamegamer.ninjago.entities.ModEntities.FIREWAVE;

public class Ninjadontgo implements ModInitializer {
	public static final String MOD_ID = "ninjadontgo";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		FabricDefaultAttributeRegistry.register(FIREWAVE, FireWave.createMobAttributes());
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModEntities.initialize();
		ModParticles.registerParticles();
	}
}