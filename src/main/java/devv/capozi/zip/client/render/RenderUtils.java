package devv.capozi.zip.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

public class RenderUtils {
    public void mapBlockToRenderLayer(Block mappedBlock, BlockRenderLayer layer) {
        BlockRenderLayerMap.putBlock(mappedBlock, layer);
    }
    public void mapBlockListToRenderLayer(List<Block> mappedBlocks, BlockRenderLayer layer) {
        for (Block block : mappedBlocks) {
            BlockRenderLayerMap.putBlock(block, layer);
        }
    }
}
