package devv.capozi.zip;

import devv.capozi.zip.common.block.PlushBlock;
import devv.capozi.zip.common.api.index.Registrar;
import devv.capozi.zip.registry.CommandInit;
import devv.capozi.zip.server.worldgen.ExpandedJigsawStructure;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

import java.util.List;
import java.util.UUID;

public class Dotzip implements ModInitializer {
    public static final String MOD_ID = "dotzip";
    public static final StructureType<ExpandedJigsawStructure> EXPANDED_JIGSAW = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(MOD_ID, "expanded_jigsaw"), () -> ExpandedJigsawStructure.CODEC);
    public static Registrar<Block> blockRegistrar = new Registrar<Block>(((identifier, item) -> Registry.register(Registries.BLOCK, identifier, item)));
    public static Registrar<Item> blockItemRegistrar = new Registrar<Item>(((identifier, item) -> Registry.register(Registries.ITEM, identifier, item)));
    @Override
    public void onInitialize() {
        CommandInit.init();
        blockRegistrar.setRegistries(blockRegistrar.entries, blockRegistrar.registry_consumer);
        blockItemRegistrar.setRegistries(blockItemRegistrar.entries, blockItemRegistrar.registry_consumer);
    }
    public static final Block CAPOZI_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID, "capozi_plush"), new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block EYA_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID,"eya_plush"), new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block COSMO_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID,"cosmo_plush"), new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Item CAPOZI_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"capozi_plush"), new BlockItem(CAPOZI_PLUSH, new Item.Settings()));
    public static final Item COSMO_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"cosmo_plush"), new BlockItem(COSMO_PLUSH, new Item.Settings()));
    public static final Item EYA_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"eya_plush"), new BlockItem(EYA_PLUSH, new Item.Settings()));
}