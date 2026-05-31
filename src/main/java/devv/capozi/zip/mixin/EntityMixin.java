package devv.capozi.zip.mixin;

import devv.capozi.zip.common.api.PersistentDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements PersistentDataSaver {
    private NbtCompound persistentData;
    @Override
    public NbtCompound getPersistent() {
        if (this.persistentData == null) {
            persistentData = new NbtCompound();
        }
        return persistentData;
    }
    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> info) {
        if(persistentData != null) {
            nbt.put("dotzip.player_name_hex", persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("dotzip.player_name_hex", 10)) {
            persistentData = nbt.getCompound("dotzip.player_name_hex");
        }
    }
}
