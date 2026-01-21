package devv.capozi.zip.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import devv.capozi.zip.Dotzip;
import devv.capozi.zip.common.util.TextsUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow
    public abstract Text getDisplayName();
    private Text capozi_devv = Text.literal("capozi_devv");
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    @ModifyReturnValue(method = "getDisplayName", at = @At("RETURN"))
    private Text dotzip$getDisplayName(Text original) {
        if (Dotzip.capozi_uuid.contains(this.getUuid())){
            return Text.literal("capozi.devv").styled(new TextsUtils().colorHex("#ff005a"));
        }
        if (Dotzip.friendUUIDs.contains(this.getUuid())) {
            return Text.literal(original.getString()).styled(new TextsUtils().colorHex("#03fcfc"));
        }
        return original;
    }
}
