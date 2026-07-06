package devv.capozi.zip;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class DotzipClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(Dotzip.CAPOZI_PLUSH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(Dotzip.EYA_PLUSH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(Dotzip.COSMO_PLUSH, BlockRenderLayer.CUTOUT);
    }
}
