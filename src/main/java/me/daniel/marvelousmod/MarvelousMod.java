package me.daniel.marvelousmod;

import me.daniel.marvelousmod.block.ModBlocks;
import me.daniel.marvelousmod.item.ModItemGroups;
import me.daniel.marvelousmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarvelousMod implements ModInitializer {
    public static final String MOD_ID = "marvelousmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
    }
}