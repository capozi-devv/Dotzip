package devv.capozi.zip.mixin;

import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(ChatHud.class)
public class ChatHudMixin {
    @Inject()
}
