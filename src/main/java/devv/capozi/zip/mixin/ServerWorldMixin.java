package devv.capozi.zip.mixin;

import devv.capozi.zip.common.api.DataConstants;
import devv.capozi.zip.common.api.PersistentDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
    @Shadow
    public abstract List<ServerPlayerEntity> getPlayers();
    @Inject(method = "tick", at = @At("TAIL"))
    private void dotzip$ServerWorld(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        for (PlayerEntity player : getPlayers()) {
            PersistentDataSaver data = (PersistentDataSaver)player;
            DataConstants.playerColors.putIfAbsent(player.getGameProfile(), data.getPersistent().getString("hex_code").orElse(""));
        }
    }
}
