package net.gamegamer.ninjago;

import net.fabricmc.api.ModInitializer;



import net.gamegamer.ninjago.entities.ModEntityTypes;
import net.gamegamer.ninjago.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ninjadontgo implements ModInitializer {
	public static final String MOD_ID = "ninjadontgo";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		ModEntityTypes.initialize();
	}
}