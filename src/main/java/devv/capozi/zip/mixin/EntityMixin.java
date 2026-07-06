package devv.capozi.zip.mixin;

import com.mojang.serialization.Codec;
import devv.capozi.zip.common.api.PersistentDataSaver;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Style;
import net.minecraft.util.dynamic.Codecs;
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
    @Inject(method = "writeData", at = @At("HEAD"))
    protected void injectWriteMethod(WriteView view, CallbackInfo ci) {
        if(persistentData != null) {
            view.put("dotzip.player_name_hex", NbtCompound.CODEC, persistentData);
        }
    }
    @Inject(method = "readData", at = @At("HEAD"))
    protected void injectReadMethod(ReadView view, CallbackInfo ci) {
        if (this.persistentData != null) {
            if (view.contains("dotzip.player_name_hex")) {
                
            }
        }
    }
}
