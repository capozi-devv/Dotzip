package devv.capozi.zip.common.api;

import net.minecraft.nbt.NbtCompound;

public interface PersistentDataSaver {
    NbtCompound getPersistent();
    static String setHex(PersistentDataSaver player, String hex) {
        NbtCompound nbt = player.getPersistent();
        nbt.putString("hex_code", hex);
        return hex;
    }
}
