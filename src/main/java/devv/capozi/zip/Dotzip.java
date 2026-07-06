package devv.capozi.zip;

import devv.capozi.zip.common.block.PlushBlock;
import devv.capozi.zip.registry.CommandInit;
import devv.capozi.zip.common.api.index.Registrar;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public @SuppressWarnings("all") class Dotzip implements ModInitializer {
    public static final String MOD_ID = "dotzip";
    public static Registrar<Block> blockRegistrar = new Registrar<Block>((id, t) -> Registry.register(Registries.BLOCK, id, t));
    public static Registrar<Item> blockItemRegistrar = new Registrar<Item>((id, t) -> Registry.register(Registries.ITEM, id, t));
    @Override
    public void onInitialize() {
        blockRegistrar.setRegistries(blockRegistrar.entries, blockRegistrar.registry_consumer);
        blockItemRegistrar.setRegistries(blockItemRegistrar.entries, blockItemRegistrar.registry_consumer);
        CommandInit.init();
    }
    public static final Block CAPOZI_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID, "capozi_plush"), new PlushBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(MOD_ID, "capozi_plush"))).nonOpaque()));
    public static final Block EYA_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID,"eya_plush"), new PlushBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(MOD_ID, "eya_plush"))).nonOpaque()));
    public static final Block COSMO_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID,"cosmo_plush"), new PlushBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(MOD_ID, "cosmo_plush"))).nonOpaque()));
    public static final Item CAPOZI_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"capozi_plush"), new BlockItem(CAPOZI_PLUSH, new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID,"capozi_plush")))));
    public static final Item COSMO_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"cosmo_plush"), new BlockItem(COSMO_PLUSH, new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID,"cosmo_plush")))));
    public static final Item EYA_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"eya_plush"), new BlockItem(EYA_PLUSH, new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID,"eya_plush")))));
}