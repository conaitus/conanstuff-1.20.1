package com.conaitus.conanstuff.item;

import com.conaitus.conanstuff.ConanStuff;
import com.conaitus.conanstuff.item.custom.IronDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item IRON_DETECTOR = registerItem("iron_detector", new IronDetectorItem(new FabricItemSettings().maxDamage(350)));

    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(IRON_DETECTOR);
    }


    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ConanStuff.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ConanStuff.LOGGER.info("Registering Mod Items for " + ConanStuff.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabItemGroup);
    }
}
