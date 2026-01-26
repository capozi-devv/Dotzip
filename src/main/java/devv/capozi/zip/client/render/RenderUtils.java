package devv.capozi.zip.client.render;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

public class RenderUtils {
    public void mapBlockToRenderLayer(Block mappedBlock, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(mappedBlock, layer);
    }
    public void mapBlockListToRenderLayer(List<Block> mappedBlocks, RenderLayer layer) {
        for (Block block : mappedBlocks) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
        }
    }
}
