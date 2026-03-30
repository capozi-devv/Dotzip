package devv.capozi.zip.common.index;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public @SuppressWarnings("all") class RegistryUtils {
    protected static Block block(String mod_id, String name, Block block, boolean registerBlockItem) {
        if (registerBlockItem) {
            blockItem(mod_id, name, block);
        }
        return Registry.register(Registries.BLOCK, Identifier.of(mod_id, name), block);
    }
    protected static Item blockItem(String mod_id, String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(mod_id, name), new BlockItem(block, new Item.Settings()));
    }
    protected static RegistryKey<DamageType> damageType(String mod_id, String path) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(mod_id, path));
    }
    protected static RegistryEntry<StatusEffect> statusEffect(String mod_id, String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(mod_id, name),statusEffect);
    }
    protected static Item item(String mod_id, String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(mod_id, name), item);
    }
    protected static SoundEvent soundEvent(String mod_id, String name) {
        Identifier id = Identifier.of(mod_id, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
