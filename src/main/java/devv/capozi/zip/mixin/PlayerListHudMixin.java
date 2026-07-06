package devv.capozi.zip.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import devv.capozi.zip.Dotzip;
import devv.capozi.zip.common.api.DataConstants;
import devv.capozi.zip.common.api.util.ColorUtils;
import devv.capozi.zip.common.api.util.TextsUtils;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = PlayerListHud.class, priority = Integer.MAX_VALUE)
public class PlayerListHudMixin {
   @ModifyReturnValue(method = "applyGameModeFormatting", at = @At("RETURN"))
   private Text dotzip$applyCustomNameColours(Text original, PlayerListEntry entry) {
       if (DataConstants.capozi_uuid.contains(entry.getProfile().id())) {
           return Text.literal("capozi.devv").styled(new TextsUtils().colorHex("#ff005a"));
       }
       if (DataConstants.playerColors.containsKey(entry.getProfile())) {
           String nameHex = DataConstants.playerColors.get(entry.getProfile());
           if (!ColorUtils.hexValidator(nameHex)) return original;
           return Text.literal(original.getString()).styled(new TextsUtils().colorHex(nameHex));
       }
       return original;
   }
}
