package me.daniel.marvelousmod.item;

import me.daniel.marvelousmod.MarvelousMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "pink_garnet"))));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "raw_pink_garnet"))));

    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        MarvelousMod.LOGGER.info("Registering Mod Items for " + MarvelousMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
