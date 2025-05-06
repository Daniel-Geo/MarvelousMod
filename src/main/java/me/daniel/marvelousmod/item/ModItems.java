package me.daniel.marvelousmod.item;

import me.daniel.marvelousmod.MarvelousMod;
import me.daniel.marvelousmod.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "pink_garnet")))));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "raw_pink_garnet")))));
    public static final Item SUSPICIOUS_SUBSTANCE = registerItem("suspicious_substance", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "suspicious_substance")))));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "chisel"))).maxDamage(32)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "cauliflower")))
            .food(ModFoodComponents.CAULIFLOWER, ModFoodComponents.CAULIFLOWER_EFFECT)));
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelousMod.MOD_ID, "starlight_ashes")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MarvelousMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MarvelousMod.LOGGER.info("Registering Mod Items for " + MarvelousMod.MOD_ID);
    }
}
