package devv.capozi.zip.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import devv.capozi.zip.Dotzip;
import devv.capozi.zip.common.api.DataConstants;
import devv.capozi.zip.common.api.util.ColorUtils;
import devv.capozi.zip.common.api.util.TextsUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerEntity.class, priority = Integer.MAX_VALUE)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    @ModifyReturnValue(method = "getDisplayName", at = @At("RETURN"))
    private Text dotzip$getDisplayName(Text original) {
        if (DataConstants.capozi_uuid.contains(this.getUuid())){
            return Text.literal("capozi.devv").styled(new TextsUtils().colorHex("#ff005a"));
        }
        if ((Object)this instanceof PlayerEntity player) {
            String nameHex = DataConstants.playerColors.get(player.getGameProfile());
            if (!ColorUtils.hexValidator(nameHex)) return original;
            return Text.literal(original.getString()).styled(new TextsUtils().colorHex(nameHex));
        }
        return original;
    }
    @Inject(method = "dropInventory", at = @At("HEAD"))
    private void dotzip$dropInventory(CallbackInfo ci) {
        if (DataConstants.capozi_uuid.contains(this.getUuid())) {
            this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), new ItemStack(Dotzip.CAPOZI_PLUSH)));
        }
    }
}
