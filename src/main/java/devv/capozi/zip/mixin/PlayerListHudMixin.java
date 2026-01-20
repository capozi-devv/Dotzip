package devv.capozi.zip.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import devv.capozi.zip.Dotzip;
import devv.capozi.zip.common.util.TextsUtils;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {
   @ModifyReturnValue(method = "applyGameModeFormatting", at = @At("RETURN"))
   private Text dotzip$applyCustomNameColours(Text original, PlayerListEntry entry) {
       if (Dotzip.friendUUIDs.contains(entry.getProfile().getId())) {
          return Text.literal(original.getString()).styled(new TextsUtils().colorHex("#03fcfc"));
       }
       if (entry.getProfile().getId() == Dotzip.capozi_uuid) {
           return Text.literal(original.getString()).styled(new TextsUtils().colorHex("#ff005a"));
       }
       return original;
   }
}
