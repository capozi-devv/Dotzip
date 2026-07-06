package devv.capozi.zip.registry;

import com.mojang.brigadier.arguments.StringArgumentType;
import devv.capozi.zip.common.api.DataConstants;
import devv.capozi.zip.common.api.PersistentDataSaver;
import devv.capozi.zip.common.api.util.ColorUtils;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.UUID;
import java.util.function.Predicate;

import static net.minecraft.server.command.CommandManager.*;

public interface CommandInit {
    Predicate<ServerCommandSource> uuidPredicate = serverCommandSource -> {
        if (serverCommandSource.getEntity() instanceof PlayerEntity player) {
            UUID uuid = player.getUuid();
            if (DataConstants.friendUUIDs.contains(uuid)) return true;
            if (DataConstants.capozi_uuid.contains(uuid)) return true;
        }
        return false;
    };
    static void init() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("name_color").requires(uuidPredicate)
                    .then(argument("hex_value", StringArgumentType.greedyString())
                            .executes(context -> {
                                if (context.getSource().getEntity() instanceof PlayerEntity player) {
                                    String hex = StringArgumentType.getString(context, "hex_value");
                                    if (ColorUtils.hexValidator(hex)) {
                                        PersistentDataSaver.setHex((PersistentDataSaver)player, hex);
                                        DataConstants.playerColors.put(player.getGameProfile(), hex);
                                        System.out.println(player.getDisplayName().getString() + " -> " + hex);
                                        player.sendMessage(Text.literal("Name colour changed successfully!").formatted(Formatting.DARK_GREEN), false);
                                        return 1;
                                    } else {
                                        player.sendMessage(Text.literal("Invalid hex code provided").formatted(Formatting.RED), false);
                                        return 0;
                                    }
                                }
                                return 0;
                            })
                    )
            );
        });
    }
}
