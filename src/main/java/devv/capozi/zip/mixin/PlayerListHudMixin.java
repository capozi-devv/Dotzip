package devv.capozi.zip.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import devv.capozi.zip.Dotzip;
import devv.capozi.zip.common.util.TextsUtils;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = PlayerListHud.class, priority = Integer.MAX_VALUE)
public class PlayerListHudMixin {
   @ModifyReturnValue(method = "applyGameModeFormatting", at = @At("RETURN"))
   private Text dotzip$applyCustomNameColours(Text original, PlayerListEntry entry) {
       if (Dotzip.friendUUIDs.contains(entry.getProfile().getId())) {
          return Text.literal(original.getString()).styled(new TextsUtils().colorHex("#43819c"));
       }
       if (Dotzip.contributer_uuids.contains(entry.getProfile().getId())) {
           return Text.literal(original.getString()).styled(new TextsUtils().colorHex("#dead45"));
       }
       if (Dotzip.capozi_uuid.contains(entry.getProfile().getId())) {
           return Text.literal("capozi.devv").styled(new TextsUtils().colorHex("#ff005a"));
       }
       return original;
   }
}
