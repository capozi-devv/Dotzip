package devv.capozi.zip;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

import java.util.UUID;

public class DotzipClient implements ClientModInitializer {
    private UUID clientUUID = MinecraftClient.getInstance().player.getUuid();
    @Override
    public void onInitializeClient() {
        for (UUID uuid : Dotzip.bannedUUIDS) {
            if (uuid == clientUUID) {
                MinecraftClient.getInstance().stop();
            }
        }
    }
}
