package com.conaitus.conanstuff;

import com.conaitus.conanstuff.block.ModBlocks;
import com.conaitus.conanstuff.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConanStuff implements ModInitializer {
	public static final String MOD_ID = "conanstuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Welcome To Mods!");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}