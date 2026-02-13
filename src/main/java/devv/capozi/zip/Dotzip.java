package devv.capozi.zip;

import devv.capozi.zip.common.block.PlushBlock;
import devv.capozi.zip.server.worldgen.ExpandedJigsawStructure;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }
    private static Item registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    @Override
    public void onInitialize() {

    }
    public static final Block CAPOZI_PLUSH = registerBlock("capozi_plush", new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block EYA_PLUSH = registerBlock("eya_plush", new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block COSMO_PLUSH = registerBlock("cosmo_plush",new PlushBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque()));
    public static final List<UUID> capozi_uuid = List.of(UUID.fromString("e8d6e412-351a-4165-adc3-d46db2a9e561"));
    public static final List<UUID> contributer_uuids = List.of(
            UUID.fromString("9a5abccf-5013-423d-b137-453b13f07cab"), // everest
            UUID.fromString("87d00b3c-4486-463d-ad9c-f8baed3fec71"), // eyalego
            UUID.fromString("9da4f059-fb15-4b34-a2e5-54cfecf7c22e"), // Kindling
            UUID.fromString("c7ef1f45-bc5a-4b59-9434-62e6d1fb4770")); // cosmo
    public static final List<UUID> friendUUIDs = List.of(
            UUID.fromString("39be881e-40d8-4afb-8458-12f4fc07c846"), // Hexader
            UUID.fromString("9aca6601-6414-4387-86ff-e4def7f5cebd"), // Arctic
            UUID.fromString("7700b3f5-0241-47a0-9df1-887254ef247b"), // RedJava
            UUID.fromString("ae445ba6-77ad-47fb-b1db-e582e46d2788"), // rustic
            UUID.fromString("1a3df47b-c05d-46fd-979b-77a6acbfd9e1"), // smipner
            UUID.fromString("14a34d5c-9840-43c1-8174-251ce81d6eea"), // unknown
            UUID.fromString("b98321a1-933b-4517-98ac-d5b70c8966f2"), // moth
            UUID.fromString("f34e93a7-f7eb-4128-bd50-e8cd23b3cee6"), // Sue
            UUID.fromString("ec23b8cd-fb66-4d9b-83b9-d748c0b05e6e"), // yuuki
            UUID.fromString("7a4a8f5e-acd5-41d7-9e3d-998bfd623c3d"), // Lazy
            UUID.fromString("0ec5dee7-d32a-44db-9b9d-c03b05459c65"), // Chaos
            UUID.fromString("bf5000b2-652c-45a7-9601-0412cb9fe222"), // Bon
            UUID.fromString("dc9bd9f4-ef4d-4059-b21c-fd4823f69ae1"), // Boxed
            UUID.fromString("97808c20-2d4d-45d3-9f89-a0cc1e7a20a7"), // Hishadi
            UUID.fromString("b73f3a2d-de3c-4d06-8c15-c71c298ab48d"), // Snapy
            UUID.fromString("8dbebb74-01dd-4f62-b61d-09e1f6126e58"), // Watt
            UUID.fromString("739a71eb-d38c-409c-933a-b43660958c3c"), // Nico
            UUID.fromString("9db34e33-105d-4412-8ac0-2316b7ad4ef1"), // origin
            UUID.fromString("a26e29f1-532e-4116-9112-ca18ea30d27f"), // chem
            UUID.fromString("5fc814d8-e485-4977-be1f-e1bb028c1929"), // farzad
            UUID.fromString("4de70f2f-8535-474c-ac9a-0a9f8eb82f8a")); // Spooks
}