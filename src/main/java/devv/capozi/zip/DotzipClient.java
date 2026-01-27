package devv.capozi.zip;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;

import java.util.UUID;

public class DotzipClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UUID clientUUID = MinecraftClient.getInstance().getSession().getProfile().getId();
        for (UUID uuid : Dotzip.bannedUUIDS) {
            if (uuid == clientUUID) {
                MinecraftClient.getInstance().stop();
            }
        }
        BlockRenderLayerMap.INSTANCE.putBlock(Dotzip.CAPOZI_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Dotzip.EYA_PLUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Dotzip.COSMO_PLUSH, RenderLayer.getCutout());
    }
}
