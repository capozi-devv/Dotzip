package devv.capozi.zip;

import com.mojang.authlib.GameProfile;
import devv.capozi.zip.common.block.PlushBlock;
import devv.capozi.zip.registry.CommandInit;
import devv.capozi.zip.common.api.index.Registrar;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public static final Block CAPOZI_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID, "capozi_plush"), new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block EYA_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID,"eya_plush"), new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block COSMO_PLUSH = blockRegistrar.add(Identifier.of(MOD_ID,"cosmo_plush"), new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Item CAPOZI_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"capozi_plush"), new BlockItem(CAPOZI_PLUSH, new Item.Settings()));
    public static final Item COSMO_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"cosmo_plush"), new BlockItem(COSMO_PLUSH, new Item.Settings()));
    public static final Item EYA_PLUSH_ITEM = blockItemRegistrar.add(Identifier.of(MOD_ID,"eya_plush"), new BlockItem(EYA_PLUSH, new Item.Settings()));
}