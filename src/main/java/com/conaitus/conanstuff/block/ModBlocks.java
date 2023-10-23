package com.conaitus.conanstuff.block;

import com.conaitus.conanstuff.ConanStuff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER).requiresTool()));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.NETHER_GOLD_ORE).requiresTool(), UniformIntProvider.create(1, 6)));
    public static final Block XP_ORE = registerBlock("xp_ore",
            new ExperienceDroppingBlock(AbstractBlock.Settings.create().luminance(value -> 2).strength(2.2f, 4.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool(), UniformIntProvider.create(12, 18)));


    private static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY_BLOCK);
        entries.add(RUBY_ORE);
        entries.add(XP_ORE);
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ConanStuff.MOD_ID, name), block);

    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(ConanStuff.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        ConanStuff.LOGGER.info("Registering Mod Blocks for " + ConanStuff.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModBlocks::addItemsToIngredientsTabItemGroup);
    }
}
