package devv.capozi.zip;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

import java.util.UUID;

public class DotzipClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UUID clientUUID = MinecraftClient.getInstance().getSession().getProfile().getId();
//        for (UUID uuid : Dotzip.bannedUUIDS) {
//            if (uuid == clientUUID) {
//                MinecraftClient.getInstance().stop();
//            }
//        }
    }
}
