package devv.capozi.zip.common.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LootTableUtils extends FabricBlockLootTableProvider {
    protected LootTableUtils(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {

    }

    public void singleBlockLootTableFromList(List<Block> blocks) {
        for(Block block : blocks) {
            if (block instanceof SlabBlock) {
                addDrop(block, slabDrops(block));
            } else if (block instanceof DoorBlock) {
                addDrop(block, doorDrops(block));
            } else {
                addDrop(block);
            }
        }
    }
}
