package net.gamegamer.ninjago.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gamegamer.ninjago.Ninjadontgo;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ModItems {
    public static final Item EMPTY_SCROLL = registerItem("empty_scroll",
            new Scrolls("empty", new Item.Settings().maxCount(1)));

    private static final Map<String, Item> POWER_SCROLLS = new HashMap<>();

    static {
        registerPowerScroll("fire");
        registerPowerScroll("ice");
        registerPowerScroll("lightning");
        // Add more powers here
    }

    private static void registerPowerScroll(String power) {
        POWER_SCROLLS.put(power, registerItem(power + "_scroll",
                new Scrolls(power, new Item.Settings().maxCount(1))));
    }

    public static Item getPowerScroll(String power) {
        return POWER_SCROLLS.getOrDefault(power, EMPTY_SCROLL);
    }

    public static final Item SWORD_OF_FIRE = registerItem("sword_of_fire",
            new FireSword(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Ninjadontgo.MOD_ID, name), item);


    }

    public static void registerModItems() {
        Ninjadontgo.LOGGER.info("Registering Mod Items for " + Ninjadontgo.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }


}










/*
public final class ModItems {
    private ModItems() {
    }

   // public static final RegistryKey<Item> SWORD_OF_FIRE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Ninjadontgo.MOD_ID, "sword_of_fire"));

    public static final Item CUSTOM_ITEM = register("custom_item", CustomItem::new, new Item.Settings());

    //public static final Item SWORD_OF_FIRE = register(new SwordItem(ToolMaterial.NETHERITE, 8f, 1.6f, new Item.Settings().registryKey(SWORD_OF_FIRE_KEY)));

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("ninjago", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
    }
}





import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gamegamer.ninjago.Ninjadontgo;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.gamegamer.ninjago.item.FireSword;
import net.gamegamer.ninjago.item.CustomItem;

import java.util.function.Function;

public class ModItems {





    private static Item registerItem(String Name, Function<Item.Settings, Item> factory,  Item.Settings settings) {
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Ninjadontgo.MOD_ID, Name));
        return Items.register(registerKey, factory, settings);
    }



    //public static final Item SWORD_OF_FIRE = registerItem("sword_of_fire", Item::new, new Item.Settings());

   // public static final Item SWORD_OF_FIRE = registerItem("sword_of_fire", Item::new, new FireSword(ToolMaterial.NETHERITE, 8, 1.6, new Item.Settings()));

    // public static final FireSword SWORD_OF_FIRE = registerItem("sword_of_fire", FireSword::new, new Item.Settings());

    public static final CustomItem CUSTOM_ITEM = registerItem("custom_item", CustomItem::new, new Item.Settings());

    public static void RegisterModItems() {
        Ninjadontgo.LOGGER.info("Registering Mod Items for" + Ninjadontgo.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            // entries.add(SWORD_OF_FIRE);

        } );
    }

}
*/